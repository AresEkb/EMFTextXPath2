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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abbrev Reverse Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.AbbrevReverseStep#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getAbbrevReverseStep()
 * @model
 * @generated
 */
public interface AbbrevReverseStep extends ReverseStep
{
  /**
   * Returns the value of the '<em><b>Kind</b></em>' attribute.
   * The literals are from the enumeration {@link org.emftext.language.xpath2.AbbrevReverseStepKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Kind</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Kind</em>' attribute.
   * @see org.emftext.language.xpath2.AbbrevReverseStepKind
   * @see #setKind(AbbrevReverseStepKind)
   * @see org.emftext.language.xpath2.Xpath2Package#getAbbrevReverseStep_Kind()
   * @model required="true"
   * @generated
   */
  AbbrevReverseStepKind getKind();

  /**
   * Sets the value of the '{@link org.emftext.language.xpath2.AbbrevReverseStep#getKind <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Kind</em>' attribute.
   * @see org.emftext.language.xpath2.AbbrevReverseStepKind
   * @see #getKind()
   * @generated
   */
  void setKind(AbbrevReverseStepKind value);

} // AbbrevReverseStep
