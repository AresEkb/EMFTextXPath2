/**
 */
package org.emftext.language.xpath2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.emftext.language.xpath2.RelativePathExpr;
import org.emftext.language.xpath2.StepExpr;
import org.emftext.language.xpath2.TailPathExpr;
import org.emftext.language.xpath2.Xpath2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relative Path Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.impl.RelativePathExprImpl#getHead <em>Head</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.impl.RelativePathExprImpl#getTail <em>Tail</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RelativePathExprImpl extends PathExprImpl implements RelativePathExpr {
	/**
   * The cached value of the '{@link #getHead() <em>Head</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getHead()
   * @generated
   * @ordered
   */
	protected StepExpr head;

	/**
   * The cached value of the '{@link #getTail() <em>Tail</em>}' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getTail()
   * @generated
   * @ordered
   */
	protected EList<TailPathExpr> tail;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected RelativePathExprImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return Xpath2Package.Literals.RELATIVE_PATH_EXPR;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public StepExpr getHead() {
    return head;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetHead(StepExpr newHead, NotificationChain msgs) {
    StepExpr oldHead = head;
    head = newHead;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Xpath2Package.RELATIVE_PATH_EXPR__HEAD, oldHead, newHead);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setHead(StepExpr newHead) {
    if (newHead != head)
    {
      NotificationChain msgs = null;
      if (head != null)
        msgs = ((InternalEObject)head).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Xpath2Package.RELATIVE_PATH_EXPR__HEAD, null, msgs);
      if (newHead != null)
        msgs = ((InternalEObject)newHead).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Xpath2Package.RELATIVE_PATH_EXPR__HEAD, null, msgs);
      msgs = basicSetHead(newHead, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Xpath2Package.RELATIVE_PATH_EXPR__HEAD, newHead, newHead));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<TailPathExpr> getTail() {
    if (tail == null)
    {
      tail = new EObjectContainmentEList<TailPathExpr>(TailPathExpr.class, this, Xpath2Package.RELATIVE_PATH_EXPR__TAIL);
    }
    return tail;
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
      case Xpath2Package.RELATIVE_PATH_EXPR__HEAD:
        return basicSetHead(null, msgs);
      case Xpath2Package.RELATIVE_PATH_EXPR__TAIL:
        return ((InternalEList<?>)getTail()).basicRemove(otherEnd, msgs);
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
      case Xpath2Package.RELATIVE_PATH_EXPR__HEAD:
        return getHead();
      case Xpath2Package.RELATIVE_PATH_EXPR__TAIL:
        return getTail();
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
      case Xpath2Package.RELATIVE_PATH_EXPR__HEAD:
        setHead((StepExpr)newValue);
        return;
      case Xpath2Package.RELATIVE_PATH_EXPR__TAIL:
        getTail().clear();
        getTail().addAll((Collection<? extends TailPathExpr>)newValue);
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
      case Xpath2Package.RELATIVE_PATH_EXPR__HEAD:
        setHead((StepExpr)null);
        return;
      case Xpath2Package.RELATIVE_PATH_EXPR__TAIL:
        getTail().clear();
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
      case Xpath2Package.RELATIVE_PATH_EXPR__HEAD:
        return head != null;
      case Xpath2Package.RELATIVE_PATH_EXPR__TAIL:
        return tail != null && !tail.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //RelativePathExprImpl
