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
package org.emftext.language.xpath2.impl;

import org.eclipse.emf.ecore.EClass;

import org.emftext.language.xpath2.RangeExprChild;
import org.emftext.language.xpath2.XPath2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Range Expr Child</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class RangeExprChildImpl extends ComparisonExprChildImpl implements RangeExprChild {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RangeExprChildImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return XPath2Package.Literals.RANGE_EXPR_CHILD;
    }

} //RangeExprChildImpl
