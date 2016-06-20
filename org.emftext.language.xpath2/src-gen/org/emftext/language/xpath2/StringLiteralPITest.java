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
 * A representation of the model object '<em><b>String Literal PI Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.StringLiteralPITest#getLiteral <em>Literal</em>}</li>
 * </ul>
 *
 * @see org.emftext.language.xpath2.XPath2Package#getStringLiteralPITest()
 * @model
 * @generated
 */
public interface StringLiteralPITest extends PITest {
    /**
     * Returns the value of the '<em><b>Literal</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Literal</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Literal</em>' reference.
     * @see #setLiteral(StringLiteral)
     * @see org.emftext.language.xpath2.XPath2Package#getStringLiteralPITest_Literal()
     * @model required="true"
     * @generated
     */
    StringLiteral getLiteral();

    /**
     * Sets the value of the '{@link org.emftext.language.xpath2.StringLiteralPITest#getLiteral <em>Literal</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Literal</em>' reference.
     * @see #getLiteral()
     * @generated
     */
    void setLiteral(StringLiteral value);

} // StringLiteralPITest
