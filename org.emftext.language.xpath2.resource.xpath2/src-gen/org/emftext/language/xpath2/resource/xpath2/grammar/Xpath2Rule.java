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
package org.emftext.language.xpath2.resource.xpath2.grammar;

import org.eclipse.emf.ecore.EClass;

/**
 * A class to represent a rules in the grammar.
 */
public class Xpath2Rule extends org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2SyntaxElement {
	
	private final EClass metaclass;
	
	public Xpath2Rule(EClass metaclass, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice choice, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality cardinality) {
		super(cardinality, new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2SyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public EClass getMetaclass() {
		return metaclass;
	}
	
	public org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getDefinition() {
		return (org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice) getChildren()[0];
	}
	
	@Deprecated
	public String toString() {
		return metaclass == null ? "null" : metaclass.getName() + " ::= " + getDefinition().toString();
	}
	
}

