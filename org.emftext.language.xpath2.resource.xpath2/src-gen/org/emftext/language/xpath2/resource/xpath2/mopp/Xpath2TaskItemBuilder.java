/**
 * Copyright (c) 2013, 2016 Denis Nikiforov.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Denis Nikiforov - initial API and implementation
 */
package org.emftext.language.xpath2.resource.xpath2.mopp;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * The Xpath2TaskItemBuilder is used to find task items in text documents. The
 * current implementation uses the generated lexer and the TaskItemDetector to
 * detect task items. This class is called by the BuilderAdapter, which runs both
 * this builder and the default builder that is intended to be customized.
 */
public class Xpath2TaskItemBuilder {
	
	public void build(IFile resource, ResourceSet resourceSet, IProgressMonitor monitor) {
		// We use one tick from the parent monitor because the BuilderAdapter reserves one
		// tick for finding task items.
		SubProgressMonitor subMonitor = new SubProgressMonitor(monitor, 1);
		// We define the overall work to be 3 ticks (removing markers, scanning the
		// resource, creating new markers).
		subMonitor.beginTask("Searching for task items in " + new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2MetaInformation().getSyntaxName() + " files", 3);
		new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2MarkerHelper().removeAllMarkers(resource, IMarker.TASK);
		subMonitor.worked(1);
		if (isInBinFolder(resource)) {
			subMonitor.done();
			return;
		}
		List<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TaskItem> taskItems = new ArrayList<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TaskItem>();
		org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TaskItemDetector taskItemDetector = new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TaskItemDetector();
		InputStream inputStream = null;
		try {
			inputStream = resource.getContents();
			String charset = resource.getCharset();
			String content = org.emftext.language.xpath2.resource.xpath2.util.Xpath2StreamUtil.getContent(inputStream, charset);
			org.emftext.language.xpath2.resource.xpath2.IXpath2TextScanner lexer = new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2MetaInformation().createLexer();
			lexer.setText(content);
			
			org.emftext.language.xpath2.resource.xpath2.IXpath2TextToken nextToken = lexer.getNextToken();
			while (nextToken != null) {
				String text = nextToken.getText();
				taskItems.addAll(taskItemDetector.findTaskItems(text, nextToken.getLine(), nextToken.getOffset()));
				nextToken = lexer.getNextToken();
			}
		} catch (IOException e) {
			org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2Plugin.logError("Exception while searching for task items", e);
		} catch (CoreException e) {
			org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2Plugin.logError("Exception while searching for task items", e);
		}
		
		try {
			if (inputStream != null) {
				inputStream.close();
			}
		} catch (IOException e) {
			// Ignore this
		}
		subMonitor.worked(1);
		
		for (org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TaskItem taskItem : taskItems) {
			Map<String, Object> markerAttributes = new LinkedHashMap<String, Object>();
			markerAttributes.put(IMarker.USER_EDITABLE, false);
			markerAttributes.put(IMarker.DONE, false);
			markerAttributes.put(IMarker.LINE_NUMBER, taskItem.getLine());
			markerAttributes.put(IMarker.CHAR_START, taskItem.getCharStart());
			markerAttributes.put(IMarker.CHAR_END, taskItem.getCharEnd());
			markerAttributes.put(IMarker.MESSAGE, taskItem.getMessage());
			new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2MarkerHelper().createMarker(resource, IMarker.TASK, markerAttributes);
		}
		subMonitor.worked(1);
		subMonitor.done();
	}
	
	public String getBuilderMarkerId() {
		return IMarker.TASK;
	}
	
	public boolean isInBinFolder(IFile resource) {
		IContainer parent = resource.getParent();
		while (parent != null) {
			if ("bin".equals(parent.getName())) {
				return true;
			}
			parent = parent.getParent();
		}
		return false;
	}
	
}
