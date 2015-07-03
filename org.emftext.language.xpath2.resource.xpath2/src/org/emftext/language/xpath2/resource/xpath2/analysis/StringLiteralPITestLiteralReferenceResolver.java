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
package org.emftext.language.xpath2.resource.xpath2.analysis;

import java.util.Map;
import org.eclipse.emf.ecore.EReference;

public class StringLiteralPITestLiteralReferenceResolver implements org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceResolver<org.emftext.language.xpath2.StringLiteralPITest, org.emftext.language.xpath2.StringLiteral> {
	
	private org.emftext.language.xpath2.resource.xpath2.analysis.Xpath2DefaultResolverDelegate<org.emftext.language.xpath2.StringLiteralPITest, org.emftext.language.xpath2.StringLiteral> delegate = new org.emftext.language.xpath2.resource.xpath2.analysis.Xpath2DefaultResolverDelegate<org.emftext.language.xpath2.StringLiteralPITest, org.emftext.language.xpath2.StringLiteral>();
	
	public void resolve(String identifier, org.emftext.language.xpath2.StringLiteralPITest container, EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceResolveResult<org.emftext.language.xpath2.StringLiteral> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.emftext.language.xpath2.StringLiteral element, org.emftext.language.xpath2.StringLiteralPITest container, EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
