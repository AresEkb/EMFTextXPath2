/**
 * Copyright (c) 2013, 2014 Denis Nikiforov.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Denis Nikiforov - initial API and implementation
 */
package org.emftext.language.xpath2.resource.xpath2.grammar;

import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;

public class Xpath2GrammarInformationProvider {
	
	public final static EStructuralFeature ANONYMOUS_FEATURE = EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static Xpath2GrammarInformationProvider INSTANCE = new Xpath2GrammarInformationProvider();
	
	private Set<String> keywords;
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_0_0_0_0 = INSTANCE.getXPATH2_0_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_0_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.EXPR__EXPR), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.XPath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.XPath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.XPath2Package.eINSTANCE.getOrExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_0_0_0_1_0_0_0 = INSTANCE.getXPATH2_0_0_0_1_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_0_0_0_1_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword(",", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_0_0_0_1_0_0_1 = INSTANCE.getXPATH2_0_0_0_1_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_0_0_0_1_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.EXPR__EXPR), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.XPath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.XPath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.XPath2Package.eINSTANCE.getOrExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_0_0_0_1_0_0 = INSTANCE.getXPATH2_0_0_0_1_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_0_0_0_1_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_0_0_0_1_0_0_0, XPATH2_0_0_0_1_0_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_0_0_0_1_0 = INSTANCE.getXPATH2_0_0_0_1_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_0_0_0_1_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_0_0_0_1_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound XPATH2_0_0_0_1 = INSTANCE.getXPATH2_0_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound getXPATH2_0_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound(XPATH2_0_0_0_1_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.STAR);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_0_0_0 = INSTANCE.getXPATH2_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_0_0_0_0, XPATH2_0_0_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_0_0 = INSTANCE.getXPATH2_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_0_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_0 = INSTANCE.getXPATH2_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getExpr(), XPATH2_0_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_1_0_0_0 = INSTANCE.getXPATH2_1_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_1_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("for", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_1_0_0_1 = INSTANCE.getXPATH2_1_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_1_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_1_0_0_2 = INSTANCE.getXPATH2_1_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_1_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getForExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.FOR_EXPR__ITERATOR), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIterator(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_1_0_0_3_0_0_0 = INSTANCE.getXPATH2_1_0_0_3_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_1_0_0_3_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword(",", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_1_0_0_3_0_0_1 = INSTANCE.getXPATH2_1_0_0_3_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_1_0_0_3_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_1_0_0_3_0_0_2 = INSTANCE.getXPATH2_1_0_0_3_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_1_0_0_3_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getForExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.FOR_EXPR__ITERATOR), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIterator(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_1_0_0_3_0_0 = INSTANCE.getXPATH2_1_0_0_3_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_1_0_0_3_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_1_0_0_3_0_0_0, XPATH2_1_0_0_3_0_0_1, XPATH2_1_0_0_3_0_0_2);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_1_0_0_3_0 = INSTANCE.getXPATH2_1_0_0_3_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_1_0_0_3_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_1_0_0_3_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound XPATH2_1_0_0_3 = INSTANCE.getXPATH2_1_0_0_3();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound getXPATH2_1_0_0_3() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound(XPATH2_1_0_0_3_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.STAR);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_1_0_0_4 = INSTANCE.getXPATH2_1_0_0_4();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_1_0_0_4() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_1_0_0_5 = INSTANCE.getXPATH2_1_0_0_5();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_1_0_0_5() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("return", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_1_0_0_6 = INSTANCE.getXPATH2_1_0_0_6();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_1_0_0_6() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_1_0_0_7 = INSTANCE.getXPATH2_1_0_0_7();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_1_0_0_7() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getForExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.FOR_EXPR__RETURN), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getExprSingle(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_1_0_0 = INSTANCE.getXPATH2_1_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_1_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_1_0_0_0, XPATH2_1_0_0_1, XPATH2_1_0_0_2, XPATH2_1_0_0_3, XPATH2_1_0_0_4, XPATH2_1_0_0_5, XPATH2_1_0_0_6, XPATH2_1_0_0_7);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_1_0 = INSTANCE.getXPATH2_1_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_1_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_1_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_1 = INSTANCE.getXPATH2_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getForExpr(), XPATH2_1_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal XPATH2_2_0_0_0 = INSTANCE.getXPATH2_2_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal getXPATH2_2_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getQuantifiedExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.QUANTIFIED_EXPR__QUANTIFIER), new String[] {"some", "some", "every", "every", }, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_2_0_0_1 = INSTANCE.getXPATH2_2_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_2_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_2_0_0_2 = INSTANCE.getXPATH2_2_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_2_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getQuantifiedExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.QUANTIFIED_EXPR__ITERATOR), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIterator(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_2_0_0_3_0_0_0 = INSTANCE.getXPATH2_2_0_0_3_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_2_0_0_3_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword(",", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_2_0_0_3_0_0_1 = INSTANCE.getXPATH2_2_0_0_3_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_2_0_0_3_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_2_0_0_3_0_0_2 = INSTANCE.getXPATH2_2_0_0_3_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_2_0_0_3_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getQuantifiedExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.QUANTIFIED_EXPR__ITERATOR), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIterator(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_2_0_0_3_0_0 = INSTANCE.getXPATH2_2_0_0_3_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_2_0_0_3_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_2_0_0_3_0_0_0, XPATH2_2_0_0_3_0_0_1, XPATH2_2_0_0_3_0_0_2);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_2_0_0_3_0 = INSTANCE.getXPATH2_2_0_0_3_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_2_0_0_3_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_2_0_0_3_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound XPATH2_2_0_0_3 = INSTANCE.getXPATH2_2_0_0_3();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound getXPATH2_2_0_0_3() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound(XPATH2_2_0_0_3_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.STAR);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_2_0_0_4 = INSTANCE.getXPATH2_2_0_0_4();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_2_0_0_4() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("satisfies", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_2_0_0_5 = INSTANCE.getXPATH2_2_0_0_5();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_2_0_0_5() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_2_0_0_6 = INSTANCE.getXPATH2_2_0_0_6();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_2_0_0_6() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getQuantifiedExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.QUANTIFIED_EXPR__SATISFIES), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.XPath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.XPath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.XPath2Package.eINSTANCE.getOrExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_2_0_0 = INSTANCE.getXPATH2_2_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_2_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_2_0_0_0, XPATH2_2_0_0_1, XPATH2_2_0_0_2, XPATH2_2_0_0_3, XPATH2_2_0_0_4, XPATH2_2_0_0_5, XPATH2_2_0_0_6);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_2_0 = INSTANCE.getXPATH2_2_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_2_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_2_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_2 = INSTANCE.getXPATH2_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getQuantifiedExpr(), XPATH2_2_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_3_0_0_0 = INSTANCE.getXPATH2_3_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_3_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("$", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder XPATH2_3_0_0_1_0_0_0 = INSTANCE.getXPATH2_3_0_0_1_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder getXPATH2_3_0_0_1_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIterator().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ITERATOR__VAR_NAME), "QNAME", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_3_0_0_1_0_0 = INSTANCE.getXPATH2_3_0_0_1_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_3_0_0_1_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_3_0_0_1_0_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder XPATH2_3_0_0_1_0_1_0 = INSTANCE.getXPATH2_3_0_0_1_0_1_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder getXPATH2_3_0_0_1_0_1_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIterator().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ITERATOR__VAR_NAME), "NCNAME", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_3_0_0_1_0_1 = INSTANCE.getXPATH2_3_0_0_1_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_3_0_0_1_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_3_0_0_1_0_1_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_3_0_0_1_0 = INSTANCE.getXPATH2_3_0_0_1_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_3_0_0_1_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_3_0_0_1_0_0, XPATH2_3_0_0_1_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound XPATH2_3_0_0_1 = INSTANCE.getXPATH2_3_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound getXPATH2_3_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound(XPATH2_3_0_0_1_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_3_0_0_2 = INSTANCE.getXPATH2_3_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_3_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_3_0_0_3 = INSTANCE.getXPATH2_3_0_0_3();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_3_0_0_3() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("in", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_3_0_0_4 = INSTANCE.getXPATH2_3_0_0_4();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_3_0_0_4() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_3_0_0_5 = INSTANCE.getXPATH2_3_0_0_5();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_3_0_0_5() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIterator().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ITERATOR__LIST), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.XPath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.XPath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.XPath2Package.eINSTANCE.getOrExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_3_0_0 = INSTANCE.getXPATH2_3_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_3_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_3_0_0_0, XPATH2_3_0_0_1, XPATH2_3_0_0_2, XPATH2_3_0_0_3, XPATH2_3_0_0_4, XPATH2_3_0_0_5);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_3_0 = INSTANCE.getXPATH2_3_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_3_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_3_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_3 = INSTANCE.getXPATH2_3();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_3() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIterator(), XPATH2_3_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_4_0_0_0 = INSTANCE.getXPATH2_4_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_4_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("if", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_4_0_0_1 = INSTANCE.getXPATH2_4_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_4_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_4_0_0_2 = INSTANCE.getXPATH2_4_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_4_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("(", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_4_0_0_3 = INSTANCE.getXPATH2_4_0_0_3();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_4_0_0_3() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIfExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.IF_EXPR__TEST), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getExpr(), org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.XPath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.XPath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.XPath2Package.eINSTANCE.getOrExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_4_0_0_4 = INSTANCE.getXPATH2_4_0_0_4();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_4_0_0_4() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword(")", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_4_0_0_5 = INSTANCE.getXPATH2_4_0_0_5();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_4_0_0_5() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_4_0_0_6 = INSTANCE.getXPATH2_4_0_0_6();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_4_0_0_6() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("then", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_4_0_0_7 = INSTANCE.getXPATH2_4_0_0_7();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_4_0_0_7() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_4_0_0_8 = INSTANCE.getXPATH2_4_0_0_8();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_4_0_0_8() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIfExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.IF_EXPR__THEN), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.XPath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.XPath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.XPath2Package.eINSTANCE.getOrExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_4_0_0_9 = INSTANCE.getXPATH2_4_0_0_9();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_4_0_0_9() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_4_0_0_10 = INSTANCE.getXPATH2_4_0_0_10();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_4_0_0_10() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("else", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_4_0_0_11 = INSTANCE.getXPATH2_4_0_0_11();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_4_0_0_11() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_4_0_0_12 = INSTANCE.getXPATH2_4_0_0_12();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_4_0_0_12() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIfExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.IF_EXPR__ELSE), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.XPath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.XPath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.XPath2Package.eINSTANCE.getOrExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_4_0_0 = INSTANCE.getXPATH2_4_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_4_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_4_0_0_0, XPATH2_4_0_0_1, XPATH2_4_0_0_2, XPATH2_4_0_0_3, XPATH2_4_0_0_4, XPATH2_4_0_0_5, XPATH2_4_0_0_6, XPATH2_4_0_0_7, XPATH2_4_0_0_8, XPATH2_4_0_0_9, XPATH2_4_0_0_10, XPATH2_4_0_0_11, XPATH2_4_0_0_12);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_4_0 = INSTANCE.getXPATH2_4_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_4_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_4_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_4 = INSTANCE.getXPATH2_4();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_4() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIfExpr(), XPATH2_4_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_5_0_0_0 = INSTANCE.getXPATH2_5_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_5_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getOrExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.OR_EXPR__OPERAND), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAndExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_5_0_0_1_0_0_0 = INSTANCE.getXPATH2_5_0_0_1_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_5_0_0_1_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_5_0_0_1_0_0_1 = INSTANCE.getXPATH2_5_0_0_1_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_5_0_0_1_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("or", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_5_0_0_1_0_0_2 = INSTANCE.getXPATH2_5_0_0_1_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_5_0_0_1_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_5_0_0_1_0_0_3 = INSTANCE.getXPATH2_5_0_0_1_0_0_3();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_5_0_0_1_0_0_3() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getOrExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.OR_EXPR__OPERAND), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAndExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_5_0_0_1_0_0 = INSTANCE.getXPATH2_5_0_0_1_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_5_0_0_1_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_5_0_0_1_0_0_0, XPATH2_5_0_0_1_0_0_1, XPATH2_5_0_0_1_0_0_2, XPATH2_5_0_0_1_0_0_3);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_5_0_0_1_0 = INSTANCE.getXPATH2_5_0_0_1_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_5_0_0_1_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_5_0_0_1_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound XPATH2_5_0_0_1 = INSTANCE.getXPATH2_5_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound getXPATH2_5_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound(XPATH2_5_0_0_1_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.STAR);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_5_0_0 = INSTANCE.getXPATH2_5_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_5_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_5_0_0_0, XPATH2_5_0_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_5_0 = INSTANCE.getXPATH2_5_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_5_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_5_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_5 = INSTANCE.getXPATH2_5();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_5() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getOrExpr(), XPATH2_5_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_6_0_0_0 = INSTANCE.getXPATH2_6_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_6_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAndExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.AND_EXPR__OPERAND), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_6_0_0_1_0_0_0 = INSTANCE.getXPATH2_6_0_0_1_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_6_0_0_1_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_6_0_0_1_0_0_1 = INSTANCE.getXPATH2_6_0_0_1_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_6_0_0_1_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("and", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_6_0_0_1_0_0_2 = INSTANCE.getXPATH2_6_0_0_1_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_6_0_0_1_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_6_0_0_1_0_0_3 = INSTANCE.getXPATH2_6_0_0_1_0_0_3();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_6_0_0_1_0_0_3() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAndExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.AND_EXPR__OPERAND), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_6_0_0_1_0_0 = INSTANCE.getXPATH2_6_0_0_1_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_6_0_0_1_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_6_0_0_1_0_0_0, XPATH2_6_0_0_1_0_0_1, XPATH2_6_0_0_1_0_0_2, XPATH2_6_0_0_1_0_0_3);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_6_0_0_1_0 = INSTANCE.getXPATH2_6_0_0_1_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_6_0_0_1_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_6_0_0_1_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound XPATH2_6_0_0_1 = INSTANCE.getXPATH2_6_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound getXPATH2_6_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound(XPATH2_6_0_0_1_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.STAR);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_6_0_0 = INSTANCE.getXPATH2_6_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_6_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_6_0_0_0, XPATH2_6_0_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_6_0 = INSTANCE.getXPATH2_6_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_6_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_6_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_6 = INSTANCE.getXPATH2_6();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_6() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAndExpr(), XPATH2_6_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_7_0_0_0 = INSTANCE.getXPATH2_7_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_7_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.COMPARISON_EXPR__LEFT), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getRangeExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_7_0_0_1_0_0_0 = INSTANCE.getXPATH2_7_0_0_1_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_7_0_0_1_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_7_0_0_1_0_0_1 = INSTANCE.getXPATH2_7_0_0_1_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_7_0_0_1_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.COMPARISON_EXPR__OPERATOR), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComp(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_7_0_0_1_0_0_2 = INSTANCE.getXPATH2_7_0_0_1_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_7_0_0_1_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_7_0_0_1_0_0_3 = INSTANCE.getXPATH2_7_0_0_1_0_0_3();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_7_0_0_1_0_0_3() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.COMPARISON_EXPR__RIGHT), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getRangeExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_7_0_0_1_0_0 = INSTANCE.getXPATH2_7_0_0_1_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_7_0_0_1_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_7_0_0_1_0_0_0, XPATH2_7_0_0_1_0_0_1, XPATH2_7_0_0_1_0_0_2, XPATH2_7_0_0_1_0_0_3);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_7_0_0_1_0 = INSTANCE.getXPATH2_7_0_0_1_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_7_0_0_1_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_7_0_0_1_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound XPATH2_7_0_0_1 = INSTANCE.getXPATH2_7_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound getXPATH2_7_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound(XPATH2_7_0_0_1_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.QUESTIONMARK);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_7_0_0 = INSTANCE.getXPATH2_7_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_7_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_7_0_0_0, XPATH2_7_0_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_7_0 = INSTANCE.getXPATH2_7_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_7_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_7_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_7 = INSTANCE.getXPATH2_7();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_7() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), XPATH2_7_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_8_0_0_0 = INSTANCE.getXPATH2_8_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_8_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getRangeExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.RANGE_EXPR__FROM), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAdditiveExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_8_0_0_1_0_0_0 = INSTANCE.getXPATH2_8_0_0_1_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_8_0_0_1_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_8_0_0_1_0_0_1 = INSTANCE.getXPATH2_8_0_0_1_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_8_0_0_1_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("to", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_8_0_0_1_0_0_2 = INSTANCE.getXPATH2_8_0_0_1_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_8_0_0_1_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_8_0_0_1_0_0_3 = INSTANCE.getXPATH2_8_0_0_1_0_0_3();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_8_0_0_1_0_0_3() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getRangeExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.RANGE_EXPR__TO), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAdditiveExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_8_0_0_1_0_0 = INSTANCE.getXPATH2_8_0_0_1_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_8_0_0_1_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_8_0_0_1_0_0_0, XPATH2_8_0_0_1_0_0_1, XPATH2_8_0_0_1_0_0_2, XPATH2_8_0_0_1_0_0_3);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_8_0_0_1_0 = INSTANCE.getXPATH2_8_0_0_1_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_8_0_0_1_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_8_0_0_1_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound XPATH2_8_0_0_1 = INSTANCE.getXPATH2_8_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound getXPATH2_8_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound(XPATH2_8_0_0_1_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.QUESTIONMARK);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_8_0_0 = INSTANCE.getXPATH2_8_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_8_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_8_0_0_0, XPATH2_8_0_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_8_0 = INSTANCE.getXPATH2_8_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_8_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_8_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_8 = INSTANCE.getXPATH2_8();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_8() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getRangeExpr(), XPATH2_8_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal XPATH2_9_0_0_0 = INSTANCE.getXPATH2_9_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal getXPATH2_9_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralComp().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.GENERAL_COMP__OPERATOR), new String[] {"eq", "=", "ne", "!=", "lt", "<", "le", "<=", "gt", ">", "ge", ">=", }, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_9_0_0 = INSTANCE.getXPATH2_9_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_9_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_9_0_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_9_0 = INSTANCE.getXPATH2_9_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_9_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_9_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_9 = INSTANCE.getXPATH2_9();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_9() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralComp(), XPATH2_9_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal XPATH2_10_0_0_0 = INSTANCE.getXPATH2_10_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal getXPATH2_10_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getValueComp().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.VALUE_COMP__OPERATOR), new String[] {"eq", "eq", "ne", "ne", "lt", "lt", "le", "le", "gt", "gt", "ge", "ge", }, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_10_0_0 = INSTANCE.getXPATH2_10_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_10_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_10_0_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_10_0 = INSTANCE.getXPATH2_10_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_10_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_10_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_10 = INSTANCE.getXPATH2_10();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_10() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getValueComp(), XPATH2_10_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal XPATH2_11_0_0_0 = INSTANCE.getXPATH2_11_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal getXPATH2_11_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getNodeComp().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.NODE_COMP__OPERATOR), new String[] {"is", "is", "precedes", "<<", "follows", ">>", }, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_11_0_0 = INSTANCE.getXPATH2_11_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_11_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_11_0_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_11_0 = INSTANCE.getXPATH2_11_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_11_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_11_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_11 = INSTANCE.getXPATH2_11();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_11() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getNodeComp(), XPATH2_11_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_12_0_0_0 = INSTANCE.getXPATH2_12_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_12_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAdditiveExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ADDITIVE_EXPR__OPERAND), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getMultiplicativeExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_12_0_0_1_0_0_0 = INSTANCE.getXPATH2_12_0_0_1_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_12_0_0_1_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal XPATH2_12_0_0_1_0_0_1 = INSTANCE.getXPATH2_12_0_0_1_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal getXPATH2_12_0_0_1_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAdditiveExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ADDITIVE_EXPR__OPERATOR), new String[] {"addition", "+", "subtraction", "-", }, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_12_0_0_1_0_0_2 = INSTANCE.getXPATH2_12_0_0_1_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_12_0_0_1_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_12_0_0_1_0_0_3 = INSTANCE.getXPATH2_12_0_0_1_0_0_3();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_12_0_0_1_0_0_3() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAdditiveExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ADDITIVE_EXPR__OPERAND), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getMultiplicativeExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_12_0_0_1_0_0 = INSTANCE.getXPATH2_12_0_0_1_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_12_0_0_1_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_12_0_0_1_0_0_0, XPATH2_12_0_0_1_0_0_1, XPATH2_12_0_0_1_0_0_2, XPATH2_12_0_0_1_0_0_3);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_12_0_0_1_0 = INSTANCE.getXPATH2_12_0_0_1_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_12_0_0_1_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_12_0_0_1_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound XPATH2_12_0_0_1 = INSTANCE.getXPATH2_12_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound getXPATH2_12_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound(XPATH2_12_0_0_1_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.STAR);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_12_0_0 = INSTANCE.getXPATH2_12_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_12_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_12_0_0_0, XPATH2_12_0_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_12_0 = INSTANCE.getXPATH2_12_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_12_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_12_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_12 = INSTANCE.getXPATH2_12();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_12() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAdditiveExpr(), XPATH2_12_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_13_0_0_0 = INSTANCE.getXPATH2_13_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_13_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getMultiplicativeExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.MULTIPLICATIVE_EXPR__OPERAND), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getUnionExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_13_0_0_1_0_0_0 = INSTANCE.getXPATH2_13_0_0_1_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_13_0_0_1_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal XPATH2_13_0_0_1_0_0_1 = INSTANCE.getXPATH2_13_0_0_1_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal getXPATH2_13_0_0_1_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getMultiplicativeExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.MULTIPLICATIVE_EXPR__OPERATOR), new String[] {"multiplication", "*", "div", "div", "idiv", "idiv", "mod", "mod", }, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_13_0_0_1_0_0_2 = INSTANCE.getXPATH2_13_0_0_1_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_13_0_0_1_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_13_0_0_1_0_0_3 = INSTANCE.getXPATH2_13_0_0_1_0_0_3();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_13_0_0_1_0_0_3() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getMultiplicativeExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.MULTIPLICATIVE_EXPR__OPERAND), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getUnionExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_13_0_0_1_0_0 = INSTANCE.getXPATH2_13_0_0_1_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_13_0_0_1_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_13_0_0_1_0_0_0, XPATH2_13_0_0_1_0_0_1, XPATH2_13_0_0_1_0_0_2, XPATH2_13_0_0_1_0_0_3);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_13_0_0_1_0 = INSTANCE.getXPATH2_13_0_0_1_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_13_0_0_1_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_13_0_0_1_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound XPATH2_13_0_0_1 = INSTANCE.getXPATH2_13_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound getXPATH2_13_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound(XPATH2_13_0_0_1_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.STAR);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_13_0_0 = INSTANCE.getXPATH2_13_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_13_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_13_0_0_0, XPATH2_13_0_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_13_0 = INSTANCE.getXPATH2_13_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_13_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_13_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_13 = INSTANCE.getXPATH2_13();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_13() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getMultiplicativeExpr(), XPATH2_13_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_14_0_0_0 = INSTANCE.getXPATH2_14_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_14_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getUnionExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.UNION_EXPR__OPERAND), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIntersectExceptExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_14_0_0_1_0_0_0 = INSTANCE.getXPATH2_14_0_0_1_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_14_0_0_1_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal XPATH2_14_0_0_1_0_0_1 = INSTANCE.getXPATH2_14_0_0_1_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal getXPATH2_14_0_0_1_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getUnionExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.UNION_EXPR__OPERATION), new String[] {"union", "union", "vertical_bar", "|", }, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_14_0_0_1_0_0_2 = INSTANCE.getXPATH2_14_0_0_1_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_14_0_0_1_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_14_0_0_1_0_0_3 = INSTANCE.getXPATH2_14_0_0_1_0_0_3();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_14_0_0_1_0_0_3() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getUnionExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.UNION_EXPR__OPERAND), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIntersectExceptExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_14_0_0_1_0_0 = INSTANCE.getXPATH2_14_0_0_1_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_14_0_0_1_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_14_0_0_1_0_0_0, XPATH2_14_0_0_1_0_0_1, XPATH2_14_0_0_1_0_0_2, XPATH2_14_0_0_1_0_0_3);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_14_0_0_1_0 = INSTANCE.getXPATH2_14_0_0_1_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_14_0_0_1_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_14_0_0_1_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound XPATH2_14_0_0_1 = INSTANCE.getXPATH2_14_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound getXPATH2_14_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound(XPATH2_14_0_0_1_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.STAR);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_14_0_0 = INSTANCE.getXPATH2_14_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_14_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_14_0_0_0, XPATH2_14_0_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_14_0 = INSTANCE.getXPATH2_14_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_14_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_14_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_14 = INSTANCE.getXPATH2_14();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_14() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getUnionExpr(), XPATH2_14_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_15_0_0_0 = INSTANCE.getXPATH2_15_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_15_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIntersectExceptExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.INTERSECT_EXCEPT_EXPR__OPERAND), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getInstanceofExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_15_0_0_1_0_0_0 = INSTANCE.getXPATH2_15_0_0_1_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_15_0_0_1_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal XPATH2_15_0_0_1_0_0_1 = INSTANCE.getXPATH2_15_0_0_1_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal getXPATH2_15_0_0_1_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIntersectExceptExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.INTERSECT_EXCEPT_EXPR__OPERATOR), new String[] {"intersect", "intersect", "except", "except", }, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_15_0_0_1_0_0_2 = INSTANCE.getXPATH2_15_0_0_1_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_15_0_0_1_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_15_0_0_1_0_0_3 = INSTANCE.getXPATH2_15_0_0_1_0_0_3();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_15_0_0_1_0_0_3() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIntersectExceptExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.INTERSECT_EXCEPT_EXPR__OPERAND), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getInstanceofExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_15_0_0_1_0_0 = INSTANCE.getXPATH2_15_0_0_1_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_15_0_0_1_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_15_0_0_1_0_0_0, XPATH2_15_0_0_1_0_0_1, XPATH2_15_0_0_1_0_0_2, XPATH2_15_0_0_1_0_0_3);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_15_0_0_1_0 = INSTANCE.getXPATH2_15_0_0_1_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_15_0_0_1_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_15_0_0_1_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound XPATH2_15_0_0_1 = INSTANCE.getXPATH2_15_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound getXPATH2_15_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound(XPATH2_15_0_0_1_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.STAR);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_15_0_0 = INSTANCE.getXPATH2_15_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_15_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_15_0_0_0, XPATH2_15_0_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_15_0 = INSTANCE.getXPATH2_15_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_15_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_15_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_15 = INSTANCE.getXPATH2_15();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_15() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIntersectExceptExpr(), XPATH2_15_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_16_0_0_0 = INSTANCE.getXPATH2_16_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_16_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getInstanceofExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.INSTANCEOF_EXPR__OPERAND), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getTreatExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_16_0_0_1_0_0_0 = INSTANCE.getXPATH2_16_0_0_1_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_16_0_0_1_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_16_0_0_1_0_0_1 = INSTANCE.getXPATH2_16_0_0_1_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_16_0_0_1_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("instance", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_16_0_0_1_0_0_2 = INSTANCE.getXPATH2_16_0_0_1_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_16_0_0_1_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("of", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_16_0_0_1_0_0_3 = INSTANCE.getXPATH2_16_0_0_1_0_0_3();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_16_0_0_1_0_0_3() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getInstanceofExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.INSTANCEOF_EXPR__TYPE), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getSequenceType(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_16_0_0_1_0_0 = INSTANCE.getXPATH2_16_0_0_1_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_16_0_0_1_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_16_0_0_1_0_0_0, XPATH2_16_0_0_1_0_0_1, XPATH2_16_0_0_1_0_0_2, XPATH2_16_0_0_1_0_0_3);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_16_0_0_1_0 = INSTANCE.getXPATH2_16_0_0_1_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_16_0_0_1_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_16_0_0_1_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound XPATH2_16_0_0_1 = INSTANCE.getXPATH2_16_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound getXPATH2_16_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound(XPATH2_16_0_0_1_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.QUESTIONMARK);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_16_0_0 = INSTANCE.getXPATH2_16_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_16_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_16_0_0_0, XPATH2_16_0_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_16_0 = INSTANCE.getXPATH2_16_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_16_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_16_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_16 = INSTANCE.getXPATH2_16();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_16() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getInstanceofExpr(), XPATH2_16_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_17_0_0_0 = INSTANCE.getXPATH2_17_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_17_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getTreatExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.TREAT_EXPR__OPERAND), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getCastableExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_17_0_0_1_0_0_0 = INSTANCE.getXPATH2_17_0_0_1_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_17_0_0_1_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_17_0_0_1_0_0_1 = INSTANCE.getXPATH2_17_0_0_1_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_17_0_0_1_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("treat", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_17_0_0_1_0_0_2 = INSTANCE.getXPATH2_17_0_0_1_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_17_0_0_1_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("as", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_17_0_0_1_0_0_3 = INSTANCE.getXPATH2_17_0_0_1_0_0_3();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_17_0_0_1_0_0_3() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getTreatExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.TREAT_EXPR__TYPE), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getSequenceType(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_17_0_0_1_0_0 = INSTANCE.getXPATH2_17_0_0_1_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_17_0_0_1_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_17_0_0_1_0_0_0, XPATH2_17_0_0_1_0_0_1, XPATH2_17_0_0_1_0_0_2, XPATH2_17_0_0_1_0_0_3);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_17_0_0_1_0 = INSTANCE.getXPATH2_17_0_0_1_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_17_0_0_1_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_17_0_0_1_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound XPATH2_17_0_0_1 = INSTANCE.getXPATH2_17_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound getXPATH2_17_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound(XPATH2_17_0_0_1_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.QUESTIONMARK);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_17_0_0 = INSTANCE.getXPATH2_17_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_17_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_17_0_0_0, XPATH2_17_0_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_17_0 = INSTANCE.getXPATH2_17_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_17_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_17_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_17 = INSTANCE.getXPATH2_17();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_17() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getTreatExpr(), XPATH2_17_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_18_0_0_0 = INSTANCE.getXPATH2_18_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_18_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getCastableExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.CASTABLE_EXPR__OPERAND), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getCastExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_18_0_0_1_0_0_0 = INSTANCE.getXPATH2_18_0_0_1_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_18_0_0_1_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_18_0_0_1_0_0_1 = INSTANCE.getXPATH2_18_0_0_1_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_18_0_0_1_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("castable", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_18_0_0_1_0_0_2 = INSTANCE.getXPATH2_18_0_0_1_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_18_0_0_1_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("as", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_18_0_0_1_0_0_3 = INSTANCE.getXPATH2_18_0_0_1_0_0_3();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_18_0_0_1_0_0_3() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getCastableExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.CASTABLE_EXPR__TYPE), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getSingleType(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_18_0_0_1_0_0 = INSTANCE.getXPATH2_18_0_0_1_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_18_0_0_1_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_18_0_0_1_0_0_0, XPATH2_18_0_0_1_0_0_1, XPATH2_18_0_0_1_0_0_2, XPATH2_18_0_0_1_0_0_3);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_18_0_0_1_0 = INSTANCE.getXPATH2_18_0_0_1_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_18_0_0_1_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_18_0_0_1_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound XPATH2_18_0_0_1 = INSTANCE.getXPATH2_18_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound getXPATH2_18_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound(XPATH2_18_0_0_1_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.QUESTIONMARK);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_18_0_0 = INSTANCE.getXPATH2_18_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_18_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_18_0_0_0, XPATH2_18_0_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_18_0 = INSTANCE.getXPATH2_18_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_18_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_18_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_18 = INSTANCE.getXPATH2_18();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_18() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getCastableExpr(), XPATH2_18_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_19_0_0_0 = INSTANCE.getXPATH2_19_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_19_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getCastExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.CAST_EXPR__OPERAND), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getUnaryExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_19_0_0_1_0_0_0 = INSTANCE.getXPATH2_19_0_0_1_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_19_0_0_1_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_19_0_0_1_0_0_1 = INSTANCE.getXPATH2_19_0_0_1_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_19_0_0_1_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("cast", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_19_0_0_1_0_0_2 = INSTANCE.getXPATH2_19_0_0_1_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_19_0_0_1_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("as", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_19_0_0_1_0_0_3 = INSTANCE.getXPATH2_19_0_0_1_0_0_3();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_19_0_0_1_0_0_3() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getCastExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.CAST_EXPR__TYPE), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getSingleType(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_19_0_0_1_0_0 = INSTANCE.getXPATH2_19_0_0_1_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_19_0_0_1_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_19_0_0_1_0_0_0, XPATH2_19_0_0_1_0_0_1, XPATH2_19_0_0_1_0_0_2, XPATH2_19_0_0_1_0_0_3);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_19_0_0_1_0 = INSTANCE.getXPATH2_19_0_0_1_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_19_0_0_1_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_19_0_0_1_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound XPATH2_19_0_0_1 = INSTANCE.getXPATH2_19_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound getXPATH2_19_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound(XPATH2_19_0_0_1_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.QUESTIONMARK);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_19_0_0 = INSTANCE.getXPATH2_19_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_19_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_19_0_0_0, XPATH2_19_0_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_19_0 = INSTANCE.getXPATH2_19_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_19_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_19_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_19 = INSTANCE.getXPATH2_19();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_19() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getCastExpr(), XPATH2_19_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal XPATH2_20_0_0_0 = INSTANCE.getXPATH2_20_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal getXPATH2_20_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getUnaryExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.UNARY_EXPR__OPERATOR), new String[] {"plus", "+", "minus", "-", }, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.STAR, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_20_0_0_1 = INSTANCE.getXPATH2_20_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_20_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getUnaryExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.UNARY_EXPR__OPERAND), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getValueExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_20_0_0 = INSTANCE.getXPATH2_20_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_20_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_20_0_0_0, XPATH2_20_0_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_20_0 = INSTANCE.getXPATH2_20_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_20_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_20_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_20 = INSTANCE.getXPATH2_20();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_20() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getUnaryExpr(), XPATH2_20_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_21_0_0_0 = INSTANCE.getXPATH2_21_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_21_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getFilterExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.FILTER_EXPR__PRIMARY_EXPR), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPrimaryExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_21_0_0_1 = INSTANCE.getXPATH2_21_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_21_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getFilterExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.FILTER_EXPR__PREDICATE), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.STAR, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPredicate(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_21_0_0 = INSTANCE.getXPATH2_21_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_21_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_21_0_0_0, XPATH2_21_0_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_21_0 = INSTANCE.getXPATH2_21_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_21_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_21_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_21 = INSTANCE.getXPATH2_21();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_21() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getFilterExpr(), XPATH2_21_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder XPATH2_22_0_0_0_0_0_0 = INSTANCE.getXPATH2_22_0_0_0_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder getXPATH2_22_0_0_0_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getFunctionCall().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.FUNCTION_CALL__NAME), "QNAME", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_22_0_0_0_0_0 = INSTANCE.getXPATH2_22_0_0_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_22_0_0_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_22_0_0_0_0_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder XPATH2_22_0_0_0_0_1_0 = INSTANCE.getXPATH2_22_0_0_0_0_1_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder getXPATH2_22_0_0_0_0_1_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getFunctionCall().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.FUNCTION_CALL__NAME), "NCNAME", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_22_0_0_0_0_1 = INSTANCE.getXPATH2_22_0_0_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_22_0_0_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_22_0_0_0_0_1_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_22_0_0_0_0 = INSTANCE.getXPATH2_22_0_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_22_0_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_22_0_0_0_0_0, XPATH2_22_0_0_0_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound XPATH2_22_0_0_0 = INSTANCE.getXPATH2_22_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound getXPATH2_22_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound(XPATH2_22_0_0_0_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_22_0_0_1 = INSTANCE.getXPATH2_22_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_22_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("(", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_22_0_0_2_0_0_0 = INSTANCE.getXPATH2_22_0_0_2_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_22_0_0_2_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getFunctionCall().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.FUNCTION_CALL__ARG), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.XPath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.XPath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.XPath2Package.eINSTANCE.getOrExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_22_0_0_2_0_0_1_0_0_0 = INSTANCE.getXPATH2_22_0_0_2_0_0_1_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_22_0_0_2_0_0_1_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword(",", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_22_0_0_2_0_0_1_0_0_1 = INSTANCE.getXPATH2_22_0_0_2_0_0_1_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_22_0_0_2_0_0_1_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_22_0_0_2_0_0_1_0_0_2 = INSTANCE.getXPATH2_22_0_0_2_0_0_1_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_22_0_0_2_0_0_1_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getFunctionCall().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.FUNCTION_CALL__ARG), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIfExpr(), org.emftext.language.xpath2.XPath2Package.eINSTANCE.getForExpr(), org.emftext.language.xpath2.XPath2Package.eINSTANCE.getQuantifiedExpr(), org.emftext.language.xpath2.XPath2Package.eINSTANCE.getOrExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_22_0_0_2_0_0_1_0_0 = INSTANCE.getXPATH2_22_0_0_2_0_0_1_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_22_0_0_2_0_0_1_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_22_0_0_2_0_0_1_0_0_0, XPATH2_22_0_0_2_0_0_1_0_0_1, XPATH2_22_0_0_2_0_0_1_0_0_2);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_22_0_0_2_0_0_1_0 = INSTANCE.getXPATH2_22_0_0_2_0_0_1_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_22_0_0_2_0_0_1_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_22_0_0_2_0_0_1_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound XPATH2_22_0_0_2_0_0_1 = INSTANCE.getXPATH2_22_0_0_2_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound getXPATH2_22_0_0_2_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound(XPATH2_22_0_0_2_0_0_1_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.STAR);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_22_0_0_2_0_0 = INSTANCE.getXPATH2_22_0_0_2_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_22_0_0_2_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_22_0_0_2_0_0_0, XPATH2_22_0_0_2_0_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_22_0_0_2_0 = INSTANCE.getXPATH2_22_0_0_2_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_22_0_0_2_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_22_0_0_2_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound XPATH2_22_0_0_2 = INSTANCE.getXPATH2_22_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound getXPATH2_22_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound(XPATH2_22_0_0_2_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.QUESTIONMARK);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_22_0_0_3 = INSTANCE.getXPATH2_22_0_0_3();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_22_0_0_3() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword(")", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_22_0_0 = INSTANCE.getXPATH2_22_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_22_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_22_0_0_0, XPATH2_22_0_0_1, XPATH2_22_0_0_2, XPATH2_22_0_0_3);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_22_0 = INSTANCE.getXPATH2_22_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_22_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_22_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_22 = INSTANCE.getXPATH2_22();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_22() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getFunctionCall(), XPATH2_22_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_23_0_0_0 = INSTANCE.getXPATH2_23_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_23_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.PATH_EXPR__STEP), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExprChild(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_23_0_0_1 = INSTANCE.getXPATH2_23_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_23_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.PATH_EXPR__STEP), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.STAR, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getChildStepExpr(), org.emftext.language.xpath2.XPath2Package.eINSTANCE.getDescOrSelfStepExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_23_0_0 = INSTANCE.getXPATH2_23_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_23_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_23_0_0_0, XPATH2_23_0_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_23_0 = INSTANCE.getXPATH2_23_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_23_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_23_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_23 = INSTANCE.getXPATH2_23();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_23() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), XPATH2_23_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_24_0_0_0 = INSTANCE.getXPATH2_24_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_24_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("/", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_24_0_0_1 = INSTANCE.getXPATH2_24_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_24_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getChildStepExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.CHILD_STEP_EXPR__STEP), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getStepExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_24_0_0 = INSTANCE.getXPATH2_24_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_24_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_24_0_0_0, XPATH2_24_0_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_24_0 = INSTANCE.getXPATH2_24_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_24_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_24_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_24 = INSTANCE.getXPATH2_24();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_24() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getChildStepExpr(), XPATH2_24_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_25_0_0_0 = INSTANCE.getXPATH2_25_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_25_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("//", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_25_0_0_1 = INSTANCE.getXPATH2_25_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_25_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getDescOrSelfStepExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.DESC_OR_SELF_STEP_EXPR__STEP), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getStepExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_25_0_0 = INSTANCE.getXPATH2_25_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_25_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_25_0_0_0, XPATH2_25_0_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_25_0 = INSTANCE.getXPATH2_25_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_25_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_25_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_25 = INSTANCE.getXPATH2_25();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_25() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getDescOrSelfStepExpr(), XPATH2_25_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_26_0_0_0 = INSTANCE.getXPATH2_26_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_26_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("/", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_26_0_0 = INSTANCE.getXPATH2_26_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_26_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_26_0_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_26_0 = INSTANCE.getXPATH2_26_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_26_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_26_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_26 = INSTANCE.getXPATH2_26();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_26() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getRootStepExpr(), XPATH2_26_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_27_0_0_0 = INSTANCE.getXPATH2_27_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_27_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getSelfStepExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.SELF_STEP_EXPR__STEP), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getSelfStepExprChild(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_27_0_0 = INSTANCE.getXPATH2_27_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_27_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_27_0_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_27_0 = INSTANCE.getXPATH2_27_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_27_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_27_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_27 = INSTANCE.getXPATH2_27();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_27() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getSelfStepExpr(), XPATH2_27_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal XPATH2_28_0_0_0 = INSTANCE.getXPATH2_28_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal getXPATH2_28_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralForwardStep().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.GENERAL_FORWARD_STEP__AXIS), new String[] {"child", "child", "descendant", "descendant", "attribute", "attribute", "self", "self", "descendant_or_self", "descendant-or-self", "following_sibling", "following-sibling", "following", "following", "namespace", "namespace", }, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_28_0_0_1 = INSTANCE.getXPATH2_28_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_28_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("::", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_28_0_0_2 = INSTANCE.getXPATH2_28_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_28_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralForwardStep().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.GENERAL_FORWARD_STEP__NODE_TEST), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getNodeTest(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_28_0_0_3 = INSTANCE.getXPATH2_28_0_0_3();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_28_0_0_3() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralForwardStep().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.GENERAL_FORWARD_STEP__PREDICATE), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.STAR, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPredicate(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_28_0_0 = INSTANCE.getXPATH2_28_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_28_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_28_0_0_0, XPATH2_28_0_0_1, XPATH2_28_0_0_2, XPATH2_28_0_0_3);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_28_0 = INSTANCE.getXPATH2_28_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_28_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_28_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_28 = INSTANCE.getXPATH2_28();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_28() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralForwardStep(), XPATH2_28_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal XPATH2_29_0_0_0 = INSTANCE.getXPATH2_29_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal getXPATH2_29_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevForwardStep().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ABBREV_FORWARD_STEP__KIND), new String[] {"child", "", "attribute", "@", }, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_29_0_0_1 = INSTANCE.getXPATH2_29_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_29_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevForwardStep().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ABBREV_FORWARD_STEP__NODE_TEST), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getNodeTest(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_29_0_0_2 = INSTANCE.getXPATH2_29_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_29_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevForwardStep().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ABBREV_FORWARD_STEP__PREDICATE), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.STAR, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPredicate(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_29_0_0 = INSTANCE.getXPATH2_29_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_29_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_29_0_0_0, XPATH2_29_0_0_1, XPATH2_29_0_0_2);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_29_0 = INSTANCE.getXPATH2_29_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_29_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_29_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_29 = INSTANCE.getXPATH2_29();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_29() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevForwardStep(), XPATH2_29_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal XPATH2_30_0_0_0 = INSTANCE.getXPATH2_30_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal getXPATH2_30_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralReverseStep().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.GENERAL_REVERSE_STEP__AXIS), new String[] {"parent", "parent", "ancestor", "ancestor", "preceding_sibling", "preceding-sibling", "preceding", "preceding", "ancestor_or_self", "ancestor-or-self", }, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_30_0_0_1 = INSTANCE.getXPATH2_30_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_30_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("::", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_30_0_0_2 = INSTANCE.getXPATH2_30_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_30_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralReverseStep().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.GENERAL_REVERSE_STEP__NODE_TEST), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getNodeTest(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_30_0_0_3 = INSTANCE.getXPATH2_30_0_0_3();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_30_0_0_3() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralReverseStep().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.GENERAL_REVERSE_STEP__PREDICATE), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.STAR, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPredicate(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_30_0_0 = INSTANCE.getXPATH2_30_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_30_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_30_0_0_0, XPATH2_30_0_0_1, XPATH2_30_0_0_2, XPATH2_30_0_0_3);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_30_0 = INSTANCE.getXPATH2_30_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_30_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_30_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_30 = INSTANCE.getXPATH2_30();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_30() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralReverseStep(), XPATH2_30_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal XPATH2_31_0_0_0 = INSTANCE.getXPATH2_31_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal getXPATH2_31_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevReverseStep().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ABBREV_REVERSE_STEP__KIND), new String[] {"parent", "..", }, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_31_0_0_1 = INSTANCE.getXPATH2_31_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_31_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevReverseStep().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ABBREV_REVERSE_STEP__PREDICATE), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.STAR, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPredicate(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_31_0_0 = INSTANCE.getXPATH2_31_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_31_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_31_0_0_0, XPATH2_31_0_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_31_0 = INSTANCE.getXPATH2_31_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_31_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_31_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_31 = INSTANCE.getXPATH2_31();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_31() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevReverseStep(), XPATH2_31_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_32_0_0_0 = INSTANCE.getXPATH2_32_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_32_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getNodeKindTest().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.NODE_KIND_TEST__TEST), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getKindTest(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_32_0_0 = INSTANCE.getXPATH2_32_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_32_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_32_0_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_32_0 = INSTANCE.getXPATH2_32_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_32_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_32_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_32 = INSTANCE.getXPATH2_32();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_32() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getNodeKindTest(), XPATH2_32_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder XPATH2_33_0_0_0_0_0_0 = INSTANCE.getXPATH2_33_0_0_0_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder getXPATH2_33_0_0_0_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getQNameTest().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.QNAME_TEST__NAME), "QNAME", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_33_0_0_0_0_0 = INSTANCE.getXPATH2_33_0_0_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_33_0_0_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_33_0_0_0_0_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder XPATH2_33_0_0_0_0_1_0 = INSTANCE.getXPATH2_33_0_0_0_0_1_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder getXPATH2_33_0_0_0_0_1_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getQNameTest().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.QNAME_TEST__NAME), "NCNAME", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_33_0_0_0_0_1 = INSTANCE.getXPATH2_33_0_0_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_33_0_0_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_33_0_0_0_0_1_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_33_0_0_0_0 = INSTANCE.getXPATH2_33_0_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_33_0_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_33_0_0_0_0_0, XPATH2_33_0_0_0_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound XPATH2_33_0_0_0 = INSTANCE.getXPATH2_33_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound getXPATH2_33_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound(XPATH2_33_0_0_0_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_33_0_0 = INSTANCE.getXPATH2_33_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_33_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_33_0_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_33_0 = INSTANCE.getXPATH2_33_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_33_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_33_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_33 = INSTANCE.getXPATH2_33();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_33() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getQNameTest(), XPATH2_33_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_34_0_0_0 = INSTANCE.getXPATH2_34_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_34_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("*", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_34_0_0 = INSTANCE.getXPATH2_34_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_34_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_34_0_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_34_0 = INSTANCE.getXPATH2_34_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_34_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_34_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_34 = INSTANCE.getXPATH2_34();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_34() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAnyWildcard(), XPATH2_34_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder XPATH2_35_0_0_0 = INSTANCE.getXPATH2_35_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder getXPATH2_35_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getLocalNameWildcard().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.LOCAL_NAME_WILDCARD__NAMESPACE), "NCNAME", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_35_0_0_1 = INSTANCE.getXPATH2_35_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_35_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword(":", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_35_0_0_2 = INSTANCE.getXPATH2_35_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_35_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("*", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_35_0_0 = INSTANCE.getXPATH2_35_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_35_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_35_0_0_0, XPATH2_35_0_0_1, XPATH2_35_0_0_2);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_35_0 = INSTANCE.getXPATH2_35_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_35_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_35_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_35 = INSTANCE.getXPATH2_35();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_35() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getLocalNameWildcard(), XPATH2_35_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_36_0_0_0 = INSTANCE.getXPATH2_36_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_36_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("*", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_36_0_0_1 = INSTANCE.getXPATH2_36_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_36_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword(":", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder XPATH2_36_0_0_2 = INSTANCE.getXPATH2_36_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder getXPATH2_36_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getNamespaceWildcard().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.NAMESPACE_WILDCARD__LOCAL_NAME), "NCNAME", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_36_0_0 = INSTANCE.getXPATH2_36_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_36_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_36_0_0_0, XPATH2_36_0_0_1, XPATH2_36_0_0_2);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_36_0 = INSTANCE.getXPATH2_36_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_36_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_36_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_36 = INSTANCE.getXPATH2_36();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_36() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getNamespaceWildcard(), XPATH2_36_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_37_0_0_0 = INSTANCE.getXPATH2_37_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_37_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("[", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_37_0_0_1 = INSTANCE.getXPATH2_37_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_37_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPredicate().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.PREDICATE__EXPR), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_37_0_0_2 = INSTANCE.getXPATH2_37_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_37_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("]", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_37_0_0 = INSTANCE.getXPATH2_37_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_37_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_37_0_0_0, XPATH2_37_0_0_1, XPATH2_37_0_0_2);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_37_0 = INSTANCE.getXPATH2_37_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_37_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_37_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_37 = INSTANCE.getXPATH2_37();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_37() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPredicate(), XPATH2_37_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_38_0_0_0 = INSTANCE.getXPATH2_38_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_38_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("$", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder XPATH2_38_0_0_1_0_0_0 = INSTANCE.getXPATH2_38_0_0_1_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder getXPATH2_38_0_0_1_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getVarRef().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.VAR_REF__VAR_NAME), "QNAME", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_38_0_0_1_0_0 = INSTANCE.getXPATH2_38_0_0_1_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_38_0_0_1_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_38_0_0_1_0_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder XPATH2_38_0_0_1_0_1_0 = INSTANCE.getXPATH2_38_0_0_1_0_1_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder getXPATH2_38_0_0_1_0_1_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getVarRef().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.VAR_REF__VAR_NAME), "NCNAME", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_38_0_0_1_0_1 = INSTANCE.getXPATH2_38_0_0_1_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_38_0_0_1_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_38_0_0_1_0_1_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_38_0_0_1_0 = INSTANCE.getXPATH2_38_0_0_1_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_38_0_0_1_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_38_0_0_1_0_0, XPATH2_38_0_0_1_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound XPATH2_38_0_0_1 = INSTANCE.getXPATH2_38_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound getXPATH2_38_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound(XPATH2_38_0_0_1_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_38_0_0 = INSTANCE.getXPATH2_38_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_38_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_38_0_0_0, XPATH2_38_0_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_38_0 = INSTANCE.getXPATH2_38_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_38_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_38_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_38 = INSTANCE.getXPATH2_38();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_38() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getVarRef(), XPATH2_38_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_39_0_0_0 = INSTANCE.getXPATH2_39_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_39_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("(", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_39_0_0_1 = INSTANCE.getXPATH2_39_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_39_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getParenthesizedExpr().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.PARENTHESIZED_EXPR__EXPR), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.QUESTIONMARK, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getExpr(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_39_0_0_2 = INSTANCE.getXPATH2_39_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_39_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword(")", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_39_0_0 = INSTANCE.getXPATH2_39_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_39_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_39_0_0_0, XPATH2_39_0_0_1, XPATH2_39_0_0_2);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_39_0 = INSTANCE.getXPATH2_39_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_39_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_39_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_39 = INSTANCE.getXPATH2_39();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_39() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getParenthesizedExpr(), XPATH2_39_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_40_0_0_0 = INSTANCE.getXPATH2_40_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_40_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword(".", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_40_0_0 = INSTANCE.getXPATH2_40_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_40_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_40_0_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_40_0 = INSTANCE.getXPATH2_40_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_40_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_40_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_40 = INSTANCE.getXPATH2_40();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_40() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getContextItemExpr(), XPATH2_40_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_41_0_0_0 = INSTANCE.getXPATH2_41_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_41_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getSingleType().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.SINGLE_TYPE__TYPE), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAtomicType(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2BooleanTerminal XPATH2_41_0_0_1 = INSTANCE.getXPATH2_41_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2BooleanTerminal getXPATH2_41_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2BooleanTerminal(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getSingleType().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.SINGLE_TYPE__OPTIONAL), "?", "", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_41_0_0 = INSTANCE.getXPATH2_41_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_41_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_41_0_0_0, XPATH2_41_0_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_41_0 = INSTANCE.getXPATH2_41_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_41_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_41_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_41 = INSTANCE.getXPATH2_41();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_41() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getSingleType(), XPATH2_41_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_42_0_0_0 = INSTANCE.getXPATH2_42_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_42_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("empty-sequence", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_42_0_0_1 = INSTANCE.getXPATH2_42_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_42_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("(", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_42_0_0_2 = INSTANCE.getXPATH2_42_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_42_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword(")", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_42_0_0 = INSTANCE.getXPATH2_42_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_42_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_42_0_0_0, XPATH2_42_0_0_1, XPATH2_42_0_0_2);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_42_0 = INSTANCE.getXPATH2_42_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_42_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_42_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_42 = INSTANCE.getXPATH2_42();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_42() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getEmptySequenceType(), XPATH2_42_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_43_0_0_0 = INSTANCE.getXPATH2_43_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_43_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getItemSequenceType().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ITEM_SEQUENCE_TYPE__ITEM_TYPE), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getItemType(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal XPATH2_43_0_0_1 = INSTANCE.getXPATH2_43_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal getXPATH2_43_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getItemSequenceType().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ITEM_SEQUENCE_TYPE__OCCURRENCE), new String[] {"mandatory", "", "optional", "?", "star", "*", "plus", "+", }, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_43_0_0 = INSTANCE.getXPATH2_43_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_43_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_43_0_0_0, XPATH2_43_0_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_43_0 = INSTANCE.getXPATH2_43_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_43_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_43_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_43 = INSTANCE.getXPATH2_43();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_43() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getItemSequenceType(), XPATH2_43_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_44_0_0_0 = INSTANCE.getXPATH2_44_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_44_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getItemKindTest().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ITEM_KIND_TEST__TEST), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getKindTest(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_44_0_0 = INSTANCE.getXPATH2_44_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_44_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_44_0_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_44_0 = INSTANCE.getXPATH2_44_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_44_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_44_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_44 = INSTANCE.getXPATH2_44();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_44() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getItemKindTest(), XPATH2_44_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_45_0_0_0 = INSTANCE.getXPATH2_45_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_45_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("item", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_45_0_0_1 = INSTANCE.getXPATH2_45_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_45_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("(", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_45_0_0_2 = INSTANCE.getXPATH2_45_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_45_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword(")", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_45_0_0 = INSTANCE.getXPATH2_45_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_45_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_45_0_0_0, XPATH2_45_0_0_1, XPATH2_45_0_0_2);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_45_0 = INSTANCE.getXPATH2_45_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_45_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_45_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_45 = INSTANCE.getXPATH2_45();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_45() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAnyItemType(), XPATH2_45_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_46_0_0_0 = INSTANCE.getXPATH2_46_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_46_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAtomicItemType().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ATOMIC_ITEM_TYPE__TYPE), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAtomicType(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_46_0_0 = INSTANCE.getXPATH2_46_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_46_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_46_0_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_46_0 = INSTANCE.getXPATH2_46_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_46_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_46_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_46 = INSTANCE.getXPATH2_46();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_46() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAtomicItemType(), XPATH2_46_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder XPATH2_47_0_0_0_0_0_0 = INSTANCE.getXPATH2_47_0_0_0_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder getXPATH2_47_0_0_0_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAtomicType().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ATOMIC_TYPE__NAME), "QNAME", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_47_0_0_0_0_0 = INSTANCE.getXPATH2_47_0_0_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_47_0_0_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_47_0_0_0_0_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder XPATH2_47_0_0_0_0_1_0 = INSTANCE.getXPATH2_47_0_0_0_0_1_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder getXPATH2_47_0_0_0_0_1_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAtomicType().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ATOMIC_TYPE__NAME), "NCNAME", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_47_0_0_0_0_1 = INSTANCE.getXPATH2_47_0_0_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_47_0_0_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_47_0_0_0_0_1_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_47_0_0_0_0 = INSTANCE.getXPATH2_47_0_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_47_0_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_47_0_0_0_0_0, XPATH2_47_0_0_0_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound XPATH2_47_0_0_0 = INSTANCE.getXPATH2_47_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound getXPATH2_47_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound(XPATH2_47_0_0_0_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_47_0_0 = INSTANCE.getXPATH2_47_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_47_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_47_0_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_47_0 = INSTANCE.getXPATH2_47_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_47_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_47_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_47 = INSTANCE.getXPATH2_47();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_47() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAtomicType(), XPATH2_47_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder XPATH2_48_0_0_0_0_0_0 = INSTANCE.getXPATH2_48_0_0_0_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder getXPATH2_48_0_0_0_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getOptionalAtomicType().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.OPTIONAL_ATOMIC_TYPE__NAME), "QNAME", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_48_0_0_0_0_0 = INSTANCE.getXPATH2_48_0_0_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_48_0_0_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_48_0_0_0_0_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder XPATH2_48_0_0_0_0_1_0 = INSTANCE.getXPATH2_48_0_0_0_0_1_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder getXPATH2_48_0_0_0_0_1_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getOptionalAtomicType().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.OPTIONAL_ATOMIC_TYPE__NAME), "NCNAME", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_48_0_0_0_0_1 = INSTANCE.getXPATH2_48_0_0_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_48_0_0_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_48_0_0_0_0_1_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_48_0_0_0_0 = INSTANCE.getXPATH2_48_0_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_48_0_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_48_0_0_0_0_0, XPATH2_48_0_0_0_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound XPATH2_48_0_0_0 = INSTANCE.getXPATH2_48_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound getXPATH2_48_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound(XPATH2_48_0_0_0_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2BooleanTerminal XPATH2_48_0_0_1 = INSTANCE.getXPATH2_48_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2BooleanTerminal getXPATH2_48_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2BooleanTerminal(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getOptionalAtomicType().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.OPTIONAL_ATOMIC_TYPE__OPTIONAL), "?", "", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_48_0_0 = INSTANCE.getXPATH2_48_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_48_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_48_0_0_0, XPATH2_48_0_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_48_0 = INSTANCE.getXPATH2_48_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_48_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_48_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_48 = INSTANCE.getXPATH2_48();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_48() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getOptionalAtomicType(), XPATH2_48_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_49_0_0_0 = INSTANCE.getXPATH2_49_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_49_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("node", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_49_0_0_1 = INSTANCE.getXPATH2_49_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_49_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("(", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_49_0_0_2 = INSTANCE.getXPATH2_49_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_49_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword(")", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_49_0_0 = INSTANCE.getXPATH2_49_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_49_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_49_0_0_0, XPATH2_49_0_0_1, XPATH2_49_0_0_2);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_49_0 = INSTANCE.getXPATH2_49_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_49_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_49_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_49 = INSTANCE.getXPATH2_49();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_49() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAnyKindTest(), XPATH2_49_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_50_0_0_0 = INSTANCE.getXPATH2_50_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_50_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("document-node", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_50_0_0_1 = INSTANCE.getXPATH2_50_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_50_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("(", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_50_0_0_2 = INSTANCE.getXPATH2_50_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_50_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getDocumentTest().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.DOCUMENT_TEST__TEST), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.QUESTIONMARK, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getElementTest(), org.emftext.language.xpath2.XPath2Package.eINSTANCE.getSchemaElementTest(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_50_0_0_3 = INSTANCE.getXPATH2_50_0_0_3();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_50_0_0_3() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword(")", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_50_0_0 = INSTANCE.getXPATH2_50_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_50_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_50_0_0_0, XPATH2_50_0_0_1, XPATH2_50_0_0_2, XPATH2_50_0_0_3);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_50_0 = INSTANCE.getXPATH2_50_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_50_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_50_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_50 = INSTANCE.getXPATH2_50();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_50() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getDocumentTest(), XPATH2_50_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_51_0_0_0 = INSTANCE.getXPATH2_51_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_51_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("text", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_51_0_0_1 = INSTANCE.getXPATH2_51_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_51_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("(", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_51_0_0_2 = INSTANCE.getXPATH2_51_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_51_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword(")", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_51_0_0 = INSTANCE.getXPATH2_51_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_51_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_51_0_0_0, XPATH2_51_0_0_1, XPATH2_51_0_0_2);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_51_0 = INSTANCE.getXPATH2_51_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_51_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_51_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_51 = INSTANCE.getXPATH2_51();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_51() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getTextTest(), XPATH2_51_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_52_0_0_0 = INSTANCE.getXPATH2_52_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_52_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("comment", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_52_0_0_1 = INSTANCE.getXPATH2_52_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_52_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("(", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_52_0_0_2 = INSTANCE.getXPATH2_52_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_52_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword(")", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_52_0_0 = INSTANCE.getXPATH2_52_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_52_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_52_0_0_0, XPATH2_52_0_0_1, XPATH2_52_0_0_2);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_52_0 = INSTANCE.getXPATH2_52_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_52_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_52_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_52 = INSTANCE.getXPATH2_52();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_52() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getCommentTest(), XPATH2_52_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_53_0_0_0 = INSTANCE.getXPATH2_53_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_53_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("processing-instruction", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_53_0_0_1 = INSTANCE.getXPATH2_53_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_53_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("(", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_53_0_0_2 = INSTANCE.getXPATH2_53_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_53_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword(")", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_53_0_0 = INSTANCE.getXPATH2_53_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_53_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_53_0_0_0, XPATH2_53_0_0_1, XPATH2_53_0_0_2);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_53_0 = INSTANCE.getXPATH2_53_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_53_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_53_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_53 = INSTANCE.getXPATH2_53();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_53() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPITest(), XPATH2_53_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_54_0_0_0 = INSTANCE.getXPATH2_54_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_54_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("processing-instruction", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_54_0_0_1 = INSTANCE.getXPATH2_54_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_54_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("(", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder XPATH2_54_0_0_2 = INSTANCE.getXPATH2_54_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder getXPATH2_54_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getNCNamePITest().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.NC_NAME_PI_TEST__NAME), "NCNAME", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_54_0_0_3 = INSTANCE.getXPATH2_54_0_0_3();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_54_0_0_3() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword(")", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_54_0_0 = INSTANCE.getXPATH2_54_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_54_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_54_0_0_0, XPATH2_54_0_0_1, XPATH2_54_0_0_2, XPATH2_54_0_0_3);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_54_0 = INSTANCE.getXPATH2_54_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_54_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_54_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_54 = INSTANCE.getXPATH2_54();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_54() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getNCNamePITest(), XPATH2_54_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_55_0_0_0 = INSTANCE.getXPATH2_55_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_55_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("processing-instruction", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_55_0_0_1 = INSTANCE.getXPATH2_55_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_55_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("(", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder XPATH2_55_0_0_2 = INSTANCE.getXPATH2_55_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder getXPATH2_55_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getStringLiteralPITest().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.STRING_LITERAL_PI_TEST__LITERAL), "STRING_LITERAL", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_55_0_0_3 = INSTANCE.getXPATH2_55_0_0_3();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_55_0_0_3() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword(")", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_55_0_0 = INSTANCE.getXPATH2_55_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_55_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_55_0_0_0, XPATH2_55_0_0_1, XPATH2_55_0_0_2, XPATH2_55_0_0_3);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_55_0 = INSTANCE.getXPATH2_55_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_55_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_55_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_55 = INSTANCE.getXPATH2_55();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_55() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getStringLiteralPITest(), XPATH2_55_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_56_0_0_0 = INSTANCE.getXPATH2_56_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_56_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("attribute", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_56_0_0_1 = INSTANCE.getXPATH2_56_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_56_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("(", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_56_0_0_2 = INSTANCE.getXPATH2_56_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_56_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword(")", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_56_0_0 = INSTANCE.getXPATH2_56_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_56_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_56_0_0_0, XPATH2_56_0_0_1, XPATH2_56_0_0_2);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_56_0 = INSTANCE.getXPATH2_56_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_56_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_56_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_56 = INSTANCE.getXPATH2_56();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_56() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAttributeTest(), XPATH2_56_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_57_0_0_0 = INSTANCE.getXPATH2_57_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_57_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("attribute", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_57_0_0_1 = INSTANCE.getXPATH2_57_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_57_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("(", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_57_0_0_2 = INSTANCE.getXPATH2_57_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_57_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("*", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_57_0_0_3_0_0_0 = INSTANCE.getXPATH2_57_0_0_3_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_57_0_0_3_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword(",", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_57_0_0_3_0_0_1 = INSTANCE.getXPATH2_57_0_0_3_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_57_0_0_3_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder XPATH2_57_0_0_3_0_0_2_0_0_0 = INSTANCE.getXPATH2_57_0_0_3_0_0_2_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder getXPATH2_57_0_0_3_0_0_2_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getWildcardAttributeTest().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.WILDCARD_ATTRIBUTE_TEST__TYPE), "QNAME", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_57_0_0_3_0_0_2_0_0 = INSTANCE.getXPATH2_57_0_0_3_0_0_2_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_57_0_0_3_0_0_2_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_57_0_0_3_0_0_2_0_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder XPATH2_57_0_0_3_0_0_2_0_1_0 = INSTANCE.getXPATH2_57_0_0_3_0_0_2_0_1_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder getXPATH2_57_0_0_3_0_0_2_0_1_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getWildcardAttributeTest().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.WILDCARD_ATTRIBUTE_TEST__TYPE), "NCNAME", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_57_0_0_3_0_0_2_0_1 = INSTANCE.getXPATH2_57_0_0_3_0_0_2_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_57_0_0_3_0_0_2_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_57_0_0_3_0_0_2_0_1_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_57_0_0_3_0_0_2_0 = INSTANCE.getXPATH2_57_0_0_3_0_0_2_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_57_0_0_3_0_0_2_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_57_0_0_3_0_0_2_0_0, XPATH2_57_0_0_3_0_0_2_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound XPATH2_57_0_0_3_0_0_2 = INSTANCE.getXPATH2_57_0_0_3_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound getXPATH2_57_0_0_3_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound(XPATH2_57_0_0_3_0_0_2_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_57_0_0_3_0_0 = INSTANCE.getXPATH2_57_0_0_3_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_57_0_0_3_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_57_0_0_3_0_0_0, XPATH2_57_0_0_3_0_0_1, XPATH2_57_0_0_3_0_0_2);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_57_0_0_3_0 = INSTANCE.getXPATH2_57_0_0_3_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_57_0_0_3_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_57_0_0_3_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound XPATH2_57_0_0_3 = INSTANCE.getXPATH2_57_0_0_3();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound getXPATH2_57_0_0_3() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound(XPATH2_57_0_0_3_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.QUESTIONMARK);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_57_0_0_4 = INSTANCE.getXPATH2_57_0_0_4();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_57_0_0_4() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword(")", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_57_0_0 = INSTANCE.getXPATH2_57_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_57_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_57_0_0_0, XPATH2_57_0_0_1, XPATH2_57_0_0_2, XPATH2_57_0_0_3, XPATH2_57_0_0_4);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_57_0 = INSTANCE.getXPATH2_57_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_57_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_57_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_57 = INSTANCE.getXPATH2_57();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_57() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getWildcardAttributeTest(), XPATH2_57_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_58_0_0_0 = INSTANCE.getXPATH2_58_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_58_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("attribute", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_58_0_0_1 = INSTANCE.getXPATH2_58_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_58_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("(", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder XPATH2_58_0_0_2_0_0_0 = INSTANCE.getXPATH2_58_0_0_2_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder getXPATH2_58_0_0_2_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getNameAttributeTest().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.NAME_ATTRIBUTE_TEST__NAME), "QNAME", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_58_0_0_2_0_0 = INSTANCE.getXPATH2_58_0_0_2_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_58_0_0_2_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_58_0_0_2_0_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder XPATH2_58_0_0_2_0_1_0 = INSTANCE.getXPATH2_58_0_0_2_0_1_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder getXPATH2_58_0_0_2_0_1_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getNameAttributeTest().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.NAME_ATTRIBUTE_TEST__NAME), "NCNAME", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_58_0_0_2_0_1 = INSTANCE.getXPATH2_58_0_0_2_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_58_0_0_2_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_58_0_0_2_0_1_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_58_0_0_2_0 = INSTANCE.getXPATH2_58_0_0_2_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_58_0_0_2_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_58_0_0_2_0_0, XPATH2_58_0_0_2_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound XPATH2_58_0_0_2 = INSTANCE.getXPATH2_58_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound getXPATH2_58_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound(XPATH2_58_0_0_2_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_58_0_0_3_0_0_0 = INSTANCE.getXPATH2_58_0_0_3_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_58_0_0_3_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword(",", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_58_0_0_3_0_0_1 = INSTANCE.getXPATH2_58_0_0_3_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_58_0_0_3_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder XPATH2_58_0_0_3_0_0_2_0_0_0 = INSTANCE.getXPATH2_58_0_0_3_0_0_2_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder getXPATH2_58_0_0_3_0_0_2_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getNameAttributeTest().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.NAME_ATTRIBUTE_TEST__TYPE), "QNAME", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_58_0_0_3_0_0_2_0_0 = INSTANCE.getXPATH2_58_0_0_3_0_0_2_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_58_0_0_3_0_0_2_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_58_0_0_3_0_0_2_0_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder XPATH2_58_0_0_3_0_0_2_0_1_0 = INSTANCE.getXPATH2_58_0_0_3_0_0_2_0_1_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder getXPATH2_58_0_0_3_0_0_2_0_1_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getNameAttributeTest().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.NAME_ATTRIBUTE_TEST__TYPE), "NCNAME", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_58_0_0_3_0_0_2_0_1 = INSTANCE.getXPATH2_58_0_0_3_0_0_2_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_58_0_0_3_0_0_2_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_58_0_0_3_0_0_2_0_1_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_58_0_0_3_0_0_2_0 = INSTANCE.getXPATH2_58_0_0_3_0_0_2_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_58_0_0_3_0_0_2_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_58_0_0_3_0_0_2_0_0, XPATH2_58_0_0_3_0_0_2_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound XPATH2_58_0_0_3_0_0_2 = INSTANCE.getXPATH2_58_0_0_3_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound getXPATH2_58_0_0_3_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound(XPATH2_58_0_0_3_0_0_2_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_58_0_0_3_0_0 = INSTANCE.getXPATH2_58_0_0_3_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_58_0_0_3_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_58_0_0_3_0_0_0, XPATH2_58_0_0_3_0_0_1, XPATH2_58_0_0_3_0_0_2);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_58_0_0_3_0 = INSTANCE.getXPATH2_58_0_0_3_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_58_0_0_3_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_58_0_0_3_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound XPATH2_58_0_0_3 = INSTANCE.getXPATH2_58_0_0_3();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound getXPATH2_58_0_0_3() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound(XPATH2_58_0_0_3_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.QUESTIONMARK);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_58_0_0_4 = INSTANCE.getXPATH2_58_0_0_4();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_58_0_0_4() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword(")", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_58_0_0 = INSTANCE.getXPATH2_58_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_58_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_58_0_0_0, XPATH2_58_0_0_1, XPATH2_58_0_0_2, XPATH2_58_0_0_3, XPATH2_58_0_0_4);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_58_0 = INSTANCE.getXPATH2_58_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_58_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_58_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_58 = INSTANCE.getXPATH2_58();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_58() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getNameAttributeTest(), XPATH2_58_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_59_0_0_0 = INSTANCE.getXPATH2_59_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_59_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("schema-attribute", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_59_0_0_1 = INSTANCE.getXPATH2_59_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_59_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("(", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder XPATH2_59_0_0_2_0_0_0 = INSTANCE.getXPATH2_59_0_0_2_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder getXPATH2_59_0_0_2_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getSchemaAttributeTest().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.SCHEMA_ATTRIBUTE_TEST__NAME), "QNAME", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_59_0_0_2_0_0 = INSTANCE.getXPATH2_59_0_0_2_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_59_0_0_2_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_59_0_0_2_0_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder XPATH2_59_0_0_2_0_1_0 = INSTANCE.getXPATH2_59_0_0_2_0_1_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder getXPATH2_59_0_0_2_0_1_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getSchemaAttributeTest().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.SCHEMA_ATTRIBUTE_TEST__NAME), "NCNAME", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_59_0_0_2_0_1 = INSTANCE.getXPATH2_59_0_0_2_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_59_0_0_2_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_59_0_0_2_0_1_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_59_0_0_2_0 = INSTANCE.getXPATH2_59_0_0_2_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_59_0_0_2_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_59_0_0_2_0_0, XPATH2_59_0_0_2_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound XPATH2_59_0_0_2 = INSTANCE.getXPATH2_59_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound getXPATH2_59_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound(XPATH2_59_0_0_2_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_59_0_0_3 = INSTANCE.getXPATH2_59_0_0_3();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_59_0_0_3() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword(")", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_59_0_0 = INSTANCE.getXPATH2_59_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_59_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_59_0_0_0, XPATH2_59_0_0_1, XPATH2_59_0_0_2, XPATH2_59_0_0_3);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_59_0 = INSTANCE.getXPATH2_59_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_59_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_59_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_59 = INSTANCE.getXPATH2_59();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_59() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getSchemaAttributeTest(), XPATH2_59_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_60_0_0_0 = INSTANCE.getXPATH2_60_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_60_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("element", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_60_0_0_1 = INSTANCE.getXPATH2_60_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_60_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("(", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_60_0_0_2 = INSTANCE.getXPATH2_60_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_60_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword(")", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_60_0_0 = INSTANCE.getXPATH2_60_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_60_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_60_0_0_0, XPATH2_60_0_0_1, XPATH2_60_0_0_2);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_60_0 = INSTANCE.getXPATH2_60_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_60_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_60_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_60 = INSTANCE.getXPATH2_60();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_60() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getElementTest(), XPATH2_60_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_61_0_0_0 = INSTANCE.getXPATH2_61_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_61_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("element", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_61_0_0_1 = INSTANCE.getXPATH2_61_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_61_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("(", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_61_0_0_2 = INSTANCE.getXPATH2_61_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_61_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("*", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_61_0_0_3_0_0_0 = INSTANCE.getXPATH2_61_0_0_3_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_61_0_0_3_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword(",", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_61_0_0_3_0_0_1 = INSTANCE.getXPATH2_61_0_0_3_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_61_0_0_3_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_61_0_0_3_0_0_2 = INSTANCE.getXPATH2_61_0_0_3_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_61_0_0_3_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getWildcardElementTest().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.WILDCARD_ELEMENT_TEST__TYPE), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getOptionalAtomicType(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_61_0_0_3_0_0 = INSTANCE.getXPATH2_61_0_0_3_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_61_0_0_3_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_61_0_0_3_0_0_0, XPATH2_61_0_0_3_0_0_1, XPATH2_61_0_0_3_0_0_2);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_61_0_0_3_0 = INSTANCE.getXPATH2_61_0_0_3_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_61_0_0_3_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_61_0_0_3_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound XPATH2_61_0_0_3 = INSTANCE.getXPATH2_61_0_0_3();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound getXPATH2_61_0_0_3() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound(XPATH2_61_0_0_3_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.QUESTIONMARK);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_61_0_0_4 = INSTANCE.getXPATH2_61_0_0_4();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_61_0_0_4() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword(")", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_61_0_0 = INSTANCE.getXPATH2_61_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_61_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_61_0_0_0, XPATH2_61_0_0_1, XPATH2_61_0_0_2, XPATH2_61_0_0_3, XPATH2_61_0_0_4);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_61_0 = INSTANCE.getXPATH2_61_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_61_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_61_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_61 = INSTANCE.getXPATH2_61();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_61() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getWildcardElementTest(), XPATH2_61_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_62_0_0_0 = INSTANCE.getXPATH2_62_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_62_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("element", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_62_0_0_1 = INSTANCE.getXPATH2_62_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_62_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("(", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder XPATH2_62_0_0_2_0_0_0 = INSTANCE.getXPATH2_62_0_0_2_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder getXPATH2_62_0_0_2_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getNameElementTest().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.NAME_ELEMENT_TEST__NAME), "QNAME", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_62_0_0_2_0_0 = INSTANCE.getXPATH2_62_0_0_2_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_62_0_0_2_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_62_0_0_2_0_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder XPATH2_62_0_0_2_0_1_0 = INSTANCE.getXPATH2_62_0_0_2_0_1_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder getXPATH2_62_0_0_2_0_1_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getNameElementTest().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.NAME_ELEMENT_TEST__NAME), "NCNAME", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_62_0_0_2_0_1 = INSTANCE.getXPATH2_62_0_0_2_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_62_0_0_2_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_62_0_0_2_0_1_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_62_0_0_2_0 = INSTANCE.getXPATH2_62_0_0_2_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_62_0_0_2_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_62_0_0_2_0_0, XPATH2_62_0_0_2_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound XPATH2_62_0_0_2 = INSTANCE.getXPATH2_62_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound getXPATH2_62_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound(XPATH2_62_0_0_2_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_62_0_0_3_0_0_0 = INSTANCE.getXPATH2_62_0_0_3_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_62_0_0_3_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword(",", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace XPATH2_62_0_0_3_0_0_1 = INSTANCE.getXPATH2_62_0_0_3_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace getXPATH2_62_0_0_3_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2WhiteSpace(1, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment XPATH2_62_0_0_3_0_0_2 = INSTANCE.getXPATH2_62_0_0_3_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment getXPATH2_62_0_0_3_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Containment(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getNameElementTest().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.NAME_ELEMENT_TEST__TYPE), org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, new EClass[] {org.emftext.language.xpath2.XPath2Package.eINSTANCE.getOptionalAtomicType(), }, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_62_0_0_3_0_0 = INSTANCE.getXPATH2_62_0_0_3_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_62_0_0_3_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_62_0_0_3_0_0_0, XPATH2_62_0_0_3_0_0_1, XPATH2_62_0_0_3_0_0_2);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_62_0_0_3_0 = INSTANCE.getXPATH2_62_0_0_3_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_62_0_0_3_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_62_0_0_3_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound XPATH2_62_0_0_3 = INSTANCE.getXPATH2_62_0_0_3();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound getXPATH2_62_0_0_3() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound(XPATH2_62_0_0_3_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.QUESTIONMARK);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_62_0_0_4 = INSTANCE.getXPATH2_62_0_0_4();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_62_0_0_4() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword(")", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_62_0_0 = INSTANCE.getXPATH2_62_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_62_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_62_0_0_0, XPATH2_62_0_0_1, XPATH2_62_0_0_2, XPATH2_62_0_0_3, XPATH2_62_0_0_4);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_62_0 = INSTANCE.getXPATH2_62_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_62_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_62_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_62 = INSTANCE.getXPATH2_62();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_62() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getNameElementTest(), XPATH2_62_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_63_0_0_0 = INSTANCE.getXPATH2_63_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_63_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("schema-element", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_63_0_0_1 = INSTANCE.getXPATH2_63_0_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_63_0_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword("(", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder XPATH2_63_0_0_2_0_0_0 = INSTANCE.getXPATH2_63_0_0_2_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder getXPATH2_63_0_0_2_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getSchemaElementTest().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.SCHEMA_ELEMENT_TEST__NAME), "QNAME", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_63_0_0_2_0_0 = INSTANCE.getXPATH2_63_0_0_2_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_63_0_0_2_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_63_0_0_2_0_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder XPATH2_63_0_0_2_0_1_0 = INSTANCE.getXPATH2_63_0_0_2_0_1_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder getXPATH2_63_0_0_2_0_1_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getSchemaElementTest().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.SCHEMA_ELEMENT_TEST__NAME), "NCNAME", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_63_0_0_2_0_1 = INSTANCE.getXPATH2_63_0_0_2_0_1();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_63_0_0_2_0_1() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_63_0_0_2_0_1_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_63_0_0_2_0 = INSTANCE.getXPATH2_63_0_0_2_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_63_0_0_2_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_63_0_0_2_0_0, XPATH2_63_0_0_2_0_1);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound XPATH2_63_0_0_2 = INSTANCE.getXPATH2_63_0_0_2();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound getXPATH2_63_0_0_2() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Compound(XPATH2_63_0_0_2_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword XPATH2_63_0_0_3 = INSTANCE.getXPATH2_63_0_0_3();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword getXPATH2_63_0_0_3() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword(")", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_63_0_0 = INSTANCE.getXPATH2_63_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_63_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_63_0_0_0, XPATH2_63_0_0_1, XPATH2_63_0_0_2, XPATH2_63_0_0_3);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_63_0 = INSTANCE.getXPATH2_63_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_63_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_63_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_63 = INSTANCE.getXPATH2_63();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_63() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getSchemaElementTest(), XPATH2_63_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder XPATH2_64_0_0_0 = INSTANCE.getXPATH2_64_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder getXPATH2_64_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIntegerLiteral().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.INTEGER_LITERAL__VALUE), "INTEGER_LITERAL", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_64_0_0 = INSTANCE.getXPATH2_64_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_64_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_64_0_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_64_0 = INSTANCE.getXPATH2_64_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_64_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_64_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_64 = INSTANCE.getXPATH2_64();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_64() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIntegerLiteral(), XPATH2_64_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder XPATH2_65_0_0_0 = INSTANCE.getXPATH2_65_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder getXPATH2_65_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getDecimalLiteral().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.DECIMAL_LITERAL__VALUE), "DECIMAL_LITERAL", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_65_0_0 = INSTANCE.getXPATH2_65_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_65_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_65_0_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_65_0 = INSTANCE.getXPATH2_65_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_65_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_65_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_65 = INSTANCE.getXPATH2_65();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_65() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getDecimalLiteral(), XPATH2_65_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder XPATH2_66_0_0_0 = INSTANCE.getXPATH2_66_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder getXPATH2_66_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getDoubleLiteral().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.DOUBLE_LITERAL__VALUE), "DOUBLE_LITERAL", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_66_0_0 = INSTANCE.getXPATH2_66_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_66_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_66_0_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_66_0 = INSTANCE.getXPATH2_66_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_66_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_66_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_66 = INSTANCE.getXPATH2_66();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_66() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getDoubleLiteral(), XPATH2_66_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder XPATH2_67_0_0_0 = INSTANCE.getXPATH2_67_0_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder getXPATH2_67_0_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Placeholder(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getStringLiteral().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.STRING_LITERAL__VALUE), "STRING_LITERAL", org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, 0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence XPATH2_67_0_0 = INSTANCE.getXPATH2_67_0_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence getXPATH2_67_0_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Sequence(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_67_0_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice XPATH2_67_0 = INSTANCE.getXPATH2_67_0();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice getXPATH2_67_0() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Choice(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE, XPATH2_67_0_0);
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule XPATH2_67 = INSTANCE.getXPATH2_67();
	private org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule getXPATH2_67() {
		return new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getStringLiteral(), XPATH2_67_0, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Cardinality.ONE);
	}
	
	
	public static String getSyntaxElementID(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2SyntaxElement syntaxElement) {
		if (syntaxElement == null) {
			// null indicates EOF
			return "<EOF>";
		}
		for (Field field : org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.class.getFields()) {
			Object fieldValue;
			try {
				fieldValue = field.get(null);
				if (fieldValue == syntaxElement) {
					String id = field.getName();
					return id;
				}
			} catch (Exception e) { }
		}
		return null;
	}
	
	public static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2SyntaxElement getSyntaxElementByID(String syntaxElementID) {
		try {
			return (org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2SyntaxElement) org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.class.getField(syntaxElementID).get(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	public final static org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule[] RULES = new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule[] {
		XPATH2_0,
		XPATH2_1,
		XPATH2_2,
		XPATH2_3,
		XPATH2_4,
		XPATH2_5,
		XPATH2_6,
		XPATH2_7,
		XPATH2_8,
		XPATH2_9,
		XPATH2_10,
		XPATH2_11,
		XPATH2_12,
		XPATH2_13,
		XPATH2_14,
		XPATH2_15,
		XPATH2_16,
		XPATH2_17,
		XPATH2_18,
		XPATH2_19,
		XPATH2_20,
		XPATH2_21,
		XPATH2_22,
		XPATH2_23,
		XPATH2_24,
		XPATH2_25,
		XPATH2_26,
		XPATH2_27,
		XPATH2_28,
		XPATH2_29,
		XPATH2_30,
		XPATH2_31,
		XPATH2_32,
		XPATH2_33,
		XPATH2_34,
		XPATH2_35,
		XPATH2_36,
		XPATH2_37,
		XPATH2_38,
		XPATH2_39,
		XPATH2_40,
		XPATH2_41,
		XPATH2_42,
		XPATH2_43,
		XPATH2_44,
		XPATH2_45,
		XPATH2_46,
		XPATH2_47,
		XPATH2_48,
		XPATH2_49,
		XPATH2_50,
		XPATH2_51,
		XPATH2_52,
		XPATH2_53,
		XPATH2_54,
		XPATH2_55,
		XPATH2_56,
		XPATH2_57,
		XPATH2_58,
		XPATH2_59,
		XPATH2_60,
		XPATH2_61,
		XPATH2_62,
		XPATH2_63,
		XPATH2_64,
		XPATH2_65,
		XPATH2_66,
		XPATH2_67,
	};
	
	/**
	 * Returns all keywords of the grammar. This includes all literals for boolean and
	 * enumeration terminals.
	 */
	public Set<String> getKeywords() {
		if (this.keywords == null) {
			this.keywords = new LinkedHashSet<String>();
			for (org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Rule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2SyntaxElement element, Set<String> keywords) {
		if (element instanceof org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword) {
			keywords.add(((org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2Keyword) element).getValue());
		} else if (element instanceof org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2BooleanTerminal) {
			keywords.add(((org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2BooleanTerminal) element).getTrueLiteral());
			keywords.add(((org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2BooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal) {
			org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal terminal = (org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2SyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}
