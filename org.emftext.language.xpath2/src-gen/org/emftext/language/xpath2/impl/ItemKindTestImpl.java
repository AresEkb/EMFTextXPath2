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

import org.emftext.language.xpath2.ItemKindTest;
import org.emftext.language.xpath2.KindTest;
import org.emftext.language.xpath2.XPath2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Item Kind Test</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.impl.ItemKindTestImpl#getTest <em>Test</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ItemKindTestImpl extends ItemTypeImpl implements ItemKindTest {
    /**
     * The cached value of the '{@link #getTest() <em>Test</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTest()
     * @generated
     * @ordered
     */
    protected KindTest test;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ItemKindTestImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return XPath2Package.Literals.ITEM_KIND_TEST;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public KindTest getTest() {
        return test;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTest(KindTest newTest, NotificationChain msgs) {
        KindTest oldTest = test;
        test = newTest;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XPath2Package.ITEM_KIND_TEST__TEST, oldTest, newTest);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTest(KindTest newTest) {
        if (newTest != test) {
            NotificationChain msgs = null;
            if (test != null)
                msgs = ((InternalEObject)test).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XPath2Package.ITEM_KIND_TEST__TEST, null, msgs);
            if (newTest != null)
                msgs = ((InternalEObject)newTest).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XPath2Package.ITEM_KIND_TEST__TEST, null, msgs);
            msgs = basicSetTest(newTest, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XPath2Package.ITEM_KIND_TEST__TEST, newTest, newTest));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case XPath2Package.ITEM_KIND_TEST__TEST:
                return basicSetTest(null, msgs);
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
            case XPath2Package.ITEM_KIND_TEST__TEST:
                return getTest();
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
            case XPath2Package.ITEM_KIND_TEST__TEST:
                setTest((KindTest)newValue);
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
            case XPath2Package.ITEM_KIND_TEST__TEST:
                setTest((KindTest)null);
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
            case XPath2Package.ITEM_KIND_TEST__TEST:
                return test != null;
        }
        return super.eIsSet(featureID);
    }

} //ItemKindTestImpl
