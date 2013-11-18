/**
 * Copyright (c) 2013 Denis Nikiforov.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Denis Nikiforov - initial API and implementation
 */
package org.emftext.language.xpath2;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.ForExpr#getIterator <em>Iterator</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.ForExpr#getReturn <em>Return</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getForExpr()
 * @model
 * @generated
 */
public interface ForExpr extends ExprSingle {
	/**
   * Returns the value of the '<em><b>Iterator</b></em>' containment reference list.
   * The list contents are of type {@link org.emftext.language.xpath2.Iterator}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterator</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Iterator</em>' containment reference list.
   * @see org.emftext.language.xpath2.Xpath2Package#getForExpr_Iterator()
   * @model containment="true" required="true"
   * @generated
   */
	EList<Iterator> getIterator();

	/**
   * Returns the value of the '<em><b>Return</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Return</em>' containment reference.
   * @see #setReturn(ExprSingle)
   * @see org.emftext.language.xpath2.Xpath2Package#getForExpr_Return()
   * @model containment="true" required="true"
   * @generated
   */
	ExprSingle getReturn();

	/**
   * Sets the value of the '{@link org.emftext.language.xpath2.ForExpr#getReturn <em>Return</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Return</em>' containment reference.
   * @see #getReturn()
   * @generated
   */
	void setReturn(ExprSingle value);

} // ForExpr
