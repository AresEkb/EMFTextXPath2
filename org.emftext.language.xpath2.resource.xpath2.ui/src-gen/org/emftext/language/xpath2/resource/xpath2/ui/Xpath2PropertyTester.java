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
package org.emftext.language.xpath2.resource.xpath2.ui;

public class Xpath2PropertyTester extends org.eclipse.core.expressions.PropertyTester {
	
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (receiver instanceof org.eclipse.core.resources.IResource) {
			org.eclipse.core.resources.IResource resource = (org.eclipse.core.resources.IResource) receiver;
			return hasMatchingURI(resource);
		} else if (receiver instanceof org.eclipse.ui.part.FileEditorInput) {
			org.eclipse.ui.part.FileEditorInput editorInput = (org.eclipse.ui.part.FileEditorInput) receiver;
			org.eclipse.core.resources.IFile file = editorInput.getFile();
			return hasMatchingURI(file);
		}
		return false;
	}
	
	private boolean hasMatchingURI(org.eclipse.core.resources.IResource resource) {
		String path = resource.getLocationURI().getPath();
		return path.endsWith("." + new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2MetaInformation().getSyntaxName());
	}
	
}
