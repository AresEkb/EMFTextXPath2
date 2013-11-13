/**
 */
package org.emftext.language.xpath2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.emftext.language.xpath2.RelativePathExpr;
import org.emftext.language.xpath2.SinglePathExpr;
import org.emftext.language.xpath2.Xpath2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Single Path Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.impl.SinglePathExprImpl#getRelativePathExpr <em>Relative Path Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SinglePathExprImpl extends PathExprImpl implements SinglePathExpr {
	/**
   * The cached value of the '{@link #getRelativePathExpr() <em>Relative Path Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getRelativePathExpr()
   * @generated
   * @ordered
   */
	protected RelativePathExpr relativePathExpr;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected SinglePathExprImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return Xpath2Package.Literals.SINGLE_PATH_EXPR;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public RelativePathExpr getRelativePathExpr() {
    return relativePathExpr;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetRelativePathExpr(RelativePathExpr newRelativePathExpr, NotificationChain msgs) {
    RelativePathExpr oldRelativePathExpr = relativePathExpr;
    relativePathExpr = newRelativePathExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Xpath2Package.SINGLE_PATH_EXPR__RELATIVE_PATH_EXPR, oldRelativePathExpr, newRelativePathExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setRelativePathExpr(RelativePathExpr newRelativePathExpr) {
    if (newRelativePathExpr != relativePathExpr)
    {
      NotificationChain msgs = null;
      if (relativePathExpr != null)
        msgs = ((InternalEObject)relativePathExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Xpath2Package.SINGLE_PATH_EXPR__RELATIVE_PATH_EXPR, null, msgs);
      if (newRelativePathExpr != null)
        msgs = ((InternalEObject)newRelativePathExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Xpath2Package.SINGLE_PATH_EXPR__RELATIVE_PATH_EXPR, null, msgs);
      msgs = basicSetRelativePathExpr(newRelativePathExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Xpath2Package.SINGLE_PATH_EXPR__RELATIVE_PATH_EXPR, newRelativePathExpr, newRelativePathExpr));
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
      case Xpath2Package.SINGLE_PATH_EXPR__RELATIVE_PATH_EXPR:
        return basicSetRelativePathExpr(null, msgs);
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
      case Xpath2Package.SINGLE_PATH_EXPR__RELATIVE_PATH_EXPR:
        return getRelativePathExpr();
    }
    return super.eGet(featureID, resolve, coreType);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public void eSet(int featureID, Object newValue) {
    switch (featureID)
    {
      case Xpath2Package.SINGLE_PATH_EXPR__RELATIVE_PATH_EXPR:
        setRelativePathExpr((RelativePathExpr)newValue);
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
      case Xpath2Package.SINGLE_PATH_EXPR__RELATIVE_PATH_EXPR:
        setRelativePathExpr((RelativePathExpr)null);
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
      case Xpath2Package.SINGLE_PATH_EXPR__RELATIVE_PATH_EXPR:
        return relativePathExpr != null;
    }
    return super.eIsSet(featureID);
  }

} //SinglePathExprImpl
