SYNTAXDEF xpath2
FOR <http://www.emftext.org/language/xpath2>
START Expr

OPTIONS {
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
	disableTokenSorting = "true";
}

TOKENS {
	PRIORITIZE INTEGER_LITERAL;
	PRIORITIZE DOUBLE_LITERAL;
	PRIORITIZE DECIMAL_LITERAL;
	PRIORITIZE COMMENT_CONTENTS;
	PRIORITIZE NCNAME;
	PRIORITIZE TEXT;

	DEFINE FRAGMENT DIGITS $('0'..'9')+$; 
	DEFINE INTEGER_LITERAL DIGITS;
	DEFINE DECIMAL_LITERAL $('.'$ + DIGITS + $)|($ + DIGITS + $'.'('0'..'9')*)$; 
	DEFINE DOUBLE_LITERAL $('.'$ + DIGITS + $)|($ + DIGITS + $('.'('0'..'9')*)?)('e'|'E')('+'|'-')?$ + DIGITS;
	DEFINE STRING_LITERAL $('\"')($ + ESCAPE_QUOT + $|~('\"'))*('\"')|('\'')($ + ESCAPE_APOS + $|~('\''))*('\'')$;  
	DEFINE FRAGMENT ESCAPE_QUOT $'\"\"'$;
	DEFINE FRAGMENT ESCAPE_APOS $'\'\''$;
	// TODO: '\u10000'..'\u10FFFF' is not supported
	DEFINE FRAGMENT CHAR $'\u0009'|'\u000A'|'\u000D'|'\u0020'..'\uD7FF'|'\uE000'..'\uFFFD'$;
	
	DEFINE FRAGMENT NAME_START_CHAR $':'|'A'..'Z'|'_'|'a'..'z'|'\u00C0'..'\u00D6'|'\u00D8'..'\u00F6'|'\u00F8'..'\u02FF'|'\u0370'..'\u037D'|'\u037F'..'\u1FFF'|'\u200C'..'\u200D'|'\u2070'..'\u218F'|'\u2C00'..'\u2FEF'|'\u3001'..'\uD7FF'|'\uF900'..'\uFDCF'|'\uFDF0'..'\uFFFD'|'\u10000'..'\uEFFFF'$;
	DEFINE FRAGMENT NAME_CHAR NAME_START_CHAR + $|'-'|'.'|'0'..'9'|'\u00B7'|'\u0300'..'\u036F'|'\u203F'..'\u2040'$;
	DEFINE FRAGMENT NAME $($ + NAME_START_CHAR + $)($ + NAME_CHAR + $)*$;
	// TODO: Should be Name - (Char* ':' Char*)	/* An XML Name, minus the ":" */
	// TODO: '\u10000'..'\uEFFFF' is not supported
	DEFINE FRAGMENT NCNAME_START_CHAR $'A'..'Z'|'_'|'a'..'z'|'\u00C0'..'\u00D6'|'\u00D8'..'\u00F6'|'\u00F8'..'\u02FF'|'\u0370'..'\u037D'|'\u037F'..'\u1FFF'|'\u200C'..'\u200D'|'\u2070'..'\u218F'|'\u2C00'..'\u2FEF'|'\u3001'..'\uD7FF'|'\uF900'..'\uFDCF'|'\uFDF0'..'\uFFFD'$;
	DEFINE FRAGMENT NCNAME_CHAR NCNAME_START_CHAR + $|'-'|'.'|'0'..'9'|'\u00B7'|'\u0300'..'\u036F'|'\u203F'..'\u2040'$;
	DEFINE NCNAME $($ + NCNAME_START_CHAR + $)($ + NCNAME_CHAR + $)*$;

	// TODO: Should be (Char+ - (Char* ('(:' | ':)') Char*))
	DEFINE COMMENT_CONTENTS CHAR + $+$;
}

