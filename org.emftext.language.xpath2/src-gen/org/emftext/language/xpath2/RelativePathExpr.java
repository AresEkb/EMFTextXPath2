/**
 */
package org.emftext.language.xpath2;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relative Path Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.RelativePathExpr#getHead <em>Head</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.RelativePathExpr#getTail <em>Tail</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getRelativePathExpr()
 * @model
 * @generated
 */
public interface RelativePathExpr extends PathExpr {
	/**
   * Returns the value of the '<em><b>Head</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Head</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Head</em>' containment reference.
   * @see #setHead(StepExpr)
   * @see org.emftext.language.xpath2.Xpath2Package#getRelativePathExpr_Head()
   * @model containment="true" required="true"
   * @generated
   */
	StepExpr getHead();

	/**
   * Sets the value of the '{@link org.emftext.language.xpath2.RelativePathExpr#getHead <em>Head</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Head</em>' containment reference.
   * @see #getHead()
   * @generated
   */
	void setHead(StepExpr value);

	/**
   * Returns the value of the '<em><b>Tail</b></em>' containment reference list.
   * The list contents are of type {@link org.emftext.language.xpath2.TailPathExpr}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tail</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Tail</em>' containment reference list.
   * @see org.emftext.language.xpath2.Xpath2Package#getRelativePathExpr_Tail()
   * @model containment="true"
   * @generated
   */
	EList<TailPathExpr> getTail();

} // RelativePathExpr
