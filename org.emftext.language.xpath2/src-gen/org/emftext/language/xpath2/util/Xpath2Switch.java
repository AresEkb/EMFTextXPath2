/**
 */
package org.emftext.language.xpath2.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.emftext.language.xpath2.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.emftext.language.xpath2.Xpath2Package
 * @generated
 */
public class Xpath2Switch<T> extends Switch<T> {
	/**
   * The cached model package
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected static Xpath2Package modelPackage;

	/**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Xpath2Switch() {
    if (modelPackage == null)
    {
      modelPackage = Xpath2Package.eINSTANCE;
    }
  }

	/**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
    return ePackage == modelPackage;
  }

	/**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
    switch (classifierID)
    {
      case Xpath2Package.EXPR:
      {
        Expr expr = (Expr)theEObject;
        T result = caseExpr(expr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.EXPR_SINGLE:
      {
        ExprSingle exprSingle = (ExprSingle)theEObject;
        T result = caseExprSingle(exprSingle);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.FOR_EXPR:
      {
        ForExpr forExpr = (ForExpr)theEObject;
        T result = caseForExpr(forExpr);
        if (result == null) result = caseExprSingle(forExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.QUANTIFIED_EXPR:
      {
        QuantifiedExpr quantifiedExpr = (QuantifiedExpr)theEObject;
        T result = caseQuantifiedExpr(quantifiedExpr);
        if (result == null) result = caseExprSingle(quantifiedExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.IF_EXPR:
      {
        IfExpr ifExpr = (IfExpr)theEObject;
        T result = caseIfExpr(ifExpr);
        if (result == null) result = caseExprSingle(ifExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.SIMPLE_FOR_CLAUSE:
      {
        SimpleForClause simpleForClause = (SimpleForClause)theEObject;
        T result = caseSimpleForClause(simpleForClause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.SIMPLE_FOR_CLAUSE_ITERATOR:
      {
        SimpleForClauseIterator simpleForClauseIterator = (SimpleForClauseIterator)theEObject;
        T result = caseSimpleForClauseIterator(simpleForClauseIterator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.OR_EXPR:
      {
        OrExpr orExpr = (OrExpr)theEObject;
        T result = caseOrExpr(orExpr);
        if (result == null) result = caseExprSingle(orExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.OR_EXPR_CHILD:
      {
        OrExprChild orExprChild = (OrExprChild)theEObject;
        T result = caseOrExprChild(orExprChild);
        if (result == null) result = caseExprSingle(orExprChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.AND_EXPR:
      {
        AndExpr andExpr = (AndExpr)theEObject;
        T result = caseAndExpr(andExpr);
        if (result == null) result = caseOrExprChild(andExpr);
        if (result == null) result = caseExprSingle(andExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.AND_EXPR_CHILD:
      {
        AndExprChild andExprChild = (AndExprChild)theEObject;
        T result = caseAndExprChild(andExprChild);
        if (result == null) result = caseOrExprChild(andExprChild);
        if (result == null) result = caseExprSingle(andExprChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.COMPARISON_EXPR:
      {
        ComparisonExpr comparisonExpr = (ComparisonExpr)theEObject;
        T result = caseComparisonExpr(comparisonExpr);
        if (result == null) result = caseAndExprChild(comparisonExpr);
        if (result == null) result = caseOrExprChild(comparisonExpr);
        if (result == null) result = caseExprSingle(comparisonExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.COMPARISON_EXPR_CHILD:
      {
        ComparisonExprChild comparisonExprChild = (ComparisonExprChild)theEObject;
        T result = caseComparisonExprChild(comparisonExprChild);
        if (result == null) result = caseAndExprChild(comparisonExprChild);
        if (result == null) result = caseOrExprChild(comparisonExprChild);
        if (result == null) result = caseExprSingle(comparisonExprChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.RANGE_EXPR:
      {
        RangeExpr rangeExpr = (RangeExpr)theEObject;
        T result = caseRangeExpr(rangeExpr);
        if (result == null) result = caseComparisonExprChild(rangeExpr);
        if (result == null) result = caseAndExprChild(rangeExpr);
        if (result == null) result = caseOrExprChild(rangeExpr);
        if (result == null) result = caseExprSingle(rangeExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.RANGE_EXPR_CHILD:
      {
        RangeExprChild rangeExprChild = (RangeExprChild)theEObject;
        T result = caseRangeExprChild(rangeExprChild);
        if (result == null) result = caseComparisonExprChild(rangeExprChild);
        if (result == null) result = caseAndExprChild(rangeExprChild);
        if (result == null) result = caseOrExprChild(rangeExprChild);
        if (result == null) result = caseExprSingle(rangeExprChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.ADDITIVE_EXPR:
      {
        AdditiveExpr additiveExpr = (AdditiveExpr)theEObject;
        T result = caseAdditiveExpr(additiveExpr);
        if (result == null) result = caseRangeExprChild(additiveExpr);
        if (result == null) result = caseComparisonExprChild(additiveExpr);
        if (result == null) result = caseAndExprChild(additiveExpr);
        if (result == null) result = caseOrExprChild(additiveExpr);
        if (result == null) result = caseExprSingle(additiveExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.ADDITIVE_EXPR_CHILD:
      {
        AdditiveExprChild additiveExprChild = (AdditiveExprChild)theEObject;
        T result = caseAdditiveExprChild(additiveExprChild);
        if (result == null) result = caseRangeExprChild(additiveExprChild);
        if (result == null) result = caseComparisonExprChild(additiveExprChild);
        if (result == null) result = caseAndExprChild(additiveExprChild);
        if (result == null) result = caseOrExprChild(additiveExprChild);
        if (result == null) result = caseExprSingle(additiveExprChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.MULTIPLICATIVE_EXPR:
      {
        MultiplicativeExpr multiplicativeExpr = (MultiplicativeExpr)theEObject;
        T result = caseMultiplicativeExpr(multiplicativeExpr);
        if (result == null) result = caseAdditiveExprChild(multiplicativeExpr);
        if (result == null) result = caseRangeExprChild(multiplicativeExpr);
        if (result == null) result = caseComparisonExprChild(multiplicativeExpr);
        if (result == null) result = caseAndExprChild(multiplicativeExpr);
        if (result == null) result = caseOrExprChild(multiplicativeExpr);
        if (result == null) result = caseExprSingle(multiplicativeExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.MULTIPLICATIVE_EXPR_CHILD:
      {
        MultiplicativeExprChild multiplicativeExprChild = (MultiplicativeExprChild)theEObject;
        T result = caseMultiplicativeExprChild(multiplicativeExprChild);
        if (result == null) result = caseAdditiveExprChild(multiplicativeExprChild);
        if (result == null) result = caseRangeExprChild(multiplicativeExprChild);
        if (result == null) result = caseComparisonExprChild(multiplicativeExprChild);
        if (result == null) result = caseAndExprChild(multiplicativeExprChild);
        if (result == null) result = caseOrExprChild(multiplicativeExprChild);
        if (result == null) result = caseExprSingle(multiplicativeExprChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.UNION_EXPR:
      {
        UnionExpr unionExpr = (UnionExpr)theEObject;
        T result = caseUnionExpr(unionExpr);
        if (result == null) result = caseMultiplicativeExprChild(unionExpr);
        if (result == null) result = caseAdditiveExprChild(unionExpr);
        if (result == null) result = caseRangeExprChild(unionExpr);
        if (result == null) result = caseComparisonExprChild(unionExpr);
        if (result == null) result = caseAndExprChild(unionExpr);
        if (result == null) result = caseOrExprChild(unionExpr);
        if (result == null) result = caseExprSingle(unionExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.UNION_EXPR_CHILD:
      {
        UnionExprChild unionExprChild = (UnionExprChild)theEObject;
        T result = caseUnionExprChild(unionExprChild);
        if (result == null) result = caseMultiplicativeExprChild(unionExprChild);
        if (result == null) result = caseAdditiveExprChild(unionExprChild);
        if (result == null) result = caseRangeExprChild(unionExprChild);
        if (result == null) result = caseComparisonExprChild(unionExprChild);
        if (result == null) result = caseAndExprChild(unionExprChild);
        if (result == null) result = caseOrExprChild(unionExprChild);
        if (result == null) result = caseExprSingle(unionExprChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.INTERSECT_EXCEPT_EXPR:
      {
        IntersectExceptExpr intersectExceptExpr = (IntersectExceptExpr)theEObject;
        T result = caseIntersectExceptExpr(intersectExceptExpr);
        if (result == null) result = caseUnionExprChild(intersectExceptExpr);
        if (result == null) result = caseMultiplicativeExprChild(intersectExceptExpr);
        if (result == null) result = caseAdditiveExprChild(intersectExceptExpr);
        if (result == null) result = caseRangeExprChild(intersectExceptExpr);
        if (result == null) result = caseComparisonExprChild(intersectExceptExpr);
        if (result == null) result = caseAndExprChild(intersectExceptExpr);
        if (result == null) result = caseOrExprChild(intersectExceptExpr);
        if (result == null) result = caseExprSingle(intersectExceptExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.INTERSECT_EXCEPT_EXPR_CHILD:
      {
        IntersectExceptExprChild intersectExceptExprChild = (IntersectExceptExprChild)theEObject;
        T result = caseIntersectExceptExprChild(intersectExceptExprChild);
        if (result == null) result = caseUnionExprChild(intersectExceptExprChild);
        if (result == null) result = caseMultiplicativeExprChild(intersectExceptExprChild);
        if (result == null) result = caseAdditiveExprChild(intersectExceptExprChild);
        if (result == null) result = caseRangeExprChild(intersectExceptExprChild);
        if (result == null) result = caseComparisonExprChild(intersectExceptExprChild);
        if (result == null) result = caseAndExprChild(intersectExceptExprChild);
        if (result == null) result = caseOrExprChild(intersectExceptExprChild);
        if (result == null) result = caseExprSingle(intersectExceptExprChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.INSTANCEOF_EXPR:
      {
        InstanceofExpr instanceofExpr = (InstanceofExpr)theEObject;
        T result = caseInstanceofExpr(instanceofExpr);
        if (result == null) result = caseIntersectExceptExprChild(instanceofExpr);
        if (result == null) result = caseUnionExprChild(instanceofExpr);
        if (result == null) result = caseMultiplicativeExprChild(instanceofExpr);
        if (result == null) result = caseAdditiveExprChild(instanceofExpr);
        if (result == null) result = caseRangeExprChild(instanceofExpr);
        if (result == null) result = caseComparisonExprChild(instanceofExpr);
        if (result == null) result = caseAndExprChild(instanceofExpr);
        if (result == null) result = caseOrExprChild(instanceofExpr);
        if (result == null) result = caseExprSingle(instanceofExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.INSTANCEOF_EXPR_CHILD:
      {
        InstanceofExprChild instanceofExprChild = (InstanceofExprChild)theEObject;
        T result = caseInstanceofExprChild(instanceofExprChild);
        if (result == null) result = caseIntersectExceptExprChild(instanceofExprChild);
        if (result == null) result = caseUnionExprChild(instanceofExprChild);
        if (result == null) result = caseMultiplicativeExprChild(instanceofExprChild);
        if (result == null) result = caseAdditiveExprChild(instanceofExprChild);
        if (result == null) result = caseRangeExprChild(instanceofExprChild);
        if (result == null) result = caseComparisonExprChild(instanceofExprChild);
        if (result == null) result = caseAndExprChild(instanceofExprChild);
        if (result == null) result = caseOrExprChild(instanceofExprChild);
        if (result == null) result = caseExprSingle(instanceofExprChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.TREAT_EXPR:
      {
        TreatExpr treatExpr = (TreatExpr)theEObject;
        T result = caseTreatExpr(treatExpr);
        if (result == null) result = caseInstanceofExprChild(treatExpr);
        if (result == null) result = caseIntersectExceptExprChild(treatExpr);
        if (result == null) result = caseUnionExprChild(treatExpr);
        if (result == null) result = caseMultiplicativeExprChild(treatExpr);
        if (result == null) result = caseAdditiveExprChild(treatExpr);
        if (result == null) result = caseRangeExprChild(treatExpr);
        if (result == null) result = caseComparisonExprChild(treatExpr);
        if (result == null) result = caseAndExprChild(treatExpr);
        if (result == null) result = caseOrExprChild(treatExpr);
        if (result == null) result = caseExprSingle(treatExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.TREAT_EXPR_CHILD:
      {
        TreatExprChild treatExprChild = (TreatExprChild)theEObject;
        T result = caseTreatExprChild(treatExprChild);
        if (result == null) result = caseInstanceofExprChild(treatExprChild);
        if (result == null) result = caseIntersectExceptExprChild(treatExprChild);
        if (result == null) result = caseUnionExprChild(treatExprChild);
        if (result == null) result = caseMultiplicativeExprChild(treatExprChild);
        if (result == null) result = caseAdditiveExprChild(treatExprChild);
        if (result == null) result = caseRangeExprChild(treatExprChild);
        if (result == null) result = caseComparisonExprChild(treatExprChild);
        if (result == null) result = caseAndExprChild(treatExprChild);
        if (result == null) result = caseOrExprChild(treatExprChild);
        if (result == null) result = caseExprSingle(treatExprChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.CASTABLE_EXPR:
      {
        CastableExpr castableExpr = (CastableExpr)theEObject;
        T result = caseCastableExpr(castableExpr);
        if (result == null) result = caseTreatExprChild(castableExpr);
        if (result == null) result = caseInstanceofExprChild(castableExpr);
        if (result == null) result = caseIntersectExceptExprChild(castableExpr);
        if (result == null) result = caseUnionExprChild(castableExpr);
        if (result == null) result = caseMultiplicativeExprChild(castableExpr);
        if (result == null) result = caseAdditiveExprChild(castableExpr);
        if (result == null) result = caseRangeExprChild(castableExpr);
        if (result == null) result = caseComparisonExprChild(castableExpr);
        if (result == null) result = caseAndExprChild(castableExpr);
        if (result == null) result = caseOrExprChild(castableExpr);
        if (result == null) result = caseExprSingle(castableExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.CASTABLE_EXPR_CHILD:
      {
        CastableExprChild castableExprChild = (CastableExprChild)theEObject;
        T result = caseCastableExprChild(castableExprChild);
        if (result == null) result = caseTreatExprChild(castableExprChild);
        if (result == null) result = caseInstanceofExprChild(castableExprChild);
        if (result == null) result = caseIntersectExceptExprChild(castableExprChild);
        if (result == null) result = caseUnionExprChild(castableExprChild);
        if (result == null) result = caseMultiplicativeExprChild(castableExprChild);
        if (result == null) result = caseAdditiveExprChild(castableExprChild);
        if (result == null) result = caseRangeExprChild(castableExprChild);
        if (result == null) result = caseComparisonExprChild(castableExprChild);
        if (result == null) result = caseAndExprChild(castableExprChild);
        if (result == null) result = caseOrExprChild(castableExprChild);
        if (result == null) result = caseExprSingle(castableExprChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.CAST_EXPR:
      {
        CastExpr castExpr = (CastExpr)theEObject;
        T result = caseCastExpr(castExpr);
        if (result == null) result = caseCastableExprChild(castExpr);
        if (result == null) result = caseTreatExprChild(castExpr);
        if (result == null) result = caseInstanceofExprChild(castExpr);
        if (result == null) result = caseIntersectExceptExprChild(castExpr);
        if (result == null) result = caseUnionExprChild(castExpr);
        if (result == null) result = caseMultiplicativeExprChild(castExpr);
        if (result == null) result = caseAdditiveExprChild(castExpr);
        if (result == null) result = caseRangeExprChild(castExpr);
        if (result == null) result = caseComparisonExprChild(castExpr);
        if (result == null) result = caseAndExprChild(castExpr);
        if (result == null) result = caseOrExprChild(castExpr);
        if (result == null) result = caseExprSingle(castExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.CAST_EXPR_CHILD:
      {
        CastExprChild castExprChild = (CastExprChild)theEObject;
        T result = caseCastExprChild(castExprChild);
        if (result == null) result = caseCastableExprChild(castExprChild);
        if (result == null) result = caseTreatExprChild(castExprChild);
        if (result == null) result = caseInstanceofExprChild(castExprChild);
        if (result == null) result = caseIntersectExceptExprChild(castExprChild);
        if (result == null) result = caseUnionExprChild(castExprChild);
        if (result == null) result = caseMultiplicativeExprChild(castExprChild);
        if (result == null) result = caseAdditiveExprChild(castExprChild);
        if (result == null) result = caseRangeExprChild(castExprChild);
        if (result == null) result = caseComparisonExprChild(castExprChild);
        if (result == null) result = caseAndExprChild(castExprChild);
        if (result == null) result = caseOrExprChild(castExprChild);
        if (result == null) result = caseExprSingle(castExprChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.UNARY_EXPR:
      {
        UnaryExpr unaryExpr = (UnaryExpr)theEObject;
        T result = caseUnaryExpr(unaryExpr);
        if (result == null) result = caseCastExprChild(unaryExpr);
        if (result == null) result = caseCastableExprChild(unaryExpr);
        if (result == null) result = caseTreatExprChild(unaryExpr);
        if (result == null) result = caseInstanceofExprChild(unaryExpr);
        if (result == null) result = caseIntersectExceptExprChild(unaryExpr);
        if (result == null) result = caseUnionExprChild(unaryExpr);
        if (result == null) result = caseMultiplicativeExprChild(unaryExpr);
        if (result == null) result = caseAdditiveExprChild(unaryExpr);
        if (result == null) result = caseRangeExprChild(unaryExpr);
        if (result == null) result = caseComparisonExprChild(unaryExpr);
        if (result == null) result = caseAndExprChild(unaryExpr);
        if (result == null) result = caseOrExprChild(unaryExpr);
        if (result == null) result = caseExprSingle(unaryExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.UNARY_EXPR_CHILD:
      {
        UnaryExprChild unaryExprChild = (UnaryExprChild)theEObject;
        T result = caseUnaryExprChild(unaryExprChild);
        if (result == null) result = caseCastExprChild(unaryExprChild);
        if (result == null) result = caseCastableExprChild(unaryExprChild);
        if (result == null) result = caseTreatExprChild(unaryExprChild);
        if (result == null) result = caseInstanceofExprChild(unaryExprChild);
        if (result == null) result = caseIntersectExceptExprChild(unaryExprChild);
        if (result == null) result = caseUnionExprChild(unaryExprChild);
        if (result == null) result = caseMultiplicativeExprChild(unaryExprChild);
        if (result == null) result = caseAdditiveExprChild(unaryExprChild);
        if (result == null) result = caseRangeExprChild(unaryExprChild);
        if (result == null) result = caseComparisonExprChild(unaryExprChild);
        if (result == null) result = caseAndExprChild(unaryExprChild);
        if (result == null) result = caseOrExprChild(unaryExprChild);
        if (result == null) result = caseExprSingle(unaryExprChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.VALUE_EXPR:
      {
        ValueExpr valueExpr = (ValueExpr)theEObject;
        T result = caseValueExpr(valueExpr);
        if (result == null) result = caseUnaryExprChild(valueExpr);
        if (result == null) result = caseCastExprChild(valueExpr);
        if (result == null) result = caseCastableExprChild(valueExpr);
        if (result == null) result = caseTreatExprChild(valueExpr);
        if (result == null) result = caseInstanceofExprChild(valueExpr);
        if (result == null) result = caseIntersectExceptExprChild(valueExpr);
        if (result == null) result = caseUnionExprChild(valueExpr);
        if (result == null) result = caseMultiplicativeExprChild(valueExpr);
        if (result == null) result = caseAdditiveExprChild(valueExpr);
        if (result == null) result = caseRangeExprChild(valueExpr);
        if (result == null) result = caseComparisonExprChild(valueExpr);
        if (result == null) result = caseAndExprChild(valueExpr);
        if (result == null) result = caseOrExprChild(valueExpr);
        if (result == null) result = caseExprSingle(valueExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.PATH_EXPR:
      {
        PathExpr pathExpr = (PathExpr)theEObject;
        T result = casePathExpr(pathExpr);
        if (result == null) result = caseValueExpr(pathExpr);
        if (result == null) result = caseUnaryExprChild(pathExpr);
        if (result == null) result = caseCastExprChild(pathExpr);
        if (result == null) result = caseCastableExprChild(pathExpr);
        if (result == null) result = caseTreatExprChild(pathExpr);
        if (result == null) result = caseInstanceofExprChild(pathExpr);
        if (result == null) result = caseIntersectExceptExprChild(pathExpr);
        if (result == null) result = caseUnionExprChild(pathExpr);
        if (result == null) result = caseMultiplicativeExprChild(pathExpr);
        if (result == null) result = caseAdditiveExprChild(pathExpr);
        if (result == null) result = caseRangeExprChild(pathExpr);
        if (result == null) result = caseComparisonExprChild(pathExpr);
        if (result == null) result = caseAndExprChild(pathExpr);
        if (result == null) result = caseOrExprChild(pathExpr);
        if (result == null) result = caseExprSingle(pathExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.SINGLE_PATH_EXPR:
      {
        SinglePathExpr singlePathExpr = (SinglePathExpr)theEObject;
        T result = caseSinglePathExpr(singlePathExpr);
        if (result == null) result = casePathExpr(singlePathExpr);
        if (result == null) result = caseValueExpr(singlePathExpr);
        if (result == null) result = caseUnaryExprChild(singlePathExpr);
        if (result == null) result = caseCastExprChild(singlePathExpr);
        if (result == null) result = caseCastableExprChild(singlePathExpr);
        if (result == null) result = caseTreatExprChild(singlePathExpr);
        if (result == null) result = caseInstanceofExprChild(singlePathExpr);
        if (result == null) result = caseIntersectExceptExprChild(singlePathExpr);
        if (result == null) result = caseUnionExprChild(singlePathExpr);
        if (result == null) result = caseMultiplicativeExprChild(singlePathExpr);
        if (result == null) result = caseAdditiveExprChild(singlePathExpr);
        if (result == null) result = caseRangeExprChild(singlePathExpr);
        if (result == null) result = caseComparisonExprChild(singlePathExpr);
        if (result == null) result = caseAndExprChild(singlePathExpr);
        if (result == null) result = caseOrExprChild(singlePathExpr);
        if (result == null) result = caseExprSingle(singlePathExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.DOUBLE_PATH_EXPR:
      {
        DoublePathExpr doublePathExpr = (DoublePathExpr)theEObject;
        T result = caseDoublePathExpr(doublePathExpr);
        if (result == null) result = casePathExpr(doublePathExpr);
        if (result == null) result = caseValueExpr(doublePathExpr);
        if (result == null) result = caseUnaryExprChild(doublePathExpr);
        if (result == null) result = caseCastExprChild(doublePathExpr);
        if (result == null) result = caseCastableExprChild(doublePathExpr);
        if (result == null) result = caseTreatExprChild(doublePathExpr);
        if (result == null) result = caseInstanceofExprChild(doublePathExpr);
        if (result == null) result = caseIntersectExceptExprChild(doublePathExpr);
        if (result == null) result = caseUnionExprChild(doublePathExpr);
        if (result == null) result = caseMultiplicativeExprChild(doublePathExpr);
        if (result == null) result = caseAdditiveExprChild(doublePathExpr);
        if (result == null) result = caseRangeExprChild(doublePathExpr);
        if (result == null) result = caseComparisonExprChild(doublePathExpr);
        if (result == null) result = caseAndExprChild(doublePathExpr);
        if (result == null) result = caseOrExprChild(doublePathExpr);
        if (result == null) result = caseExprSingle(doublePathExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.RELATIVE_PATH_EXPR:
      {
        RelativePathExpr relativePathExpr = (RelativePathExpr)theEObject;
        T result = caseRelativePathExpr(relativePathExpr);
        if (result == null) result = casePathExpr(relativePathExpr);
        if (result == null) result = caseValueExpr(relativePathExpr);
        if (result == null) result = caseUnaryExprChild(relativePathExpr);
        if (result == null) result = caseCastExprChild(relativePathExpr);
        if (result == null) result = caseCastableExprChild(relativePathExpr);
        if (result == null) result = caseTreatExprChild(relativePathExpr);
        if (result == null) result = caseInstanceofExprChild(relativePathExpr);
        if (result == null) result = caseIntersectExceptExprChild(relativePathExpr);
        if (result == null) result = caseUnionExprChild(relativePathExpr);
        if (result == null) result = caseMultiplicativeExprChild(relativePathExpr);
        if (result == null) result = caseAdditiveExprChild(relativePathExpr);
        if (result == null) result = caseRangeExprChild(relativePathExpr);
        if (result == null) result = caseComparisonExprChild(relativePathExpr);
        if (result == null) result = caseAndExprChild(relativePathExpr);
        if (result == null) result = caseOrExprChild(relativePathExpr);
        if (result == null) result = caseExprSingle(relativePathExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.STEP_EXPR:
      {
        StepExpr stepExpr = (StepExpr)theEObject;
        T result = caseStepExpr(stepExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.TAIL_PATH_EXPR:
      {
        TailPathExpr tailPathExpr = (TailPathExpr)theEObject;
        T result = caseTailPathExpr(tailPathExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.SINGLE_TAIL_PATH_EXPR:
      {
        SingleTailPathExpr singleTailPathExpr = (SingleTailPathExpr)theEObject;
        T result = caseSingleTailPathExpr(singleTailPathExpr);
        if (result == null) result = caseTailPathExpr(singleTailPathExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.DOUBLE_TAIL_PATH_EXPR:
      {
        DoubleTailPathExpr doubleTailPathExpr = (DoubleTailPathExpr)theEObject;
        T result = caseDoubleTailPathExpr(doubleTailPathExpr);
        if (result == null) result = caseTailPathExpr(doubleTailPathExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.FILTER_EXPR:
      {
        FilterExpr filterExpr = (FilterExpr)theEObject;
        T result = caseFilterExpr(filterExpr);
        if (result == null) result = caseStepExpr(filterExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.AXIS_STEP:
      {
        AxisStep axisStep = (AxisStep)theEObject;
        T result = caseAxisStep(axisStep);
        if (result == null) result = caseStepExpr(axisStep);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.DIRECTIONAL_STEP:
      {
        DirectionalStep directionalStep = (DirectionalStep)theEObject;
        T result = caseDirectionalStep(directionalStep);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.FORWARD_STEP:
      {
        ForwardStep forwardStep = (ForwardStep)theEObject;
        T result = caseForwardStep(forwardStep);
        if (result == null) result = caseDirectionalStep(forwardStep);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.REVERSE_STEP:
      {
        ReverseStep reverseStep = (ReverseStep)theEObject;
        T result = caseReverseStep(reverseStep);
        if (result == null) result = caseDirectionalStep(reverseStep);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.GENERAL_FORWARD_STEP:
      {
        GeneralForwardStep generalForwardStep = (GeneralForwardStep)theEObject;
        T result = caseGeneralForwardStep(generalForwardStep);
        if (result == null) result = caseForwardStep(generalForwardStep);
        if (result == null) result = caseDirectionalStep(generalForwardStep);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.ABBREV_FORWARD_STEP:
      {
        AbbrevForwardStep abbrevForwardStep = (AbbrevForwardStep)theEObject;
        T result = caseAbbrevForwardStep(abbrevForwardStep);
        if (result == null) result = caseForwardStep(abbrevForwardStep);
        if (result == null) result = caseDirectionalStep(abbrevForwardStep);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.FORWARD_AXIS:
      {
        ForwardAxis forwardAxis = (ForwardAxis)theEObject;
        T result = caseForwardAxis(forwardAxis);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.GENERAL_REVERSE_STEP:
      {
        GeneralReverseStep generalReverseStep = (GeneralReverseStep)theEObject;
        T result = caseGeneralReverseStep(generalReverseStep);
        if (result == null) result = caseReverseStep(generalReverseStep);
        if (result == null) result = caseDirectionalStep(generalReverseStep);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.ABBREV_REVERSE_STEP:
      {
        AbbrevReverseStep abbrevReverseStep = (AbbrevReverseStep)theEObject;
        T result = caseAbbrevReverseStep(abbrevReverseStep);
        if (result == null) result = caseReverseStep(abbrevReverseStep);
        if (result == null) result = caseDirectionalStep(abbrevReverseStep);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.REVERSE_AXIS:
      {
        ReverseAxis reverseAxis = (ReverseAxis)theEObject;
        T result = caseReverseAxis(reverseAxis);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.NODE_TEST:
      {
        NodeTest nodeTest = (NodeTest)theEObject;
        T result = caseNodeTest(nodeTest);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.NODE_KIND_TEST:
      {
        NodeKindTest nodeKindTest = (NodeKindTest)theEObject;
        T result = caseNodeKindTest(nodeKindTest);
        if (result == null) result = caseNodeTest(nodeKindTest);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.NAME_TEST:
      {
        NameTest nameTest = (NameTest)theEObject;
        T result = caseNameTest(nameTest);
        if (result == null) result = caseNodeTest(nameTest);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.QNAME_TEST:
      {
        QNameTest qNameTest = (QNameTest)theEObject;
        T result = caseQNameTest(qNameTest);
        if (result == null) result = caseNameTest(qNameTest);
        if (result == null) result = caseNodeTest(qNameTest);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.WILDCARD:
      {
        Wildcard wildcard = (Wildcard)theEObject;
        T result = caseWildcard(wildcard);
        if (result == null) result = caseNameTest(wildcard);
        if (result == null) result = caseNodeTest(wildcard);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.ANY_WILDCARD:
      {
        AnyWildcard anyWildcard = (AnyWildcard)theEObject;
        T result = caseAnyWildcard(anyWildcard);
        if (result == null) result = caseWildcard(anyWildcard);
        if (result == null) result = caseNameTest(anyWildcard);
        if (result == null) result = caseNodeTest(anyWildcard);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.LOCAL_NAME_WILDCARD:
      {
        LocalNameWildcard localNameWildcard = (LocalNameWildcard)theEObject;
        T result = caseLocalNameWildcard(localNameWildcard);
        if (result == null) result = caseWildcard(localNameWildcard);
        if (result == null) result = caseNameTest(localNameWildcard);
        if (result == null) result = caseNodeTest(localNameWildcard);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.NAMESPACE_WILDCARD:
      {
        NamespaceWildcard namespaceWildcard = (NamespaceWildcard)theEObject;
        T result = caseNamespaceWildcard(namespaceWildcard);
        if (result == null) result = caseWildcard(namespaceWildcard);
        if (result == null) result = caseNameTest(namespaceWildcard);
        if (result == null) result = caseNodeTest(namespaceWildcard);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.PREDICATE:
      {
        Predicate predicate = (Predicate)theEObject;
        T result = casePredicate(predicate);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.PRIMARY_EXPR:
      {
        PrimaryExpr primaryExpr = (PrimaryExpr)theEObject;
        T result = casePrimaryExpr(primaryExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.LITERAL:
      {
        Literal literal = (Literal)theEObject;
        T result = caseLiteral(literal);
        if (result == null) result = casePrimaryExpr(literal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.VAR_REF:
      {
        VarRef varRef = (VarRef)theEObject;
        T result = caseVarRef(varRef);
        if (result == null) result = casePrimaryExpr(varRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.VAR_NAME:
      {
        VarName varName = (VarName)theEObject;
        T result = caseVarName(varName);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.PARENTHESIZED_EXPR:
      {
        ParenthesizedExpr parenthesizedExpr = (ParenthesizedExpr)theEObject;
        T result = caseParenthesizedExpr(parenthesizedExpr);
        if (result == null) result = casePrimaryExpr(parenthesizedExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.CONTEXT_ITEM_EXPR:
      {
        ContextItemExpr contextItemExpr = (ContextItemExpr)theEObject;
        T result = caseContextItemExpr(contextItemExpr);
        if (result == null) result = casePrimaryExpr(contextItemExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.FUNCTION_CALL:
      {
        FunctionCall functionCall = (FunctionCall)theEObject;
        T result = caseFunctionCall(functionCall);
        if (result == null) result = casePrimaryExpr(functionCall);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.NUMERIC_LITERAL:
      {
        NumericLiteral numericLiteral = (NumericLiteral)theEObject;
        T result = caseNumericLiteral(numericLiteral);
        if (result == null) result = caseLiteral(numericLiteral);
        if (result == null) result = casePrimaryExpr(numericLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.STRING_LITERAL:
      {
        StringLiteral stringLiteral = (StringLiteral)theEObject;
        T result = caseStringLiteral(stringLiteral);
        if (result == null) result = caseLiteral(stringLiteral);
        if (result == null) result = casePrimaryExpr(stringLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.INTEGER_LITERAL:
      {
        IntegerLiteral integerLiteral = (IntegerLiteral)theEObject;
        T result = caseIntegerLiteral(integerLiteral);
        if (result == null) result = caseNumericLiteral(integerLiteral);
        if (result == null) result = caseLiteral(integerLiteral);
        if (result == null) result = casePrimaryExpr(integerLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.DECIMAL_LITERAL:
      {
        DecimalLiteral decimalLiteral = (DecimalLiteral)theEObject;
        T result = caseDecimalLiteral(decimalLiteral);
        if (result == null) result = caseNumericLiteral(decimalLiteral);
        if (result == null) result = caseLiteral(decimalLiteral);
        if (result == null) result = casePrimaryExpr(decimalLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.DOUBLE_LITERAL:
      {
        DoubleLiteral doubleLiteral = (DoubleLiteral)theEObject;
        T result = caseDoubleLiteral(doubleLiteral);
        if (result == null) result = caseNumericLiteral(doubleLiteral);
        if (result == null) result = caseLiteral(doubleLiteral);
        if (result == null) result = casePrimaryExpr(doubleLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.COMP:
      {
        Comp comp = (Comp)theEObject;
        T result = caseComp(comp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.GENERAL_COMP:
      {
        GeneralComp generalComp = (GeneralComp)theEObject;
        T result = caseGeneralComp(generalComp);
        if (result == null) result = caseComp(generalComp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.VALUE_COMP:
      {
        ValueComp valueComp = (ValueComp)theEObject;
        T result = caseValueComp(valueComp);
        if (result == null) result = caseComp(valueComp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.NODE_COMP:
      {
        NodeComp nodeComp = (NodeComp)theEObject;
        T result = caseNodeComp(nodeComp);
        if (result == null) result = caseComp(nodeComp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.SINGLE_TYPE:
      {
        SingleType singleType = (SingleType)theEObject;
        T result = caseSingleType(singleType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.ATOMIC_TYPE:
      {
        AtomicType atomicType = (AtomicType)theEObject;
        T result = caseAtomicType(atomicType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.SEQUENCE_TYPE:
      {
        SequenceType sequenceType = (SequenceType)theEObject;
        T result = caseSequenceType(sequenceType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.EMPTY_SEQUENCE_TYPE:
      {
        EmptySequenceType emptySequenceType = (EmptySequenceType)theEObject;
        T result = caseEmptySequenceType(emptySequenceType);
        if (result == null) result = caseSequenceType(emptySequenceType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.ITEM_SEQUENCE_TYPE:
      {
        ItemSequenceType itemSequenceType = (ItemSequenceType)theEObject;
        T result = caseItemSequenceType(itemSequenceType);
        if (result == null) result = caseSequenceType(itemSequenceType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.ITEM_TYPE:
      {
        ItemType itemType = (ItemType)theEObject;
        T result = caseItemType(itemType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.ITEM_KIND_TEST:
      {
        ItemKindTest itemKindTest = (ItemKindTest)theEObject;
        T result = caseItemKindTest(itemKindTest);
        if (result == null) result = caseItemType(itemKindTest);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.ANY_ITEM_TYPE:
      {
        AnyItemType anyItemType = (AnyItemType)theEObject;
        T result = caseAnyItemType(anyItemType);
        if (result == null) result = caseItemType(anyItemType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.ATOMIC_ITEM_TYPE:
      {
        AtomicItemType atomicItemType = (AtomicItemType)theEObject;
        T result = caseAtomicItemType(atomicItemType);
        if (result == null) result = caseItemType(atomicItemType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.KIND_TEST:
      {
        KindTest kindTest = (KindTest)theEObject;
        T result = caseKindTest(kindTest);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.DOCUMENT_TEST:
      {
        DocumentTest documentTest = (DocumentTest)theEObject;
        T result = caseDocumentTest(documentTest);
        if (result == null) result = caseKindTest(documentTest);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.ELEMENT_TEST:
      {
        ElementTest elementTest = (ElementTest)theEObject;
        T result = caseElementTest(elementTest);
        if (result == null) result = caseKindTest(elementTest);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.NAME_ELEMENT_TEST:
      {
        NameElementTest nameElementTest = (NameElementTest)theEObject;
        T result = caseNameElementTest(nameElementTest);
        if (result == null) result = caseElementTest(nameElementTest);
        if (result == null) result = caseKindTest(nameElementTest);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.WILDCARD_ELEMENT_TEST:
      {
        WildcardElementTest wildcardElementTest = (WildcardElementTest)theEObject;
        T result = caseWildcardElementTest(wildcardElementTest);
        if (result == null) result = caseElementTest(wildcardElementTest);
        if (result == null) result = caseKindTest(wildcardElementTest);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.ATTRIBUTE_TEST:
      {
        AttributeTest attributeTest = (AttributeTest)theEObject;
        T result = caseAttributeTest(attributeTest);
        if (result == null) result = caseKindTest(attributeTest);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.NAME_ATTRIBUTE_TEST:
      {
        NameAttributeTest nameAttributeTest = (NameAttributeTest)theEObject;
        T result = caseNameAttributeTest(nameAttributeTest);
        if (result == null) result = caseAttributeTest(nameAttributeTest);
        if (result == null) result = caseKindTest(nameAttributeTest);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.WILDCARD_ATTRIBUTE_TEST:
      {
        WildcardAttributeTest wildcardAttributeTest = (WildcardAttributeTest)theEObject;
        T result = caseWildcardAttributeTest(wildcardAttributeTest);
        if (result == null) result = caseAttributeTest(wildcardAttributeTest);
        if (result == null) result = caseKindTest(wildcardAttributeTest);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.SCHEMA_ELEMENT_TEST:
      {
        SchemaElementTest schemaElementTest = (SchemaElementTest)theEObject;
        T result = caseSchemaElementTest(schemaElementTest);
        if (result == null) result = caseKindTest(schemaElementTest);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.SCHEMA_ATTRIBUTE_TEST:
      {
        SchemaAttributeTest schemaAttributeTest = (SchemaAttributeTest)theEObject;
        T result = caseSchemaAttributeTest(schemaAttributeTest);
        if (result == null) result = caseKindTest(schemaAttributeTest);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.PI_TEST:
      {
        PITest piTest = (PITest)theEObject;
        T result = casePITest(piTest);
        if (result == null) result = caseKindTest(piTest);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.NC_NAME_PI_TEST:
      {
        NCNamePITest ncNamePITest = (NCNamePITest)theEObject;
        T result = caseNCNamePITest(ncNamePITest);
        if (result == null) result = casePITest(ncNamePITest);
        if (result == null) result = caseKindTest(ncNamePITest);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.STRING_LITERAL_PI_TEST:
      {
        StringLiteralPITest stringLiteralPITest = (StringLiteralPITest)theEObject;
        T result = caseStringLiteralPITest(stringLiteralPITest);
        if (result == null) result = casePITest(stringLiteralPITest);
        if (result == null) result = caseKindTest(stringLiteralPITest);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.COMMENT_TEST:
      {
        CommentTest commentTest = (CommentTest)theEObject;
        T result = caseCommentTest(commentTest);
        if (result == null) result = caseKindTest(commentTest);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.TEXT_TEST:
      {
        TextTest textTest = (TextTest)theEObject;
        T result = caseTextTest(textTest);
        if (result == null) result = caseKindTest(textTest);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.ANY_KIND_TEST:
      {
        AnyKindTest anyKindTest = (AnyKindTest)theEObject;
        T result = caseAnyKindTest(anyKindTest);
        if (result == null) result = caseKindTest(anyKindTest);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.COMMENT:
      {
        Comment comment = (Comment)theEObject;
        T result = caseComment(comment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.QNAME:
      {
        QName qName = (QName)theEObject;
        T result = caseQName(qName);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Expr</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseExpr(Expr object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Expr Single</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expr Single</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseExprSingle(ExprSingle object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>For Expr</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>For Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseForExpr(ForExpr object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Quantified Expr</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Quantified Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseQuantifiedExpr(QuantifiedExpr object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>If Expr</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>If Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseIfExpr(IfExpr object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Simple For Clause</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Simple For Clause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseSimpleForClause(SimpleForClause object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Simple For Clause Iterator</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Simple For Clause Iterator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseSimpleForClauseIterator(SimpleForClauseIterator object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Or Expr</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Or Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseOrExpr(OrExpr object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Or Expr Child</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Or Expr Child</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseOrExprChild(OrExprChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>And Expr</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>And Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseAndExpr(AndExpr object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>And Expr Child</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>And Expr Child</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseAndExprChild(AndExprChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Comparison Expr</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Comparison Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseComparisonExpr(ComparisonExpr object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Comparison Expr Child</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Comparison Expr Child</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseComparisonExprChild(ComparisonExprChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Range Expr</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Range Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseRangeExpr(RangeExpr object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Range Expr Child</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Range Expr Child</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseRangeExprChild(RangeExprChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Additive Expr</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Additive Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseAdditiveExpr(AdditiveExpr object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Additive Expr Child</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Additive Expr Child</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseAdditiveExprChild(AdditiveExprChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Multiplicative Expr</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Multiplicative Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseMultiplicativeExpr(MultiplicativeExpr object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Multiplicative Expr Child</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Multiplicative Expr Child</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseMultiplicativeExprChild(MultiplicativeExprChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Union Expr</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Union Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseUnionExpr(UnionExpr object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Union Expr Child</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Union Expr Child</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseUnionExprChild(UnionExprChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Intersect Except Expr</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Intersect Except Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseIntersectExceptExpr(IntersectExceptExpr object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Intersect Except Expr Child</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Intersect Except Expr Child</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseIntersectExceptExprChild(IntersectExceptExprChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Instanceof Expr</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Instanceof Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseInstanceofExpr(InstanceofExpr object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Instanceof Expr Child</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Instanceof Expr Child</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseInstanceofExprChild(InstanceofExprChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Treat Expr</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Treat Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseTreatExpr(TreatExpr object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Treat Expr Child</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Treat Expr Child</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseTreatExprChild(TreatExprChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Castable Expr</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Castable Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseCastableExpr(CastableExpr object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Castable Expr Child</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Castable Expr Child</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseCastableExprChild(CastableExprChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Cast Expr</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Cast Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseCastExpr(CastExpr object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Cast Expr Child</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Cast Expr Child</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseCastExprChild(CastExprChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Unary Expr</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unary Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseUnaryExpr(UnaryExpr object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Unary Expr Child</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unary Expr Child</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseUnaryExprChild(UnaryExprChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Value Expr</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Value Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseValueExpr(ValueExpr object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Path Expr</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Path Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T casePathExpr(PathExpr object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Single Path Expr</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Single Path Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseSinglePathExpr(SinglePathExpr object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Double Path Expr</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Double Path Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseDoublePathExpr(DoublePathExpr object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Relative Path Expr</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Relative Path Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseRelativePathExpr(RelativePathExpr object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Step Expr</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Step Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseStepExpr(StepExpr object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Tail Path Expr</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tail Path Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseTailPathExpr(TailPathExpr object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Single Tail Path Expr</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Single Tail Path Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseSingleTailPathExpr(SingleTailPathExpr object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Double Tail Path Expr</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Double Tail Path Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseDoubleTailPathExpr(DoubleTailPathExpr object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Filter Expr</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Filter Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseFilterExpr(FilterExpr object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Axis Step</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Axis Step</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseAxisStep(AxisStep object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Directional Step</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Directional Step</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseDirectionalStep(DirectionalStep object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Forward Step</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Forward Step</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseForwardStep(ForwardStep object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Reverse Step</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Reverse Step</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseReverseStep(ReverseStep object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>General Forward Step</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>General Forward Step</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseGeneralForwardStep(GeneralForwardStep object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Abbrev Forward Step</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abbrev Forward Step</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseAbbrevForwardStep(AbbrevForwardStep object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Forward Axis</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Forward Axis</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseForwardAxis(ForwardAxis object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>General Reverse Step</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>General Reverse Step</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseGeneralReverseStep(GeneralReverseStep object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Abbrev Reverse Step</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abbrev Reverse Step</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseAbbrevReverseStep(AbbrevReverseStep object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Reverse Axis</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Reverse Axis</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseReverseAxis(ReverseAxis object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Node Test</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Node Test</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseNodeTest(NodeTest object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Node Kind Test</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Node Kind Test</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseNodeKindTest(NodeKindTest object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Name Test</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Name Test</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseNameTest(NameTest object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>QName Test</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>QName Test</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseQNameTest(QNameTest object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Wildcard</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Wildcard</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseWildcard(Wildcard object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Any Wildcard</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Any Wildcard</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseAnyWildcard(AnyWildcard object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Local Name Wildcard</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Local Name Wildcard</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseLocalNameWildcard(LocalNameWildcard object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Namespace Wildcard</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Namespace Wildcard</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseNamespaceWildcard(NamespaceWildcard object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Predicate</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Predicate</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T casePredicate(Predicate object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Primary Expr</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Primary Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T casePrimaryExpr(PrimaryExpr object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Literal</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseLiteral(Literal object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Var Ref</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Var Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseVarRef(VarRef object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Var Name</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Var Name</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseVarName(VarName object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Parenthesized Expr</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parenthesized Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseParenthesizedExpr(ParenthesizedExpr object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Context Item Expr</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Context Item Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseContextItemExpr(ContextItemExpr object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Function Call</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Function Call</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseFunctionCall(FunctionCall object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Numeric Literal</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Numeric Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseNumericLiteral(NumericLiteral object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>String Literal</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseStringLiteral(StringLiteral object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Integer Literal</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Integer Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseIntegerLiteral(IntegerLiteral object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Decimal Literal</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Decimal Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseDecimalLiteral(DecimalLiteral object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Double Literal</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Double Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseDoubleLiteral(DoubleLiteral object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Comp</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Comp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseComp(Comp object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>General Comp</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>General Comp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseGeneralComp(GeneralComp object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Value Comp</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Value Comp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseValueComp(ValueComp object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Node Comp</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Node Comp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseNodeComp(NodeComp object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Single Type</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Single Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseSingleType(SingleType object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Atomic Type</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Atomic Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseAtomicType(AtomicType object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Sequence Type</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sequence Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseSequenceType(SequenceType object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Empty Sequence Type</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Empty Sequence Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseEmptySequenceType(EmptySequenceType object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Item Sequence Type</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Item Sequence Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseItemSequenceType(ItemSequenceType object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Item Type</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Item Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseItemType(ItemType object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Item Kind Test</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Item Kind Test</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseItemKindTest(ItemKindTest object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Any Item Type</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Any Item Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseAnyItemType(AnyItemType object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Atomic Item Type</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Atomic Item Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseAtomicItemType(AtomicItemType object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Kind Test</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Kind Test</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseKindTest(KindTest object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Document Test</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Document Test</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseDocumentTest(DocumentTest object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Element Test</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Element Test</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseElementTest(ElementTest object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Name Element Test</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Name Element Test</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseNameElementTest(NameElementTest object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Wildcard Element Test</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Wildcard Element Test</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseWildcardElementTest(WildcardElementTest object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Attribute Test</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute Test</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseAttributeTest(AttributeTest object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Name Attribute Test</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Name Attribute Test</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseNameAttributeTest(NameAttributeTest object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Wildcard Attribute Test</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Wildcard Attribute Test</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseWildcardAttributeTest(WildcardAttributeTest object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Schema Element Test</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Schema Element Test</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseSchemaElementTest(SchemaElementTest object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Schema Attribute Test</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Schema Attribute Test</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseSchemaAttributeTest(SchemaAttributeTest object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>PI Test</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>PI Test</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T casePITest(PITest object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>NC Name PI Test</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>NC Name PI Test</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseNCNamePITest(NCNamePITest object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>String Literal PI Test</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String Literal PI Test</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseStringLiteralPITest(StringLiteralPITest object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Comment Test</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Comment Test</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseCommentTest(CommentTest object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Text Test</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Text Test</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseTextTest(TextTest object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Any Kind Test</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Any Kind Test</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseAnyKindTest(AnyKindTest object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Comment</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Comment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseComment(Comment object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>QName</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>QName</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseQName(QName object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
	@Override
	public T defaultCase(EObject object) {
    return null;
  }

} //Xpath2Switch
