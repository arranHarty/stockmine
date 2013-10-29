package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TStewardshipTaskOutputBeginJava
{
  protected static String nl;
  public static synchronized TStewardshipTaskOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TStewardshipTaskOutputBeginJava result = new TStewardshipTaskOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "String taskFlag_";
  protected final String TEXT_2 = "=\"\";" + NL + "int nb_line_";
  protected final String TEXT_3 = " = 0;\t" + NL + "org.talend.stewardship.TaskGenerator tasks_";
  protected final String TEXT_4 = " = new org.talend.stewardship.TaskGenerator();" + NL + "org.talend.stewardship.Task task_";
  protected final String TEXT_5 = " = null;" + NL + "int port_";
  protected final String TEXT_6 = " =  ";
  protected final String TEXT_7 = ";" + NL + "String url_";
  protected final String TEXT_8 = " = org.talend.datastewardship.server.task.creation.TaskLoadClientTools.getUrl(";
  protected final String TEXT_9 = ",String.valueOf(port_";
  protected final String TEXT_10 = "));" + NL + "org.talend.datastewardship.server.task.creation.TaskLoadClient taskLoadClient_";
  protected final String TEXT_11 = " = new org.talend.datastewardship.server.task.creation.TaskLoadClient(url_";
  protected final String TEXT_12 = ",";
  protected final String TEXT_13 = ",";
  protected final String TEXT_14 = ");" + NL + "org.talend.stewardship.Record record_";
  protected final String TEXT_15 = " = null;" + NL + "boolean targetRecordExisted_";
  protected final String TEXT_16 = " = false;";
  protected final String TEXT_17 = NL + "    \tString recordColumn_";
  protected final String TEXT_18 = "_";
  protected final String TEXT_19 = " = null;" + NL + "    \tString recordColumn_";
  protected final String TEXT_20 = "_Value_";
  protected final String TEXT_21 = " = null;" + NL + "    \tString recordColumn_";
  protected final String TEXT_22 = "_Type_";
  protected final String TEXT_23 = " = null;" + NL + "    \tString recordColumn_";
  protected final String TEXT_24 = "_Key_";
  protected final String TEXT_25 = " = null;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	
    
    String host = ElementParameterParser.getValue(node, "__HOST__");
    String port = ElementParameterParser.getValue(node, "__PORT__");
    String username = ElementParameterParser.getValue(node, "__USERNAME__");
    String password = ElementParameterParser.getValue(node, "__PASSWORD__");
    
List<IMetadataTable> metadatas = node.getMetadataList();
List<Map<String, String>> recordColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__RECORD_COLUMN__");
if ((metadatas!=null)&&(metadatas.size()>0)) {//1
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {//2

    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	for (IConnection conn : conns) {//3
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//4

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    //For TDI-26345
if(recordColumns.size()>0){
	for(Map<String, String> recordColumn:recordColumns){

    stringBuffer.append(TEXT_17);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
	}
}

    
			}	
		}
	}	
}

    return stringBuffer.toString();
  }
}
