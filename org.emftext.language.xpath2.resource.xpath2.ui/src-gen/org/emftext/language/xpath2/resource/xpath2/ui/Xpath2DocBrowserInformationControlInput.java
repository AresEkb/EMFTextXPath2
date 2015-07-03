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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Provides input for the <code>TextHover</code>. The most is copied from
 * <code>org.eclipse.jdt.internal.ui.text.java.hover.JavadocBrowserInformationContr
 * olInput</code>.
 */
public class Xpath2DocBrowserInformationControlInput {
	
	private final Xpath2DocBrowserInformationControlInput fPrevious;
	private Xpath2DocBrowserInformationControlInput fNext;
	private final EObject element;
	private final String htmlContent;
	private final String tokenText;
	private final Resource resource;
	
	/**
	 * <p>
	 * Creates a new browser information control input.
	 * </p>
	 * 
	 * @param previous previous input, or <code>null</code> if none available
	 * @param element the element, or <code>null</code> if none available
	 * @param htmlContent HTML contents, must not be null
	 */
	public Xpath2DocBrowserInformationControlInput(Xpath2DocBrowserInformationControlInput previous, EObject element, Resource resource, String htmlContent, String tokenText) {
		fPrevious= previous;
		if (previous != null) {
			previous.fNext= this;
		}
		assert htmlContent != null;
		this.element = element;
		this.htmlContent = htmlContent;
		this.tokenText = tokenText;
		this.resource = resource;
	}
	
	/**
	 * <p>
	 * Returns the previous input or <code>null</code> if this is the first.
	 * </p>
	 * 
	 * @return the previous input or <code>null</code>
	 */
	public Xpath2DocBrowserInformationControlInput getPrevious() {
		return fPrevious;
	}
	
	/**
	 * <p>
	 * Returns the next input or <code>null</code> if this is the last.
	 * </p>
	 * 
	 * @return the next input or <code>null</code>
	 */
	public Xpath2DocBrowserInformationControlInput getNext() {
		return fNext;
	}
	
	/**
	 * 
	 * @return the resource
	 */
	public Resource getResource() {
		return resource;
	}
	
	public String getHtml() {
		return htmlContent;
	}
	
	public String toString() {
		return getHtml();
	}
	
	/**
	 * 
	 * @return the token text, it is needed for a hyperlink where the caret has to
	 * jump to
	 */
	public String getTokenText() {
		return tokenText;
	}
	
	public Object getInputElement() {
		return element == null ? (Object) htmlContent : element;
	}
	
	public String getInputName() {
		return element == null ? "" : element.toString();
	}
	
	public int getLeadingImageWidth() {
		return 0;
	}
}
