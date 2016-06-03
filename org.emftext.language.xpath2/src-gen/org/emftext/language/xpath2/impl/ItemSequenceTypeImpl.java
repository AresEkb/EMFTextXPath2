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

import org.emftext.language.xpath2.ItemSequenceType;
import org.emftext.language.xpath2.ItemType;
import org.emftext.language.xpath2.OccurrenceIndicatorKind;
import org.emftext.language.xpath2.XPath2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Item Sequence Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.impl.ItemSequenceTypeImpl#getItemType <em>Item Type</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.impl.ItemSequenceTypeImpl#getOccurrence <em>Occurrence</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ItemSequenceTypeImpl extends SequenceTypeImpl implements ItemSequenceType {
	/**
	 * The cached value of the '{@link #getItemType() <em>Item Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItemType()
	 * @generated
	 * @ordered
	 */
	protected ItemType itemType;

	/**
	 * The default value of the '{@link #getOccurrence() <em>Occurrence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOccurrence()
	 * @generated
	 * @ordered
	 */
	protected static final OccurrenceIndicatorKind OCCURRENCE_EDEFAULT = OccurrenceIndicatorKind.MANDATORY;

	/**
	 * The cached value of the '{@link #getOccurrence() <em>Occurrence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOccurrence()
	 * @generated
	 * @ordered
	 */
	protected OccurrenceIndicatorKind occurrence = OCCURRENCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ItemSequenceTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XPath2Package.Literals.ITEM_SEQUENCE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ItemType getItemType() {
		return itemType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetItemType(ItemType newItemType, NotificationChain msgs) {
		ItemType oldItemType = itemType;
		itemType = newItemType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XPath2Package.ITEM_SEQUENCE_TYPE__ITEM_TYPE, oldItemType, newItemType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItemType(ItemType newItemType) {
		if (newItemType != itemType) {
			NotificationChain msgs = null;
			if (itemType != null)
				msgs = ((InternalEObject)itemType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XPath2Package.ITEM_SEQUENCE_TYPE__ITEM_TYPE, null, msgs);
			if (newItemType != null)
				msgs = ((InternalEObject)newItemType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XPath2Package.ITEM_SEQUENCE_TYPE__ITEM_TYPE, null, msgs);
			msgs = basicSetItemType(newItemType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XPath2Package.ITEM_SEQUENCE_TYPE__ITEM_TYPE, newItemType, newItemType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OccurrenceIndicatorKind getOccurrence() {
		return occurrence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOccurrence(OccurrenceIndicatorKind newOccurrence) {
		OccurrenceIndicatorKind oldOccurrence = occurrence;
		occurrence = newOccurrence == null ? OCCURRENCE_EDEFAULT : newOccurrence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XPath2Package.ITEM_SEQUENCE_TYPE__OCCURRENCE, oldOccurrence, occurrence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XPath2Package.ITEM_SEQUENCE_TYPE__ITEM_TYPE:
				return basicSetItemType(null, msgs);
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
			case XPath2Package.ITEM_SEQUENCE_TYPE__ITEM_TYPE:
				return getItemType();
			case XPath2Package.ITEM_SEQUENCE_TYPE__OCCURRENCE:
				return getOccurrence();
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
			case XPath2Package.ITEM_SEQUENCE_TYPE__ITEM_TYPE:
				setItemType((ItemType)newValue);
				return;
			case XPath2Package.ITEM_SEQUENCE_TYPE__OCCURRENCE:
				setOccurrence((OccurrenceIndicatorKind)newValue);
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
			case XPath2Package.ITEM_SEQUENCE_TYPE__ITEM_TYPE:
				setItemType((ItemType)null);
				return;
			case XPath2Package.ITEM_SEQUENCE_TYPE__OCCURRENCE:
				setOccurrence(OCCURRENCE_EDEFAULT);
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
			case XPath2Package.ITEM_SEQUENCE_TYPE__ITEM_TYPE:
				return itemType != null;
			case XPath2Package.ITEM_SEQUENCE_TYPE__OCCURRENCE:
				return occurrence != OCCURRENCE_EDEFAULT;
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
		result.append(" (occurrence: ");
		result.append(occurrence);
		result.append(')');
		return result.toString();
	}

} //ItemSequenceTypeImpl
