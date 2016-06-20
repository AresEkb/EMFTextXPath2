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
package org.emftext.language.xpath2.resource.xpath2.mopp;

import java.util.ArrayList;
import java.util.List;

public class Xpath2SyntaxElementDecorator {
	
	/**
	 * the syntax element to be decorated
	 */
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2SyntaxElement decoratedElement;
	
	/**
	 * an array of child decorators (one decorator per child of the decorated syntax
	 * element
	 */
	private Xpath2SyntaxElementDecorator[] childDecorators;
	
	/**
	 * a list of the indices that must be printed
	 */
	private List<Integer> indicesToPrint = new ArrayList<Integer>();
	
	public Xpath2SyntaxElementDecorator(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2SyntaxElement decoratedElement, Xpath2SyntaxElementDecorator[] childDecorators) {
		super();
		this.decoratedElement = decoratedElement;
		this.childDecorators = childDecorators;
	}
	
	public void addIndexToPrint(Integer index) {
		indicesToPrint.add(index);
	}
	
	public org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2SyntaxElement getDecoratedElement() {
		return decoratedElement;
	}
	
	public Xpath2SyntaxElementDecorator[] getChildDecorators() {
		return childDecorators;
	}
	
	public Integer getNextIndexToPrint() {
		if (indicesToPrint.size() == 0) {
			return null;
		}
		return indicesToPrint.remove(0);
	}
	
	public String toString() {
		return "" + getDecoratedElement();
	}
	
}
