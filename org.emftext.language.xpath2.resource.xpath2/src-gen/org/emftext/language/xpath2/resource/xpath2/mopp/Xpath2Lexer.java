// $ANTLR 3.4

	package org.emftext.language.xpath2.resource.xpath2.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class Xpath2Lexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__50=50;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__59=59;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__73=73;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int COMMENT_CONTENTS=4;
    public static final int DECIMAL_LITERAL=5;
    public static final int DOUBLE_LITERAL=6;
    public static final int INTEGER_LITERAL=7;
    public static final int LINEBREAK=8;
    public static final int NCNAME=9;
    public static final int STRING_LITERAL=10;
    public static final int TEXT=11;
    public static final int WHITESPACE=12;

    	public java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>();
    	public java.util.List<Integer> lexerExceptionsPosition = new java.util.ArrayList<Integer>();
    	
    	public void reportError(org.antlr.runtime3_4_0.RecognitionException e) {
    		lexerExceptions.add(e);
    		lexerExceptionsPosition.add(((org.antlr.runtime3_4_0.ANTLRStringStream) input).index());
    	}


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public Xpath2Lexer() {} 
    public Xpath2Lexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public Xpath2Lexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "Xpath2.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:15:7: ( '!=' )
            // Xpath2.g:15:9: '!='
            {
            match("!="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:16:7: ( '$' )
            // Xpath2.g:16:9: '$'
            {
            match('$'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:17:7: ( '(' )
            // Xpath2.g:17:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:18:7: ( ')' )
            // Xpath2.g:18:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:19:7: ( '*' )
            // Xpath2.g:19:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:20:7: ( '+' )
            // Xpath2.g:20:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:21:7: ( ',' )
            // Xpath2.g:21:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:22:7: ( '-' )
            // Xpath2.g:22:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:23:7: ( '.' )
            // Xpath2.g:23:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:24:7: ( '..' )
            // Xpath2.g:24:9: '..'
            {
            match(".."); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:25:7: ( '/' )
            // Xpath2.g:25:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:26:7: ( '//' )
            // Xpath2.g:26:9: '//'
            {
            match("//"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:27:7: ( ':' )
            // Xpath2.g:27:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:28:7: ( '::' )
            // Xpath2.g:28:9: '::'
            {
            match("::"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:29:7: ( '<' )
            // Xpath2.g:29:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:30:7: ( '<<' )
            // Xpath2.g:30:9: '<<'
            {
            match("<<"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:31:7: ( '<=' )
            // Xpath2.g:31:9: '<='
            {
            match("<="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:32:7: ( '=' )
            // Xpath2.g:32:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:33:7: ( '>' )
            // Xpath2.g:33:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:34:7: ( '>=' )
            // Xpath2.g:34:9: '>='
            {
            match(">="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:35:7: ( '>>' )
            // Xpath2.g:35:9: '>>'
            {
            match(">>"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:36:7: ( '?' )
            // Xpath2.g:36:9: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:37:7: ( '@' )
            // Xpath2.g:37:9: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:38:7: ( '[' )
            // Xpath2.g:38:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:39:7: ( ']' )
            // Xpath2.g:39:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:40:7: ( 'ancestor' )
            // Xpath2.g:40:9: 'ancestor'
            {
            match("ancestor"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:41:7: ( 'ancestor-or-self' )
            // Xpath2.g:41:9: 'ancestor-or-self'
            {
            match("ancestor-or-self"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:42:7: ( 'and' )
            // Xpath2.g:42:9: 'and'
            {
            match("and"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:43:7: ( 'attribute' )
            // Xpath2.g:43:9: 'attribute'
            {
            match("attribute"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:44:7: ( 'child' )
            // Xpath2.g:44:9: 'child'
            {
            match("child"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:45:7: ( 'comment' )
            // Xpath2.g:45:9: 'comment'
            {
            match("comment"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:46:7: ( 'descendant' )
            // Xpath2.g:46:9: 'descendant'
            {
            match("descendant"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:47:7: ( 'descendant-or-self' )
            // Xpath2.g:47:9: 'descendant-or-self'
            {
            match("descendant-or-self"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:48:7: ( 'document-node' )
            // Xpath2.g:48:9: 'document-node'
            {
            match("document-node"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:49:7: ( 'element' )
            // Xpath2.g:49:9: 'element'
            {
            match("element"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:50:7: ( 'else' )
            // Xpath2.g:50:9: 'else'
            {
            match("else"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:51:7: ( 'empty-sequence' )
            // Xpath2.g:51:9: 'empty-sequence'
            {
            match("empty-sequence"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:52:7: ( 'eq' )
            // Xpath2.g:52:9: 'eq'
            {
            match("eq"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:53:7: ( 'every' )
            // Xpath2.g:53:9: 'every'
            {
            match("every"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:54:7: ( 'following' )
            // Xpath2.g:54:9: 'following'
            {
            match("following"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:55:7: ( 'following-sibling' )
            // Xpath2.g:55:9: 'following-sibling'
            {
            match("following-sibling"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:56:7: ( 'for' )
            // Xpath2.g:56:9: 'for'
            {
            match("for"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:57:7: ( 'ge' )
            // Xpath2.g:57:9: 'ge'
            {
            match("ge"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:58:7: ( 'gt' )
            // Xpath2.g:58:9: 'gt'
            {
            match("gt"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:59:7: ( 'if' )
            // Xpath2.g:59:9: 'if'
            {
            match("if"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:60:7: ( 'in' )
            // Xpath2.g:60:9: 'in'
            {
            match("in"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:61:7: ( 'is' )
            // Xpath2.g:61:9: 'is'
            {
            match("is"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:62:7: ( 'item' )
            // Xpath2.g:62:9: 'item'
            {
            match("item"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:63:7: ( 'le' )
            // Xpath2.g:63:9: 'le'
            {
            match("le"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:64:7: ( 'lt' )
            // Xpath2.g:64:9: 'lt'
            {
            match("lt"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:65:7: ( 'namespace' )
            // Xpath2.g:65:9: 'namespace'
            {
            match("namespace"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:66:7: ( 'ne' )
            // Xpath2.g:66:9: 'ne'
            {
            match("ne"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:67:7: ( 'node' )
            // Xpath2.g:67:9: 'node'
            {
            match("node"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:68:7: ( 'or' )
            // Xpath2.g:68:9: 'or'
            {
            match("or"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:69:7: ( 'parent' )
            // Xpath2.g:69:9: 'parent'
            {
            match("parent"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:70:7: ( 'preceding' )
            // Xpath2.g:70:9: 'preceding'
            {
            match("preceding"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:71:7: ( 'preceding-sibling' )
            // Xpath2.g:71:9: 'preceding-sibling'
            {
            match("preceding-sibling"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:72:7: ( 'processing-instruction' )
            // Xpath2.g:72:9: 'processing-instruction'
            {
            match("processing-instruction"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:73:7: ( 'return' )
            // Xpath2.g:73:9: 'return'
            {
            match("return"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:74:7: ( 'satisfies' )
            // Xpath2.g:74:9: 'satisfies'
            {
            match("satisfies"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:75:7: ( 'schema-attribute' )
            // Xpath2.g:75:9: 'schema-attribute'
            {
            match("schema-attribute"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:76:7: ( 'schema-element' )
            // Xpath2.g:76:9: 'schema-element'
            {
            match("schema-element"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:77:7: ( 'self' )
            // Xpath2.g:77:9: 'self'
            {
            match("self"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:78:7: ( 'some' )
            // Xpath2.g:78:9: 'some'
            {
            match("some"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:79:7: ( 'text' )
            // Xpath2.g:79:9: 'text'
            {
            match("text"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:80:7: ( 'then' )
            // Xpath2.g:80:9: 'then'
            {
            match("then"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:81:7: ( 'to' )
            // Xpath2.g:81:9: 'to'
            {
            match("to"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "INTEGER_LITERAL"
    public final void mINTEGER_LITERAL() throws RecognitionException {
        try {
            int _type = INTEGER_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:7465:16: ( ( ( '0' .. '9' )+ ) )
            // Xpath2.g:7466:2: ( ( '0' .. '9' )+ )
            {
            // Xpath2.g:7466:2: ( ( '0' .. '9' )+ )
            // Xpath2.g:7466:3: ( '0' .. '9' )+
            {
            // Xpath2.g:7466:3: ( '0' .. '9' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Xpath2.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INTEGER_LITERAL"

    // $ANTLR start "DECIMAL_LITERAL"
    public final void mDECIMAL_LITERAL() throws RecognitionException {
        try {
            int _type = DECIMAL_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:7468:16: ( ( ( '.' ( '0' .. '9' )+ ) | ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ) ) )
            // Xpath2.g:7469:2: ( ( '.' ( '0' .. '9' )+ ) | ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ) )
            {
            // Xpath2.g:7469:2: ( ( '.' ( '0' .. '9' )+ ) | ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='.') ) {
                alt5=1;
            }
            else if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // Xpath2.g:7469:3: ( '.' ( '0' .. '9' )+ )
                    {
                    // Xpath2.g:7469:3: ( '.' ( '0' .. '9' )+ )
                    // Xpath2.g:7469:4: '.' ( '0' .. '9' )+
                    {
                    match('.'); 

                    // Xpath2.g:7469:7: ( '0' .. '9' )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // Xpath2.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt2 >= 1 ) break loop2;
                                EarlyExitException eee =
                                    new EarlyExitException(2, input);
                                throw eee;
                        }
                        cnt2++;
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // Xpath2.g:7469:20: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* )
                    {
                    // Xpath2.g:7469:20: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* )
                    // Xpath2.g:7469:21: ( '0' .. '9' )+ '.' ( '0' .. '9' )*
                    {
                    // Xpath2.g:7469:21: ( '0' .. '9' )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // Xpath2.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt3 >= 1 ) break loop3;
                                EarlyExitException eee =
                                    new EarlyExitException(3, input);
                                throw eee;
                        }
                        cnt3++;
                    } while (true);


                    match('.'); 

                    // Xpath2.g:7469:35: ( '0' .. '9' )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // Xpath2.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DECIMAL_LITERAL"

    // $ANTLR start "DOUBLE_LITERAL"
    public final void mDOUBLE_LITERAL() throws RecognitionException {
        try {
            int _type = DOUBLE_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:7471:15: ( ( ( '.' ( '0' .. '9' )+ ) | ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )* )? ) ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ ) )
            // Xpath2.g:7472:2: ( ( '.' ( '0' .. '9' )+ ) | ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )* )? ) ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            {
            // Xpath2.g:7472:2: ( ( '.' ( '0' .. '9' )+ ) | ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )* )? ) ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='.') ) {
                alt12=1;
            }
            else if ( ((LA12_0 >= '0' && LA12_0 <= '9')) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }
            switch (alt12) {
                case 1 :
                    // Xpath2.g:7472:3: ( '.' ( '0' .. '9' )+ )
                    {
                    // Xpath2.g:7472:3: ( '.' ( '0' .. '9' )+ )
                    // Xpath2.g:7472:4: '.' ( '0' .. '9' )+
                    {
                    match('.'); 

                    // Xpath2.g:7472:7: ( '0' .. '9' )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // Xpath2.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt6 >= 1 ) break loop6;
                                EarlyExitException eee =
                                    new EarlyExitException(6, input);
                                throw eee;
                        }
                        cnt6++;
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // Xpath2.g:7472:20: ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )* )? ) ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
                    {
                    // Xpath2.g:7472:20: ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )* )? )
                    // Xpath2.g:7472:21: ( '0' .. '9' )+ ( '.' ( '0' .. '9' )* )?
                    {
                    // Xpath2.g:7472:21: ( '0' .. '9' )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // Xpath2.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);


                    // Xpath2.g:7472:32: ( '.' ( '0' .. '9' )* )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='.') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // Xpath2.g:7472:33: '.' ( '0' .. '9' )*
                            {
                            match('.'); 

                            // Xpath2.g:7472:36: ( '0' .. '9' )*
                            loop8:
                            do {
                                int alt8=2;
                                int LA8_0 = input.LA(1);

                                if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
                                    alt8=1;
                                }


                                switch (alt8) {
                            	case 1 :
                            	    // Xpath2.g:
                            	    {
                            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                            	        input.consume();
                            	    }
                            	    else {
                            	        MismatchedSetException mse = new MismatchedSetException(null,input);
                            	        recover(mse);
                            	        throw mse;
                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop8;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }


                    if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    // Xpath2.g:7472:59: ( '+' | '-' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='+'||LA10_0=='-') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // Xpath2.g:
                            {
                            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                                input.consume();
                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;
                            }


                            }
                            break;

                    }


                    // Xpath2.g:7472:69: ( '0' .. '9' )+
                    int cnt11=0;
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( ((LA11_0 >= '0' && LA11_0 <= '9')) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // Xpath2.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt11 >= 1 ) break loop11;
                                EarlyExitException eee =
                                    new EarlyExitException(11, input);
                                throw eee;
                        }
                        cnt11++;
                    } while (true);


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOUBLE_LITERAL"

    // $ANTLR start "STRING_LITERAL"
    public final void mSTRING_LITERAL() throws RecognitionException {
        try {
            int _type = STRING_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:7474:15: ( ( ( '\\\"' ) ( '\\\"\\\"' |~ ( '\\\"' ) )* ( '\\\"' ) | ( '\\'' ) ( '\\'\\'' |~ ( '\\'' ) )* ( '\\'' ) ) )
            // Xpath2.g:7475:2: ( ( '\\\"' ) ( '\\\"\\\"' |~ ( '\\\"' ) )* ( '\\\"' ) | ( '\\'' ) ( '\\'\\'' |~ ( '\\'' ) )* ( '\\'' ) )
            {
            // Xpath2.g:7475:2: ( ( '\\\"' ) ( '\\\"\\\"' |~ ( '\\\"' ) )* ( '\\\"' ) | ( '\\'' ) ( '\\'\\'' |~ ( '\\'' ) )* ( '\\'' ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='\"') ) {
                alt15=1;
            }
            else if ( (LA15_0=='\'') ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;

            }
            switch (alt15) {
                case 1 :
                    // Xpath2.g:7475:3: ( '\\\"' ) ( '\\\"\\\"' |~ ( '\\\"' ) )* ( '\\\"' )
                    {
                    // Xpath2.g:7475:3: ( '\\\"' )
                    // Xpath2.g:7475:4: '\\\"'
                    {
                    match('\"'); 

                    }


                    // Xpath2.g:7475:9: ( '\\\"\\\"' |~ ( '\\\"' ) )*
                    loop13:
                    do {
                        int alt13=3;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0=='\"') ) {
                            int LA13_1 = input.LA(2);

                            if ( (LA13_1=='\"') ) {
                                alt13=1;
                            }


                        }
                        else if ( ((LA13_0 >= '\u0000' && LA13_0 <= '!')||(LA13_0 >= '#' && LA13_0 <= '\uFFFF')) ) {
                            alt13=2;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // Xpath2.g:7475:10: '\\\"\\\"'
                    	    {
                    	    match("\"\""); 



                    	    }
                    	    break;
                    	case 2 :
                    	    // Xpath2.g:7475:17: ~ ( '\\\"' )
                    	    {
                    	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    // Xpath2.g:7475:26: ( '\\\"' )
                    // Xpath2.g:7475:27: '\\\"'
                    {
                    match('\"'); 

                    }


                    }
                    break;
                case 2 :
                    // Xpath2.g:7475:33: ( '\\'' ) ( '\\'\\'' |~ ( '\\'' ) )* ( '\\'' )
                    {
                    // Xpath2.g:7475:33: ( '\\'' )
                    // Xpath2.g:7475:34: '\\''
                    {
                    match('\''); 

                    }


                    // Xpath2.g:7475:39: ( '\\'\\'' |~ ( '\\'' ) )*
                    loop14:
                    do {
                        int alt14=3;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0=='\'') ) {
                            int LA14_1 = input.LA(2);

                            if ( (LA14_1=='\'') ) {
                                alt14=1;
                            }


                        }
                        else if ( ((LA14_0 >= '\u0000' && LA14_0 <= '&')||(LA14_0 >= '(' && LA14_0 <= '\uFFFF')) ) {
                            alt14=2;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // Xpath2.g:7475:40: '\\'\\''
                    	    {
                    	    match("''"); 



                    	    }
                    	    break;
                    	case 2 :
                    	    // Xpath2.g:7475:47: ~ ( '\\'' )
                    	    {
                    	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '\uFFFF') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    // Xpath2.g:7475:56: ( '\\'' )
                    // Xpath2.g:7475:57: '\\''
                    {
                    match('\''); 

                    }


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING_LITERAL"

    // $ANTLR start "COMMENT_CONTENTS"
    public final void mCOMMENT_CONTENTS() throws RecognitionException {
        try {
            int _type = COMMENT_CONTENTS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:7477:17: ( ( '\\u0009' | '\\u000A' | '\\u000D' | '\\u0020' .. '\\uD7FF' | ( '\\uE000' .. '\\uFFFD' )+ ) )
            // Xpath2.g:7478:2: ( '\\u0009' | '\\u000A' | '\\u000D' | '\\u0020' .. '\\uD7FF' | ( '\\uE000' .. '\\uFFFD' )+ )
            {
            // Xpath2.g:7478:2: ( '\\u0009' | '\\u000A' | '\\u000D' | '\\u0020' .. '\\uD7FF' | ( '\\uE000' .. '\\uFFFD' )+ )
            int alt17=5;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='\t') ) {
                alt17=1;
            }
            else if ( (LA17_0=='\n') ) {
                alt17=2;
            }
            else if ( (LA17_0=='\r') ) {
                alt17=3;
            }
            else if ( ((LA17_0 >= ' ' && LA17_0 <= '\uD7FF')) ) {
                alt17=4;
            }
            else if ( ((LA17_0 >= '\uE000' && LA17_0 <= '\uFFFD')) ) {
                alt17=5;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }
            switch (alt17) {
                case 1 :
                    // Xpath2.g:7478:3: '\\u0009'
                    {
                    match('\t'); 

                    }
                    break;
                case 2 :
                    // Xpath2.g:7478:12: '\\u000A'
                    {
                    match('\n'); 

                    }
                    break;
                case 3 :
                    // Xpath2.g:7478:21: '\\u000D'
                    {
                    match('\r'); 

                    }
                    break;
                case 4 :
                    // Xpath2.g:7478:30: '\\u0020' .. '\\uD7FF'
                    {
                    matchRange(' ','\uD7FF'); 

                    }
                    break;
                case 5 :
                    // Xpath2.g:7478:49: ( '\\uE000' .. '\\uFFFD' )+
                    {
                    // Xpath2.g:7478:49: ( '\\uE000' .. '\\uFFFD' )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( ((LA16_0 >= '\uE000' && LA16_0 <= '\uFFFD')) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // Xpath2.g:
                    	    {
                    	    if ( (input.LA(1) >= '\uE000' && input.LA(1) <= '\uFFFD') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt16 >= 1 ) break loop16;
                                EarlyExitException eee =
                                    new EarlyExitException(16, input);
                                throw eee;
                        }
                        cnt16++;
                    } while (true);


                    }
                    break;

            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT_CONTENTS"

    // $ANTLR start "NCNAME"
    public final void mNCNAME() throws RecognitionException {
        try {
            int _type = NCNAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:7481:7: ( ( 'A' .. 'Z' | '_' | 'a' .. 'z' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u02FF' | '\\u0370' .. '\\u037D' | '\\u037F' .. '\\u1FFF' | '\\u200C' .. '\\u200D' | '\\u2070' .. '\\u218F' | '\\u2C00' .. '\\u2FEF' | '\\u3001' .. '\\uD7FF' | '\\uF900' .. '\\uFDCF' | '\\uFDF0' .. '\\uFFFD' ( 'A' .. 'Z' | '_' | 'a' .. 'z' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u02FF' | '\\u0370' .. '\\u037D' | '\\u037F' .. '\\u1FFF' | '\\u200C' .. '\\u200D' | '\\u2070' .. '\\u218F' | '\\u2C00' .. '\\u2FEF' | '\\u3001' .. '\\uD7FF' | '\\uF900' .. '\\uFDCF' | '\\uFDF0' .. '\\uFFFD' | '-' | '.' | '0' .. '9' | '\\u00B7' | '\\u0300' .. '\\u036F' | '\\u203F' .. '\\u2040' )* ) )
            // Xpath2.g:7482:2: ( 'A' .. 'Z' | '_' | 'a' .. 'z' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u02FF' | '\\u0370' .. '\\u037D' | '\\u037F' .. '\\u1FFF' | '\\u200C' .. '\\u200D' | '\\u2070' .. '\\u218F' | '\\u2C00' .. '\\u2FEF' | '\\u3001' .. '\\uD7FF' | '\\uF900' .. '\\uFDCF' | '\\uFDF0' .. '\\uFFFD' ( 'A' .. 'Z' | '_' | 'a' .. 'z' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u02FF' | '\\u0370' .. '\\u037D' | '\\u037F' .. '\\u1FFF' | '\\u200C' .. '\\u200D' | '\\u2070' .. '\\u218F' | '\\u2C00' .. '\\u2FEF' | '\\u3001' .. '\\uD7FF' | '\\uF900' .. '\\uFDCF' | '\\uFDF0' .. '\\uFFFD' | '-' | '.' | '0' .. '9' | '\\u00B7' | '\\u0300' .. '\\u036F' | '\\u203F' .. '\\u2040' )* )
            {
            // Xpath2.g:7482:2: ( 'A' .. 'Z' | '_' | 'a' .. 'z' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u02FF' | '\\u0370' .. '\\u037D' | '\\u037F' .. '\\u1FFF' | '\\u200C' .. '\\u200D' | '\\u2070' .. '\\u218F' | '\\u2C00' .. '\\u2FEF' | '\\u3001' .. '\\uD7FF' | '\\uF900' .. '\\uFDCF' | '\\uFDF0' .. '\\uFFFD' ( 'A' .. 'Z' | '_' | 'a' .. 'z' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u02FF' | '\\u0370' .. '\\u037D' | '\\u037F' .. '\\u1FFF' | '\\u200C' .. '\\u200D' | '\\u2070' .. '\\u218F' | '\\u2C00' .. '\\u2FEF' | '\\u3001' .. '\\uD7FF' | '\\uF900' .. '\\uFDCF' | '\\uFDF0' .. '\\uFFFD' | '-' | '.' | '0' .. '9' | '\\u00B7' | '\\u0300' .. '\\u036F' | '\\u203F' .. '\\u2040' )* )
            int alt19=14;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0 >= 'A' && LA19_0 <= 'Z')) ) {
                alt19=1;
            }
            else if ( (LA19_0=='_') ) {
                alt19=2;
            }
            else if ( ((LA19_0 >= 'a' && LA19_0 <= 'z')) ) {
                alt19=3;
            }
            else if ( ((LA19_0 >= '\u00C0' && LA19_0 <= '\u00D6')) ) {
                alt19=4;
            }
            else if ( ((LA19_0 >= '\u00D8' && LA19_0 <= '\u00F6')) ) {
                alt19=5;
            }
            else if ( ((LA19_0 >= '\u00F8' && LA19_0 <= '\u02FF')) ) {
                alt19=6;
            }
            else if ( ((LA19_0 >= '\u0370' && LA19_0 <= '\u037D')) ) {
                alt19=7;
            }
            else if ( ((LA19_0 >= '\u037F' && LA19_0 <= '\u1FFF')) ) {
                alt19=8;
            }
            else if ( ((LA19_0 >= '\u200C' && LA19_0 <= '\u200D')) ) {
                alt19=9;
            }
            else if ( ((LA19_0 >= '\u2070' && LA19_0 <= '\u218F')) ) {
                alt19=10;
            }
            else if ( ((LA19_0 >= '\u2C00' && LA19_0 <= '\u2FEF')) ) {
                alt19=11;
            }
            else if ( ((LA19_0 >= '\u3001' && LA19_0 <= '\uD7FF')) ) {
                alt19=12;
            }
            else if ( ((LA19_0 >= '\uF900' && LA19_0 <= '\uFDCF')) ) {
                alt19=13;
            }
            else if ( ((LA19_0 >= '\uFDF0' && LA19_0 <= '\uFFFD')) ) {
                alt19=14;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;

            }
            switch (alt19) {
                case 1 :
                    // Xpath2.g:7482:3: 'A' .. 'Z'
                    {
                    matchRange('A','Z'); 

                    }
                    break;
                case 2 :
                    // Xpath2.g:7482:12: '_'
                    {
                    match('_'); 

                    }
                    break;
                case 3 :
                    // Xpath2.g:7482:16: 'a' .. 'z'
                    {
                    matchRange('a','z'); 

                    }
                    break;
                case 4 :
                    // Xpath2.g:7482:25: '\\u00C0' .. '\\u00D6'
                    {
                    matchRange('\u00C0','\u00D6'); 

                    }
                    break;
                case 5 :
                    // Xpath2.g:7482:44: '\\u00D8' .. '\\u00F6'
                    {
                    matchRange('\u00D8','\u00F6'); 

                    }
                    break;
                case 6 :
                    // Xpath2.g:7482:63: '\\u00F8' .. '\\u02FF'
                    {
                    matchRange('\u00F8','\u02FF'); 

                    }
                    break;
                case 7 :
                    // Xpath2.g:7482:82: '\\u0370' .. '\\u037D'
                    {
                    matchRange('\u0370','\u037D'); 

                    }
                    break;
                case 8 :
                    // Xpath2.g:7482:101: '\\u037F' .. '\\u1FFF'
                    {
                    matchRange('\u037F','\u1FFF'); 

                    }
                    break;
                case 9 :
                    // Xpath2.g:7482:120: '\\u200C' .. '\\u200D'
                    {
                    matchRange('\u200C','\u200D'); 

                    }
                    break;
                case 10 :
                    // Xpath2.g:7482:139: '\\u2070' .. '\\u218F'
                    {
                    matchRange('\u2070','\u218F'); 

                    }
                    break;
                case 11 :
                    // Xpath2.g:7482:158: '\\u2C00' .. '\\u2FEF'
                    {
                    matchRange('\u2C00','\u2FEF'); 

                    }
                    break;
                case 12 :
                    // Xpath2.g:7482:177: '\\u3001' .. '\\uD7FF'
                    {
                    matchRange('\u3001','\uD7FF'); 

                    }
                    break;
                case 13 :
                    // Xpath2.g:7482:196: '\\uF900' .. '\\uFDCF'
                    {
                    matchRange('\uF900','\uFDCF'); 

                    }
                    break;
                case 14 :
                    // Xpath2.g:7482:215: '\\uFDF0' .. '\\uFFFD' ( 'A' .. 'Z' | '_' | 'a' .. 'z' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u02FF' | '\\u0370' .. '\\u037D' | '\\u037F' .. '\\u1FFF' | '\\u200C' .. '\\u200D' | '\\u2070' .. '\\u218F' | '\\u2C00' .. '\\u2FEF' | '\\u3001' .. '\\uD7FF' | '\\uF900' .. '\\uFDCF' | '\\uFDF0' .. '\\uFFFD' | '-' | '.' | '0' .. '9' | '\\u00B7' | '\\u0300' .. '\\u036F' | '\\u203F' .. '\\u2040' )*
                    {
                    matchRange('\uFDF0','\uFFFD'); 

                    // Xpath2.g:7482:233: ( 'A' .. 'Z' | '_' | 'a' .. 'z' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u02FF' | '\\u0370' .. '\\u037D' | '\\u037F' .. '\\u1FFF' | '\\u200C' .. '\\u200D' | '\\u2070' .. '\\u218F' | '\\u2C00' .. '\\u2FEF' | '\\u3001' .. '\\uD7FF' | '\\uF900' .. '\\uFDCF' | '\\uFDF0' .. '\\uFFFD' | '-' | '.' | '0' .. '9' | '\\u00B7' | '\\u0300' .. '\\u036F' | '\\u203F' .. '\\u2040' )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( ((LA18_0 >= '-' && LA18_0 <= '.')||(LA18_0 >= '0' && LA18_0 <= '9')||(LA18_0 >= 'A' && LA18_0 <= 'Z')||LA18_0=='_'||(LA18_0 >= 'a' && LA18_0 <= 'z')||LA18_0=='\u00B7'||(LA18_0 >= '\u00C0' && LA18_0 <= '\u00D6')||(LA18_0 >= '\u00D8' && LA18_0 <= '\u00F6')||(LA18_0 >= '\u00F8' && LA18_0 <= '\u037D')||(LA18_0 >= '\u037F' && LA18_0 <= '\u1FFF')||(LA18_0 >= '\u200C' && LA18_0 <= '\u200D')||(LA18_0 >= '\u203F' && LA18_0 <= '\u2040')||(LA18_0 >= '\u2070' && LA18_0 <= '\u218F')||(LA18_0 >= '\u2C00' && LA18_0 <= '\u2FEF')||(LA18_0 >= '\u3001' && LA18_0 <= '\uD7FF')||(LA18_0 >= '\uF900' && LA18_0 <= '\uFDCF')||(LA18_0 >= '\uFDF0' && LA18_0 <= '\uFFFD')) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // Xpath2.g:
                    	    {
                    	    if ( (input.LA(1) >= '-' && input.LA(1) <= '.')||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z')||input.LA(1)=='\u00B7'||(input.LA(1) >= '\u00C0' && input.LA(1) <= '\u00D6')||(input.LA(1) >= '\u00D8' && input.LA(1) <= '\u00F6')||(input.LA(1) >= '\u00F8' && input.LA(1) <= '\u037D')||(input.LA(1) >= '\u037F' && input.LA(1) <= '\u1FFF')||(input.LA(1) >= '\u200C' && input.LA(1) <= '\u200D')||(input.LA(1) >= '\u203F' && input.LA(1) <= '\u2040')||(input.LA(1) >= '\u2070' && input.LA(1) <= '\u218F')||(input.LA(1) >= '\u2C00' && input.LA(1) <= '\u2FEF')||(input.LA(1) >= '\u3001' && input.LA(1) <= '\uD7FF')||(input.LA(1) >= '\uF900' && input.LA(1) <= '\uFDCF')||(input.LA(1) >= '\uFDF0' && input.LA(1) <= '\uFFFD') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NCNAME"

    // $ANTLR start "TEXT"
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:7484:5: ( ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ ) )
            // Xpath2.g:7485:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            {
            // Xpath2.g:7485:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            // Xpath2.g:7485:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            {
            // Xpath2.g:7485:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0=='-'||(LA20_0 >= '0' && LA20_0 <= '9')||(LA20_0 >= 'A' && LA20_0 <= 'Z')||LA20_0=='_'||(LA20_0 >= 'a' && LA20_0 <= 'z')) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // Xpath2.g:
            	    {
            	    if ( input.LA(1)=='-'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt20 >= 1 ) break loop20;
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
            } while (true);


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TEXT"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:7487:11: ( ( ( ' ' | '\\t' | '\\f' ) ) )
            // Xpath2.g:7488:2: ( ( ' ' | '\\t' | '\\f' ) )
            {
            if ( input.LA(1)=='\t'||input.LA(1)=='\f'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHITESPACE"

    // $ANTLR start "LINEBREAK"
    public final void mLINEBREAK() throws RecognitionException {
        try {
            int _type = LINEBREAK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Xpath2.g:7491:10: ( ( ( '\\r\\n' | '\\r' | '\\n' ) ) )
            // Xpath2.g:7492:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            {
            // Xpath2.g:7492:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // Xpath2.g:7492:3: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // Xpath2.g:7492:3: ( '\\r\\n' | '\\r' | '\\n' )
            int alt21=3;
            int LA21_0 = input.LA(1);

            if ( (LA21_0=='\r') ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1=='\n') ) {
                    alt21=1;
                }
                else {
                    alt21=2;
                }
            }
            else if ( (LA21_0=='\n') ) {
                alt21=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;

            }
            switch (alt21) {
                case 1 :
                    // Xpath2.g:7492:4: '\\r\\n'
                    {
                    match("\r\n"); 



                    }
                    break;
                case 2 :
                    // Xpath2.g:7492:13: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // Xpath2.g:7492:20: '\\n'
                    {
                    match('\n'); 

                    }
                    break;

            }


            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LINEBREAK"

    public void mTokens() throws RecognitionException {
        // Xpath2.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | INTEGER_LITERAL | DECIMAL_LITERAL | DOUBLE_LITERAL | STRING_LITERAL | COMMENT_CONTENTS | NCNAME | TEXT | WHITESPACE | LINEBREAK )
        int alt22=76;
        alt22 = dfa22.predict(input);
        switch (alt22) {
            case 1 :
                // Xpath2.g:1:10: T__13
                {
                mT__13(); 


                }
                break;
            case 2 :
                // Xpath2.g:1:16: T__14
                {
                mT__14(); 


                }
                break;
            case 3 :
                // Xpath2.g:1:22: T__15
                {
                mT__15(); 


                }
                break;
            case 4 :
                // Xpath2.g:1:28: T__16
                {
                mT__16(); 


                }
                break;
            case 5 :
                // Xpath2.g:1:34: T__17
                {
                mT__17(); 


                }
                break;
            case 6 :
                // Xpath2.g:1:40: T__18
                {
                mT__18(); 


                }
                break;
            case 7 :
                // Xpath2.g:1:46: T__19
                {
                mT__19(); 


                }
                break;
            case 8 :
                // Xpath2.g:1:52: T__20
                {
                mT__20(); 


                }
                break;
            case 9 :
                // Xpath2.g:1:58: T__21
                {
                mT__21(); 


                }
                break;
            case 10 :
                // Xpath2.g:1:64: T__22
                {
                mT__22(); 


                }
                break;
            case 11 :
                // Xpath2.g:1:70: T__23
                {
                mT__23(); 


                }
                break;
            case 12 :
                // Xpath2.g:1:76: T__24
                {
                mT__24(); 


                }
                break;
            case 13 :
                // Xpath2.g:1:82: T__25
                {
                mT__25(); 


                }
                break;
            case 14 :
                // Xpath2.g:1:88: T__26
                {
                mT__26(); 


                }
                break;
            case 15 :
                // Xpath2.g:1:94: T__27
                {
                mT__27(); 


                }
                break;
            case 16 :
                // Xpath2.g:1:100: T__28
                {
                mT__28(); 


                }
                break;
            case 17 :
                // Xpath2.g:1:106: T__29
                {
                mT__29(); 


                }
                break;
            case 18 :
                // Xpath2.g:1:112: T__30
                {
                mT__30(); 


                }
                break;
            case 19 :
                // Xpath2.g:1:118: T__31
                {
                mT__31(); 


                }
                break;
            case 20 :
                // Xpath2.g:1:124: T__32
                {
                mT__32(); 


                }
                break;
            case 21 :
                // Xpath2.g:1:130: T__33
                {
                mT__33(); 


                }
                break;
            case 22 :
                // Xpath2.g:1:136: T__34
                {
                mT__34(); 


                }
                break;
            case 23 :
                // Xpath2.g:1:142: T__35
                {
                mT__35(); 


                }
                break;
            case 24 :
                // Xpath2.g:1:148: T__36
                {
                mT__36(); 


                }
                break;
            case 25 :
                // Xpath2.g:1:154: T__37
                {
                mT__37(); 


                }
                break;
            case 26 :
                // Xpath2.g:1:160: T__38
                {
                mT__38(); 


                }
                break;
            case 27 :
                // Xpath2.g:1:166: T__39
                {
                mT__39(); 


                }
                break;
            case 28 :
                // Xpath2.g:1:172: T__40
                {
                mT__40(); 


                }
                break;
            case 29 :
                // Xpath2.g:1:178: T__41
                {
                mT__41(); 


                }
                break;
            case 30 :
                // Xpath2.g:1:184: T__42
                {
                mT__42(); 


                }
                break;
            case 31 :
                // Xpath2.g:1:190: T__43
                {
                mT__43(); 


                }
                break;
            case 32 :
                // Xpath2.g:1:196: T__44
                {
                mT__44(); 


                }
                break;
            case 33 :
                // Xpath2.g:1:202: T__45
                {
                mT__45(); 


                }
                break;
            case 34 :
                // Xpath2.g:1:208: T__46
                {
                mT__46(); 


                }
                break;
            case 35 :
                // Xpath2.g:1:214: T__47
                {
                mT__47(); 


                }
                break;
            case 36 :
                // Xpath2.g:1:220: T__48
                {
                mT__48(); 


                }
                break;
            case 37 :
                // Xpath2.g:1:226: T__49
                {
                mT__49(); 


                }
                break;
            case 38 :
                // Xpath2.g:1:232: T__50
                {
                mT__50(); 


                }
                break;
            case 39 :
                // Xpath2.g:1:238: T__51
                {
                mT__51(); 


                }
                break;
            case 40 :
                // Xpath2.g:1:244: T__52
                {
                mT__52(); 


                }
                break;
            case 41 :
                // Xpath2.g:1:250: T__53
                {
                mT__53(); 


                }
                break;
            case 42 :
                // Xpath2.g:1:256: T__54
                {
                mT__54(); 


                }
                break;
            case 43 :
                // Xpath2.g:1:262: T__55
                {
                mT__55(); 


                }
                break;
            case 44 :
                // Xpath2.g:1:268: T__56
                {
                mT__56(); 


                }
                break;
            case 45 :
                // Xpath2.g:1:274: T__57
                {
                mT__57(); 


                }
                break;
            case 46 :
                // Xpath2.g:1:280: T__58
                {
                mT__58(); 


                }
                break;
            case 47 :
                // Xpath2.g:1:286: T__59
                {
                mT__59(); 


                }
                break;
            case 48 :
                // Xpath2.g:1:292: T__60
                {
                mT__60(); 


                }
                break;
            case 49 :
                // Xpath2.g:1:298: T__61
                {
                mT__61(); 


                }
                break;
            case 50 :
                // Xpath2.g:1:304: T__62
                {
                mT__62(); 


                }
                break;
            case 51 :
                // Xpath2.g:1:310: T__63
                {
                mT__63(); 


                }
                break;
            case 52 :
                // Xpath2.g:1:316: T__64
                {
                mT__64(); 


                }
                break;
            case 53 :
                // Xpath2.g:1:322: T__65
                {
                mT__65(); 


                }
                break;
            case 54 :
                // Xpath2.g:1:328: T__66
                {
                mT__66(); 


                }
                break;
            case 55 :
                // Xpath2.g:1:334: T__67
                {
                mT__67(); 


                }
                break;
            case 56 :
                // Xpath2.g:1:340: T__68
                {
                mT__68(); 


                }
                break;
            case 57 :
                // Xpath2.g:1:346: T__69
                {
                mT__69(); 


                }
                break;
            case 58 :
                // Xpath2.g:1:352: T__70
                {
                mT__70(); 


                }
                break;
            case 59 :
                // Xpath2.g:1:358: T__71
                {
                mT__71(); 


                }
                break;
            case 60 :
                // Xpath2.g:1:364: T__72
                {
                mT__72(); 


                }
                break;
            case 61 :
                // Xpath2.g:1:370: T__73
                {
                mT__73(); 


                }
                break;
            case 62 :
                // Xpath2.g:1:376: T__74
                {
                mT__74(); 


                }
                break;
            case 63 :
                // Xpath2.g:1:382: T__75
                {
                mT__75(); 


                }
                break;
            case 64 :
                // Xpath2.g:1:388: T__76
                {
                mT__76(); 


                }
                break;
            case 65 :
                // Xpath2.g:1:394: T__77
                {
                mT__77(); 


                }
                break;
            case 66 :
                // Xpath2.g:1:400: T__78
                {
                mT__78(); 


                }
                break;
            case 67 :
                // Xpath2.g:1:406: T__79
                {
                mT__79(); 


                }
                break;
            case 68 :
                // Xpath2.g:1:412: INTEGER_LITERAL
                {
                mINTEGER_LITERAL(); 


                }
                break;
            case 69 :
                // Xpath2.g:1:428: DECIMAL_LITERAL
                {
                mDECIMAL_LITERAL(); 


                }
                break;
            case 70 :
                // Xpath2.g:1:444: DOUBLE_LITERAL
                {
                mDOUBLE_LITERAL(); 


                }
                break;
            case 71 :
                // Xpath2.g:1:459: STRING_LITERAL
                {
                mSTRING_LITERAL(); 


                }
                break;
            case 72 :
                // Xpath2.g:1:474: COMMENT_CONTENTS
                {
                mCOMMENT_CONTENTS(); 


                }
                break;
            case 73 :
                // Xpath2.g:1:491: NCNAME
                {
                mNCNAME(); 


                }
                break;
            case 74 :
                // Xpath2.g:1:498: TEXT
                {
                mTEXT(); 


                }
                break;
            case 75 :
                // Xpath2.g:1:503: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 76 :
                // Xpath2.g:1:514: LINEBREAK
                {
                mLINEBREAK(); 


                }
                break;

        }

    }


    protected DFA22 dfa22 = new DFA22(this);
    static final String DFA22_eotS =
        "\1\uffff\1\66\6\uffff\1\77\1\102\1\105\1\107\1\112\1\uffff\1\116"+
        "\4\uffff\16\66\1\164\2\66\2\uffff\2\66\1\uffff\2\66\12\uffff\1\66"+
        "\15\uffff\1\174\17\uffff\10\100\1\u0087\2\100\1\u008b\1\u008c\1"+
        "\u008d\1\u008e\1\u008f\1\100\1\u0091\1\u0092\1\100\1\u0094\1\100"+
        "\1\u0096\11\100\1\u00a1\1\uffff\1\164\1\174\1\100\2\uffff\1\66\2"+
        "\uffff\1\100\1\u00a7\10\100\1\uffff\2\100\1\u00b2\5\uffff\1\100"+
        "\2\uffff\1\100\1\uffff\1\100\1\uffff\12\100\1\uffff\1\174\1\uffff"+
        "\1\100\1\u00a3\1\100\1\uffff\6\100\1\u00c7\3\100\1\uffff\1\u00cb"+
        "\1\100\1\u00cd\6\100\1\u00d4\1\u00d5\1\u00d6\1\u00d7\2\100\1\u00da"+
        "\4\100\1\uffff\1\100\1\u00e0\1\100\1\uffff\1\100\1\uffff\6\100\4"+
        "\uffff\2\100\1\uffff\5\100\1\uffff\2\100\1\u00f2\2\100\1\u00f5\4"+
        "\100\1\u00fa\2\100\1\u00fd\3\100\1\uffff\2\100\1\uffff\2\100\1\u0107"+
        "\1\100\1\uffff\2\100\1\uffff\11\100\1\uffff\1\u0114\3\100\1\u0119"+
        "\1\u011a\1\u011c\1\100\1\u011e\3\100\1\uffff\1\u0123\3\100\2\uffff"+
        "\1\100\1\uffff\1\100\1\uffff\4\100\1\uffff\22\100\1\u013f\10\100"+
        "\1\uffff\1\u0148\4\100\1\u014d\2\100\1\uffff\4\100\1\uffff\1\u0154"+
        "\4\100\1\u0159\1\uffff\1\100\1\u015b\1\u015c\1\100\1\uffff\1\u015e"+
        "\2\uffff\1\100\1\uffff\3\100\1\u0163\1\uffff";
    static final String DFA22_eofS =
        "\u0164\uffff";
    static final String DFA22_minS =
        "\1\11\1\75\6\uffff\1\55\1\56\1\57\1\72\1\74\1\uffff\1\75\4\uffff"+
        "\17\55\2\0\2\uffff\1\12\1\55\1\uffff\2\55\12\uffff\1\55\15\uffff"+
        "\1\60\17\uffff\1\143\1\164\1\151\1\155\1\163\1\143\1\145\1\160\1"+
        "\55\1\145\1\154\5\55\1\145\2\55\1\155\1\55\1\144\1\55\1\162\1\145"+
        "\2\164\1\150\1\154\1\155\1\170\1\145\1\55\1\uffff\1\55\1\60\1\53"+
        "\2\uffff\1\55\2\uffff\1\145\1\55\1\162\1\154\1\155\1\143\1\165\1"+
        "\155\1\145\1\164\1\uffff\1\162\1\154\1\55\5\uffff\1\155\2\uffff"+
        "\1\145\1\uffff\1\145\1\uffff\1\145\2\143\1\165\1\151\1\145\1\146"+
        "\1\145\1\164\1\156\1\uffff\1\60\1\uffff\1\60\1\55\1\163\1\uffff"+
        "\1\151\1\144\2\145\1\155\1\145\1\55\2\171\1\157\1\uffff\1\55\1\163"+
        "\1\55\1\156\2\145\1\162\1\163\1\155\4\55\1\164\1\142\1\55\2\156"+
        "\1\145\1\156\1\uffff\2\55\1\167\1\uffff\1\160\1\uffff\1\164\1\144"+
        "\1\163\1\156\1\146\1\141\4\uffff\1\157\1\165\1\uffff\1\164\1\144"+
        "\1\156\1\164\1\163\1\uffff\1\151\1\141\1\55\1\151\1\163\1\55\1\151"+
        "\1\55\1\162\1\164\1\55\1\141\1\164\1\55\1\145\1\156\1\143\1\uffff"+
        "\1\156\1\151\1\uffff\1\145\1\141\1\55\1\145\1\uffff\1\156\1\55\1"+
        "\uffff\1\161\1\147\1\145\1\147\1\156\1\163\1\164\1\154\1\157\1\uffff"+
        "\1\55\1\164\1\156\1\165\3\55\1\147\1\55\1\164\1\145\1\162\1\uffff"+
        "\1\55\1\157\1\145\1\163\2\uffff\1\163\1\uffff\1\55\1\uffff\1\162"+
        "\1\155\1\55\1\157\1\uffff\1\144\1\156\4\151\1\145\1\163\1\162\1"+
        "\145\1\143\2\142\1\156\1\142\1\156\1\145\2\55\1\145\2\154\1\163"+
        "\1\165\1\164\1\154\1\163\1\uffff\1\55\2\151\2\164\1\55\1\146\1\145"+
        "\1\uffff\2\156\1\162\1\145\1\uffff\1\55\1\154\2\147\1\165\1\55\1"+
        "\uffff\1\146\2\55\1\143\1\uffff\1\55\2\uffff\1\164\1\uffff\1\151"+
        "\1\157\1\156\1\55\1\uffff";
    static final String DFA22_maxS =
        "\1\ufffd\1\75\6\uffff\1\172\1\71\1\57\1\72\1\75\1\uffff\1\76\4\uffff"+
        "\17\172\2\uffff\2\uffff\1\12\1\172\1\uffff\2\172\12\uffff\1\ufffd"+
        "\15\uffff\1\71\17\uffff\1\144\1\164\1\151\1\155\1\163\1\143\1\163"+
        "\1\160\1\172\1\145\1\162\5\172\1\145\2\172\1\155\1\172\1\144\1\172"+
        "\1\162\1\157\2\164\1\150\1\154\1\155\1\170\1\145\1\172\1\uffff\1"+
        "\172\1\145\1\71\2\uffff\1\ufffd\2\uffff\1\145\1\172\1\162\1\154"+
        "\1\155\1\143\1\165\1\155\1\145\1\164\1\uffff\1\162\1\154\1\172\5"+
        "\uffff\1\155\2\uffff\1\145\1\uffff\1\145\1\uffff\1\145\2\143\1\165"+
        "\1\151\1\145\1\146\1\145\1\164\1\156\1\uffff\1\145\1\uffff\1\71"+
        "\1\172\1\163\1\uffff\1\151\1\144\2\145\1\155\1\145\1\172\2\171\1"+
        "\157\1\uffff\1\172\1\163\1\172\1\156\2\145\1\162\1\163\1\155\4\172"+
        "\1\164\1\142\1\172\2\156\1\145\1\156\1\uffff\1\55\1\172\1\167\1"+
        "\uffff\1\160\1\uffff\1\164\1\144\1\163\1\156\1\146\1\141\4\uffff"+
        "\1\157\1\165\1\uffff\1\164\1\144\1\156\1\164\1\163\1\uffff\1\151"+
        "\1\141\1\172\1\151\1\163\1\172\1\151\1\55\1\162\1\164\1\172\1\141"+
        "\1\164\1\172\1\145\1\156\1\143\1\uffff\1\156\1\151\1\uffff\2\145"+
        "\1\172\1\145\1\uffff\1\156\1\55\1\uffff\1\161\1\147\1\145\1\147"+
        "\1\156\1\163\1\164\1\154\1\157\1\uffff\1\172\1\164\1\156\1\165\3"+
        "\172\1\147\1\172\1\164\1\145\1\162\1\uffff\1\172\1\157\1\145\1\163"+
        "\2\uffff\1\163\1\uffff\1\55\1\uffff\1\162\1\155\1\55\1\157\1\uffff"+
        "\1\144\1\156\4\151\1\145\1\163\1\162\1\145\1\143\2\142\1\156\1\142"+
        "\1\156\1\145\1\55\1\172\1\145\2\154\1\163\1\165\1\164\1\154\1\163"+
        "\1\uffff\1\172\2\151\2\164\1\172\1\146\1\145\1\uffff\2\156\1\162"+
        "\1\145\1\uffff\1\172\1\154\2\147\1\165\1\172\1\uffff\1\146\2\172"+
        "\1\143\1\uffff\1\172\2\uffff\1\164\1\uffff\1\151\1\157\1\156\1\172"+
        "\1\uffff";
    static final String DFA22_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\5\1\6\1\7\5\uffff\1\22\1\uffff\1\26\1\27"+
        "\1\30\1\31\21\uffff\2\110\2\uffff\1\110\2\uffff\12\110\1\uffff\1"+
        "\110\1\113\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\112\1\12\1\11\1\uffff"+
        "\1\14\1\13\1\16\1\15\1\20\1\21\1\17\1\22\1\24\1\25\1\23\1\26\1\27"+
        "\1\30\1\31\41\uffff\1\104\3\uffff\1\107\1\114\1\uffff\1\111\1\105"+
        "\12\uffff\1\46\3\uffff\1\53\1\54\1\55\1\56\1\57\1\uffff\1\61\1\62"+
        "\1\uffff\1\64\1\uffff\1\66\12\uffff\1\103\1\uffff\1\106\3\uffff"+
        "\1\34\12\uffff\1\52\24\uffff\1\44\3\uffff\1\60\1\uffff\1\65\6\uffff"+
        "\1\77\1\100\1\101\1\102\2\uffff\1\36\5\uffff\1\47\21\uffff\1\67"+
        "\2\uffff\1\73\4\uffff\1\37\2\uffff\1\43\11\uffff\1\32\14\uffff\1"+
        "\35\4\uffff\1\50\1\63\1\uffff\1\70\1\uffff\1\74\4\uffff\1\40\33"+
        "\uffff\1\42\10\uffff\1\45\4\uffff\1\76\6\uffff\1\33\4\uffff\1\75"+
        "\1\uffff\1\51\1\71\1\uffff\1\41\4\uffff\1\72";
    static final String DFA22_specialS =
        "\42\uffff\1\1\1\0\u0140\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\44\1\45\1\uffff\1\67\1\46\22\uffff\1\64\1\1\1\42\1\66\1\2"+
            "\2\66\1\43\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\12\41\1\13\1\66"+
            "\1\14\1\15\1\16\1\17\1\20\32\47\1\21\1\66\1\22\1\66\1\51\1\66"+
            "\1\23\1\52\1\24\1\25\1\26\1\27\1\30\1\52\1\31\2\52\1\32\1\52"+
            "\1\33\1\34\1\35\1\52\1\36\1\37\1\40\6\52\105\66\27\53\1\66\37"+
            "\54\1\66\u0208\55\160\66\16\56\1\66\u1c81\57\14\66\2\60\142"+
            "\66\u0120\61\u0a70\66\u03f0\62\21\66\ua7ff\63\u0800\uffff\u1900"+
            "\66\u04d0\50\40\66\u020e\65",
            "\1\70",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\101\1\uffff\12\103",
            "\1\104",
            "\1\106",
            "\1\110\1\111",
            "",
            "\1\114\1\115",
            "",
            "",
            "",
            "",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\15\100\1\123\5\100\1\124\6\100",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\7\100\1\125\6\100\1\126\13\100",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\4\100\1\127\11\100\1\130\13\100",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\13\100\1\131\1\132\3\100\1\133\4\100\1\134\4\100",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\16\100\1\135\13\100",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\4\100\1\136\16\100\1\137\6\100",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\5\100\1\140\7\100\1\141\4\100\1\142\1\143\6\100",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\4\100\1\144\16\100\1\145\6\100",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\1\146\3\100\1\147\11\100\1\150\13\100",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\21\100\1\151\10\100",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\1\152\20\100\1\153\10\100",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\4\100\1\154\25\100",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\1\155\1\100\1\156\1\100\1\157\11\100\1\160\13\100",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\4\100\1\161\2\100\1\162\6\100\1\163\13\100",
            "\1\100\1\166\1\uffff\12\165\7\uffff\4\100\1\167\25\100\4\uffff"+
            "\1\100\1\uffff\4\100\1\167\25\100",
            "\0\170",
            "\0\170",
            "",
            "",
            "\1\171",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\2\173\1\uffff\12\173\7\uffff\32\173\4\uffff\1\173\1\uffff"+
            "\32\173\74\uffff\1\173\10\uffff\27\173\1\uffff\37\173\1\uffff"+
            "\u0286\173\1\uffff\u1c81\173\14\uffff\2\173\61\uffff\2\173\57"+
            "\uffff\u0120\173\u0a70\uffff\u03f0\173\21\uffff\ua7ff\173\u2100"+
            "\uffff\u04d0\172\40\uffff\u020e\172",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\103",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\175\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084\15\uffff\1\u0085",
            "\1\u0086",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u0088",
            "\1\u0089\5\uffff\1\u008a",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u0090",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u0093",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u0095",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u0097",
            "\1\u0098\11\uffff\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "",
            "\1\100\1\166\1\uffff\12\165\7\uffff\4\100\1\167\25\100\4\uffff"+
            "\1\100\1\uffff\4\100\1\167\25\100",
            "\12\u00a2\13\uffff\1\u00a3\37\uffff\1\u00a3",
            "\1\u00a3\1\uffff\1\u00a4\2\uffff\12\u00a5",
            "",
            "",
            "\2\173\1\uffff\12\173\7\uffff\32\173\4\uffff\1\173\1\uffff"+
            "\32\173\74\uffff\1\173\10\uffff\27\173\1\uffff\37\173\1\uffff"+
            "\u0286\173\1\uffff\u1c81\173\14\uffff\2\173\61\uffff\2\173\57"+
            "\uffff\u0120\173\u0a70\uffff\u03f0\173\21\uffff\ua7ff\173\u2100"+
            "\uffff\u04d0\172\40\uffff\u020e\172",
            "",
            "",
            "\1\u00a6",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "",
            "\1\u00b0",
            "\1\u00b1",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "",
            "",
            "",
            "",
            "",
            "\1\u00b3",
            "",
            "",
            "\1\u00b4",
            "",
            "\1\u00b5",
            "",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00bf",
            "",
            "\12\u00a2\13\uffff\1\u00a3\37\uffff\1\u00a3",
            "",
            "\12\u00a5",
            "\1\100\2\uffff\12\u00a5\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u00c0",
            "",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u00cc",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u00d8",
            "\1\u00d9",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u00db",
            "\1\u00dc",
            "\1\u00dd",
            "\1\u00de",
            "",
            "\1\u00df",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u00e1",
            "",
            "\1\u00e2",
            "",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
            "\1\u00e7",
            "\1\u00e8",
            "",
            "",
            "",
            "",
            "\1\u00e9",
            "\1\u00ea",
            "",
            "\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "\1\u00ee",
            "\1\u00ef",
            "",
            "\1\u00f0",
            "\1\u00f1",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u00f3",
            "\1\u00f4",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u00f6",
            "\1\u00f7",
            "\1\u00f8",
            "\1\u00f9",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u00fb",
            "\1\u00fc",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "",
            "\1\u0101",
            "\1\u0102",
            "",
            "\1\u0103",
            "\1\u0104\3\uffff\1\u0105",
            "\1\u0106\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u0108",
            "",
            "\1\u0109",
            "\1\u010a",
            "",
            "\1\u010b",
            "\1\u010c",
            "\1\u010d",
            "\1\u010e",
            "\1\u010f",
            "\1\u0110",
            "\1\u0111",
            "\1\u0112",
            "\1\u0113",
            "",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u0115",
            "\1\u0116",
            "\1\u0117",
            "\1\u0118\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u011b\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u011d",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u011f",
            "\1\u0120",
            "\1\u0121",
            "",
            "\1\u0122\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u0124",
            "\1\u0125",
            "\1\u0126",
            "",
            "",
            "\1\u0127",
            "",
            "\1\u0128",
            "",
            "\1\u0129",
            "\1\u012a",
            "\1\u012b",
            "\1\u012c",
            "",
            "\1\u012d",
            "\1\u012e",
            "\1\u012f",
            "\1\u0130",
            "\1\u0131",
            "\1\u0132",
            "\1\u0133",
            "\1\u0134",
            "\1\u0135",
            "\1\u0136",
            "\1\u0137",
            "\1\u0138",
            "\1\u0139",
            "\1\u013a",
            "\1\u013b",
            "\1\u013c",
            "\1\u013d",
            "\1\u013e",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u0140",
            "\1\u0141",
            "\1\u0142",
            "\1\u0143",
            "\1\u0144",
            "\1\u0145",
            "\1\u0146",
            "\1\u0147",
            "",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u0149",
            "\1\u014a",
            "\1\u014b",
            "\1\u014c",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u014e",
            "\1\u014f",
            "",
            "\1\u0150",
            "\1\u0151",
            "\1\u0152",
            "\1\u0153",
            "",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u0155",
            "\1\u0156",
            "\1\u0157",
            "\1\u0158",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "",
            "\1\u015a",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "\1\u015d",
            "",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            "",
            "",
            "\1\u015f",
            "",
            "\1\u0160",
            "\1\u0161",
            "\1\u0162",
            "\1\100\2\uffff\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff"+
            "\32\100",
            ""
    };

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | INTEGER_LITERAL | DECIMAL_LITERAL | DOUBLE_LITERAL | STRING_LITERAL | COMMENT_CONTENTS | NCNAME | TEXT | WHITESPACE | LINEBREAK );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA22_35 = input.LA(1);

                        s = -1;
                        if ( ((LA22_35 >= '\u0000' && LA22_35 <= '\uFFFF')) ) {s = 120;}

                        else s = 54;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA22_34 = input.LA(1);

                        s = -1;
                        if ( ((LA22_34 >= '\u0000' && LA22_34 <= '\uFFFF')) ) {s = 120;}

                        else s = 54;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 22, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

}