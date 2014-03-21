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

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.quickassist.IQuickFixableAnnotation;
import org.eclipse.ui.texteditor.MarkerAnnotation;

public class Xpath2MarkerAnnotation extends MarkerAnnotation implements IQuickFixableAnnotation {
	
	// private boolean isQuickFixable;
	
	public Xpath2MarkerAnnotation(IMarker marker) {
		super(marker);
	}
	
	public void setQuickFixable(boolean state) {
		// this.isQuickFixable = state;
	}
	
	public boolean isQuickFixableStateSet() {
		return true;
	}
	
	public boolean isQuickFixable() {
		try {
			return getMarker().getAttribute(IMarker.SOURCE_ID) != null;
		} catch (CoreException e) {
			// ignore
		}
		return false;
	}
	
}
