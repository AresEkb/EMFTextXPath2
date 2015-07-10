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
package org.emftext.language.xpath2.resource.xpath2.ui;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * A CodeCompletionHelper can be used to derive completion proposals for partial
 * documents. It runs the parser generated by EMFText in a special mode (i.e., the
 * rememberExpectedElements mode). Based on the elements that are expected by the
 * parser for different regions in the document, valid proposals are computed.
 */
public class Xpath2CodeCompletionHelper {
	
	private org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2AttributeValueProvider attributeValueProvider = new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2AttributeValueProvider();
	
	private org.emftext.language.xpath2.resource.xpath2.IXpath2MetaInformation metaInformation = new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2MetaInformation();
	
	/**
	 * <p>
	 * Computes a set of proposals for the given document assuming the cursor is at
	 * 'cursorOffset'. The proposals are derived using the meta information, i.e., the
	 * generated language plug-in.
	 * </p>
	 * 
	 * @param originalResource the resource to compute completions for
	 * @param content the documents content
	 * @param cursorOffset the current offset of the cursor
	 * 
	 * @return an array of completion proposals
	 */
	public org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal[] computeCompletionProposals(org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource originalResource, String content, int cursorOffset) {
		ResourceSet resourceSet = new ResourceSetImpl();
		// the shadow resource needs the same URI because reference resolvers may use the
		// URI to resolve external references
		org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource resource = (org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource) resourceSet.createResource(originalResource.getURI());
		ByteArrayInputStream inputStream = new ByteArrayInputStream(content.getBytes());
		org.emftext.language.xpath2.resource.xpath2.IXpath2MetaInformation metaInformation = resource.getMetaInformation();
		org.emftext.language.xpath2.resource.xpath2.IXpath2TextParser parser = metaInformation.createParser(inputStream, null);
		org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal[] expectedElements = parseToExpectedElements(parser, resource, cursorOffset);
		if (expectedElements == null) {
			return new org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal[0];
		}
		if (expectedElements.length == 0) {
			return new org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal[0];
		}
		List<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal> expectedAfterCursor = Arrays.asList(getElementsExpectedAt(expectedElements, cursorOffset));
		List<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal> expectedBeforeCursor = Arrays.asList(getElementsExpectedAt(expectedElements, cursorOffset - 1));
		setPrefixes(expectedAfterCursor, content, cursorOffset);
		setPrefixes(expectedBeforeCursor, content, cursorOffset);
		
		// First, we derive all possible proposals from the set of elements that are
		// expected at the cursor position.
		Collection<org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal> allProposals = new LinkedHashSet<org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal>();
		Collection<org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal> rightProposals = deriveProposals(expectedAfterCursor, content, resource, cursorOffset);
		Collection<org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal> leftProposals = deriveProposals(expectedBeforeCursor, content, resource, cursorOffset - 1);
		removeKeywordsEndingBeforeIndex(leftProposals, cursorOffset);
		
		// Second, the set of left proposals (i.e., the ones before the cursor) is checked
		// for emptiness. If the set is empty, the right proposals (i.e., the ones after
		// the cursor) are also considered. If the set is not empty, the right proposal
		// are discarded, because it does not make sense to propose them until the element
		// before the cursor was completed.
		allProposals.addAll(leftProposals);
		// Count the proposals before the cursor that match the prefix
		int leftMatchingProposals = 0;
		for (org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal leftProposal : leftProposals) {
			if (leftProposal.isMatchesPrefix()) {
				leftMatchingProposals++;
			}
		}
		if (leftMatchingProposals == 0) {
			allProposals.addAll(rightProposals);
		}
		
		// Third, the proposals are sorted according to their relevance. Proposals that
		// matched the prefix are preferred over ones that did not. Finally, proposals are
		// sorted alphabetically.
		final List<org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal> sortedProposals = new ArrayList<org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal>(allProposals);
		Collections.sort(sortedProposals);
		EObject root = null;
		if (!resource.getContents().isEmpty()) {
			root = resource.getContents().get(0);
		}
		for (org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal proposal : sortedProposals) {
			proposal.setRoot(root);
		}
		
		return sortedProposals.toArray(new org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal[sortedProposals.size()]);
	}
	
