package org.talend.designer.codegen.translators.processing.hadoop;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TPigDistinctMainJava
{
  protected static String nl;
  public static synchronized TPigDistinctMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPigDistinctMainJava result = new TPigDistinctMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tStringBuilder sb_";
  protected final String TEXT_3 = " = new StringBuilder();" + NL + "\tsb_";
  protected final String TEXT_4 = ".append(\"";
  protected final String TEXT_5 = "_";
  protected final String TEXT_6 = "_RESULT = DISTINCT ";
  protected final String TEXT_7 = "_";
  protected final String TEXT_8 = "_RESULT\");";
  protected final String TEXT_9 = NL + "\t\tsb_";
  protected final String TEXT_10 = ".append(\" PARALLEL ";
  protected final String TEXT_11 = "\");";
  protected final String TEXT_12 = NL + "\tsb_";
  protected final String TEXT_13 = ".append(\";\");";
  protected final String TEXT_14 = NL + "\t\tpigServer_";
  protected final String TEXT_15 = ".registerQuery(sb_";
  protected final String TEXT_16 = ".toString());";
  protected final String TEXT_17 = NL + "    \tpl_";
  protected final String TEXT_18 = " = new Object[2];" + NL + "    \tpl_";
  protected final String TEXT_19 = "[0] = \"query\";" + NL + "    \tpl_";
  protected final String TEXT_20 = "[1] = sb_";
  protected final String TEXT_21 = ".toString();" + NL + "    \tpigScript_";
  protected final String TEXT_22 = ".add(pl_";
  protected final String TEXT_23 = ");";
  protected final String TEXT_24 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String previous_node="";
	String start_node="";
	
	boolean inMain = true;

	String previousOutputConnectionName = "";
	
	if(node.getIncomingConnections()!=null && node.getIncomingConnections().size()>0) {
		IConnection connection = node.getIncomingConnections().get(0);
		previous_node = connection.getSource().getUniqueName();
		INode loadNode = node.getDesignSubjobStartNode();
		start_node = loadNode.getUniqueName();
		inMain = loadNode.isSubtreeStart();
		previousOutputConnectionName = connection.getName();
	}
	
	String outputConnectionName = "";
	List<IConnection> outputConnections = (List<IConnection>)node.getOutgoingConnections();
	if(outputConnections!=null && outputConnections.size()>0) {
		outputConnectionName = outputConnections.get(0).getName();
	}
	
	boolean useParallel = "true".equals(ElementParameterParser.getValue(node, "__INCREASE_PARALLELISM__"));
	String reduce_number = ElementParameterParser.getValue(node, "__REDUCE_NUMBER__");
	

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(outputConnectionName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(previous_node);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(previousOutputConnectionName);
    stringBuffer.append(TEXT_8);
    		
	if(useParallel) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(reduce_number);
    stringBuffer.append(TEXT_11);
    
	}

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
	if(inMain) {//all output process and main input process 

    stringBuffer.append(TEXT_14);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
	} else {//lookup process

    stringBuffer.append(TEXT_17);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_23);
    
	}

    stringBuffer.append(TEXT_24);
    return stringBuffer.toString();
  }
}
