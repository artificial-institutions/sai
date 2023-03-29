//To generate the grammar files, type antlr4 sai_constitutive.g

grammar sai_constitutive;


@header
{
package lang.parser;

}



@members{

  
}




constitutive_spec	:	normative_id (status_functions)? constitutive_rules;
normative_id		:	'institution_id' ':' ATOM '.';

status_functions	:	'status_functions'':'(agent_sf_decl|event_sf_decl|state_sf_decl)+; //choice pattern
agent_sf_decl		:	'agents'':' agent_sf_list '.'; //sequence
agent_sf_list		:	agent_sf(','agent_sf)*;	//sequence with separator
event_sf_decl		:	'events'':' event_sf_list '.'; //sequence
event_sf_list		:	event_sf(','event_sf)*;	//sequence with separator
state_sf_decl		:	'states'':' state_sf_list '.'; //sequence
state_sf_list		:	state_sf(','state_sf)*;	//sequence with separator

constitutive_rules	:	'constitutive_rules' ':' const_rule+;
const_rule		:	id ':' count_as_stat t? m?'.';
id			:	DIGIT+;
count_as_stat		:	(x? 'count-as' y);
y			:	pred;
x			:	(VAR|pred);
t			:	'when' event_sf ;
m			:	'while' sf_formula;

agent_sf:	ATOM;
event_sf:	pred|(VAR(annotation)?);
state_sf:	pred;

agent_x:	ATOM;
event_x:	pred;
state_x:	pred;



sf_formula	:	sff_or_expr;
sff_or_expr	:	sff_and_expr (TK_OR sff_or_expr)?;
sff_and_expr	:	sff_rel (TK_AND sff_and_expr)?;	
//sff_rel	:		arithm_term(TK_REL_OP sff_rel)?;
sff_rel	:		arithm_term((TK_REL_OP|TK_IS) sff_rel)?; 
arithm_term	:	arithm_factor (('+'|'-') arithm_term)?;
arithm_factor	:	sff_atom (('*'|'/'|INTDIV|INTMOD) arithm_factor)?;
//sff_atom	:       NEGATION? (((VAR|pred)('is' (VAR|pred))?)|('('sff_or_expr')')|(DIGIT+));
sff_atom	:       NEGATION? ((VAR|pred|sai__is_term)|('('sff_or_expr')')|(DIGIT+));

TK_OR		:	'|';
TK_AND		:	'&';
TK_REL_OP	:	'<' | '<=' | '>' | '>=' | '==' | '\\==' | '=' | '=..';
TK_IS		:	'is';



/*** Template for arithm.expressions ***
arithm_expression	:	arithm_term;
arithm_term		:	arithm_factor (('+'|'-') arithm_term)?;
arithm_factor		:	arithm_atom (('*'|'/'|INTDIV|INTMOD) arithm_factor)?;
arithm_atom		:	VAR|DIGIT+|'('arithm_term')';	//the basic element of arithm.expressions

*/


sai__is_term:	'sai__is('pred_term','pred_term','sf_formula')';

pred	:	//ATOM(list)?;
		//(TK_NEG)?ATOM(list_of_pred_terms)?(list)?;
		ATOM(list_of_pred_terms)?(list)?;
list_of_pred_terms
	:	'('pred_terms')';
pred_terms
	:	pred_term(','pred_term)*;	
pred_term
	:	//VAR|TERM_NULL|STRING|DIGIT+|ATOM(list_of_pred_terms)?|list_of_pred_terms;
	       VAR|TERM_NULL|STRING|DIGIT+|ATOM(list_of_pred_terms)?|('('sff_or_expr')');
annotation
	:	list;

// *** List section
list	:	'['list_term(','list_term)*']';
list_term
	:	//pred(','pred)*;	
	(list|arithm_term|STRING);
//*** end of list section/

//Logic expr session	




STRING
	:	//'"'(ATOM|VAR|DIGIT|SPECIAL_CHAR_TERM)+(('/'|' ')(ATOM|VAR|DIGIT|SPECIAL_CHAR_TERM))*'"';	
		'"'('a'..'z'|'A'..'Z'|DIGIT|'_'|'$'|'@'|SPECIAL_CHAR_TERM)*'"';
		
NEGATION 	:	'not';
TK_NEG 	:                     '~';
INTDIV	:	 'div';
INTMOD	:	 'mod';		
ATOM	:	('a'..'z')('a'..'z'|'A'..'Z'|DIGIT|'_'|'$'|'@')*;
VAR	:	('A'..'Z')('a'..'z'|'A'..'Z'|DIGIT|'_'|'$'|'@')*;
//numeral :	DIGIT+;
DIGIT	:	'0'..'9';

TERM_NULL:	'_';

SPECIAL_CHAR_TERM
	:	('-'|'+'|'%'|'*'|'!'|'@'|'#'|'&'|'/'|':'|'.');

COMMENT_STAT
	:	// '/*' (options {greedy=false;} : .)* '*/' //{$channel=HIDDEN;} //<- para antlr3
		'/*' .*? '*/'-> channel(HIDDEN) //<- para antlr4
		;

WS 	:	(' '|'\r'|'\n')+{skip();} ;
