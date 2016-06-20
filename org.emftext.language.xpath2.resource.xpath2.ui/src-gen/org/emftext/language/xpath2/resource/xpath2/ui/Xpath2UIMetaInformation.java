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
package org.emftext.language.xpath2.resource.xpath2.ui;

import org.eclipse.core.resources.IResource;

public class Xpath2UIMetaInformation extends org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2MetaInformation {
	
	public org.emftext.language.xpath2.resource.xpath2.IXpath2HoverTextProvider getHoverTextProvider() {
		return new org.emftext.language.xpath2.resource.xpath2.ui.Xpath2HoverTextProvider();
	}
	
	public org.emftext.language.xpath2.resource.xpath2.ui.Xpath2ImageProvider getImageProvider() {
		return org.emftext.language.xpath2.resource.xpath2.ui.Xpath2ImageProvider.INSTANCE;
	}
	
	public org.emftext.language.xpath2.resource.xpath2.ui.Xpath2ColorManager createColorManager() {
		return new org.emftext.language.xpath2.resource.xpath2.ui.Xpath2ColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(org.emftext.language.xpath2.resource.xpath2.IXpath2TextResour
	 * ce, org.emftext.language.xpath2.resource.xpath2.ui.Xpath2ColorManager) instead.
	 */
	public org.emftext.language.xpath2.resource.xpath2.ui.Xpath2TokenScanner createTokenScanner(org.emftext.language.xpath2.resource.xpath2.ui.Xpath2ColorManager colorManager) {
		return (org.emftext.language.xpath2.resource.xpath2.ui.Xpath2TokenScanner) createTokenScanner(null, colorManager);
	}
	
	public org.emftext.language.xpath2.resource.xpath2.ui.IXpath2TokenScanner createTokenScanner(org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource resource, org.emftext.language.xpath2.resource.xpath2.ui.Xpath2ColorManager colorManager) {
		return new org.emftext.language.xpath2.resource.xpath2.ui.Xpath2TokenScanner(resource, colorManager);
	}
	
	public org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CodeCompletionHelper createCodeCompletionHelper() {
		return new org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CodeCompletionHelper();
	}
	
	@SuppressWarnings("rawtypes")
	public Object createResourceAdapter(Object adaptableObject, Class adapterType, IResource resource) {
		return new org.emftext.language.xpath2.resource.xpath2.ui.debug.Xpath2LineBreakpointAdapter();
	}
	
}
