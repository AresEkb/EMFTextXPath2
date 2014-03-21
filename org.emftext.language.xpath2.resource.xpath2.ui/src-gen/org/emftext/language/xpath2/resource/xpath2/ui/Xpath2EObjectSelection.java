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
package org.emftext.language.xpath2.resource.xpath2.ui;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;

public class Xpath2EObjectSelection implements IStructuredSelection {
	
	private final EObject selectedObject;
	
	public Xpath2EObjectSelection(EObject selectedObject) {
		super();
		this.selectedObject = selectedObject;
	}
	
	public EObject getSelectedObject() {
		return selectedObject;
	}
	
	public boolean isEmpty() {
		return false;
	}
	
	public Object getFirstElement() {
		return selectedObject;
	}
	
	public Iterator<?> iterator() {
		return new Iterator<EObject>() {
			
			private boolean hasNext = true;
			
			public boolean hasNext() {
				return hasNext;
			}
			
			public EObject next(){
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
	
	public List<?> toList() {
		return Collections.singletonList(selectedObject);
	}
	
}
