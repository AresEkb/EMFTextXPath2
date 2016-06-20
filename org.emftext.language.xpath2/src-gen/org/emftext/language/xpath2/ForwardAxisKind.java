/**
 * Copyright (c) 2013, 2016 Denis Nikiforov.
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
 * A representation of the literals of the enumeration '<em><b>Forward Axis Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.emftext.language.xpath2.XPath2Package#getForwardAxisKind()
 * @model
 * @generated
 */
public enum ForwardAxisKind implements Enumerator {
    /**
     * The '<em><b>Child</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #CHILD_VALUE
     * @generated
     * @ordered
     */
    CHILD(0, "child", "child"),

    /**
     * The '<em><b>Descendant</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #DESCENDANT_VALUE
     * @generated
     * @ordered
     */
    DESCENDANT(1, "descendant", "descendant"),

    /**
     * The '<em><b>Attribute</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #ATTRIBUTE_VALUE
     * @generated
     * @ordered
     */
    ATTRIBUTE(2, "attribute", "attribute"),

    /**
     * The '<em><b>Self</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #SELF_VALUE
     * @generated
     * @ordered
     */
    SELF(3, "self", "self"),

    /**
     * The '<em><b>Descendant or self</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #DESCENDANT_OR_SELF_VALUE
     * @generated
     * @ordered
     */
    DESCENDANT_OR_SELF(4, "descendant_or_self", "descendant_or_self"),

    /**
     * The '<em><b>Following sibling</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #FOLLOWING_SIBLING_VALUE
     * @generated
     * @ordered
     */
    FOLLOWING_SIBLING(5, "following_sibling", "following_sibling"),

    /**
     * The '<em><b>Following</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #FOLLOWING_VALUE
     * @generated
     * @ordered
     */
    FOLLOWING(6, "following", "following"),

    /**
     * The '<em><b>Namespace</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #NAMESPACE_VALUE
     * @generated
     * @ordered
     */
    NAMESPACE(7, "namespace", "namespace");

    /**
     * The '<em><b>Child</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Child</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #CHILD
     * @model name="child"
     * @generated
     * @ordered
     */
    public static final int CHILD_VALUE = 0;

    /**
     * The '<em><b>Descendant</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Descendant</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #DESCENDANT
     * @model name="descendant"
     * @generated
     * @ordered
     */
    public static final int DESCENDANT_VALUE = 1;

    /**
     * The '<em><b>Attribute</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Attribute</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #ATTRIBUTE
     * @model name="attribute"
     * @generated
     * @ordered
     */
    public static final int ATTRIBUTE_VALUE = 2;

    /**
     * The '<em><b>Self</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Self</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #SELF
     * @model name="self"
     * @generated
     * @ordered
     */
    public static final int SELF_VALUE = 3;

    /**
     * The '<em><b>Descendant or self</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Descendant or self</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #DESCENDANT_OR_SELF
     * @model name="descendant_or_self"
     * @generated
     * @ordered
     */
    public static final int DESCENDANT_OR_SELF_VALUE = 4;

    /**
     * The '<em><b>Following sibling</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Following sibling</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #FOLLOWING_SIBLING
     * @model name="following_sibling"
     * @generated
     * @ordered
     */
    public static final int FOLLOWING_SIBLING_VALUE = 5;

    /**
     * The '<em><b>Following</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Following</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #FOLLOWING
     * @model name="following"
     * @generated
     * @ordered
     */
    public static final int FOLLOWING_VALUE = 6;

    /**
     * The '<em><b>Namespace</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Namespace</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #NAMESPACE
     * @model name="namespace"
     * @generated
     * @ordered
     */
    public static final int NAMESPACE_VALUE = 7;

    /**
     * An array of all the '<em><b>Forward Axis Kind</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final ForwardAxisKind[] VALUES_ARRAY =
        new ForwardAxisKind[] {
            CHILD,
            DESCENDANT,
            ATTRIBUTE,
            SELF,
            DESCENDANT_OR_SELF,
            FOLLOWING_SIBLING,
            FOLLOWING,
            NAMESPACE,
        };

    /**
     * A public read-only list of all the '<em><b>Forward Axis Kind</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<ForwardAxisKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Forward Axis Kind</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param literal the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static ForwardAxisKind get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            ForwardAxisKind result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Forward Axis Kind</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param name the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static ForwardAxisKind getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            ForwardAxisKind result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Forward Axis Kind</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static ForwardAxisKind get(int value) {
        switch (value) {
            case CHILD_VALUE: return CHILD;
            case DESCENDANT_VALUE: return DESCENDANT;
            case ATTRIBUTE_VALUE: return ATTRIBUTE;
            case SELF_VALUE: return SELF;
            case DESCENDANT_OR_SELF_VALUE: return DESCENDANT_OR_SELF;
            case FOLLOWING_SIBLING_VALUE: return FOLLOWING_SIBLING;
            case FOLLOWING_VALUE: return FOLLOWING;
            case NAMESPACE_VALUE: return NAMESPACE;
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
    private ForwardAxisKind(int value, String name, String literal) {
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
    
} //ForwardAxisKind
