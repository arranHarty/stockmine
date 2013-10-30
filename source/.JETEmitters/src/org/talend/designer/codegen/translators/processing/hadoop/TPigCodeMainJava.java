package org.talend.designer.codegen.translators.processing.hadoop;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TPigCodeMainJava
{
  protected static String nl;
  public static synchronized TPigCodeMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPigCodeMainJava result = new TPigCodeMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "\tStringBuilder sb_";
  protected final String TEXT_3 = " = new StringBuilder();";
  protected final String TEXT_4 = NL + "\t\tpigServer_";
  protected final String TEXT_5 = ".registerQuery(\"";
  protected final String TEXT_6 = "\");\t\t";
  protected final String TEXT_7 = NL + "    \tpl_";
  protected final String TEXT_8 = " = new Object[2];" + NL + "    \tpl_";
  protected final String TEXT_9 = "[0] = \"query\";" + NL + "    \tpl_";
  protected final String TEXT_10 = "[1] = \"";
  protected final String TEXT_11 = "\";" + NL + "    \tpigScript_";
  protected final String TEXT_12 = ".add(pl_";
  protected final String TEXT_13 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

	String scriptCode = ElementParameterParser.getValue(node,"__SCRIPT_CODE__");
	String [] codes = scriptCode.split("\n");

	String start_node="";
	
	boolean inMain = true;

	if(node.getIncomingConnections()!=null && node.getIncomingConnections().size()>0) {
		INode loadNode = node.getDesignSubjobStartNode();
		start_node = loadNode.getUniqueName();
		inMain = loadNode.isSubtreeStart();
	}


    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
	for(String code : codes) {
		code = code.trim();
		if("true".equals(ElementParameterParser.getValue(node, "__ESCAPE__"))){
			code = code.replace("\\","\\\\").replace("\"","\\\"");
		}
		
		if(inMain) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(code);
    stringBuffer.append(TEXT_6);
    
		} else {

    stringBuffer.append(TEXT_7);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(code);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_13);
    
		}
	}

    return stringBuffer.toString();
  }
}
