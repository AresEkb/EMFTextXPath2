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

import org.eclipse.emf.ecore.EClass;

public class Xpath2SyntaxCoverageInformationProvider {
	
	public EClass[] getClassesWithSyntax() {
		return new EClass[] {
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getExpr(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getForExpr(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getQuantifiedExpr(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIterator(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIfExpr(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getOrExpr(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAndExpr(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getRangeExpr(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralComp(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getValueComp(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getNodeComp(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAdditiveExpr(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getMultiplicativeExpr(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getUnionExpr(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIntersectExceptExpr(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getInstanceofExpr(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getTreatExpr(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getCastableExpr(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getCastExpr(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getUnaryExpr(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getFilterExpr(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getFunctionCall(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getChildStepExpr(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getDescOrSelfStepExpr(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getRootStepExpr(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getSelfStepExpr(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralForwardStep(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevForwardStep(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralReverseStep(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevReverseStep(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getNodeKindTest(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getQNameTest(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAnyWildcard(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getLocalNameWildcard(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getNamespaceWildcard(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPredicate(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getVarRef(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getParenthesizedExpr(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getContextItemExpr(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getSingleType(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getEmptySequenceType(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getItemSequenceType(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getItemKindTest(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAnyItemType(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAtomicItemType(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAtomicType(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getOptionalAtomicType(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAnyKindTest(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getDocumentTest(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getTextTest(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getCommentTest(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPITest(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getNCNamePITest(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getStringLiteralPITest(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAttributeTest(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getWildcardAttributeTest(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getNameAttributeTest(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getSchemaAttributeTest(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getElementTest(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getWildcardElementTest(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getNameElementTest(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getSchemaElementTest(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIntegerLiteral(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getDecimalLiteral(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getDoubleLiteral(),
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getStringLiteral(),
		};
	}
	
	public EClass[] getStartSymbols() {
		return new EClass[] {
			org.emftext.language.xpath2.XPath2Package.eINSTANCE.getExpr(),
		};
	}
	
}
