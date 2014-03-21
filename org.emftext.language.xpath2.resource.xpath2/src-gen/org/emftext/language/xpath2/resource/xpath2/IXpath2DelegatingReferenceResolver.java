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

/**
 * A delegating reference resolver is an extension of a normal reference resolver
 * that can be configured with another resolver that it may delegate method calls
 * to. This interface can be implemented by additional resolvers to customize
 * resolving using the load option ADDITIONAL_REFERENCE_RESOLVERS.
 * 
 * @see org.emftext.language.xpath2.resource.xpath2.IXpath2Options
 */
public interface IXpath2DelegatingReferenceResolver<ContainerType extends EObject, ReferenceType extends EObject> extends org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceResolver<ContainerType, ReferenceType> {
	
	/**
	 * Sets the delegate for this resolver.
	 */
	public void setDelegate(org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceResolver<ContainerType, ReferenceType> delegate);
	
}
