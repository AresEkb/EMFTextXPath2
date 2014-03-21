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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iterator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.Iterator#getVarName <em>Var Name</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.Iterator#getList <em>List</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getIterator()
 * @model
 * @generated
 */
public interface Iterator extends EObject {
    /**
     * Returns the value of the '<em><b>Var Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Var Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Var Name</em>' attribute.
     * @see #setVarName(QName)
     * @see org.emftext.language.xpath2.Xpath2Package#getIterator_VarName()
     * @model dataType="org.eclipse.emf.ecore.xml.type.QName" required="true"
     * @generated
     */
    QName getVarName();

    /**
     * Sets the value of the '{@link org.emftext.language.xpath2.Iterator#getVarName <em>Var Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Var Name</em>' attribute.
     * @see #getVarName()
     * @generated
     */
    void setVarName(QName value);

    /**
     * Returns the value of the '<em><b>List</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>List</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>List</em>' containment reference.
     * @see #setList(ExprSingle)
     * @see org.emftext.language.xpath2.Xpath2Package#getIterator_List()
     * @model containment="true" required="true"
     * @generated
     */
    ExprSingle getList();

    /**
     * Sets the value of the '{@link org.emftext.language.xpath2.Iterator#getList <em>List</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>List</em>' containment reference.
     * @see #getList()
     * @generated
     */
    void setList(ExprSingle value);

} // Iterator
