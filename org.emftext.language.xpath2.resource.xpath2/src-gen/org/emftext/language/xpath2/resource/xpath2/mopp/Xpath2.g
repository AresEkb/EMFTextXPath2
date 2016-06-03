grammar Xpath2;

options {
	superClass = Xpath2ANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package org.emftext.language.xpath2.resource.xpath2.mopp;
	
	import java.util.ArrayList;
import java.util.List;
import org.antlr.runtime3_4_0.ANTLRStringStream;
import org.antlr.runtime3_4_0.RecognitionException;
}

@lexer::members {
	public List<RecognitionException> lexerExceptions  = new ArrayList<RecognitionException>();
	public List<Integer> lexerExceptionPositions = new ArrayList<Integer>();
	
	public void reportError(RecognitionException e) {
		lexerExceptions.add(e);
		lexerExceptionPositions.add(((ANTLRStringStream) input).index());
	}
}
@header{
	package org.emftext.language.xpath2.resource.xpath2.mopp;
	
	import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.antlr.runtime3_4_0.ANTLRInputStream;
import org.antlr.runtime3_4_0.BitSet;
import org.antlr.runtime3_4_0.CommonToken;
import org.antlr.runtime3_4_0.CommonTokenStream;
import org.antlr.runtime3_4_0.IntStream;
import org.antlr.runtime3_4_0.Lexer;
import org.antlr.runtime3_4_0.RecognitionException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
}

@members{
	private org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolverFactory tokenResolverFactory = new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TokenResolverFactory();
	
	/**
	 * the index of the last token that was handled by collectHiddenTokens()
	 */
	private int lastPosition;
	
	/**
	 * A flag that indicates whether the parser should remember all expected elements.
	 * This flag is set to true when using the parse for code completion. Otherwise it
	 * is set to false.
	 */
	private boolean rememberExpectedElements = false;
	
	private Object parseToIndexTypeObject;
	private int lastTokenIndex = 0;
	
	/**
	 * A list of expected elements the were collected while parsing the input stream.
	 * This list is only filled if <code>rememberExpectedElements</code> is set to
	 * true.
	 */
	private List<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal> expectedElements = new ArrayList<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal>();
	
	private int mismatchedTokenRecoveryTries = 0;
	/**
	 * A helper list to allow a lexer to pass errors to its parser
	 */
	protected List<RecognitionException> lexerExceptions = Collections.synchronizedList(new ArrayList<RecognitionException>());
	
	/**
	 * Another helper list to allow a lexer to pass positions of errors to its parser
	 */
	protected List<Integer> lexerExceptionPositions = Collections.synchronizedList(new ArrayList<Integer>());
	
	/**
	 * A stack for incomplete objects. This stack is used filled when the parser is
	 * used for code completion. Whenever the parser starts to read an object it is
	 * pushed on the stack. Once the element was parser completely it is popped from
	 * the stack.
	 */
	List<EObject> incompleteObjects = new ArrayList<EObject>();
	
	private int stopIncludingHiddenTokens;
	private int stopExcludingHiddenTokens;
	private int tokenIndexOfLastCompleteElement;
	
	private int expectedElementsIndexOfLastCompleteElement;
	
	/**
	 * The offset indicating the cursor position when the parser is used for code
	 * completion by calling parseToExpectedElements().
	 */
	private int cursorOffset;
	
	/**
	 * The offset of the first hidden token of the last expected element. This offset
	 * is used to discard expected elements, which are not needed for code completion.
	 */
	private int lastStartIncludingHidden;
	
	private org.emftext.language.xpath2.resource.xpath2.IXpath2LocationMap locationMap;
	
	private org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2SyntaxErrorMessageConverter syntaxErrorMessageConverter = new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2SyntaxErrorMessageConverter(tokenNames);
	
	@Override
	public void reportError(RecognitionException re) {
		addErrorToResource(syntaxErrorMessageConverter.translateParseError(re));
	}
	
	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
		postParseCommands.add(new org.emftext.language.xpath2.resource.xpath2.IXpath2Command<org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource>() {
			public boolean execute(org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for code completion
					return true;
				}
				resource.addProblem(new org.emftext.language.xpath2.resource.xpath2.IXpath2Problem() {
					public org.emftext.language.xpath2.resource.xpath2.Xpath2EProblemSeverity getSeverity() {
						return org.emftext.language.xpath2.resource.xpath2.Xpath2EProblemSeverity.ERROR;
					}
					public org.emftext.language.xpath2.resource.xpath2.Xpath2EProblemType getType() {
						return org.emftext.language.xpath2.resource.xpath2.Xpath2EProblemType.SYNTAX_ERROR;
					}
					public String getMessage() {
						return errorMessage;
					}
					public Collection<org.emftext.language.xpath2.resource.xpath2.IXpath2QuickFix> getQuickFixes() {
						return null;
					}
				}, column, line, startIndex, stopIndex);
				return true;
			}
		});
	}
	
	protected void addErrorToResource(org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2LocalizedMessage message) {
		if (message == null) {
			return;
		}
		addErrorToResource(message.getMessage(), message.getColumn(), message.getLine(), message.getCharStart(), message.getCharEnd());
	}
	
	public void addExpectedElement(EClass eClass, int expectationStartIndex, int expectationEndIndex) {
		for (int expectationIndex = expectationStartIndex; expectationIndex <= expectationEndIndex; expectationIndex++) {
			addExpectedElement(eClass, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[expectationIndex]);
		}
	}
	
	public void addExpectedElement(EClass eClass, int expectationIndex) {
		addExpectedElement(eClass, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectationConstants.EXPECTATIONS[expectationIndex]);
	}
	
	public void addExpectedElement(EClass eClass, int[] ids) {
		if (!this.rememberExpectedElements) {
			return;
		}
		int terminalID = ids[0];
		int followSetID = ids[1];
		org.emftext.language.xpath2.resource.xpath2.IXpath2ExpectedElement terminal = org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2FollowSetProvider.TERMINALS[terminalID];
		org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ContainedFeature[] containmentFeatures = new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ContainedFeature[ids.length - 2];
		for (int i = 2; i < ids.length; i++) {
			containmentFeatures[i - 2] = org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2FollowSetProvider.LINKS[ids[i]];
		}
		org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2ContainmentTrace containmentTrace = new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2ContainmentTrace(eClass, containmentFeatures);
		EObject container = getLastIncompleteElement();
		org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal expectedElement = new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal(container, terminal, followSetID, containmentTrace);
		setPosition(expectedElement, input.index());
		int startIncludingHiddenTokens = expectedElement.getStartIncludingHiddenTokens();
		lastStartIncludingHidden = startIncludingHiddenTokens;
		this.expectedElements.add(expectedElement);
	}
	
	protected void collectHiddenTokens(EObject element) {
	}
	
	protected void copyLocalizationInfos(final EObject source, final EObject target) {
		if (disableLocationMap) {
			return;
		}
		final org.emftext.language.xpath2.resource.xpath2.IXpath2LocationMap locationMap = this.locationMap;
		if (locationMap == null) {
			// the locationMap can be null if the parser is used for code completion
			return;
		}
		postParseCommands.add(new org.emftext.language.xpath2.resource.xpath2.IXpath2Command<org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource>() {
			public boolean execute(org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource resource) {
				locationMap.setCharStart(target, locationMap.getCharStart(source));
				locationMap.setCharEnd(target, locationMap.getCharEnd(source));
				locationMap.setColumn(target, locationMap.getColumn(source));
				locationMap.setLine(target, locationMap.getLine(source));
				return true;
			}
		});
	}
	
	protected void copyLocalizationInfos(final CommonToken source, final EObject target) {
		if (disableLocationMap) {
			return;
		}
		final org.emftext.language.xpath2.resource.xpath2.IXpath2LocationMap locationMap = this.locationMap;
		if (locationMap == null) {
			// the locationMap can be null if the parser is used for code completion
			return;
		}
		postParseCommands.add(new org.emftext.language.xpath2.resource.xpath2.IXpath2Command<org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource>() {
			public boolean execute(org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource resource) {
				if (source == null) {
					return true;
				}
				locationMap.setCharStart(target, source.getStartIndex());
				locationMap.setCharEnd(target, source.getStopIndex());
				locationMap.setColumn(target, source.getCharPositionInLine());
				locationMap.setLine(target, source.getLine());
				return true;
			}
		});
	}
	
	/**
	 * Sets the end character index and the last line for the given object in the
	 * location map.
	 */
	protected void setLocalizationEnd(Collection<org.emftext.language.xpath2.resource.xpath2.IXpath2Command<org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource>> postParseCommands , final EObject object, final int endChar, final int endLine) {
		if (disableLocationMap) {
			return;
		}
		final org.emftext.language.xpath2.resource.xpath2.IXpath2LocationMap locationMap = this.locationMap;
		if (locationMap == null) {
			// the locationMap can be null if the parser is used for code completion
			return;
		}
		postParseCommands.add(new org.emftext.language.xpath2.resource.xpath2.IXpath2Command<org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource>() {
			public boolean execute(org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource resource) {
				locationMap.setCharEnd(object, endChar);
				locationMap.setLine(object, endLine);
				return true;
			}
		});
	}
	
	public org.emftext.language.xpath2.resource.xpath2.IXpath2TextParser createInstance(InputStream actualInputStream, String encoding) {
		try {
			if (encoding == null) {
				return new Xpath2Parser(new CommonTokenStream(new Xpath2Lexer(new ANTLRInputStream(actualInputStream))));
			} else {
				return new Xpath2Parser(new CommonTokenStream(new Xpath2Lexer(new ANTLRInputStream(actualInputStream, encoding))));
			}
		} catch (IOException e) {
			new org.emftext.language.xpath2.resource.xpath2.util.Xpath2RuntimeUtil().logError("Error while creating parser.", e);
			return null;
		}
	}
	
	/**
	 * This default constructor is only used to call createInstance() on it.
	 */
	public Xpath2Parser() {
		super(null);
	}
	
	protected EObject doParse() throws RecognitionException {
		this.lastPosition = 0;
		// required because the lexer class can not be subclassed
		((Xpath2Lexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((Xpath2Lexer) getTokenStream().getTokenSource()).lexerExceptionPositions = lexerExceptionPositions;
		Object typeObject = getTypeObject();
		if (typeObject == null) {
			return start();
		} else if (typeObject instanceof EClass) {
			EClass type = (EClass) typeObject;
			if (type.getInstanceClass() == org.emftext.language.xpath2.Expr.class) {
				return parse_org_emftext_language_xpath2_Expr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.ForExpr.class) {
				return parse_org_emftext_language_xpath2_ForExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.QuantifiedExpr.class) {
				return parse_org_emftext_language_xpath2_QuantifiedExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.Iterator.class) {
				return parse_org_emftext_language_xpath2_Iterator();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.IfExpr.class) {
				return parse_org_emftext_language_xpath2_IfExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.OrExpr.class) {
				return parse_org_emftext_language_xpath2_OrExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.AndExpr.class) {
				return parse_org_emftext_language_xpath2_AndExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.ComparisonExpr.class) {
				return parse_org_emftext_language_xpath2_ComparisonExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.RangeExpr.class) {
				return parse_org_emftext_language_xpath2_RangeExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.GeneralComp.class) {
				return parse_org_emftext_language_xpath2_GeneralComp();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.ValueComp.class) {
				return parse_org_emftext_language_xpath2_ValueComp();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.NodeComp.class) {
				return parse_org_emftext_language_xpath2_NodeComp();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.AdditiveExpr.class) {
				return parse_org_emftext_language_xpath2_AdditiveExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.MultiplicativeExpr.class) {
				return parse_org_emftext_language_xpath2_MultiplicativeExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.UnionExpr.class) {
				return parse_org_emftext_language_xpath2_UnionExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.IntersectExceptExpr.class) {
				return parse_org_emftext_language_xpath2_IntersectExceptExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.InstanceofExpr.class) {
				return parse_org_emftext_language_xpath2_InstanceofExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.TreatExpr.class) {
				return parse_org_emftext_language_xpath2_TreatExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.CastableExpr.class) {
				return parse_org_emftext_language_xpath2_CastableExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.CastExpr.class) {
				return parse_org_emftext_language_xpath2_CastExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.UnaryExpr.class) {
				return parse_org_emftext_language_xpath2_UnaryExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.FilterExpr.class) {
				return parse_org_emftext_language_xpath2_FilterExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.FunctionCall.class) {
				return parse_org_emftext_language_xpath2_FunctionCall();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.PathExpr.class) {
				return parse_org_emftext_language_xpath2_PathExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.ChildStepExpr.class) {
				return parse_org_emftext_language_xpath2_ChildStepExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.DescOrSelfStepExpr.class) {
				return parse_org_emftext_language_xpath2_DescOrSelfStepExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.RootStepExpr.class) {
				return parse_org_emftext_language_xpath2_RootStepExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.SelfStepExpr.class) {
				return parse_org_emftext_language_xpath2_SelfStepExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.GeneralForwardStep.class) {
				return parse_org_emftext_language_xpath2_GeneralForwardStep();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.AbbrevForwardStep.class) {
				return parse_org_emftext_language_xpath2_AbbrevForwardStep();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.GeneralReverseStep.class) {
				return parse_org_emftext_language_xpath2_GeneralReverseStep();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.AbbrevReverseStep.class) {
				return parse_org_emftext_language_xpath2_AbbrevReverseStep();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.NodeKindTest.class) {
				return parse_org_emftext_language_xpath2_NodeKindTest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.QNameTest.class) {
				return parse_org_emftext_language_xpath2_QNameTest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.AnyWildcard.class) {
				return parse_org_emftext_language_xpath2_AnyWildcard();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.LocalNameWildcard.class) {
				return parse_org_emftext_language_xpath2_LocalNameWildcard();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.NamespaceWildcard.class) {
				return parse_org_emftext_language_xpath2_NamespaceWildcard();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.Predicate.class) {
				return parse_org_emftext_language_xpath2_Predicate();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.VarRef.class) {
				return parse_org_emftext_language_xpath2_VarRef();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.ParenthesizedExpr.class) {
				return parse_org_emftext_language_xpath2_ParenthesizedExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.ContextItemExpr.class) {
				return parse_org_emftext_language_xpath2_ContextItemExpr();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.SingleType.class) {
				return parse_org_emftext_language_xpath2_SingleType();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.EmptySequenceType.class) {
				return parse_org_emftext_language_xpath2_EmptySequenceType();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.ItemSequenceType.class) {
				return parse_org_emftext_language_xpath2_ItemSequenceType();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.ItemKindTest.class) {
				return parse_org_emftext_language_xpath2_ItemKindTest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.AnyItemType.class) {
				return parse_org_emftext_language_xpath2_AnyItemType();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.AtomicItemType.class) {
				return parse_org_emftext_language_xpath2_AtomicItemType();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.AtomicType.class) {
				return parse_org_emftext_language_xpath2_AtomicType();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.OptionalAtomicType.class) {
				return parse_org_emftext_language_xpath2_OptionalAtomicType();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.AnyKindTest.class) {
				return parse_org_emftext_language_xpath2_AnyKindTest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.DocumentTest.class) {
				return parse_org_emftext_language_xpath2_DocumentTest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.TextTest.class) {
				return parse_org_emftext_language_xpath2_TextTest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.CommentTest.class) {
				return parse_org_emftext_language_xpath2_CommentTest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.PITest.class) {
				return parse_org_emftext_language_xpath2_PITest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.NCNamePITest.class) {
				return parse_org_emftext_language_xpath2_NCNamePITest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.StringLiteralPITest.class) {
				return parse_org_emftext_language_xpath2_StringLiteralPITest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.AttributeTest.class) {
				return parse_org_emftext_language_xpath2_AttributeTest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.WildcardAttributeTest.class) {
				return parse_org_emftext_language_xpath2_WildcardAttributeTest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.NameAttributeTest.class) {
				return parse_org_emftext_language_xpath2_NameAttributeTest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.SchemaAttributeTest.class) {
				return parse_org_emftext_language_xpath2_SchemaAttributeTest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.ElementTest.class) {
				return parse_org_emftext_language_xpath2_ElementTest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.WildcardElementTest.class) {
				return parse_org_emftext_language_xpath2_WildcardElementTest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.NameElementTest.class) {
				return parse_org_emftext_language_xpath2_NameElementTest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.SchemaElementTest.class) {
				return parse_org_emftext_language_xpath2_SchemaElementTest();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.IntegerLiteral.class) {
				return parse_org_emftext_language_xpath2_IntegerLiteral();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.DecimalLiteral.class) {
				return parse_org_emftext_language_xpath2_DecimalLiteral();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.DoubleLiteral.class) {
				return parse_org_emftext_language_xpath2_DoubleLiteral();
			}
			if (type.getInstanceClass() == org.emftext.language.xpath2.StringLiteral.class) {
				return parse_org_emftext_language_xpath2_StringLiteral();
			}
		}
		throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2UnexpectedContentTypeException(typeObject);
	}
	
	public int getMismatchedTokenRecoveryTries() {
		return mismatchedTokenRecoveryTries;
	}
	
	public Object getMissingSymbol(IntStream arg0, RecognitionException arg1, int arg2, BitSet arg3) {
		mismatchedTokenRecoveryTries++;
		return super.getMissingSymbol(arg0, arg1, arg2, arg3);
	}
	
	public Object getParseToIndexTypeObject() {
		return parseToIndexTypeObject;
	}
	
	protected Object getTypeObject() {
		Object typeObject = getParseToIndexTypeObject();
		if (typeObject != null) {
			return typeObject;
		}
		Map<?,?> options = getOptions();
		if (options != null) {
			typeObject = options.get(org.emftext.language.xpath2.resource.xpath2.IXpath2Options.RESOURCE_CONTENT_TYPE);
		}
		return typeObject;
	}
	
	/**
	 * Implementation that calls {@link #doParse()} and handles the thrown
	 * RecognitionExceptions.
	 */
	public org.emftext.language.xpath2.resource.xpath2.IXpath2ParseResult parse() {
		// Reset parser state
		terminateParsing = false;
		postParseCommands = new ArrayList<org.emftext.language.xpath2.resource.xpath2.IXpath2Command<org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource>>();
		org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ParseResult parseResult = new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ParseResult();
		if (disableLocationMap) {
			locationMap = new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2DevNullLocationMap();
		} else {
			locationMap = new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2LocationMap();
		}
		// Run parser
		try {
			EObject result =  doParse();
			if (lexerExceptions.isEmpty()) {
				parseResult.setRoot(result);
				parseResult.setLocationMap(locationMap);
			}
		} catch (RecognitionException re) {
			addErrorToResource(syntaxErrorMessageConverter.translateParseError(re));
		} catch (IllegalArgumentException iae) {
			if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
				// can be caused if a null is set on EMF models where not allowed. this will just
				// happen if other errors occurred before
			} else {
				iae.printStackTrace();
			}
		}
		for (RecognitionException re : lexerExceptions) {
			addErrorToResource(syntaxErrorMessageConverter.translateLexicalError(re, lexerExceptions, lexerExceptionPositions));
		}
		parseResult.getPostParseCommands().addAll(postParseCommands);
		return parseResult;
	}
	
	public List<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal> parseToExpectedElements(EClass type, org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource dummyResource, int cursorOffset) {
		this.rememberExpectedElements = true;
		this.parseToIndexTypeObject = type;
		this.cursorOffset = cursorOffset;
		this.lastStartIncludingHidden = -1;
		final CommonTokenStream tokenStream = (CommonTokenStream) getTokenStream();
		org.emftext.language.xpath2.resource.xpath2.IXpath2ParseResult result = parse();
		for (EObject incompleteObject : incompleteObjects) {
			Lexer lexer = (Lexer) tokenStream.getTokenSource();
			int endChar = lexer.getCharIndex();
			int endLine = lexer.getLine();
			setLocalizationEnd(result.getPostParseCommands(), incompleteObject, endChar, endLine);
		}
		if (result != null) {
			EObject root = result.getRoot();
			if (root != null) {
				dummyResource.getContentsInternal().add(root);
			}
			for (org.emftext.language.xpath2.resource.xpath2.IXpath2Command<org.emftext.language.xpath2.resource.xpath2.IXpath2TextResource> command : result.getPostParseCommands()) {
				command.execute(dummyResource);
			}
		}
		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
		Set<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal> currentFollowSet = new LinkedHashSet<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal>();
		List<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal> newFollowSet = new ArrayList<org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal>();
		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
			org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal expectedElementI = expectedElements.get(i);
			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
				currentFollowSet.add(expectedElementI);
			} else {
				break;
			}
		}
		int followSetID = 246;
		int i;
		for (i = tokenIndexOfLastCompleteElement; i < tokenStream.size(); i++) {
			CommonToken nextToken = (CommonToken) tokenStream.get(i);
			if (nextToken.getType() < 0) {
				break;
			}
			if (nextToken.getChannel() == 99) {
				// hidden tokens do not reduce the follow set
			} else {
				// now that we have found the next visible token the position for that expected
				// terminals can be set
				for (org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal nextFollow : newFollowSet) {
					lastTokenIndex = 0;
					setPosition(nextFollow, i);
				}
				newFollowSet.clear();
				// normal tokens do reduce the follow set - only elements that match the token are
				// kept
				for (org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal nextFollow : currentFollowSet) {
					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
						// keep this one - it matches
						Collection<org.emftext.language.xpath2.resource.xpath2.util.Xpath2Pair<org.emftext.language.xpath2.resource.xpath2.IXpath2ExpectedElement, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
						for (org.emftext.language.xpath2.resource.xpath2.util.Xpath2Pair<org.emftext.language.xpath2.resource.xpath2.IXpath2ExpectedElement, org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ContainedFeature[]> newFollowerPair : newFollowers) {
							org.emftext.language.xpath2.resource.xpath2.IXpath2ExpectedElement newFollower = newFollowerPair.getLeft();
							EObject container = getLastIncompleteElement();
							org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2ContainmentTrace containmentTrace = new org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2ContainmentTrace(null, newFollowerPair.getRight());
							org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal newFollowTerminal = new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal(container, newFollower, followSetID, containmentTrace);
							newFollowSet.add(newFollowTerminal);
							expectedElements.add(newFollowTerminal);
						}
					}
				}
				currentFollowSet.clear();
				currentFollowSet.addAll(newFollowSet);
			}
			followSetID++;
		}
		// after the last token in the stream we must set the position for the elements
		// that were added during the last iteration of the loop
		for (org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal nextFollow : newFollowSet) {
			lastTokenIndex = 0;
			setPosition(nextFollow, i);
		}
		return this.expectedElements;
	}
	
	public void setPosition(org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ExpectedTerminal expectedElement, int tokenIndex) {
		int currentIndex = Math.max(0, tokenIndex);
		for (int index = lastTokenIndex; index < currentIndex; index++) {
			if (index >= input.size()) {
				break;
			}
			CommonToken tokenAtIndex = (CommonToken) input.get(index);
			stopIncludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
			if (tokenAtIndex.getChannel() != 99 && !anonymousTokens.contains(tokenAtIndex)) {
				stopExcludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
			}
		}
		lastTokenIndex = Math.max(0, currentIndex);
		expectedElement.setPosition(stopExcludingHiddenTokens, stopIncludingHiddenTokens);
	}
	
	public Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow) throws RecognitionException {
		if (!rememberExpectedElements) {
			return super.recoverFromMismatchedToken(input, ttype, follow);
		} else {
			return null;
		}
	}
	
	private void startIncompleteElement(Object object) {
		if (object instanceof EObject) {
			this.incompleteObjects.add((EObject) object);
		}
	}
	
	private void completedElement(Object object, boolean isContainment) {
		if (isContainment && !this.incompleteObjects.isEmpty()) {
			this.incompleteObjects.remove(object);
		}
		if (object instanceof EObject) {
			this.tokenIndexOfLastCompleteElement = getTokenStream().index();
			this.expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
		}
	}
	
	private EObject getLastIncompleteElement() {
		if (incompleteObjects.isEmpty()) {
			return null;
		}
		return incompleteObjects.get(incompleteObjects.size() - 1);
	}
	
}

