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
package org.emftext.language.xpath2.resource.xpath2.debug;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant;

public class Xpath2SourceLookupParticipant extends AbstractSourceLookupParticipant {
	
	public String getSourceName(Object object) throws CoreException {
		if (object instanceof org.emftext.language.xpath2.resource.xpath2.debug.Xpath2StackFrame) {
			org.emftext.language.xpath2.resource.xpath2.debug.Xpath2StackFrame frame = (org.emftext.language.xpath2.resource.xpath2.debug.Xpath2StackFrame) object;
			return frame.getResourceURI();
		}
		return null;
	}
	
}
