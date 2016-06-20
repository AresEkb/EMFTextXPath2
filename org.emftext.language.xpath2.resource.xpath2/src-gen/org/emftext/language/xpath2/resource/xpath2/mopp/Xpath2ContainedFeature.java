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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A Xpath2ContainedFeature represents a path element of a
 * org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2ContainmentTrace
 */
public class Xpath2ContainedFeature {
	
	/**
	 * The class to which the feature points.
	 */
	private EClass containerClass;
	
	/**
	 * The feature that points to the container class.
	 */
	private EStructuralFeature feature;
	
	public Xpath2ContainedFeature(EClass containerClass, EStructuralFeature feature) {
		super();
		this.containerClass = containerClass;
		this.feature = feature;
	}
	
	public EClass getContainerClass() {
		return containerClass;
	}
	
	public EStructuralFeature getFeature() {
		return feature;
	}
	
	public String toString() {
		return (feature == null ? "null" : feature.getName()) + "->" + (containerClass == null ? "null" : containerClass.getName());
	}
	
}
