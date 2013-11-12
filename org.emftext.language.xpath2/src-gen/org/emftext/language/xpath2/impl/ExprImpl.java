/**
 */
package org.emftext.language.xpath2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.emftext.language.xpath2.Expr;
import org.emftext.language.xpath2.ExprSingle;
import org.emftext.language.xpath2.Xpath2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.impl.ExprImpl#getOwnedExprSingle <em>Owned Expr Single</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExprImpl extends EObjectImpl implements Expr {
	/**
   * The cached value of the '{@link #getOwnedExprSingle() <em>Owned Expr Single</em>}' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getOwnedExprSingle()
   * @generated
   * @ordered
   */
	protected EList<ExprSingle> ownedExprSingle;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected ExprImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return Xpath2Package.Literals.EXPR;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<ExprSingle> getOwnedExprSingle() {
    if (ownedExprSingle == null)
    {
      ownedExprSingle = new EObjectContainmentEList<ExprSingle>(ExprSingle.class, this, Xpath2Package.EXPR__OWNED_EXPR_SINGLE);
    }
    return ownedExprSingle;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID)
    {
      case Xpath2Package.EXPR__OWNED_EXPR_SINGLE:
        return ((InternalEList<?>)getOwnedExprSingle()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID)
    {
      case Xpath2Package.EXPR__OWNED_EXPR_SINGLE:
        return getOwnedExprSingle();
    }
    return super.eGet(featureID, resolve, coreType);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
    switch (featureID)
    {
      case Xpath2Package.EXPR__OWNED_EXPR_SINGLE:
        getOwnedExprSingle().clear();
        getOwnedExprSingle().addAll((Collection<? extends ExprSingle>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public void eUnset(int featureID) {
    switch (featureID)
    {
      case Xpath2Package.EXPR__OWNED_EXPR_SINGLE:
        getOwnedExprSingle().clear();
        return;
    }
    super.eUnset(featureID);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public boolean eIsSet(int featureID) {
    switch (featureID)
    {
      case Xpath2Package.EXPR__OWNED_EXPR_SINGLE:
        return ownedExprSingle != null && !ownedExprSingle.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ExprImpl
