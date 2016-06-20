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

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.emftext.language.xpath2.IntersectExceptExpr;
import org.emftext.language.xpath2.IntersectExceptExprChild;
import org.emftext.language.xpath2.IntersectExceptOpKind;
import org.emftext.language.xpath2.XPath2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Intersect Except Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.impl.IntersectExceptExprImpl#getOperand <em>Operand</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.impl.IntersectExceptExprImpl#getOperator <em>Operator</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntersectExceptExprImpl extends UnionExprChildImpl implements IntersectExceptExpr {
    /**
     * The cached value of the '{@link #getOperand() <em>Operand</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOperand()
     * @generated
     * @ordered
     */
    protected EList<IntersectExceptExprChild> operand;

    /**
     * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOperator()
     * @generated
     * @ordered
     */
    protected EList<IntersectExceptOpKind> operator;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IntersectExceptExprImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return XPath2Package.Literals.INTERSECT_EXCEPT_EXPR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<IntersectExceptExprChild> getOperand() {
        if (operand == null) {
            operand = new EObjectContainmentEList<IntersectExceptExprChild>(IntersectExceptExprChild.class, this, XPath2Package.INTERSECT_EXCEPT_EXPR__OPERAND);
        }
        return operand;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<IntersectExceptOpKind> getOperator() {
        if (operator == null) {
            operator = new EDataTypeEList<IntersectExceptOpKind>(IntersectExceptOpKind.class, this, XPath2Package.INTERSECT_EXCEPT_EXPR__OPERATOR);
        }
        return operator;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case XPath2Package.INTERSECT_EXCEPT_EXPR__OPERAND:
                return ((InternalEList<?>)getOperand()).basicRemove(otherEnd, msgs);
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
            case XPath2Package.INTERSECT_EXCEPT_EXPR__OPERAND:
                return getOperand();
            case XPath2Package.INTERSECT_EXCEPT_EXPR__OPERATOR:
                return getOperator();
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
            case XPath2Package.INTERSECT_EXCEPT_EXPR__OPERAND:
                getOperand().clear();
                getOperand().addAll((Collection<? extends IntersectExceptExprChild>)newValue);
                return;
            case XPath2Package.INTERSECT_EXCEPT_EXPR__OPERATOR:
                getOperator().clear();
                getOperator().addAll((Collection<? extends IntersectExceptOpKind>)newValue);
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
            case XPath2Package.INTERSECT_EXCEPT_EXPR__OPERAND:
                getOperand().clear();
                return;
            case XPath2Package.INTERSECT_EXCEPT_EXPR__OPERATOR:
                getOperator().clear();
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
            case XPath2Package.INTERSECT_EXCEPT_EXPR__OPERAND:
                return operand != null && !operand.isEmpty();
            case XPath2Package.INTERSECT_EXCEPT_EXPR__OPERATOR:
                return operator != null && !operator.isEmpty();
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
        result.append(" (operator: ");
        result.append(operator);
        result.append(')');
        return result.toString();
    }

} //IntersectExceptExprImpl
