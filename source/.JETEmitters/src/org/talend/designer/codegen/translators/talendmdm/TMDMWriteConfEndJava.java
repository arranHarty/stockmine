package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.utils.NodeUtil;

public class TMDMWriteConfEndJava
{
  protected static String nl;
  public static synchronized TMDMWriteConfEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMWriteConfEndJava result = new TMDMWriteConfEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t}" + NL + "\tif (globalMap.containsKey(\"";
  protected final String TEXT_2 = "_FINISH\") ) {" + NL + "\t\tif (queue_";
  protected final String TEXT_3 = ".isEmpty()) {" + NL + "\t\t\tbreak;" + NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_4 = NL + "\ttxf_";
  protected final String TEXT_5 = ".join();" + NL + "\tif(txf_";
  protected final String TEXT_6 = ".getLastException()!=null) {" + NL + "\t\tcurrentComponent = txf_";
  protected final String TEXT_7 = ".getCurrentComponent();" + NL + "\t\tthrow txf_";
  protected final String TEXT_8 = ".getLastException();" + NL + "\t}";
  protected final String TEXT_9 = NL + "globalMap.remove(\"";
  protected final String TEXT_10 = "_FINISH\");";
  protected final String TEXT_11 = " " + NL + "\tif(miList_";
  protected final String TEXT_12 = ".size() > 0){" + NL + "\t\twspks_";
  protected final String TEXT_13 = " = xtentisWS_";
  protected final String TEXT_14 = ".putItemWithReportArray(miList_";
  protected final String TEXT_15 = ".toArray(new org.talend.mdm.webservice.WSPutItemWithReport[miList_";
  protected final String TEXT_16 = ".size()]));" + NL + "\t\tmiList_";
  protected final String TEXT_17 = ".clear();" + NL + "\t\tmiList_";
  protected final String TEXT_18 = " = null;" + NL + "\t\t";
  protected final String TEXT_19 = NL + "        \txtentisWS_";
  protected final String TEXT_20 = ".updateItemArrayMetadata(util_";
  protected final String TEXT_21 = ". makeUpdateMeteItms(taskIDs_";
  protected final String TEXT_22 = ",wspks_";
  protected final String TEXT_23 = "));" + NL + "        \ttaskIDs_";
  protected final String TEXT_24 = ".clear();";
  protected final String TEXT_25 = NL + "\t}";
  protected final String TEXT_26 = NL + "\tif(miList_";
  protected final String TEXT_27 = ".size() > 0){" + NL + "\t\twspks_";
  protected final String TEXT_28 = " = xtentisWS_";
  protected final String TEXT_29 = ".putItemArray(miList_";
  protected final String TEXT_30 = ".toArray(new org.talend.mdm.webservice.WSPutItem[miList_";
  protected final String TEXT_31 = ".size()]));" + NL + "\t\tmiList_";
  protected final String TEXT_32 = ".clear();" + NL + "\t\tmiList_";
  protected final String TEXT_33 = " = null;" + NL + "\t\t";
  protected final String TEXT_34 = NL + "        \txtentisWS_";
  protected final String TEXT_35 = ".updateItemArrayMetadata(util_";
  protected final String TEXT_36 = ". makeUpdateMeteItms(taskIDs_";
  protected final String TEXT_37 = ",wspks_";
  protected final String TEXT_38 = "));" + NL + "        \ttaskIDs_";
  protected final String TEXT_39 = ".clear();";
  protected final String TEXT_40 = NL + "\t}";
  protected final String TEXT_41 = NL + " \t";
  protected final String TEXT_42 = NL + " \t\tstub_";
  protected final String TEXT_43 = ".logout(new org.talend.mdm.webservice.WSLogout());" + NL + " \t";
  protected final String TEXT_44 = NL + " \t" + NL + " \tglobalMap.put(\"";
  protected final String TEXT_45 = "_NB_LINE\",nb_line_";
  protected final String TEXT_46 = ");             ";
  protected final String TEXT_47 = NL + "            ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String virtualcid = cid;
	String destination = ElementParameterParser.getValue(node, "__DESTINATION__");
	if(destination!=null && !"".equals(destination)){
		cid = destination;
	}
	
	boolean isStaging = "STAGING".equalsIgnoreCase(ElementParameterParser.getValue(node, "__CONTAINER_TYPE__"));
	
	boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
	
	boolean isMassInsert =("true").equals(ElementParameterParser.getValue(node,"__EXTENDINSERT__"));
	boolean withReport = ("true").equals(ElementParameterParser.getValue(node,"__WITHREPORT__"));
	
	boolean addTaskID = ("true").equals(ElementParameterParser.getValue(node,"__ADD_TASKID__"));
	String taskID = ElementParameterParser.getValue(node,"__TASKID__");
	boolean usePartialUpdate = ("true").equals(ElementParameterParser.getValue(node,"__USE_PARTIAL_UPDATE__"));

    stringBuffer.append(TEXT_1);
    stringBuffer.append(virtualcid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
INode sourceNode = node.getIncomingConnections(EConnectionType.ON_COMPONENT_OK).get(0).getSource();
String virtualSourceCid = sourceNode.getUniqueName();
INode startNode = NodeUtil.getSpecificStartNode(sourceNode);
String startNodeCid = null; 
if(startNode != null){
	startNodeCid = startNode.getUniqueName();
} 
IConnection nextMergeConn = NodeUtil.getNextMergeConnection(node);
if(nextMergeConn != null && nextMergeConn.getInputId()>1 && startNodeCid != null){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
}

    stringBuffer.append(TEXT_9);
    stringBuffer.append(virtualcid);
    stringBuffer.append(TEXT_10);
    
if(!usePartialUpdate){
	if(isMassInsert){
		if(!isStaging && withReport){

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    if(addTaskID){
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    }
    stringBuffer.append(TEXT_25);
    
		}else{
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    if(addTaskID){
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    }
    stringBuffer.append(TEXT_40);
    
		}
	}
}
    stringBuffer.append(TEXT_41);
    if(!useExistingConn){
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    }
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(TEXT_47);
    return stringBuffer.toString();
  }
}
