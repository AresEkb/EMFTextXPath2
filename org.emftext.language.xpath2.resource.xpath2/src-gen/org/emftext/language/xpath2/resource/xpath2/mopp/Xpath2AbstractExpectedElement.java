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
package org.emftext.language.xpath2.resource.xpath2.mopp;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class Xpath2AbstractExpectedElement implements org.emftext.language.xpath2.resource.xpath2.IXpath2ExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	
	private java.util.Set<org.emftext.language.xpath2.resource.xpath2.util.Xpath2Pair<org.emftext.language.xpath2.resource.xpath2.IXpath2ExpectedElement, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ContainedFeature[]>> followers = new java.util.LinkedHashSet<org.emftext.language.xpath2.resource.xpath2.util.Xpath2Pair<org.emftext.language.xpath2.resource.xpath2.IXpath2ExpectedElement, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ContainedFeature[]>>();
	
	public Xpath2AbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(org.emftext.language.xpath2.resource.xpath2.IXpath2ExpectedElement follower, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ContainedFeature[] path) {
		followers.add(new org.emftext.language.xpath2.resource.xpath2.util.Xpath2Pair<org.emftext.language.xpath2.resource.xpath2.IXpath2ExpectedElement, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ContainedFeature[]>(follower, path));
	}
	
	public java.util.Collection<org.emftext.language.xpath2.resource.xpath2.util.Xpath2Pair<org.emftext.language.xpath2.resource.xpath2.IXpath2ExpectedElement, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
