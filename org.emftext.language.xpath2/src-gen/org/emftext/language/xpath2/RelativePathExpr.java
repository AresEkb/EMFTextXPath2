/**
 */
package org.emftext.language.xpath2;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relative Path Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.RelativePathExpr#getStep <em>Step</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.RelativePathExpr#getSeparator <em>Separator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getRelativePathExpr()
 * @model
 * @generated
 */
public interface RelativePathExpr extends EObject {
	/**
   * Returns the value of the '<em><b>Step</b></em>' containment reference list.
   * The list contents are of type {@link org.emftext.language.xpath2.StepExpr}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Step</em>' containment reference list.
   * @see org.emftext.language.xpath2.Xpath2Package#getRelativePathExpr_Step()
   * @model containment="true" required="true"
   * @generated
   */
	EList<StepExpr> getStep();

	/**
   * Returns the value of the '<em><b>Separator</b></em>' containment reference list.
   * The list contents are of type {@link org.emftext.language.xpath2.PathSeparator}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Separator</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Separator</em>' containment reference list.
   * @see org.emftext.language.xpath2.Xpath2Package#getRelativePathExpr_Separator()
   * @model containment="true"
   * @generated
   */
	EList<PathSeparator> getSeparator();

} // RelativePathExpr
