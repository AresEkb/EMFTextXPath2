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
package org.emftext.language.xpath2.resource.xpath2.grammar;

public class Xpath2Compound extends org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2SyntaxElement {
	
	public Xpath2Compound(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice choice, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality cardinality) {
		super(cardinality, new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2SyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
