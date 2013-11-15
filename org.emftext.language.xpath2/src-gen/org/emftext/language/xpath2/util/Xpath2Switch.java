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
      case Xpath2Package.ANY_EXPR:
      {
        AnyExpr anyExpr = (AnyExpr)theEObject;
        T result = caseAnyExpr(anyExpr);
        if (result == null) result = caseParenthesizedExprChild(anyExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.EXPR:
      {
        Expr expr = (Expr)theEObject;
        T result = caseExpr(expr);
        if (result == null) result = caseAnyExpr(expr);
        if (result == null) result = caseParenthesizedExprChild(expr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.EXPR_SINGLE:
      {
        ExprSingle exprSingle = (ExprSingle)theEObject;
        T result = caseExprSingle(exprSingle);
        if (result == null) result = caseAnyExpr(exprSingle);
        if (result == null) result = caseParenthesizedExprChild(exprSingle);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.FOR_EXPR:
      {
        ForExpr forExpr = (ForExpr)theEObject;
        T result = caseForExpr(forExpr);
        if (result == null) result = caseExprSingle(forExpr);
        if (result == null) result = caseAnyExpr(forExpr);
        if (result == null) result = caseParenthesizedExprChild(forExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.QUANTIFIED_EXPR:
      {
        QuantifiedExpr quantifiedExpr = (QuantifiedExpr)theEObject;
        T result = caseQuantifiedExpr(quantifiedExpr);
        if (result == null) result = caseExprSingle(quantifiedExpr);
        if (result == null) result = caseAnyExpr(quantifiedExpr);
        if (result == null) result = caseParenthesizedExprChild(quantifiedExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.IF_EXPR:
      {
        IfExpr ifExpr = (IfExpr)theEObject;
        T result = caseIfExpr(ifExpr);
        if (result == null) result = caseExprSingle(ifExpr);
        if (result == null) result = caseAnyExpr(ifExpr);
        if (result == null) result = caseParenthesizedExprChild(ifExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.ITERATOR:
      {
        Iterator iterator = (Iterator)theEObject;
        T result = caseIterator(iterator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.OR_EXPR:
      {
        OrExpr orExpr = (OrExpr)theEObject;
        T result = caseOrExpr(orExpr);
        if (result == null) result = caseExprSingle(orExpr);
        if (result == null) result = caseAnyExpr(orExpr);
        if (result == null) result = caseParenthesizedExprChild(orExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.OR_EXPR_CHILD:
      {
        OrExprChild orExprChild = (OrExprChild)theEObject;
        T result = caseOrExprChild(orExprChild);
        if (result == null) result = caseExprSingle(orExprChild);
        if (result == null) result = caseAnyExpr(orExprChild);
        if (result == null) result = caseParenthesizedExprChild(orExprChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.AND_EXPR:
      {
        AndExpr andExpr = (AndExpr)theEObject;
        T result = caseAndExpr(andExpr);
        if (result == null) result = caseOrExprChild(andExpr);
        if (result == null) result = caseExprSingle(andExpr);
        if (result == null) result = caseAnyExpr(andExpr);
        if (result == null) result = caseParenthesizedExprChild(andExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.AND_EXPR_CHILD:
      {
        AndExprChild andExprChild = (AndExprChild)theEObject;
        T result = caseAndExprChild(andExprChild);
        if (result == null) result = caseOrExprChild(andExprChild);
        if (result == null) result = caseExprSingle(andExprChild);
        if (result == null) result = caseAnyExpr(andExprChild);
        if (result == null) result = caseParenthesizedExprChild(andExprChild);
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
        if (result == null) result = caseAnyExpr(comparisonExpr);
        if (result == null) result = caseParenthesizedExprChild(comparisonExpr);
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
        if (result == null) result = caseAnyExpr(comparisonExprChild);
        if (result == null) result = caseParenthesizedExprChild(comparisonExprChild);
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
        if (result == null) result = caseAnyExpr(rangeExpr);
        if (result == null) result = caseParenthesizedExprChild(rangeExpr);
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
        if (result == null) result = caseAnyExpr(rangeExprChild);
        if (result == null) result = caseParenthesizedExprChild(rangeExprChild);
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
        if (result == null) result = caseAnyExpr(additiveExpr);
        if (result == null) result = caseParenthesizedExprChild(additiveExpr);
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
        if (result == null) result = caseAnyExpr(additiveExprChild);
        if (result == null) result = caseParenthesizedExprChild(additiveExprChild);
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
        if (result == null) result = caseAnyExpr(multiplicativeExpr);
        if (result == null) result = caseParenthesizedExprChild(multiplicativeExpr);
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
        if (result == null) result = caseAnyExpr(multiplicativeExprChild);
        if (result == null) result = caseParenthesizedExprChild(multiplicativeExprChild);
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
        if (result == null) result = caseAnyExpr(unionExpr);
        if (result == null) result = caseParenthesizedExprChild(unionExpr);
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
        if (result == null) result = caseAnyExpr(unionExprChild);
        if (result == null) result = caseParenthesizedExprChild(unionExprChild);
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
        if (result == null) result = caseAnyExpr(intersectExceptExpr);
        if (result == null) result = caseParenthesizedExprChild(intersectExceptExpr);
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
        if (result == null) result = caseAnyExpr(intersectExceptExprChild);
        if (result == null) result = caseParenthesizedExprChild(intersectExceptExprChild);
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
        if (result == null) result = caseAnyExpr(instanceofExpr);
        if (result == null) result = caseParenthesizedExprChild(instanceofExpr);
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
        if (result == null) result = caseAnyExpr(instanceofExprChild);
        if (result == null) result = caseParenthesizedExprChild(instanceofExprChild);
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
        if (result == null) result = caseAnyExpr(treatExpr);
        if (result == null) result = caseParenthesizedExprChild(treatExpr);
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
        if (result == null) result = caseAnyExpr(treatExprChild);
        if (result == null) result = caseParenthesizedExprChild(treatExprChild);
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
        if (result == null) result = caseAnyExpr(castableExpr);
        if (result == null) result = caseParenthesizedExprChild(castableExpr);
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
        if (result == null) result = caseAnyExpr(castableExprChild);
        if (result == null) result = caseParenthesizedExprChild(castableExprChild);
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
        if (result == null) result = caseAnyExpr(castExpr);
        if (result == null) result = caseParenthesizedExprChild(castExpr);
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
        if (result == null) result = caseAnyExpr(castExprChild);
        if (result == null) result = caseParenthesizedExprChild(castExprChild);
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
        if (result == null) result = caseAnyExpr(unaryExpr);
        if (result == null) result = caseParenthesizedExprChild(unaryExpr);
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
        if (result == null) result = caseAnyExpr(unaryExprChild);
        if (result == null) result = caseParenthesizedExprChild(unaryExprChild);
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
        if (result == null) result = caseAnyExpr(valueExpr);
        if (result == null) result = caseParenthesizedExprChild(valueExpr);
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
        if (result == null) result = caseAnyExpr(pathExpr);
        if (result == null) result = caseParenthesizedExprChild(pathExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.PATH_EXPR_CHILD:
      {
        PathExprChild pathExprChild = (PathExprChild)theEObject;
        T result = casePathExprChild(pathExprChild);
        if (result == null) result = caseUnaryExprChild(pathExprChild);
        if (result == null) result = caseCastExprChild(pathExprChild);
        if (result == null) result = caseCastableExprChild(pathExprChild);
        if (result == null) result = caseTreatExprChild(pathExprChild);
        if (result == null) result = caseInstanceofExprChild(pathExprChild);
        if (result == null) result = caseIntersectExceptExprChild(pathExprChild);
        if (result == null) result = caseUnionExprChild(pathExprChild);
        if (result == null) result = caseMultiplicativeExprChild(pathExprChild);
        if (result == null) result = caseAdditiveExprChild(pathExprChild);
        if (result == null) result = caseRangeExprChild(pathExprChild);
        if (result == null) result = caseComparisonExprChild(pathExprChild);
        if (result == null) result = caseAndExprChild(pathExprChild);
        if (result == null) result = caseOrExprChild(pathExprChild);
        if (result == null) result = caseExprSingle(pathExprChild);
        if (result == null) result = caseAnyExpr(pathExprChild);
        if (result == null) result = caseParenthesizedExprChild(pathExprChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.ROOT_STEP_EXPR:
      {
        RootStepExpr rootStepExpr = (RootStepExpr)theEObject;
        T result = caseRootStepExpr(rootStepExpr);
        if (result == null) result = casePathExprChild(rootStepExpr);
        if (result == null) result = caseUnaryExprChild(rootStepExpr);
        if (result == null) result = caseCastExprChild(rootStepExpr);
        if (result == null) result = caseCastableExprChild(rootStepExpr);
        if (result == null) result = caseTreatExprChild(rootStepExpr);
        if (result == null) result = caseInstanceofExprChild(rootStepExpr);
        if (result == null) result = caseIntersectExceptExprChild(rootStepExpr);
        if (result == null) result = caseUnionExprChild(rootStepExpr);
        if (result == null) result = caseMultiplicativeExprChild(rootStepExpr);
        if (result == null) result = caseAdditiveExprChild(rootStepExpr);
        if (result == null) result = caseRangeExprChild(rootStepExpr);
        if (result == null) result = caseComparisonExprChild(rootStepExpr);
        if (result == null) result = caseAndExprChild(rootStepExpr);
        if (result == null) result = caseOrExprChild(rootStepExpr);
        if (result == null) result = caseExprSingle(rootStepExpr);
        if (result == null) result = caseAnyExpr(rootStepExpr);
        if (result == null) result = caseParenthesizedExprChild(rootStepExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.CHILD_STEP_EXPR:
      {
        ChildStepExpr childStepExpr = (ChildStepExpr)theEObject;
        T result = caseChildStepExpr(childStepExpr);
        if (result == null) result = casePathExprChild(childStepExpr);
        if (result == null) result = caseUnaryExprChild(childStepExpr);
        if (result == null) result = caseCastExprChild(childStepExpr);
        if (result == null) result = caseCastableExprChild(childStepExpr);
        if (result == null) result = caseTreatExprChild(childStepExpr);
        if (result == null) result = caseInstanceofExprChild(childStepExpr);
        if (result == null) result = caseIntersectExceptExprChild(childStepExpr);
        if (result == null) result = caseUnionExprChild(childStepExpr);
        if (result == null) result = caseMultiplicativeExprChild(childStepExpr);
        if (result == null) result = caseAdditiveExprChild(childStepExpr);
        if (result == null) result = caseRangeExprChild(childStepExpr);
        if (result == null) result = caseComparisonExprChild(childStepExpr);
        if (result == null) result = caseAndExprChild(childStepExpr);
        if (result == null) result = caseOrExprChild(childStepExpr);
        if (result == null) result = caseExprSingle(childStepExpr);
        if (result == null) result = caseAnyExpr(childStepExpr);
        if (result == null) result = caseParenthesizedExprChild(childStepExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.DESC_OR_SELF_STEP_EXPR:
      {
        DescOrSelfStepExpr descOrSelfStepExpr = (DescOrSelfStepExpr)theEObject;
        T result = caseDescOrSelfStepExpr(descOrSelfStepExpr);
        if (result == null) result = casePathExprChild(descOrSelfStepExpr);
        if (result == null) result = caseUnaryExprChild(descOrSelfStepExpr);
        if (result == null) result = caseCastExprChild(descOrSelfStepExpr);
        if (result == null) result = caseCastableExprChild(descOrSelfStepExpr);
        if (result == null) result = caseTreatExprChild(descOrSelfStepExpr);
        if (result == null) result = caseInstanceofExprChild(descOrSelfStepExpr);
        if (result == null) result = caseIntersectExceptExprChild(descOrSelfStepExpr);
        if (result == null) result = caseUnionExprChild(descOrSelfStepExpr);
        if (result == null) result = caseMultiplicativeExprChild(descOrSelfStepExpr);
        if (result == null) result = caseAdditiveExprChild(descOrSelfStepExpr);
        if (result == null) result = caseRangeExprChild(descOrSelfStepExpr);
        if (result == null) result = caseComparisonExprChild(descOrSelfStepExpr);
        if (result == null) result = caseAndExprChild(descOrSelfStepExpr);
        if (result == null) result = caseOrExprChild(descOrSelfStepExpr);
        if (result == null) result = caseExprSingle(descOrSelfStepExpr);
        if (result == null) result = caseAnyExpr(descOrSelfStepExpr);
        if (result == null) result = caseParenthesizedExprChild(descOrSelfStepExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.SELF_STEP_EXPR:
      {
        SelfStepExpr selfStepExpr = (SelfStepExpr)theEObject;
        T result = caseSelfStepExpr(selfStepExpr);
        if (result == null) result = casePathExprChild(selfStepExpr);
        if (result == null) result = caseUnaryExprChild(selfStepExpr);
        if (result == null) result = caseCastExprChild(selfStepExpr);
        if (result == null) result = caseCastableExprChild(selfStepExpr);
        if (result == null) result = caseTreatExprChild(selfStepExpr);
        if (result == null) result = caseInstanceofExprChild(selfStepExpr);
        if (result == null) result = caseIntersectExceptExprChild(selfStepExpr);
        if (result == null) result = caseUnionExprChild(selfStepExpr);
        if (result == null) result = caseMultiplicativeExprChild(selfStepExpr);
        if (result == null) result = caseAdditiveExprChild(selfStepExpr);
        if (result == null) result = caseRangeExprChild(selfStepExpr);
        if (result == null) result = caseComparisonExprChild(selfStepExpr);
        if (result == null) result = caseAndExprChild(selfStepExpr);
        if (result == null) result = caseOrExprChild(selfStepExpr);
        if (result == null) result = caseExprSingle(selfStepExpr);
        if (result == null) result = caseAnyExpr(selfStepExpr);
        if (result == null) result = caseParenthesizedExprChild(selfStepExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.SELF_STEP_EXPR_CHILD:
      {
        SelfStepExprChild selfStepExprChild = (SelfStepExprChild)theEObject;
        T result = caseSelfStepExprChild(selfStepExprChild);
        if (result == null) result = casePathExprChild(selfStepExprChild);
        if (result == null) result = caseUnaryExprChild(selfStepExprChild);
        if (result == null) result = caseCastExprChild(selfStepExprChild);
        if (result == null) result = caseCastableExprChild(selfStepExprChild);
        if (result == null) result = caseTreatExprChild(selfStepExprChild);
        if (result == null) result = caseInstanceofExprChild(selfStepExprChild);
        if (result == null) result = caseIntersectExceptExprChild(selfStepExprChild);
        if (result == null) result = caseUnionExprChild(selfStepExprChild);
        if (result == null) result = caseMultiplicativeExprChild(selfStepExprChild);
        if (result == null) result = caseAdditiveExprChild(selfStepExprChild);
        if (result == null) result = caseRangeExprChild(selfStepExprChild);
        if (result == null) result = caseComparisonExprChild(selfStepExprChild);
        if (result == null) result = caseAndExprChild(selfStepExprChild);
        if (result == null) result = caseOrExprChild(selfStepExprChild);
        if (result == null) result = caseExprSingle(selfStepExprChild);
        if (result == null) result = caseAnyExpr(selfStepExprChild);
        if (result == null) result = caseParenthesizedExprChild(selfStepExprChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.STEP_EXPR:
      {
        StepExpr stepExpr = (StepExpr)theEObject;
        T result = caseStepExpr(stepExpr);
        if (result == null) result = caseSelfStepExprChild(stepExpr);
        if (result == null) result = casePathExprChild(stepExpr);
        if (result == null) result = caseUnaryExprChild(stepExpr);
        if (result == null) result = caseCastExprChild(stepExpr);
        if (result == null) result = caseCastableExprChild(stepExpr);
        if (result == null) result = caseTreatExprChild(stepExpr);
        if (result == null) result = caseInstanceofExprChild(stepExpr);
        if (result == null) result = caseIntersectExceptExprChild(stepExpr);
        if (result == null) result = caseUnionExprChild(stepExpr);
        if (result == null) result = caseMultiplicativeExprChild(stepExpr);
        if (result == null) result = caseAdditiveExprChild(stepExpr);
        if (result == null) result = caseRangeExprChild(stepExpr);
        if (result == null) result = caseComparisonExprChild(stepExpr);
        if (result == null) result = caseAndExprChild(stepExpr);
        if (result == null) result = caseOrExprChild(stepExpr);
        if (result == null) result = caseExprSingle(stepExpr);
        if (result == null) result = caseAnyExpr(stepExpr);
        if (result == null) result = caseParenthesizedExprChild(stepExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.FILTER_EXPR:
      {
        FilterExpr filterExpr = (FilterExpr)theEObject;
        T result = caseFilterExpr(filterExpr);
        if (result == null) result = caseStepExpr(filterExpr);
        if (result == null) result = caseSelfStepExprChild(filterExpr);
        if (result == null) result = casePathExprChild(filterExpr);
        if (result == null) result = caseUnaryExprChild(filterExpr);
        if (result == null) result = caseCastExprChild(filterExpr);
        if (result == null) result = caseCastableExprChild(filterExpr);
        if (result == null) result = caseTreatExprChild(filterExpr);
        if (result == null) result = caseInstanceofExprChild(filterExpr);
        if (result == null) result = caseIntersectExceptExprChild(filterExpr);
        if (result == null) result = caseUnionExprChild(filterExpr);
        if (result == null) result = caseMultiplicativeExprChild(filterExpr);
        if (result == null) result = caseAdditiveExprChild(filterExpr);
        if (result == null) result = caseRangeExprChild(filterExpr);
        if (result == null) result = caseComparisonExprChild(filterExpr);
        if (result == null) result = caseAndExprChild(filterExpr);
        if (result == null) result = caseOrExprChild(filterExpr);
        if (result == null) result = caseExprSingle(filterExpr);
        if (result == null) result = caseAnyExpr(filterExpr);
        if (result == null) result = caseParenthesizedExprChild(filterExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.FILTER_EXPR_CHILD:
      {
        FilterExprChild filterExprChild = (FilterExprChild)theEObject;
        T result = caseFilterExprChild(filterExprChild);
        if (result == null) result = caseSelfStepExprChild(filterExprChild);
        if (result == null) result = casePathExprChild(filterExprChild);
        if (result == null) result = caseUnaryExprChild(filterExprChild);
        if (result == null) result = caseCastExprChild(filterExprChild);
        if (result == null) result = caseCastableExprChild(filterExprChild);
        if (result == null) result = caseTreatExprChild(filterExprChild);
        if (result == null) result = caseInstanceofExprChild(filterExprChild);
        if (result == null) result = caseIntersectExceptExprChild(filterExprChild);
        if (result == null) result = caseUnionExprChild(filterExprChild);
        if (result == null) result = caseMultiplicativeExprChild(filterExprChild);
        if (result == null) result = caseAdditiveExprChild(filterExprChild);
        if (result == null) result = caseRangeExprChild(filterExprChild);
        if (result == null) result = caseComparisonExprChild(filterExprChild);
        if (result == null) result = caseAndExprChild(filterExprChild);
        if (result == null) result = caseOrExprChild(filterExprChild);
        if (result == null) result = caseExprSingle(filterExprChild);
        if (result == null) result = caseAnyExpr(filterExprChild);
        if (result == null) result = caseParenthesizedExprChild(filterExprChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.AXIS_STEP:
      {
        AxisStep axisStep = (AxisStep)theEObject;
        T result = caseAxisStep(axisStep);
        if (result == null) result = caseStepExpr(axisStep);
        if (result == null) result = caseSelfStepExprChild(axisStep);
        if (result == null) result = casePathExprChild(axisStep);
        if (result == null) result = caseUnaryExprChild(axisStep);
        if (result == null) result = caseCastExprChild(axisStep);
        if (result == null) result = caseCastableExprChild(axisStep);
        if (result == null) result = caseTreatExprChild(axisStep);
        if (result == null) result = caseInstanceofExprChild(axisStep);
        if (result == null) result = caseIntersectExceptExprChild(axisStep);
        if (result == null) result = caseUnionExprChild(axisStep);
        if (result == null) result = caseMultiplicativeExprChild(axisStep);
        if (result == null) result = caseAdditiveExprChild(axisStep);
        if (result == null) result = caseRangeExprChild(axisStep);
        if (result == null) result = caseComparisonExprChild(axisStep);
        if (result == null) result = caseAndExprChild(axisStep);
        if (result == null) result = caseOrExprChild(axisStep);
        if (result == null) result = caseExprSingle(axisStep);
        if (result == null) result = caseAnyExpr(axisStep);
        if (result == null) result = caseParenthesizedExprChild(axisStep);
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
        if (result == null) result = caseFilterExprChild(primaryExpr);
        if (result == null) result = caseSelfStepExprChild(primaryExpr);
        if (result == null) result = casePathExprChild(primaryExpr);
        if (result == null) result = caseUnaryExprChild(primaryExpr);
        if (result == null) result = caseCastExprChild(primaryExpr);
        if (result == null) result = caseCastableExprChild(primaryExpr);
        if (result == null) result = caseTreatExprChild(primaryExpr);
        if (result == null) result = caseInstanceofExprChild(primaryExpr);
        if (result == null) result = caseIntersectExceptExprChild(primaryExpr);
        if (result == null) result = caseUnionExprChild(primaryExpr);
        if (result == null) result = caseMultiplicativeExprChild(primaryExpr);
        if (result == null) result = caseAdditiveExprChild(primaryExpr);
        if (result == null) result = caseRangeExprChild(primaryExpr);
        if (result == null) result = caseComparisonExprChild(primaryExpr);
        if (result == null) result = caseAndExprChild(primaryExpr);
        if (result == null) result = caseOrExprChild(primaryExpr);
        if (result == null) result = caseExprSingle(primaryExpr);
        if (result == null) result = caseAnyExpr(primaryExpr);
        if (result == null) result = caseParenthesizedExprChild(primaryExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.LITERAL:
      {
        Literal literal = (Literal)theEObject;
        T result = caseLiteral(literal);
        if (result == null) result = casePrimaryExpr(literal);
        if (result == null) result = caseFilterExprChild(literal);
        if (result == null) result = caseSelfStepExprChild(literal);
        if (result == null) result = casePathExprChild(literal);
        if (result == null) result = caseUnaryExprChild(literal);
        if (result == null) result = caseCastExprChild(literal);
        if (result == null) result = caseCastableExprChild(literal);
        if (result == null) result = caseTreatExprChild(literal);
        if (result == null) result = caseInstanceofExprChild(literal);
        if (result == null) result = caseIntersectExceptExprChild(literal);
        if (result == null) result = caseUnionExprChild(literal);
        if (result == null) result = caseMultiplicativeExprChild(literal);
        if (result == null) result = caseAdditiveExprChild(literal);
        if (result == null) result = caseRangeExprChild(literal);
        if (result == null) result = caseComparisonExprChild(literal);
        if (result == null) result = caseAndExprChild(literal);
        if (result == null) result = caseOrExprChild(literal);
        if (result == null) result = caseExprSingle(literal);
        if (result == null) result = caseAnyExpr(literal);
        if (result == null) result = caseParenthesizedExprChild(literal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.VAR_REF:
      {
        VarRef varRef = (VarRef)theEObject;
        T result = caseVarRef(varRef);
        if (result == null) result = casePrimaryExpr(varRef);
        if (result == null) result = caseFilterExprChild(varRef);
        if (result == null) result = caseSelfStepExprChild(varRef);
        if (result == null) result = casePathExprChild(varRef);
        if (result == null) result = caseUnaryExprChild(varRef);
        if (result == null) result = caseCastExprChild(varRef);
        if (result == null) result = caseCastableExprChild(varRef);
        if (result == null) result = caseTreatExprChild(varRef);
        if (result == null) result = caseInstanceofExprChild(varRef);
        if (result == null) result = caseIntersectExceptExprChild(varRef);
        if (result == null) result = caseUnionExprChild(varRef);
        if (result == null) result = caseMultiplicativeExprChild(varRef);
        if (result == null) result = caseAdditiveExprChild(varRef);
        if (result == null) result = caseRangeExprChild(varRef);
        if (result == null) result = caseComparisonExprChild(varRef);
        if (result == null) result = caseAndExprChild(varRef);
        if (result == null) result = caseOrExprChild(varRef);
        if (result == null) result = caseExprSingle(varRef);
        if (result == null) result = caseAnyExpr(varRef);
        if (result == null) result = caseParenthesizedExprChild(varRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.VAR_NAME:
      {
        VarName varName = (VarName)theEObject;
        T result = caseVarName(varName);
        if (result == null) result = caseQName(varName);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.PARENTHESIZED_EXPR:
      {
        ParenthesizedExpr parenthesizedExpr = (ParenthesizedExpr)theEObject;
        T result = caseParenthesizedExpr(parenthesizedExpr);
        if (result == null) result = casePrimaryExpr(parenthesizedExpr);
        if (result == null) result = caseFilterExprChild(parenthesizedExpr);
        if (result == null) result = caseSelfStepExprChild(parenthesizedExpr);
        if (result == null) result = casePathExprChild(parenthesizedExpr);
        if (result == null) result = caseUnaryExprChild(parenthesizedExpr);
        if (result == null) result = caseCastExprChild(parenthesizedExpr);
        if (result == null) result = caseCastableExprChild(parenthesizedExpr);
        if (result == null) result = caseTreatExprChild(parenthesizedExpr);
        if (result == null) result = caseInstanceofExprChild(parenthesizedExpr);
        if (result == null) result = caseIntersectExceptExprChild(parenthesizedExpr);
        if (result == null) result = caseUnionExprChild(parenthesizedExpr);
        if (result == null) result = caseMultiplicativeExprChild(parenthesizedExpr);
        if (result == null) result = caseAdditiveExprChild(parenthesizedExpr);
        if (result == null) result = caseRangeExprChild(parenthesizedExpr);
        if (result == null) result = caseComparisonExprChild(parenthesizedExpr);
        if (result == null) result = caseAndExprChild(parenthesizedExpr);
        if (result == null) result = caseOrExprChild(parenthesizedExpr);
        if (result == null) result = caseExprSingle(parenthesizedExpr);
        if (result == null) result = caseAnyExpr(parenthesizedExpr);
        if (result == null) result = caseParenthesizedExprChild(parenthesizedExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.PARENTHESIZED_EXPR_CHILD:
      {
        ParenthesizedExprChild parenthesizedExprChild = (ParenthesizedExprChild)theEObject;
        T result = caseParenthesizedExprChild(parenthesizedExprChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.CONTEXT_ITEM_EXPR:
      {
        ContextItemExpr contextItemExpr = (ContextItemExpr)theEObject;
        T result = caseContextItemExpr(contextItemExpr);
        if (result == null) result = casePrimaryExpr(contextItemExpr);
        if (result == null) result = caseFilterExprChild(contextItemExpr);
        if (result == null) result = caseSelfStepExprChild(contextItemExpr);
        if (result == null) result = casePathExprChild(contextItemExpr);
        if (result == null) result = caseUnaryExprChild(contextItemExpr);
        if (result == null) result = caseCastExprChild(contextItemExpr);
        if (result == null) result = caseCastableExprChild(contextItemExpr);
        if (result == null) result = caseTreatExprChild(contextItemExpr);
        if (result == null) result = caseInstanceofExprChild(contextItemExpr);
        if (result == null) result = caseIntersectExceptExprChild(contextItemExpr);
        if (result == null) result = caseUnionExprChild(contextItemExpr);
        if (result == null) result = caseMultiplicativeExprChild(contextItemExpr);
        if (result == null) result = caseAdditiveExprChild(contextItemExpr);
        if (result == null) result = caseRangeExprChild(contextItemExpr);
        if (result == null) result = caseComparisonExprChild(contextItemExpr);
        if (result == null) result = caseAndExprChild(contextItemExpr);
        if (result == null) result = caseOrExprChild(contextItemExpr);
        if (result == null) result = caseExprSingle(contextItemExpr);
        if (result == null) result = caseAnyExpr(contextItemExpr);
        if (result == null) result = caseParenthesizedExprChild(contextItemExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.FUNCTION_CALL:
      {
        FunctionCall functionCall = (FunctionCall)theEObject;
        T result = caseFunctionCall(functionCall);
        if (result == null) result = casePrimaryExpr(functionCall);
        if (result == null) result = caseFilterExprChild(functionCall);
        if (result == null) result = caseSelfStepExprChild(functionCall);
        if (result == null) result = casePathExprChild(functionCall);
        if (result == null) result = caseUnaryExprChild(functionCall);
        if (result == null) result = caseCastExprChild(functionCall);
        if (result == null) result = caseCastableExprChild(functionCall);
        if (result == null) result = caseTreatExprChild(functionCall);
        if (result == null) result = caseInstanceofExprChild(functionCall);
        if (result == null) result = caseIntersectExceptExprChild(functionCall);
        if (result == null) result = caseUnionExprChild(functionCall);
        if (result == null) result = caseMultiplicativeExprChild(functionCall);
        if (result == null) result = caseAdditiveExprChild(functionCall);
        if (result == null) result = caseRangeExprChild(functionCall);
        if (result == null) result = caseComparisonExprChild(functionCall);
        if (result == null) result = caseAndExprChild(functionCall);
        if (result == null) result = caseOrExprChild(functionCall);
        if (result == null) result = caseExprSingle(functionCall);
        if (result == null) result = caseAnyExpr(functionCall);
        if (result == null) result = caseParenthesizedExprChild(functionCall);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.NUMERIC_LITERAL:
      {
        NumericLiteral numericLiteral = (NumericLiteral)theEObject;
        T result = caseNumericLiteral(numericLiteral);
        if (result == null) result = caseLiteral(numericLiteral);
        if (result == null) result = casePrimaryExpr(numericLiteral);
        if (result == null) result = caseFilterExprChild(numericLiteral);
        if (result == null) result = caseSelfStepExprChild(numericLiteral);
        if (result == null) result = casePathExprChild(numericLiteral);
        if (result == null) result = caseUnaryExprChild(numericLiteral);
        if (result == null) result = caseCastExprChild(numericLiteral);
        if (result == null) result = caseCastableExprChild(numericLiteral);
        if (result == null) result = caseTreatExprChild(numericLiteral);
        if (result == null) result = caseInstanceofExprChild(numericLiteral);
        if (result == null) result = caseIntersectExceptExprChild(numericLiteral);
        if (result == null) result = caseUnionExprChild(numericLiteral);
        if (result == null) result = caseMultiplicativeExprChild(numericLiteral);
        if (result == null) result = caseAdditiveExprChild(numericLiteral);
        if (result == null) result = caseRangeExprChild(numericLiteral);
        if (result == null) result = caseComparisonExprChild(numericLiteral);
        if (result == null) result = caseAndExprChild(numericLiteral);
        if (result == null) result = caseOrExprChild(numericLiteral);
        if (result == null) result = caseExprSingle(numericLiteral);
        if (result == null) result = caseAnyExpr(numericLiteral);
        if (result == null) result = caseParenthesizedExprChild(numericLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Xpath2Package.STRING_LITERAL:
      {
        StringLiteral stringLiteral = (StringLiteral)theEObject;
        T result = caseStringLiteral(stringLiteral);
        if (result == null) result = caseLiteral(stringLiteral);
        if (result == null) result = casePrimaryExpr(stringLiteral);
        if (result == null) result = caseFilterExprChild(stringLiteral);
        if (result == null) result = caseSelfStepExprChild(stringLiteral);
        if (result == null) result = casePathExprChild(stringLiteral);
        if (result == null) result = caseUnaryExprChild(stringLiteral);
        if (result == null) result = caseCastExprChild(stringLiteral);
        if (result == null) result = caseCastableExprChild(stringLiteral);
        if (result == null) result = caseTreatExprChild(stringLiteral);
        if (result == null) result = caseInstanceofExprChild(stringLiteral);
        if (result == null) result = caseIntersectExceptExprChild(stringLiteral);
        if (result == null) result = caseUnionExprChild(stringLiteral);
        if (result == null) result = caseMultiplicativeExprChild(stringLiteral);
        if (result == null) result = caseAdditiveExprChild(stringLiteral);
        if (result == null) result = caseRangeExprChild(stringLiteral);
        if (result == null) result = caseComparisonExprChild(stringLiteral);
        if (result == null) result = caseAndExprChild(stringLiteral);
        if (result == null) result = caseOrExprChild(stringLiteral);
        if (result == null) result = caseExprSingle(stringLiteral);
        if (result == null) result = caseAnyExpr(stringLiteral);
        if (result == null) result = caseParenthesizedExprChild(stringLiteral);
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
        if (result == null) result = caseFilterExprChild(integerLiteral);
        if (result == null) result = caseSelfStepExprChild(integerLiteral);
        if (result == null) result = casePathExprChild(integerLiteral);
        if (result == null) result = caseUnaryExprChild(integerLiteral);
        if (result == null) result = caseCastExprChild(integerLiteral);
        if (result == null) result = caseCastableExprChild(integerLiteral);
        if (result == null) result = caseTreatExprChild(integerLiteral);
        if (result == null) result = caseInstanceofExprChild(integerLiteral);
        if (result == null) result = caseIntersectExceptExprChild(integerLiteral);
        if (result == null) result = caseUnionExprChild(integerLiteral);
        if (result == null) result = caseMultiplicativeExprChild(integerLiteral);
        if (result == null) result = caseAdditiveExprChild(integerLiteral);
        if (result == null) result = caseRangeExprChild(integerLiteral);
        if (result == null) result = caseComparisonExprChild(integerLiteral);
        if (result == null) result = caseAndExprChild(integerLiteral);
        if (result == null) result = caseOrExprChild(integerLiteral);
        if (result == null) result = caseExprSingle(integerLiteral);
        if (result == null) result = caseAnyExpr(integerLiteral);
        if (result == null) result = caseParenthesizedExprChild(integerLiteral);
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
        if (result == null) result = caseFilterExprChild(decimalLiteral);
        if (result == null) result = caseSelfStepExprChild(decimalLiteral);
        if (result == null) result = casePathExprChild(decimalLiteral);
        if (result == null) result = caseUnaryExprChild(decimalLiteral);
        if (result == null) result = caseCastExprChild(decimalLiteral);
        if (result == null) result = caseCastableExprChild(decimalLiteral);
        if (result == null) result = caseTreatExprChild(decimalLiteral);
        if (result == null) result = caseInstanceofExprChild(decimalLiteral);
        if (result == null) result = caseIntersectExceptExprChild(decimalLiteral);
        if (result == null) result = caseUnionExprChild(decimalLiteral);
        if (result == null) result = caseMultiplicativeExprChild(decimalLiteral);
        if (result == null) result = caseAdditiveExprChild(decimalLiteral);
        if (result == null) result = caseRangeExprChild(decimalLiteral);
        if (result == null) result = caseComparisonExprChild(decimalLiteral);
        if (result == null) result = caseAndExprChild(decimalLiteral);
        if (result == null) result = caseOrExprChild(decimalLiteral);
        if (result == null) result = caseExprSingle(decimalLiteral);
        if (result == null) result = caseAnyExpr(decimalLiteral);
        if (result == null) result = caseParenthesizedExprChild(decimalLiteral);
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
        if (result == null) result = caseFilterExprChild(doubleLiteral);
        if (result == null) result = caseSelfStepExprChild(doubleLiteral);
        if (result == null) result = casePathExprChild(doubleLiteral);
        if (result == null) result = caseUnaryExprChild(doubleLiteral);
        if (result == null) result = caseCastExprChild(doubleLiteral);
        if (result == null) result = caseCastableExprChild(doubleLiteral);
        if (result == null) result = caseTreatExprChild(doubleLiteral);
        if (result == null) result = caseInstanceofExprChild(doubleLiteral);
        if (result == null) result = caseIntersectExceptExprChild(doubleLiteral);
        if (result == null) result = caseUnionExprChild(doubleLiteral);
        if (result == null) result = caseMultiplicativeExprChild(doubleLiteral);
        if (result == null) result = caseAdditiveExprChild(doubleLiteral);
        if (result == null) result = caseRangeExprChild(doubleLiteral);
        if (result == null) result = caseComparisonExprChild(doubleLiteral);
        if (result == null) result = caseAndExprChild(doubleLiteral);
        if (result == null) result = caseOrExprChild(doubleLiteral);
        if (result == null) result = caseExprSingle(doubleLiteral);
        if (result == null) result = caseAnyExpr(doubleLiteral);
        if (result == null) result = caseParenthesizedExprChild(doubleLiteral);
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
   * Returns the result of interpreting the object as an instance of '<em>Any Expr</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Any Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
    public T caseAnyExpr(AnyExpr object) {
    return null;
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
   * Returns the result of interpreting the object as an instance of '<em>Iterator</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Iterator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
    public T caseIterator(Iterator object) {
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
   * Returns the result of interpreting the object as an instance of '<em>Path Expr Child</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Path Expr Child</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
    public T casePathExprChild(PathExprChild object) {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Root Step Expr</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Root Step Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
    public T caseRootStepExpr(RootStepExpr object) {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Child Step Expr</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Child Step Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
    public T caseChildStepExpr(ChildStepExpr object) {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Desc Or Self Step Expr</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Desc Or Self Step Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
    public T caseDescOrSelfStepExpr(DescOrSelfStepExpr object) {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Self Step Expr</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Self Step Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
    public T caseSelfStepExpr(SelfStepExpr object) {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Self Step Expr Child</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Self Step Expr Child</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
    public T caseSelfStepExprChild(SelfStepExprChild object) {
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
   * Returns the result of interpreting the object as an instance of '<em>Filter Expr Child</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Filter Expr Child</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
    public T caseFilterExprChild(FilterExprChild object) {
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
   * Returns the result of interpreting the object as an instance of '<em>Parenthesized Expr Child</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parenthesized Expr Child</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
    public T caseParenthesizedExprChild(ParenthesizedExprChild object) {
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
