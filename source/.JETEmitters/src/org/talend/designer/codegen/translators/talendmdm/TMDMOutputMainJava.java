package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.EConnectionType;
import java.util.List;
import java.util.Map;

public class TMDMOutputMainJava
{
  protected static String nl;
  public static synchronized TMDMOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMOutputMainJava result = new TMDMOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "        ";
  protected final String TEXT_2 = " = null;";
  protected final String TEXT_3 = NL + "      ";
  protected final String TEXT_4 = " = new ";
  protected final String TEXT_5 = "Struct();";
  protected final String TEXT_6 = NL + "      ";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = ";";
  protected final String TEXT_11 = NL + "      ";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = " = ";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = ".toString();";
  protected final String TEXT_16 = NL + "\t";
  protected final String TEXT_17 = ".";
  protected final String TEXT_18 = " = ";
  protected final String TEXT_19 = ".";
  protected final String TEXT_20 = ";";
  protected final String TEXT_21 = NL + "    input_";
  protected final String TEXT_22 = " = ";
  protected final String TEXT_23 = ".";
  protected final String TEXT_24 = ".toString();" + NL + "" + NL + "    try {" + NL + "\t\t";
  protected final String TEXT_25 = NL + "\t\t\torg.talend.mdm.webservice.WSPartialPutItem wsPartialPutItem_";
  protected final String TEXT_26 = " = new org.talend.mdm.webservice.WSPartialPutItem(input_";
  protected final String TEXT_27 = ",";
  protected final String TEXT_28 = ",";
  protected final String TEXT_29 = ",";
  protected final String TEXT_30 = ",";
  protected final String TEXT_31 = ",";
  protected final String TEXT_32 = ",";
  protected final String TEXT_33 = ",";
  protected final String TEXT_34 = ");" + NL + "\t\t\twspk_";
  protected final String TEXT_35 = " = xtentisWS_";
  protected final String TEXT_36 = ".partialPutItem(wsPartialPutItem_";
  protected final String TEXT_37 = ");" + NL + "\t\t\t";
  protected final String TEXT_38 = NL + "\t              \t";
  protected final String TEXT_39 = ".";
  protected final String TEXT_40 = "= wspk_";
  protected final String TEXT_41 = ".getIds(";
  protected final String TEXT_42 = ");" + NL + "\t            ";
  protected final String TEXT_43 = "     " + NL + "            " + NL + "\t\t";
  protected final String TEXT_44 = "   " + NL + "\t\t\t" + NL + "\t\t\torg.talend.mdm.webservice.WSPutItem item_";
  protected final String TEXT_45 = " = new org.talend.mdm.webservice.WSPutItem(dataCluster_";
  protected final String TEXT_46 = ",input_";
  protected final String TEXT_47 = ",dataModel_";
  protected final String TEXT_48 = ", ";
  protected final String TEXT_49 = ");" + NL + "\t      \t";
  protected final String TEXT_50 = NL + "\t        \torg.talend.mdm.webservice.WSPutItemWithReport itemReport_";
  protected final String TEXT_51 = " = new org.talend.mdm.webservice.WSPutItemWithReport(item_";
  protected final String TEXT_52 = ",";
  protected final String TEXT_53 = ",";
  protected final String TEXT_54 = ");" + NL + "\t\t" + NL + "\t\t        ";
  protected final String TEXT_55 = NL + "\t\t        \t";
  protected final String TEXT_56 = NL + "\t\t        \t\ttaskIDs_";
  protected final String TEXT_57 = ".add(";
  protected final String TEXT_58 = "); " + NL + "\t\t        \t";
  protected final String TEXT_59 = NL + "\t\t          miList_";
  protected final String TEXT_60 = ".add(itemReport_";
  protected final String TEXT_61 = ");" + NL + "\t\t" + NL + "\t\t          if (miList_";
  protected final String TEXT_62 = ".size() >= ";
  protected final String TEXT_63 = ") {" + NL + "\t\t            wspks_";
  protected final String TEXT_64 = " = xtentisWS_";
  protected final String TEXT_65 = ".putItemWithReportArray(miList_";
  protected final String TEXT_66 = ".toArray(new org.talend.mdm.webservice.WSPutItemWithReport[";
  protected final String TEXT_67 = "]));" + NL + "\t\t            miList_";
  protected final String TEXT_68 = ".clear();" + NL + "\t\t            ";
  protected final String TEXT_69 = NL + "\t\t            \txtentisWS_";
  protected final String TEXT_70 = ".updateItemArrayMetadata(util_";
  protected final String TEXT_71 = ". makeUpdateMeteItms(taskIDs_";
  protected final String TEXT_72 = ",wspks_";
  protected final String TEXT_73 = "));" + NL + "\t\t            \ttaskIDs_";
  protected final String TEXT_74 = ".clear();" + NL + "\t\t            ";
  protected final String TEXT_75 = NL + "\t\t          }" + NL + "\t\t        ";
  protected final String TEXT_76 = NL + "\t\t          wspk_";
  protected final String TEXT_77 = " = xtentisWS_";
  protected final String TEXT_78 = ".putItemWithReport(itemReport_";
  protected final String TEXT_79 = ");" + NL + "\t\t          \t";
  protected final String TEXT_80 = NL + "\t\t            \txtentisWS_";
  protected final String TEXT_81 = ".updateItemMetadata(util_";
  protected final String TEXT_82 = ". makeUpdateMeteItm(";
  protected final String TEXT_83 = ",wspk_";
  protected final String TEXT_84 = "));" + NL + "\t\t            ";
  protected final String TEXT_85 = NL + "\t\t        ";
  protected final String TEXT_86 = NL + "\t\t            ";
  protected final String TEXT_87 = ".";
  protected final String TEXT_88 = "= wspk_";
  protected final String TEXT_89 = ".getIds(";
  protected final String TEXT_90 = ");" + NL + "\t\t          ";
  protected final String TEXT_91 = NL + "\t\t        \t";
  protected final String TEXT_92 = NL + "\t\t        \t\ttaskIDs_";
  protected final String TEXT_93 = ".add(";
  protected final String TEXT_94 = "); " + NL + "\t\t        \t";
  protected final String TEXT_95 = NL + "\t\t          miList_";
  protected final String TEXT_96 = ".add(item_";
  protected final String TEXT_97 = ");" + NL + "\t\t" + NL + "\t\t          if (miList_";
  protected final String TEXT_98 = ".size() >= ";
  protected final String TEXT_99 = ") {" + NL + "\t\t            wspks_";
  protected final String TEXT_100 = " = xtentisWS_";
  protected final String TEXT_101 = ".putItemArray(miList_";
  protected final String TEXT_102 = ".toArray(new org.talend.mdm.webservice.WSPutItem[";
  protected final String TEXT_103 = "]));" + NL + "\t\t            miList_";
  protected final String TEXT_104 = ".clear();" + NL + "\t\t            ";
  protected final String TEXT_105 = NL + "\t\t            \txtentisWS_";
  protected final String TEXT_106 = ".updateItemArrayMetadata(util_";
  protected final String TEXT_107 = ". makeUpdateMeteItms(taskIDs_";
  protected final String TEXT_108 = ",wspks_";
  protected final String TEXT_109 = "));" + NL + "\t\t            \ttaskIDs_";
  protected final String TEXT_110 = ".clear();" + NL + "\t\t            ";
  protected final String TEXT_111 = NL + "\t\t          }" + NL + "\t\t        ";
  protected final String TEXT_112 = NL + "\t\t          wspk_";
  protected final String TEXT_113 = " = xtentisWS_";
  protected final String TEXT_114 = ".putItem(item_";
  protected final String TEXT_115 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_116 = NL + "\t\t            \txtentisWS_";
  protected final String TEXT_117 = ".updateItemMetadata(util_";
  protected final String TEXT_118 = ". makeUpdateMeteItm(";
  protected final String TEXT_119 = ",wspk_";
  protected final String TEXT_120 = ")); " + NL + "\t\t            ";
  protected final String TEXT_121 = NL + "\t\t          ";
  protected final String TEXT_122 = NL + "\t\t              ";
  protected final String TEXT_123 = ".";
  protected final String TEXT_124 = "= wspk_";
  protected final String TEXT_125 = ".getIds(";
  protected final String TEXT_126 = ");" + NL + "\t\t            ";
  protected final String TEXT_127 = NL + "\t    ";
  protected final String TEXT_128 = "  " + NL + "    } catch (java.lang.Exception e) {";
  protected final String TEXT_129 = NL + "        throw(e);";
  protected final String TEXT_130 = NL + "            ";
  protected final String TEXT_131 = " = null;";
  protected final String TEXT_132 = NL + "          ";
  protected final String TEXT_133 = " = new ";
  protected final String TEXT_134 = "Struct();" + NL + "          " + NL + "          \t";
  protected final String TEXT_135 = NL + "\t\t  ";
  protected final String TEXT_136 = ".";
  protected final String TEXT_137 = " = ";
  protected final String TEXT_138 = ".";
  protected final String TEXT_139 = ".toString();" + NL + "\t\t\t";
  protected final String TEXT_140 = NL + "\t\t  ";
  protected final String TEXT_141 = ".";
  protected final String TEXT_142 = " = ";
  protected final String TEXT_143 = ".";
  protected final String TEXT_144 = ";" + NL + "\t\t   \t";
  protected final String TEXT_145 = NL + "\t\t   \t\t\t\t";
  protected final String TEXT_146 = ".xml = input_";
  protected final String TEXT_147 = ";" + NL + "\t\t   \t\t\t";
  protected final String TEXT_148 = NL + "\t\t   \t\t\t\t";
  protected final String TEXT_149 = ".xml = ";
  protected final String TEXT_150 = ".xml;" + NL + "\t\t   \t\t\t";
  protected final String TEXT_151 = "   ";
  protected final String TEXT_152 = NL + "          ";
  protected final String TEXT_153 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_154 = ";";
  protected final String TEXT_155 = NL + "          System.err.println(e.getMessage());";
  protected final String TEXT_156 = NL + "    }" + NL + "    nb_line_";
  protected final String TEXT_157 = "++;";
  protected final String TEXT_158 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

boolean isStaging = "STAGING".equalsIgnoreCase(ElementParameterParser.getValue(node, "__CONTAINER_TYPE__"));

String destination = ElementParameterParser.getValue(node, "__DESTINATION__");
boolean withReport = ("true").equals(ElementParameterParser.getValue(node,"__WITHREPORT__"));
String needCheck = ElementParameterParser.getValue(node,"__ISINVOKE__");
boolean isMassInsert =("true").equals(ElementParameterParser.getValue(node,"__EXTENDINSERT__"));
String numMassInsert = ElementParameterParser.getValue(node,"__COMMIT_LEVEL__");
String sourceName = ElementParameterParser.getValue(node,"__SOURCE__");
boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node,"__DIE_ON_ERROR__"));
String isUpdate = ElementParameterParser.getValue(node,"__ISUPDATE__");
List<Map<String,String>> keysReturn = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__RETURN_IDS__");

