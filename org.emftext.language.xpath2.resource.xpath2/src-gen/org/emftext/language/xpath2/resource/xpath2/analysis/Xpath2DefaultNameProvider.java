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

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;

public class Xpath2DefaultNameProvider implements org.emftext.language.xpath2.resource.xpath2.IXpath2NameProvider {
	
	public final static String NAME_FEATURE = "name";
	
	/**
	 * Returns a list of potential identifiers that may be used to reference the given
	 * element. This method can be overridden to customize the identification of
	 * elements.
	 */
	public List<String> getNames(EObject element) {
		List<String> names = new ArrayList<String>();
		
		// first check for attributes that have set the ID flag to true
		List<EAttribute> attributes = element.eClass().getEAllAttributes();
		for (EAttribute attribute : attributes) {
			if (attribute.isID()) {
				Object attributeValue = element.eGet(attribute);
				if (attributeValue != null) {
					names.add(attributeValue.toString());
				}
			}
		}
		
		// then check for an attribute that is called 'name'
		EStructuralFeature nameAttr = element.eClass().getEStructuralFeature(NAME_FEATURE);
		if (nameAttr instanceof EAttribute) {
			Object attributeValue = element.eGet(nameAttr);
			if (attributeValue != null) {
				names.add(attributeValue.toString());
			}
		} else {
			// try any other string attribute found
			for (EAttribute attribute : attributes) {
				if ("java.lang.String".equals(attribute.getEType().getInstanceClassName())) {
					Object attributeValue = element.eGet(attribute);
					if (attributeValue != null) {
						names.add(attributeValue.toString());
					}
				}
			}
			
			// try operations without arguments that return strings and which have a name that
			// ends with 'name'
			for (EOperation operation : element.eClass().getEAllOperations()) {
				if (operation.getName().toLowerCase().endsWith(NAME_FEATURE) && operation.getEParameters().size() == 0) {
					Object result = org.emftext.language.xpath2.resource.xpath2.util.Xpath2EObjectUtil.invokeOperation(element, operation);
					if (result != null) {
						names.add(result.toString());
					}
				}
			}
		}
		return names;
	}
	
}
