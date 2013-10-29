package org.talend.designer.codegen.translators.orchestration;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TLoopBeginJava
{
  protected static String nl;
  public static synchronized TLoopBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLoopBeginJava result = new TLoopBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\tlog.info(\"";
  protected final String TEXT_3 = " - Start to work.\");";
  protected final String TEXT_4 = NL + "int current_iteration_";
  protected final String TEXT_5 = " = 0;";
  protected final String TEXT_6 = NL + "\tlog.info(\"";
  protected final String TEXT_7 = " - Start to loop from \" + ";
  protected final String TEXT_8 = " + \" to \" + ";
  protected final String TEXT_9 = " + \" with step \" + ";
  protected final String TEXT_10 = " + \".\");";
  protected final String TEXT_11 = NL + NL + "for(int loop";
  protected final String TEXT_12 = " =";
  protected final String TEXT_13 = "; loop";
  protected final String TEXT_14 = "<=";
  protected final String TEXT_15 = "; loop";
  protected final String TEXT_16 = "=loop";
  protected final String TEXT_17 = "+";
  protected final String TEXT_18 = "){";
  protected final String TEXT_19 = NL + "for(int loop";
  protected final String TEXT_20 = " =";
  protected final String TEXT_21 = "; loop";
  protected final String TEXT_22 = ">=";
  protected final String TEXT_23 = "; loop";
  protected final String TEXT_24 = "=loop";
  protected final String TEXT_25 = "+";
  protected final String TEXT_26 = "){";
  protected final String TEXT_27 = NL + "\t";
  protected final String TEXT_28 = NL + "\t\tlog.debug(\"";
  protected final String TEXT_29 = " - Loop value is \" + loop";
  protected final String TEXT_30 = ");" + NL + "\t";
  protected final String TEXT_31 = NL + "current_iteration_";
  protected final String TEXT_32 = "++;" + NL + "globalMap.put(\"";
  protected final String TEXT_33 = "_CURRENT_VALUE\",loop";
  protected final String TEXT_34 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_35 = "_CURRENT_ITERATION\",current_iteration_";
  protected final String TEXT_36 = ");" + NL;
  protected final String TEXT_37 = NL;
  protected final String TEXT_38 = NL;
  protected final String TEXT_39 = ";" + NL + "\t";
  protected final String TEXT_40 = NL + "\t\tlog.info(\"";
  protected final String TEXT_41 = " - Start loop condition with \" + ";
  protected final String TEXT_42 = ");" + NL + "\t";
  protected final String TEXT_43 = NL + "while(";
  protected final String TEXT_44 = "){" + NL + "\t";
  protected final String TEXT_45 = NL + "\t\tlog.debug(\"";
  protected final String TEXT_46 = " - Current iterate value is \" + current_iteration_";
  protected final String TEXT_47 = ");" + NL + "\t";
  protected final String TEXT_48 = NL + "current_iteration_";
  protected final String TEXT_49 = "++;" + NL + "globalMap.put(\"";
  protected final String TEXT_50 = "_CURRENT_ITERATION\",current_iteration_";
  protected final String TEXT_51 = ");" + NL;
  protected final String TEXT_52 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

boolean forLoop = ("true").equals(ElementParameterParser.getValue(node,"__FORLOOP__"));

boolean whileLoop = ("true").equals(ElementParameterParser.getValue(node,"__WHILELOOP__"));

boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	if(isLog4jEnabled){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
	}

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
if (forLoop) {

String from = ElementParameterParser.getValue(node, "__FROM__");
if (("").equals(from)) from = "1";
String to   = ElementParameterParser.getValue(node, "__TO__");
if (("").equals(to)) to = "1";
String step   = ElementParameterParser.getValue(node, "__STEP__");
if (("").equals(step)) step = "1";
boolean increase = ("true").equals(ElementParameterParser.getValue(node, "__INCREASE__"));
if(isLog4jEnabled){

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(from);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(to);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(step);
    stringBuffer.append(TEXT_10);
    
}
if(increase){
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(from);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(to);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(step);
    stringBuffer.append(TEXT_18);
    
}else{
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(from);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(to);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(step);
    stringBuffer.append(TEXT_26);
    }
    stringBuffer.append(TEXT_27);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    }
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
}else{// While type

String condition = ElementParameterParser.getValue(node, "__CONDITION__");
if (condition.startsWith("\"") && condition.endsWith("\"")) {
    condition = condition.substring(1, condition.length()-1);
}

String declaration = ElementParameterParser.getValue(node, "__DECLARATION__");
if (declaration.startsWith("\"") && declaration.endsWith("\"")) {
    declaration = declaration.substring(1, declaration.length()-1);
}




    stringBuffer.append(TEXT_37);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(declaration);
    stringBuffer.append(TEXT_39);
    if(isLog4jEnabled){
		String cdn = ElementParameterParser.getValue(node, "__CONDITION__");
		
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cdn);
    stringBuffer.append(TEXT_42);
    }
    stringBuffer.append(TEXT_43);
    stringBuffer.append(condition);
    stringBuffer.append(TEXT_44);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    }
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
}

    stringBuffer.append(TEXT_52);
    return stringBuffer.toString();
  }
}
