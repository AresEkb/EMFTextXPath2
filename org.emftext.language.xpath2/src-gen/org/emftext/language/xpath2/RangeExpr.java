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
 * A representation of the model object '<em><b>Range Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.RangeExpr#getFrom <em>From</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.RangeExpr#getTo <em>To</em>}</li>
 * </ul>
 *
 * @see org.emftext.language.xpath2.XPath2Package#getRangeExpr()
 * @model
 * @generated
 */
public interface RangeExpr extends ComparisonExprChild {
    /**
     * Returns the value of the '<em><b>From</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>From</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>From</em>' containment reference.
     * @see #setFrom(RangeExprChild)
     * @see org.emftext.language.xpath2.XPath2Package#getRangeExpr_From()
     * @model containment="true" required="true"
     * @generated
     */
    RangeExprChild getFrom();

    /**
     * Sets the value of the '{@link org.emftext.language.xpath2.RangeExpr#getFrom <em>From</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>From</em>' containment reference.
     * @see #getFrom()
     * @generated
     */
    void setFrom(RangeExprChild value);

    /**
     * Returns the value of the '<em><b>To</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>To</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>To</em>' containment reference.
     * @see #setTo(RangeExprChild)
     * @see org.emftext.language.xpath2.XPath2Package#getRangeExpr_To()
     * @model containment="true"
     * @generated
     */
    RangeExprChild getTo();

    /**
     * Sets the value of the '{@link org.emftext.language.xpath2.RangeExpr#getTo <em>To</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>To</em>' containment reference.
     * @see #getTo()
     * @generated
     */
    void setTo(RangeExprChild value);

} // RangeExpr