start returns [ EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getExpr(), 0, 90);
		expectedElementsIndexOfLastCompleteElement = 90;
	}
	(
		c0 = parse_org_emftext_language_xpath2_Expr{ element = c0; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_org_emftext_language_xpath2_Expr returns [org.emftext.language.xpath2.Expr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_IfExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					addObjectToList(element, org.emftext.language.xpath2.XPath2Package.EXPR__EXPR, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_0_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
		|		a0_1 = parse_org_emftext_language_xpath2_ForExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createExpr();
				startIncompleteElement(element);
			}
			if (a0_1 != null) {
				if (a0_1 != null) {
					Object value = a0_1;
					addObjectToList(element, org.emftext.language.xpath2.XPath2Package.EXPR__EXPR, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_0_0_0_0, a0_1, true);
				copyLocalizationInfos(a0_1, element);
			}
		}
		|		a0_2 = parse_org_emftext_language_xpath2_QuantifiedExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createExpr();
				startIncompleteElement(element);
			}
			if (a0_2 != null) {
				if (a0_2 != null) {
					Object value = a0_2;
					addObjectToList(element, org.emftext.language.xpath2.XPath2Package.EXPR__EXPR, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_0_0_0_0, a0_2, true);
				copyLocalizationInfos(a0_2, element);
			}
		}
		|		a0_3 = parse_org_emftext_language_xpath2_OrExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createExpr();
				startIncompleteElement(element);
			}
			if (a0_3 != null) {
				if (a0_3 != null) {
					Object value = a0_3;
					addObjectToList(element, org.emftext.language.xpath2.XPath2Package.EXPR__EXPR, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_0_0_0_0, a0_3, true);
				copyLocalizationInfos(a0_3, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 91, 94);
	}
	
	(
		(
			a1 = ',' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_0_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getExpr(), 95, 185);
			}
			
			(
				a2_0 = parse_org_emftext_language_xpath2_IfExpr				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createExpr();
						startIncompleteElement(element);
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							Object value = a2_0;
							addObjectToList(element, org.emftext.language.xpath2.XPath2Package.EXPR__EXPR, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_0_0_0_1_0_0_1, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
				|				a2_1 = parse_org_emftext_language_xpath2_ForExpr				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createExpr();
						startIncompleteElement(element);
					}
					if (a2_1 != null) {
						if (a2_1 != null) {
							Object value = a2_1;
							addObjectToList(element, org.emftext.language.xpath2.XPath2Package.EXPR__EXPR, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_0_0_0_1_0_0_1, a2_1, true);
						copyLocalizationInfos(a2_1, element);
					}
				}
				|				a2_2 = parse_org_emftext_language_xpath2_QuantifiedExpr				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createExpr();
						startIncompleteElement(element);
					}
					if (a2_2 != null) {
						if (a2_2 != null) {
							Object value = a2_2;
							addObjectToList(element, org.emftext.language.xpath2.XPath2Package.EXPR__EXPR, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_0_0_0_1_0_0_1, a2_2, true);
						copyLocalizationInfos(a2_2, element);
					}
				}
				|				a2_3 = parse_org_emftext_language_xpath2_OrExpr				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createExpr();
						startIncompleteElement(element);
					}
					if (a2_3 != null) {
						if (a2_3 != null) {
							Object value = a2_3;
							addObjectToList(element, org.emftext.language.xpath2.XPath2Package.EXPR__EXPR, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_0_0_0_1_0_0_1, a2_3, true);
						copyLocalizationInfos(a2_3, element);
					}
				}
			)
			{
				// expected elements (follow set)
				// We've found the last token for this rule. The constructed EObject is now
				// complete.
				completedElement(element, true);
				addExpectedElement(null, 186, 189);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 190, 193);
	}
	
;

parse_org_emftext_language_xpath2_ForExpr returns [org.emftext.language.xpath2.ForExpr element = null]
@init{
}
:
	a0 = 'for' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createForExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_1_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getForExpr(), 194);
	}
	
	(
		a1_0 = parse_org_emftext_language_xpath2_Iterator		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createForExpr();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					addObjectToList(element, org.emftext.language.xpath2.XPath2Package.FOR_EXPR__ITERATOR, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_1_0_0_2, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 195, 196);
	}
	
	(
		(
			a2 = ',' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createForExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_1_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getForExpr(), 197);
			}
			
			(
				a3_0 = parse_org_emftext_language_xpath2_Iterator				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createForExpr();
						startIncompleteElement(element);
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							Object value = a3_0;
							addObjectToList(element, org.emftext.language.xpath2.XPath2Package.FOR_EXPR__ITERATOR, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_1_0_0_3_0_0_2, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, 198, 199);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, 200, 201);
	}
	
	a4 = 'return' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createForExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_1_0_0_5, null, true);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getForExpr(), 202, 1522);
	}
	
	(
		a5_0 = parse_org_emftext_language_xpath2_ExprSingle		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createForExpr();
				startIncompleteElement(element);
			}
			if (a5_0 != null) {
				if (a5_0 != null) {
					Object value = a5_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.FOR_EXPR__RETURN), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_1_0_0_7, a5_0, true);
				copyLocalizationInfos(a5_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 1523, 1528);
	}
	
;

parse_org_emftext_language_xpath2_QuantifiedExpr returns [org.emftext.language.xpath2.QuantifiedExpr element = null]
@init{
}
:
	(
		(
			a0 = 'some' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createQuantifiedExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_2_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getQuantifierKind().getEEnumLiteral(org.emftext.language.xpath2.QuantifierKind.SOME_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.QUANTIFIED_EXPR__QUANTIFIER), value);
				completedElement(value, false);
			}
			|			a1 = 'every' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createQuantifiedExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_2_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getQuantifierKind().getEEnumLiteral(org.emftext.language.xpath2.QuantifierKind.EVERY_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.QUANTIFIED_EXPR__QUANTIFIER), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getQuantifiedExpr(), 1529);
	}
	
	(
		a4_0 = parse_org_emftext_language_xpath2_Iterator		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createQuantifiedExpr();
				startIncompleteElement(element);
			}
			if (a4_0 != null) {
				if (a4_0 != null) {
					Object value = a4_0;
					addObjectToList(element, org.emftext.language.xpath2.XPath2Package.QUANTIFIED_EXPR__ITERATOR, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_2_0_0_2, a4_0, true);
				copyLocalizationInfos(a4_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 1530, 1531);
	}
	
	(
		(
			a5 = ',' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createQuantifiedExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_2_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getQuantifiedExpr(), 1532);
			}
			
			(
				a6_0 = parse_org_emftext_language_xpath2_Iterator				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createQuantifiedExpr();
						startIncompleteElement(element);
					}
					if (a6_0 != null) {
						if (a6_0 != null) {
							Object value = a6_0;
							addObjectToList(element, org.emftext.language.xpath2.XPath2Package.QUANTIFIED_EXPR__ITERATOR, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_2_0_0_3_0_0_2, a6_0, true);
						copyLocalizationInfos(a6_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, 1533, 1534);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, 1535, 1536);
	}
	
	a7 = 'satisfies' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createQuantifiedExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_2_0_0_4, null, true);
		copyLocalizationInfos((CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getQuantifiedExpr(), 1537, 1627);
	}
	
	(
		a8_0 = parse_org_emftext_language_xpath2_IfExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createQuantifiedExpr();
				startIncompleteElement(element);
			}
			if (a8_0 != null) {
				if (a8_0 != null) {
					Object value = a8_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.QUANTIFIED_EXPR__SATISFIES), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_2_0_0_6, a8_0, true);
				copyLocalizationInfos(a8_0, element);
			}
		}
		|		a8_1 = parse_org_emftext_language_xpath2_ForExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createQuantifiedExpr();
				startIncompleteElement(element);
			}
			if (a8_1 != null) {
				if (a8_1 != null) {
					Object value = a8_1;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.QUANTIFIED_EXPR__SATISFIES), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_2_0_0_6, a8_1, true);
				copyLocalizationInfos(a8_1, element);
			}
		}
		|		a8_2 = parse_org_emftext_language_xpath2_QuantifiedExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createQuantifiedExpr();
				startIncompleteElement(element);
			}
			if (a8_2 != null) {
				if (a8_2 != null) {
					Object value = a8_2;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.QUANTIFIED_EXPR__SATISFIES), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_2_0_0_6, a8_2, true);
				copyLocalizationInfos(a8_2, element);
			}
		}
		|		a8_3 = parse_org_emftext_language_xpath2_OrExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createQuantifiedExpr();
				startIncompleteElement(element);
			}
			if (a8_3 != null) {
				if (a8_3 != null) {
					Object value = a8_3;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.QUANTIFIED_EXPR__SATISFIES), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_2_0_0_6, a8_3, true);
				copyLocalizationInfos(a8_3, element);
			}
		}
	)
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 1628, 1633);
	}
	
;

parse_org_emftext_language_xpath2_Iterator returns [org.emftext.language.xpath2.Iterator element = null]
@init{
}
:
	a0 = '$' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createIterator();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_3_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 1634, 1635);
	}
	
	(
		(
			a1 = QNAME			
			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createIterator();
					startIncompleteElement(element);
				}
				if (a1 != null) {
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QNAME");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ITERATOR__VAR_NAME), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
					}
					javax.xml.namespace.QName resolved = (javax.xml.namespace.QName) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ITERATOR__VAR_NAME), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_3_0_0_1_0_0_0, resolved, true);
					copyLocalizationInfos((CommonToken) a1, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, 1636);
		}
		
		
		|		(
			a2 = NCNAME			
			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createIterator();
					startIncompleteElement(element);
				}
				if (a2 != null) {
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NCNAME");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ITERATOR__VAR_NAME), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
					}
					javax.xml.namespace.QName resolved = (javax.xml.namespace.QName) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ITERATOR__VAR_NAME), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_3_0_0_1_0_1_0, resolved, true);
					copyLocalizationInfos((CommonToken) a2, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, 1637);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 1638);
	}
	
	a3 = 'in' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createIterator();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_3_0_0_3, null, true);
		copyLocalizationInfos((CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIterator(), 1639, 1729);
	}
	
	(
		a4_0 = parse_org_emftext_language_xpath2_IfExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createIterator();
				startIncompleteElement(element);
			}
			if (a4_0 != null) {
				if (a4_0 != null) {
					Object value = a4_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ITERATOR__LIST), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_3_0_0_5, a4_0, true);
				copyLocalizationInfos(a4_0, element);
			}
		}
		|		a4_1 = parse_org_emftext_language_xpath2_ForExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createIterator();
				startIncompleteElement(element);
			}
			if (a4_1 != null) {
				if (a4_1 != null) {
					Object value = a4_1;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ITERATOR__LIST), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_3_0_0_5, a4_1, true);
				copyLocalizationInfos(a4_1, element);
			}
		}
		|		a4_2 = parse_org_emftext_language_xpath2_QuantifiedExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createIterator();
				startIncompleteElement(element);
			}
			if (a4_2 != null) {
				if (a4_2 != null) {
					Object value = a4_2;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ITERATOR__LIST), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_3_0_0_5, a4_2, true);
				copyLocalizationInfos(a4_2, element);
			}
		}
		|		a4_3 = parse_org_emftext_language_xpath2_OrExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createIterator();
				startIncompleteElement(element);
			}
			if (a4_3 != null) {
				if (a4_3 != null) {
					Object value = a4_3;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ITERATOR__LIST), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_3_0_0_5, a4_3, true);
				copyLocalizationInfos(a4_3, element);
			}
		}
	)
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 1730, 1733);
	}
	
;

