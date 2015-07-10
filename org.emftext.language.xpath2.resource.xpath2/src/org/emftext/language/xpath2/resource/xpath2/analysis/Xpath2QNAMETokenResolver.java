/**
 * Copyright (c) 2013, 2015 Denis Nikiforov.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Denis Nikiforov - initial API and implementation
 */
package org.emftext.language.xpath2.resource.xpath2.analysis;

import javax.xml.namespace.QName;

public class Xpath2QNAMETokenResolver implements org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver {
	
    private final org.emftext.language.xpath2.resource.xpath2.analysis.Xpath2DefaultTokenResolver defaultTokenResolver = new org.emftext.language.xpath2.resource.xpath2.analysis.Xpath2DefaultTokenResolver(true);

    @Override
    public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
        if (value instanceof QName) {
            QName name = (QName)value;
            String prefix = name.getPrefix();
            return prefix.isEmpty() ? name.getLocalPart() : prefix + ":" + name.getLocalPart();
        }
        // By default token de-resolving is delegated to the DefaultTokenResolver.
        String result = defaultTokenResolver.deResolve(value, feature, container, null, null, null);
        return result;
    }

    @Override
    public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result) {
        String[] parts = lexem.split(":");
        switch (parts.length) {
        case 1:
            result.setResolvedToken(new QName(parts[0]));
            break;
        case 2:
            result.setResolvedToken(new QName(null, parts[1], parts[0]));
            break;
        default:
            // By default token resolving is delegated to the DefaultTokenResolver.
            defaultTokenResolver.resolve(lexem, feature, result, null, null, null);
            break;
        }
    }

    @Override
    public void setOptions(java.util.Map<?,?> options) {
        defaultTokenResolver.setOptions(options);
    }
    
}
