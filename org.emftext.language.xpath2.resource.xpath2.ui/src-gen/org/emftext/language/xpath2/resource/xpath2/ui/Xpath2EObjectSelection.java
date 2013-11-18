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
package org.emftext.language.xpath2.resource.xpath2.ui;

public class Xpath2EObjectSelection implements org.eclipse.jface.viewers.IStructuredSelection {
	
	private final org.eclipse.emf.ecore.EObject selectedObject;
	private final boolean highlighting;
	
	public Xpath2EObjectSelection(org.eclipse.emf.ecore.EObject selectedObject, boolean highlighting) {
		super();
		this.selectedObject = selectedObject;
		this.highlighting = highlighting;
	}
	
	public org.eclipse.emf.ecore.EObject getSelectedObject() {
		return selectedObject;
	}
	
	public boolean doHighlighting() {
		return highlighting;
	}
	
	public boolean isEmpty() {
		return false;
	}
	
	public Object getFirstElement() {
		return selectedObject;
	}
	
	public java.util.Iterator<?> iterator() {
		return new java.util.Iterator<org.eclipse.emf.ecore.EObject>() {
			
			private boolean hasNext = true;
			
			public boolean hasNext() {
				return hasNext;
			}
			
			public org.eclipse.emf.ecore.EObject next(){
				hasNext = false;
				return selectedObject;
			}
			
			public void remove() {
			}
		};
	}
	
	public int size() {
		return 1;
	}
	
	public Object[] toArray() {
		return new Object[] {selectedObject};
	}
	
	public java.util.List<?> toList() {
		java.util.ArrayList<org.eclipse.emf.ecore.EObject> list = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
		list.add(selectedObject);
		return list;
	}
	
}
