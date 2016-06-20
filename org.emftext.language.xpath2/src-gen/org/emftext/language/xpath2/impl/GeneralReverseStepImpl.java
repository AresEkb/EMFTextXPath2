/**
 * Copyright (c) 2013, 2016 Denis Nikiforov.
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

import org.emftext.language.xpath2.GeneralReverseStep;
import org.emftext.language.xpath2.NodeTest;
import org.emftext.language.xpath2.ReverseAxisKind;
import org.emftext.language.xpath2.XPath2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>General Reverse Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.impl.GeneralReverseStepImpl#getAxis <em>Axis</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.impl.GeneralReverseStepImpl#getNodeTest <em>Node Test</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GeneralReverseStepImpl extends ReverseStepImpl implements GeneralReverseStep {
    /**
     * The default value of the '{@link #getAxis() <em>Axis</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAxis()
     * @generated
     * @ordered
     */
    protected static final ReverseAxisKind AXIS_EDEFAULT = ReverseAxisKind.PARENT;

    /**
     * The cached value of the '{@link #getAxis() <em>Axis</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAxis()
     * @generated
     * @ordered
     */
    protected ReverseAxisKind axis = AXIS_EDEFAULT;

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
    protected GeneralReverseStepImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return XPath2Package.Literals.GENERAL_REVERSE_STEP;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ReverseAxisKind getAxis() {
        return axis;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAxis(ReverseAxisKind newAxis) {
        ReverseAxisKind oldAxis = axis;
        axis = newAxis == null ? AXIS_EDEFAULT : newAxis;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XPath2Package.GENERAL_REVERSE_STEP__AXIS, oldAxis, axis));
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
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XPath2Package.GENERAL_REVERSE_STEP__NODE_TEST, oldNodeTest, newNodeTest);
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
        if (newNodeTest != nodeTest) {
            NotificationChain msgs = null;
            if (nodeTest != null)
                msgs = ((InternalEObject)nodeTest).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XPath2Package.GENERAL_REVERSE_STEP__NODE_TEST, null, msgs);
            if (newNodeTest != null)
                msgs = ((InternalEObject)newNodeTest).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XPath2Package.GENERAL_REVERSE_STEP__NODE_TEST, null, msgs);
            msgs = basicSetNodeTest(newNodeTest, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XPath2Package.GENERAL_REVERSE_STEP__NODE_TEST, newNodeTest, newNodeTest));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case XPath2Package.GENERAL_REVERSE_STEP__NODE_TEST:
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
        switch (featureID) {
            case XPath2Package.GENERAL_REVERSE_STEP__AXIS:
                return getAxis();
            case XPath2Package.GENERAL_REVERSE_STEP__NODE_TEST:
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
        switch (featureID) {
            case XPath2Package.GENERAL_REVERSE_STEP__AXIS:
                setAxis((ReverseAxisKind)newValue);
                return;
            case XPath2Package.GENERAL_REVERSE_STEP__NODE_TEST:
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
        switch (featureID) {
            case XPath2Package.GENERAL_REVERSE_STEP__AXIS:
                setAxis(AXIS_EDEFAULT);
                return;
            case XPath2Package.GENERAL_REVERSE_STEP__NODE_TEST:
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
        switch (featureID) {
            case XPath2Package.GENERAL_REVERSE_STEP__AXIS:
                return axis != AXIS_EDEFAULT;
            case XPath2Package.GENERAL_REVERSE_STEP__NODE_TEST:
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

} //GeneralReverseStepImpl
