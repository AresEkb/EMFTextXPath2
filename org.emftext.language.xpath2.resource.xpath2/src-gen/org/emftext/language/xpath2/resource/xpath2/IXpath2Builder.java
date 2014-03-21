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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;

/**
 * An interface for builders that can be used to perform operations when resources
 * are changed and saved. This is an abstraction over the Eclipse builder API that
 * is specifically designed for building resources that contain EMF models.
 */
public interface IXpath2Builder {
	
	/**
	 * Check whether building the resource with the given URI is needed.This method
	 * allows to excluded resource from the build process before these are actually
	 * loaded. If this method returns false, the build() method will not be invoked
	 * for the resource located at the given URI.
	 */
	public boolean isBuildingNeeded(URI uri);
	
	/**
	 * Builds the given resource.
	 */
	public IStatus build(org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2Resource resource, IProgressMonitor monitor);
	
	/**
	 * Handles the deletion of the given resource.
	 */
	public IStatus handleDeletion(URI uri, IProgressMonitor monitor);
	
}
