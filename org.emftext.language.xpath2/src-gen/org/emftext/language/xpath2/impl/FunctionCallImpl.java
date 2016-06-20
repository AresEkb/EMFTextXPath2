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

import java.util.Collection;

import javax.xml.namespace.QName;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.emftext.language.xpath2.ExprSingle;
import org.emftext.language.xpath2.FunctionCall;
import org.emftext.language.xpath2.XPath2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.impl.FunctionCallImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.impl.FunctionCallImpl#getArg <em>Arg</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FunctionCallImpl extends PrimaryExprImpl implements FunctionCall {
    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final QName NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected QName name = NAME_EDEFAULT;

    /**
     * The cached value of the '{@link #getArg() <em>Arg</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getArg()
     * @generated
     * @ordered
     */
    protected EList<ExprSingle> arg;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FunctionCallImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return XPath2Package.Literals.FUNCTION_CALL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public QName getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName(QName newName) {
        QName oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XPath2Package.FUNCTION_CALL__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ExprSingle> getArg() {
        if (arg == null) {
            arg = new EObjectContainmentEList<ExprSingle>(ExprSingle.class, this, XPath2Package.FUNCTION_CALL__ARG);
        }
        return arg;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case XPath2Package.FUNCTION_CALL__ARG:
                return ((InternalEList<?>)getArg()).basicRemove(otherEnd, msgs);
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
            case XPath2Package.FUNCTION_CALL__NAME:
                return getName();
            case XPath2Package.FUNCTION_CALL__ARG:
                return getArg();
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
        switch (featureID) {
            case XPath2Package.FUNCTION_CALL__NAME:
                setName((QName)newValue);
                return;
            case XPath2Package.FUNCTION_CALL__ARG:
                getArg().clear();
                getArg().addAll((Collection<? extends ExprSingle>)newValue);
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
            case XPath2Package.FUNCTION_CALL__NAME:
                setName(NAME_EDEFAULT);
                return;
            case XPath2Package.FUNCTION_CALL__ARG:
                getArg().clear();
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
            case XPath2Package.FUNCTION_CALL__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case XPath2Package.FUNCTION_CALL__ARG:
                return arg != null && !arg.isEmpty();
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
        result.append(" (name: ");
        result.append(name);
        result.append(')');
        return result.toString();
    }

} //FunctionCallImpl
