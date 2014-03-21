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
 * A representation of the model object '<em><b>Namespace Wildcard</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.NamespaceWildcard#getLocalName <em>Local Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getNamespaceWildcard()
 * @model
 * @generated
 */
public interface NamespaceWildcard extends Wildcard {
    /**
     * Returns the value of the '<em><b>Local Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Local Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Local Name</em>' attribute.
     * @see #setLocalName(String)
     * @see org.emftext.language.xpath2.Xpath2Package#getNamespaceWildcard_LocalName()
     * @model required="true"
     * @generated
     */
    String getLocalName();

    /**
     * Sets the value of the '{@link org.emftext.language.xpath2.NamespaceWildcard#getLocalName <em>Local Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Local Name</em>' attribute.
     * @see #getLocalName()
     * @generated
     */
    void setLocalName(String value);

} // NamespaceWildcard
