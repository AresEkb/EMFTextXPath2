/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.xpath2.resource.xpath2;

/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IXpath2Command<ContextType> {
	
	public boolean execute(ContextType context);
}
