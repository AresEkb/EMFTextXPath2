/**
 */
package org.emftext.language.xpath2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.emftext.language.xpath2.ExprSingle;
import org.emftext.language.xpath2.ForExpr;
import org.emftext.language.xpath2.SimpleForClause;
import org.emftext.language.xpath2.Xpath2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>For Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.impl.ForExprImpl#getOwnedSimpleForClause <em>Owned Simple For Clause</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.impl.ForExprImpl#getReturn <em>Return</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForExprImpl extends ExprSingleImpl implements ForExpr {
	/**
   * The cached value of the '{@link #getOwnedSimpleForClause() <em>Owned Simple For Clause</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getOwnedSimpleForClause()
   * @generated
   * @ordered
   */
	protected SimpleForClause ownedSimpleForClause;

	/**
   * The cached value of the '{@link #getReturn() <em>Return</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getReturn()
   * @generated
   * @ordered
   */
	protected ExprSingle return_;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected ForExprImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return Xpath2Package.Literals.FOR_EXPR;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public SimpleForClause getOwnedSimpleForClause() {
    return ownedSimpleForClause;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetOwnedSimpleForClause(SimpleForClause newOwnedSimpleForClause, NotificationChain msgs) {
    SimpleForClause oldOwnedSimpleForClause = ownedSimpleForClause;
    ownedSimpleForClause = newOwnedSimpleForClause;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Xpath2Package.FOR_EXPR__OWNED_SIMPLE_FOR_CLAUSE, oldOwnedSimpleForClause, newOwnedSimpleForClause);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setOwnedSimpleForClause(SimpleForClause newOwnedSimpleForClause) {
    if (newOwnedSimpleForClause != ownedSimpleForClause)
    {
      NotificationChain msgs = null;
      if (ownedSimpleForClause != null)
        msgs = ((InternalEObject)ownedSimpleForClause).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Xpath2Package.FOR_EXPR__OWNED_SIMPLE_FOR_CLAUSE, null, msgs);
      if (newOwnedSimpleForClause != null)
        msgs = ((InternalEObject)newOwnedSimpleForClause).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Xpath2Package.FOR_EXPR__OWNED_SIMPLE_FOR_CLAUSE, null, msgs);
      msgs = basicSetOwnedSimpleForClause(newOwnedSimpleForClause, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Xpath2Package.FOR_EXPR__OWNED_SIMPLE_FOR_CLAUSE, newOwnedSimpleForClause, newOwnedSimpleForClause));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ExprSingle getReturn() {
    return return_;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetReturn(ExprSingle newReturn, NotificationChain msgs) {
    ExprSingle oldReturn = return_;
    return_ = newReturn;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Xpath2Package.FOR_EXPR__RETURN, oldReturn, newReturn);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setReturn(ExprSingle newReturn) {
    if (newReturn != return_)
    {
      NotificationChain msgs = null;
      if (return_ != null)
        msgs = ((InternalEObject)return_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Xpath2Package.FOR_EXPR__RETURN, null, msgs);
      if (newReturn != null)
        msgs = ((InternalEObject)newReturn).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Xpath2Package.FOR_EXPR__RETURN, null, msgs);
      msgs = basicSetReturn(newReturn, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Xpath2Package.FOR_EXPR__RETURN, newReturn, newReturn));
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
      case Xpath2Package.FOR_EXPR__OWNED_SIMPLE_FOR_CLAUSE:
        return basicSetOwnedSimpleForClause(null, msgs);
      case Xpath2Package.FOR_EXPR__RETURN:
        return basicSetReturn(null, msgs);
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
      case Xpath2Package.FOR_EXPR__OWNED_SIMPLE_FOR_CLAUSE:
        return getOwnedSimpleForClause();
      case Xpath2Package.FOR_EXPR__RETURN:
        return getReturn();
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
      case Xpath2Package.FOR_EXPR__OWNED_SIMPLE_FOR_CLAUSE:
        setOwnedSimpleForClause((SimpleForClause)newValue);
        return;
      case Xpath2Package.FOR_EXPR__RETURN:
        setReturn((ExprSingle)newValue);
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
      case Xpath2Package.FOR_EXPR__OWNED_SIMPLE_FOR_CLAUSE:
        setOwnedSimpleForClause((SimpleForClause)null);
        return;
      case Xpath2Package.FOR_EXPR__RETURN:
        setReturn((ExprSingle)null);
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
      case Xpath2Package.FOR_EXPR__OWNED_SIMPLE_FOR_CLAUSE:
        return ownedSimpleForClause != null;
      case Xpath2Package.FOR_EXPR__RETURN:
        return return_ != null;
    }
    return super.eIsSet(featureID);
  }

} //ForExprImpl
