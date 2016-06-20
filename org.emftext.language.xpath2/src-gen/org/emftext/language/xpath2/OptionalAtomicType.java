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
package org.emftext.language.xpath2;

import javax.xml.namespace.QName;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Optional Atomic Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.OptionalAtomicType#getName <em>Name</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.OptionalAtomicType#isOptional <em>Optional</em>}</li>
 * </ul>
 *
 * @see org.emftext.language.xpath2.XPath2Package#getOptionalAtomicType()
 * @model
 * @generated
 */
public interface OptionalAtomicType extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(QName)
     * @see org.emftext.language.xpath2.XPath2Package#getOptionalAtomicType_Name()
     * @model dataType="org.eclipse.emf.ecore.xml.type.QName" required="true"
     * @generated
     */
    QName getName();

    /**
     * Sets the value of the '{@link org.emftext.language.xpath2.OptionalAtomicType#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(QName value);

    /**
     * Returns the value of the '<em><b>Optional</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Optional</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Optional</em>' attribute.
     * @see #setOptional(boolean)
     * @see org.emftext.language.xpath2.XPath2Package#getOptionalAtomicType_Optional()
     * @model required="true"
     * @generated
     */
    boolean isOptional();

    /**
     * Sets the value of the '{@link org.emftext.language.xpath2.OptionalAtomicType#isOptional <em>Optional</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Optional</em>' attribute.
     * @see #isOptional()
     * @generated
     */
    void setOptional(boolean value);

} // OptionalAtomicType
