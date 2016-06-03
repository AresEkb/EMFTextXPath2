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

import org.emftext.language.xpath2.CastExpr;
import org.emftext.language.xpath2.CastExprChild;
import org.emftext.language.xpath2.SingleType;
import org.emftext.language.xpath2.XPath2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cast Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.impl.CastExprImpl#getOperand <em>Operand</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.impl.CastExprImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CastExprImpl extends CastableExprChildImpl implements CastExpr {
	/**
	 * The cached value of the '{@link #getOperand() <em>Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperand()
	 * @generated
	 * @ordered
	 */
	protected CastExprChild operand;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected SingleType type;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CastExprImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XPath2Package.Literals.CAST_EXPR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CastExprChild getOperand() {
		return operand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOperand(CastExprChild newOperand, NotificationChain msgs) {
		CastExprChild oldOperand = operand;
		operand = newOperand;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XPath2Package.CAST_EXPR__OPERAND, oldOperand, newOperand);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperand(CastExprChild newOperand) {
		if (newOperand != operand) {
			NotificationChain msgs = null;
			if (operand != null)
				msgs = ((InternalEObject)operand).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XPath2Package.CAST_EXPR__OPERAND, null, msgs);
			if (newOperand != null)
				msgs = ((InternalEObject)newOperand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XPath2Package.CAST_EXPR__OPERAND, null, msgs);
			msgs = basicSetOperand(newOperand, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XPath2Package.CAST_EXPR__OPERAND, newOperand, newOperand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SingleType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetType(SingleType newType, NotificationChain msgs) {
		SingleType oldType = type;
		type = newType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XPath2Package.CAST_EXPR__TYPE, oldType, newType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(SingleType newType) {
		if (newType != type) {
			NotificationChain msgs = null;
			if (type != null)
				msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XPath2Package.CAST_EXPR__TYPE, null, msgs);
			if (newType != null)
				msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XPath2Package.CAST_EXPR__TYPE, null, msgs);
			msgs = basicSetType(newType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XPath2Package.CAST_EXPR__TYPE, newType, newType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XPath2Package.CAST_EXPR__OPERAND:
				return basicSetOperand(null, msgs);
			case XPath2Package.CAST_EXPR__TYPE:
				return basicSetType(null, msgs);
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
			case XPath2Package.CAST_EXPR__OPERAND:
				return getOperand();
			case XPath2Package.CAST_EXPR__TYPE:
				return getType();
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
			case XPath2Package.CAST_EXPR__OPERAND:
				setOperand((CastExprChild)newValue);
				return;
			case XPath2Package.CAST_EXPR__TYPE:
				setType((SingleType)newValue);
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
			case XPath2Package.CAST_EXPR__OPERAND:
				setOperand((CastExprChild)null);
				return;
			case XPath2Package.CAST_EXPR__TYPE:
				setType((SingleType)null);
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
			case XPath2Package.CAST_EXPR__OPERAND:
				return operand != null;
			case XPath2Package.CAST_EXPR__TYPE:
				return type != null;
		}
		return super.eIsSet(featureID);
	}

} //CastExprImpl
