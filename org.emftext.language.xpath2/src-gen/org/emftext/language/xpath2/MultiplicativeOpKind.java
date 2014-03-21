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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Multiplicative Op Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.emftext.language.xpath2.Xpath2Package#getMultiplicativeOpKind()
 * @model
 * @generated
 */
public enum MultiplicativeOpKind implements Enumerator {
    /**
     * The '<em><b>Multiplication</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #MULTIPLICATION_VALUE
     * @generated
     * @ordered
     */
    MULTIPLICATION(0, "multiplication", "multiplication"),

    /**
     * The '<em><b>Div</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #DIV_VALUE
     * @generated
     * @ordered
     */
    DIV(1, "div", "div"),

    /**
     * The '<em><b>Idiv</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #IDIV_VALUE
     * @generated
     * @ordered
     */
    IDIV(2, "idiv", "idiv"),

    /**
     * The '<em><b>Mod</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #MOD_VALUE
     * @generated
     * @ordered
     */
    MOD(3, "mod", "mod");

    /**
     * The '<em><b>Multiplication</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Multiplication</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #MULTIPLICATION
     * @model name="multiplication"
     * @generated
     * @ordered
     */
    public static final int MULTIPLICATION_VALUE = 0;

    /**
     * The '<em><b>Div</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Div</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #DIV
     * @model name="div"
     * @generated
     * @ordered
     */
    public static final int DIV_VALUE = 1;

    /**
     * The '<em><b>Idiv</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Idiv</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #IDIV
     * @model name="idiv"
     * @generated
     * @ordered
     */
    public static final int IDIV_VALUE = 2;

    /**
     * The '<em><b>Mod</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Mod</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #MOD
     * @model name="mod"
     * @generated
     * @ordered
     */
    public static final int MOD_VALUE = 3;

    /**
     * An array of all the '<em><b>Multiplicative Op Kind</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final MultiplicativeOpKind[] VALUES_ARRAY =
        new MultiplicativeOpKind[] {
            MULTIPLICATION,
            DIV,
            IDIV,
            MOD,
        };

    /**
     * A public read-only list of all the '<em><b>Multiplicative Op Kind</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<MultiplicativeOpKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Multiplicative Op Kind</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static MultiplicativeOpKind get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            MultiplicativeOpKind result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Multiplicative Op Kind</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static MultiplicativeOpKind getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            MultiplicativeOpKind result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Multiplicative Op Kind</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static MultiplicativeOpKind get(int value) {
        switch (value) {
            case MULTIPLICATION_VALUE: return MULTIPLICATION;
            case DIV_VALUE: return DIV;
            case IDIV_VALUE: return IDIV;
            case MOD_VALUE: return MOD;
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
    private MultiplicativeOpKind(int value, String name, String literal) {
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
    
} //MultiplicativeOpKind
