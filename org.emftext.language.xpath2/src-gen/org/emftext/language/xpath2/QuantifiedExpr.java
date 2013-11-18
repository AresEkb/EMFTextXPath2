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
 * A representation of the model object '<em><b>Quantified Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.QuantifiedExpr#getQuantifier <em>Quantifier</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.QuantifiedExpr#getIterator <em>Iterator</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.QuantifiedExpr#getSatisfies <em>Satisfies</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getQuantifiedExpr()
 * @model
 * @generated
 */
public interface QuantifiedExpr extends ExprSingle {
	/**
   * Returns the value of the '<em><b>Quantifier</b></em>' attribute.
   * The literals are from the enumeration {@link org.emftext.language.xpath2.QuantifierKind}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quantifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Quantifier</em>' attribute.
   * @see org.emftext.language.xpath2.QuantifierKind
   * @see #setQuantifier(QuantifierKind)
   * @see org.emftext.language.xpath2.Xpath2Package#getQuantifiedExpr_Quantifier()
   * @model required="true"
   * @generated
   */
	QuantifierKind getQuantifier();

	/**
   * Sets the value of the '{@link org.emftext.language.xpath2.QuantifiedExpr#getQuantifier <em>Quantifier</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Quantifier</em>' attribute.
   * @see org.emftext.language.xpath2.QuantifierKind
   * @see #getQuantifier()
   * @generated
   */
	void setQuantifier(QuantifierKind value);

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
   * @see org.emftext.language.xpath2.Xpath2Package#getQuantifiedExpr_Iterator()
   * @model containment="true" required="true"
   * @generated
   */
	EList<Iterator> getIterator();

	/**
   * Returns the value of the '<em><b>Satisfies</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Satisfies</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Satisfies</em>' containment reference.
   * @see #setSatisfies(ExprSingle)
   * @see org.emftext.language.xpath2.Xpath2Package#getQuantifiedExpr_Satisfies()
   * @model containment="true" required="true"
   * @generated
   */
	ExprSingle getSatisfies();

	/**
   * Sets the value of the '{@link org.emftext.language.xpath2.QuantifiedExpr#getSatisfies <em>Satisfies</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Satisfies</em>' containment reference.
   * @see #getSatisfies()
   * @generated
   */
	void setSatisfies(ExprSingle value);

} // QuantifiedExpr
