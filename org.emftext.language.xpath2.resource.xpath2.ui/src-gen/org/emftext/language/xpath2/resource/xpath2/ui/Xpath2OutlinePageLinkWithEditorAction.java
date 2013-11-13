/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.xpath2.resource.xpath2.ui;

public class Xpath2OutlinePageLinkWithEditorAction extends org.emftext.language.xpath2.resource.xpath2.ui.AbstractXpath2OutlinePageAction {
	
	public Xpath2OutlinePageLinkWithEditorAction(org.emftext.language.xpath2.resource.xpath2.ui.Xpath2OutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}
