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
package org.emftext.language.xpath2.resource.xpath2.ui.launch;

/**
 * A class that converts the current selection or active editor to a launch
 * configuration.
 * Set the overrideLaunchShortcut option to false to customize this class.
 */
public class Xpath2LaunchShortcut implements org.eclipse.debug.ui.ILaunchShortcut2 {
	
	public void launch(org.eclipse.jface.viewers.ISelection selection, String mode) {
		if (selection instanceof org.eclipse.jface.viewers.IStructuredSelection) {
			org.eclipse.jface.viewers.IStructuredSelection structuredSelection = (org.eclipse.jface.viewers.IStructuredSelection) selection;
			java.util.Iterator<?> it = structuredSelection.iterator();
			while (it.hasNext()) {
				Object object = it.next();
				if (object instanceof org.eclipse.core.resources.IFile) {
					org.eclipse.core.resources.IFile file = (org.eclipse.core.resources.IFile) object;
					launch(file, mode);
				}
			}
		}
	}
	
	public void launch(org.eclipse.ui.IEditorPart editorPart, String mode) {
		org.eclipse.ui.IEditorInput editorInput = editorPart.getEditorInput();
		if (editorInput instanceof org.eclipse.ui.IFileEditorInput) {
			org.eclipse.ui.IFileEditorInput fileInput = (org.eclipse.ui.IFileEditorInput) editorInput;
			launch(fileInput.getFile(), mode);
		}
	}
	
	private void launch(org.eclipse.core.resources.IFile file, String mode) {
		try {
			org.eclipse.debug.core.ILaunchManager lm = org.eclipse.debug.core.DebugPlugin.getDefault().getLaunchManager();
			org.eclipse.debug.core.ILaunchConfigurationType type = lm.getLaunchConfigurationType(new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2MetaInformation().getLaunchConfigurationType());
			org.eclipse.debug.core.ILaunchConfigurationWorkingCopy workingCopy = type.newInstance(null, file.getName());
			org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			workingCopy.setAttribute(org.emftext.language.xpath2.resource.xpath2.launch.Xpath2LaunchConfigurationDelegate.ATTR_RESOURCE_URI, uri.toString());
			org.eclipse.debug.core.ILaunchConfiguration configuration = workingCopy.doSave();
			org.eclipse.debug.ui.DebugUITools.launch(configuration, mode);
		} catch (org.eclipse.core.runtime.CoreException e) {
			org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2Plugin.logError("Exception while launching selection", e);
		}
	}
	
	public org.eclipse.debug.core.ILaunchConfiguration[] getLaunchConfigurations(org.eclipse.jface.viewers.ISelection selection) {
		return null;
	}
	
	public org.eclipse.debug.core.ILaunchConfiguration[] getLaunchConfigurations(org.eclipse.ui.IEditorPart editorPart) {
		return null;
	}
	
	public org.eclipse.core.resources.IResource getLaunchableResource(org.eclipse.jface.viewers.ISelection selection) {
		return null;
	}
	
	public org.eclipse.core.resources.IResource getLaunchableResource(org.eclipse.ui.IEditorPart editorPart) {
		return null;
	}
	
}
