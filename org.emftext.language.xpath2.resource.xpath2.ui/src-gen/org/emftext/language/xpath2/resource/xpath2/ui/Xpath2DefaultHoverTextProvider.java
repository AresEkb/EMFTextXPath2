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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class Xpath2DefaultHoverTextProvider implements org.emftext.language.xpath2.resource.xpath2.IXpath2HoverTextProvider {
	
	public String getHoverText(EObject container, EObject referencedObject) {
		return getHoverText(referencedObject);
	}
	
	public String getHoverText(EObject object) {
		if (object == null) {
			return null;
		}
		EClass eClass = object.eClass();
		String label = "<strong>" + eClass.getName() + "</strong>";
		String documentation = EcoreUtil.getDocumentation(eClass);
		String documentationHTML = documentation == null ? "" : " (" + documentation +")";
		label += documentationHTML;
		for (EAttribute attribute : eClass.getEAllAttributes()) {
			Object value = null;
			try {
				value = object.eGet(attribute);
			} catch (Exception e) {
				// Exception in eGet, do nothing
			}
			if (value != null && value.toString() != null && !value.toString().equals("[]")) {
				label += "<br />" + attribute.getName() + ": " + object.eGet(attribute).toString();
			}
		}
		return label;
	}
	
}
