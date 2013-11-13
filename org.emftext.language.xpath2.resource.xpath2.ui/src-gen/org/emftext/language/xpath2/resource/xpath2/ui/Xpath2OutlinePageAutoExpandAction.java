/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.xpath2.resource.xpath2.ui;

public class Xpath2OutlinePageAutoExpandAction extends org.emftext.language.xpath2.resource.xpath2.ui.AbstractXpath2OutlinePageAction {
	
	public Xpath2OutlinePageAutoExpandAction(org.emftext.language.xpath2.resource.xpath2.ui.Xpath2OutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Auto expand", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/auto_expand_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setAutoExpand(on);
		getTreeViewer().refresh();
	}
	
}
