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

import javax.xml.namespace.QName;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Name Attribute Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.NameAttributeTest#getName <em>Name</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.NameAttributeTest#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getNameAttributeTest()
 * @model
 * @generated
 */
public interface NameAttributeTest extends AttributeTest {
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
     * @see org.emftext.language.xpath2.Xpath2Package#getNameAttributeTest_Name()
     * @model dataType="org.eclipse.emf.ecore.xml.type.QName" required="true"
     * @generated
     */
    QName getName();

    /**
     * Sets the value of the '{@link org.emftext.language.xpath2.NameAttributeTest#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(QName value);

    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' attribute.
     * @see #setType(QName)
     * @see org.emftext.language.xpath2.Xpath2Package#getNameAttributeTest_Type()
     * @model dataType="org.eclipse.emf.ecore.xml.type.QName"
     * @generated
     */
    QName getType();

    /**
     * Sets the value of the '{@link org.emftext.language.xpath2.NameAttributeTest#getType <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' attribute.
     * @see #getType()
     * @generated
     */
    void setType(QName value);

} // NameAttributeTest
