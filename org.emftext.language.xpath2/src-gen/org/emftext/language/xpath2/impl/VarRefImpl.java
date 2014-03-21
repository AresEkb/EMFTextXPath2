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

import javax.xml.namespace.QName;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.emftext.language.xpath2.VarRef;
import org.emftext.language.xpath2.Xpath2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Var Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.impl.VarRefImpl#getVarName <em>Var Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VarRefImpl extends PrimaryExprImpl implements VarRef {
    /**
     * The default value of the '{@link #getVarName() <em>Var Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVarName()
     * @generated
     * @ordered
     */
    protected static final QName VAR_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getVarName() <em>Var Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVarName()
     * @generated
     * @ordered
     */
    protected QName varName = VAR_NAME_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected VarRefImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return Xpath2Package.Literals.VAR_REF;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public QName getVarName() {
        return varName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setVarName(QName newVarName) {
        QName oldVarName = varName;
        varName = newVarName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Xpath2Package.VAR_REF__VAR_NAME, oldVarName, varName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case Xpath2Package.VAR_REF__VAR_NAME:
                return getVarName();
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
            case Xpath2Package.VAR_REF__VAR_NAME:
                setVarName((QName)newValue);
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
            case Xpath2Package.VAR_REF__VAR_NAME:
                setVarName(VAR_NAME_EDEFAULT);
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
            case Xpath2Package.VAR_REF__VAR_NAME:
                return VAR_NAME_EDEFAULT == null ? varName != null : !VAR_NAME_EDEFAULT.equals(varName);
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
        result.append(" (varName: ");
        result.append(varName);
        result.append(')');
        return result.toString();
    }

} //VarRefImpl
