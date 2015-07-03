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

import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;

/**
 * A hyperlink detector returns hyperlink if the token, where the mouse cursor
 * hovers, is a proxy.
 */
public class Xpath2HyperlinkDetector implements IHyperlinkDetector {
	
	private org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource textResource;
	
	/**
	 * <p>
	 * Creates a hyperlink detector.
	 * </p>
	 * 
	 * @param resource the resource to use for calculating the locations.
	 */
	public Xpath2HyperlinkDetector(Resource resource) {
		textResource = (org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource) resource;
	}
	
	public IHyperlink[] detectHyperlinks(ITextViewer textViewer, IRegion region, boolean canShowMultipleHyperlinks) {
		org.emftext.language.xpath2.resource.xpath2.IXpath2LocationMap locationMap = textResource.getLocationMap();
		List<EObject> elementsAtOffset = locationMap.getElementsAt(region.getOffset());
		EObject resolvedEObject = null;
		for (EObject eObject : elementsAtOffset) {
			if (eObject.eIsProxy()) {
				resolvedEObject = EcoreUtil.resolve(eObject, textResource);
				if (resolvedEObject == eObject) {
					continue;
				}
				int offset = locationMap.getCharStart(eObject);
				int length = locationMap.getCharEnd(eObject) - offset + 1;
				String text = null;
				try {
					text = textViewer.getDocument().get(offset, length);
				} catch (BadLocationException e) {
				}
				// we skip elements that are not contained in a resource, because we cannot jump
				// to them anyway
				if (resolvedEObject.eResource() != null) {
					IHyperlink hyperlink = new org.emftext.language.xpath2.resource.xpath2.ui.Xpath2Hyperlink(new Region(offset, length), resolvedEObject, text);
					return new IHyperlink[] {hyperlink};
				}
			}
		}
		return null;
	}
	
}
