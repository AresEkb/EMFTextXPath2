/**
 */
package org.emftext.language.xpath2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Occurrence Indicator Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.emftext.language.xpath2.Xpath2Package#getOccurrenceIndicatorKind()
 * @model
 * @generated
 */
public enum OccurrenceIndicatorKind implements Enumerator {
	/**
   * The '<em><b>Mandatory</b></em>' literal object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #MANDATORY_VALUE
   * @generated
   * @ordered
   */
	MANDATORY(0, "mandatory", "mandatory"),

	/**
   * The '<em><b>Optional</b></em>' literal object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #OPTIONAL_VALUE
   * @generated
   * @ordered
   */
	OPTIONAL(0, "optional", "optional"),

	/**
   * The '<em><b>Star</b></em>' literal object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #STAR_VALUE
   * @generated
   * @ordered
   */
	STAR(0, "star", "star"),

	/**
   * The '<em><b>Plus</b></em>' literal object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #PLUS_VALUE
   * @generated
   * @ordered
   */
	PLUS(0, "plus", "plus");

	/**
   * The '<em><b>Mandatory</b></em>' literal value.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Mandatory</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @see #MANDATORY
   * @model name="mandatory"
   * @generated
   * @ordered
   */
	public static final int MANDATORY_VALUE = 0;

	/**
   * The '<em><b>Optional</b></em>' literal value.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Optional</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @see #OPTIONAL
   * @model name="optional"
   * @generated
   * @ordered
   */
	public static final int OPTIONAL_VALUE = 0;

	/**
   * The '<em><b>Star</b></em>' literal value.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Star</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @see #STAR
   * @model name="star"
   * @generated
   * @ordered
   */
	public static final int STAR_VALUE = 0;

	/**
   * The '<em><b>Plus</b></em>' literal value.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Plus</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @see #PLUS
   * @model name="plus"
   * @generated
   * @ordered
   */
	public static final int PLUS_VALUE = 0;

	/**
   * An array of all the '<em><b>Occurrence Indicator Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private static final OccurrenceIndicatorKind[] VALUES_ARRAY =
		new OccurrenceIndicatorKind[]
    {
      MANDATORY,
      OPTIONAL,
      STAR,
      PLUS,
    };

	/**
   * A public read-only list of all the '<em><b>Occurrence Indicator Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static final List<OccurrenceIndicatorKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
   * Returns the '<em><b>Occurrence Indicator Kind</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static OccurrenceIndicatorKind get(String literal) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      OccurrenceIndicatorKind result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

	/**
   * Returns the '<em><b>Occurrence Indicator Kind</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static OccurrenceIndicatorKind getByName(String name) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      OccurrenceIndicatorKind result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

	/**
   * Returns the '<em><b>Occurrence Indicator Kind</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static OccurrenceIndicatorKind get(int value) {
    switch (value)
    {
      case MANDATORY_VALUE: return MANDATORY;
    }
    return null;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private final int value;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private final String name;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private final String literal;

	/**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private OccurrenceIndicatorKind(int value, String name, String literal) {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public int getValue() {
    return value;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getName() {
    return name;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getLiteral() {
    return literal;
  }

	/**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public String toString() {
    return literal;
  }
	
} //OccurrenceIndicatorKind
