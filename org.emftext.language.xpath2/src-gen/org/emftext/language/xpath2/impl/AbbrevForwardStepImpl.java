/**
 */
package org.emftext.language.xpath2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.emftext.language.xpath2.AbbrevForwardStep;
import org.emftext.language.xpath2.NodeTest;
import org.emftext.language.xpath2.Xpath2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abbrev Forward Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.impl.AbbrevForwardStepImpl#isAt <em>At</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.impl.AbbrevForwardStepImpl#getNodeTest <em>Node Test</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AbbrevForwardStepImpl extends ForwardStepImpl implements AbbrevForwardStep {
	/**
   * The default value of the '{@link #isAt() <em>At</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #isAt()
   * @generated
   * @ordered
   */
	protected static final boolean AT_EDEFAULT = false;

	/**
   * The cached value of the '{@link #isAt() <em>At</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #isAt()
   * @generated
   * @ordered
   */
	protected boolean at = AT_EDEFAULT;

	/**
   * The cached value of the '{@link #getNodeTest() <em>Node Test</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getNodeTest()
   * @generated
   * @ordered
   */
	protected NodeTest nodeTest;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected AbbrevForwardStepImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return Xpath2Package.Literals.ABBREV_FORWARD_STEP;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public boolean isAt() {
    return at;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setAt(boolean newAt) {
    boolean oldAt = at;
    at = newAt;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Xpath2Package.ABBREV_FORWARD_STEP__AT, oldAt, at));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NodeTest getNodeTest() {
    return nodeTest;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetNodeTest(NodeTest newNodeTest, NotificationChain msgs) {
    NodeTest oldNodeTest = nodeTest;
    nodeTest = newNodeTest;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Xpath2Package.ABBREV_FORWARD_STEP__NODE_TEST, oldNodeTest, newNodeTest);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setNodeTest(NodeTest newNodeTest) {
    if (newNodeTest != nodeTest)
    {
      NotificationChain msgs = null;
      if (nodeTest != null)
        msgs = ((InternalEObject)nodeTest).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Xpath2Package.ABBREV_FORWARD_STEP__NODE_TEST, null, msgs);
      if (newNodeTest != null)
        msgs = ((InternalEObject)newNodeTest).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Xpath2Package.ABBREV_FORWARD_STEP__NODE_TEST, null, msgs);
      msgs = basicSetNodeTest(newNodeTest, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Xpath2Package.ABBREV_FORWARD_STEP__NODE_TEST, newNodeTest, newNodeTest));
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
      case Xpath2Package.ABBREV_FORWARD_STEP__NODE_TEST:
        return basicSetNodeTest(null, msgs);
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
      case Xpath2Package.ABBREV_FORWARD_STEP__AT:
        return isAt();
      case Xpath2Package.ABBREV_FORWARD_STEP__NODE_TEST:
        return getNodeTest();
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
      case Xpath2Package.ABBREV_FORWARD_STEP__AT:
        setAt((Boolean)newValue);
        return;
      case Xpath2Package.ABBREV_FORWARD_STEP__NODE_TEST:
        setNodeTest((NodeTest)newValue);
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
      case Xpath2Package.ABBREV_FORWARD_STEP__AT:
        setAt(AT_EDEFAULT);
        return;
      case Xpath2Package.ABBREV_FORWARD_STEP__NODE_TEST:
        setNodeTest((NodeTest)null);
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
      case Xpath2Package.ABBREV_FORWARD_STEP__AT:
        return at != AT_EDEFAULT;
      case Xpath2Package.ABBREV_FORWARD_STEP__NODE_TEST:
        return nodeTest != null;
    }
    return super.eIsSet(featureID);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (at: ");
    result.append(at);
    result.append(')');
    return result.toString();
  }

} //AbbrevForwardStepImpl
