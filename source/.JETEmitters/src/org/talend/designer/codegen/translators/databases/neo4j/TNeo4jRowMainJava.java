package org.talend.designer.codegen.translators.databases.neo4j;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

public class TNeo4jRowMainJava
{
  protected static String nl;
  public static synchronized TNeo4jRowMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNeo4jRowMainJava result = new TNeo4jRowMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    java.util.Map<String, Object> parameters_";
  protected final String TEXT_2 = " = new java.util.HashMap<String, Object>();";
  protected final String TEXT_3 = NL + "    \tparameters_";
  protected final String TEXT_4 = ".put(";
  protected final String TEXT_5 = ", ";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = ");" + NL + "    \t";
  protected final String TEXT_8 = NL + "\torg.neo4j.cypher.ExecutionResult result_";
  protected final String TEXT_9 = " = null;" + NL + "    try {" + NL + "    \tresult_";
  protected final String TEXT_10 = " = engine_";
  protected final String TEXT_11 = ".execute(";
  protected final String TEXT_12 = ", parameters_";
  protected final String TEXT_13 = ");" + NL + "    } catch (Exception e_";
  protected final String TEXT_14 = ") {" + NL + "    \t";
  protected final String TEXT_15 = NL + "    \t\tthrow(e_";
  protected final String TEXT_16 = ");" + NL + "    \t\t";
  protected final String TEXT_17 = NL + "    \t\t\t";
  protected final String TEXT_18 = " = new ";
  protected final String TEXT_19 = "Struct();" + NL + "    \t\t\t";
  protected final String TEXT_20 = NL + "    \t\t\t\t\t";
  protected final String TEXT_21 = ".";
  protected final String TEXT_22 = " = ";
  protected final String TEXT_23 = ".";
  protected final String TEXT_24 = ";" + NL + "    \t\t\t\t\t";
  protected final String TEXT_25 = NL + "    \t\t\t";
  protected final String TEXT_26 = ".errorMessage = e_";
  protected final String TEXT_27 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_28 = ";" + NL + "    \t\t\t";
  protected final String TEXT_29 = NL + "    \t\t\tSystem.err.print(e_";
  protected final String TEXT_30 = ".getMessage());" + NL + "    \t\t\t";
  protected final String TEXT_31 = NL + "    }" + NL + "" + NL + "\tif(result_";
  protected final String TEXT_32 = "!=null) {" + NL + "\t\tnbNodeInserted_";
  protected final String TEXT_33 = " += result_";
  protected final String TEXT_34 = ".queryStatistics().nodesCreated();" + NL + "\t\tnbRelationshipInserted_";
  protected final String TEXT_35 = " += result_";
  protected final String TEXT_36 = ".queryStatistics().relationshipsCreated();" + NL + "\t\tnbPropertiesUpdated_";
  protected final String TEXT_37 = " += result_";
  protected final String TEXT_38 = ".queryStatistics().propertiesSet();" + NL + "\t\tnbNodeDeleted_";
  protected final String TEXT_39 = " += result_";
  protected final String TEXT_40 = ".queryStatistics().deletedNodes();" + NL + "\t\tnbRelationshipDeleted_";
  protected final String TEXT_41 = " += result_";
  protected final String TEXT_42 = ".queryStatistics().deletedRelationships();" + NL + "\t}" + NL + "\t\t" + NL + "\tcounter_";
  protected final String TEXT_43 = "++;" + NL + "" + NL + "\tif (counter_";
  protected final String TEXT_44 = " % Long.parseLong(";
  protected final String TEXT_45 = ") == 0) {" + NL + "\t\ttx_";
  protected final String TEXT_46 = ".success();" + NL + "\t\ttx_";
  protected final String TEXT_47 = ".finish();" + NL + "\t\ttx_";
  protected final String TEXT_48 = " = databaseService_";
  protected final String TEXT_49 = ".beginTx();" + NL + "\t}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	
    
    String query = ElementParameterParser.getValue(node, "__QUERY__");
    query = query.replaceAll("\n"," ");
    query = query.replaceAll("\r"," ");
    List<Map<String, String>> listParameters = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__PARAMETERS__");
    boolean dieOnError = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));   
    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__"); 
    
    List<IMetadataColumn> columnList = null;
    List<IMetadataTable> metadatas = node.getMetadataList();
    
    if (metadatas != null && metadatas.size() > 0) {
    	IMetadataTable metadata = metadatas.get(0);
    	if (metadata != null) {
    		columnList = metadata.getListColumns();
    	}
    }	
    
    List<? extends IConnection> inputs = node.getIncomingConnections();
    List<? extends IConnection> outputs = node.getOutgoingSortedConnections();
    String incomingConnName = null;
    String outgoingConnName = null;
    
    if (inputs.size() > 0) {
    	IConnection in = inputs.get(0);
    	incomingConnName = in.getName();
    }
    
    if (outputs.size() > 0) {
    	IConnection out = outputs.get(0);
    	outgoingConnName = out.getName();
    }
    
    String rejectConnName = null;
    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
    if (rejectConns != null && rejectConns.size() > 0) {
    	IConnection rejectConn = rejectConns.get(0);
    	rejectConnName = rejectConn.getName();
    }
    
    List<IMetadataColumn> rejectColumnList = null;
    IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
    if (metadataTable != null) {
    	rejectColumnList = metadataTable.getListColumns();
    }
    
    Set<String> inputCols = new HashSet();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata!=null) {
			List< ? extends IConnection> conns = node.getIncomingConnections();
			columnList = metadata.getListColumns();
			if(conns != null && conns.size()>0){
				IConnection conn = conns.get(0);
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
					incomingConnName = conn.getName();
					IMetadataTable inputMetadataTable = conn.getMetadataTable();
					for (IMetadataColumn inputCol : inputMetadataTable.getListColumns()) {
						inputCols.add(inputCol.getLabel());
					}
				}
			}
		}
	}
    
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
    for (Map<String, String> parameter : listParameters) {
    	
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(parameter.get("PARAMETER_NAME"));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(parameter.get("PARAMETER_VALUE"));
    stringBuffer.append(TEXT_7);
    
    }
    
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
    	if (dieOnError) {
    		
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
    	} else {
    		if (rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
    			
    stringBuffer.append(TEXT_17);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_19);
    
    			if (incomingConnName != null) {
    				for (IMetadataColumn column : columnList) {
    					if (inputCols.contains(column.getLabel())) {
    					
    stringBuffer.append(TEXT_20);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_24);
    
    					}
    				}
    			}
    			
    stringBuffer.append(TEXT_25);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_28);
    
    		} else {
    			
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
    		}
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    return stringBuffer.toString();
  }
}