RULES {
	Expr ::= ownedExprSingle ("," ownedExprSingle)*;
	ForExpr ::= ownedSimpleForClause "return" return;
	SimpleForClause ::= "for" iterator ("," iterator)*;
	Iterator ::= "$" varName "in" list;
	QuantifiedExpr ::= quantifier[some : "some", every : "every"] iterator ("," iterator)* "satisfies" satisfies;
	IfExpr ::= "if" "(" condition ")" "then" then "else" else;
	OrExpr ::= operand:AndExpr ("or" operand:AndExpr)*;
	AndExpr ::= operand:ComparisonExpr ("and" operand:ComparisonExpr)*;
	ComparisonExpr ::= left:RangeExpr (operator right:RangeExpr)?;
	RangeExpr ::= from:AdditiveExpr ("to" to:AdditiveExpr)?;
	AdditiveExpr ::= operand:MultiplicativeExpr (operator[addition : "+", subtraction : "-"] operand:MultiplicativeExpr)*;
	MultiplicativeExpr ::= operand:UnionExpr (operator[multiplication : "*", div : "div", idiv : "idiv", mod : "mod"] operand:UnionExpr)*;
	UnionExpr ::= operand:IntersectExceptExpr (operation[union : "union", vertical_bar : "|"] operand:IntersectExceptExpr)*;
	IntersectExceptExpr ::= operand:InstanceofExpr (operator[intersect : "intersect", except : "except"] operand:InstanceofExpr)*;
	InstanceofExpr ::= operand:TreatExpr ("instance" "of" type)?;
	TreatExpr ::= operand:CastableExpr ("treat" "as" type)?;
	CastableExpr ::= operand:CastExpr ("castable" "as" type)?;
	CastExpr ::= operand:UnaryExpr ("cast" "as" type)?;
	UnaryExpr ::= operator[plus : "+", minus : "-"]* operand:ValueExpr;
	GeneralComp ::= operator[eq : "=", ne : "!=", lt : "<", le : "<=", gt : ">", ge : ">="];
	ValueComp ::= operator[eq : "eq", ne : "ne", lt : "lt", le : "le", gt : "gt", ge : "ge"];
	NodeComp ::= operator[is : "is", precedes : "<<", follows : ">>"];
	SinglePathExpr ::= "/" relativePathExpr?;
	DoublePathExpr ::= "//" relativePathExpr;
	RelativePathExpr ::= head tail*;
	SingleTailPathExpr ::= "/" stepExpression;
	DoubleTailPathExpr ::= "//" stepExpression;
	AxisStep ::= step predicate*;
	GeneralForwardStep ::= axis nodeTest;
	AbbrevForwardStep ::= at["@" : ""] nodeTest;
	ForwardAxis ::= kind[
		child : "child", descendant : "descendant", attribute : "attribute",
		self : "self", descendant_or_self : "descendant-or-self",
		following_sibling : "following-sibling", following : "following", namespace : "namespace"] "::";
	GeneralReverseStep ::= axis nodeTest;
	AbbrevReverseStep ::= "..";
	ReverseAxis ::= kind[parent : "parent", ancestor : "ancestor",
		preceding_sibling : "preceding-sibling", preceding : "preceding",
		ancestor_or_self : "ancestor-or-self"] "::";
	NodeKindTest ::= test;
	QNameTest ::= name;
	AnyWildcard ::= "*";
	LocalNameWildcard ::= namespace[] ":" "*";
	NamespaceWildcard ::= "*" ":" localName[];
	FilterExpr ::= primaryExpr predicate*;
	Predicate ::= "[" expr "]";
	VarRef ::= "$" varName; 
	VarName ::= (prefix[NCNAME] ":")? localPart[NCNAME];
	ParenthesizedExpr ::= "(" expr:Expr? ")";
	ContextItemExpr ::= ".";
	FunctionCall ::= name "(" (arg ("," arg)*)? ")";
	SingleType ::= type optional["?" : ""];
	EmptySequenceType ::= "empty-sequence" "(" ")";
	ItemSequenceType ::= itemType occurrence[mandatory : "", optional : "?", star : "*", plus : "+"];
	ItemKindTest ::= test;
	AnyItemType ::= "item" "(" ")";
	AtomicItemType ::= type;
	AtomicType ::= name;
	AnyKindTest ::= "node" "(" ")";
	DocumentTest ::= "document-node" "(" (test:ElementTest,SchemaElementTest)? ")";
	TextTest ::= "text" "(" ")";
	CommentTest ::= "comment" "(" ")";
	PITest ::= "processing-instruction" "("  ")";
	NCNamePITest ::= "processing-instruction" "(" name[NCNAME] ")";
	StringLiteralPITest ::= "processing-instruction" "(" literal[STRING_LITERAL] ")";
	AttributeTest ::= "attribute" "("  ")";
	WildcardAttributeTest ::= "attribute" "(" "*" ("," type)? ")";
	NameAttributeTest ::= "attribute" "(" name ("," type)? ")";
	SchemaAttributeTest ::= "schema-attribute" "(" name ")";
	ElementTest ::= "element" "("  ")";
	WildcardElementTest ::= "element" "(" "*" ("," type typeIsOptional["?" : ""])? ")";
	NameElementTest ::= "element" "(" name ("," type typeIsOptional["?" : ""])? ")";
	SchemaElementTest ::= "schema-element" "(" name ")";

	IntegerLiteral ::= value[INTEGER_LITERAL];
	DecimalLiteral ::= value[DECIMAL_LITERAL];
	DoubleLiteral ::= value[DOUBLE_LITERAL];
	StringLiteral ::= value[STRING_LITERAL];
	// TODO: I don't understand where to place comments
	//Comment ::= "(:" (text[COMMENT_CONTENTS] | comment)* ":)";
	QName ::= (prefix[NCNAME] ":")? localPart[NCNAME];
}
