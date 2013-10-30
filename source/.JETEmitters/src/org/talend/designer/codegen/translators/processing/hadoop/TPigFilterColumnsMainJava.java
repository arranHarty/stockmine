package org.talend.designer.codegen.translators.processing.hadoop;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class TPigFilterColumnsMainJava
{
  protected static String nl;
  public static synchronized TPigFilterColumnsMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPigFilterColumnsMainJava result = new TPigFilterColumnsMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tStringBuilder sb_";
  protected final String TEXT_3 = " = new StringBuilder();" + NL + "\tsb_";
  protected final String TEXT_4 = ".append(\"";
  protected final String TEXT_5 = "_";
  protected final String TEXT_6 = "_RESULT = FOREACH ";
  protected final String TEXT_7 = "_";
  protected final String TEXT_8 = "_RESULT GENERATE \");";
  protected final String TEXT_9 = NL + "\t\t\t\t\t\t\tsb_";
  protected final String TEXT_10 = ".append(\"";
  protected final String TEXT_11 = "\");\t";
  protected final String TEXT_12 = NL + "\t\t\t\t\t\t\tsb_";
  protected final String TEXT_13 = ".append(\", ";
  protected final String TEXT_14 = "\");";
  protected final String TEXT_15 = NL + "\tsb_";
  protected final String TEXT_16 = ".append(\";\");";
  protected final String TEXT_17 = NL + "\t\tpigServer_";
  protected final String TEXT_18 = ".registerQuery(sb_";
  protected final String TEXT_19 = ".toString());";
  protected final String TEXT_20 = NL + "    \tpl_";
  protected final String TEXT_21 = " = new Object[2];" + NL + "    \tpl_";
  protected final String TEXT_22 = "[0] = \"query\";" + NL + "    \tpl_";
  protected final String TEXT_23 = "[1] = sb_";
  protected final String TEXT_24 = ".toString();" + NL + "    \tpigScript_";
  protected final String TEXT_25 = ".add(pl_";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL;
  protected final String TEXT_28 = NL;

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
    
	Set<String> inputCols = new HashSet<String>();
 
 	
	if (node.getIncomingConnections()!=null) {
		for (IConnection incomingConn : node.getIncomingConnections()) {
			if (incomingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				IMetadataTable inputMetadataTable = incomingConn.getMetadataTable();
				for (IMetadataColumn inputCol : inputMetadataTable.getListColumns()) {
					inputCols.add(inputCol.getLabel());
				}
				break;
			}
		}
	}
	
	boolean isFirst = true;
	for (IConnection conn : node.getOutgoingConnections()) {
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
			IMetadataTable outputMetadataTable = conn.getMetadataTable();
			if (outputMetadataTable!=null) {
				for (IMetadataColumn outputCol : outputMetadataTable.getListColumns()) { 
					if (inputCols.contains(outputCol.getLabel())) {
						if(isFirst) {
							isFirst=false;
					

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_11);
    
						} else {

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(outputCol.getLabel() );
    stringBuffer.append(TEXT_14);
    
						}
					}
				}
			}
		}
	}

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
	if(inMain) {//all output process and main input process 

    stringBuffer.append(TEXT_17);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
	} else {//lookup process

    stringBuffer.append(TEXT_20);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_26);
    
	}

    stringBuffer.append(TEXT_27);
    stringBuffer.append(TEXT_28);
    return stringBuffer.toString();
  }
}
