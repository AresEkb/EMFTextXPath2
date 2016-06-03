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
package org.emftext.language.xpath2.resource.xpath2.mopp;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * This class is used when computing code completion proposals to group a set of
 * expected elements which belong to the same follow set.
 */
public class Xpath2FollowSetGroup {
	
	private List<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal> expectedTerminals = new ArrayList<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal>();
	
	public void add(org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal expectedTerminal) {
		expectedTerminals.add(expectedTerminal);
	}
	
	public List<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal> getExpectedTerminals() {
		return expectedTerminals;
	}
	
	public int getStartExcludingHiddenTokens() {
		int lastStart = -1;
		for (org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal expectedTerminal : expectedTerminals) {
			int nextStart = expectedTerminal.getStartExcludingHiddenTokens();
			if (lastStart < 0) {
				lastStart = nextStart;
			} else if (lastStart != nextStart) {
				System.err.println("Found terminals in same follow set with different start.");
			}
		}
		
		return lastStart;
	}
	
	public EClass getRule() {
		EClass lastRule = null;
		for (org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal expectedTerminal : expectedTerminals) {
			EClass nextRule = expectedTerminal.getTerminal().getRuleMetaclass();
			if (lastRule == null) {
				lastRule = nextRule;
			} else if (lastRule != nextRule) {
				System.err.println("Found terminals in same follow set with different rule.");
			}
		}
		
		return lastRule;
	}
	
	public boolean hasSameStartExcludingHiddenTokens(int lastStartExcludingHiddenTokens) {
		if (lastStartExcludingHiddenTokens < 0) {
			return false;
		}
		
		return lastStartExcludingHiddenTokens == getStartExcludingHiddenTokens();
	}
	
	public boolean hasDifferentRule(EClass lastRule) {
		if (lastRule == null) {
			return true;
		}
		
		return lastRule != getRule();
	}
	
	public EObject getContainer() {
		EObject lastContainer = null;
		for (org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal expectedTerminal : expectedTerminals) {
			EObject nextContainer = expectedTerminal.getContainer();
			if (lastContainer == null) {
				lastContainer = nextContainer;
			} else if (lastContainer != nextContainer) {
				System.err.println("Found terminals in same follow set with different container.");
			}
		}
		
		return lastContainer;
	}
	
	@Override
	public String toString() {
		return "Xpath2FollowSetGroup" + expectedTerminals;
	}
	
}
