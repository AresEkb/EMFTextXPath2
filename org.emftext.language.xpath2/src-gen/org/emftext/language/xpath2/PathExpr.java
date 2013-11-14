/**
 */
package org.emftext.language.xpath2;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Path Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.PathExpr#getStep <em>Step</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getPathExpr()
 * @model
 * @generated
 */
public interface PathExpr extends ValueExpr {
    /**
   * Returns the value of the '<em><b>Step</b></em>' containment reference list.
   * The list contents are of type {@link org.emftext.language.xpath2.PathExprChild}.
   * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Step</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
   * @return the value of the '<em>Step</em>' containment reference list.
   * @see org.emftext.language.xpath2.Xpath2Package#getPathExpr_Step()
   * @model containment="true" required="true"
   * @generated
   */
    EList<PathExprChild> getStep();

} // PathExpr
