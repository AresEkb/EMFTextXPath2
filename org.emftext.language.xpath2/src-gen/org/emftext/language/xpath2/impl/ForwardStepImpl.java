/**
 * Copyright (c) 2013 Denis Nikiforov.
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

import org.emftext.language.xpath2.ForwardStep;
import org.emftext.language.xpath2.Xpath2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Forward Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class ForwardStepImpl extends AxisStepImpl implements ForwardStep
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ForwardStepImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return Xpath2Package.Literals.FORWARD_STEP;
  }

} //ForwardStepImpl
