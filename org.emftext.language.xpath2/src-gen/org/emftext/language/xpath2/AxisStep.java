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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Axis Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.AxisStep#getPredicate <em>Predicate</em>}</li>
 * </ul>
 *
 * @see org.emftext.language.xpath2.XPath2Package#getAxisStep()
 * @model abstract="true"
 * @generated
 */
public interface AxisStep extends StepExpr {
    /**
     * Returns the value of the '<em><b>Predicate</b></em>' containment reference list.
     * The list contents are of type {@link org.emftext.language.xpath2.Predicate}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Predicate</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Predicate</em>' containment reference list.
     * @see org.emftext.language.xpath2.XPath2Package#getAxisStep_Predicate()
     * @model containment="true"
     * @generated
     */
    EList<Predicate> getPredicate();

} // AxisStep
