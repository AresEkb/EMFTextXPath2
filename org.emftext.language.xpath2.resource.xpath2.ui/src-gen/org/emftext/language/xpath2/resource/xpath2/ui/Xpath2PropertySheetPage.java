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
package org.emftext.language.xpath2.resource.xpath2.ui;

import java.util.Iterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.PropertySheetPage;

public class Xpath2PropertySheetPage extends PropertySheetPage implements ISelectionChangedListener {
	
	public void selectionChanged(SelectionChangedEvent event) {
		selectionChanged(null, event.getSelection());
	}
	
	public void selectionChanged(IWorkbenchPart part, ISelection iSelection) {
		// This is a workaround for a bug in EMF (see
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=291301).Unfortunately Ed Merks
		// refuses to fix it, so we need to solve it here.
		if (iSelection instanceof org.emftext.language.xpath2.resource.xpath2.ui.Xpath2EObjectSelection) {
			final org.emftext.language.xpath2.resource.xpath2.ui.Xpath2EObjectSelection selection = (org.emftext.language.xpath2.resource.xpath2.ui.Xpath2EObjectSelection) iSelection;
			final EObject selectedObject = selection.getSelectedObject();
			// check whether the selected object or one of its children contains a proxy which
			// is a GenXYZClass (e.g., GenFeature, GenClass, GenPackage)
			if (containsGenProxy(selectedObject)) {
				return;
			}
		}
		if (iSelection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) iSelection;
			Iterator<?> it = structuredSelection.iterator();
			while (it.hasNext()) {
				final Object next = it.next();
				if (next instanceof EObject) {
					if (containsGenProxy((EObject) next)) {
						return;
					}
				}
			}
		}
		// end of workaround
		super.selectionChanged(part, iSelection);
	}
	
	private boolean containsGenProxy(EObject selectedObject) {
		boolean isGenProxy = isGenProxy(selectedObject);
		if (isGenProxy) {
			return true;
		}
		for (EObject child : selectedObject.eCrossReferences()) {
			if (isGenProxy(child)) {
				return true;
			}
		}
		for (EObject child : selectedObject.eContents()) {
			if (containsGenProxy(child)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isGenProxy(EObject selectedObject) {
		boolean isGenMetaclass = isInstanceOf("org.eclipse.emf.codegen.ecore.genmodel.GenClass", selectedObject);
		isGenMetaclass |= isInstanceOf("org.eclipse.emf.codegen.ecore.genmodel.GenFeature", selectedObject);
		isGenMetaclass |= isInstanceOf("org.eclipse.emf.codegen.ecore.genmodel.GenPackage", selectedObject);
		boolean isProxy = selectedObject.eIsProxy();
		return isGenMetaclass && isProxy;
	}
	
	private boolean isInstanceOf(String className, Object object) {
		try {
			Class<?> clazz = Class.forName(className);
			return clazz.isInstance(object);
		} catch (ClassNotFoundException e) {
			return false;
		}
	}
}
