/**
 * Copyright (c) 2013 Denis Nikiforov.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Denis Nikiforov - initial API and implementation
 */
package org.emftext.language.xpath2.resource.xpath2.mopp;

public class Xpath2SyntaxCoverageInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getForExpr(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQuantifiedExpr(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIterator(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIfExpr(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOrExpr(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAndExpr(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getComparisonExpr(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRangeExpr(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralComp(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getValueComp(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNodeComp(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAdditiveExpr(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getMultiplicativeExpr(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnionExpr(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIntersectExceptExpr(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getInstanceofExpr(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getTreatExpr(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getCastableExpr(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getCastExpr(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getUnaryExpr(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFilterExpr(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getFunctionCall(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPathExpr(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getChildStepExpr(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDescOrSelfStepExpr(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getRootStepExpr(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSelfStepExpr(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralForwardStep(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevForwardStep(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getGeneralReverseStep(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAbbrevReverseStep(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNodeKindTest(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQNameTest(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAnyWildcard(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getLocalNameWildcard(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNamespaceWildcard(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPredicate(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getVarRef(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getVarName(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getParenthesizedExpr(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getContextItemExpr(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSingleType(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getEmptySequenceType(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getItemSequenceType(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getItemKindTest(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAnyItemType(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAtomicItemType(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAtomicType(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getOptionalAtomicType(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAnyKindTest(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDocumentTest(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getTextTest(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getCommentTest(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getPITest(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNCNamePITest(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getStringLiteralPITest(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getAttributeTest(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getWildcardAttributeTest(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameAttributeTest(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSchemaAttributeTest(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getElementTest(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getWildcardElementTest(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getNameElementTest(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getSchemaElementTest(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getIntegerLiteral(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDecimalLiteral(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getDoubleLiteral(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getStringLiteral(),
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getQName(),
		};
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.emftext.language.xpath2.Xpath2Package.eINSTANCE.getExpr(),
		};
	}
	
}
