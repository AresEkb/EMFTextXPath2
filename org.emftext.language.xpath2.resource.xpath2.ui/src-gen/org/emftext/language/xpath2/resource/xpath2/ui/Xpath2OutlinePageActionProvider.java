/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.xpath2.resource.xpath2.ui;

public class Xpath2OutlinePageActionProvider {
	
	public java.util.List<org.eclipse.jface.action.IAction> getActions(org.emftext.language.xpath2.resource.xpath2.ui.Xpath2OutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		java.util.List<org.eclipse.jface.action.IAction> defaultActions = new java.util.ArrayList<org.eclipse.jface.action.IAction>();
		defaultActions.add(new org.emftext.language.xpath2.resource.xpath2.ui.Xpath2OutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new org.emftext.language.xpath2.resource.xpath2.ui.Xpath2OutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new org.emftext.language.xpath2.resource.xpath2.ui.Xpath2OutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new org.emftext.language.xpath2.resource.xpath2.ui.Xpath2OutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new org.emftext.language.xpath2.resource.xpath2.ui.Xpath2OutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new org.emftext.language.xpath2.resource.xpath2.ui.Xpath2OutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
