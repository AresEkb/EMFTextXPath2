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
 * A representation of the model object '<em><b>General Forward Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.GeneralForwardStep#getAxis <em>Axis</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.GeneralForwardStep#getNodeTest <em>Node Test</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getGeneralForwardStep()
 * @model
 * @generated
 */
public interface GeneralForwardStep extends ForwardStep {
    /**
     * Returns the value of the '<em><b>Axis</b></em>' attribute.
     * The literals are from the enumeration {@link org.emftext.language.xpath2.ForwardAxisKind}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Axis</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Axis</em>' attribute.
     * @see org.emftext.language.xpath2.ForwardAxisKind
     * @see #setAxis(ForwardAxisKind)
     * @see org.emftext.language.xpath2.Xpath2Package#getGeneralForwardStep_Axis()
     * @model required="true"
     * @generated
     */
    ForwardAxisKind getAxis();

    /**
     * Sets the value of the '{@link org.emftext.language.xpath2.GeneralForwardStep#getAxis <em>Axis</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Axis</em>' attribute.
     * @see org.emftext.language.xpath2.ForwardAxisKind
     * @see #getAxis()
     * @generated
     */
    void setAxis(ForwardAxisKind value);

    /**
     * Returns the value of the '<em><b>Node Test</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Node Test</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Node Test</em>' containment reference.
     * @see #setNodeTest(NodeTest)
     * @see org.emftext.language.xpath2.Xpath2Package#getGeneralForwardStep_NodeTest()
     * @model containment="true" required="true"
     * @generated
     */
    NodeTest getNodeTest();

    /**
     * Sets the value of the '{@link org.emftext.language.xpath2.GeneralForwardStep#getNodeTest <em>Node Test</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Node Test</em>' containment reference.
     * @see #getNodeTest()
     * @generated
     */
    void setNodeTest(NodeTest value);

} // GeneralForwardStep
