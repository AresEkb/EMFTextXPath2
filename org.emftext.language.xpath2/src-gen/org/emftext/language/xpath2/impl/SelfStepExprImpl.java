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

import org.emftext.language.xpath2.SelfStepExpr;
import org.emftext.language.xpath2.StepExprChild;
import org.emftext.language.xpath2.XPath2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Self Step Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.impl.SelfStepExprImpl#getStep <em>Step</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SelfStepExprImpl extends PathExprChildImpl implements SelfStepExpr {
    /**
     * The cached value of the '{@link #getStep() <em>Step</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStep()
     * @generated
     * @ordered
     */
    protected StepExprChild step;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SelfStepExprImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return XPath2Package.Literals.SELF_STEP_EXPR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public StepExprChild getStep() {
        return step;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetStep(StepExprChild newStep, NotificationChain msgs) {
        StepExprChild oldStep = step;
        step = newStep;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XPath2Package.SELF_STEP_EXPR__STEP, oldStep, newStep);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setStep(StepExprChild newStep) {
        if (newStep != step) {
            NotificationChain msgs = null;
            if (step != null)
                msgs = ((InternalEObject)step).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XPath2Package.SELF_STEP_EXPR__STEP, null, msgs);
            if (newStep != null)
                msgs = ((InternalEObject)newStep).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XPath2Package.SELF_STEP_EXPR__STEP, null, msgs);
            msgs = basicSetStep(newStep, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, XPath2Package.SELF_STEP_EXPR__STEP, newStep, newStep));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case XPath2Package.SELF_STEP_EXPR__STEP:
                return basicSetStep(null, msgs);
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
            case XPath2Package.SELF_STEP_EXPR__STEP:
                return getStep();
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
            case XPath2Package.SELF_STEP_EXPR__STEP:
                setStep((StepExprChild)newValue);
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
            case XPath2Package.SELF_STEP_EXPR__STEP:
                setStep((StepExprChild)null);
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
            case XPath2Package.SELF_STEP_EXPR__STEP:
                return step != null;
        }
        return super.eIsSet(featureID);
    }

} //SelfStepExprImpl
