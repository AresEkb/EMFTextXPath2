/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.xpath2.resource.xpath2.ui;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class Xpath2ProposalPostProcessor {
	
	public java.util.List<org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal> process(java.util.List<org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
