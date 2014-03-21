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
package org.emftext.language.xpath2.resource.xpath2.mopp;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

public class Xpath2ResourceFactory implements Resource.Factory {
	
	public Xpath2ResourceFactory() {
		super();
	}
	
	public Resource createResource(URI uri) {
		return new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2Resource(uri);
	}
	
}
