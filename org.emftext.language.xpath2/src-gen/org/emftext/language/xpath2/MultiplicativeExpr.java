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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiplicative Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.MultiplicativeExpr#getOperand <em>Operand</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.MultiplicativeExpr#getOperator <em>Operator</em>}</li>
 * </ul>
 *
 * @see org.emftext.language.xpath2.XPath2Package#getMultiplicativeExpr()
 * @model
 * @generated
 */
public interface MultiplicativeExpr extends AdditiveExprChild {
    /**
     * Returns the value of the '<em><b>Operand</b></em>' containment reference list.
     * The list contents are of type {@link org.emftext.language.xpath2.MultiplicativeExprChild}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operand</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operand</em>' containment reference list.
     * @see org.emftext.language.xpath2.XPath2Package#getMultiplicativeExpr_Operand()
     * @model containment="true" required="true"
     * @generated
     */
    EList<MultiplicativeExprChild> getOperand();

    /**
     * Returns the value of the '<em><b>Operator</b></em>' attribute list.
     * The list contents are of type {@link org.emftext.language.xpath2.MultiplicativeOpKind}.
     * The literals are from the enumeration {@link org.emftext.language.xpath2.MultiplicativeOpKind}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operator</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operator</em>' attribute list.
     * @see org.emftext.language.xpath2.MultiplicativeOpKind
     * @see org.emftext.language.xpath2.XPath2Package#getMultiplicativeExpr_Operator()
     * @model unique="false"
     * @generated
     */
    EList<MultiplicativeOpKind> getOperator();

} // MultiplicativeExpr
