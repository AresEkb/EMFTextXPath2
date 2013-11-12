/**
 */
package org.emftext.language.xpath2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>General Comp Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.emftext.language.xpath2.Xpath2Package#getGeneralCompKind()
 * @model
 * @generated
 */
public enum GeneralCompKind implements Enumerator {
	/**
   * The '<em><b>Eq</b></em>' literal object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #EQ_VALUE
   * @generated
   * @ordered
   */
	EQ(0, "eq", "eq"),

	/**
   * The '<em><b>Ne</b></em>' literal object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #NE_VALUE
   * @generated
   * @ordered
   */
	NE(0, "ne", "ne"),

	/**
   * The '<em><b>Lt</b></em>' literal object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #LT_VALUE
   * @generated
   * @ordered
   */
	LT(0, "lt", "lt"),

	/**
   * The '<em><b>Le</b></em>' literal object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #LE_VALUE
   * @generated
   * @ordered
   */
	LE(0, "le", "le"),

	/**
   * The '<em><b>Gt</b></em>' literal object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #GT_VALUE
   * @generated
   * @ordered
   */
	GT(0, "gt", "gt"),

	/**
   * The '<em><b>Ge</b></em>' literal object.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #GE_VALUE
   * @generated
   * @ordered
   */
	GE(0, "ge", "ge");

	/**
   * The '<em><b>Eq</b></em>' literal value.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Eq</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @see #EQ
   * @model name="eq"
   * @generated
   * @ordered
   */
	public static final int EQ_VALUE = 0;

	/**
   * The '<em><b>Ne</b></em>' literal value.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ne</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @see #NE
   * @model name="ne"
   * @generated
   * @ordered
   */
	public static final int NE_VALUE = 0;

	/**
   * The '<em><b>Lt</b></em>' literal value.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Lt</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @see #LT
   * @model name="lt"
   * @generated
   * @ordered
   */
	public static final int LT_VALUE = 0;

	/**
   * The '<em><b>Le</b></em>' literal value.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Le</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @see #LE
   * @model name="le"
   * @generated
   * @ordered
   */
	public static final int LE_VALUE = 0;

	/**
   * The '<em><b>Gt</b></em>' literal value.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Gt</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @see #GT
   * @model name="gt"
   * @generated
   * @ordered
   */
	public static final int GT_VALUE = 0;

	/**
   * The '<em><b>Ge</b></em>' literal value.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ge</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @see #GE
   * @model name="ge"
   * @generated
   * @ordered
   */
	public static final int GE_VALUE = 0;

	/**
   * An array of all the '<em><b>General Comp Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private static final GeneralCompKind[] VALUES_ARRAY =
		new GeneralCompKind[]
    {
      EQ,
      NE,
      LT,
      LE,
      GT,
      GE,
    };

	/**
   * A public read-only list of all the '<em><b>General Comp Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static final List<GeneralCompKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
   * Returns the '<em><b>General Comp Kind</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static GeneralCompKind get(String literal) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      GeneralCompKind result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

	/**
   * Returns the '<em><b>General Comp Kind</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static GeneralCompKind getByName(String name) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      GeneralCompKind result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

	/**
   * Returns the '<em><b>General Comp Kind</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static GeneralCompKind get(int value) {
    switch (value)
    {
      case EQ_VALUE: return EQ;
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
	private GeneralCompKind(int value, String name, String literal) {
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
	
} //GeneralCompKind