parse_org_emftext_language_xpath2_IfExpr returns [org.emftext.language.xpath2.IfExpr element = null]
@init{
}
:
	a0 = 'if' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createIfExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 1734);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createIfExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIfExpr(), 1735, 1916);
	}
	
	(
		a2_0 = parse_org_emftext_language_xpath2_Expr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createIfExpr();
				startIncompleteElement(element);
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					Object value = a2_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.IF_EXPR__TEST), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_3, a2_0, true);
				copyLocalizationInfos(a2_0, element);
			}
		}
		|		a2_1 = parse_org_emftext_language_xpath2_IfExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createIfExpr();
				startIncompleteElement(element);
			}
			if (a2_1 != null) {
				if (a2_1 != null) {
					Object value = a2_1;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.IF_EXPR__TEST), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_3, a2_1, true);
				copyLocalizationInfos(a2_1, element);
			}
		}
		|		a2_2 = parse_org_emftext_language_xpath2_ForExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createIfExpr();
				startIncompleteElement(element);
			}
			if (a2_2 != null) {
				if (a2_2 != null) {
					Object value = a2_2;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.IF_EXPR__TEST), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_3, a2_2, true);
				copyLocalizationInfos(a2_2, element);
			}
		}
		|		a2_3 = parse_org_emftext_language_xpath2_QuantifiedExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createIfExpr();
				startIncompleteElement(element);
			}
			if (a2_3 != null) {
				if (a2_3 != null) {
					Object value = a2_3;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.IF_EXPR__TEST), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_3, a2_3, true);
				copyLocalizationInfos(a2_3, element);
			}
		}
		|		a2_4 = parse_org_emftext_language_xpath2_OrExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createIfExpr();
				startIncompleteElement(element);
			}
			if (a2_4 != null) {
				if (a2_4 != null) {
					Object value = a2_4;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.IF_EXPR__TEST), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_3, a2_4, true);
				copyLocalizationInfos(a2_4, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 1917);
	}
	
	a3 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createIfExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_4, null, true);
		copyLocalizationInfos((CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 1918);
	}
	
	a4 = 'then' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createIfExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_6, null, true);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIfExpr(), 1919, 2009);
	}
	
	(
		a5_0 = parse_org_emftext_language_xpath2_IfExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createIfExpr();
				startIncompleteElement(element);
			}
			if (a5_0 != null) {
				if (a5_0 != null) {
					Object value = a5_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.IF_EXPR__THEN), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_8, a5_0, true);
				copyLocalizationInfos(a5_0, element);
			}
		}
		|		a5_1 = parse_org_emftext_language_xpath2_ForExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createIfExpr();
				startIncompleteElement(element);
			}
			if (a5_1 != null) {
				if (a5_1 != null) {
					Object value = a5_1;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.IF_EXPR__THEN), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_8, a5_1, true);
				copyLocalizationInfos(a5_1, element);
			}
		}
		|		a5_2 = parse_org_emftext_language_xpath2_QuantifiedExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createIfExpr();
				startIncompleteElement(element);
			}
			if (a5_2 != null) {
				if (a5_2 != null) {
					Object value = a5_2;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.IF_EXPR__THEN), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_8, a5_2, true);
				copyLocalizationInfos(a5_2, element);
			}
		}
		|		a5_3 = parse_org_emftext_language_xpath2_OrExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createIfExpr();
				startIncompleteElement(element);
			}
			if (a5_3 != null) {
				if (a5_3 != null) {
					Object value = a5_3;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.IF_EXPR__THEN), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_8, a5_3, true);
				copyLocalizationInfos(a5_3, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 2010);
	}
	
	a6 = 'else' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createIfExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_10, null, true);
		copyLocalizationInfos((CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIfExpr(), 2011, 2101);
	}
	
	(
		a7_0 = parse_org_emftext_language_xpath2_IfExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createIfExpr();
				startIncompleteElement(element);
			}
			if (a7_0 != null) {
				if (a7_0 != null) {
					Object value = a7_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.IF_EXPR__ELSE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_12, a7_0, true);
				copyLocalizationInfos(a7_0, element);
			}
		}
		|		a7_1 = parse_org_emftext_language_xpath2_ForExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createIfExpr();
				startIncompleteElement(element);
			}
			if (a7_1 != null) {
				if (a7_1 != null) {
					Object value = a7_1;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.IF_EXPR__ELSE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_12, a7_1, true);
				copyLocalizationInfos(a7_1, element);
			}
		}
		|		a7_2 = parse_org_emftext_language_xpath2_QuantifiedExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createIfExpr();
				startIncompleteElement(element);
			}
			if (a7_2 != null) {
				if (a7_2 != null) {
					Object value = a7_2;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.IF_EXPR__ELSE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_12, a7_2, true);
				copyLocalizationInfos(a7_2, element);
			}
		}
		|		a7_3 = parse_org_emftext_language_xpath2_OrExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createIfExpr();
				startIncompleteElement(element);
			}
			if (a7_3 != null) {
				if (a7_3 != null) {
					Object value = a7_3;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.IF_EXPR__ELSE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_4_0_0_12, a7_3, true);
				copyLocalizationInfos(a7_3, element);
			}
		}
	)
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 2102, 2107);
	}
	
;

parse_org_emftext_language_xpath2_OrExpr returns [org.emftext.language.xpath2.OrExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_AndExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createOrExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					addObjectToList(element, org.emftext.language.xpath2.XPath2Package.OR_EXPR__OPERAND, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_5_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 2108, 2114);
	}
	
	(
		(
			a1 = 'or' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createOrExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_5_0_0_1_0_0_1, null, true);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getOrExpr(), 2115, 2202);
			}
			
			(
				a2_0 = parse_org_emftext_language_xpath2_AndExpr				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createOrExpr();
						startIncompleteElement(element);
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							Object value = a2_0;
							addObjectToList(element, org.emftext.language.xpath2.XPath2Package.OR_EXPR__OPERAND, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_5_0_0_1_0_0_3, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				// We've found the last token for this rule. The constructed EObject is now
				// complete.
				completedElement(element, true);
				addExpectedElement(null, 2203, 2209);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 2210, 2216);
	}
	
;

parse_org_emftext_language_xpath2_AndExpr returns [org.emftext.language.xpath2.AndExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_ComparisonExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createAndExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					addObjectToList(element, org.emftext.language.xpath2.XPath2Package.AND_EXPR__OPERAND, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_6_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 2217, 2224);
	}
	
	(
		(
			a1 = 'and' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createAndExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_6_0_0_1_0_0_1, null, true);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAndExpr(), 2225, 2312);
			}
			
			(
				a2_0 = parse_org_emftext_language_xpath2_ComparisonExpr				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createAndExpr();
						startIncompleteElement(element);
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							Object value = a2_0;
							addObjectToList(element, org.emftext.language.xpath2.XPath2Package.AND_EXPR__OPERAND, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_6_0_0_1_0_0_3, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				// We've found the last token for this rule. The constructed EObject is now
				// complete.
				completedElement(element, true);
				addExpectedElement(null, 2313, 2320);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 2321, 2328);
	}
	
;

parse_org_emftext_language_xpath2_ComparisonExpr returns [org.emftext.language.xpath2.ComparisonExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_RangeExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createComparisonExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.COMPARISON_EXPR__LEFT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_7_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 2329, 2331);
		addExpectedElement(null, 2332, 2339);
	}
	
	(
		(
			(
				a1_0 = parse_org_emftext_language_xpath2_Comp				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createComparisonExpr();
						startIncompleteElement(element);
					}
					if (a1_0 != null) {
						if (a1_0 != null) {
							Object value = a1_0;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.COMPARISON_EXPR__OPERATOR), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_7_0_0_1_0_0_1, a1_0, true);
						copyLocalizationInfos(a1_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 2340, 2427);
			}
			
			(
				a2_0 = parse_org_emftext_language_xpath2_RangeExpr				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createComparisonExpr();
						startIncompleteElement(element);
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							Object value = a2_0;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.COMPARISON_EXPR__RIGHT), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_7_0_0_1_0_0_3, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				// We've found the last token for this rule. The constructed EObject is now
				// complete.
				completedElement(element, true);
				addExpectedElement(null, 2428, 2435);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 2436, 2443);
	}
	
;

parse_org_emftext_language_xpath2_RangeExpr returns [org.emftext.language.xpath2.RangeExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_AdditiveExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createRangeExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.RANGE_EXPR__FROM), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_8_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 2444, 2450);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 2451, 2453);
		addExpectedElement(null, 2454, 2455);
	}
	
	(
		(
			a1 = 'to' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createRangeExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_8_0_0_1_0_0_1, null, true);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getRangeExpr(), 2456, 2543);
			}
			
			(
				a2_0 = parse_org_emftext_language_xpath2_AdditiveExpr				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createRangeExpr();
						startIncompleteElement(element);
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							Object value = a2_0;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.RANGE_EXPR__TO), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_8_0_0_1_0_0_3, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				// We've found the last token for this rule. The constructed EObject is now
				// complete.
				completedElement(element, true);
				addExpectedElement(null, 2544, 2549);
				addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 2550, 2552);
				addExpectedElement(null, 2553, 2554);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 2555, 2560);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 2561, 2563);
		addExpectedElement(null, 2564, 2565);
	}
	
;

parse_org_emftext_language_xpath2_GeneralComp returns [org.emftext.language.xpath2.GeneralComp element = null]
@init{
}
:
	(
		(
			a0 = '=' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createGeneralComp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_9_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralCompKind().getEEnumLiteral(org.emftext.language.xpath2.GeneralCompKind.EQ_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.GENERAL_COMP__OPERATOR), value);
				completedElement(value, false);
			}
			|			a1 = '!=' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createGeneralComp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_9_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralCompKind().getEEnumLiteral(org.emftext.language.xpath2.GeneralCompKind.NE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.GENERAL_COMP__OPERATOR), value);
				completedElement(value, false);
			}
			|			a2 = '<' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createGeneralComp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_9_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a2, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralCompKind().getEEnumLiteral(org.emftext.language.xpath2.GeneralCompKind.LT_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.GENERAL_COMP__OPERATOR), value);
				completedElement(value, false);
			}
			|			a3 = '<=' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createGeneralComp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_9_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a3, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralCompKind().getEEnumLiteral(org.emftext.language.xpath2.GeneralCompKind.LE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.GENERAL_COMP__OPERATOR), value);
				completedElement(value, false);
			}
			|			a4 = '>' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createGeneralComp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_9_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a4, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralCompKind().getEEnumLiteral(org.emftext.language.xpath2.GeneralCompKind.GT_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.GENERAL_COMP__OPERATOR), value);
				completedElement(value, false);
			}
			|			a5 = '>=' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createGeneralComp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_9_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a5, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralCompKind().getEEnumLiteral(org.emftext.language.xpath2.GeneralCompKind.GE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.GENERAL_COMP__OPERATOR), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 2566, 2653);
	}
	
;

parse_org_emftext_language_xpath2_ValueComp returns [org.emftext.language.xpath2.ValueComp element = null]
@init{
}
:
	(
		(
			a0 = 'eq' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createValueComp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_10_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralCompKind().getEEnumLiteral(org.emftext.language.xpath2.GeneralCompKind.EQ_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.VALUE_COMP__OPERATOR), value);
				completedElement(value, false);
			}
			|			a1 = 'ne' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createValueComp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_10_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralCompKind().getEEnumLiteral(org.emftext.language.xpath2.GeneralCompKind.NE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.VALUE_COMP__OPERATOR), value);
				completedElement(value, false);
			}
			|			a2 = 'lt' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createValueComp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_10_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a2, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralCompKind().getEEnumLiteral(org.emftext.language.xpath2.GeneralCompKind.LT_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.VALUE_COMP__OPERATOR), value);
				completedElement(value, false);
			}
			|			a3 = 'le' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createValueComp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_10_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a3, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralCompKind().getEEnumLiteral(org.emftext.language.xpath2.GeneralCompKind.LE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.VALUE_COMP__OPERATOR), value);
				completedElement(value, false);
			}
			|			a4 = 'gt' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createValueComp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_10_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a4, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralCompKind().getEEnumLiteral(org.emftext.language.xpath2.GeneralCompKind.GT_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.VALUE_COMP__OPERATOR), value);
				completedElement(value, false);
			}
			|			a5 = 'ge' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createValueComp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_10_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a5, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralCompKind().getEEnumLiteral(org.emftext.language.xpath2.GeneralCompKind.GE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.VALUE_COMP__OPERATOR), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 2654, 2741);
	}
	
;

parse_org_emftext_language_xpath2_NodeComp returns [org.emftext.language.xpath2.NodeComp element = null]
@init{
}
:
	(
		(
			a0 = 'is' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createNodeComp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_11_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getNodeCompKind().getEEnumLiteral(org.emftext.language.xpath2.NodeCompKind.IS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.NODE_COMP__OPERATOR), value);
				completedElement(value, false);
			}
			|			a1 = '<<' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createNodeComp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_11_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getNodeCompKind().getEEnumLiteral(org.emftext.language.xpath2.NodeCompKind.PRECEDES_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.NODE_COMP__OPERATOR), value);
				completedElement(value, false);
			}
			|			a2 = '>>' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createNodeComp();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_11_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a2, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getNodeCompKind().getEEnumLiteral(org.emftext.language.xpath2.NodeCompKind.FOLLOWS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.NODE_COMP__OPERATOR), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 2742, 2829);
	}
	
;

parse_org_emftext_language_xpath2_AdditiveExpr returns [org.emftext.language.xpath2.AdditiveExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_MultiplicativeExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createAdditiveExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					addObjectToList(element, org.emftext.language.xpath2.XPath2Package.ADDITIVE_EXPR__OPERAND, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_12_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 2830, 2837);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 2838, 2840);
		addExpectedElement(null, 2841, 2842);
	}
	
	(
		(
			(
				(
					a1 = '+' {
						if (element == null) {
							element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createAdditiveExpr();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_12_0_0_1_0_0_1, null, true);
						copyLocalizationInfos((CommonToken)a1, element);
						// set value of enumeration attribute
						Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAdditiveOpKind().getEEnumLiteral(org.emftext.language.xpath2.AdditiveOpKind.ADDITION_VALUE).getInstance();
						addObjectToList(element, org.emftext.language.xpath2.XPath2Package.ADDITIVE_EXPR__OPERATOR, value);
						completedElement(value, false);
					}
					|					a2 = '-' {
						if (element == null) {
							element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createAdditiveExpr();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_12_0_0_1_0_0_1, null, true);
						copyLocalizationInfos((CommonToken)a2, element);
						// set value of enumeration attribute
						Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAdditiveOpKind().getEEnumLiteral(org.emftext.language.xpath2.AdditiveOpKind.SUBTRACTION_VALUE).getInstance();
						addObjectToList(element, org.emftext.language.xpath2.XPath2Package.ADDITIVE_EXPR__OPERATOR, value);
						completedElement(value, false);
					}
				)
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAdditiveExpr(), 2843, 2930);
			}
			
			(
				a5_0 = parse_org_emftext_language_xpath2_MultiplicativeExpr				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createAdditiveExpr();
						startIncompleteElement(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							addObjectToList(element, org.emftext.language.xpath2.XPath2Package.ADDITIVE_EXPR__OPERAND, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_12_0_0_1_0_0_3, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				// We've found the last token for this rule. The constructed EObject is now
				// complete.
				completedElement(element, true);
				addExpectedElement(null, 2931, 2938);
				addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 2939, 2941);
				addExpectedElement(null, 2942, 2943);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 2944, 2951);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 2952, 2954);
		addExpectedElement(null, 2955, 2956);
	}
	
;

parse_org_emftext_language_xpath2_MultiplicativeExpr returns [org.emftext.language.xpath2.MultiplicativeExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_UnionExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createMultiplicativeExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					addObjectToList(element, org.emftext.language.xpath2.XPath2Package.MULTIPLICATIVE_EXPR__OPERAND, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_13_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 2957, 2965);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 2966, 2968);
		addExpectedElement(null, 2969, 2970);
	}
	
	(
		(
			(
				(
					a1 = '*' {
						if (element == null) {
							element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createMultiplicativeExpr();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_13_0_0_1_0_0_1, null, true);
						copyLocalizationInfos((CommonToken)a1, element);
						// set value of enumeration attribute
						Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getMultiplicativeOpKind().getEEnumLiteral(org.emftext.language.xpath2.MultiplicativeOpKind.MULTIPLICATION_VALUE).getInstance();
						addObjectToList(element, org.emftext.language.xpath2.XPath2Package.MULTIPLICATIVE_EXPR__OPERATOR, value);
						completedElement(value, false);
					}
					|					a2 = 'div' {
						if (element == null) {
							element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createMultiplicativeExpr();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_13_0_0_1_0_0_1, null, true);
						copyLocalizationInfos((CommonToken)a2, element);
						// set value of enumeration attribute
						Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getMultiplicativeOpKind().getEEnumLiteral(org.emftext.language.xpath2.MultiplicativeOpKind.DIV_VALUE).getInstance();
						addObjectToList(element, org.emftext.language.xpath2.XPath2Package.MULTIPLICATIVE_EXPR__OPERATOR, value);
						completedElement(value, false);
					}
					|					a3 = 'idiv' {
						if (element == null) {
							element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createMultiplicativeExpr();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_13_0_0_1_0_0_1, null, true);
						copyLocalizationInfos((CommonToken)a3, element);
						// set value of enumeration attribute
						Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getMultiplicativeOpKind().getEEnumLiteral(org.emftext.language.xpath2.MultiplicativeOpKind.IDIV_VALUE).getInstance();
						addObjectToList(element, org.emftext.language.xpath2.XPath2Package.MULTIPLICATIVE_EXPR__OPERATOR, value);
						completedElement(value, false);
					}
					|					a4 = 'mod' {
						if (element == null) {
							element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createMultiplicativeExpr();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_13_0_0_1_0_0_1, null, true);
						copyLocalizationInfos((CommonToken)a4, element);
						// set value of enumeration attribute
						Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getMultiplicativeOpKind().getEEnumLiteral(org.emftext.language.xpath2.MultiplicativeOpKind.MOD_VALUE).getInstance();
						addObjectToList(element, org.emftext.language.xpath2.XPath2Package.MULTIPLICATIVE_EXPR__OPERATOR, value);
						completedElement(value, false);
					}
				)
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getMultiplicativeExpr(), 2971, 3058);
			}
			
			(
				a7_0 = parse_org_emftext_language_xpath2_UnionExpr				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createMultiplicativeExpr();
						startIncompleteElement(element);
					}
					if (a7_0 != null) {
						if (a7_0 != null) {
							Object value = a7_0;
							addObjectToList(element, org.emftext.language.xpath2.XPath2Package.MULTIPLICATIVE_EXPR__OPERAND, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_13_0_0_1_0_0_3, a7_0, true);
						copyLocalizationInfos(a7_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				// We've found the last token for this rule. The constructed EObject is now
				// complete.
				completedElement(element, true);
				addExpectedElement(null, 3059, 3067);
				addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 3068, 3070);
				addExpectedElement(null, 3071, 3072);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 3073, 3081);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 3082, 3084);
		addExpectedElement(null, 3085, 3086);
	}
	
;

