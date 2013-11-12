/**
 */
package org.emftext.language.xpath2;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple For Clause Iterator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.SimpleForClauseIterator#getVarName <em>Var Name</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.SimpleForClauseIterator#getList <em>List</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getSimpleForClauseIterator()
 * @model
 * @generated
 */
public interface SimpleForClauseIterator extends EObject {
	/**
   * Returns the value of the '<em><b>Var Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Var Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Var Name</em>' attribute.
   * @see #setVarName(String)
   * @see org.emftext.language.xpath2.Xpath2Package#getSimpleForClauseIterator_VarName()
   * @model required="true"
   * @generated
   */
	String getVarName();

	/**
   * Sets the value of the '{@link org.emftext.language.xpath2.SimpleForClauseIterator#getVarName <em>Var Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Var Name</em>' attribute.
   * @see #getVarName()
   * @generated
   */
	void setVarName(String value);

	/**
   * Returns the value of the '<em><b>List</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>List</em>' containment reference.
   * @see #setList(ExprSingle)
   * @see org.emftext.language.xpath2.Xpath2Package#getSimpleForClauseIterator_List()
   * @model containment="true" required="true"
   * @generated
   */
	ExprSingle getList();

	/**
   * Sets the value of the '{@link org.emftext.language.xpath2.SimpleForClauseIterator#getList <em>List</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>List</em>' containment reference.
   * @see #getList()
   * @generated
   */
	void setList(ExprSingle value);

} // SimpleForClauseIterator
