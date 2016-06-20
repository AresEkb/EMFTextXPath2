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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Wildcard Element Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.WildcardElementTest#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.emftext.language.xpath2.XPath2Package#getWildcardElementTest()
 * @model
 * @generated
 */
public interface WildcardElementTest extends ElementTest {
    /**
     * Returns the value of the '<em><b>Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' containment reference.
     * @see #setType(OptionalAtomicType)
     * @see org.emftext.language.xpath2.XPath2Package#getWildcardElementTest_Type()
     * @model containment="true"
     * @generated
     */
    OptionalAtomicType getType();

    /**
     * Sets the value of the '{@link org.emftext.language.xpath2.WildcardElementTest#getType <em>Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' containment reference.
     * @see #getType()
     * @generated
     */
    void setType(OptionalAtomicType value);

} // WildcardElementTest