	public org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal[] parseToExpectedElements(org.emftext.language.xpath2.resource.xpath2.IXpath2TextParser parser, org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource resource, int cursorOffset) {
		final List<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal> expectedElements = parser.parseToExpectedElements(null, resource, cursorOffset);
		if (expectedElements == null) {
			return new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal[0];
		}
		removeDuplicateEntries(expectedElements);
		removeInvalidEntriesAtEnd(expectedElements);
		return expectedElements.toArray(new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal[expectedElements.size()]);
	}
	
	/**
	 * Removes all expected elements that refer to the same terminal and that start at
	 * the same position.
	 */
	protected void removeDuplicateEntries(List<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal> expectedElements) {
		int size = expectedElements.size();
		// We split the list of expected elements into buckets where each bucket contains
		// the elements that start at the same position.
		Map<Integer, List<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal>> map = new LinkedHashMap<Integer, List<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal>>();
		for (int i = 0; i < size; i++) {
			org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal elementAtIndex = expectedElements.get(i);
			int start1 = elementAtIndex.getStartExcludingHiddenTokens();
			List<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal> list = map.get(start1);
			if (list == null) {
				list = new ArrayList<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal>();
				map.put(start1, list);
			}
			list.add(elementAtIndex);
		}
		
		// Then, we remove all duplicate elements from each bucket individually.
		for (int position : map.keySet()) {
			List<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal> list = map.get(position);
			removeDuplicateEntriesFromBucket(list);
		}
		
		// After removing all duplicates, we merge the buckets.
		expectedElements.clear();
		for (int position : map.keySet()) {
			List<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal> list = map.get(position);
			expectedElements.addAll(list);
		}
	}
	
	/**
	 * Removes all expected elements that refer to the same terminal. Attention: This
	 * method assumes that the given list of expected terminals contains only elements
	 * that start at the same position.
	 */
	protected void removeDuplicateEntriesFromBucket(List<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal> expectedElements) {
		int size = expectedElements.size();
		for (int i = 0; i < size - 1; i++) {
			org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal elementAtIndex = expectedElements.get(i);
			org.emftext.language.xpath2.resource.xpath2.IXpath2ExpectedElement terminal = elementAtIndex.getTerminal();
			for (int j = i + 1; j < size;) {
				org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal elementAtNext = expectedElements.get(j);
				if (terminal.equals(elementAtNext.getTerminal())) {
					expectedElements.remove(j);
					size--;
				} else {
					j++;
				}
			}
		}
	}
	
	protected void removeInvalidEntriesAtEnd(List<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal> expectedElements) {
		for (int i = 0; i < expectedElements.size() - 1;) {
			org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal elementAtIndex = expectedElements.get(i);
			org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal elementAtNext = expectedElements.get(i + 1);
			
			// If the two expected elements have a different parent in the syntax definition,
			// we must not discard the second element, because it probably stems from a parent
			// rule.
			org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2SyntaxElement symtaxElementOfThis = elementAtIndex.getTerminal().getSymtaxElement();
			org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2SyntaxElement symtaxElementOfNext = elementAtNext.getTerminal().getSymtaxElement();
			boolean differentParent = symtaxElementOfNext.getParent() != symtaxElementOfThis.getParent();
			
			boolean sameStartExcludingHiddenTokens = elementAtIndex.getStartExcludingHiddenTokens() == elementAtNext.getStartExcludingHiddenTokens();
			boolean differentFollowSet = elementAtIndex.getFollowSetID() != elementAtNext.getFollowSetID();
			if (sameStartExcludingHiddenTokens && differentFollowSet && !differentParent) {
				expectedElements.remove(i + 1);
			} else {
				i++;
			}
		}
	}
	
	/**
	 * Removes all proposals for keywords that end before the given index.
	 */
	protected void removeKeywordsEndingBeforeIndex(Collection<org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal> proposals, int index) {
		List<org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal> toRemove = new ArrayList<org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal>();
		for (org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal proposal : proposals) {
			org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal expectedTerminal = proposal.getExpectedTerminal();
			org.emftext.language.xpath2.resource.xpath2.IXpath2ExpectedElement terminal = expectedTerminal.getTerminal();
			if (terminal instanceof org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedCsString) {
				org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedCsString csString = (org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedCsString) terminal;
				int startExcludingHiddenTokens = expectedTerminal.getStartExcludingHiddenTokens();
				if (startExcludingHiddenTokens + csString.getValue().length() - 1 < index) {
					toRemove.add(proposal);
				}
			}
		}
		proposals.removeAll(toRemove);
	}
	
