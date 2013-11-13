/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.xpath2.resource.xpath2.mopp;

/**
 * The Xpath2TaskItemBuilder is used to find task items in text documents. The
 * current implementation uses the generated lexer and the TaskItemDetector to
 * detect task items. This class is called by the BuilderAdapter, which runs both
 * this builder and the default builder that is intended to be customized.
 */
public class Xpath2TaskItemBuilder {
	
	public void build(org.eclipse.core.resources.IFile resource, org.eclipse.emf.ecore.resource.ResourceSet resourceSet, org.eclipse.core.runtime.IProgressMonitor monitor) {
		monitor.setTaskName("Searching for task items");
		new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2MarkerHelper().removeAllMarkers(resource, org.eclipse.core.resources.IMarker.TASK);
		if (isInBinFolder(resource)) {
			return;
		}
		java.util.List<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TaskItem> taskItems = new java.util.ArrayList<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TaskItem>();
		org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TaskItemDetector taskItemDetector = new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TaskItemDetector();
		try {
			java.io.InputStream inputStream = resource.getContents();
			String content = org.emftext.language.xpath2.resource.xpath2.util.Xpath2StreamUtil.getContent(inputStream);
			org.emftext.language.xpath2.resource.xpath2.IXpath2TextScanner lexer = new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2MetaInformation().createLexer();
			lexer.setText(content);
			
			org.emftext.language.xpath2.resource.xpath2.IXpath2TextToken nextToken = lexer.getNextToken();
			while (nextToken != null) {
				String text = nextToken.getText();
				taskItems.addAll(taskItemDetector.findTaskItems(text, nextToken.getLine(), nextToken.getOffset()));
				nextToken = lexer.getNextToken();
			}
		} catch (java.io.IOException e) {
			org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2Plugin.logError("Exception while searching for task items", e);
		} catch (org.eclipse.core.runtime.CoreException e) {
			org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2Plugin.logError("Exception while searching for task items", e);
		}
		
		for (org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TaskItem taskItem : taskItems) {
			java.util.Map<String, Object> markerAttributes = new java.util.LinkedHashMap<String, Object>();
			markerAttributes.put(org.eclipse.core.resources.IMarker.USER_EDITABLE, false);
			markerAttributes.put(org.eclipse.core.resources.IMarker.DONE, false);
			markerAttributes.put(org.eclipse.core.resources.IMarker.LINE_NUMBER, taskItem.getLine());
			markerAttributes.put(org.eclipse.core.resources.IMarker.CHAR_START, taskItem.getCharStart());
			markerAttributes.put(org.eclipse.core.resources.IMarker.CHAR_END, taskItem.getCharEnd());
			markerAttributes.put(org.eclipse.core.resources.IMarker.MESSAGE, taskItem.getMessage());
			new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2MarkerHelper().createMarker(resource, org.eclipse.core.resources.IMarker.TASK, markerAttributes);
		}
	}
	
	public String getBuilderMarkerId() {
		return org.eclipse.core.resources.IMarker.TASK;
	}
	
	public boolean isInBinFolder(org.eclipse.core.resources.IFile resource) {
		org.eclipse.core.resources.IContainer parent = resource.getParent();
		while (parent != null) {
			if ("bin".equals(parent.getName())) {
				return true;
			}
			parent = parent.getParent();
		}
		return false;
	}
	
}
