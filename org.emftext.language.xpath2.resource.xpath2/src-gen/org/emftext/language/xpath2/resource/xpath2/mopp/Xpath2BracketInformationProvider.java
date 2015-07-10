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

import java.util.ArrayList;
import java.util.Collection;

/**
 * This class provides information about how brackets must be handled in the
 * editor (e.g., whether they must be closed automatically).
 */
public class Xpath2BracketInformationProvider {
	
	public Collection<org.emftext.language.xpath2.resource.xpath2.IXpath2BracketPair> getBracketPairs() {
		Collection<org.emftext.language.xpath2.resource.xpath2.IXpath2BracketPair> result = new ArrayList<org.emftext.language.xpath2.resource.xpath2.IXpath2BracketPair>();
		result.add(new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2BracketPair("(", ")", true, false));
		result.add(new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2BracketPair("[", "]", true, false));
		return result;
	}
	
}