	protected String findPrefix(List<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal> expectedElements, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal expectedAtCursor, String content, int cursorOffset) {
		if (cursorOffset < 0) {
			return "";
		}
		
		int end = 0;
		for (org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal expectedElement : expectedElements) {
			if (expectedElement == expectedAtCursor) {
				final int start = expectedElement.getStartExcludingHiddenTokens();
				if (start >= 0  && start < Integer.MAX_VALUE) {
					end = start;
				}
				break;
			}
		}
		end = Math.min(end, cursorOffset);
		final String prefix = content.substring(end, Math.min(content.length(), cursorOffset));
		return prefix;
	}
	
	protected Collection<org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal> deriveProposals(List<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal> expectedElements, String content, org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource resource, int cursorOffset) {
		Collection<org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal> resultSet = new LinkedHashSet<org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal>();
		for (org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal expectedElement : expectedElements) {
			resultSet.addAll(deriveProposals(expectedElement, content, resource, cursorOffset));
		}
		return resultSet;
	}
	
	protected Collection<org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal> deriveProposals(final org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal expectedTerminal, String content, org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource resource, int cursorOffset) {
		org.emftext.language.xpath2.resource.xpath2.IXpath2ExpectedElement expectedElement = (org.emftext.language.xpath2.resource.xpath2.IXpath2ExpectedElement) expectedTerminal.getTerminal();
		if (expectedElement instanceof org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedCsString) {
			org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedCsString csString = (org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedCsString) expectedElement;
			return handleKeyword(expectedTerminal, csString, expectedTerminal.getPrefix(), expectedTerminal.getContainer());
		} else if (expectedElement instanceof org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedBooleanTerminal) {
			org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedBooleanTerminal expectedBooleanTerminal = (org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedBooleanTerminal) expectedElement;
			return handleBooleanTerminal(expectedTerminal, expectedBooleanTerminal, expectedTerminal.getPrefix());
		} else if (expectedElement instanceof org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedEnumerationTerminal) {
			org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedEnumerationTerminal expectedEnumerationTerminal = (org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedEnumerationTerminal) expectedElement;
			return handleEnumerationTerminal(expectedTerminal, expectedEnumerationTerminal, expectedTerminal.getPrefix());
		} else if (expectedElement instanceof org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedStructuralFeature) {
			final org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedStructuralFeature expectedFeature = (org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedStructuralFeature) expectedElement;
			final EStructuralFeature feature = expectedFeature.getFeature();
			final EClassifier featureType = feature.getEType();
			final EObject container = findCorrectContainer(expectedTerminal);
			
			// Here it gets really crazy. We need to modify the model in a way that reflects
			// the state the model would be in, if the expected terminal were present. After
			// computing the corresponding completion proposals, the original state of the
			// model is restored. This procedure is required, because different models can be
			// required for different completion situations. This can be particularly observed
			// when the user has not yet typed a character that starts an element to be
			// completed.
			final Collection<org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal> proposals = new ArrayList<org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal>();
			expectedTerminal.materialize(new Runnable() {
				
				public void run() {
					if (feature instanceof EReference) {
						EReference reference = (EReference) feature;
						if (featureType instanceof EClass) {
							if (reference.isContainment()) {
								// the FOLLOW set should contain only non-containment references
								assert false;
							} else {
								proposals.addAll(handleNCReference(expectedTerminal, container, reference, expectedTerminal.getPrefix(), expectedFeature.getTokenName()));
							}
						}
					} else if (feature instanceof EAttribute) {
						EAttribute attribute = (EAttribute) feature;
						if (featureType instanceof EEnum) {
							EEnum enumType = (EEnum) featureType;
							proposals.addAll(handleEnumAttribute(expectedTerminal, expectedFeature, enumType, expectedTerminal.getPrefix(), container));
						} else {
							// handle EAttributes (derive default value depending on the type of the
							// attribute, figure out token resolver, and call deResolve())
							proposals.addAll(handleAttribute(expectedTerminal, expectedFeature, container, attribute, expectedTerminal.getPrefix()));
						}
					} else {
						// there should be no other subclass of EStructuralFeature
						assert false;
					}
				}
			});
			// Return the proposals that were computed in the closure call.
			return proposals;
		} else {
			// there should be no other class implementing IExpectedElement
			assert false;
		}
		return Collections.emptyList();
	}
	
