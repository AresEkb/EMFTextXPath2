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
package org.emftext.language.xpath2.resource.xpath2.mopp;

import java.util.Collections;
import java.util.Set;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class Xpath2ExpectedCsString extends org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2AbstractExpectedElement {
	
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword keyword;
	
	public Xpath2ExpectedCsString(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	/**
	 * Returns the expected keyword.
	 */
	public org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2SyntaxElement getSyntaxElement() {
		return keyword;
	}
	
	public Set<String> getTokenNames() {
		return Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof Xpath2ExpectedCsString) {
			return getValue().equals(((Xpath2ExpectedCsString) o).getValue());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return getValue().hashCode();
	}
	
}
