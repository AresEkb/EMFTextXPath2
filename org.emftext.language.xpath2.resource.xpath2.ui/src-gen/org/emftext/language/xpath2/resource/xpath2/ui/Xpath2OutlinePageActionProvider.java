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
import org.eclipse.jface.action.IAction;

public class Xpath2OutlinePageActionProvider {
	
	public List<IAction> getActions(org.emftext.language.xpath2.resource.xpath2.ui.Xpath2OutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		java.util.List<IAction> defaultActions = new java.util.ArrayList<IAction>();
		defaultActions.add(new org.emftext.language.xpath2.resource.xpath2.ui.Xpath2OutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new org.emftext.language.xpath2.resource.xpath2.ui.Xpath2OutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new org.emftext.language.xpath2.resource.xpath2.ui.Xpath2OutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new org.emftext.language.xpath2.resource.xpath2.ui.Xpath2OutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new org.emftext.language.xpath2.resource.xpath2.ui.Xpath2OutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new org.emftext.language.xpath2.resource.xpath2.ui.Xpath2OutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
