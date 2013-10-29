package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import org.talend.core.model.process.ElementParameterParser;

public class TStewardshipTaskOutputEndJava
{
  protected static String nl;
  public static synchronized TStewardshipTaskOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TStewardshipTaskOutputEndJava result = new TStewardshipTaskOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tif(targetRecordExisted_";
  protected final String TEXT_2 = "){" + NL + "\t\t\t\t\trecord_";
  protected final String TEXT_3 = " = task_";
  protected final String TEXT_4 = ".addTargetRecord();";
  protected final String TEXT_5 = NL + "    \t\t\t\t\t\trecord_";
  protected final String TEXT_6 = ".addSrcColumn(recordColumn_";
  protected final String TEXT_7 = "_";
  protected final String TEXT_8 = ",recordColumn_";
  protected final String TEXT_9 = "_Value_";
  protected final String TEXT_10 = ",recordColumn_";
  protected final String TEXT_11 = "_Type_";
  protected final String TEXT_12 = ",recordColumn_";
  protected final String TEXT_13 = "_Key_";
  protected final String TEXT_14 = ");";
  protected final String TEXT_15 = NL + "\t\t\t\t}" + NL + "\tif(tasks_";
  protected final String TEXT_16 = ".getTaskCount()>=1){" + NL + "\t\tString content = tasks_";
  protected final String TEXT_17 = ".getTasksAndClear();" + NL + "\t\t//System.out.println(content);" + NL + "\t\tboolean loadResult_";
  protected final String TEXT_18 = " = taskLoadClient_";
  protected final String TEXT_19 = ".doLoad(content);" + NL + "\t\tif(!loadResult_";
  protected final String TEXT_20 = "){" + NL + "\t\t\tSystem.err.println(\"An error occured while uploading tasks.\");" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_21 = NL + "globalMap.put(\"";
  protected final String TEXT_22 = "_NB_LINE\",nb_line_";
  protected final String TEXT_23 = ");";
  protected final String TEXT_24 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	
    String recordType = ElementParameterParser.getValue(node, "__RECORD_TYPE__");
	List<Map<String, String>> recordColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__RECORD_COLUMN__");

List<IMetadataTable> metadatas = node.getMetadataList();
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
    
					if(recordColumns.size()>0){
						for(Map<String, String> recordColumn:recordColumns){

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
						}
					}

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
			}	
		}
	}	
}

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(TEXT_24);
    return stringBuffer.toString();
  }
}