parse_org_emftext_language_xpath2_UnionExpr returns [org.emftext.language.xpath2.UnionExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_IntersectExceptExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createUnionExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					addObjectToList(element, org.emftext.language.xpath2.XPath2Package.UNION_EXPR__OPERAND, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_14_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 3087, 3096);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 3097, 3099);
		addExpectedElement(null, 3100, 3101);
	}
	
	(
		(
			(
				(
					a1 = 'union' {
						if (element == null) {
							element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createUnionExpr();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_14_0_0_1_0_0_1, null, true);
						copyLocalizationInfos((CommonToken)a1, element);
						// set value of enumeration attribute
						Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getUnionOp().getEEnumLiteral(org.emftext.language.xpath2.UnionOp.UNION_VALUE).getInstance();
						addObjectToList(element, org.emftext.language.xpath2.XPath2Package.UNION_EXPR__OPERATION, value);
						completedElement(value, false);
					}
					|					a2 = '|' {
						if (element == null) {
							element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createUnionExpr();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_14_0_0_1_0_0_1, null, true);
						copyLocalizationInfos((CommonToken)a2, element);
						// set value of enumeration attribute
						Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getUnionOp().getEEnumLiteral(org.emftext.language.xpath2.UnionOp.VERTICAL_BAR_VALUE).getInstance();
						addObjectToList(element, org.emftext.language.xpath2.XPath2Package.UNION_EXPR__OPERATION, value);
						completedElement(value, false);
					}
				)
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getUnionExpr(), 3102, 3189);
			}
			
			(
				a5_0 = parse_org_emftext_language_xpath2_IntersectExceptExpr				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createUnionExpr();
						startIncompleteElement(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							addObjectToList(element, org.emftext.language.xpath2.XPath2Package.UNION_EXPR__OPERAND, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_14_0_0_1_0_0_3, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				// We've found the last token for this rule. The constructed EObject is now
				// complete.
				completedElement(element, true);
				addExpectedElement(null, 3190, 3199);
				addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 3200, 3202);
				addExpectedElement(null, 3203, 3204);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 3205, 3214);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 3215, 3217);
		addExpectedElement(null, 3218, 3219);
	}
	
;

parse_org_emftext_language_xpath2_IntersectExceptExpr returns [org.emftext.language.xpath2.IntersectExceptExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_InstanceofExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createIntersectExceptExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					addObjectToList(element, org.emftext.language.xpath2.XPath2Package.INTERSECT_EXCEPT_EXPR__OPERAND, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_15_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 3220, 3230);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 3231, 3233);
		addExpectedElement(null, 3234, 3235);
	}
	
	(
		(
			(
				(
					a1 = 'intersect' {
						if (element == null) {
							element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createIntersectExceptExpr();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_15_0_0_1_0_0_1, null, true);
						copyLocalizationInfos((CommonToken)a1, element);
						// set value of enumeration attribute
						Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIntersectExceptOpKind().getEEnumLiteral(org.emftext.language.xpath2.IntersectExceptOpKind.INTERSECT_VALUE).getInstance();
						addObjectToList(element, org.emftext.language.xpath2.XPath2Package.INTERSECT_EXCEPT_EXPR__OPERATOR, value);
						completedElement(value, false);
					}
					|					a2 = 'except' {
						if (element == null) {
							element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createIntersectExceptExpr();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_15_0_0_1_0_0_1, null, true);
						copyLocalizationInfos((CommonToken)a2, element);
						// set value of enumeration attribute
						Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIntersectExceptOpKind().getEEnumLiteral(org.emftext.language.xpath2.IntersectExceptOpKind.EXCEPT_VALUE).getInstance();
						addObjectToList(element, org.emftext.language.xpath2.XPath2Package.INTERSECT_EXCEPT_EXPR__OPERATOR, value);
						completedElement(value, false);
					}
				)
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getIntersectExceptExpr(), 3236, 3323);
			}
			
			(
				a5_0 = parse_org_emftext_language_xpath2_InstanceofExpr				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createIntersectExceptExpr();
						startIncompleteElement(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							addObjectToList(element, org.emftext.language.xpath2.XPath2Package.INTERSECT_EXCEPT_EXPR__OPERAND, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_15_0_0_1_0_0_3, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				// We've found the last token for this rule. The constructed EObject is now
				// complete.
				completedElement(element, true);
				addExpectedElement(null, 3324, 3334);
				addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 3335, 3337);
				addExpectedElement(null, 3338, 3339);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 3340, 3350);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 3351, 3353);
		addExpectedElement(null, 3354, 3355);
	}
	
;

parse_org_emftext_language_xpath2_InstanceofExpr returns [org.emftext.language.xpath2.InstanceofExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_TreatExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createInstanceofExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.INSTANCEOF_EXPR__OPERAND), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_16_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 3356, 3367);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 3368, 3370);
		addExpectedElement(null, 3371, 3372);
	}
	
	(
		(
			a1 = 'instance' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createInstanceofExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_16_0_0_1_0_0_1, null, true);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, 3373);
			}
			
			a2 = 'of' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createInstanceofExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_16_0_0_1_0_0_2, null, true);
				copyLocalizationInfos((CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getInstanceofExpr(), 3374, 3392);
			}
			
			(
				a3_0 = parse_org_emftext_language_xpath2_SequenceType				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createInstanceofExpr();
						startIncompleteElement(element);
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							Object value = a3_0;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.INSTANCEOF_EXPR__TYPE), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_16_0_0_1_0_0_3, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				// We've found the last token for this rule. The constructed EObject is now
				// complete.
				completedElement(element, true);
				addExpectedElement(null, 3393, 3403);
				addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 3404, 3406);
				addExpectedElement(null, 3407, 3408);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 3409, 3419);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 3420, 3422);
		addExpectedElement(null, 3423, 3424);
	}
	
;

parse_org_emftext_language_xpath2_TreatExpr returns [org.emftext.language.xpath2.TreatExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_CastableExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createTreatExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.TREAT_EXPR__OPERAND), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_17_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 3425, 3437);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 3438, 3440);
		addExpectedElement(null, 3441, 3442);
	}
	
	(
		(
			a1 = 'treat' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createTreatExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_17_0_0_1_0_0_1, null, true);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, 3443);
			}
			
			a2 = 'as' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createTreatExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_17_0_0_1_0_0_2, null, true);
				copyLocalizationInfos((CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getTreatExpr(), 3444, 3462);
			}
			
			(
				a3_0 = parse_org_emftext_language_xpath2_SequenceType				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createTreatExpr();
						startIncompleteElement(element);
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							Object value = a3_0;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.TREAT_EXPR__TYPE), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_17_0_0_1_0_0_3, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				// We've found the last token for this rule. The constructed EObject is now
				// complete.
				completedElement(element, true);
				addExpectedElement(null, 3463, 3474);
				addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 3475, 3477);
				addExpectedElement(null, 3478, 3479);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 3480, 3491);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 3492, 3494);
		addExpectedElement(null, 3495, 3496);
	}
	
;

parse_org_emftext_language_xpath2_CastableExpr returns [org.emftext.language.xpath2.CastableExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_CastExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createCastableExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.CASTABLE_EXPR__OPERAND), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_18_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 3497, 3510);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 3511, 3513);
		addExpectedElement(null, 3514, 3515);
	}
	
	(
		(
			a1 = 'castable' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createCastableExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_18_0_0_1_0_0_1, null, true);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, 3516);
			}
			
			a2 = 'as' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createCastableExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_18_0_0_1_0_0_2, null, true);
				copyLocalizationInfos((CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getCastableExpr(), 3517, 3518);
			}
			
			(
				a3_0 = parse_org_emftext_language_xpath2_SingleType				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createCastableExpr();
						startIncompleteElement(element);
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							Object value = a3_0;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.CASTABLE_EXPR__TYPE), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_18_0_0_1_0_0_3, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				// We've found the last token for this rule. The constructed EObject is now
				// complete.
				completedElement(element, true);
				addExpectedElement(null, 3519, 3531);
				addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 3532, 3534);
				addExpectedElement(null, 3535, 3536);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 3537, 3549);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 3550, 3552);
		addExpectedElement(null, 3553, 3554);
	}
	
;

parse_org_emftext_language_xpath2_CastExpr returns [org.emftext.language.xpath2.CastExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_UnaryExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createCastExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.CAST_EXPR__OPERAND), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_19_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 3555, 3569);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 3570, 3572);
		addExpectedElement(null, 3573, 3574);
	}
	
	(
		(
			a1 = 'cast' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createCastExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_19_0_0_1_0_0_1, null, true);
				copyLocalizationInfos((CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, 3575);
			}
			
			a2 = 'as' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createCastExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_19_0_0_1_0_0_2, null, true);
				copyLocalizationInfos((CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getCastExpr(), 3576, 3577);
			}
			
			(
				a3_0 = parse_org_emftext_language_xpath2_SingleType				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createCastExpr();
						startIncompleteElement(element);
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							Object value = a3_0;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.CAST_EXPR__TYPE), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_19_0_0_1_0_0_3, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				// We've found the last token for this rule. The constructed EObject is now
				// complete.
				completedElement(element, true);
				addExpectedElement(null, 3578, 3591);
				addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 3592, 3594);
				addExpectedElement(null, 3595, 3596);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 3597, 3610);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 3611, 3613);
		addExpectedElement(null, 3614, 3615);
	}
	
;

parse_org_emftext_language_xpath2_UnaryExpr returns [org.emftext.language.xpath2.UnaryExpr element = null]
@init{
}
:
	(
		(
			(
				a0 = '+' {
					if (element == null) {
						element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createUnaryExpr();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_20_0_0_0, null, true);
					copyLocalizationInfos((CommonToken)a0, element);
					// set value of enumeration attribute
					Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getUnaryOp().getEEnumLiteral(org.emftext.language.xpath2.UnaryOp.PLUS_VALUE).getInstance();
					addObjectToList(element, org.emftext.language.xpath2.XPath2Package.UNARY_EXPR__OPERATOR, value);
					completedElement(value, false);
				}
				|				a1 = '-' {
					if (element == null) {
						element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createUnaryExpr();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_20_0_0_0, null, true);
					copyLocalizationInfos((CommonToken)a1, element);
					// set value of enumeration attribute
					Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getUnaryOp().getEEnumLiteral(org.emftext.language.xpath2.UnaryOp.MINUS_VALUE).getInstance();
					addObjectToList(element, org.emftext.language.xpath2.XPath2Package.UNARY_EXPR__OPERATOR, value);
					completedElement(value, false);
				}
			)
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, 3616);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getUnaryExpr(), 3617, 3703);
	}
	
	(
		a4_0 = parse_org_emftext_language_xpath2_ValueExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createUnaryExpr();
				startIncompleteElement(element);
			}
			if (a4_0 != null) {
				if (a4_0 != null) {
					Object value = a4_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.UNARY_EXPR__OPERAND), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_20_0_0_1, a4_0, true);
				copyLocalizationInfos(a4_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 3704, 3718);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 3719, 3721);
		addExpectedElement(null, 3722, 3723);
	}
	
;

parse_org_emftext_language_xpath2_FilterExpr returns [org.emftext.language.xpath2.FilterExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_PrimaryExpr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createFilterExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.FILTER_EXPR__PRIMARY_EXPR), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_21_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getFilterExpr(), 3724);
		addExpectedElement(null, 3725, 3730);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 3731, 3732);
		addExpectedElement(null, 3733, 3741);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 3742, 3744);
		addExpectedElement(null, 3745, 3746);
	}
	
	(
		(
			a1_0 = parse_org_emftext_language_xpath2_Predicate			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createFilterExpr();
					startIncompleteElement(element);
				}
				if (a1_0 != null) {
					if (a1_0 != null) {
						Object value = a1_0;
						addObjectToList(element, org.emftext.language.xpath2.XPath2Package.FILTER_EXPR__PREDICATE, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_21_0_0_1, a1_0, true);
					copyLocalizationInfos(a1_0, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getFilterExpr(), 3747);
		addExpectedElement(null, 3748, 3753);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 3754, 3755);
		addExpectedElement(null, 3756, 3764);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 3765, 3767);
		addExpectedElement(null, 3768, 3769);
	}
	
;

parse_org_emftext_language_xpath2_FunctionCall returns [org.emftext.language.xpath2.FunctionCall element = null]
@init{
}
:
	(
		(
			a0 = QNAME			
			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createFunctionCall();
					startIncompleteElement(element);
				}
				if (a0 != null) {
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QNAME");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.FUNCTION_CALL__NAME), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
					}
					javax.xml.namespace.QName resolved = (javax.xml.namespace.QName) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.FUNCTION_CALL__NAME), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_22_0_0_0_0_0_0, resolved, true);
					copyLocalizationInfos((CommonToken) a0, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, 3770);
		}
		
		
		|		(
			a1 = NCNAME			
			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createFunctionCall();
					startIncompleteElement(element);
				}
				if (a1 != null) {
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NCNAME");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.FUNCTION_CALL__NAME), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
					}
					javax.xml.namespace.QName resolved = (javax.xml.namespace.QName) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.FUNCTION_CALL__NAME), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_22_0_0_0_0_1_0, resolved, true);
					copyLocalizationInfos((CommonToken) a1, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, 3771);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 3772);
	}
	
	a2 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createFunctionCall();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_22_0_0_1, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getFunctionCall(), 3773, 3863);
		addExpectedElement(null, 3864);
	}
	
	(
		(
			(
				a3_0 = parse_org_emftext_language_xpath2_IfExpr				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createFunctionCall();
						startIncompleteElement(element);
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							Object value = a3_0;
							addObjectToList(element, org.emftext.language.xpath2.XPath2Package.FUNCTION_CALL__ARG, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_22_0_0_2_0_0_0, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
				|				a3_1 = parse_org_emftext_language_xpath2_ForExpr				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createFunctionCall();
						startIncompleteElement(element);
					}
					if (a3_1 != null) {
						if (a3_1 != null) {
							Object value = a3_1;
							addObjectToList(element, org.emftext.language.xpath2.XPath2Package.FUNCTION_CALL__ARG, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_22_0_0_2_0_0_0, a3_1, true);
						copyLocalizationInfos(a3_1, element);
					}
				}
				|				a3_2 = parse_org_emftext_language_xpath2_QuantifiedExpr				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createFunctionCall();
						startIncompleteElement(element);
					}
					if (a3_2 != null) {
						if (a3_2 != null) {
							Object value = a3_2;
							addObjectToList(element, org.emftext.language.xpath2.XPath2Package.FUNCTION_CALL__ARG, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_22_0_0_2_0_0_0, a3_2, true);
						copyLocalizationInfos(a3_2, element);
					}
				}
				|				a3_3 = parse_org_emftext_language_xpath2_OrExpr				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createFunctionCall();
						startIncompleteElement(element);
					}
					if (a3_3 != null) {
						if (a3_3 != null) {
							Object value = a3_3;
							addObjectToList(element, org.emftext.language.xpath2.XPath2Package.FUNCTION_CALL__ARG, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_22_0_0_2_0_0_0, a3_3, true);
						copyLocalizationInfos(a3_3, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, 3865, 3866);
			}
			
			(
				(
					a4 = ',' {
						if (element == null) {
							element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createFunctionCall();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_22_0_0_2_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((CommonToken)a4, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getFunctionCall(), 3867, 3957);
					}
					
					(
						a5_0 = parse_org_emftext_language_xpath2_IfExpr						{
							if (terminateParsing) {
								throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createFunctionCall();
								startIncompleteElement(element);
							}
							if (a5_0 != null) {
								if (a5_0 != null) {
									Object value = a5_0;
									addObjectToList(element, org.emftext.language.xpath2.XPath2Package.FUNCTION_CALL__ARG, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_22_0_0_2_0_0_1_0_0_2, a5_0, true);
								copyLocalizationInfos(a5_0, element);
							}
						}
						|						a5_1 = parse_org_emftext_language_xpath2_ForExpr						{
							if (terminateParsing) {
								throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createFunctionCall();
								startIncompleteElement(element);
							}
							if (a5_1 != null) {
								if (a5_1 != null) {
									Object value = a5_1;
									addObjectToList(element, org.emftext.language.xpath2.XPath2Package.FUNCTION_CALL__ARG, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_22_0_0_2_0_0_1_0_0_2, a5_1, true);
								copyLocalizationInfos(a5_1, element);
							}
						}
						|						a5_2 = parse_org_emftext_language_xpath2_QuantifiedExpr						{
							if (terminateParsing) {
								throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createFunctionCall();
								startIncompleteElement(element);
							}
							if (a5_2 != null) {
								if (a5_2 != null) {
									Object value = a5_2;
									addObjectToList(element, org.emftext.language.xpath2.XPath2Package.FUNCTION_CALL__ARG, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_22_0_0_2_0_0_1_0_0_2, a5_2, true);
								copyLocalizationInfos(a5_2, element);
							}
						}
						|						a5_3 = parse_org_emftext_language_xpath2_OrExpr						{
							if (terminateParsing) {
								throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
							}
							if (element == null) {
								element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createFunctionCall();
								startIncompleteElement(element);
							}
							if (a5_3 != null) {
								if (a5_3 != null) {
									Object value = a5_3;
									addObjectToList(element, org.emftext.language.xpath2.XPath2Package.FUNCTION_CALL__ARG, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_22_0_0_2_0_0_1_0_0_2, a5_3, true);
								copyLocalizationInfos(a5_3, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, 3958, 3959);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, 3960, 3961);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, 3962);
	}
	
	a6 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createFunctionCall();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_22_0_0_3, null, true);
		copyLocalizationInfos((CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 3963, 3968);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getFilterExpr(), 3969);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 3970, 3971);
		addExpectedElement(null, 3972, 3980);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 3981, 3983);
		addExpectedElement(null, 3984, 3985);
	}
	
;

parse_org_emftext_language_xpath2_PathExpr returns [org.emftext.language.xpath2.PathExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_PathExprChild		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createPathExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					addObjectToList(element, org.emftext.language.xpath2.XPath2Package.PATH_EXPR__STEP, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_23_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 3986, 3987);
		addExpectedElement(null, 3988, 4002);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 4003, 4005);
		addExpectedElement(null, 4006, 4007);
	}
	
	(
		(
			a1_0 = parse_org_emftext_language_xpath2_ChildStepExpr			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createPathExpr();
					startIncompleteElement(element);
				}
				if (a1_0 != null) {
					if (a1_0 != null) {
						Object value = a1_0;
						addObjectToList(element, org.emftext.language.xpath2.XPath2Package.PATH_EXPR__STEP, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_23_0_0_1, a1_0, true);
					copyLocalizationInfos(a1_0, element);
				}
			}
			|			a1_1 = parse_org_emftext_language_xpath2_DescOrSelfStepExpr			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createPathExpr();
					startIncompleteElement(element);
				}
				if (a1_1 != null) {
					if (a1_1 != null) {
						Object value = a1_1;
						addObjectToList(element, org.emftext.language.xpath2.XPath2Package.PATH_EXPR__STEP, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_23_0_0_1, a1_1, true);
					copyLocalizationInfos(a1_1, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 4008, 4009);
		addExpectedElement(null, 4010, 4024);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 4025, 4027);
		addExpectedElement(null, 4028, 4029);
	}
	
;

parse_org_emftext_language_xpath2_ChildStepExpr returns [org.emftext.language.xpath2.ChildStepExpr element = null]
@init{
}
:
	a0 = '/' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createChildStepExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_24_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getChildStepExpr(), 4030, 4071);
	}
	
	(
		a1_0 = parse_org_emftext_language_xpath2_StepExprChild		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createChildStepExpr();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.CHILD_STEP_EXPR__STEP), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_24_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 4072, 4077);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 4078, 4079);
		addExpectedElement(null, 4080, 4088);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 4089, 4091);
		addExpectedElement(null, 4092, 4093);
	}
	