boolean addTaskID = ("true").equals(ElementParameterParser.getValue(node,"__ADD_TASKID__"));
boolean isCustom = "true".equals(ElementParameterParser.getValue(node, "__CUSTOM__")); 
String taskID = ElementParameterParser.getValue(node,"__TASKID__");
String prevColumn = ElementParameterParser.getValue(node, "__PREV_COLUMN_TASK_ID__");

boolean usePartialUpdate = ("true").equals(ElementParameterParser.getValue(node,"__USE_PARTIAL_UPDATE__"));
String pivot = ElementParameterParser.getValue(node,"__PIVOT__");
boolean overwrite = ("true").equals(ElementParameterParser.getValue(node,"__OVERWRITE__"));
String key = ElementParameterParser.getValue(node,"__KEY__");
String position = ElementParameterParser.getValue(node,"__POSITION__");
String dataModule = ElementParameterParser.getValue(node, "__DATAMODEL__");
String dataCluster = ElementParameterParser.getValue(node, "__DATACLUSTER__");

String doc = ElementParameterParser.getValue(node, "__DOCUMENT__");

List<IMetadataTable> metadatas = node.getMetadataList();

if (destination != null && !"".equals(destination)) {
  cid = destination;
}

if (metadatas != null && metadatas.size()>0) { 
  IMetadataTable metadata = metadatas.get(0);
  if (metadata != null) { 
  
  	List<? extends IConnection> outputConns = node.getOutgoingConnections(EConnectionType.FLOW_MAIN);
  	List<IMetadataColumn> inputColumnList = null;
  	List<IMetadataColumn> outputColumnList = null;
  	List<IMetadataColumn> columnList =metadata.getListColumns();
  	
    String rejectConnName = null;
    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
    List<IMetadataColumn> rejectColumnList = null;
    if (rejectConns != null && rejectConns.size() > 0) {
      IConnection rejectConn = rejectConns.get(0);
      if(rejectConn!=null){
      	rejectConnName = rejectConn.getName();
      	IMetadataTable metadataTable = rejectConn.getMetadataTable();
      	if(metadataTable!=null){
      		rejectColumnList = metadataTable.getListColumns();
      	}
      }
    }
   
    String outConnName = null;
	String inputConnName = null;
    List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();

    for(IConnection tmpconn : outgoingConns) {
      if (tmpconn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
        if(rejectConnName==null || !rejectConnName.equals(tmpconn.getName())){
          outConnName=tmpconn.getName();
		  IMetadataTable outputMetadata = tmpconn.getMetadataTable();
		  if(outputMetadata!=null){
		      outputColumnList = outputMetadata.getListColumns();
		  }
        }
    stringBuffer.append(TEXT_1);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_2);
    
      }
    }
	
	List<? extends IConnection> inputConns = node.getIncomingConnections();
    if (inputConns != null && inputConns.size() > 0) {
      IConnection inputConn = inputConns.get(0);
      if(inputConn!=null){
      	inputConnName = inputConn.getName();
      	IMetadataTable inputMetadata = inputConn.getMetadataTable();
      	if(inputMetadata!=null) {
      		inputColumnList = inputMetadata.getListColumns();
      	}
	  }
	}

    if (outConnName != null && inputConnName!=null) {
    
    stringBuffer.append(TEXT_3);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_5);
    
        for(IMetadataColumn outputColumn : outputColumnList) {
        	for(IMetadataColumn inputColumn : inputColumnList) {
        		if (outputColumn.getLabel().equals(inputColumn.getLabel())) {
	        		if(doc!=null && doc.equals(outputColumn.getLabel())) {
	        			if("id_Document".equals(outputColumn.getTalendType())) {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(doc);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(inputConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(doc);
    stringBuffer.append(TEXT_10);
    
        				} else {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(doc);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(inputConnName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(doc);
    stringBuffer.append(TEXT_15);
     
    					}
    				} else { // to those which do not match doc columns

    stringBuffer.append(TEXT_16);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(outputColumn.getLabel());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(inputConnName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(inputColumn.getLabel());
    stringBuffer.append(TEXT_20);
    
    				}
    			} // if input column matches output column
    		} // for input column
    	} // for output column
    }
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(inputConnName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(doc);
    stringBuffer.append(TEXT_24);
    if(usePartialUpdate){ // partial
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(dataCluster );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(pivot);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(dataModule );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(key.equals("")?null:key);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(position.equals("")?null:position);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(overwrite);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(withReport);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
	        if (outConnName !=null && !isMassInsert && keysReturn.size() > 0) {
	        	for (int i = 0; i < keysReturn.size(); i++){
	            	Map<String,String> map = keysReturn.get(i);
	              	
    stringBuffer.append(TEXT_38);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(map.get("OUTPUT_COLUMN"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_42);
    
	            }
	       	}
		   	
    stringBuffer.append(TEXT_43);
    }else{// not partial 
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(isUpdate );
    stringBuffer.append(TEXT_49);
    
		    if (!isStaging && withReport) {
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(sourceName );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(needCheck );
    stringBuffer.append(TEXT_54);
    if (isMassInsert) {
    stringBuffer.append(TEXT_55);
    if(addTaskID){
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(isCustom?taskID:inputConnName + "." + prevColumn);
    stringBuffer.append(TEXT_58);
    }
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(numMassInsert );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(numMassInsert );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    if(addTaskID){
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    }
    stringBuffer.append(TEXT_75);
    } else {
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    if(addTaskID){
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(isCustom?taskID:inputConnName + "." + prevColumn);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    }
    stringBuffer.append(TEXT_85);
    
		        }
		
		        if (outConnName !=null && !isMassInsert && keysReturn.size() > 0) {
		        
		          for (int i = 0; i < keysReturn.size(); i++){
		            Map<String,String> map = keysReturn.get(i);
		            
    stringBuffer.append(TEXT_86);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(map.get("OUTPUT_COLUMN"));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_90);
    
		          }
		        }
		      } else {
		      
		        if (isMassInsert) {
		        
    stringBuffer.append(TEXT_91);
    if(addTaskID){
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(isCustom?taskID:inputConnName + "." + prevColumn);
    stringBuffer.append(TEXT_94);
    }
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(numMassInsert );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(numMassInsert );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    if(addTaskID){
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    }
    stringBuffer.append(TEXT_111);
    
		        } else {
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    if(addTaskID){
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(isCustom?taskID:inputConnName + "." + prevColumn);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    }
    stringBuffer.append(TEXT_121);
    
		          if (outConnName !=null && !isMassInsert && keysReturn.size() > 0) {
		            for (int i = 0; i < keysReturn.size(); i++){
		              Map<String,String> map = keysReturn.get(i);
		              
    stringBuffer.append(TEXT_122);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(map.get("OUTPUT_COLUMN"));
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_126);
    
		            }
		          }
		        }
		      }
		      
    stringBuffer.append(TEXT_127);
    }//end partial
    stringBuffer.append(TEXT_128);
    if (dieOnError) {
    stringBuffer.append(TEXT_129);
    } else {

        if (rejectConnName != null) {
          if (outConnName != null) {
    stringBuffer.append(TEXT_130);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_131);
    }
    stringBuffer.append(TEXT_132);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_134);
    
            for(IMetadataColumn column : columnList) {
				if (!"xml".equals(column.getLabel()) && !"errorCode".equals(column.getLabel()) && !"errorMessage".equals(column.getLabel())) {
					if(column.getLabel().equals(doc) && "id_String".equals(column.getTalendType())) {
			
    stringBuffer.append(TEXT_135);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_137);
    stringBuffer.append(inputConnName );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_139);
    
					} else {
			
    stringBuffer.append(TEXT_140);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_142);
    stringBuffer.append(inputConnName );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_144);
    
		   			}
		   		}
		   		if("xml".equals(column.getLabel())){
		   			if("id_String".equals(column.getTalendType())){
		   			
    stringBuffer.append(TEXT_145);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
     
		   			}else{
		   				  
    stringBuffer.append(TEXT_148);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(inputConnName );
    stringBuffer.append(TEXT_150);
    
		   			}
		   		}
			}
			
    stringBuffer.append(TEXT_151);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_154);
    } else {
    stringBuffer.append(TEXT_155);
    }
      }
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    
  }
}
    stringBuffer.append(TEXT_158);
    return stringBuffer.toString();
  }
}
