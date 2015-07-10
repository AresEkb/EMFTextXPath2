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


public class Xpath2Sequence extends org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2SyntaxElement {
	
	public Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality cardinality, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2SyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return org.emftext.language.xpath2.resource.xpath2.util.Xpath2StringUtil.explode(getChildren(), " ");
	}
	
}