;

parse_org_emftext_language_xpath2_DescOrSelfStepExpr returns [org.emftext.language.xpath2.DescOrSelfStepExpr element = null]
@init{
}
:
	a0 = '//' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createDescOrSelfStepExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_25_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getDescOrSelfStepExpr(), 4094, 4135);
	}
	
	(
		a1_0 = parse_org_emftext_language_xpath2_StepExprChild		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createDescOrSelfStepExpr();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.DESC_OR_SELF_STEP_EXPR__STEP), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_25_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 4136, 4141);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 4142, 4143);
		addExpectedElement(null, 4144, 4152);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 4153, 4155);
		addExpectedElement(null, 4156, 4157);
	}
	
;

parse_org_emftext_language_xpath2_RootStepExpr returns [org.emftext.language.xpath2.RootStepExpr element = null]
@init{
}
:
	a0 = '/' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createRootStepExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_26_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 4158, 4163);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 4164, 4165);
		addExpectedElement(null, 4166, 4174);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 4175, 4177);
		addExpectedElement(null, 4178, 4179);
	}
	
;

parse_org_emftext_language_xpath2_SelfStepExpr returns [org.emftext.language.xpath2.SelfStepExpr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_StepExprChild		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createSelfStepExpr();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.SELF_STEP_EXPR__STEP), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_27_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 4180, 4185);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 4186, 4187);
		addExpectedElement(null, 4188, 4196);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 4197, 4199);
		addExpectedElement(null, 4200, 4201);
	}
	
;

parse_org_emftext_language_xpath2_GeneralForwardStep returns [org.emftext.language.xpath2.GeneralForwardStep element = null]
@init{
}
:
	(
		(
			a0 = 'child' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createGeneralForwardStep();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_28_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getForwardAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ForwardAxisKind.CHILD_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.GENERAL_FORWARD_STEP__AXIS), value);
				completedElement(value, false);
			}
			|			a1 = 'descendant' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createGeneralForwardStep();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_28_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getForwardAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ForwardAxisKind.DESCENDANT_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.GENERAL_FORWARD_STEP__AXIS), value);
				completedElement(value, false);
			}
			|			a2 = 'attribute' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createGeneralForwardStep();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_28_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a2, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getForwardAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ForwardAxisKind.ATTRIBUTE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.GENERAL_FORWARD_STEP__AXIS), value);
				completedElement(value, false);
			}
			|			a3 = 'self' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createGeneralForwardStep();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_28_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a3, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getForwardAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ForwardAxisKind.SELF_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.GENERAL_FORWARD_STEP__AXIS), value);
				completedElement(value, false);
			}
			|			a4 = 'descendant-or-self' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createGeneralForwardStep();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_28_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a4, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getForwardAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ForwardAxisKind.DESCENDANT_OR_SELF_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.GENERAL_FORWARD_STEP__AXIS), value);
				completedElement(value, false);
			}
			|			a5 = 'following-sibling' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createGeneralForwardStep();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_28_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a5, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getForwardAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ForwardAxisKind.FOLLOWING_SIBLING_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.GENERAL_FORWARD_STEP__AXIS), value);
				completedElement(value, false);
			}
			|			a6 = 'following' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createGeneralForwardStep();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_28_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a6, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getForwardAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ForwardAxisKind.FOLLOWING_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.GENERAL_FORWARD_STEP__AXIS), value);
				completedElement(value, false);
			}
			|			a7 = 'namespace' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createGeneralForwardStep();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_28_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a7, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getForwardAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ForwardAxisKind.NAMESPACE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.GENERAL_FORWARD_STEP__AXIS), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 4202);
	}
	
	a10 = '::' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createGeneralForwardStep();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_28_0_0_1, null, true);
		copyLocalizationInfos((CommonToken)a10, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralForwardStep(), 4203, 4222);
	}
	
	(
		a11_0 = parse_org_emftext_language_xpath2_NodeTest		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createGeneralForwardStep();
				startIncompleteElement(element);
			}
			if (a11_0 != null) {
				if (a11_0 != null) {
					Object value = a11_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.GENERAL_FORWARD_STEP__NODE_TEST), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_28_0_0_2, a11_0, true);
				copyLocalizationInfos(a11_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralForwardStep(), 4223);
		addExpectedElement(null, 4224, 4229);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 4230, 4231);
		addExpectedElement(null, 4232, 4240);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 4241, 4243);
		addExpectedElement(null, 4244, 4245);
	}
	
	(
		(
			a12_0 = parse_org_emftext_language_xpath2_Predicate			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createGeneralForwardStep();
					startIncompleteElement(element);
				}
				if (a12_0 != null) {
					if (a12_0 != null) {
						Object value = a12_0;
						addObjectToList(element, org.emftext.language.xpath2.XPath2Package.GENERAL_FORWARD_STEP__PREDICATE, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_28_0_0_3, a12_0, true);
					copyLocalizationInfos(a12_0, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralForwardStep(), 4246);
		addExpectedElement(null, 4247, 4252);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 4253, 4254);
		addExpectedElement(null, 4255, 4263);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 4264, 4266);
		addExpectedElement(null, 4267, 4268);
	}
	
;

parse_org_emftext_language_xpath2_AbbrevForwardStep returns [org.emftext.language.xpath2.AbbrevForwardStep element = null]
@init{
}
:
	(
		(
			a0 = '@' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createAbbrevForwardStep();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevForwardStepKind().getEEnumLiteral(org.emftext.language.xpath2.AbbrevForwardStepKind.CHILD_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ABBREV_FORWARD_STEP__KIND), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_29_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevForwardStepKind().getEEnumLiteral(org.emftext.language.xpath2.AbbrevForwardStepKind.ATTRIBUTE_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ABBREV_FORWARD_STEP__KIND), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevForwardStep(), 4269, 4288);
	}
	
	(
		a3_0 = parse_org_emftext_language_xpath2_NodeTest		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createAbbrevForwardStep();
				startIncompleteElement(element);
				// initialize enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevForwardStepKind().getEEnumLiteral(org.emftext.language.xpath2.AbbrevForwardStepKind.CHILD_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ABBREV_FORWARD_STEP__KIND), value);
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					Object value = a3_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ABBREV_FORWARD_STEP__NODE_TEST), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_29_0_0_1, a3_0, true);
				copyLocalizationInfos(a3_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevForwardStep(), 4289);
		addExpectedElement(null, 4290, 4295);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 4296, 4297);
		addExpectedElement(null, 4298, 4306);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 4307, 4309);
		addExpectedElement(null, 4310, 4311);
	}
	
	(
		(
			a4_0 = parse_org_emftext_language_xpath2_Predicate			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createAbbrevForwardStep();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevForwardStepKind().getEEnumLiteral(org.emftext.language.xpath2.AbbrevForwardStepKind.CHILD_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ABBREV_FORWARD_STEP__KIND), value);
				}
				if (a4_0 != null) {
					if (a4_0 != null) {
						Object value = a4_0;
						addObjectToList(element, org.emftext.language.xpath2.XPath2Package.ABBREV_FORWARD_STEP__PREDICATE, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_29_0_0_2, a4_0, true);
					copyLocalizationInfos(a4_0, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevForwardStep(), 4312);
		addExpectedElement(null, 4313, 4318);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 4319, 4320);
		addExpectedElement(null, 4321, 4329);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 4330, 4332);
		addExpectedElement(null, 4333, 4334);
	}
	
;

parse_org_emftext_language_xpath2_GeneralReverseStep returns [org.emftext.language.xpath2.GeneralReverseStep element = null]
@init{
}
:
	(
		(
			a0 = 'parent' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createGeneralReverseStep();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_30_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getReverseAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ReverseAxisKind.PARENT_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.GENERAL_REVERSE_STEP__AXIS), value);
				completedElement(value, false);
			}
			|			a1 = 'ancestor' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createGeneralReverseStep();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_30_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getReverseAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ReverseAxisKind.ANCESTOR_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.GENERAL_REVERSE_STEP__AXIS), value);
				completedElement(value, false);
			}
			|			a2 = 'preceding-sibling' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createGeneralReverseStep();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_30_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a2, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getReverseAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ReverseAxisKind.PRECEDING_SIBLING_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.GENERAL_REVERSE_STEP__AXIS), value);
				completedElement(value, false);
			}
			|			a3 = 'preceding' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createGeneralReverseStep();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_30_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a3, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getReverseAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ReverseAxisKind.PRECEDING_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.GENERAL_REVERSE_STEP__AXIS), value);
				completedElement(value, false);
			}
			|			a4 = 'ancestor-or-self' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createGeneralReverseStep();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_30_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a4, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getReverseAxisKind().getEEnumLiteral(org.emftext.language.xpath2.ReverseAxisKind.ANCESTOR_OR_SELF_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.GENERAL_REVERSE_STEP__AXIS), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 4335);
	}
	
	a7 = '::' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createGeneralReverseStep();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_30_0_0_1, null, true);
		copyLocalizationInfos((CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralReverseStep(), 4336, 4355);
	}
	
	(
		a8_0 = parse_org_emftext_language_xpath2_NodeTest		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createGeneralReverseStep();
				startIncompleteElement(element);
			}
			if (a8_0 != null) {
				if (a8_0 != null) {
					Object value = a8_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.GENERAL_REVERSE_STEP__NODE_TEST), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_30_0_0_2, a8_0, true);
				copyLocalizationInfos(a8_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralReverseStep(), 4356);
		addExpectedElement(null, 4357, 4362);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 4363, 4364);
		addExpectedElement(null, 4365, 4373);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 4374, 4376);
		addExpectedElement(null, 4377, 4378);
	}
	
	(
		(
			a9_0 = parse_org_emftext_language_xpath2_Predicate			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createGeneralReverseStep();
					startIncompleteElement(element);
				}
				if (a9_0 != null) {
					if (a9_0 != null) {
						Object value = a9_0;
						addObjectToList(element, org.emftext.language.xpath2.XPath2Package.GENERAL_REVERSE_STEP__PREDICATE, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_30_0_0_3, a9_0, true);
					copyLocalizationInfos(a9_0, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralReverseStep(), 4379);
		addExpectedElement(null, 4380, 4385);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 4386, 4387);
		addExpectedElement(null, 4388, 4396);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 4397, 4399);
		addExpectedElement(null, 4400, 4401);
	}
	
;

parse_org_emftext_language_xpath2_AbbrevReverseStep returns [org.emftext.language.xpath2.AbbrevReverseStep element = null]
@init{
}
:
	(
		(
			a0 = '..' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createAbbrevReverseStep();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_31_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevReverseStepKind().getEEnumLiteral(org.emftext.language.xpath2.AbbrevReverseStepKind.PARENT_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ABBREV_REVERSE_STEP__KIND), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevReverseStep(), 4402);
		addExpectedElement(null, 4403, 4408);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 4409, 4410);
		addExpectedElement(null, 4411, 4419);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 4420, 4422);
		addExpectedElement(null, 4423, 4424);
	}
	
	(
		(
			a3_0 = parse_org_emftext_language_xpath2_Predicate			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createAbbrevReverseStep();
					startIncompleteElement(element);
				}
				if (a3_0 != null) {
					if (a3_0 != null) {
						Object value = a3_0;
						addObjectToList(element, org.emftext.language.xpath2.XPath2Package.ABBREV_REVERSE_STEP__PREDICATE, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_31_0_0_1, a3_0, true);
					copyLocalizationInfos(a3_0, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevReverseStep(), 4425);
		addExpectedElement(null, 4426, 4431);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 4432, 4433);
		addExpectedElement(null, 4434, 4442);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 4443, 4445);
		addExpectedElement(null, 4446, 4447);
	}
	
;

parse_org_emftext_language_xpath2_NodeKindTest returns [org.emftext.language.xpath2.NodeKindTest element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_KindTest		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createNodeKindTest();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.NODE_KIND_TEST__TEST), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_32_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralForwardStep(), 4448);
		addExpectedElement(null, 4449, 4454);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 4455, 4456);
		addExpectedElement(null, 4457, 4465);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 4466, 4468);
		addExpectedElement(null, 4469, 4470);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevForwardStep(), 4471);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralReverseStep(), 4472);
	}
	
;

parse_org_emftext_language_xpath2_QNameTest returns [org.emftext.language.xpath2.QNameTest element = null]
@init{
}
:
	(
		(
			a0 = QNAME			
			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createQNameTest();
					startIncompleteElement(element);
				}
				if (a0 != null) {
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QNAME");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.QNAME_TEST__NAME), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
					}
					javax.xml.namespace.QName resolved = (javax.xml.namespace.QName) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.QNAME_TEST__NAME), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_33_0_0_0_0_0_0, resolved, true);
					copyLocalizationInfos((CommonToken) a0, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralForwardStep(), 4473);
			addExpectedElement(null, 4474, 4479);
			addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 4480, 4481);
			addExpectedElement(null, 4482, 4490);
			addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 4491, 4493);
			addExpectedElement(null, 4494, 4495);
			addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevForwardStep(), 4496);
			addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralReverseStep(), 4497);
		}
		
		
		|		(
			a1 = NCNAME			
			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createQNameTest();
					startIncompleteElement(element);
				}
				if (a1 != null) {
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NCNAME");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.QNAME_TEST__NAME), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
					}
					javax.xml.namespace.QName resolved = (javax.xml.namespace.QName) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.QNAME_TEST__NAME), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_33_0_0_0_0_1_0, resolved, true);
					copyLocalizationInfos((CommonToken) a1, element);
				}
			}
		)
		{
			// expected elements (follow set)
			// We've found the last token for this rule. The constructed EObject is now
			// complete.
			completedElement(element, true);
			addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralForwardStep(), 4498);
			addExpectedElement(null, 4499, 4504);
			addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 4505, 4506);
			addExpectedElement(null, 4507, 4515);
			addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 4516, 4518);
			addExpectedElement(null, 4519, 4520);
			addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevForwardStep(), 4521);
			addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralReverseStep(), 4522);
		}
		
	)
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralForwardStep(), 4523);
		addExpectedElement(null, 4524, 4529);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 4530, 4531);
		addExpectedElement(null, 4532, 4540);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 4541, 4543);
		addExpectedElement(null, 4544, 4545);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevForwardStep(), 4546);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralReverseStep(), 4547);
	}
	
;

parse_org_emftext_language_xpath2_AnyWildcard returns [org.emftext.language.xpath2.AnyWildcard element = null]
@init{
}
:
	a0 = '*' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createAnyWildcard();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_34_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralForwardStep(), 4548);
		addExpectedElement(null, 4549, 4554);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 4555, 4556);
		addExpectedElement(null, 4557, 4565);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 4566, 4568);
		addExpectedElement(null, 4569, 4570);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevForwardStep(), 4571);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralReverseStep(), 4572);
	}
	
;

parse_org_emftext_language_xpath2_LocalNameWildcard returns [org.emftext.language.xpath2.LocalNameWildcard element = null]
@init{
}
:
	(
		a0 = NCNAME		
		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createLocalNameWildcard();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NCNAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.LOCAL_NAME_WILDCARD__NAMESPACE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.LOCAL_NAME_WILDCARD__NAMESPACE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_35_0_0_0, resolved, true);
				copyLocalizationInfos((CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 4573);
	}
	
	a1 = ':' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createLocalNameWildcard();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_35_0_0_1, null, true);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 4574);
	}
	
	a2 = '*' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createLocalNameWildcard();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_35_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralForwardStep(), 4575);
		addExpectedElement(null, 4576, 4581);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 4582, 4583);
		addExpectedElement(null, 4584, 4592);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 4593, 4595);
		addExpectedElement(null, 4596, 4597);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevForwardStep(), 4598);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralReverseStep(), 4599);
	}
	
;

parse_org_emftext_language_xpath2_NamespaceWildcard returns [org.emftext.language.xpath2.NamespaceWildcard element = null]
@init{
}
:
	a0 = '*' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createNamespaceWildcard();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_36_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 4600);
	}
	
	a1 = ':' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createNamespaceWildcard();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_36_0_0_1, null, true);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 4601);
	}
	
	(
		a2 = NCNAME		
		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createNamespaceWildcard();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NCNAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.NAMESPACE_WILDCARD__LOCAL_NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.NAMESPACE_WILDCARD__LOCAL_NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_36_0_0_2, resolved, true);
				copyLocalizationInfos((CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralForwardStep(), 4602);
		addExpectedElement(null, 4603, 4608);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 4609, 4610);
		addExpectedElement(null, 4611, 4619);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 4620, 4622);
		addExpectedElement(null, 4623, 4624);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevForwardStep(), 4625);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralReverseStep(), 4626);
	}
	
;

