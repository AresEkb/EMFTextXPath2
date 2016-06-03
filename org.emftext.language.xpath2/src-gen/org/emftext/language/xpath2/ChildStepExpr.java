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
 * A representation of the model object '<em><b>Child Step Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.ChildStepExpr#getStep <em>Step</em>}</li>
 * </ul>
 *
 * @see org.emftext.language.xpath2.XPath2Package#getChildStepExpr()
 * @model
 * @generated
 */
public interface ChildStepExpr extends PathExprChild {
	/**
	 * Returns the value of the '<em><b>Step</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step</em>' containment reference.
	 * @see #setStep(StepExprChild)
	 * @see org.emftext.language.xpath2.XPath2Package#getChildStepExpr_Step()
	 * @model containment="true" required="true"
	 * @generated
	 */
	StepExprChild getStep();

	/**
	 * Sets the value of the '{@link org.emftext.language.xpath2.ChildStepExpr#getStep <em>Step</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step</em>' containment reference.
	 * @see #getStep()
	 * @generated
	 */
	void setStep(StepExprChild value);

} // ChildStepExpr
