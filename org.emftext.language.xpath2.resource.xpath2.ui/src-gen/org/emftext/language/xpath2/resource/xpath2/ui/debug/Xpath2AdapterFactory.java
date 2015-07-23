/**
 * Copyright (c) 2013, 2015 Denis Nikiforov.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Denis Nikiforov - initial API and implementation
 */
package org.emftext.language.xpath2.resource.xpath2.ui.debug;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IChildrenCountUpdate;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IChildrenUpdate;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IElementContentProvider;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IElementLabelProvider;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IHasChildrenUpdate;
import org.eclipse.debug.internal.ui.viewers.model.provisional.ILabelUpdate;
import org.eclipse.debug.ui.actions.IToggleBreakpointsTarget;
import org.eclipse.ui.texteditor.ITextEditor;

@SuppressWarnings("restriction")
public class Xpath2AdapterFactory implements IAdapterFactory {
	
	@SuppressWarnings("rawtypes")
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adaptableObject instanceof ITextEditor) {
			ITextEditor editorPart = (ITextEditor) adaptableObject;
			IResource resource = (IResource) editorPart.getEditorInput().getAdapter(IResource.class);
			if (resource != null) {
				String extension = resource.getFileExtension();
				if (extension != null && extension.equals(new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2MetaInformation().getSyntaxName())) {
					return new org.emftext.language.xpath2.resource.xpath2.ui.Xpath2UIMetaInformation().createResourceAdapter(adaptableObject, adapterType, resource);
				}
			}
		}
		if (adapterType == IElementLabelProvider.class && adaptableObject instanceof org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugVariable) {
			final org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugVariable variable = (org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugVariable) adaptableObject;
			return new IElementLabelProvider() {
				
				public void update(ILabelUpdate[] updates) {
					for (ILabelUpdate update : updates) {
						try {
							update.setLabel(variable.getName(), 0);
							update.setLabel(variable.getValue().getValueString(), 1);
							update.done();
						} catch (DebugException e) {
						}
					}
				}
			};
		}
		if (adapterType == IElementContentProvider.class && adaptableObject instanceof org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugVariable) {
			final org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugVariable variable = (org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugVariable) adaptableObject;
			return new IElementContentProvider() {
				
				public void update(IChildrenCountUpdate[] updates) {
					try {
						for (IChildrenCountUpdate update : updates) {
							IValue value = variable.getValue();
							org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugValue castedValue = (org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugValue) value;
							update.setChildCount(castedValue.getVariableCount());
							update.done();
						}
					} catch (DebugException e) {
						e.printStackTrace();
					}
				}
				
				public void update(IChildrenUpdate[] updates) {
					try {
						IValue value = variable.getValue();
						org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugValue castedValue = (org.emftext.language.xpath2.resource.xpath2.debug.Xpath2DebugValue) value;
						for (IChildrenUpdate update : updates) {
							int offset = update.getOffset();
							int length = update.getLength();
							for (int i = offset; i < offset + length; i++) {
								IVariable variable = castedValue.getChild(i);
								update.setChild(variable, i);
							}
							update.done();
						}
					} catch (DebugException e) {
						e.printStackTrace();
					}
				}
				
				public void update(IHasChildrenUpdate[] updates) {
					for (IHasChildrenUpdate update : updates) {
						try {
							update.setHasChilren(variable.getValue().hasVariables());
							update.done();
						} catch (DebugException e) {
							e.printStackTrace();
						}
					}
				}
			};
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public Class[] getAdapterList() {
		return new Class[] {IToggleBreakpointsTarget.class};
	}
	
}
