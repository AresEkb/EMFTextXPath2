/**
 */
package org.emftext.language.xpath2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.emftext.language.xpath2.StepExpr;
import org.emftext.language.xpath2.TailPathExpr;
import org.emftext.language.xpath2.Xpath2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tail Path Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.impl.TailPathExprImpl#getStepExpression <em>Step Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TailPathExprImpl extends EObjectImpl implements TailPathExpr {
	/**
   * The cached value of the '{@link #getStepExpression() <em>Step Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getStepExpression()
   * @generated
   * @ordered
   */
	protected StepExpr stepExpression;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected TailPathExprImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return Xpath2Package.Literals.TAIL_PATH_EXPR;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public StepExpr getStepExpression() {
    return stepExpression;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetStepExpression(StepExpr newStepExpression, NotificationChain msgs) {
    StepExpr oldStepExpression = stepExpression;
    stepExpression = newStepExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Xpath2Package.TAIL_PATH_EXPR__STEP_EXPRESSION, oldStepExpression, newStepExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setStepExpression(StepExpr newStepExpression) {
    if (newStepExpression != stepExpression)
    {
      NotificationChain msgs = null;
      if (stepExpression != null)
        msgs = ((InternalEObject)stepExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Xpath2Package.TAIL_PATH_EXPR__STEP_EXPRESSION, null, msgs);
      if (newStepExpression != null)
        msgs = ((InternalEObject)newStepExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Xpath2Package.TAIL_PATH_EXPR__STEP_EXPRESSION, null, msgs);
      msgs = basicSetStepExpression(newStepExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Xpath2Package.TAIL_PATH_EXPR__STEP_EXPRESSION, newStepExpression, newStepExpression));
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
      case Xpath2Package.TAIL_PATH_EXPR__STEP_EXPRESSION:
        return basicSetStepExpression(null, msgs);
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
      case Xpath2Package.TAIL_PATH_EXPR__STEP_EXPRESSION:
        return getStepExpression();
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
      case Xpath2Package.TAIL_PATH_EXPR__STEP_EXPRESSION:
        setStepExpression((StepExpr)newValue);
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
      case Xpath2Package.TAIL_PATH_EXPR__STEP_EXPRESSION:
        setStepExpression((StepExpr)null);
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
      case Xpath2Package.TAIL_PATH_EXPR__STEP_EXPRESSION:
        return stepExpression != null;
    }
    return super.eIsSet(featureID);
  }

} //TailPathExprImpl
