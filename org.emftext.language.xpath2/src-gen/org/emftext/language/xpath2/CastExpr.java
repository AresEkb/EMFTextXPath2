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
 * A representation of the model object '<em><b>Cast Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.CastExpr#getOperand <em>Operand</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.CastExpr#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.emftext.language.xpath2.XPath2Package#getCastExpr()
 * @model
 * @generated
 */
public interface CastExpr extends CastableExprChild {
    /**
     * Returns the value of the '<em><b>Operand</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operand</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operand</em>' containment reference.
     * @see #setOperand(CastExprChild)
     * @see org.emftext.language.xpath2.XPath2Package#getCastExpr_Operand()
     * @model containment="true" required="true"
     * @generated
     */
    CastExprChild getOperand();

    /**
     * Sets the value of the '{@link org.emftext.language.xpath2.CastExpr#getOperand <em>Operand</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Operand</em>' containment reference.
     * @see #getOperand()
     * @generated
     */
    void setOperand(CastExprChild value);

    /**
     * Returns the value of the '<em><b>Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' containment reference.
     * @see #setType(SingleType)
     * @see org.emftext.language.xpath2.XPath2Package#getCastExpr_Type()
     * @model containment="true"
     * @generated
     */
    SingleType getType();

    /**
     * Sets the value of the '{@link org.emftext.language.xpath2.CastExpr#getType <em>Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' containment reference.
     * @see #getType()
     * @generated
     */
    void setType(SingleType value);

} // CastExpr
