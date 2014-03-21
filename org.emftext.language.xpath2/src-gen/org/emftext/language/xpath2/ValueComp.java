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
 * A representation of the model object '<em><b>Value Comp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.ValueComp#getOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getValueComp()
 * @model
 * @generated
 */
public interface ValueComp extends Comp {
    /**
     * Returns the value of the '<em><b>Operator</b></em>' attribute.
     * The literals are from the enumeration {@link org.emftext.language.xpath2.GeneralCompKind}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operator</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operator</em>' attribute.
     * @see org.emftext.language.xpath2.GeneralCompKind
     * @see #setOperator(GeneralCompKind)
     * @see org.emftext.language.xpath2.Xpath2Package#getValueComp_Operator()
     * @model required="true"
     * @generated
     */
    GeneralCompKind getOperator();

    /**
     * Sets the value of the '{@link org.emftext.language.xpath2.ValueComp#getOperator <em>Operator</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Operator</em>' attribute.
     * @see org.emftext.language.xpath2.GeneralCompKind
     * @see #getOperator()
     * @generated
     */
    void setOperator(GeneralCompKind value);

} // ValueComp
