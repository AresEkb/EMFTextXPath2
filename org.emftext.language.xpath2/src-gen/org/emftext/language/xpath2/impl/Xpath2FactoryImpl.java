/**
 */
package org.emftext.language.xpath2.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.emftext.language.xpath2.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Xpath2FactoryImpl extends EFactoryImpl implements Xpath2Factory {
	/**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static Xpath2Factory init() {
    try
    {
      Xpath2Factory theXpath2Factory = (Xpath2Factory)EPackage.Registry.INSTANCE.getEFactory(Xpath2Package.eNS_URI);
      if (theXpath2Factory != null)
      {
        return theXpath2Factory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new Xpath2FactoryImpl();
  }

	/**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Xpath2FactoryImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public EObject create(EClass eClass) {
    switch (eClass.getClassifierID())
    {
      case Xpath2Package.EXPR: return createExpr();
      case Xpath2Package.FOR_EXPR: return createForExpr();
      case Xpath2Package.QUANTIFIED_EXPR: return createQuantifiedExpr();
      case Xpath2Package.IF_EXPR: return createIfExpr();
      case Xpath2Package.SIMPLE_FOR_CLAUSE: return createSimpleForClause();
      case Xpath2Package.SIMPLE_FOR_CLAUSE_ITERATOR: return createSimpleForClauseIterator();
      case Xpath2Package.OR_EXPR: return createOrExpr();
      case Xpath2Package.AND_EXPR: return createAndExpr();
      case Xpath2Package.COMPARISON_EXPR: return createComparisonExpr();
      case Xpath2Package.RANGE_EXPR: return createRangeExpr();
      case Xpath2Package.ADDITIVE_EXPR: return createAdditiveExpr();
      case Xpath2Package.MULTIPLICATIVE_EXPR: return createMultiplicativeExpr();
      case Xpath2Package.UNION_EXPR: return createUnionExpr();
      case Xpath2Package.INTERSECT_EXCEPT_EXPR: return createIntersectExceptExpr();
      case Xpath2Package.INSTANCEOF_EXPR: return createInstanceofExpr();
      case Xpath2Package.TREAT_EXPR: return createTreatExpr();
      case Xpath2Package.CASTABLE_EXPR: return createCastableExpr();
      case Xpath2Package.CAST_EXPR: return createCastExpr();
      case Xpath2Package.UNARY_EXPR: return createUnaryExpr();
      case Xpath2Package.PATH_EXPR: return createPathExpr();
      case Xpath2Package.SINGLE_PATH_SEPARATOR: return createSinglePathSeparator();
      case Xpath2Package.DOUBLE_PATH_SEPARATOR: return createDoublePathSeparator();
      case Xpath2Package.RELATIVE_PATH_EXPR: return createRelativePathExpr();
      case Xpath2Package.FILTER_EXPR: return createFilterExpr();
      case Xpath2Package.AXIS_STEP: return createAxisStep();
      case Xpath2Package.GENERAL_FORWARD_STEP: return createGeneralForwardStep();
      case Xpath2Package.ABBREV_FORWARD_STEP: return createAbbrevForwardStep();
      case Xpath2Package.FORWARD_AXIS: return createForwardAxis();
      case Xpath2Package.GENERAL_REVERSE_STEP: return createGeneralReverseStep();
      case Xpath2Package.ABBREV_REVERSE_STEP: return createAbbrevReverseStep();
      case Xpath2Package.REVERSE_AXIS: return createReverseAxis();
      case Xpath2Package.NODE_KIND_TEST: return createNodeKindTest();
      case Xpath2Package.QNAME_TEST: return createQNameTest();
      case Xpath2Package.ANY_WILDCARD: return createAnyWildcard();
      case Xpath2Package.LOCAL_NAME_WILDCARD: return createLocalNameWildcard();
      case Xpath2Package.NAMESPACE_WILDCARD: return createNamespaceWildcard();
      case Xpath2Package.PREDICATE: return createPredicate();
      case Xpath2Package.VAR_REF: return createVarRef();
      case Xpath2Package.VAR_NAME: return createVarName();
      case Xpath2Package.PARENTHESIZED_EXPR: return createParenthesizedExpr();
      case Xpath2Package.CONTEXT_ITEM_EXPR: return createContextItemExpr();
      case Xpath2Package.FUNCTION_CALL: return createFunctionCall();
      case Xpath2Package.STRING_LITERAL: return createStringLiteral();
      case Xpath2Package.INTEGER_LITERAL: return createIntegerLiteral();
      case Xpath2Package.DECIMAL_LITERAL: return createDecimalLiteral();
      case Xpath2Package.DOUBLE_LITERAL: return createDoubleLiteral();
      case Xpath2Package.GENERAL_COMP: return createGeneralComp();
      case Xpath2Package.VALUE_COMP: return createValueComp();
      case Xpath2Package.NODE_COMP: return createNodeComp();
      case Xpath2Package.SINGLE_TYPE: return createSingleType();
      case Xpath2Package.ATOMIC_TYPE: return createAtomicType();
      case Xpath2Package.EMPTY_SEQUENCE_TYPE: return createEmptySequenceType();
      case Xpath2Package.ITEM_SEQUENCE_TYPE: return createItemSequenceType();
      case Xpath2Package.ITEM_KIND_TEST: return createItemKindTest();
      case Xpath2Package.ANY_ITEM_TYPE: return createAnyItemType();
      case Xpath2Package.ATOMIC_ITEM_TYPE: return createAtomicItemType();
      case Xpath2Package.DOCUMENT_TEST: return createDocumentTest();
      case Xpath2Package.ELEMENT_TEST: return createElementTest();
      case Xpath2Package.ATTRIBUTE_TEST: return createAttributeTest();
      case Xpath2Package.SCHEMA_ELEMENT_TEST: return createSchemaElementTest();
      case Xpath2Package.SCHEMA_ATTRIBUTE_TEST: return createSchemaAttributeTest();
      case Xpath2Package.PI_TEST: return createPITest();
      case Xpath2Package.COMMENT_TEST: return createCommentTest();
      case Xpath2Package.TEXT_TEST: return createTextTest();
      case Xpath2Package.ANY_KIND_TEST: return createAnyKindTest();
      case Xpath2Package.COMMENT: return createComment();
      case Xpath2Package.QNAME: return createQName();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
    switch (eDataType.getClassifierID())
    {
      case Xpath2Package.PATH_SEPARATOR_KIND:
        return createPathSeparatorKindFromString(eDataType, initialValue);
      case Xpath2Package.FORWARD_AXIS_KIND:
        return createForwardAxisKindFromString(eDataType, initialValue);
      case Xpath2Package.REVERSE_AXIS_KIND:
        return createReverseAxisKindFromString(eDataType, initialValue);
      case Xpath2Package.UNION_OP:
        return createUnionOpFromString(eDataType, initialValue);
      case Xpath2Package.ADDITIVE_OP_KIND:
        return createAdditiveOpKindFromString(eDataType, initialValue);
      case Xpath2Package.MULTIPLICATIVE_OP_KIND:
        return createMultiplicativeOpKindFromString(eDataType, initialValue);
      case Xpath2Package.QUANTIFIER_KIND:
        return createQuantifierKindFromString(eDataType, initialValue);
      case Xpath2Package.INTERSECT_EXCEPT_OP_KIND:
        return createIntersectExceptOpKindFromString(eDataType, initialValue);
      case Xpath2Package.UNARY_OP:
        return createUnaryOpFromString(eDataType, initialValue);
      case Xpath2Package.GENERAL_COMP_KIND:
        return createGeneralCompKindFromString(eDataType, initialValue);
      case Xpath2Package.VALUE_COMP_KIND:
        return createValueCompKindFromString(eDataType, initialValue);
      case Xpath2Package.NODE_COMP_KIND:
        return createNodeCompKindFromString(eDataType, initialValue);
      case Xpath2Package.OCCURRENCE_INDICATOR_KIND:
        return createOccurrenceIndicatorKindFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
    switch (eDataType.getClassifierID())
    {
      case Xpath2Package.PATH_SEPARATOR_KIND:
        return convertPathSeparatorKindToString(eDataType, instanceValue);
      case Xpath2Package.FORWARD_AXIS_KIND:
        return convertForwardAxisKindToString(eDataType, instanceValue);
      case Xpath2Package.REVERSE_AXIS_KIND:
        return convertReverseAxisKindToString(eDataType, instanceValue);
      case Xpath2Package.UNION_OP:
        return convertUnionOpToString(eDataType, instanceValue);
      case Xpath2Package.ADDITIVE_OP_KIND:
        return convertAdditiveOpKindToString(eDataType, instanceValue);
      case Xpath2Package.MULTIPLICATIVE_OP_KIND:
        return convertMultiplicativeOpKindToString(eDataType, instanceValue);
      case Xpath2Package.QUANTIFIER_KIND:
        return convertQuantifierKindToString(eDataType, instanceValue);
      case Xpath2Package.INTERSECT_EXCEPT_OP_KIND:
        return convertIntersectExceptOpKindToString(eDataType, instanceValue);
      case Xpath2Package.UNARY_OP:
        return convertUnaryOpToString(eDataType, instanceValue);
      case Xpath2Package.GENERAL_COMP_KIND:
        return convertGeneralCompKindToString(eDataType, instanceValue);
      case Xpath2Package.VALUE_COMP_KIND:
        return convertValueCompKindToString(eDataType, instanceValue);
      case Xpath2Package.NODE_COMP_KIND:
        return convertNodeCompKindToString(eDataType, instanceValue);
      case Xpath2Package.OCCURRENCE_INDICATOR_KIND:
        return convertOccurrenceIndicatorKindToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Expr createExpr() {
    ExprImpl expr = new ExprImpl();
    return expr;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ForExpr createForExpr() {
    ForExprImpl forExpr = new ForExprImpl();
    return forExpr;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public QuantifiedExpr createQuantifiedExpr() {
    QuantifiedExprImpl quantifiedExpr = new QuantifiedExprImpl();
    return quantifiedExpr;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public IfExpr createIfExpr() {
    IfExprImpl ifExpr = new IfExprImpl();
    return ifExpr;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public SimpleForClause createSimpleForClause() {
    SimpleForClauseImpl simpleForClause = new SimpleForClauseImpl();
    return simpleForClause;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public SimpleForClauseIterator createSimpleForClauseIterator() {
    SimpleForClauseIteratorImpl simpleForClauseIterator = new SimpleForClauseIteratorImpl();
    return simpleForClauseIterator;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public OrExpr createOrExpr() {
    OrExprImpl orExpr = new OrExprImpl();
    return orExpr;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public AndExpr createAndExpr() {
    AndExprImpl andExpr = new AndExprImpl();
    return andExpr;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ComparisonExpr createComparisonExpr() {
    ComparisonExprImpl comparisonExpr = new ComparisonExprImpl();
    return comparisonExpr;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public RangeExpr createRangeExpr() {
    RangeExprImpl rangeExpr = new RangeExprImpl();
    return rangeExpr;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public AdditiveExpr createAdditiveExpr() {
    AdditiveExprImpl additiveExpr = new AdditiveExprImpl();
    return additiveExpr;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public MultiplicativeExpr createMultiplicativeExpr() {
    MultiplicativeExprImpl multiplicativeExpr = new MultiplicativeExprImpl();
    return multiplicativeExpr;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public UnionExpr createUnionExpr() {
    UnionExprImpl unionExpr = new UnionExprImpl();
    return unionExpr;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public IntersectExceptExpr createIntersectExceptExpr() {
    IntersectExceptExprImpl intersectExceptExpr = new IntersectExceptExprImpl();
    return intersectExceptExpr;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public InstanceofExpr createInstanceofExpr() {
    InstanceofExprImpl instanceofExpr = new InstanceofExprImpl();
    return instanceofExpr;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public TreatExpr createTreatExpr() {
    TreatExprImpl treatExpr = new TreatExprImpl();
    return treatExpr;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public CastableExpr createCastableExpr() {
    CastableExprImpl castableExpr = new CastableExprImpl();
    return castableExpr;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public CastExpr createCastExpr() {
    CastExprImpl castExpr = new CastExprImpl();
    return castExpr;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public UnaryExpr createUnaryExpr() {
    UnaryExprImpl unaryExpr = new UnaryExprImpl();
    return unaryExpr;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public PathExpr createPathExpr() {
    PathExprImpl pathExpr = new PathExprImpl();
    return pathExpr;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public SinglePathSeparator createSinglePathSeparator() {
    SinglePathSeparatorImpl singlePathSeparator = new SinglePathSeparatorImpl();
    return singlePathSeparator;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public DoublePathSeparator createDoublePathSeparator() {
    DoublePathSeparatorImpl doublePathSeparator = new DoublePathSeparatorImpl();
    return doublePathSeparator;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public RelativePathExpr createRelativePathExpr() {
    RelativePathExprImpl relativePathExpr = new RelativePathExprImpl();
    return relativePathExpr;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public FilterExpr createFilterExpr() {
    FilterExprImpl filterExpr = new FilterExprImpl();
    return filterExpr;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public AxisStep createAxisStep() {
    AxisStepImpl axisStep = new AxisStepImpl();
    return axisStep;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public GeneralForwardStep createGeneralForwardStep() {
    GeneralForwardStepImpl generalForwardStep = new GeneralForwardStepImpl();
    return generalForwardStep;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public AbbrevForwardStep createAbbrevForwardStep() {
    AbbrevForwardStepImpl abbrevForwardStep = new AbbrevForwardStepImpl();
    return abbrevForwardStep;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ForwardAxis createForwardAxis() {
    ForwardAxisImpl forwardAxis = new ForwardAxisImpl();
    return forwardAxis;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public GeneralReverseStep createGeneralReverseStep() {
    GeneralReverseStepImpl generalReverseStep = new GeneralReverseStepImpl();
    return generalReverseStep;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public AbbrevReverseStep createAbbrevReverseStep() {
    AbbrevReverseStepImpl abbrevReverseStep = new AbbrevReverseStepImpl();
    return abbrevReverseStep;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ReverseAxis createReverseAxis() {
    ReverseAxisImpl reverseAxis = new ReverseAxisImpl();
    return reverseAxis;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NodeKindTest createNodeKindTest() {
    NodeKindTestImpl nodeKindTest = new NodeKindTestImpl();
    return nodeKindTest;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public QNameTest createQNameTest() {
    QNameTestImpl qNameTest = new QNameTestImpl();
    return qNameTest;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public AnyWildcard createAnyWildcard() {
    AnyWildcardImpl anyWildcard = new AnyWildcardImpl();
    return anyWildcard;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public LocalNameWildcard createLocalNameWildcard() {
    LocalNameWildcardImpl localNameWildcard = new LocalNameWildcardImpl();
    return localNameWildcard;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NamespaceWildcard createNamespaceWildcard() {
    NamespaceWildcardImpl namespaceWildcard = new NamespaceWildcardImpl();
    return namespaceWildcard;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Predicate createPredicate() {
    PredicateImpl predicate = new PredicateImpl();
    return predicate;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public VarRef createVarRef() {
    VarRefImpl varRef = new VarRefImpl();
    return varRef;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public VarName createVarName() {
    VarNameImpl varName = new VarNameImpl();
    return varName;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ParenthesizedExpr createParenthesizedExpr() {
    ParenthesizedExprImpl parenthesizedExpr = new ParenthesizedExprImpl();
    return parenthesizedExpr;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ContextItemExpr createContextItemExpr() {
    ContextItemExprImpl contextItemExpr = new ContextItemExprImpl();
    return contextItemExpr;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public FunctionCall createFunctionCall() {
    FunctionCallImpl functionCall = new FunctionCallImpl();
    return functionCall;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public StringLiteral createStringLiteral() {
    StringLiteralImpl stringLiteral = new StringLiteralImpl();
    return stringLiteral;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public IntegerLiteral createIntegerLiteral() {
    IntegerLiteralImpl integerLiteral = new IntegerLiteralImpl();
    return integerLiteral;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public DecimalLiteral createDecimalLiteral() {
    DecimalLiteralImpl decimalLiteral = new DecimalLiteralImpl();
    return decimalLiteral;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public DoubleLiteral createDoubleLiteral() {
    DoubleLiteralImpl doubleLiteral = new DoubleLiteralImpl();
    return doubleLiteral;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public GeneralComp createGeneralComp() {
    GeneralCompImpl generalComp = new GeneralCompImpl();
    return generalComp;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ValueComp createValueComp() {
    ValueCompImpl valueComp = new ValueCompImpl();
    return valueComp;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NodeComp createNodeComp() {
    NodeCompImpl nodeComp = new NodeCompImpl();
    return nodeComp;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public SingleType createSingleType() {
    SingleTypeImpl singleType = new SingleTypeImpl();
    return singleType;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public AtomicType createAtomicType() {
    AtomicTypeImpl atomicType = new AtomicTypeImpl();
    return atomicType;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EmptySequenceType createEmptySequenceType() {
    EmptySequenceTypeImpl emptySequenceType = new EmptySequenceTypeImpl();
    return emptySequenceType;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ItemSequenceType createItemSequenceType() {
    ItemSequenceTypeImpl itemSequenceType = new ItemSequenceTypeImpl();
    return itemSequenceType;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ItemKindTest createItemKindTest() {
    ItemKindTestImpl itemKindTest = new ItemKindTestImpl();
    return itemKindTest;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public AnyItemType createAnyItemType() {
    AnyItemTypeImpl anyItemType = new AnyItemTypeImpl();
    return anyItemType;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public AtomicItemType createAtomicItemType() {
    AtomicItemTypeImpl atomicItemType = new AtomicItemTypeImpl();
    return atomicItemType;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public DocumentTest createDocumentTest() {
    DocumentTestImpl documentTest = new DocumentTestImpl();
    return documentTest;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ElementTest createElementTest() {
    ElementTestImpl elementTest = new ElementTestImpl();
    return elementTest;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public AttributeTest createAttributeTest() {
    AttributeTestImpl attributeTest = new AttributeTestImpl();
    return attributeTest;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public SchemaElementTest createSchemaElementTest() {
    SchemaElementTestImpl schemaElementTest = new SchemaElementTestImpl();
    return schemaElementTest;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public SchemaAttributeTest createSchemaAttributeTest() {
    SchemaAttributeTestImpl schemaAttributeTest = new SchemaAttributeTestImpl();
    return schemaAttributeTest;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public PITest createPITest() {
    PITestImpl piTest = new PITestImpl();
    return piTest;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public CommentTest createCommentTest() {
    CommentTestImpl commentTest = new CommentTestImpl();
    return commentTest;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public TextTest createTextTest() {
    TextTestImpl textTest = new TextTestImpl();
    return textTest;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public AnyKindTest createAnyKindTest() {
    AnyKindTestImpl anyKindTest = new AnyKindTestImpl();
    return anyKindTest;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Comment createComment() {
    CommentImpl comment = new CommentImpl();
    return comment;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public QName createQName() {
    QNameImpl qName = new QNameImpl();
    return qName;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public PathSeparatorKind createPathSeparatorKindFromString(EDataType eDataType, String initialValue) {
    PathSeparatorKind result = PathSeparatorKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String convertPathSeparatorKindToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ForwardAxisKind createForwardAxisKindFromString(EDataType eDataType, String initialValue) {
    ForwardAxisKind result = ForwardAxisKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String convertForwardAxisKindToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ReverseAxisKind createReverseAxisKindFromString(EDataType eDataType, String initialValue) {
    ReverseAxisKind result = ReverseAxisKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String convertReverseAxisKindToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public UnionOp createUnionOpFromString(EDataType eDataType, String initialValue) {
    UnionOp result = UnionOp.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String convertUnionOpToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public AdditiveOpKind createAdditiveOpKindFromString(EDataType eDataType, String initialValue) {
    AdditiveOpKind result = AdditiveOpKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String convertAdditiveOpKindToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public MultiplicativeOpKind createMultiplicativeOpKindFromString(EDataType eDataType, String initialValue) {
    MultiplicativeOpKind result = MultiplicativeOpKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String convertMultiplicativeOpKindToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public QuantifierKind createQuantifierKindFromString(EDataType eDataType, String initialValue) {
    QuantifierKind result = QuantifierKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String convertQuantifierKindToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public IntersectExceptOpKind createIntersectExceptOpKindFromString(EDataType eDataType, String initialValue) {
    IntersectExceptOpKind result = IntersectExceptOpKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String convertIntersectExceptOpKindToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public UnaryOp createUnaryOpFromString(EDataType eDataType, String initialValue) {
    UnaryOp result = UnaryOp.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String convertUnaryOpToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public GeneralCompKind createGeneralCompKindFromString(EDataType eDataType, String initialValue) {
    GeneralCompKind result = GeneralCompKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String convertGeneralCompKindToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ValueCompKind createValueCompKindFromString(EDataType eDataType, String initialValue) {
    ValueCompKind result = ValueCompKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String convertValueCompKindToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NodeCompKind createNodeCompKindFromString(EDataType eDataType, String initialValue) {
    NodeCompKind result = NodeCompKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String convertNodeCompKindToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public OccurrenceIndicatorKind createOccurrenceIndicatorKindFromString(EDataType eDataType, String initialValue) {
    OccurrenceIndicatorKind result = OccurrenceIndicatorKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String convertOccurrenceIndicatorKindToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Xpath2Package getXpath2Package() {
    return (Xpath2Package)getEPackage();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
	@Deprecated
	public static Xpath2Package getPackage() {
    return Xpath2Package.eINSTANCE;
  }

} //Xpath2FactoryImpl
