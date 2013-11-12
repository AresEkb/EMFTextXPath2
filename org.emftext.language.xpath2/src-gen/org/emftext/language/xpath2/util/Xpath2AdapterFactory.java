/**
 */
package org.emftext.language.xpath2.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.emftext.language.xpath2.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.language.xpath2.Xpath2Package
 * @generated
 */
public class Xpath2AdapterFactory extends AdapterFactoryImpl {
	/**
   * The cached model package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected static Xpath2Package modelPackage;

	/**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Xpath2AdapterFactory() {
    if (modelPackage == null)
    {
      modelPackage = Xpath2Package.eINSTANCE;
    }
  }

	/**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
	@Override
	public boolean isFactoryForType(Object object) {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

	/**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected Xpath2Switch<Adapter> modelSwitch =
		new Xpath2Switch<Adapter>()
    {
      @Override
      public Adapter caseExpr(Expr object)
      {
        return createExprAdapter();
      }
      @Override
      public Adapter caseExprSingle(ExprSingle object)
      {
        return createExprSingleAdapter();
      }
      @Override
      public Adapter caseForExpr(ForExpr object)
      {
        return createForExprAdapter();
      }
      @Override
      public Adapter caseQuantifiedExpr(QuantifiedExpr object)
      {
        return createQuantifiedExprAdapter();
      }
      @Override
      public Adapter caseIfExpr(IfExpr object)
      {
        return createIfExprAdapter();
      }
      @Override
      public Adapter caseSimpleForClause(SimpleForClause object)
      {
        return createSimpleForClauseAdapter();
      }
      @Override
      public Adapter caseSimpleForClauseIterator(SimpleForClauseIterator object)
      {
        return createSimpleForClauseIteratorAdapter();
      }
      @Override
      public Adapter caseOrExpr(OrExpr object)
      {
        return createOrExprAdapter();
      }
      @Override
      public Adapter caseOrExprChild(OrExprChild object)
      {
        return createOrExprChildAdapter();
      }
      @Override
      public Adapter caseAndExpr(AndExpr object)
      {
        return createAndExprAdapter();
      }
      @Override
      public Adapter caseAndExprChild(AndExprChild object)
      {
        return createAndExprChildAdapter();
      }
      @Override
      public Adapter caseComparisonExpr(ComparisonExpr object)
      {
        return createComparisonExprAdapter();
      }
      @Override
      public Adapter caseComparisonExprChild(ComparisonExprChild object)
      {
        return createComparisonExprChildAdapter();
      }
      @Override
      public Adapter caseRangeExpr(RangeExpr object)
      {
        return createRangeExprAdapter();
      }
      @Override
      public Adapter caseRangeExprChild(RangeExprChild object)
      {
        return createRangeExprChildAdapter();
      }
      @Override
      public Adapter caseAdditiveExpr(AdditiveExpr object)
      {
        return createAdditiveExprAdapter();
      }
      @Override
      public Adapter caseAdditiveExprChild(AdditiveExprChild object)
      {
        return createAdditiveExprChildAdapter();
      }
      @Override
      public Adapter caseMultiplicativeExpr(MultiplicativeExpr object)
      {
        return createMultiplicativeExprAdapter();
      }
      @Override
      public Adapter caseMultiplicativeExprChild(MultiplicativeExprChild object)
      {
        return createMultiplicativeExprChildAdapter();
      }
      @Override
      public Adapter caseUnionExpr(UnionExpr object)
      {
        return createUnionExprAdapter();
      }
      @Override
      public Adapter caseUnionExprChild(UnionExprChild object)
      {
        return createUnionExprChildAdapter();
      }
      @Override
      public Adapter caseIntersectExceptExpr(IntersectExceptExpr object)
      {
        return createIntersectExceptExprAdapter();
      }
      @Override
      public Adapter caseIntersectExceptExprChild(IntersectExceptExprChild object)
      {
        return createIntersectExceptExprChildAdapter();
      }
      @Override
      public Adapter caseInstanceofExpr(InstanceofExpr object)
      {
        return createInstanceofExprAdapter();
      }
      @Override
      public Adapter caseInstanceofExprChild(InstanceofExprChild object)
      {
        return createInstanceofExprChildAdapter();
      }
      @Override
      public Adapter caseTreatExpr(TreatExpr object)
      {
        return createTreatExprAdapter();
      }
      @Override
      public Adapter caseTreatExprChild(TreatExprChild object)
      {
        return createTreatExprChildAdapter();
      }
      @Override
      public Adapter caseCastableExpr(CastableExpr object)
      {
        return createCastableExprAdapter();
      }
      @Override
      public Adapter caseCastableExprChild(CastableExprChild object)
      {
        return createCastableExprChildAdapter();
      }
      @Override
      public Adapter caseCastExpr(CastExpr object)
      {
        return createCastExprAdapter();
      }
      @Override
      public Adapter caseCastExprChild(CastExprChild object)
      {
        return createCastExprChildAdapter();
      }
      @Override
      public Adapter caseUnaryExpr(UnaryExpr object)
      {
        return createUnaryExprAdapter();
      }
      @Override
      public Adapter caseUnaryExprChild(UnaryExprChild object)
      {
        return createUnaryExprChildAdapter();
      }
      @Override
      public Adapter caseValueExpr(ValueExpr object)
      {
        return createValueExprAdapter();
      }
      @Override
      public Adapter casePathExpr(PathExpr object)
      {
        return createPathExprAdapter();
      }
      @Override
      public Adapter casePathSeparator(PathSeparator object)
      {
        return createPathSeparatorAdapter();
      }
      @Override
      public Adapter caseSinglePathSeparator(SinglePathSeparator object)
      {
        return createSinglePathSeparatorAdapter();
      }
      @Override
      public Adapter caseDoublePathSeparator(DoublePathSeparator object)
      {
        return createDoublePathSeparatorAdapter();
      }
      @Override
      public Adapter caseRelativePathExpr(RelativePathExpr object)
      {
        return createRelativePathExprAdapter();
      }
      @Override
      public Adapter caseStepExpr(StepExpr object)
      {
        return createStepExprAdapter();
      }
      @Override
      public Adapter caseFilterExpr(FilterExpr object)
      {
        return createFilterExprAdapter();
      }
      @Override
      public Adapter caseAxisStep(AxisStep object)
      {
        return createAxisStepAdapter();
      }
      @Override
      public Adapter caseDirectionalStep(DirectionalStep object)
      {
        return createDirectionalStepAdapter();
      }
      @Override
      public Adapter caseForwardStep(ForwardStep object)
      {
        return createForwardStepAdapter();
      }
      @Override
      public Adapter caseReverseStep(ReverseStep object)
      {
        return createReverseStepAdapter();
      }
      @Override
      public Adapter caseGeneralForwardStep(GeneralForwardStep object)
      {
        return createGeneralForwardStepAdapter();
      }
      @Override
      public Adapter caseAbbrevForwardStep(AbbrevForwardStep object)
      {
        return createAbbrevForwardStepAdapter();
      }
      @Override
      public Adapter caseForwardAxis(ForwardAxis object)
      {
        return createForwardAxisAdapter();
      }
      @Override
      public Adapter caseGeneralReverseStep(GeneralReverseStep object)
      {
        return createGeneralReverseStepAdapter();
      }
      @Override
      public Adapter caseAbbrevReverseStep(AbbrevReverseStep object)
      {
        return createAbbrevReverseStepAdapter();
      }
      @Override
      public Adapter caseReverseAxis(ReverseAxis object)
      {
        return createReverseAxisAdapter();
      }
      @Override
      public Adapter caseNodeTest(NodeTest object)
      {
        return createNodeTestAdapter();
      }
      @Override
      public Adapter caseNodeKindTest(NodeKindTest object)
      {
        return createNodeKindTestAdapter();
      }
      @Override
      public Adapter caseNameTest(NameTest object)
      {
        return createNameTestAdapter();
      }
      @Override
      public Adapter caseQNameTest(QNameTest object)
      {
        return createQNameTestAdapter();
      }
      @Override
      public Adapter caseWildcard(Wildcard object)
      {
        return createWildcardAdapter();
      }
      @Override
      public Adapter caseAnyWildcard(AnyWildcard object)
      {
        return createAnyWildcardAdapter();
      }
      @Override
      public Adapter caseLocalNameWildcard(LocalNameWildcard object)
      {
        return createLocalNameWildcardAdapter();
      }
      @Override
      public Adapter caseNamespaceWildcard(NamespaceWildcard object)
      {
        return createNamespaceWildcardAdapter();
      }
      @Override
      public Adapter casePredicate(Predicate object)
      {
        return createPredicateAdapter();
      }
      @Override
      public Adapter casePrimaryExpr(PrimaryExpr object)
      {
        return createPrimaryExprAdapter();
      }
      @Override
      public Adapter caseLiteral(Literal object)
      {
        return createLiteralAdapter();
      }
      @Override
      public Adapter caseVarRef(VarRef object)
      {
        return createVarRefAdapter();
      }
      @Override
      public Adapter caseVarName(VarName object)
      {
        return createVarNameAdapter();
      }
      @Override
      public Adapter caseParenthesizedExpr(ParenthesizedExpr object)
      {
        return createParenthesizedExprAdapter();
      }
      @Override
      public Adapter caseContextItemExpr(ContextItemExpr object)
      {
        return createContextItemExprAdapter();
      }
      @Override
      public Adapter caseFunctionCall(FunctionCall object)
      {
        return createFunctionCallAdapter();
      }
      @Override
      public Adapter caseNumericLiteral(NumericLiteral object)
      {
        return createNumericLiteralAdapter();
      }
      @Override
      public Adapter caseStringLiteral(StringLiteral object)
      {
        return createStringLiteralAdapter();
      }
      @Override
      public Adapter caseIntegerLiteral(IntegerLiteral object)
      {
        return createIntegerLiteralAdapter();
      }
      @Override
      public Adapter caseDecimalLiteral(DecimalLiteral object)
      {
        return createDecimalLiteralAdapter();
      }
      @Override
      public Adapter caseDoubleLiteral(DoubleLiteral object)
      {
        return createDoubleLiteralAdapter();
      }
      @Override
      public Adapter caseComp(Comp object)
      {
        return createCompAdapter();
      }
      @Override
      public Adapter caseGeneralComp(GeneralComp object)
      {
        return createGeneralCompAdapter();
      }
      @Override
      public Adapter caseValueComp(ValueComp object)
      {
        return createValueCompAdapter();
      }
      @Override
      public Adapter caseNodeComp(NodeComp object)
      {
        return createNodeCompAdapter();
      }
      @Override
      public Adapter caseSingleType(SingleType object)
      {
        return createSingleTypeAdapter();
      }
      @Override
      public Adapter caseAtomicType(AtomicType object)
      {
        return createAtomicTypeAdapter();
      }
      @Override
      public Adapter caseSequenceType(SequenceType object)
      {
        return createSequenceTypeAdapter();
      }
      @Override
      public Adapter caseEmptySequenceType(EmptySequenceType object)
      {
        return createEmptySequenceTypeAdapter();
      }
      @Override
      public Adapter caseItemSequenceType(ItemSequenceType object)
      {
        return createItemSequenceTypeAdapter();
      }
      @Override
      public Adapter caseItemType(ItemType object)
      {
        return createItemTypeAdapter();
      }
      @Override
      public Adapter caseItemKindTest(ItemKindTest object)
      {
        return createItemKindTestAdapter();
      }
      @Override
      public Adapter caseAnyItemType(AnyItemType object)
      {
        return createAnyItemTypeAdapter();
      }
      @Override
      public Adapter caseAtomicItemType(AtomicItemType object)
      {
        return createAtomicItemTypeAdapter();
      }
      @Override
      public Adapter caseKindTest(KindTest object)
      {
        return createKindTestAdapter();
      }
      @Override
      public Adapter caseDocumentTest(DocumentTest object)
      {
        return createDocumentTestAdapter();
      }
      @Override
      public Adapter caseElementTest(ElementTest object)
      {
        return createElementTestAdapter();
      }
      @Override
      public Adapter caseAttributeTest(AttributeTest object)
      {
        return createAttributeTestAdapter();
      }
      @Override
      public Adapter caseSchemaElementTest(SchemaElementTest object)
      {
        return createSchemaElementTestAdapter();
      }
      @Override
      public Adapter caseSchemaAttributeTest(SchemaAttributeTest object)
      {
        return createSchemaAttributeTestAdapter();
      }
      @Override
      public Adapter casePITest(PITest object)
      {
        return createPITestAdapter();
      }
      @Override
      public Adapter caseCommentTest(CommentTest object)
      {
        return createCommentTestAdapter();
      }
      @Override
      public Adapter caseTextTest(TextTest object)
      {
        return createTextTestAdapter();
      }
      @Override
      public Adapter caseAnyKindTest(AnyKindTest object)
      {
        return createAnyKindTestAdapter();
      }
      @Override
      public Adapter caseComment(Comment object)
      {
        return createCommentAdapter();
      }
      @Override
      public Adapter caseQName(QName object)
      {
        return createQNameAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

	/**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
	@Override
	public Adapter createAdapter(Notifier target) {
    return modelSwitch.doSwitch((EObject)target);
  }


	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.Expr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.Expr
   * @generated
   */
	public Adapter createExprAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.ExprSingle <em>Expr Single</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.ExprSingle
   * @generated
   */
	public Adapter createExprSingleAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.ForExpr <em>For Expr</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.ForExpr
   * @generated
   */
	public Adapter createForExprAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.QuantifiedExpr <em>Quantified Expr</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.QuantifiedExpr
   * @generated
   */
	public Adapter createQuantifiedExprAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.IfExpr <em>If Expr</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.IfExpr
   * @generated
   */
	public Adapter createIfExprAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.SimpleForClause <em>Simple For Clause</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.SimpleForClause
   * @generated
   */
	public Adapter createSimpleForClauseAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.SimpleForClauseIterator <em>Simple For Clause Iterator</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.SimpleForClauseIterator
   * @generated
   */
	public Adapter createSimpleForClauseIteratorAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.OrExpr <em>Or Expr</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.OrExpr
   * @generated
   */
	public Adapter createOrExprAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.OrExprChild <em>Or Expr Child</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.OrExprChild
   * @generated
   */
	public Adapter createOrExprChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.AndExpr <em>And Expr</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.AndExpr
   * @generated
   */
	public Adapter createAndExprAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.AndExprChild <em>And Expr Child</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.AndExprChild
   * @generated
   */
	public Adapter createAndExprChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.ComparisonExpr <em>Comparison Expr</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.ComparisonExpr
   * @generated
   */
	public Adapter createComparisonExprAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.ComparisonExprChild <em>Comparison Expr Child</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.ComparisonExprChild
   * @generated
   */
	public Adapter createComparisonExprChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.RangeExpr <em>Range Expr</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.RangeExpr
   * @generated
   */
	public Adapter createRangeExprAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.RangeExprChild <em>Range Expr Child</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.RangeExprChild
   * @generated
   */
	public Adapter createRangeExprChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.AdditiveExpr <em>Additive Expr</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.AdditiveExpr
   * @generated
   */
	public Adapter createAdditiveExprAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.AdditiveExprChild <em>Additive Expr Child</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.AdditiveExprChild
   * @generated
   */
	public Adapter createAdditiveExprChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.MultiplicativeExpr <em>Multiplicative Expr</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.MultiplicativeExpr
   * @generated
   */
	public Adapter createMultiplicativeExprAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.MultiplicativeExprChild <em>Multiplicative Expr Child</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.MultiplicativeExprChild
   * @generated
   */
	public Adapter createMultiplicativeExprChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.UnionExpr <em>Union Expr</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.UnionExpr
   * @generated
   */
	public Adapter createUnionExprAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.UnionExprChild <em>Union Expr Child</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.UnionExprChild
   * @generated
   */
	public Adapter createUnionExprChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.IntersectExceptExpr <em>Intersect Except Expr</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.IntersectExceptExpr
   * @generated
   */
	public Adapter createIntersectExceptExprAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.IntersectExceptExprChild <em>Intersect Except Expr Child</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.IntersectExceptExprChild
   * @generated
   */
	public Adapter createIntersectExceptExprChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.InstanceofExpr <em>Instanceof Expr</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.InstanceofExpr
   * @generated
   */
	public Adapter createInstanceofExprAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.InstanceofExprChild <em>Instanceof Expr Child</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.InstanceofExprChild
   * @generated
   */
	public Adapter createInstanceofExprChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.TreatExpr <em>Treat Expr</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.TreatExpr
   * @generated
   */
	public Adapter createTreatExprAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.TreatExprChild <em>Treat Expr Child</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.TreatExprChild
   * @generated
   */
	public Adapter createTreatExprChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.CastableExpr <em>Castable Expr</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.CastableExpr
   * @generated
   */
	public Adapter createCastableExprAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.CastableExprChild <em>Castable Expr Child</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.CastableExprChild
   * @generated
   */
	public Adapter createCastableExprChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.CastExpr <em>Cast Expr</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.CastExpr
   * @generated
   */
	public Adapter createCastExprAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.CastExprChild <em>Cast Expr Child</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.CastExprChild
   * @generated
   */
	public Adapter createCastExprChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.UnaryExpr <em>Unary Expr</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.UnaryExpr
   * @generated
   */
	public Adapter createUnaryExprAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.UnaryExprChild <em>Unary Expr Child</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.UnaryExprChild
   * @generated
   */
	public Adapter createUnaryExprChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.ValueExpr <em>Value Expr</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.ValueExpr
   * @generated
   */
	public Adapter createValueExprAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.PathExpr <em>Path Expr</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.PathExpr
   * @generated
   */
	public Adapter createPathExprAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.PathSeparator <em>Path Separator</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.PathSeparator
   * @generated
   */
	public Adapter createPathSeparatorAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.SinglePathSeparator <em>Single Path Separator</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.SinglePathSeparator
   * @generated
   */
	public Adapter createSinglePathSeparatorAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.DoublePathSeparator <em>Double Path Separator</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.DoublePathSeparator
   * @generated
   */
	public Adapter createDoublePathSeparatorAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.RelativePathExpr <em>Relative Path Expr</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.RelativePathExpr
   * @generated
   */
	public Adapter createRelativePathExprAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.StepExpr <em>Step Expr</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.StepExpr
   * @generated
   */
	public Adapter createStepExprAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.FilterExpr <em>Filter Expr</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.FilterExpr
   * @generated
   */
	public Adapter createFilterExprAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.AxisStep <em>Axis Step</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.AxisStep
   * @generated
   */
	public Adapter createAxisStepAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.DirectionalStep <em>Directional Step</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.DirectionalStep
   * @generated
   */
	public Adapter createDirectionalStepAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.ForwardStep <em>Forward Step</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.ForwardStep
   * @generated
   */
	public Adapter createForwardStepAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.ReverseStep <em>Reverse Step</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.ReverseStep
   * @generated
   */
	public Adapter createReverseStepAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.GeneralForwardStep <em>General Forward Step</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.GeneralForwardStep
   * @generated
   */
	public Adapter createGeneralForwardStepAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.AbbrevForwardStep <em>Abbrev Forward Step</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.AbbrevForwardStep
   * @generated
   */
	public Adapter createAbbrevForwardStepAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.ForwardAxis <em>Forward Axis</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.ForwardAxis
   * @generated
   */
	public Adapter createForwardAxisAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.GeneralReverseStep <em>General Reverse Step</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.GeneralReverseStep
   * @generated
   */
	public Adapter createGeneralReverseStepAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.AbbrevReverseStep <em>Abbrev Reverse Step</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.AbbrevReverseStep
   * @generated
   */
	public Adapter createAbbrevReverseStepAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.ReverseAxis <em>Reverse Axis</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.ReverseAxis
   * @generated
   */
	public Adapter createReverseAxisAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.NodeTest <em>Node Test</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.NodeTest
   * @generated
   */
	public Adapter createNodeTestAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.NodeKindTest <em>Node Kind Test</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.NodeKindTest
   * @generated
   */
	public Adapter createNodeKindTestAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.NameTest <em>Name Test</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.NameTest
   * @generated
   */
	public Adapter createNameTestAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.QNameTest <em>QName Test</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.QNameTest
   * @generated
   */
	public Adapter createQNameTestAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.Wildcard <em>Wildcard</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.Wildcard
   * @generated
   */
	public Adapter createWildcardAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.AnyWildcard <em>Any Wildcard</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.AnyWildcard
   * @generated
   */
	public Adapter createAnyWildcardAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.LocalNameWildcard <em>Local Name Wildcard</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.LocalNameWildcard
   * @generated
   */
	public Adapter createLocalNameWildcardAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.NamespaceWildcard <em>Namespace Wildcard</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.NamespaceWildcard
   * @generated
   */
	public Adapter createNamespaceWildcardAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.Predicate <em>Predicate</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.Predicate
   * @generated
   */
	public Adapter createPredicateAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.PrimaryExpr <em>Primary Expr</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.PrimaryExpr
   * @generated
   */
	public Adapter createPrimaryExprAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.Literal
   * @generated
   */
	public Adapter createLiteralAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.VarRef <em>Var Ref</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.VarRef
   * @generated
   */
	public Adapter createVarRefAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.VarName <em>Var Name</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.VarName
   * @generated
   */
	public Adapter createVarNameAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.ParenthesizedExpr <em>Parenthesized Expr</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.ParenthesizedExpr
   * @generated
   */
	public Adapter createParenthesizedExprAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.ContextItemExpr <em>Context Item Expr</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.ContextItemExpr
   * @generated
   */
	public Adapter createContextItemExprAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.FunctionCall <em>Function Call</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.FunctionCall
   * @generated
   */
	public Adapter createFunctionCallAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.NumericLiteral <em>Numeric Literal</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.NumericLiteral
   * @generated
   */
	public Adapter createNumericLiteralAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.StringLiteral <em>String Literal</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.StringLiteral
   * @generated
   */
	public Adapter createStringLiteralAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.IntegerLiteral <em>Integer Literal</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.IntegerLiteral
   * @generated
   */
	public Adapter createIntegerLiteralAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.DecimalLiteral <em>Decimal Literal</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.DecimalLiteral
   * @generated
   */
	public Adapter createDecimalLiteralAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.DoubleLiteral <em>Double Literal</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.DoubleLiteral
   * @generated
   */
	public Adapter createDoubleLiteralAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.Comp <em>Comp</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.Comp
   * @generated
   */
	public Adapter createCompAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.GeneralComp <em>General Comp</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.GeneralComp
   * @generated
   */
	public Adapter createGeneralCompAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.ValueComp <em>Value Comp</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.ValueComp
   * @generated
   */
	public Adapter createValueCompAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.NodeComp <em>Node Comp</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.NodeComp
   * @generated
   */
	public Adapter createNodeCompAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.SingleType <em>Single Type</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.SingleType
   * @generated
   */
	public Adapter createSingleTypeAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.AtomicType <em>Atomic Type</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.AtomicType
   * @generated
   */
	public Adapter createAtomicTypeAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.SequenceType <em>Sequence Type</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.SequenceType
   * @generated
   */
	public Adapter createSequenceTypeAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.EmptySequenceType <em>Empty Sequence Type</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.EmptySequenceType
   * @generated
   */
	public Adapter createEmptySequenceTypeAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.ItemSequenceType <em>Item Sequence Type</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.ItemSequenceType
   * @generated
   */
	public Adapter createItemSequenceTypeAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.ItemType <em>Item Type</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.ItemType
   * @generated
   */
	public Adapter createItemTypeAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.ItemKindTest <em>Item Kind Test</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.ItemKindTest
   * @generated
   */
	public Adapter createItemKindTestAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.AnyItemType <em>Any Item Type</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.AnyItemType
   * @generated
   */
	public Adapter createAnyItemTypeAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.AtomicItemType <em>Atomic Item Type</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.AtomicItemType
   * @generated
   */
	public Adapter createAtomicItemTypeAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.KindTest <em>Kind Test</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.KindTest
   * @generated
   */
	public Adapter createKindTestAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.DocumentTest <em>Document Test</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.DocumentTest
   * @generated
   */
	public Adapter createDocumentTestAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.ElementTest <em>Element Test</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.ElementTest
   * @generated
   */
	public Adapter createElementTestAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.AttributeTest <em>Attribute Test</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.AttributeTest
   * @generated
   */
	public Adapter createAttributeTestAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.SchemaElementTest <em>Schema Element Test</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.SchemaElementTest
   * @generated
   */
	public Adapter createSchemaElementTestAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.SchemaAttributeTest <em>Schema Attribute Test</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.SchemaAttributeTest
   * @generated
   */
	public Adapter createSchemaAttributeTestAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.PITest <em>PI Test</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.PITest
   * @generated
   */
	public Adapter createPITestAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.CommentTest <em>Comment Test</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.CommentTest
   * @generated
   */
	public Adapter createCommentTestAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.TextTest <em>Text Test</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.TextTest
   * @generated
   */
	public Adapter createTextTestAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.AnyKindTest <em>Any Kind Test</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.AnyKindTest
   * @generated
   */
	public Adapter createAnyKindTestAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.Comment <em>Comment</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.Comment
   * @generated
   */
	public Adapter createCommentAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.xpath2.QName <em>QName</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.xpath2.QName
   * @generated
   */
	public Adapter createQNameAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
	public Adapter createEObjectAdapter() {
    return null;
  }

} //Xpath2AdapterFactory
