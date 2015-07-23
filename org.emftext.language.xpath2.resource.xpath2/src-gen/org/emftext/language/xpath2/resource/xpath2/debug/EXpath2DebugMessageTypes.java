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


public enum EXpath2DebugMessageTypes {
	
	// An enumeration of all commands that can be sent to the debug server from debug
	// clients (i.e., interpreters or other processes).
	STARTED,
	RESUMED,
	TERMINATED,
	SUSPENDED,
	
	// An enumeration of all commands that can be sent by the debug server to debug
	// clients (i.e., interpreters or other processes).
	GET_FRAME_VARIABLES,
	GET_VARIABLES,
	GET_STACK,
	STEP_RETURN,
	STEP_INTO,
	STEP_OVER,
	RESUME,
	EXIT,
	
	ADD_LINE_BREAKPOINT,
	REMOVE_LINE_BREAKPOINT,
	
	GET_STACK_RESPONSE,
	GET_FRAME_VARIABLES_RESPONSE,
	GET_VARIABLES_RESPONSE,
}