parse_org_emftext_language_xpath2_Predicate returns [org.emftext.language.xpath2.Predicate element = null]
@init{
}
:
	a0 = '[' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createPredicate();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_37_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPredicate(), 4627, 4717);
	}
	
	(
		a1_0 = parse_org_emftext_language_xpath2_Expr		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createPredicate();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.PREDICATE__EXPR), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_37_0_0_1, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 4718);
	}
	
	a2 = ']' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createPredicate();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_37_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getFilterExpr(), 4719);
		addExpectedElement(null, 4720, 4725);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 4726, 4727);
		addExpectedElement(null, 4728, 4736);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 4737, 4739);
		addExpectedElement(null, 4740, 4741);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralForwardStep(), 4742);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevForwardStep(), 4743);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralReverseStep(), 4744);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevReverseStep(), 4745);
	}
	
;

parse_org_emftext_language_xpath2_VarRef returns [org.emftext.language.xpath2.VarRef element = null]
@init{
}
:
	a0 = '$' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createVarRef();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_38_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 4746, 4747);
	}
	
	(
		(
			a1 = QNAME			
			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createVarRef();
					startIncompleteElement(element);
				}
				if (a1 != null) {
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QNAME");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.VAR_REF__VAR_NAME), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
					}
					javax.xml.namespace.QName resolved = (javax.xml.namespace.QName) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.VAR_REF__VAR_NAME), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_38_0_0_1_0_0_0, resolved, true);
					copyLocalizationInfos((CommonToken) a1, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, 4748, 4753);
			addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getFilterExpr(), 4754);
			addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 4755, 4756);
			addExpectedElement(null, 4757, 4765);
			addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 4766, 4768);
			addExpectedElement(null, 4769, 4770);
		}
		
		
		|		(
			a2 = NCNAME			
			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createVarRef();
					startIncompleteElement(element);
				}
				if (a2 != null) {
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NCNAME");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.VAR_REF__VAR_NAME), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
					}
					javax.xml.namespace.QName resolved = (javax.xml.namespace.QName) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.VAR_REF__VAR_NAME), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_38_0_0_1_0_1_0, resolved, true);
					copyLocalizationInfos((CommonToken) a2, element);
				}
			}
		)
		{
			// expected elements (follow set)
			// We've found the last token for this rule. The constructed EObject is now
			// complete.
			completedElement(element, true);
			addExpectedElement(null, 4771, 4776);
			addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getFilterExpr(), 4777);
			addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 4778, 4779);
			addExpectedElement(null, 4780, 4788);
			addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 4789, 4791);
			addExpectedElement(null, 4792, 4793);
		}
		
	)
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 4794, 4799);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getFilterExpr(), 4800);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 4801, 4802);
		addExpectedElement(null, 4803, 4811);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 4812, 4814);
		addExpectedElement(null, 4815, 4816);
	}
	
;

parse_org_emftext_language_xpath2_ParenthesizedExpr returns [org.emftext.language.xpath2.ParenthesizedExpr element = null]
@init{
}
:
	a0 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createParenthesizedExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_39_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getParenthesizedExpr(), 4817, 4907);
		addExpectedElement(null, 4908);
	}
	
	(
		(
			a1_0 = parse_org_emftext_language_xpath2_Expr			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createParenthesizedExpr();
					startIncompleteElement(element);
				}
				if (a1_0 != null) {
					if (a1_0 != null) {
						Object value = a1_0;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.PARENTHESIZED_EXPR__EXPR), value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_39_0_0_1, a1_0, true);
					copyLocalizationInfos(a1_0, element);
				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, 4909);
	}
	
	a2 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createParenthesizedExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_39_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 4910, 4915);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getFilterExpr(), 4916);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 4917, 4918);
		addExpectedElement(null, 4919, 4927);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 4928, 4930);
		addExpectedElement(null, 4931, 4932);
	}
	
;

parse_org_emftext_language_xpath2_ContextItemExpr returns [org.emftext.language.xpath2.ContextItemExpr element = null]
@init{
}
:
	a0 = '.' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createContextItemExpr();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_40_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 4933, 4938);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getFilterExpr(), 4939);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 4940, 4941);
		addExpectedElement(null, 4942, 4950);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 4951, 4953);
		addExpectedElement(null, 4954, 4955);
	}
	
;

parse_org_emftext_language_xpath2_SingleType returns [org.emftext.language.xpath2.SingleType element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_AtomicType		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createSingleType();
				startIncompleteElement(element);
				// initialize boolean attribute
				{
					Object value = false;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.SINGLE_TYPE__OPTIONAL), value);
				}
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.SINGLE_TYPE__TYPE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_41_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 4956, 4969);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 4970, 4972);
		addExpectedElement(null, 4973, 4974);
	}
	
	(
		(
			a1 = '?' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createSingleType();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.SINGLE_TYPE__OPTIONAL), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_41_0_0_1, true, true);
				copyLocalizationInfos((CommonToken)a1, element);
				// set value of boolean attribute
				Object value = true;
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.SINGLE_TYPE__OPTIONAL), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 4975, 4987);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 4988, 4990);
		addExpectedElement(null, 4991, 4992);
	}
	
;

parse_org_emftext_language_xpath2_EmptySequenceType returns [org.emftext.language.xpath2.EmptySequenceType element = null]
@init{
}
:
	a0 = 'empty-sequence' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createEmptySequenceType();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_42_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 4993);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createEmptySequenceType();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_42_0_0_1, null, true);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 4994);
	}
	
	a2 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createEmptySequenceType();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_42_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 4995, 5005);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 5006, 5008);
		addExpectedElement(null, 5009, 5010);
	}
	
;

parse_org_emftext_language_xpath2_ItemSequenceType returns [org.emftext.language.xpath2.ItemSequenceType element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_ItemType		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createItemSequenceType();
				startIncompleteElement(element);
				// initialize enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getOccurrenceIndicatorKind().getEEnumLiteral(org.emftext.language.xpath2.OccurrenceIndicatorKind.MANDATORY_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ITEM_SEQUENCE_TYPE__OCCURRENCE), value);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ITEM_SEQUENCE_TYPE__ITEM_TYPE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_43_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 5011, 5022);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 5023, 5025);
		addExpectedElement(null, 5026, 5027);
	}
	
	(
		(
			a1 = '?' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createItemSequenceType();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getOccurrenceIndicatorKind().getEEnumLiteral(org.emftext.language.xpath2.OccurrenceIndicatorKind.MANDATORY_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ITEM_SEQUENCE_TYPE__OCCURRENCE), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_43_0_0_1, null, true);
				copyLocalizationInfos((CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getOccurrenceIndicatorKind().getEEnumLiteral(org.emftext.language.xpath2.OccurrenceIndicatorKind.OPTIONAL_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ITEM_SEQUENCE_TYPE__OCCURRENCE), value);
				completedElement(value, false);
			}
			|			a2 = '*' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createItemSequenceType();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getOccurrenceIndicatorKind().getEEnumLiteral(org.emftext.language.xpath2.OccurrenceIndicatorKind.MANDATORY_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ITEM_SEQUENCE_TYPE__OCCURRENCE), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_43_0_0_1, null, true);
				copyLocalizationInfos((CommonToken)a2, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getOccurrenceIndicatorKind().getEEnumLiteral(org.emftext.language.xpath2.OccurrenceIndicatorKind.STAR_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ITEM_SEQUENCE_TYPE__OCCURRENCE), value);
				completedElement(value, false);
			}
			|			a3 = '+' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createItemSequenceType();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getOccurrenceIndicatorKind().getEEnumLiteral(org.emftext.language.xpath2.OccurrenceIndicatorKind.MANDATORY_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ITEM_SEQUENCE_TYPE__OCCURRENCE), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_43_0_0_1, null, true);
				copyLocalizationInfos((CommonToken)a3, element);
				// set value of enumeration attribute
				Object value = org.emftext.language.xpath2.XPath2Package.eINSTANCE.getOccurrenceIndicatorKind().getEEnumLiteral(org.emftext.language.xpath2.OccurrenceIndicatorKind.PLUS_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ITEM_SEQUENCE_TYPE__OCCURRENCE), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 5028, 5038);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 5039, 5041);
		addExpectedElement(null, 5042, 5043);
	}
	
;

parse_org_emftext_language_xpath2_ItemKindTest returns [org.emftext.language.xpath2.ItemKindTest element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_KindTest		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createItemKindTest();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ITEM_KIND_TEST__TEST), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_44_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 5044, 5055);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 5056, 5058);
		addExpectedElement(null, 5059, 5060);
	}
	
;

parse_org_emftext_language_xpath2_AnyItemType returns [org.emftext.language.xpath2.AnyItemType element = null]
@init{
}
:
	a0 = 'item' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createAnyItemType();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_45_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 5061);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createAnyItemType();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_45_0_0_1, null, true);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 5062);
	}
	
	a2 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createAnyItemType();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_45_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 5063, 5074);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 5075, 5077);
		addExpectedElement(null, 5078, 5079);
	}
	
;

parse_org_emftext_language_xpath2_AtomicItemType returns [org.emftext.language.xpath2.AtomicItemType element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_xpath2_AtomicType		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createAtomicItemType();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ATOMIC_ITEM_TYPE__TYPE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_46_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 5080, 5091);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 5092, 5094);
		addExpectedElement(null, 5095, 5096);
	}
	
;

parse_org_emftext_language_xpath2_AtomicType returns [org.emftext.language.xpath2.AtomicType element = null]
@init{
}
:
	(
		(
			a0 = QNAME			
			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createAtomicType();
					startIncompleteElement(element);
				}
				if (a0 != null) {
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QNAME");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ATOMIC_TYPE__NAME), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
					}
					javax.xml.namespace.QName resolved = (javax.xml.namespace.QName) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ATOMIC_TYPE__NAME), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_47_0_0_0_0_0_0, resolved, true);
					copyLocalizationInfos((CommonToken) a0, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, 5097, 5110);
			addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 5111, 5113);
			addExpectedElement(null, 5114, 5116);
		}
		
		
		|		(
			a1 = NCNAME			
			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createAtomicType();
					startIncompleteElement(element);
				}
				if (a1 != null) {
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NCNAME");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ATOMIC_TYPE__NAME), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
					}
					javax.xml.namespace.QName resolved = (javax.xml.namespace.QName) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.ATOMIC_TYPE__NAME), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_47_0_0_0_0_1_0, resolved, true);
					copyLocalizationInfos((CommonToken) a1, element);
				}
			}
		)
		{
			// expected elements (follow set)
			// We've found the last token for this rule. The constructed EObject is now
			// complete.
			completedElement(element, true);
			addExpectedElement(null, 5117, 5130);
			addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 5131, 5133);
			addExpectedElement(null, 5134, 5136);
		}
		
	)
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 5137, 5150);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 5151, 5153);
		addExpectedElement(null, 5154, 5156);
	}
	
;

parse_org_emftext_language_xpath2_OptionalAtomicType returns [org.emftext.language.xpath2.OptionalAtomicType element = null]
@init{
}
:
	(
		(
			a0 = QNAME			
			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createOptionalAtomicType();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.OPTIONAL_ATOMIC_TYPE__OPTIONAL), value);
					}
				}
				if (a0 != null) {
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QNAME");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.OPTIONAL_ATOMIC_TYPE__NAME), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
					}
					javax.xml.namespace.QName resolved = (javax.xml.namespace.QName) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.OPTIONAL_ATOMIC_TYPE__NAME), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_48_0_0_0_0_0_0, resolved, true);
					copyLocalizationInfos((CommonToken) a0, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, 5157, 5159);
		}
		
		
		|		(
			a1 = NCNAME			
			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createOptionalAtomicType();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.OPTIONAL_ATOMIC_TYPE__OPTIONAL), value);
					}
				}
				if (a1 != null) {
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NCNAME");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.OPTIONAL_ATOMIC_TYPE__NAME), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((CommonToken) a1).getLine(), ((CommonToken) a1).getCharPositionInLine(), ((CommonToken) a1).getStartIndex(), ((CommonToken) a1).getStopIndex());
					}
					javax.xml.namespace.QName resolved = (javax.xml.namespace.QName) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.OPTIONAL_ATOMIC_TYPE__NAME), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_48_0_0_0_0_1_0, resolved, true);
					copyLocalizationInfos((CommonToken) a1, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, 5160, 5162);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 5163, 5165);
	}
	
	(
		(
			a2 = '?' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createOptionalAtomicType();
					startIncompleteElement(element);
					// initialize boolean attribute
					{
						Object value = false;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.OPTIONAL_ATOMIC_TYPE__OPTIONAL), value);
					}
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_48_0_0_1, true, true);
				copyLocalizationInfos((CommonToken)a2, element);
				// set value of boolean attribute
				Object value = true;
				element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.OPTIONAL_ATOMIC_TYPE__OPTIONAL), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 5166, 5167);
	}
	
;

parse_org_emftext_language_xpath2_AnyKindTest returns [org.emftext.language.xpath2.AnyKindTest element = null]
@init{
}
:
	a0 = 'node' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createAnyKindTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_49_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 5168);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createAnyKindTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_49_0_0_1, null, true);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 5169);
	}
	
	a2 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createAnyKindTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_49_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralForwardStep(), 5170);
		addExpectedElement(null, 5171, 5176);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 5177, 5178);
		addExpectedElement(null, 5179, 5187);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 5188, 5190);
		addExpectedElement(null, 5191, 5192);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevForwardStep(), 5193);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralReverseStep(), 5194);
		addExpectedElement(null, 5195);
	}
	
;

parse_org_emftext_language_xpath2_DocumentTest returns [org.emftext.language.xpath2.DocumentTest element = null]
@init{
}
:
	a0 = 'document-node' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createDocumentTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_50_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 5196);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createDocumentTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_50_0_0_1, null, true);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getDocumentTest(), 5197, 5200);
		addExpectedElement(null, 5201);
	}
	
	(
		(
			a2_0 = parse_org_emftext_language_xpath2_ElementTest			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createDocumentTest();
					startIncompleteElement(element);
				}
				if (a2_0 != null) {
					if (a2_0 != null) {
						Object value = a2_0;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.DOCUMENT_TEST__TEST), value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_50_0_0_2, a2_0, true);
					copyLocalizationInfos(a2_0, element);
				}
			}
			|			a2_1 = parse_org_emftext_language_xpath2_SchemaElementTest			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createDocumentTest();
					startIncompleteElement(element);
				}
				if (a2_1 != null) {
					if (a2_1 != null) {
						Object value = a2_1;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.DOCUMENT_TEST__TEST), value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_50_0_0_2, a2_1, true);
					copyLocalizationInfos(a2_1, element);
				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, 5202);
	}
	
	a3 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createDocumentTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_50_0_0_3, null, true);
		copyLocalizationInfos((CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralForwardStep(), 5203);
		addExpectedElement(null, 5204, 5209);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 5210, 5211);
		addExpectedElement(null, 5212, 5220);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 5221, 5223);
		addExpectedElement(null, 5224, 5225);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevForwardStep(), 5226);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralReverseStep(), 5227);
		addExpectedElement(null, 5228);
	}
	
;

parse_org_emftext_language_xpath2_TextTest returns [org.emftext.language.xpath2.TextTest element = null]
@init{
}
:
	a0 = 'text' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createTextTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_51_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 5229);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createTextTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_51_0_0_1, null, true);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 5230);
	}
	
	a2 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createTextTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_51_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralForwardStep(), 5231);
		addExpectedElement(null, 5232, 5237);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 5238, 5239);
		addExpectedElement(null, 5240, 5248);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 5249, 5251);
		addExpectedElement(null, 5252, 5253);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevForwardStep(), 5254);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralReverseStep(), 5255);
		addExpectedElement(null, 5256);
	}
	
;

parse_org_emftext_language_xpath2_CommentTest returns [org.emftext.language.xpath2.CommentTest element = null]
@init{
}
:
	a0 = 'comment' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createCommentTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_52_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 5257);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createCommentTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_52_0_0_1, null, true);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 5258);
	}
	
	a2 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createCommentTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_52_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralForwardStep(), 5259);
		addExpectedElement(null, 5260, 5265);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 5266, 5267);
		addExpectedElement(null, 5268, 5276);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 5277, 5279);
		addExpectedElement(null, 5280, 5281);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevForwardStep(), 5282);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralReverseStep(), 5283);
		addExpectedElement(null, 5284);
	}
	
;

parse_org_emftext_language_xpath2_PITest returns [org.emftext.language.xpath2.PITest element = null]
@init{
}
:
	a0 = 'processing-instruction' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createPITest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_53_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 5285);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createPITest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_53_0_0_1, null, true);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 5286);
	}
	
	a2 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createPITest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_53_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralForwardStep(), 5287);
		addExpectedElement(null, 5288, 5293);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 5294, 5295);
		addExpectedElement(null, 5296, 5304);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 5305, 5307);
		addExpectedElement(null, 5308, 5309);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevForwardStep(), 5310);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralReverseStep(), 5311);
		addExpectedElement(null, 5312);
	}
	
	|//derived choice rules for sub-classes: 
	
	c0 = parse_org_emftext_language_xpath2_NCNamePITest{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_StringLiteralPITest{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_xpath2_NCNamePITest returns [org.emftext.language.xpath2.NCNamePITest element = null]
@init{
}
:
	a0 = 'processing-instruction' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createNCNamePITest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_54_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 5313);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createNCNamePITest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_54_0_0_1, null, true);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 5314);
	}
	
	(
		a2 = NCNAME		
		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createNCNamePITest();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NCNAME");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.NC_NAME_PI_TEST__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.NC_NAME_PI_TEST__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_54_0_0_2, resolved, true);
				copyLocalizationInfos((CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 5315);
	}
	
	a3 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createNCNamePITest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_54_0_0_3, null, true);
		copyLocalizationInfos((CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralForwardStep(), 5316);
		addExpectedElement(null, 5317, 5322);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 5323, 5324);
		addExpectedElement(null, 5325, 5333);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 5334, 5336);
		addExpectedElement(null, 5337, 5338);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevForwardStep(), 5339);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralReverseStep(), 5340);
		addExpectedElement(null, 5341);
	}
	
;

