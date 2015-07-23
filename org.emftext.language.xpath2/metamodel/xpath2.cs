// Copyright (c) 2013, 2014 Denis Nikiforov.
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html
//
// Contributors:
//    Denis Nikiforov - initial API and implementation

SYNTAXDEF xpath2
FOR <http://www.emftext.org/language/xpath2>
START Expr

OPTIONS {
    reloadGeneratorModel = "true";
    generateCodeFromGeneratorModel = "true";
    usePredefinedTokens = "false";
    overridePluginXML = "false";
    ignoreTypeRestrictionsForPrinting = "true";
    licenceHeader = "licenceHeader.txt";
    editorName = "EMFText XPath 2.0 Editor";
    disableBuilder = "true";
    disableDebugSupport = "true";
    disableLaunchSupport = "true";
    disableNewProjectWizard = "true";
    disableTokenSorting = "true";
}

TOKENS {
    PRIORITIZE INTEGER_LITERAL;
    PRIORITIZE DECIMAL_LITERAL;
    PRIORITIZE DOUBLE_LITERAL;
//    PRIORITIZE COMMENT_CONTENTS;
    PRIORITIZE QNAME;
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
    // TODO: Should be Name - (Char* ':' Char*) /* An XML Name, minus the ":" */
    // TODO: '\u10000'..'\uEFFFF' is not supported
    DEFINE FRAGMENT NCNAME_START_CHAR $'A'..'Z'|'_'|'a'..'z'|'\u00C0'..'\u00D6'|'\u00D8'..'\u00F6'|'\u00F8'..'\u02FF'|'\u0370'..'\u037D'|'\u037F'..'\u1FFF'|'\u200C'..'\u200D'|'\u2070'..'\u218F'|'\u2C00'..'\u2FEF'|'\u3001'..'\uD7FF'|'\uF900'..'\uFDCF'|'\uFDF0'..'\uFFFD'$;
    DEFINE FRAGMENT NCNAME_CHAR NCNAME_START_CHAR + $|'-'|'.'|'0'..'9'|'\u00B7'|'\u0300'..'\u036F'|'\u203F'..'\u2040'$;
    DEFINE NCNAME $($ + NCNAME_START_CHAR + $)($ + NCNAME_CHAR + $)*$;

    DEFINE QNAME NCNAME + $':'$ + NCNAME;

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

    // There are a lot of choices like (name[QNAME] | name[NCNAME]).
    // Printer needs them to choose a right resolver Xpath2QNAMETokenResolver

    // TODO: Implement http://www.w3.org/TR/xpath20/#parse-note-leading-lone-slash
    // TODO: Sometimes model isn't fully updated in a outline window

    // Sequence Expressions, Comparison Expressions, Logical Expressions
    Expr ::= expr:IfExpr,ForExpr,QuantifiedExpr,OrExpr
        ("," expr:IfExpr,ForExpr,QuantifiedExpr,OrExpr)*;
    ForExpr ::= "for" #1 iterator ("," #1 iterator)* #1 "return" #1 return;
    QuantifiedExpr ::= quantifier[some : "some", every : "every"] #1
        iterator ("," #1 iterator)*
        "satisfies" #1 satisfies:IfExpr,ForExpr,QuantifiedExpr,OrExpr;
    @SuppressWarnings(explicitSyntaxChoice)
    Iterator ::= "$" (varName[QNAME] | varName[NCNAME]) #1 "in" #1 list:IfExpr,ForExpr,QuantifiedExpr,OrExpr;
    IfExpr ::= "if" #1 "(" test:Expr,IfExpr,ForExpr,QuantifiedExpr,OrExpr ")"
        #1 "then" #1 then:IfExpr,ForExpr,QuantifiedExpr,OrExpr
        #1 "else" #1 else:IfExpr,ForExpr,QuantifiedExpr,OrExpr;
    OrExpr ::= operand:AndExpr (#1 "or" #1 operand:AndExpr)*;
    AndExpr ::= operand:ComparisonExpr (#1 "and" #1 operand:ComparisonExpr)*;
    ComparisonExpr ::= left:RangeExpr (#1 operator #1 right:RangeExpr)?;
    RangeExpr ::= from:AdditiveExpr (#1 "to" #1 to:AdditiveExpr)?;
    GeneralComp ::= operator[eq : "=", ne : "!=", lt : "<", le : "<=",
        gt : ">", ge : ">="];
    ValueComp ::= operator[eq : "eq", ne : "ne", lt : "lt", le : "le",
        gt : "gt", ge : "ge"];
    NodeComp ::= operator[is : "is", precedes : "<<", follows : ">>"];

    // Sequence Expressions, Arithmetic Expressions
    AdditiveExpr ::= operand:MultiplicativeExpr
        (#1 operator[addition : "+", subtraction : "-"] #1 operand:MultiplicativeExpr)*;
    MultiplicativeExpr ::= operand:UnionExpr
        (#1 operator[multiplication : "*", div : "div", idiv : "idiv", mod : "mod"] #1 operand:UnionExpr)*;
    UnionExpr ::= operand:IntersectExceptExpr
        (#1 operation[union : "union", vertical_bar : "|"] #1 operand:IntersectExceptExpr)*;
    IntersectExceptExpr ::= operand:InstanceofExpr
        (#1 operator[intersect : "intersect", except : "except"] #1 operand:InstanceofExpr)*;

    // Expressions on SequenceTypes
    InstanceofExpr ::= operand:TreatExpr (#1 "instance" "of" type)?;
    TreatExpr ::= operand:CastableExpr (#1 "treat" "as" type)?;
    CastableExpr ::= operand:CastExpr (#1 "castable" "as" type)?;
    CastExpr ::= operand:UnaryExpr (#1 "cast" "as" type)?;
    UnaryExpr ::= operator[plus : "+", minus : "-"]* operand:ValueExpr;

    // FilterExpr must have higher priority than FunctionCall
    FilterExpr ::= primaryExpr:PrimaryExpr predicate*;
    // FunctionCall must have higher priority than PathExpr
    @SuppressWarnings(explicitSyntaxChoice)
    FunctionCall ::= (name[QNAME] | name[NCNAME]) "(" (arg:IfExpr,ForExpr,QuantifiedExpr,OrExpr
        ("," #1 arg:IfExpr,ForExpr,QuantifiedExpr,OrExpr)*)? ")";

    // Path Expressions
    PathExpr ::= step step:ChildStepExpr,DescOrSelfStepExpr*;
    ChildStepExpr ::= "/" step;
    DescOrSelfStepExpr ::= "//" step;
    RootStepExpr ::= "/";
    SelfStepExpr ::= step;
    GeneralForwardStep ::= axis[
        child : "child", descendant : "descendant", attribute : "attribute",
        self : "self", descendant_or_self : "descendant-or-self",
        following_sibling : "following-sibling", following : "following",
        namespace : "namespace"] "::" nodeTest predicate*;
    AbbrevForwardStep ::= kind[child : "", attribute : "@"] nodeTest predicate*;
    GeneralReverseStep ::= axis[parent : "parent", ancestor : "ancestor",
        preceding_sibling : "preceding-sibling", preceding : "preceding",
        ancestor_or_self : "ancestor-or-self"] "::" nodeTest predicate*;
    AbbrevReverseStep ::= kind[parent : ".."] predicate*;
    NodeKindTest ::= test;
    @SuppressWarnings(explicitSyntaxChoice)
    QNameTest ::= (name[QNAME] | name[NCNAME]);
    AnyWildcard ::= "*";
    LocalNameWildcard ::= namespace[NCNAME] ":" "*";
    NamespaceWildcard ::= "*" ":" localName[NCNAME];
    Predicate ::= "[" expr:Expr "]";

    // Primary Expressions
    @SuppressWarnings(explicitSyntaxChoice)
    VarRef ::= "$" (varName[QNAME] | varName[NCNAME]); 
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
    @SuppressWarnings(explicitSyntaxChoice)
    AtomicType ::= (name[QNAME] | name[NCNAME]);
    @SuppressWarnings(explicitSyntaxChoice)
    OptionalAtomicType ::= (name[QNAME] | name[NCNAME]) optional["?" : ""];
    AnyKindTest ::= "node" "(" ")";
    DocumentTest ::= "document-node" "(" test:ElementTest,SchemaElementTest? ")";
    TextTest ::= "text" "(" ")";
    CommentTest ::= "comment" "(" ")";
    PITest ::= "processing-instruction" "("  ")";
    NCNamePITest ::= "processing-instruction" "(" name[NCNAME] ")";
    StringLiteralPITest ::= "processing-instruction" "(" literal[STRING_LITERAL] ")";
    AttributeTest ::= "attribute" "("  ")";
    @SuppressWarnings(explicitSyntaxChoice)
    WildcardAttributeTest ::= "attribute" "(" "*" ("," #1 (type[QNAME] | type[NCNAME]))? ")";
    @SuppressWarnings(explicitSyntaxChoice)
    NameAttributeTest ::= "attribute" "(" (name[QNAME] | name[NCNAME]) ("," #1 (type[QNAME] | type[NCNAME]))? ")";
    @SuppressWarnings(explicitSyntaxChoice)
    SchemaAttributeTest ::= "schema-attribute" "(" (name[QNAME] | name[NCNAME]) ")";
    ElementTest ::= "element" "("  ")";
    WildcardElementTest ::= "element" "(" "*" ("," #1 type)? ")";
    @SuppressWarnings(explicitSyntaxChoice)
    NameElementTest ::= "element" "(" (name[QNAME] | name[NCNAME]) ("," #1 type)? ")";
    @SuppressWarnings(explicitSyntaxChoice)
    SchemaElementTest ::= "schema-element" "(" (name[QNAME] | name[NCNAME]) ")";

    // Literals
    IntegerLiteral ::= value[INTEGER_LITERAL];
    DecimalLiteral ::= value[DECIMAL_LITERAL];
    DoubleLiteral ::= value[DOUBLE_LITERAL];
    StringLiteral ::= value[STRING_LITERAL];
    // TODO: I don't understand where to place comments
    //Comment ::= "(:" (text[COMMENT_CONTENTS] | comment)* ":)";
    //QName ::= (prefix[NCNAME] ":")? name[NCNAME];
}
