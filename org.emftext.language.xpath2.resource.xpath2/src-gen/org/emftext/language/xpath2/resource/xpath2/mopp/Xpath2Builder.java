/**
 * Copyright (c) 2013, 2015 Denis Nikiforov.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Denis Nikiforov - initial API and implementation
 */
package org.emftext.language.xpath2.resource.xpath2.mopp;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;

public class Xpath2Builder implements org.emftext.language.xpath2.resource.xpath2.IXpath2Builder {
	
	public boolean isBuildingNeeded(URI uri) {
		// Change this to return true to enable building of all resources.
		return false;
	}
	
	public IStatus build(org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2Resource resource, IProgressMonitor monitor) {
		// Set option 'overrideBuilder' to 'false' and then perform build here.
		
		// We use one tick from the parent monitor because the BuilderAdapter reserves one
		// tick for the Builder.
		SubProgressMonitor subMonitor = new SubProgressMonitor(monitor, 1);
		subMonitor.beginTask("Building " + resource.getURI().lastSegment(), 10);
		// The actual work of the builder can be performed here.
		subMonitor.worked(10);
		subMonitor.done();
		return Status.OK_STATUS;
	}
	
	/**
	 * Handles the deletion of the given resource.
	 */
	public IStatus handleDeletion(URI uri, IProgressMonitor monitor) {
		// by default nothing is done when a resource is deleted
		return Status.OK_STATUS;
	}
	
}
