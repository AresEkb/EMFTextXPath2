/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.xpath2.resource.xpath2.ui;

public class Xpath2OutlinePageLexicalSortingAction extends org.emftext.language.xpath2.resource.xpath2.ui.AbstractXpath2OutlinePageAction {
	
	public Xpath2OutlinePageLexicalSortingAction(org.emftext.language.xpath2.resource.xpath2.ui.Xpath2OutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Sort alphabetically", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/sort_lexically_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setSortLexically(on);
		getTreeViewer().refresh();
	}
	
}
