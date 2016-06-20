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
package org.emftext.language.xpath2.resource.xpath2;

import java.util.Map;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

public interface IXpath2ReferenceCache {
	
	/**
	 * Returns all EObjects of the given type.
	 */
	public Set<EObject> getObjects(EClass type);
	
	/**
	 * Initializes the cache with the object tree that is rooted at <code>root</code>.
	 * The cache allows to retrieve of objects of a given type or a given name. If the
	 * cache was already initialized, no action is performed.
	 */
	public void initialize(EObject root);
	
	/**
	 * Returns the map from object names to objects that was created when the cache
	 * was initialized.
	 */
	public Map<String, Set<EObject>> getNameToObjectsMap();
	
	/**
	 * Clears the cache.
	 */
	public void clear();
	
}
