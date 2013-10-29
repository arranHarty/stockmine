package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMDMOutputEndJava
{
  protected static String nl;
  public static synchronized TMDMOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMOutputEndJava result = new TMDMOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = " " + NL + "\tif(miList_";
  protected final String TEXT_3 = ".size() > 0){" + NL + "\t\twspks_";
  protected final String TEXT_4 = " = xtentisWS_";
  protected final String TEXT_5 = ".putItemWithReportArray(miList_";
  protected final String TEXT_6 = ".toArray(new org.talend.mdm.webservice.WSPutItemWithReport[miList_";
  protected final String TEXT_7 = ".size()]));" + NL + "\t\tmiList_";
  protected final String TEXT_8 = ".clear();" + NL + "\t\tmiList_";
  protected final String TEXT_9 = " = null;" + NL + "\t\t";
  protected final String TEXT_10 = NL + "        \txtentisWS_";
  protected final String TEXT_11 = ".updateItemArrayMetadata(util_";
  protected final String TEXT_12 = ". makeUpdateMeteItms(taskIDs_";
  protected final String TEXT_13 = ",wspks_";
  protected final String TEXT_14 = "));" + NL + "        \ttaskIDs_";
  protected final String TEXT_15 = ".clear();";
  protected final String TEXT_16 = NL + "\t}";
  protected final String TEXT_17 = NL + "\tif(miList_";
  protected final String TEXT_18 = ".size() > 0){" + NL + "\t\twspks_";
  protected final String TEXT_19 = " = xtentisWS_";
  protected final String TEXT_20 = ".putItemArray(miList_";
  protected final String TEXT_21 = ".toArray(new org.talend.mdm.webservice.WSPutItem[miList_";
  protected final String TEXT_22 = ".size()]));" + NL + "\t\tmiList_";
  protected final String TEXT_23 = ".clear();" + NL + "\t\tmiList_";
  protected final String TEXT_24 = " = null;" + NL + "\t\t";
  protected final String TEXT_25 = NL + "        \txtentisWS_";
  protected final String TEXT_26 = ".updateItemArrayMetadata(util_";
  protected final String TEXT_27 = ". makeUpdateMeteItms(taskIDs_";
  protected final String TEXT_28 = ",wspks_";
  protected final String TEXT_29 = "));" + NL + "        \ttaskIDs_";
  protected final String TEXT_30 = ".clear();";
  protected final String TEXT_31 = NL + "\t}";
  protected final String TEXT_32 = NL + " \t";
  protected final String TEXT_33 = NL + " \t\tstub_";
  protected final String TEXT_34 = ".logout(new org.talend.mdm.webservice.WSLogout());" + NL + " \t";
  protected final String TEXT_35 = NL + " \t" + NL + " \tglobalMap.put(\"";
  protected final String TEXT_36 = "_NB_LINE\",nb_line_";
  protected final String TEXT_37 = ");             ";
  protected final String TEXT_38 = NL + "            ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String destination = ElementParameterParser.getValue(node, "__DESTINATION__");
	if(destination!=null && !"".equals(destination)){
		cid = destination;
	}
	boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
	
	boolean isMassInsert =("true").equals(ElementParameterParser.getValue(node,"__EXTENDINSERT__"));
	boolean withReport = ("true").equals(ElementParameterParser.getValue(node,"__WITHREPORT__"));
	
	boolean isStaging = "STAGING".equalsIgnoreCase(ElementParameterParser.getValue(node, "__CONTAINER_TYPE__"));
	
	boolean addTaskID = ("true").equals(ElementParameterParser.getValue(node,"__ADD_TASKID__"));
	String taskID = ElementParameterParser.getValue(node,"__TASKID__");
	boolean usePartialUpdate = ("true").equals(ElementParameterParser.getValue(node,"__USE_PARTIAL_UPDATE__"));

    stringBuffer.append(TEXT_1);
    
if(!usePartialUpdate){
	if(isMassInsert){
		if(!isStaging && withReport){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    if(addTaskID){
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    
		}else{
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    if(addTaskID){
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    }
    stringBuffer.append(TEXT_31);
    
		}
	}
}
    stringBuffer.append(TEXT_32);
    if(!useExistingConn){
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    }
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(TEXT_38);
    return stringBuffer.toString();
  }
}
