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
package org.emftext.language.xpath2.resource.xpath2;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * An interface for factories to create instances of
 * org.emftext.language.xpath2.resource.xpath2.IXpath2ContextDependentURIFragment.
 * 
 * @param <ContainerType> the type of the class containing the reference to be
 * resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public interface IXpath2ContextDependentURIFragmentFactory<ContainerType extends EObject, ReferenceType extends EObject> {
	
	/**
	 * Create a new instance of the
	 * org.emftext.language.xpath2.resource.xpath2.IXpath2ContextDependentURIFragment
	 * interface.
	 * 
	 * @param identifier the identifier that references an Object
	 * @param container the object that contains the reference
	 * @param reference the reference itself
	 * @param positionInReference the position of the identifier (if the reference is
	 * multiple)
	 * @param proxy the proxy that will be resolved later to the actual EObject
	 * 
	 * @return the new instance of
	 * org.emftext.language.xpath2.resource.xpath2.IXpath2ContextDependentURIFragment
	 */
	public org.emftext.language.xpath2.resource.xpath2.IXpath2ContextDependentURIFragment<?> create(String identifier, ContainerType container, EReference reference, int positionInReference, EObject proxy);
}
