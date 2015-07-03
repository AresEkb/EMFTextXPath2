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
 * A representation of the model object '<em><b>Abbrev Forward Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.AbbrevForwardStep#getKind <em>Kind</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.AbbrevForwardStep#getNodeTest <em>Node Test</em>}</li>
 * </ul>
 *
 * @see org.emftext.language.xpath2.XPath2Package#getAbbrevForwardStep()
 * @model
 * @generated
 */
public interface AbbrevForwardStep extends ForwardStep {
    /**
     * Returns the value of the '<em><b>Kind</b></em>' attribute.
     * The literals are from the enumeration {@link org.emftext.language.xpath2.AbbrevForwardStepKind}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Kind</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Kind</em>' attribute.
     * @see org.emftext.language.xpath2.AbbrevForwardStepKind
     * @see #setKind(AbbrevForwardStepKind)
     * @see org.emftext.language.xpath2.XPath2Package#getAbbrevForwardStep_Kind()
     * @model required="true"
     * @generated
     */
    AbbrevForwardStepKind getKind();

    /**
     * Sets the value of the '{@link org.emftext.language.xpath2.AbbrevForwardStep#getKind <em>Kind</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Kind</em>' attribute.
     * @see org.emftext.language.xpath2.AbbrevForwardStepKind
     * @see #getKind()
     * @generated
     */
    void setKind(AbbrevForwardStepKind value);

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
     * @see org.emftext.language.xpath2.XPath2Package#getAbbrevForwardStep_NodeTest()
     * @model containment="true" required="true"
     * @generated
     */
    NodeTest getNodeTest();

    /**
     * Sets the value of the '{@link org.emftext.language.xpath2.AbbrevForwardStep#getNodeTest <em>Node Test</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Node Test</em>' containment reference.
     * @see #getNodeTest()
     * @generated
     */
    void setNodeTest(NodeTest value);

} // AbbrevForwardStep
