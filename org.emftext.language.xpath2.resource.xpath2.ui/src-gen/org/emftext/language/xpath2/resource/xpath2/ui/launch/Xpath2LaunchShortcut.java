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
package org.emftext.language.xpath2.resource.xpath2.ui.launch;

import java.util.Iterator;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.ILaunchShortcut2;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;

/**
 * <p>
 * A class that converts the current selection or active editor to a launch
 * configuration.
 * </p>
 * <p>
 * Set the overrideLaunchShortcut option to false to customize this class.
 * </p>
 */
public class Xpath2LaunchShortcut implements ILaunchShortcut2 {
	
	public void launch(ISelection selection, String mode) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			Iterator<?> it = structuredSelection.iterator();
			while (it.hasNext()) {
				Object object = it.next();
				if (object instanceof IFile) {
					IFile file = (IFile) object;
					launch(file, mode);
				}
			}
		}
	}
	
	public void launch(IEditorPart editorPart, String mode) {
		IEditorInput editorInput = editorPart.getEditorInput();
		if (editorInput instanceof IFileEditorInput) {
			IFileEditorInput fileInput = (IFileEditorInput) editorInput;
			launch(fileInput.getFile(), mode);
		}
	}
	
	private void launch(IFile file, String mode) {
		try {
			ILaunchManager lm = DebugPlugin.getDefault().getLaunchManager();
			ILaunchConfigurationType type = lm.getLaunchConfigurationType(new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2MetaInformation().getLaunchConfigurationType());
			ILaunchConfigurationWorkingCopy workingCopy = type.newInstance(null, file.getName());
			URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			workingCopy.setAttribute(org.emftext.language.xpath2.resource.xpath2.launch.Xpath2LaunchConfigurationDelegate.ATTR_RESOURCE_URI, uri.toString());
			ILaunchConfiguration configuration = workingCopy.doSave();
			DebugUITools.launch(configuration, mode);
		} catch (CoreException e) {
			org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2Plugin.logError("Exception while launching selection", e);
		}
	}
	
	public ILaunchConfiguration[] getLaunchConfigurations(ISelection selection) {
		return null;
	}
	
	public ILaunchConfiguration[] getLaunchConfigurations(IEditorPart editorPart) {
		return null;
	}
	
	public IResource getLaunchableResource(ISelection selection) {
		return null;
	}
	
	public IResource getLaunchableResource(IEditorPart editorPart) {
		return null;
	}
	
}
