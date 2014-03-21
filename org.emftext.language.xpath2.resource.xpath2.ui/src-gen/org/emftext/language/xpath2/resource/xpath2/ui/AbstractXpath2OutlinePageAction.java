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

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;

public abstract class AbstractXpath2OutlinePageAction extends Action {
	
	private String preferenceKey = this.getClass().getSimpleName() + ".isChecked";
	
	private org.emftext.language.xpath2.resource.xpath2.ui.Xpath2OutlinePageTreeViewer treeViewer;
	
	public AbstractXpath2OutlinePageAction(org.emftext.language.xpath2.resource.xpath2.ui.Xpath2OutlinePageTreeViewer treeViewer, String text, int style) {
		super(text, style);
		this.treeViewer = treeViewer;
	}
	
	public void initialize(String imagePath) {
		ImageDescriptor descriptor = org.emftext.language.xpath2.resource.xpath2.ui.Xpath2ImageProvider.INSTANCE.getImageDescriptor(imagePath);
		setDisabledImageDescriptor(descriptor);
		setImageDescriptor(descriptor);
		setHoverImageDescriptor(descriptor);
		boolean checked = org.emftext.language.xpath2.resource.xpath2.ui.Xpath2UIPlugin.getDefault().getPreferenceStore().getBoolean(preferenceKey);
		valueChanged(checked, false);
	}
	
	@Override
	public void run() {
		if (keepState()) {
			valueChanged(isChecked(), true);
		} else {
			runBusy(true);
		}
	}
	
	public void runBusy(final boolean on) {
		BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
			public void run() {
				runInternal(on);
			}
		});
	}
	
	public abstract void runInternal(boolean on);
	
	private void valueChanged(boolean on, boolean store) {
		setChecked(on);
		runBusy(on);
		if (store) {
			org.emftext.language.xpath2.resource.xpath2.ui.Xpath2UIPlugin.getDefault().getPreferenceStore().setValue(preferenceKey, on);
		}
	}
	
	public boolean keepState() {
		return true;
	}
	
	public org.emftext.language.xpath2.resource.xpath2.ui.Xpath2OutlinePageTreeViewer getTreeViewer() {
		return treeViewer;
	}
	
	public org.emftext.language.xpath2.resource.xpath2.ui.Xpath2OutlinePageTreeViewerComparator getTreeViewerComparator() {
		return (org.emftext.language.xpath2.resource.xpath2.ui.Xpath2OutlinePageTreeViewerComparator) treeViewer.getComparator();
	}
	
}
