package org.talend.designer.codegen.translators.processing.hadoop;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import java.util.List;

public class TPigCrossMainJava
{
  protected static String nl;
  public static synchronized TPigCrossMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPigCrossMainJava result = new TPigCrossMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tStringBuilder sb_";
  protected final String TEXT_3 = " = new StringBuilder();" + NL + "\tsb_";
  protected final String TEXT_4 = ".append(\"";
  protected final String TEXT_5 = "_CROSS_FILE = LOAD '\"+";
  protected final String TEXT_6 = "+\"' using PigStorage('\"+";
  protected final String TEXT_7 = "+\"')\");";
  protected final String TEXT_8 = NL + "\t\t\tsb_";
  protected final String TEXT_9 = ".append(\" AS (\");";
  protected final String TEXT_10 = NL + "\t\t\t\tsb_";
  protected final String TEXT_11 = ".append(\"";
  protected final String TEXT_12 = "\");";
  protected final String TEXT_13 = NL + "\t\t\tsb_";
  protected final String TEXT_14 = ".append(\")\");";
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
  protected final String TEXT_27 = NL + "\t" + NL + "\tsb_";
  protected final String TEXT_28 = " = new StringBuilder();" + NL + "\tsb_";
  protected final String TEXT_29 = ".append(\"";
  protected final String TEXT_30 = "_";
  protected final String TEXT_31 = "_RESULT = CROSS ";
  protected final String TEXT_32 = "_";
  protected final String TEXT_33 = "_RESULT, ";
  protected final String TEXT_34 = "_CROSS_FILE\");";
  protected final String TEXT_35 = NL + "\t\tsb_";
  protected final String TEXT_36 = ".append(\" PARTITION BY \"+";
  protected final String TEXT_37 = ");";
  protected final String TEXT_38 = NL + "\t\tsb_";
  protected final String TEXT_39 = ".append(\" PARALLEL ";
  protected final String TEXT_40 = "\");";
  protected final String TEXT_41 = NL + "\tsb_";
  protected final String TEXT_42 = ".append(\";\");";
  protected final String TEXT_43 = NL + "\t\tpigServer_";
  protected final String TEXT_44 = ".registerQuery(sb_";
  protected final String TEXT_45 = ".toString());";
  protected final String TEXT_46 = NL + "    \tpl_";
  protected final String TEXT_47 = " = new Object[2];" + NL + "    \tpl_";
  protected final String TEXT_48 = "[0] = \"query\";" + NL + "    \tpl_";
  protected final String TEXT_49 = "[1] = sb_";
  protected final String TEXT_50 = ".toString();" + NL + "    \tpigScript_";
  protected final String TEXT_51 = ".add(pl_";
  protected final String TEXT_52 = ");";
  protected final String TEXT_53 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_54 = NL;

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
	
	String crossFilename = ElementParameterParser.getValue(node, "__CROSS_FILENAME__");
	String fieldSeparator = ElementParameterParser.getValue(node, "__FIELD_SEPARATOR_CHAR__");
	
	boolean usePartition = "true".equals(ElementParameterParser.getValue(node, "__USE_PARTITION__"));
	String partition = ElementParameterParser.getValue(node, "__PARTITION__");
	
	boolean useParallel = "true".equals(ElementParameterParser.getValue(node, "__INCREASE_PARALLELISM__"));
	String reduce_number = ElementParameterParser.getValue(node, "__REDUCE_NUMBER__");
	

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(crossFilename);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_7);
    
	List<IMetadataTable> metadatas = node.getMetadataList();
	IMetadataTable metadata = null;
	if(metadatas != null && metadatas.size() > 0) {
	    metadata = metadatas.get(0);
	}
	if(metadata!=null) {
		if(metadata.getListColumns() != null && metadata.getListColumns().size() > 0) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
			for(int i=0; i<metadata.getListColumns().size(); i++) {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(i!=0?", ":"");
    stringBuffer.append(metadata.getListColumns().get(i).getLabel());
    stringBuffer.append(TEXT_12);
    
			}

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(outputConnectionName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(previous_node);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(previousOutputConnectionName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
	if(usePartition) {

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(partition);
    stringBuffer.append(TEXT_37);
    
	}
		
	if(useParallel) {

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(reduce_number);
    stringBuffer.append(TEXT_40);
    
	}

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
	if(inMain) {//all output process and main input process 

    stringBuffer.append(TEXT_43);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    
	} else {//lookup process

    stringBuffer.append(TEXT_46);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(start_node);
    stringBuffer.append(TEXT_52);
    
	}

    stringBuffer.append(TEXT_53);
    stringBuffer.append(TEXT_54);
    return stringBuffer.toString();
  }
}
