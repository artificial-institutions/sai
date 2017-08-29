grammar sai_normative;


@header
{
package lang.parser;

import jason.asSyntax.Atom;
}



@members{

  
}




sai			:	normative_spec; //sequence pattern
normative_spec  	:	(institution_id)(status_functions)?(norms); //sequence pattern
institution_id		:      'institution_id' ':' ATOM '.';
status_functions	:	'status_functions'':'(agent_sf_decl|event_sf_decl|state_sf_decl)+; //choice pattern
agent_sf_decl		:	'agents'':' agent_sf_list '.'; //sequence
agent_sf_list		:	agent_sf(','agent_sf)*;	//sequence with separator
event_sf_decl		:	'events'':' event_sf_list '.'; //sequence
event_sf_list		:	event_sf(','event_sf)*;	//sequence with separator
state_sf_decl		:	'states'':' state_sf_list '.'; //sequence
state_sf_list		:	state_sf(','state_sf)*;	//sequence with separator


norms		:	'norms' ':' norm+;
norm 		:	 id ':' condition ':' attribute deontic aim ('until' deadline)? ('else' or_else)?'.';
id		:	DIGIT+;
condition	:	sf_formula;
attribute	:	agent_sf;
deontic 	:	'obliged'|'prohibited'|'permitted';
aim		:	sf_formula;
deadline	:	sf_formula;
or_else		:	sf_formula;



agent_sf:	ATOM;
event_sf:	pred;
state_sf:	pred;



sf_formula	:	sff_or_expr;
sff_or_expr	:	sff_and_expr (TK_OR sff_or_expr)?;
sff_and_expr	:	sff_rel (TK_AND sff_and_expr)?;	
sff_rel	:		arithm_term((TK_REL_OP|TK_IS) sff_rel)?; 
arithm_term	:	arithm_factor (('+'|'-') arithm_term)?;
arithm_factor	:	sff_atom (('*'|'/'|INTDIV|INTMOD) arithm_factor)?;
sff_atom	:       NEGATION? ((VAR|pred)|('('sff_or_expr')')|(DIGIT+));

TK_OR		:	'|';
TK_AND		:	'&';
TK_REL_OP	:	'<' | '<=' | '>' | '>=' | '==' | '\\==' | '=' | '=..';




/*** Template for arithm.expressions ***
arithm_expression	:	arithm_term;
arithm_term		:	arithm_factor (('+'|'-') arithm_term)?;
arithm_factor		:	arithm_atom (('*'|'/'|INTDIV|INTMOD) arithm_factor)?;
arithm_atom		:	VAR|DIGIT+|'('arithm_term')';	//the basic element of arithm.expressions

*/




pred	:	//ATOM(list)?;
		//(TK_NEG)?ATOM(list_of_pred_terms)?(list)?;
		ATOM(list_of_pred_terms)?(list)?;
list_of_pred_terms
	:	'('pred_terms')';
pred_terms
	:	pred_term(','pred_term)*;	
pred_term
	:	VAR|TERM_NULL|STRING|DIGIT+|ATOM(list_of_pred_terms)?;

annotation
	:	list;

// *** List section
list	:	'['list_term(','list_term)*']';
list_term
	:	//pred(','pred)*;	
	(list|arithm_term|STRING);
//*** end of list section/

//Logic expr session	


TK_IS		:	'is';

STRING
	:	'"'(ATOM|VAR|DIGIT+)(('/'|' ')(ATOM|VAR|DIGIT+))*'"';
NEGATION 	:	'not';
TK_NEG 	:                     '~';
INTDIV	:	 'div';
INTMOD	:	 'mod';		
ATOM	:	('a'..'z')('a'..'z'|'A'..'Z'|DIGIT|'_'|'$'|'@')*;
VAR	:	('A'..'Z')('a'..'z'|'A'..'Z'|DIGIT|'_'|'$'|'@')*;
//NUMERAL :	DIGIT+;
DIGIT	:	'0'..'9';

TERM_NULL:	'_';

COMMENT_STAT
	:	  
	         //'/*' (options {greedy=false;} : .)* '*/'// {$channel=HIDDEN;} //<- para antlr3
		'/*' .*? '*/'-> channel(HIDDEN) //<- para antlr4

		;

WS 	:	(' '|'\r'|'\n')+{skip();} ;