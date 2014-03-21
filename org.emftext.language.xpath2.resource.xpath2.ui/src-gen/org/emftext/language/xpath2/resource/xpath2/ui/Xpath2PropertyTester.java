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
package org.emftext.language.xpath2.resource.xpath2.ui;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.ui.part.FileEditorInput;

public class Xpath2PropertyTester extends PropertyTester {
	
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (receiver instanceof IResource) {
			IResource resource = (IResource) receiver;
			return hasMatchingURI(resource);
		} else if (receiver instanceof FileEditorInput) {
			FileEditorInput editorInput = (FileEditorInput) receiver;
			IFile file = editorInput.getFile();
			return hasMatchingURI(file);
		}
		return false;
	}
	
	private boolean hasMatchingURI(IResource resource) {
		String path = resource.getLocationURI().getPath();
		return path.endsWith("." + new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2MetaInformation().getSyntaxName());
	}
	
}
