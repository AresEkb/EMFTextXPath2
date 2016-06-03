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
package org.emftext.language.xpath2;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Item Sequence Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.ItemSequenceType#getItemType <em>Item Type</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.ItemSequenceType#getOccurrence <em>Occurrence</em>}</li>
 * </ul>
 *
 * @see org.emftext.language.xpath2.XPath2Package#getItemSequenceType()
 * @model
 * @generated
 */
public interface ItemSequenceType extends SequenceType {
	/**
	 * Returns the value of the '<em><b>Item Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Item Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Item Type</em>' containment reference.
	 * @see #setItemType(ItemType)
	 * @see org.emftext.language.xpath2.XPath2Package#getItemSequenceType_ItemType()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ItemType getItemType();

	/**
	 * Sets the value of the '{@link org.emftext.language.xpath2.ItemSequenceType#getItemType <em>Item Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Item Type</em>' containment reference.
	 * @see #getItemType()
	 * @generated
	 */
	void setItemType(ItemType value);

	/**
	 * Returns the value of the '<em><b>Occurrence</b></em>' attribute.
	 * The literals are from the enumeration {@link org.emftext.language.xpath2.OccurrenceIndicatorKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Occurrence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Occurrence</em>' attribute.
	 * @see org.emftext.language.xpath2.OccurrenceIndicatorKind
	 * @see #setOccurrence(OccurrenceIndicatorKind)
	 * @see org.emftext.language.xpath2.XPath2Package#getItemSequenceType_Occurrence()
	 * @model required="true"
	 * @generated
	 */
	OccurrenceIndicatorKind getOccurrence();

	/**
	 * Sets the value of the '{@link org.emftext.language.xpath2.ItemSequenceType#getOccurrence <em>Occurrence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Occurrence</em>' attribute.
	 * @see org.emftext.language.xpath2.OccurrenceIndicatorKind
	 * @see #getOccurrence()
	 * @generated
	 */
	void setOccurrence(OccurrenceIndicatorKind value);

} // ItemSequenceType
