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

/**
 * This class is used when computing code completion proposals hold groups of
 * expected elements which belong to the same follow set.
 */
public class Xpath2FollowSetGroupList {
	
	private int lastFollowSetID = -1;
	private List<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2FollowSetGroup> followSetGroups = new ArrayList<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2FollowSetGroup>();
	
	public Xpath2FollowSetGroupList(List<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal> expectedTerminals) {
		for (org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal expectedTerminal : expectedTerminals) {
			addExpectedTerminal(expectedTerminal);
		}
	}
	
	private void addExpectedTerminal(org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal expectedTerminal) {
		org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2FollowSetGroup group;
		
		int followSetID = expectedTerminal.getFollowSetID();
		if (followSetID == lastFollowSetID) {
			if (followSetGroups.isEmpty()) {
				group = addNewGroup();
			} else {
				group = followSetGroups.get(followSetGroups.size() - 1);
			}
		} else {
			group = addNewGroup();
			lastFollowSetID = followSetID;
		}
		
		group.add(expectedTerminal);
	}
	
	public List<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2FollowSetGroup> getFollowSetGroups() {
		return followSetGroups;
	}
	
	private org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2FollowSetGroup addNewGroup() {
		org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2FollowSetGroup group = new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2FollowSetGroup();
		followSetGroups.add(group);
		return group;
	}
	
}
