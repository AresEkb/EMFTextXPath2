/**
 * Copyright (c) 2013 Denis Nikiforov.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Denis Nikiforov - initial API and implementation
 */
package org.emftext.language.xpath2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.emftext.language.xpath2.ForwardAxisKind;
import org.emftext.language.xpath2.GeneralForwardStep;
import org.emftext.language.xpath2.NodeTest;
import org.emftext.language.xpath2.Xpath2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>General Forward Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.impl.GeneralForwardStepImpl#getAxis <em>Axis</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.impl.GeneralForwardStepImpl#getNodeTest <em>Node Test</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GeneralForwardStepImpl extends ForwardStepImpl implements GeneralForwardStep {
	/**
   * The default value of the '{@link #getAxis() <em>Axis</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getAxis()
   * @generated
   * @ordered
   */
	protected static final ForwardAxisKind AXIS_EDEFAULT = ForwardAxisKind.CHILD;

	/**
   * The cached value of the '{@link #getAxis() <em>Axis</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getAxis()
   * @generated
   * @ordered
   */
	protected ForwardAxisKind axis = AXIS_EDEFAULT;

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
	protected GeneralForwardStepImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return Xpath2Package.Literals.GENERAL_FORWARD_STEP;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ForwardAxisKind getAxis() {
    return axis;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setAxis(ForwardAxisKind newAxis) {
    ForwardAxisKind oldAxis = axis;
    axis = newAxis == null ? AXIS_EDEFAULT : newAxis;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Xpath2Package.GENERAL_FORWARD_STEP__AXIS, oldAxis, axis));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Xpath2Package.GENERAL_FORWARD_STEP__NODE_TEST, oldNodeTest, newNodeTest);
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
        msgs = ((InternalEObject)nodeTest).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Xpath2Package.GENERAL_FORWARD_STEP__NODE_TEST, null, msgs);
      if (newNodeTest != null)
        msgs = ((InternalEObject)newNodeTest).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Xpath2Package.GENERAL_FORWARD_STEP__NODE_TEST, null, msgs);
      msgs = basicSetNodeTest(newNodeTest, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Xpath2Package.GENERAL_FORWARD_STEP__NODE_TEST, newNodeTest, newNodeTest));
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
      case Xpath2Package.GENERAL_FORWARD_STEP__NODE_TEST:
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
      case Xpath2Package.GENERAL_FORWARD_STEP__AXIS:
        return getAxis();
      case Xpath2Package.GENERAL_FORWARD_STEP__NODE_TEST:
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
      case Xpath2Package.GENERAL_FORWARD_STEP__AXIS:
        setAxis((ForwardAxisKind)newValue);
        return;
      case Xpath2Package.GENERAL_FORWARD_STEP__NODE_TEST:
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
      case Xpath2Package.GENERAL_FORWARD_STEP__AXIS:
        setAxis(AXIS_EDEFAULT);
        return;
      case Xpath2Package.GENERAL_FORWARD_STEP__NODE_TEST:
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
      case Xpath2Package.GENERAL_FORWARD_STEP__AXIS:
        return axis != AXIS_EDEFAULT;
      case Xpath2Package.GENERAL_FORWARD_STEP__NODE_TEST:
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
    result.append(" (axis: ");
    result.append(axis);
    result.append(')');
    return result.toString();
  }

} //GeneralForwardStepImpl