	protected Collection<org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal> handleEnumAttribute(org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal expectedTerminal, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedStructuralFeature expectedFeature, EEnum enumType, String prefix, EObject container) {
		Collection<EEnumLiteral> enumLiterals = enumType.getELiterals();
		Collection<org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal> result = new LinkedHashSet<org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal>();
		for (EEnumLiteral literal : enumLiterals) {
			String unResolvedLiteral = literal.getLiteral();
			// use token resolver to get de-resolved value of the literal
			org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolverFactory tokenResolverFactory = metaInformation.getTokenResolverFactory();
			org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver(expectedFeature.getTokenName());
			String resolvedLiteral = tokenResolver.deResolve(unResolvedLiteral, expectedFeature.getFeature(), container);
			boolean matchesPrefix = matches(resolvedLiteral, prefix);
			result.add(new org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal(expectedTerminal, resolvedLiteral, prefix, matchesPrefix, expectedFeature.getFeature(), container));
		}
		return result;
	}
	
	protected Collection<org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal> handleNCReference(org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal expectedTerminal, EObject container, EReference reference, String prefix, String tokenName) {
		// proposals for non-containment references are derived by calling the reference
		// resolver switch in fuzzy mode.
		org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceResolverSwitch resolverSwitch = metaInformation.getReferenceResolverSwitch();
		org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolverFactory tokenResolverFactory = metaInformation.getTokenResolverFactory();
		org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceResolveResult<EObject> result = new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ReferenceResolveResult<EObject>(true);
		resolverSwitch.resolveFuzzy(prefix, container, reference, 0, result);
		Collection<org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceMapping<EObject>> mappings = result.getMappings();
		if (mappings != null) {
			Collection<org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal> resultSet = new LinkedHashSet<org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal>();
			for (org.emftext.language.xpath2.resource.xpath2.IXpath2ReferenceMapping<EObject> mapping : mappings) {
				Image image = null;
				if (mapping instanceof org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ElementMapping<?>) {
					org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ElementMapping<?> elementMapping = (org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ElementMapping<?>) mapping;
					Object target = elementMapping.getTargetElement();
					// de-resolve reference to obtain correct identifier
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver(tokenName);
					final String identifier = tokenResolver.deResolve(elementMapping.getIdentifier(), reference, container);
					if (target instanceof EObject) {
						image = getImage((EObject) target);
					}
					boolean matchesPrefix = matches(identifier, prefix);
					org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal proposal = new org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal(expectedTerminal, identifier, prefix, matchesPrefix, reference, container, image);
					proposal.setReferenceTarget(target);
					resultSet.add(proposal);
				}
			}
			return resultSet;
		}
		return Collections.emptyList();
	}
	
	protected Collection<org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal> handleAttribute(org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal expectedTerminal, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedStructuralFeature expectedFeature, EObject container, EAttribute attribute, String prefix) {
		Collection<org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal> resultSet = new LinkedHashSet<org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal>();
		Object[] defaultValues = attributeValueProvider.getDefaultValues(attribute);
		if (defaultValues != null) {
			for (Object defaultValue : defaultValues) {
				if (defaultValue != null) {
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolverFactory tokenResolverFactory = metaInformation.getTokenResolverFactory();
					String tokenName = expectedFeature.getTokenName();
					if (tokenName != null) {
						org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver(tokenName);
						if (tokenResolver != null) {
							String defaultValueAsString = tokenResolver.deResolve(defaultValue, attribute, container);
							boolean matchesPrefix = matches(defaultValueAsString, prefix);
							resultSet.add(new org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal(expectedTerminal, defaultValueAsString, prefix, matchesPrefix, expectedFeature.getFeature(), container));
						}
					}
				}
			}
		}
		return resultSet;
	}
	