parse_org_emftext_language_xpath2_StringLiteralPITest returns [org.emftext.language.xpath2.StringLiteralPITest element = null]
@init{
}
:
	a0 = 'processing-instruction' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createStringLiteralPITest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_55_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 5342);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createStringLiteralPITest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_55_0_0_1, null, true);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 5343);
	}
	
	(
		a2 = STRING_LITERAL		
		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createStringLiteralPITest();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("STRING_LITERAL");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.STRING_LITERAL_PI_TEST__LITERAL), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.emftext.language.xpath2.StringLiteral proxy = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createStringLiteral();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2ContextDependentURIFragmentFactory<org.emftext.language.xpath2.StringLiteralPITest, org.emftext.language.xpath2.StringLiteral>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getStringLiteralPITestLiteralReferenceResolver()), element, (EReference) element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.STRING_LITERAL_PI_TEST__LITERAL), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.STRING_LITERAL_PI_TEST__LITERAL), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_55_0_0_2, proxy, true);
				copyLocalizationInfos((CommonToken) a2, element);
				copyLocalizationInfos((CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 5344);
	}
	
	a3 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createStringLiteralPITest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_55_0_0_3, null, true);
		copyLocalizationInfos((CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralForwardStep(), 5345);
		addExpectedElement(null, 5346, 5351);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 5352, 5353);
		addExpectedElement(null, 5354, 5362);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 5363, 5365);
		addExpectedElement(null, 5366, 5367);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevForwardStep(), 5368);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralReverseStep(), 5369);
		addExpectedElement(null, 5370);
	}
	
;

parse_org_emftext_language_xpath2_AttributeTest returns [org.emftext.language.xpath2.AttributeTest element = null]
@init{
}
:
	a0 = 'attribute' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createAttributeTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_56_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 5371);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createAttributeTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_56_0_0_1, null, true);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 5372);
	}
	
	a2 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createAttributeTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_56_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralForwardStep(), 5373);
		addExpectedElement(null, 5374, 5379);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 5380, 5381);
		addExpectedElement(null, 5382, 5390);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 5391, 5393);
		addExpectedElement(null, 5394, 5395);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevForwardStep(), 5396);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralReverseStep(), 5397);
		addExpectedElement(null, 5398);
	}
	
	|//derived choice rules for sub-classes: 
	
	c0 = parse_org_emftext_language_xpath2_WildcardAttributeTest{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_NameAttributeTest{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_xpath2_WildcardAttributeTest returns [org.emftext.language.xpath2.WildcardAttributeTest element = null]
@init{
}
:
	a0 = 'attribute' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createWildcardAttributeTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_57_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 5399);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createWildcardAttributeTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_57_0_0_1, null, true);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 5400);
	}
	
	a2 = '*' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createWildcardAttributeTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_57_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 5401, 5402);
	}
	
	(
		(
			a3 = ',' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createWildcardAttributeTest();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_57_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, 5403, 5404);
			}
			
			(
				(
					a4 = QNAME					
					{
						if (terminateParsing) {
							throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
						}
						if (element == null) {
							element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createWildcardAttributeTest();
							startIncompleteElement(element);
						}
						if (a4 != null) {
							org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QNAME");
							tokenResolver.setOptions(getOptions());
							org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
							tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.WILDCARD_ATTRIBUTE_TEST__TYPE), result);
							Object resolvedObject = result.getResolvedToken();
							if (resolvedObject == null) {
								addErrorToResource(result.getErrorMessage(), ((CommonToken) a4).getLine(), ((CommonToken) a4).getCharPositionInLine(), ((CommonToken) a4).getStartIndex(), ((CommonToken) a4).getStopIndex());
							}
							javax.xml.namespace.QName resolved = (javax.xml.namespace.QName) resolvedObject;
							if (resolved != null) {
								Object value = resolved;
								element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.WILDCARD_ATTRIBUTE_TEST__TYPE), value);
								completedElement(value, false);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_57_0_0_3_0_0_2_0_0_0, resolved, true);
							copyLocalizationInfos((CommonToken) a4, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 5405);
				}
				
				
				|				(
					a5 = NCNAME					
					{
						if (terminateParsing) {
							throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
						}
						if (element == null) {
							element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createWildcardAttributeTest();
							startIncompleteElement(element);
						}
						if (a5 != null) {
							org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NCNAME");
							tokenResolver.setOptions(getOptions());
							org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
							tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.WILDCARD_ATTRIBUTE_TEST__TYPE), result);
							Object resolvedObject = result.getResolvedToken();
							if (resolvedObject == null) {
								addErrorToResource(result.getErrorMessage(), ((CommonToken) a5).getLine(), ((CommonToken) a5).getCharPositionInLine(), ((CommonToken) a5).getStartIndex(), ((CommonToken) a5).getStopIndex());
							}
							javax.xml.namespace.QName resolved = (javax.xml.namespace.QName) resolvedObject;
							if (resolved != null) {
								Object value = resolved;
								element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.WILDCARD_ATTRIBUTE_TEST__TYPE), value);
								completedElement(value, false);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_57_0_0_3_0_0_2_0_1_0, resolved, true);
							copyLocalizationInfos((CommonToken) a5, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 5406);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, 5407);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, 5408);
	}
	
	a6 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createWildcardAttributeTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_57_0_0_4, null, true);
		copyLocalizationInfos((CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralForwardStep(), 5409);
		addExpectedElement(null, 5410, 5415);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 5416, 5417);
		addExpectedElement(null, 5418, 5426);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 5427, 5429);
		addExpectedElement(null, 5430, 5431);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevForwardStep(), 5432);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralReverseStep(), 5433);
		addExpectedElement(null, 5434);
	}
	
;

parse_org_emftext_language_xpath2_NameAttributeTest returns [org.emftext.language.xpath2.NameAttributeTest element = null]
@init{
}
:
	a0 = 'attribute' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createNameAttributeTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_58_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 5435);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createNameAttributeTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_58_0_0_1, null, true);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 5436, 5437);
	}
	
	(
		(
			a2 = QNAME			
			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createNameAttributeTest();
					startIncompleteElement(element);
				}
				if (a2 != null) {
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QNAME");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.NAME_ATTRIBUTE_TEST__NAME), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
					}
					javax.xml.namespace.QName resolved = (javax.xml.namespace.QName) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.NAME_ATTRIBUTE_TEST__NAME), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_58_0_0_2_0_0_0, resolved, true);
					copyLocalizationInfos((CommonToken) a2, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, 5438, 5439);
		}
		
		
		|		(
			a3 = NCNAME			
			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createNameAttributeTest();
					startIncompleteElement(element);
				}
				if (a3 != null) {
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NCNAME");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.NAME_ATTRIBUTE_TEST__NAME), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
					}
					javax.xml.namespace.QName resolved = (javax.xml.namespace.QName) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.NAME_ATTRIBUTE_TEST__NAME), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_58_0_0_2_0_1_0, resolved, true);
					copyLocalizationInfos((CommonToken) a3, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, 5440, 5441);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 5442, 5443);
	}
	
	(
		(
			a4 = ',' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createNameAttributeTest();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_58_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, 5444, 5445);
			}
			
			(
				(
					a5 = QNAME					
					{
						if (terminateParsing) {
							throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
						}
						if (element == null) {
							element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createNameAttributeTest();
							startIncompleteElement(element);
						}
						if (a5 != null) {
							org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QNAME");
							tokenResolver.setOptions(getOptions());
							org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
							tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.NAME_ATTRIBUTE_TEST__TYPE), result);
							Object resolvedObject = result.getResolvedToken();
							if (resolvedObject == null) {
								addErrorToResource(result.getErrorMessage(), ((CommonToken) a5).getLine(), ((CommonToken) a5).getCharPositionInLine(), ((CommonToken) a5).getStartIndex(), ((CommonToken) a5).getStopIndex());
							}
							javax.xml.namespace.QName resolved = (javax.xml.namespace.QName) resolvedObject;
							if (resolved != null) {
								Object value = resolved;
								element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.NAME_ATTRIBUTE_TEST__TYPE), value);
								completedElement(value, false);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_58_0_0_3_0_0_2_0_0_0, resolved, true);
							copyLocalizationInfos((CommonToken) a5, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 5446);
				}
				
				
				|				(
					a6 = NCNAME					
					{
						if (terminateParsing) {
							throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
						}
						if (element == null) {
							element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createNameAttributeTest();
							startIncompleteElement(element);
						}
						if (a6 != null) {
							org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NCNAME");
							tokenResolver.setOptions(getOptions());
							org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
							tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.NAME_ATTRIBUTE_TEST__TYPE), result);
							Object resolvedObject = result.getResolvedToken();
							if (resolvedObject == null) {
								addErrorToResource(result.getErrorMessage(), ((CommonToken) a6).getLine(), ((CommonToken) a6).getCharPositionInLine(), ((CommonToken) a6).getStartIndex(), ((CommonToken) a6).getStopIndex());
							}
							javax.xml.namespace.QName resolved = (javax.xml.namespace.QName) resolvedObject;
							if (resolved != null) {
								Object value = resolved;
								element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.NAME_ATTRIBUTE_TEST__TYPE), value);
								completedElement(value, false);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_58_0_0_3_0_0_2_0_1_0, resolved, true);
							copyLocalizationInfos((CommonToken) a6, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, 5447);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, 5448);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, 5449);
	}
	
	a7 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createNameAttributeTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_58_0_0_4, null, true);
		copyLocalizationInfos((CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralForwardStep(), 5450);
		addExpectedElement(null, 5451, 5456);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 5457, 5458);
		addExpectedElement(null, 5459, 5467);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 5468, 5470);
		addExpectedElement(null, 5471, 5472);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevForwardStep(), 5473);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralReverseStep(), 5474);
		addExpectedElement(null, 5475);
	}
	
;

parse_org_emftext_language_xpath2_SchemaAttributeTest returns [org.emftext.language.xpath2.SchemaAttributeTest element = null]
@init{
}
:
	a0 = 'schema-attribute' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createSchemaAttributeTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_59_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 5476);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createSchemaAttributeTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_59_0_0_1, null, true);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 5477, 5478);
	}
	
	(
		(
			a2 = QNAME			
			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createSchemaAttributeTest();
					startIncompleteElement(element);
				}
				if (a2 != null) {
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QNAME");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.SCHEMA_ATTRIBUTE_TEST__NAME), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
					}
					javax.xml.namespace.QName resolved = (javax.xml.namespace.QName) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.SCHEMA_ATTRIBUTE_TEST__NAME), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_59_0_0_2_0_0_0, resolved, true);
					copyLocalizationInfos((CommonToken) a2, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, 5479);
		}
		
		
		|		(
			a3 = NCNAME			
			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createSchemaAttributeTest();
					startIncompleteElement(element);
				}
				if (a3 != null) {
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NCNAME");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.SCHEMA_ATTRIBUTE_TEST__NAME), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
					}
					javax.xml.namespace.QName resolved = (javax.xml.namespace.QName) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.SCHEMA_ATTRIBUTE_TEST__NAME), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_59_0_0_2_0_1_0, resolved, true);
					copyLocalizationInfos((CommonToken) a3, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, 5480);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 5481);
	}
	
	a4 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createSchemaAttributeTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_59_0_0_3, null, true);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralForwardStep(), 5482);
		addExpectedElement(null, 5483, 5488);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 5489, 5490);
		addExpectedElement(null, 5491, 5499);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 5500, 5502);
		addExpectedElement(null, 5503, 5504);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevForwardStep(), 5505);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralReverseStep(), 5506);
		addExpectedElement(null, 5507);
	}
	
;

parse_org_emftext_language_xpath2_ElementTest returns [org.emftext.language.xpath2.ElementTest element = null]
@init{
}
:
	a0 = 'element' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createElementTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_60_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 5508);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createElementTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_60_0_0_1, null, true);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 5509);
	}
	
	a2 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createElementTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_60_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralForwardStep(), 5510);
		addExpectedElement(null, 5511, 5516);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 5517, 5518);
		addExpectedElement(null, 5519, 5527);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 5528, 5530);
		addExpectedElement(null, 5531, 5532);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevForwardStep(), 5533);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralReverseStep(), 5534);
		addExpectedElement(null, 5535, 5536);
	}
	
	|//derived choice rules for sub-classes: 
	
	c0 = parse_org_emftext_language_xpath2_WildcardElementTest{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_NameElementTest{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_xpath2_WildcardElementTest returns [org.emftext.language.xpath2.WildcardElementTest element = null]
@init{
}
:
	a0 = 'element' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createWildcardElementTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_61_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 5537);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createWildcardElementTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_61_0_0_1, null, true);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 5538);
	}
	
	a2 = '*' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createWildcardElementTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_61_0_0_2, null, true);
		copyLocalizationInfos((CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 5539, 5540);
	}
	
	(
		(
			a3 = ',' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createWildcardElementTest();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_61_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getWildcardElementTest(), 5541, 5542);
			}
			
			(
				a4_0 = parse_org_emftext_language_xpath2_OptionalAtomicType				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createWildcardElementTest();
						startIncompleteElement(element);
					}
					if (a4_0 != null) {
						if (a4_0 != null) {
							Object value = a4_0;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.WILDCARD_ELEMENT_TEST__TYPE), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_61_0_0_3_0_0_2, a4_0, true);
						copyLocalizationInfos(a4_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, 5543);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, 5544);
	}
	
	a5 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createWildcardElementTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_61_0_0_4, null, true);
		copyLocalizationInfos((CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralForwardStep(), 5545);
		addExpectedElement(null, 5546, 5551);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 5552, 5553);
		addExpectedElement(null, 5554, 5562);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 5563, 5565);
		addExpectedElement(null, 5566, 5567);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevForwardStep(), 5568);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralReverseStep(), 5569);
		addExpectedElement(null, 5570, 5571);
	}
	
;

parse_org_emftext_language_xpath2_NameElementTest returns [org.emftext.language.xpath2.NameElementTest element = null]
@init{
}
:
	a0 = 'element' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createNameElementTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_62_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 5572);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createNameElementTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_62_0_0_1, null, true);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 5573, 5574);
	}
	
	(
		(
			a2 = QNAME			
			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createNameElementTest();
					startIncompleteElement(element);
				}
				if (a2 != null) {
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QNAME");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.NAME_ELEMENT_TEST__NAME), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
					}
					javax.xml.namespace.QName resolved = (javax.xml.namespace.QName) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.NAME_ELEMENT_TEST__NAME), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_62_0_0_2_0_0_0, resolved, true);
					copyLocalizationInfos((CommonToken) a2, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, 5575, 5576);
		}
		
		
		|		(
			a3 = NCNAME			
			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createNameElementTest();
					startIncompleteElement(element);
				}
				if (a3 != null) {
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NCNAME");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.NAME_ELEMENT_TEST__NAME), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
					}
					javax.xml.namespace.QName resolved = (javax.xml.namespace.QName) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.NAME_ELEMENT_TEST__NAME), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_62_0_0_2_0_1_0, resolved, true);
					copyLocalizationInfos((CommonToken) a3, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, 5577, 5578);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 5579, 5580);
	}
	
	(
		(
			a4 = ',' {
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createNameElementTest();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_62_0_0_3_0_0_0, null, true);
				copyLocalizationInfos((CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getNameElementTest(), 5581, 5582);
			}
			
			(
				a5_0 = parse_org_emftext_language_xpath2_OptionalAtomicType				{
					if (terminateParsing) {
						throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
					}
					if (element == null) {
						element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createNameElementTest();
						startIncompleteElement(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.NAME_ELEMENT_TEST__TYPE), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_62_0_0_3_0_0_2, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, 5583);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, 5584);
	}
	
	a6 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createNameElementTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_62_0_0_4, null, true);
		copyLocalizationInfos((CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralForwardStep(), 5585);
		addExpectedElement(null, 5586, 5591);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 5592, 5593);
		addExpectedElement(null, 5594, 5602);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 5603, 5605);
		addExpectedElement(null, 5606, 5607);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevForwardStep(), 5608);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralReverseStep(), 5609);
		addExpectedElement(null, 5610, 5611);
	}
	
;

parse_org_emftext_language_xpath2_SchemaElementTest returns [org.emftext.language.xpath2.SchemaElementTest element = null]
@init{
}
:
	a0 = 'schema-element' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createSchemaElementTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_63_0_0_0, null, true);
		copyLocalizationInfos((CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 5612);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createSchemaElementTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_63_0_0_1, null, true);
		copyLocalizationInfos((CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, 5613, 5614);
	}
	
	(
		(
			a2 = QNAME			
			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createSchemaElementTest();
					startIncompleteElement(element);
				}
				if (a2 != null) {
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QNAME");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.SCHEMA_ELEMENT_TEST__NAME), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((CommonToken) a2).getLine(), ((CommonToken) a2).getCharPositionInLine(), ((CommonToken) a2).getStartIndex(), ((CommonToken) a2).getStopIndex());
					}
					javax.xml.namespace.QName resolved = (javax.xml.namespace.QName) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.SCHEMA_ELEMENT_TEST__NAME), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_63_0_0_2_0_0_0, resolved, true);
					copyLocalizationInfos((CommonToken) a2, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, 5615);
		}
		
		
		|		(
			a3 = NCNAME			
			{
				if (terminateParsing) {
					throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
				}
				if (element == null) {
					element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createSchemaElementTest();
					startIncompleteElement(element);
				}
				if (a3 != null) {
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("NCNAME");
					tokenResolver.setOptions(getOptions());
					org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.SCHEMA_ELEMENT_TEST__NAME), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((CommonToken) a3).getLine(), ((CommonToken) a3).getCharPositionInLine(), ((CommonToken) a3).getStartIndex(), ((CommonToken) a3).getStopIndex());
					}
					javax.xml.namespace.QName resolved = (javax.xml.namespace.QName) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.SCHEMA_ELEMENT_TEST__NAME), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_63_0_0_2_0_1_0, resolved, true);
					copyLocalizationInfos((CommonToken) a3, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, 5616);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, 5617);
	}
	
	a4 = ')' {
		if (element == null) {
			element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createSchemaElementTest();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_63_0_0_3, null, true);
		copyLocalizationInfos((CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralForwardStep(), 5618);
		addExpectedElement(null, 5619, 5624);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 5625, 5626);
		addExpectedElement(null, 5627, 5635);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 5636, 5638);
		addExpectedElement(null, 5639, 5640);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getAbbrevForwardStep(), 5641);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getGeneralReverseStep(), 5642);
		addExpectedElement(null, 5643, 5644);
	}
	
;

parse_org_emftext_language_xpath2_IntegerLiteral returns [org.emftext.language.xpath2.IntegerLiteral element = null]
@init{
}
:
	(
		a0 = INTEGER_LITERAL		
		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createIntegerLiteral();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.INTEGER_LITERAL__VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.INTEGER_LITERAL__VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_64_0_0_0, resolved, true);
				copyLocalizationInfos((CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 5645, 5650);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getFilterExpr(), 5651);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 5652, 5653);
		addExpectedElement(null, 5654, 5662);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 5663, 5665);
		addExpectedElement(null, 5666, 5667);
	}
	
