/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.xpath2.resource.xpath2.mopp;

public class Xpath2BracketInformationProvider {
	
	public class BracketPair implements org.emftext.language.xpath2.resource.xpath2.IXpath2BracketPair {
		
		private String opening;
		private String closing;
		private boolean closingEnabledInside;
		
		public BracketPair(String opening, String closing, boolean closingEnabledInside) {
			super();
			this.opening = opening;
			this.closing = closing;
			this.closingEnabledInside = closingEnabledInside;
		}
		
		public String getOpeningBracket() {
			return opening;
		}
		
		public String getClosingBracket() {
			return closing;
		}
		
		public boolean isClosingEnabledInside() {
			return closingEnabledInside;
		}
	}
	
	public java.util.Collection<org.emftext.language.xpath2.resource.xpath2.IXpath2BracketPair> getBracketPairs() {
		java.util.Collection<org.emftext.language.xpath2.resource.xpath2.IXpath2BracketPair> result = new java.util.ArrayList<org.emftext.language.xpath2.resource.xpath2.IXpath2BracketPair>();
		result.add(new BracketPair("(", ")", true));
		result.add(new BracketPair("[", "]", true));
		return result;
	}
	
}
