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
package org.emftext.language.xpath2.resource.xpath2.debug;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.sourcelookup.ISourceContainer;
import org.eclipse.debug.core.sourcelookup.ISourceContainerType;
import org.eclipse.debug.core.sourcelookup.ISourceLookupDirector;
import org.eclipse.debug.core.sourcelookup.ISourcePathComputerDelegate;
import org.eclipse.emf.common.util.URI;

public class Xpath2SourcePathComputerDelegate implements ISourcePathComputerDelegate {
	
	public ISourceContainer[] computeSourceContainers(ILaunchConfiguration configuration, IProgressMonitor monitor) throws CoreException {
		return new ISourceContainer[] {new ISourceContainer() {
			
			@SuppressWarnings("rawtypes")
			public Object getAdapter(Class adapter) {
				return null;
			}
			
			public boolean isComposite() {
				return false;
			}
			
			public void init(ISourceLookupDirector director) {
				// do nothing
			}
			
			public ISourceContainerType getType() {
				return null;
			}
			
			public ISourceContainer[] getSourceContainers() throws CoreException {
				return new ISourceContainer[0];
			}
			
			public String getName() {
				return "Resource URI";
			}
			
			public Object[] findSourceElements(String name) throws CoreException {
				URI eUri = URI.createURI(name);
				if (eUri.isPlatformResource()) {
					String platformString = eUri.toPlatformString(true);
					return new Object[] {ResourcesPlugin.getWorkspace().getRoot().findMember(platformString)};
				}
				return new Object[0];
			}
			
			public void dispose() {
			}
		}};
	}
	
}