;

parse_org_emftext_language_xpath2_DecimalLiteral returns [org.emftext.language.xpath2.DecimalLiteral element = null]
@init{
}
:
	(
		a0 = DECIMAL_LITERAL		
		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createDecimalLiteral();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DECIMAL_LITERAL");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.DECIMAL_LITERAL__VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
				}
				java.lang.Float resolved = (java.lang.Float) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.DECIMAL_LITERAL__VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_65_0_0_0, resolved, true);
				copyLocalizationInfos((CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 5668, 5673);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getFilterExpr(), 5674);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 5675, 5676);
		addExpectedElement(null, 5677, 5685);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 5686, 5688);
		addExpectedElement(null, 5689, 5690);
	}
	
;

parse_org_emftext_language_xpath2_DoubleLiteral returns [org.emftext.language.xpath2.DoubleLiteral element = null]
@init{
}
:
	(
		a0 = DOUBLE_LITERAL		
		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createDoubleLiteral();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("DOUBLE_LITERAL");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.DOUBLE_LITERAL__VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
				}
				java.lang.Double resolved = (java.lang.Double) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.DOUBLE_LITERAL__VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_66_0_0_0, resolved, true);
				copyLocalizationInfos((CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 5691, 5696);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getFilterExpr(), 5697);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 5698, 5699);
		addExpectedElement(null, 5700, 5708);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 5709, 5711);
		addExpectedElement(null, 5712, 5713);
	}
	
;

parse_org_emftext_language_xpath2_StringLiteral returns [org.emftext.language.xpath2.StringLiteral element = null]
@init{
}
:
	(
		a0 = STRING_LITERAL		
		{
			if (terminateParsing) {
				throw new org.emftext.language.xpath2.resource.xpath2.mopp.Xpath2TerminateParsingException();
			}
			if (element == null) {
				element = org.emftext.language.xpath2.XPath2Factory.eINSTANCE.createStringLiteral();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("STRING_LITERAL");
				tokenResolver.setOptions(getOptions());
				org.emftext.language.xpath2.resource.xpath2.IXpath2TokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.STRING_LITERAL__VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((CommonToken) a0).getLine(), ((CommonToken) a0).getCharPositionInLine(), ((CommonToken) a0).getStartIndex(), ((CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.xpath2.XPath2Package.STRING_LITERAL__VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.xpath2.resource.xpath2.grammar.Xpath2GrammarInformationProvider.XPATH2_67_0_0_0, resolved, true);
				copyLocalizationInfos((CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		// We've found the last token for this rule. The constructed EObject is now
		// complete.
		completedElement(element, true);
		addExpectedElement(null, 5714, 5719);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getFilterExpr(), 5720);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getPathExpr(), 5721, 5722);
		addExpectedElement(null, 5723, 5731);
		addExpectedElement(org.emftext.language.xpath2.XPath2Package.eINSTANCE.getComparisonExpr(), 5732, 5734);
		addExpectedElement(null, 5735, 5736);
	}
	
;

parse_org_emftext_language_xpath2_ExprSingle returns [org.emftext.language.xpath2.ExprSingle element = null]
:
	c0 = parse_org_emftext_language_xpath2_ForExpr{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_QuantifiedExpr{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_xpath2_IfExpr{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_org_emftext_language_xpath2_OrExpr{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_org_emftext_language_xpath2_AndExpr{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_org_emftext_language_xpath2_ComparisonExpr{ element = c5; /* this is a subclass or primitive expression choice */ }
	|	c6 = parse_org_emftext_language_xpath2_RangeExpr{ element = c6; /* this is a subclass or primitive expression choice */ }
	|	c7 = parse_org_emftext_language_xpath2_AdditiveExpr{ element = c7; /* this is a subclass or primitive expression choice */ }
	|	c8 = parse_org_emftext_language_xpath2_MultiplicativeExpr{ element = c8; /* this is a subclass or primitive expression choice */ }
	|	c9 = parse_org_emftext_language_xpath2_UnionExpr{ element = c9; /* this is a subclass or primitive expression choice */ }
	|	c10 = parse_org_emftext_language_xpath2_IntersectExceptExpr{ element = c10; /* this is a subclass or primitive expression choice */ }
	|	c11 = parse_org_emftext_language_xpath2_InstanceofExpr{ element = c11; /* this is a subclass or primitive expression choice */ }
	|	c12 = parse_org_emftext_language_xpath2_TreatExpr{ element = c12; /* this is a subclass or primitive expression choice */ }
	|	c13 = parse_org_emftext_language_xpath2_CastableExpr{ element = c13; /* this is a subclass or primitive expression choice */ }
	|	c14 = parse_org_emftext_language_xpath2_CastExpr{ element = c14; /* this is a subclass or primitive expression choice */ }
	|	c15 = parse_org_emftext_language_xpath2_UnaryExpr{ element = c15; /* this is a subclass or primitive expression choice */ }
	|	c16 = parse_org_emftext_language_xpath2_FilterExpr{ element = c16; /* this is a subclass or primitive expression choice */ }
	|	c17 = parse_org_emftext_language_xpath2_FunctionCall{ element = c17; /* this is a subclass or primitive expression choice */ }
	|	c18 = parse_org_emftext_language_xpath2_PathExpr{ element = c18; /* this is a subclass or primitive expression choice */ }
	|	c19 = parse_org_emftext_language_xpath2_ChildStepExpr{ element = c19; /* this is a subclass or primitive expression choice */ }
	|	c20 = parse_org_emftext_language_xpath2_DescOrSelfStepExpr{ element = c20; /* this is a subclass or primitive expression choice */ }
	|	c21 = parse_org_emftext_language_xpath2_RootStepExpr{ element = c21; /* this is a subclass or primitive expression choice */ }
	|	c22 = parse_org_emftext_language_xpath2_SelfStepExpr{ element = c22; /* this is a subclass or primitive expression choice */ }
	|	c23 = parse_org_emftext_language_xpath2_GeneralForwardStep{ element = c23; /* this is a subclass or primitive expression choice */ }
	|	c24 = parse_org_emftext_language_xpath2_AbbrevForwardStep{ element = c24; /* this is a subclass or primitive expression choice */ }
	|	c25 = parse_org_emftext_language_xpath2_GeneralReverseStep{ element = c25; /* this is a subclass or primitive expression choice */ }
	|	c26 = parse_org_emftext_language_xpath2_AbbrevReverseStep{ element = c26; /* this is a subclass or primitive expression choice */ }
	|	c27 = parse_org_emftext_language_xpath2_VarRef{ element = c27; /* this is a subclass or primitive expression choice */ }
	|	c28 = parse_org_emftext_language_xpath2_ParenthesizedExpr{ element = c28; /* this is a subclass or primitive expression choice */ }
	|	c29 = parse_org_emftext_language_xpath2_ContextItemExpr{ element = c29; /* this is a subclass or primitive expression choice */ }
	|	c30 = parse_org_emftext_language_xpath2_IntegerLiteral{ element = c30; /* this is a subclass or primitive expression choice */ }
	|	c31 = parse_org_emftext_language_xpath2_DecimalLiteral{ element = c31; /* this is a subclass or primitive expression choice */ }
	|	c32 = parse_org_emftext_language_xpath2_DoubleLiteral{ element = c32; /* this is a subclass or primitive expression choice */ }
	|	c33 = parse_org_emftext_language_xpath2_StringLiteral{ element = c33; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_xpath2_Comp returns [org.emftext.language.xpath2.Comp element = null]
:
	c0 = parse_org_emftext_language_xpath2_GeneralComp{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_ValueComp{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_xpath2_NodeComp{ element = c2; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_xpath2_SequenceType returns [org.emftext.language.xpath2.SequenceType element = null]
:
	c0 = parse_org_emftext_language_xpath2_EmptySequenceType{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_ItemSequenceType{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_xpath2_ValueExpr returns [org.emftext.language.xpath2.ValueExpr element = null]
:
	c0 = parse_org_emftext_language_xpath2_PathExpr{ element = c0; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_xpath2_PrimaryExpr returns [org.emftext.language.xpath2.PrimaryExpr element = null]
:
	c0 = parse_org_emftext_language_xpath2_FunctionCall{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_VarRef{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_xpath2_ParenthesizedExpr{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_org_emftext_language_xpath2_ContextItemExpr{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_org_emftext_language_xpath2_IntegerLiteral{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_org_emftext_language_xpath2_DecimalLiteral{ element = c5; /* this is a subclass or primitive expression choice */ }
	|	c6 = parse_org_emftext_language_xpath2_DoubleLiteral{ element = c6; /* this is a subclass or primitive expression choice */ }
	|	c7 = parse_org_emftext_language_xpath2_StringLiteral{ element = c7; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_xpath2_PathExprChild returns [org.emftext.language.xpath2.PathExprChild element = null]
:
	c0 = parse_org_emftext_language_xpath2_FilterExpr{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_FunctionCall{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_xpath2_ChildStepExpr{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_org_emftext_language_xpath2_DescOrSelfStepExpr{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_org_emftext_language_xpath2_RootStepExpr{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_org_emftext_language_xpath2_SelfStepExpr{ element = c5; /* this is a subclass or primitive expression choice */ }
	|	c6 = parse_org_emftext_language_xpath2_GeneralForwardStep{ element = c6; /* this is a subclass or primitive expression choice */ }
	|	c7 = parse_org_emftext_language_xpath2_AbbrevForwardStep{ element = c7; /* this is a subclass or primitive expression choice */ }
	|	c8 = parse_org_emftext_language_xpath2_GeneralReverseStep{ element = c8; /* this is a subclass or primitive expression choice */ }
	|	c9 = parse_org_emftext_language_xpath2_AbbrevReverseStep{ element = c9; /* this is a subclass or primitive expression choice */ }
	|	c10 = parse_org_emftext_language_xpath2_VarRef{ element = c10; /* this is a subclass or primitive expression choice */ }
	|	c11 = parse_org_emftext_language_xpath2_ParenthesizedExpr{ element = c11; /* this is a subclass or primitive expression choice */ }
	|	c12 = parse_org_emftext_language_xpath2_ContextItemExpr{ element = c12; /* this is a subclass or primitive expression choice */ }
	|	c13 = parse_org_emftext_language_xpath2_IntegerLiteral{ element = c13; /* this is a subclass or primitive expression choice */ }
	|	c14 = parse_org_emftext_language_xpath2_DecimalLiteral{ element = c14; /* this is a subclass or primitive expression choice */ }
	|	c15 = parse_org_emftext_language_xpath2_DoubleLiteral{ element = c15; /* this is a subclass or primitive expression choice */ }
	|	c16 = parse_org_emftext_language_xpath2_StringLiteral{ element = c16; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_xpath2_StepExprChild returns [org.emftext.language.xpath2.StepExprChild element = null]
:
	c0 = parse_org_emftext_language_xpath2_FilterExpr{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_FunctionCall{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_xpath2_GeneralForwardStep{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_org_emftext_language_xpath2_AbbrevForwardStep{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_org_emftext_language_xpath2_GeneralReverseStep{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_org_emftext_language_xpath2_AbbrevReverseStep{ element = c5; /* this is a subclass or primitive expression choice */ }
	|	c6 = parse_org_emftext_language_xpath2_VarRef{ element = c6; /* this is a subclass or primitive expression choice */ }
	|	c7 = parse_org_emftext_language_xpath2_ParenthesizedExpr{ element = c7; /* this is a subclass or primitive expression choice */ }
	|	c8 = parse_org_emftext_language_xpath2_ContextItemExpr{ element = c8; /* this is a subclass or primitive expression choice */ }
	|	c9 = parse_org_emftext_language_xpath2_IntegerLiteral{ element = c9; /* this is a subclass or primitive expression choice */ }
	|	c10 = parse_org_emftext_language_xpath2_DecimalLiteral{ element = c10; /* this is a subclass or primitive expression choice */ }
	|	c11 = parse_org_emftext_language_xpath2_DoubleLiteral{ element = c11; /* this is a subclass or primitive expression choice */ }
	|	c12 = parse_org_emftext_language_xpath2_StringLiteral{ element = c12; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_xpath2_NodeTest returns [org.emftext.language.xpath2.NodeTest element = null]
:
	c0 = parse_org_emftext_language_xpath2_NodeKindTest{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_QNameTest{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_xpath2_AnyWildcard{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_org_emftext_language_xpath2_LocalNameWildcard{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_org_emftext_language_xpath2_NamespaceWildcard{ element = c4; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_xpath2_KindTest returns [org.emftext.language.xpath2.KindTest element = null]
:
	c0 = parse_org_emftext_language_xpath2_AnyKindTest{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_DocumentTest{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_xpath2_TextTest{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_org_emftext_language_xpath2_CommentTest{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_org_emftext_language_xpath2_PITest{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_org_emftext_language_xpath2_NCNamePITest{ element = c5; /* this is a subclass or primitive expression choice */ }
	|	c6 = parse_org_emftext_language_xpath2_StringLiteralPITest{ element = c6; /* this is a subclass or primitive expression choice */ }
	|	c7 = parse_org_emftext_language_xpath2_AttributeTest{ element = c7; /* this is a subclass or primitive expression choice */ }
	|	c8 = parse_org_emftext_language_xpath2_WildcardAttributeTest{ element = c8; /* this is a subclass or primitive expression choice */ }
	|	c9 = parse_org_emftext_language_xpath2_NameAttributeTest{ element = c9; /* this is a subclass or primitive expression choice */ }
	|	c10 = parse_org_emftext_language_xpath2_SchemaAttributeTest{ element = c10; /* this is a subclass or primitive expression choice */ }
	|	c11 = parse_org_emftext_language_xpath2_ElementTest{ element = c11; /* this is a subclass or primitive expression choice */ }
	|	c12 = parse_org_emftext_language_xpath2_WildcardElementTest{ element = c12; /* this is a subclass or primitive expression choice */ }
	|	c13 = parse_org_emftext_language_xpath2_NameElementTest{ element = c13; /* this is a subclass or primitive expression choice */ }
	|	c14 = parse_org_emftext_language_xpath2_SchemaElementTest{ element = c14; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_xpath2_ItemType returns [org.emftext.language.xpath2.ItemType element = null]
:
	c0 = parse_org_emftext_language_xpath2_ItemKindTest{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_xpath2_AnyItemType{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_xpath2_AtomicItemType{ element = c2; /* this is a subclass or primitive expression choice */ }
	
;

INTEGER_LITERAL:
	(('0'..'9')+)
;
DECIMAL_LITERAL:
	(('.'('0'..'9')+)|(('0'..'9')+'.'('0'..'9')*))
;
DOUBLE_LITERAL:
	((('.'('0'..'9')+)|(('0'..'9')+('.'('0'..'9')*)?))('e'|'E')('+'|'-')?('0'..'9')+)
;
QNAME:
	(('A'..'Z'|'_'|'a'..'z'|'\u00C0'..'\u00D6'|'\u00D8'..'\u00F6'|'\u00F8'..'\u02FF'|'\u0370'..'\u037D'|'\u037F'..'\u1FFF'|'\u200C'..'\u200D'|'\u2070'..'\u218F'|'\u2C00'..'\u2FEF'|'\u3001'..'\uD7FF'|'\uF900'..'\uFDCF'|'\uFDF0'..'\uFFFD')('A'..'Z'|'_'|'a'..'z'|'\u00C0'..'\u00D6'|'\u00D8'..'\u00F6'|'\u00F8'..'\u02FF'|'\u0370'..'\u037D'|'\u037F'..'\u1FFF'|'\u200C'..'\u200D'|'\u2070'..'\u218F'|'\u2C00'..'\u2FEF'|'\u3001'..'\uD7FF'|'\uF900'..'\uFDCF'|'\uFDF0'..'\uFFFD'|'-'|'.'|'0'..'9'|'\u00B7'|'\u0300'..'\u036F'|'\u203F'..'\u2040')*':'('A'..'Z'|'_'|'a'..'z'|'\u00C0'..'\u00D6'|'\u00D8'..'\u00F6'|'\u00F8'..'\u02FF'|'\u0370'..'\u037D'|'\u037F'..'\u1FFF'|'\u200C'..'\u200D'|'\u2070'..'\u218F'|'\u2C00'..'\u2FEF'|'\u3001'..'\uD7FF'|'\uF900'..'\uFDCF'|'\uFDF0'..'\uFFFD')('A'..'Z'|'_'|'a'..'z'|'\u00C0'..'\u00D6'|'\u00D8'..'\u00F6'|'\u00F8'..'\u02FF'|'\u0370'..'\u037D'|'\u037F'..'\u1FFF'|'\u200C'..'\u200D'|'\u2070'..'\u218F'|'\u2C00'..'\u2FEF'|'\u3001'..'\uD7FF'|'\uF900'..'\uFDCF'|'\uFDF0'..'\uFFFD'|'-'|'.'|'0'..'9'|'\u00B7'|'\u0300'..'\u036F'|'\u203F'..'\u2040')*)
;
NCNAME:
	(('A'..'Z'|'_'|'a'..'z'|'\u00C0'..'\u00D6'|'\u00D8'..'\u00F6'|'\u00F8'..'\u02FF'|'\u0370'..'\u037D'|'\u037F'..'\u1FFF'|'\u200C'..'\u200D'|'\u2070'..'\u218F'|'\u2C00'..'\u2FEF'|'\u3001'..'\uD7FF'|'\uF900'..'\uFDCF'|'\uFDF0'..'\uFFFD')('A'..'Z'|'_'|'a'..'z'|'\u00C0'..'\u00D6'|'\u00D8'..'\u00F6'|'\u00F8'..'\u02FF'|'\u0370'..'\u037D'|'\u037F'..'\u1FFF'|'\u200C'..'\u200D'|'\u2070'..'\u218F'|'\u2C00'..'\u2FEF'|'\u3001'..'\uD7FF'|'\uF900'..'\uFDCF'|'\uFDF0'..'\uFFFD'|'-'|'.'|'0'..'9'|'\u00B7'|'\u0300'..'\u036F'|'\u203F'..'\u2040')*)
;
STRING_LITERAL:
	(('\"')('\"\"'|~('\"'))*('\"')|('\'')('\'\''|~('\''))*('\''))
;
WHITESPACE:
	((' '|'\t'|'\f'|'\r'|'\n')+)
	{ _channel = 99; }
;

