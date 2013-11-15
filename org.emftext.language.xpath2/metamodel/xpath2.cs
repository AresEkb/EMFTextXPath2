SYNTAXDEF xpath2
FOR <http://www.emftext.org/language/xpath2>
START Expr

OPTIONS {
    reloadGeneratorModel = "true";
    generateCodeFromGeneratorModel = "true";
    usePredefinedTokens = "false";
    disableTokenSorting = "true";
}

TOKENS {
    PRIORITIZE INTEGER_LITERAL;
    PRIORITIZE DECIMAL_LITERAL;
    PRIORITIZE DOUBLE_LITERAL;
//    PRIORITIZE COMMENT_CONTENTS;
    PRIORITIZE NCNAME;

    DEFINE FRAGMENT DIGITS $('0'..'9')+$; 
    DEFINE FRAGMENT ESCAPE_QUOT $'\"\"'$;
    DEFINE FRAGMENT ESCAPE_APOS $'\'\''$;
    // TODO: '\u10000'..'\u10FFFF' is not supported
    DEFINE FRAGMENT CHAR $'\u0009'|'\u000A'|'\u000D'|'\u0020'..'\uD7FF'|'\uE000'..'\uFFFD'$;
    DEFINE INTEGER_LITERAL DIGITS;
    DEFINE DECIMAL_LITERAL $('.'$ + DIGITS + $)|($ + DIGITS + $'.'('0'..'9')*)$; 
    DEFINE DOUBLE_LITERAL $('.'$ + DIGITS + $)|($ + DIGITS + $('.'('0'..'9')*)?)('e'|'E')('+'|'-')?$ + DIGITS;
    DEFINE STRING_LITERAL $('\"')($ + ESCAPE_QUOT + $|~('\"'))*('\"')|('\'')($ + ESCAPE_APOS + $|~('\''))*('\'')$;  

//    DEFINE FRAGMENT NAME_START_CHAR $':'|'A'..'Z'|'_'|'a'..'z'|'\u00C0'..'\u00D6'|'\u00D8'..'\u00F6'|'\u00F8'..'\u02FF'|'\u0370'..'\u037D'|'\u037F'..'\u1FFF'|'\u200C'..'\u200D'|'\u2070'..'\u218F'|'\u2C00'..'\u2FEF'|'\u3001'..'\uD7FF'|'\uF900'..'\uFDCF'|'\uFDF0'..'\uFFFD'|'\u10000'..'\uEFFFF'$;
//    DEFINE FRAGMENT NAME_CHAR NAME_START_CHAR + $|'-'|'.'|'0'..'9'|'\u00B7'|'\u0300'..'\u036F'|'\u203F'..'\u2040'$;
//    DEFINE NAME $($ + NAME_START_CHAR + $)($ + NAME_CHAR + $)*$;
    // TODO: Should be Name - (Char* ':' Char*)	/* An XML Name, minus the ":" */
    // TODO: '\u10000'..'\uEFFFF' is not supported
    DEFINE FRAGMENT NCNAME_START_CHAR $'A'..'Z'|'_'|'a'..'z'|'\u00C0'..'\u00D6'|'\u00D8'..'\u00F6'|'\u00F8'..'\u02FF'|'\u0370'..'\u037D'|'\u037F'..'\u1FFF'|'\u200C'..'\u200D'|'\u2070'..'\u218F'|'\u2C00'..'\u2FEF'|'\u3001'..'\uD7FF'|'\uF900'..'\uFDCF'|'\uFDF0'..'\uFFFD'$;
    DEFINE FRAGMENT NCNAME_CHAR NCNAME_START_CHAR + $|'-'|'.'|'0'..'9'|'\u00B7'|'\u0300'..'\u036F'|'\u203F'..'\u2040'$;
    // TODO: It's very strange but it doesn't match single-character names
    DEFINE NCNAME $($ + NCNAME_START_CHAR + $)($ + NCNAME_CHAR + $)*$;

    // TODO: Should be (Char+ - (Char* ('(:' | ':)') Char*))
//    DEFINE COMMENT_CONTENTS CHAR + $+$;

    @SuppressWarnings(unusedToken)
    DEFINE WHITESPACE $(' '|'\t'|'\f'|'\r'|'\n')+$;
}

TOKENSTYLES {
    "$" COLOR #DA0000;
    "INTEGER_LITERAL", "DECIMAL_LITERAL", "DOUBLE_LITERAL", "STRING_LITERAL" COLOR #2518B5;
    "NCNAME" COLOR #00802A;
//    "COMMENT_CONTENTS" COLOR #999999, ITALIC;
}