	/**
	 * Creates a set of completion proposals from the given keyword.
	 */
	protected Collection<org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal> handleKeyword(org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal expectedTerminal, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedCsString csString, String prefix, EObject container) {
		String proposal = csString.getValue();
		boolean matchesPrefix = matches(proposal, prefix);
		return Collections.singleton(new org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal(expectedTerminal, proposal, prefix, matchesPrefix, null, container));
	}
	
	/**
	 * Creates a set of (two) completion proposals from the given boolean terminal.
	 */
	protected Collection<org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal> handleBooleanTerminal(org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal expectedTerminal, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedBooleanTerminal expectedBooleanTerminal, String prefix) {
		Collection<org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal> result = new LinkedHashSet<org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal>(2);
		org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2BooleanTerminal booleanTerminal = expectedBooleanTerminal.getBooleanTerminal();
		result.addAll(handleLiteral(expectedTerminal, booleanTerminal.getAttribute(), prefix, booleanTerminal.getTrueLiteral()));
		result.addAll(handleLiteral(expectedTerminal, booleanTerminal.getAttribute(), prefix, booleanTerminal.getFalseLiteral()));
		return result;
	}
	
	/**
	 * Creates a set of completion proposals from the given enumeration terminal. For
	 * each enumeration literal one proposal is created.
	 */
	protected Collection<org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal> handleEnumerationTerminal(org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal expectedTerminal, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedEnumerationTerminal expectedEnumerationTerminal, String prefix) {
		Collection<org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal> result = new LinkedHashSet<org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal>(2);
		org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2EnumerationTerminal enumerationTerminal = expectedEnumerationTerminal.getEnumerationTerminal();
		Map<String, String> literalMapping = enumerationTerminal.getLiteralMapping();
		for (String literalName : literalMapping.keySet()) {
			result.addAll(handleLiteral(expectedTerminal, enumerationTerminal.getAttribute(), prefix, literalMapping.get(literalName)));
		}
		return result;
	}
	
	protected Collection<org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal> handleLiteral(org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal expectedTerminal, EAttribute attribute, String prefix, String literal) {
		if ("".equals(literal)) {
			return Collections.emptySet();
		}
		boolean matchesPrefix = matches(literal, prefix);
		return Collections.singleton(new org.emftext.language.xpath2.resource.xpath2.ui.Xpath2CompletionProposal(expectedTerminal, literal, prefix, matchesPrefix, null, null));
	}
	
	/**
	 * Calculates the prefix for each given expected element. The prefix depends on
	 * the current document content, the cursor position, and the position where the
	 * element is expected.
	 */
	protected void setPrefixes(List<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal> expectedElements, String content, int cursorOffset) {
		if (cursorOffset < 0) {
			return;
		}
		for (org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal expectedElement : expectedElements) {
			String prefix = findPrefix(expectedElements, expectedElement, content, cursorOffset);
			expectedElement.setPrefix(prefix);
		}
	}
	
	public org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal[] getElementsExpectedAt(org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal[] allExpectedElements, int cursorOffset) {
		List<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal> expectedAtCursor = new ArrayList<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal>();
		for (int i = 0; i < allExpectedElements.length; i++) {
			org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal expectedElement = allExpectedElements[i];
			int startIncludingHidden = expectedElement.getStartIncludingHiddenTokens();
			int end = getEnd(allExpectedElements, i);
			if (cursorOffset >= startIncludingHidden && cursorOffset <= end) {
				expectedAtCursor.add(expectedElement);
			}
		}
		return expectedAtCursor.toArray(new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal[expectedAtCursor.size()]);
	}
	
	/**
	 * Calculates the end index of the expected element at allExpectedElements[index].
	 * To determine the end, the subsequent expected elements from the array of all
	 * expected elements are used. An element is considered to end one character
	 * before the next elements starts.
	 */
	protected int getEnd(org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal[] allExpectedElements, int indexInList) {
		org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal elementAtIndex = allExpectedElements[indexInList];
		int startIncludingHidden = elementAtIndex.getStartIncludingHiddenTokens();
		int startExcludingHidden = elementAtIndex.getStartExcludingHiddenTokens();
		for (int i = indexInList + 1; i < allExpectedElements.length; i++) {
			org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal elementAtI = allExpectedElements[i];
			int startIncludingHiddenForI = elementAtI.getStartIncludingHiddenTokens();
			int startExcludingHiddenForI = elementAtI.getStartExcludingHiddenTokens();
			if (startIncludingHidden != startIncludingHiddenForI || startExcludingHidden != startExcludingHiddenForI) {
				return startIncludingHiddenForI - 1;
			}
		}
		return Integer.MAX_VALUE;
	}
	
