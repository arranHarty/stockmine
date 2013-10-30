package org.talend.designer.codegen.translators.processing.hadoop;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TPigAggregateMainJava
{
  protected static String nl;
  public static synchronized TPigAggregateMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPigAggregateMainJava result = new TPigAggregateMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "\tStringBuilder sb_";
  protected final String TEXT_3 = " = new StringBuilder();";
  protected final String TEXT_4 = NL + "\t\tsb_";
  protected final String TEXT_5 = ".append(\"";
  protected final String TEXT_6 = "_GROUP = GROUP ";
  protected final String TEXT_7 = "_";
  protected final String TEXT_8 = "_RESULT BY (\");" + NL + "\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\tsb_";
  protected final String TEXT_10 = ".append(\",\");";
  protected final String TEXT_11 = NL + "\t\t\tsb_";
  protected final String TEXT_12 = ".append(\"";
  protected final String TEXT_13 = "\");";
  protected final String TEXT_14 = NL + "\t\tsb_";
  protected final String TEXT_15 = ".append(\")\");";
  protected final String TEXT_16 = NL + "\t\t\tsb_";
  protected final String TEXT_17 = ".append(\" PARALLEL \"+";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = "\t\t" + NL + "\t\tsb_";
  protected final String TEXT_20 = ".append(\";\");";
  protected final String TEXT_21 = NL + "\t\t\tpigServer_";
  protected final String TEXT_22 = ".registerQuery(sb_";
  protected final String TEXT_23 = ".toString());";
  protected final String TEXT_24 = NL + "        \tpl_";
  protected final String TEXT_25 = " = new Object[2];" + NL + "        \tpl_";
  protected final String TEXT_26 = "[0] = \"query\";" + NL + "        \tpl_";
  protected final String TEXT_27 = "[1] = sb_";
  protected final String TEXT_28 = ".toString();" + NL + "        \tpigScript_";
  protected final String TEXT_29 = ".add(pl_";
  protected final String TEXT_30 = ");";
  protected final String TEXT_31 = NL + NL + "\t\tsb_";
  protected final String TEXT_32 = " = new StringBuilder();" + NL + "\t\tsb_";
  protected final String TEXT_33 = ".append(\"";
  protected final String TEXT_34 = "_";
  protected final String TEXT_35 = "_RESULT = FOREACH ";
  protected final String TEXT_36 = "_GROUP GENERATE \");";
  protected final String TEXT_37 = NL + "\t\t\t\tsb_";
  protected final String TEXT_38 = ".append(\",\");";
  protected final String TEXT_39 = NL + "\t\t\tsb_";
  protected final String TEXT_40 = ".append(\"group";
  protected final String TEXT_41 = " AS ";
  protected final String TEXT_42 = "\");";
  protected final String TEXT_43 = NL + "\t\t\tsb_";
  protected final String TEXT_44 = ".append(\", ";
  protected final String TEXT_45 = "(";
  protected final String TEXT_46 = "_";
  protected final String TEXT_47 = "_RESULT.";
  protected final String TEXT_48 = ") AS ";
  protected final String TEXT_49 = "\");";
  protected final String TEXT_50 = NL + "\t\tsb_";
  protected final String TEXT_51 = ".append(\";\");";
  protected final String TEXT_52 = NL + "\t\t\tpigServer_";
  protected final String TEXT_53 = ".registerQuery(sb_";
  protected final String TEXT_54 = ".toString());";
  protected final String TEXT_55 = NL + "        \tpl_";
  protected final String TEXT_56 = " = new Object[2];" + NL + "        \tpl_";
  protected final String TEXT_57 = "[0] = \"query\";" + NL + "        \tpl_";
  protected final String TEXT_58 = "[1] = sb_";
  protected final String TEXT_59 = ".toString();" + NL + "        \tpigScript_";
  protected final String TEXT_60 = ".add(pl_";
  protected final String TEXT_61 = ");";
  protected final String TEXT_62 = NL + "\t\t" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_63 = NL;

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
	
	List<Map<String, String>> key_fields = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__KEY_FIELDS__");
	List<Map<String, String>> operations_config = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__OPERATIONS__");

	
	boolean useParallel = "true".equals(ElementParameterParser.getValue(node, "__INCREASE_PARALLELISM__"));
	String reduce_number = ElementParameterParser.getValue(node, "__REDUCE_NUMBER__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
	if(key_fields != null && key_fields.size()>0 && operations_config != null && operations_config.size()>0) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(previous_node);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(previousOutputConnectionName);
    stringBuffer.append(TEXT_8);
    
		boolean isFirst = true;
		for(Map<String, String> key_field : key_fields) {
			if(!isFirst) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    	
			}
			isFirst=false;

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(key_field.get("INPUT_COLUMN"));
    stringBuffer.append(TEXT_13);
    
		}

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    

		if(useParallel) {

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(reduce_number);
    stringBuffer.append(TEXT_18);
    
		}
		

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
		if(inMain) {//all output process and main input process 

    stringBuffer.append(TEXT_21);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
		} else {//lookup process

    stringBuffer.append(TEXT_24);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_30);
    
		}

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(outputConnectionName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
		isFirst = true;
		for(Map<String, String> key_field : key_fields) {
			if(!isFirst) {

    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    	
			}
			isFirst=false;

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(key_fields.size()>1?"."+key_field.get("INPUT_COLUMN"):"");
    stringBuffer.append(TEXT_41);
    stringBuffer.append(key_field.get("INPUT_COLUMN"));
    stringBuffer.append(TEXT_42);
    
		}

		for(Map<String, String> operation_config : operations_config) {

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(operation_config.get("FUNCTION"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(previous_node);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(previousOutputConnectionName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(operation_config.get("INPUT_COLUMN"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(operation_config.get("OUTPUT_COLUMN"));
    stringBuffer.append(TEXT_49);
    
		}

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
		if(inMain) {//all output process and main input process 

    stringBuffer.append(TEXT_52);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
		} else {//lookup process

    stringBuffer.append(TEXT_55);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_61);
    
		}
	}

    stringBuffer.append(TEXT_62);
    stringBuffer.append(TEXT_63);
    return stringBuffer.toString();
  }
}
