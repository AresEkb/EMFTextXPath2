/**
 * Copyright (c) 2013, 2014 Denis Nikiforov.
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

import org.emftext.language.xpath2.AbbrevForwardStep;
import org.emftext.language.xpath2.AbbrevForwardStepKind;
import org.emftext.language.xpath2.NodeTest;
import org.emftext.language.xpath2.Xpath2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abbrev Forward Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.impl.AbbrevForwardStepImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.impl.AbbrevForwardStepImpl#getNodeTest <em>Node Test</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AbbrevForwardStepImpl extends ForwardStepImpl implements AbbrevForwardStep {
    /**
     * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getKind()
     * @generated
     * @ordered
     */
    protected static final AbbrevForwardStepKind KIND_EDEFAULT = AbbrevForwardStepKind.CHILD;

    /**
     * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getKind()
     * @generated
     * @ordered
     */
    protected AbbrevForwardStepKind kind = KIND_EDEFAULT;

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
    public AbbrevForwardStepKind getKind() {
        return kind;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setKind(AbbrevForwardStepKind newKind) {
        AbbrevForwardStepKind oldKind = kind;
        kind = newKind == null ? KIND_EDEFAULT : newKind;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Xpath2Package.ABBREV_FORWARD_STEP__KIND, oldKind, kind));
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
        if (newNodeTest != nodeTest) {
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
        switch (featureID) {
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
        switch (featureID) {
            case Xpath2Package.ABBREV_FORWARD_STEP__KIND:
                return getKind();
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
        switch (featureID) {
            case Xpath2Package.ABBREV_FORWARD_STEP__KIND:
                setKind((AbbrevForwardStepKind)newValue);
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
        switch (featureID) {
            case Xpath2Package.ABBREV_FORWARD_STEP__KIND:
                setKind(KIND_EDEFAULT);
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
        switch (featureID) {
            case Xpath2Package.ABBREV_FORWARD_STEP__KIND:
                return kind != KIND_EDEFAULT;
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
        result.append(" (kind: ");
        result.append(kind);
        result.append(')');
        return result.toString();
    }

} //AbbrevForwardStepImpl
