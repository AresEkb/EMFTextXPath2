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
 * An inactive implementation of the ILocationMap interface. That is used if the
 * org.emftext.language.xpath2.resource.xpath2.IXpath2Options.DISABLE_LOCATION_MAP
 * option is set.
 */
public class Xpath2DevNullLocationMap implements org.emftext.language.xpath2.resource.xpath2.IXpath2LocationMap {
	
	public void setLine(org.eclipse.emf.ecore.EObject element, int line) {
	}
	
	public int getLine(org.eclipse.emf.ecore.EObject element) {
		return -1;
	}
	
	public void setColumn(org.eclipse.emf.ecore.EObject element, int column) {
	}
	
	public int getColumn(org.eclipse.emf.ecore.EObject element) {
		return -1;
	}
	
	public void setCharStart(org.eclipse.emf.ecore.EObject element, int charStart) {
	}
	
	public int getCharStart(org.eclipse.emf.ecore.EObject element) {
		return -1;
	}
	
	public void setCharEnd(org.eclipse.emf.ecore.EObject element, int charEnd) {
	}
	
	public int getCharEnd(org.eclipse.emf.ecore.EObject element) {
		return -1;
	}
	
	public java.util.List<org.eclipse.emf.ecore.EObject> getElementsAt(final int documentOffset) {
		return java.util.Collections.<org.eclipse.emf.ecore.EObject>emptyList();
	}
	
	public java.util.List<org.eclipse.emf.ecore.EObject> getElementsBetween(final int startOffset, final int endOffset) {
		return java.util.Collections.<org.eclipse.emf.ecore.EObject>emptyList();
	}
	
}
