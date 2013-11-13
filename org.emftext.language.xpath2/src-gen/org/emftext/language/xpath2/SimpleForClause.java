/**
 */
package org.emftext.language.xpath2;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple For Clause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.SimpleForClause#getIterator <em>Iterator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getSimpleForClause()
 * @model
 * @generated
 */
public interface SimpleForClause extends EObject {
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
   * @see org.emftext.language.xpath2.Xpath2Package#getSimpleForClause_Iterator()
   * @model containment="true" required="true"
   * @generated
   */
	EList<Iterator> getIterator();

} // SimpleForClause
