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

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

public class Xpath2Problem implements org.emftext.language.xpath2.resource.xpath2.IXpath2Problem {
	
	private String message;
	private org.emftext.language.xpath2.resource.xpath2.Xpath2EProblemType type;
	private org.emftext.language.xpath2.resource.xpath2.Xpath2EProblemSeverity severity;
	private Collection<org.emftext.language.xpath2.resource.xpath2.IXpath2QuickFix> quickFixes;
	
	public Xpath2Problem(String message, org.emftext.language.xpath2.resource.xpath2.Xpath2EProblemType type, org.emftext.language.xpath2.resource.xpath2.Xpath2EProblemSeverity severity) {
		this(message, type, severity, Collections.<org.emftext.language.xpath2.resource.xpath2.IXpath2QuickFix>emptySet());
	}
	
	public Xpath2Problem(String message, org.emftext.language.xpath2.resource.xpath2.Xpath2EProblemType type, org.emftext.language.xpath2.resource.xpath2.Xpath2EProblemSeverity severity, org.emftext.language.xpath2.resource.xpath2.IXpath2QuickFix quickFix) {
		this(message, type, severity, Collections.singleton(quickFix));
	}
	
	public Xpath2Problem(String message, org.emftext.language.xpath2.resource.xpath2.Xpath2EProblemType type, org.emftext.language.xpath2.resource.xpath2.Xpath2EProblemSeverity severity, Collection<org.emftext.language.xpath2.resource.xpath2.IXpath2QuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new LinkedHashSet<org.emftext.language.xpath2.resource.xpath2.IXpath2QuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public org.emftext.language.xpath2.resource.xpath2.Xpath2EProblemType getType() {
		return type;
	}
	
	public org.emftext.language.xpath2.resource.xpath2.Xpath2EProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Collection<org.emftext.language.xpath2.resource.xpath2.IXpath2QuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
