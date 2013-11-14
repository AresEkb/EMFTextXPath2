/**
 */
package org.emftext.language.xpath2;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Comment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.xpath2.Comment#getText <em>Text</em>}</li>
 *   <li>{@link org.emftext.language.xpath2.Comment#getComment <em>Comment</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.xpath2.Xpath2Package#getComment()
 * @model
 * @generated
 */
public interface Comment extends EObject {
    /**
   * Returns the value of the '<em><b>Text</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Text</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
   * @return the value of the '<em>Text</em>' attribute list.
   * @see org.emftext.language.xpath2.Xpath2Package#getComment_Text()
   * @model
   * @generated
   */
    EList<String> getText();

    /**
   * Returns the value of the '<em><b>Comment</b></em>' containment reference list.
   * The list contents are of type {@link org.emftext.language.xpath2.Comment}.
   * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Comment</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
   * @return the value of the '<em>Comment</em>' containment reference list.
   * @see org.emftext.language.xpath2.Xpath2Package#getComment_Comment()
   * @model containment="true"
   * @generated
   */
    EList<Comment> getComment();

} // Comment
