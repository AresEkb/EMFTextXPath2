/**
 */
package org.emftext.language.xpath2.impl;

import org.eclipse.emf.ecore.EClass;

import org.emftext.language.xpath2.AnyExpr;
import org.emftext.language.xpath2.Xpath2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Any Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class AnyExprImpl extends ParenthesizedExprChildImpl implements AnyExpr {
    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    protected AnyExprImpl() {
    super();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    protected EClass eStaticClass() {
    return Xpath2Package.Literals.ANY_EXPR;
  }

} //AnyExprImpl