	/**
	 * Checks whether the given proposed string matches the prefix. The two strings
	 * are compared ignoring the case. The prefix is also considered to match if is a
	 * camel case representation of the proposal.
	 */
	protected boolean matches(String proposal, String prefix) {
		if (proposal == null || prefix == null) {
			return false;
		}
		return (proposal.toLowerCase().startsWith(prefix.toLowerCase()) || org.emftext.language.xpath2.resource.xpath2.util.Xpath2StringUtil.matchCamelCase(prefix, proposal) != null) && !proposal.equals(prefix);
	}
	
	protected Image getImage(EObject element) {
		if (!Platform.isRunning()) {
			return null;
		}
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
		return labelProvider.getImage(element);
	}
	
	protected EObject findCorrectContainer(org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal expectedTerminal) {
		EObject container = expectedTerminal.getContainer();
		EClass ruleMetaclass = expectedTerminal.getTerminal().getRuleMetaclass();
		if (ruleMetaclass.isInstance(container)) {
			// container is correct for expected terminal
			return container;
		}
		// the container is wrong
		EObject parent = null;
		EObject previousParent = null;
		EObject correctContainer = null;
		EObject hookableParent = null;
		org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2ContainmentTrace containmentTrace = expectedTerminal.getContainmentTrace();
		EClass startClass = containmentTrace.getStartClass();
		org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ContainedFeature currentLink = null;
		org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ContainedFeature previousLink = null;
		org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ContainedFeature[] containedFeatures = containmentTrace.getPath();
		for (int i = 0; i < containedFeatures.length; i++) {
			currentLink = containedFeatures[i];
			if (i > 0) {
				previousLink = containedFeatures[i - 1];
			}
			EClass containerClass = currentLink.getContainerClass();
			hookableParent = findHookParent(container, startClass, currentLink, parent);
			if (hookableParent != null) {
				// we found the correct parent
				break;
			} else {
				previousParent = parent;
				parent = containerClass.getEPackage().getEFactoryInstance().create(containerClass);
				if (parent != null) {
					if (previousParent == null) {
						// replace container for expectedTerminal with correctContainer
						correctContainer = parent;
					} else {
						// This assignment is only performed to get rid of a warning about a potential
						// null pointer access. Variable 'previousLink' cannot be null here, because it is
						// initialized for all loop iterations where 'i' is greather than 0 and for the
						// case where 'i' equals zero, this path is never executed, because
						// 'previousParent' is null in this case.
						org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ContainedFeature link = previousLink;
						org.emftext.language.xpath2.resource.xpath2.util.Xpath2EObjectUtil.setFeature(parent, link.getFeature(), previousParent, false);
					}
				}
			}
		}
		
		if (correctContainer == null) {
			correctContainer = container;
		}
		
		if (currentLink == null) {
			return correctContainer;
		}
		
		hookableParent = findHookParent(container, startClass, currentLink, parent);
		
		final EObject finalHookableParent = hookableParent;
		final EStructuralFeature finalFeature = currentLink.getFeature();
		final EObject finalParent = parent;
		if (parent != null && hookableParent != null) {
			expectedTerminal.setAttachmentCode(new Runnable() {
				
				public void run() {
					org.emftext.language.xpath2.resource.xpath2.util.Xpath2EObjectUtil.setFeature(finalHookableParent, finalFeature, finalParent, false);
				}
			});
		}
		return correctContainer;
	}
	
	/**
	 * Walks up the containment hierarchy to find an EObject that is able to hold
	 * (contain) the given object.
	 */
	protected EObject findHookParent(EObject container, EClass startClass, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ContainedFeature currentLink, EObject object) {
		EClass containerClass = currentLink.getContainerClass();
		while (container != null) {
			if (containerClass.isInstance(object)) {
				if (startClass.equals(container.eClass())) {
					return container;
				}
			}
			container = container.eContainer();
		}
		return null;
	}
	
}
