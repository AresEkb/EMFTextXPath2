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
 * A representation of the model object '<em><b>Filter Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.FilterExpr#getPrimaryExpr <em>Primary Expr</em>}</li>
 * </ul>
 *
 * @see org.emftext.language.xpath2.XPath2Package#getFilterExpr()
 * @model
 * @generated
 */
public interface FilterExpr extends StepExpr {
    /**
     * Returns the value of the '<em><b>Primary Expr</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Primary Expr</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Primary Expr</em>' containment reference.
     * @see #setPrimaryExpr(FilterExprChild)
     * @see org.emftext.language.xpath2.XPath2Package#getFilterExpr_PrimaryExpr()
     * @model containment="true" required="true"
     * @generated
     */
    FilterExprChild getPrimaryExpr();

    /**
     * Sets the value of the '{@link org.emftext.language.xpath2.FilterExpr#getPrimaryExpr <em>Primary Expr</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Primary Expr</em>' containment reference.
     * @see #getPrimaryExpr()
     * @generated
     */
    void setPrimaryExpr(FilterExprChild value);

} // FilterExpr
