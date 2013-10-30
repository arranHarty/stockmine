package org.talend.designer.codegen.translators.processing.hadoop;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TPigFilterRowMainJava
{
  protected static String nl;
  public static synchronized TPigFilterRowMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPigFilterRowMainJava result = new TPigFilterRowMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "\tStringBuilder sb_";
  protected final String TEXT_3 = " = new StringBuilder();" + NL + "\tsb_";
  protected final String TEXT_4 = ".append(\"";
  protected final String TEXT_5 = "_";
  protected final String TEXT_6 = "_RESULT = FILTER ";
  protected final String TEXT_7 = "_";
  protected final String TEXT_8 = "_RESULT BY \");" + NL + "\t";
  protected final String TEXT_9 = NL + "\t\t\t\tsb_";
  protected final String TEXT_10 = ".append(\" ";
  protected final String TEXT_11 = " \");";
  protected final String TEXT_12 = NL + "\t\t\tsb_";
  protected final String TEXT_13 = ".append(\"(";
  protected final String TEXT_14 = "(";
  protected final String TEXT_15 = " ";
  protected final String TEXT_16 = " \"+";
  protected final String TEXT_17 = "+\"))\");";
  protected final String TEXT_18 = NL + "\t\tsb_";
  protected final String TEXT_19 = ".append(";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "\tsb_";
  protected final String TEXT_22 = ".append(\";\");";
  protected final String TEXT_23 = NL + "\t\tpigServer_";
  protected final String TEXT_24 = ".registerQuery(sb_";
  protected final String TEXT_25 = ".toString());";
  protected final String TEXT_26 = NL + "    \tpl_";
  protected final String TEXT_27 = " = new Object[2];" + NL + "    \tpl_";
  protected final String TEXT_28 = "[0] = \"query\";" + NL + "    \tpl_";
  protected final String TEXT_29 = "[1] = sb_";
  protected final String TEXT_30 = ".toString();" + NL + "    \tpigScript_";
  protected final String TEXT_31 = ".add(pl_";
  protected final String TEXT_32 = ");";
  protected final String TEXT_33 = NL;

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
	
	List<Map<String, String>> configs = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FILTER_CONFIG__");
	boolean useAdvancedFilter = "true".equals(ElementParameterParser.getValue(node, "__USE_ADVANCED_FILTER__"));
	String advancedFilter = ElementParameterParser.getValue(node, "__ADVANCED_FILTER__");

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
    
	if(!useAdvancedFilter) {
		boolean isFirst = true;
		String operator = "";
		for(Map<String, String> configMap : configs) {
			if(!isFirst) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(configMap.get("LOGICAL"));
    stringBuffer.append(TEXT_11);
    
			}
			isFirst=false;

			if("EQUAL".equals(configMap.get("OPERATOR"))) {
				operator = "==";
			} else if("NEQUAL".equals(configMap.get("OPERATOR"))) {
				operator = "!=";
			} else if("GREATER".equals(configMap.get("OPERATOR"))) {
				operator = ">";
			} else if("GREATER_EQUAL".equals(configMap.get("OPERATOR"))) {
				operator = ">=";
			} else if("LESS".equals(configMap.get("OPERATOR"))) {
				operator = "<";
			} else if("LESS_EQUAL".equals(configMap.get("OPERATOR"))) {
				operator = "<=";
			} else if("MATCH".equals(configMap.get("OPERATOR"))) {
				operator = "matches";
			}

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append("true".equals(configMap.get("NOT"))?"NOT ":"");
    stringBuffer.append(TEXT_14);
    stringBuffer.append(configMap.get("COLUMN_NAME"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(operator);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(configMap.get("VALUE"));
    stringBuffer.append(TEXT_17);
    
		}
	}else {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(advancedFilter);
    stringBuffer.append(TEXT_20);
    
	}

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
	if(inMain) {//all output process and main input process 

    stringBuffer.append(TEXT_23);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
	} else {//lookup process

    stringBuffer.append(TEXT_26);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_32);
    
	}

    stringBuffer.append(TEXT_33);
    return stringBuffer.toString();
  }
}