RULES {
    // The rule sets overlap. This is done on purpose, because rules are
    // ordered from general to specific one as in the original dictionary:
    // http://www.w3.org/TR/xpath20/#nt-bnf

    // There are a lot of type restrictions in the rules. Without them parser
    // will be too complex and won't generated.

    // TODO: Implement http://www.w3.org/TR/xpath20/#parse-note-leading-lone-slash
    // TODO: Sometimes model isn't fully updated in a outline window

    // Sequence Expressions, Comparison Expressions, Logical Expressions
    Expr ::= expr:IfExpr,ForExpr,QuantifiedExpr,OrExpr
        ("," expr:IfExpr,ForExpr,QuantifiedExpr,OrExpr)*;
    ForExpr ::= "for" iterator ("," iterator)* "return" return;
    QuantifiedExpr ::= quantifier[some : "some", every : "every"]
        iterator ("," iterator)*
        "satisfies" satisfies:IfExpr,ForExpr,QuantifiedExpr,OrExpr;
    Iterator ::= "$" varName "in" list:IfExpr,ForExpr,QuantifiedExpr,OrExpr;
    IfExpr ::= "if" "(" test:Expr,IfExpr,ForExpr,QuantifiedExpr,OrExpr ")"
        "then" then:IfExpr,ForExpr,QuantifiedExpr,OrExpr
        "else" else:IfExpr,ForExpr,QuantifiedExpr,OrExpr;
    OrExpr ::= operand:AndExpr ("or" operand:AndExpr)*;
    AndExpr ::= operand:ComparisonExpr ("and" operand:ComparisonExpr)*;
    ComparisonExpr ::= left:RangeExpr (operator right:RangeExpr)?;
    RangeExpr ::= from:AdditiveExpr ("to" to:AdditiveExpr)?;
    GeneralComp ::= operator[eq : "=", ne : "!=", lt : "<", le : "<=",
        gt : ">", ge : ">="];
    ValueComp ::= operator[eq : "eq", ne : "ne", lt : "lt", le : "le",
        gt : "gt", ge : "ge"];
    NodeComp ::= operator[is : "is", precedes : "<<", follows : ">>"];

    // Sequence Expressions, Arithmetic Expressions
    AdditiveExpr ::= operand:MultiplicativeExpr
        (operator[addition : "+", subtraction : "-"] operand:MultiplicativeExpr)*;
    MultiplicativeExpr ::= operand:UnionExpr
        (operator[multiplication : "*", div : "div", idiv : "idiv", mod : "mod"] operand:UnionExpr)*;
    UnionExpr ::= operand:IntersectExceptExpr
        (operation[union : "union", vertical_bar : "|"] operand:IntersectExceptExpr)*;
    IntersectExceptExpr ::= operand:InstanceofExpr
        (operator[intersect : "intersect", except : "except"] operand:InstanceofExpr)*;

    // Expressions on SequenceTypes
    InstanceofExpr ::= operand:TreatExpr ("instance" "of" type)?;
    TreatExpr ::= operand:CastableExpr ("treat" "as" type)?;
    CastableExpr ::= operand:CastExpr ("castable" "as" type)?;
    CastExpr ::= operand:UnaryExpr ("cast" "as" type)?;
    UnaryExpr ::= operator[plus : "+", minus : "-"]* operand:ValueExpr;

    // FunctionCall must have higher priority than PathExpr
    FunctionCall ::= name "(" (arg:IfExpr,ForExpr,QuantifiedExpr,OrExpr
        ("," arg:IfExpr,ForExpr,QuantifiedExpr,OrExpr)*)? ")";

    // Path Expressions
    PathExpr ::= step step:ChildStepExpr,DescOrSelfStepExpr*;
    ChildStepExpr ::= "/" step;
    DescOrSelfStepExpr ::= "//" step;
    RootStepExpr ::= "/";
    SelfStepExpr ::= step;
    AxisStep ::= step predicate*;
    GeneralForwardStep ::= axis[
        child : "child", descendant : "descendant", attribute : "attribute",
        self : "self", descendant_or_self : "descendant-or-self",
        following_sibling : "following-sibling", following : "following",
        namespace : "namespace"] "::" nodeTest;
    AbbrevForwardStep ::= kind[child : "", attribute : "@"] nodeTest;
    GeneralReverseStep ::= axis[parent : "parent", ancestor : "ancestor",
        preceding_sibling : "preceding-sibling", preceding : "preceding",
        ancestor_or_self : "ancestor-or-self"] "::" nodeTest;
    AbbrevReverseStep ::= kind[parent : ".."];
    NodeKindTest ::= test;
    QNameTest ::= name;
    AnyWildcard ::= "*";
    LocalNameWildcard ::= namespace[NCNAME] ":" "*";
    NamespaceWildcard ::= "*" ":" localName[NCNAME];
    FilterExpr ::= primaryExpr:PrimaryExpr predicate*;
    Predicate ::= "[" expr:Expr "]";

    // Primary Expressions
    VarRef ::= "$" varName; 
    VarName ::= (prefix[NCNAME] ":")? localPart[NCNAME];
    ParenthesizedExpr ::= "(" expr:Expr? ")";
    ContextItemExpr ::= ".";

    // Types
    SingleType ::= type optional["?" : ""];
    EmptySequenceType ::= "empty-sequence" "(" ")";
    ItemSequenceType ::= itemType occurrence[
        mandatory : "", optional : "?", star : "*", plus : "+"];
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
    WildcardElementTest ::= "element" "(" "*" ("," type typeIsOptional["?" : ""]?)? ")";
    NameElementTest ::= "element" "(" name ("," type typeIsOptional["?" : ""]?)? ")";
    SchemaElementTest ::= "schema-element" "(" name ")";

    // Literals
    IntegerLiteral ::= value[INTEGER_LITERAL];
    DecimalLiteral ::= value[DECIMAL_LITERAL];
    DoubleLiteral ::= value[DOUBLE_LITERAL];
    StringLiteral ::= value[STRING_LITERAL];
    // TODO: I don't understand where to place comments
    //Comment ::= "(:" (text[COMMENT_CONTENTS] | comment)* ":)";
    QName ::= (prefix[NCNAME] ":")? localPart[NCNAME];
}
