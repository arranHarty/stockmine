package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import java.util.List;
import java.util.Map;

public class TMDMReadConfBeginJava
{
  protected static String nl;
  public static synchronized TMDMReadConfBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMReadConfBeginJava result = new TMDMReadConfBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "       " + NL + "\t\t\t\tint nb_line_";
  protected final String TEXT_2 = " = 0;" + NL + "\t\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\t\torg.talend.mdm.webservice.XtentisServiceLocator xtentisService_";
  protected final String TEXT_4 = " = new org.talend.mdm.webservice.XtentisServiceLocator();" + NL + "\t\t\t\t\txtentisService_";
  protected final String TEXT_5 = ".setXtentisPortEndpointAddress(";
  protected final String TEXT_6 = ");" + NL + "\t\t\t\t\torg.talend.mdm.webservice.XtentisPort xtentisWS_";
  protected final String TEXT_7 = " = xtentisService_";
  protected final String TEXT_8 = ".getXtentisPort();    " + NL + "\t\t\t\t\torg.talend.mdm.webservice.XtentisBindingStub stub_";
  protected final String TEXT_9 = " = (org.talend.mdm.webservice.XtentisBindingStub)xtentisWS_";
  protected final String TEXT_10 = ";" + NL + "\t" + NL + "\t\t\t\t\t// Authentification" + NL + "\t\t\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t\t\t\tstub_";
  protected final String TEXT_12 = ".setUsername(";
  protected final String TEXT_13 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_14 = NL + "\t\t\t\t\t\tstub_";
  protected final String TEXT_15 = ".setUsername(";
  protected final String TEXT_16 = " + \"/\" + ";
  protected final String TEXT_17 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\t\tstub_";
  protected final String TEXT_19 = ".setPassword(";
  protected final String TEXT_20 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\t\torg.talend.mdm.webservice.XtentisPort xtentisWS_";
  protected final String TEXT_22 = " = (org.talend.mdm.webservice.XtentisPort)globalMap.get(\"";
  protected final String TEXT_23 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\t" + NL + "\t\t\t\torg.talend.mdm.webservice.WSDataClusterPK dataCluster_";
  protected final String TEXT_25 = " = new org.talend.mdm.webservice.WSDataClusterPK(";
  protected final String TEXT_26 = " + \"";
  protected final String TEXT_27 = "\");" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_28 = NL + "\t\t\t\t\tString[] ids_";
  protected final String TEXT_29 = " = {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_30 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_31 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t\t};" + NL + "\t\t\t\t\torg.talend.mdm.webservice.WSGetItem wsitem_";
  protected final String TEXT_33 = " = " + NL + "\t\t\t\t\tnew org.talend.mdm.webservice.WSGetItem(new org.talend.mdm.webservice.WSItemPK(dataCluster_";
  protected final String TEXT_34 = ",";
  protected final String TEXT_35 = ",ids_";
  protected final String TEXT_36 = "));" + NL + "\t\t\t\t\tString ";
  protected final String TEXT_37 = "_xml = \"\";" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\torg.talend.mdm.webservice.WSItem item_";
  protected final String TEXT_38 = "=xtentisWS_";
  protected final String TEXT_39 = ".getItem(wsitem_";
  protected final String TEXT_40 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_41 = "_xml = item_";
  protected final String TEXT_42 = ".getContent();" + NL + "\t\t\t\t\t} catch(java.lang.Exception e) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\t\t\t\tthrow e;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_44 = NL + "\t\t\t\t\t\tSystem.err.println(e.getMessage());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_45 = "\t\t\t" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tnb_line_";
  protected final String TEXT_46 = " ++;" + NL + "\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t\t\torg.talend.mdm.webservice.WSWhereCondition wc_";
  protected final String TEXT_48 = " = null;" + NL + "\t\t\t\t\tjava.util.List<org.talend.mdm.webservice.WSWhereItem> conditions_";
  protected final String TEXT_49 = " = new java.util.ArrayList<org.talend.mdm.webservice.WSWhereItem>();" + NL + "\t\t\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t\t\t\twc_";
  protected final String TEXT_51 = " =new org.talend.mdm.webservice.WSWhereCondition(";
  protected final String TEXT_52 = ",org.talend.mdm.webservice.WSWhereOperator.";
  protected final String TEXT_53 = ", ";
  protected final String TEXT_54 = ", org.talend.mdm.webservice.WSStringPredicate.";
  protected final String TEXT_55 = ",false);" + NL + "\t\t\t\t\t\torg.talend.mdm.webservice.WSWhereItem wsItem_";
  protected final String TEXT_56 = "_";
  protected final String TEXT_57 = "=new org.talend.mdm.webservice.WSWhereItem(wc_";
  protected final String TEXT_58 = ",null,null);" + NL + "\t\t\t\t\t\tconditions_";
  protected final String TEXT_59 = ".add(wsItem_";
  protected final String TEXT_60 = "_";
  protected final String TEXT_61 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_62 = NL + "\t\t\t\t\torg.talend.mdm.webservice.WSWhereItem wsItem_";
  protected final String TEXT_63 = " = null;" + NL + "\t\t\t\t\tif(conditions_";
  protected final String TEXT_64 = ".size() > 0){" + NL + "\t\t\t\t\t";
  protected final String TEXT_65 = NL + "\t\t\t\t\t\twsItem_";
  protected final String TEXT_66 = " =new org.talend.mdm.webservice.WSWhereItem(null,conditions_";
  protected final String TEXT_67 = ".toArray(new org.talend.mdm.webservice.WSWhereItem[conditions_";
  protected final String TEXT_68 = ".size()]),null);" + NL + "\t\t\t\t\t";
  protected final String TEXT_69 = NL + "\t\t\t\t\t\twsItem_";
  protected final String TEXT_70 = " =new org.talend.mdm.webservice.WSWhereItem(null,null,conditions_";
  protected final String TEXT_71 = ".toArray(new org.talend.mdm.webservice.WSWhereItem[conditions_";
  protected final String TEXT_72 = ".size()]));" + NL + "\t\t\t\t\t";
  protected final String TEXT_73 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tint limit_";
  protected final String TEXT_74 = " = ";
  protected final String TEXT_75 = ";" + NL + "\t\t\t\t\tint recordsPerPage_";
  protected final String TEXT_76 = " = ";
  protected final String TEXT_77 = ";" + NL + "\t\t\t\t\tint skip_";
  protected final String TEXT_78 = " = ";
  protected final String TEXT_79 = ";" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tif (skip_";
  protected final String TEXT_80 = " < 0)" + NL + "\t\t                skip_";
  protected final String TEXT_81 = " = 0;" + NL + "\t\t" + NL + "\t\t            if (recordsPerPage_";
  protected final String TEXT_82 = " <= 0)" + NL + "\t\t                recordsPerPage_";
  protected final String TEXT_83 = " = -1;// read whole records in one time" + NL + "\t\t" + NL + "\t\t            if (limit_";
  protected final String TEXT_84 = " <= 0)" + NL + "\t\t                limit_";
  protected final String TEXT_85 = " = -1;// no limit" + NL + "\t\t\t\t\t" + NL + "\t\t            int retrievedCount_";
  protected final String TEXT_86 = " = 0;" + NL + "           \t\t\tint readRecordsSize_";
  protected final String TEXT_87 = " = limit_";
  protected final String TEXT_88 = " == -1 ? recordsPerPage_";
  protected final String TEXT_89 = " : (recordsPerPage_";
  protected final String TEXT_90 = " == -1 ? limit_";
  protected final String TEXT_91 = " : (recordsPerPage_";
  protected final String TEXT_92 = " > limit_";
  protected final String TEXT_93 = " ? limit_";
  protected final String TEXT_94 = NL + "                    : recordsPerPage_";
  protected final String TEXT_95 = "));" + NL + "" + NL + "\t\t\t\t\torg.talend.mdm.webservice.WSGetItems getitems_";
  protected final String TEXT_96 = "=null;" + NL + "\t\t\t\t\t" + NL + "            \t\tboolean continueFlag_";
  protected final String TEXT_97 = " = true;" + NL + "            \t\tint totalCount_";
  protected final String TEXT_98 = " = -1;";
  protected final String TEXT_99 = NL + "            \t\twhile (continueFlag_";
  protected final String TEXT_100 = ") {" + NL + "            \t\t\t\t\t                " + NL + "\t\t                getitems_";
  protected final String TEXT_101 = "=new org.talend.mdm.webservice.WSGetItems(dataCluster_";
  protected final String TEXT_102 = ", ";
  protected final String TEXT_103 = ", wsItem_";
  protected final String TEXT_104 = "," + NL + "\t\t\t\t\t\t\t\t\t    \t";
  protected final String TEXT_105 = ",  //spell Threshold" + NL + "\t\t\t\t\t\t\t\t\t\t\tskip_";
  protected final String TEXT_106 = " + retrievedCount_";
  protected final String TEXT_107 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\treadRecordsSize_";
  protected final String TEXT_108 = ",true);" + NL + "\t\t\t\t\t\tString[] items_";
  protected final String TEXT_109 = " = {};" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\titems_";
  protected final String TEXT_110 = " = xtentisWS_";
  protected final String TEXT_111 = ".getItems(getitems_";
  protected final String TEXT_112 = ");" + NL + "\t\t\t\t\t\t\tif(totalCount_";
  protected final String TEXT_113 = " < 0){ " + NL + "\t\t\t\t\t\t\t\ttotalCount_";
  protected final String TEXT_114 = " = Integer.valueOf(items_";
  protected final String TEXT_115 = "[0].replaceAll(\"<totalCount>\", \"\").replaceAll(\"</totalCount>\", \"\"));" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t} catch(java.lang.Exception e) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_116 = NL + "\t\t\t\t\t\t\tthrow e;" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_117 = NL + "\t\t\t\t\t\t\tSystem.err.println(e.getMessage());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_118 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tretrievedCount_";
  protected final String TEXT_119 = " += (items_";
  protected final String TEXT_120 = ".length - 1);" + NL + "\t\t\t\t\t\tif (totalCount_";
  protected final String TEXT_121 = " == retrievedCount_";
  protected final String TEXT_122 = " || recordsPerPage_";
  protected final String TEXT_123 = " == -1 || (items_";
  protected final String TEXT_124 = ".length - 1) < readRecordsSize_";
  protected final String TEXT_125 = " || limit_";
  protected final String TEXT_126 = " == retrievedCount_";
  protected final String TEXT_127 = ") {" + NL + "\t\t                    continueFlag_";
  protected final String TEXT_128 = " = false;" + NL + "\t\t                } else if (limit_";
  protected final String TEXT_129 = " != -1 && limit_";
  protected final String TEXT_130 = " < retrievedCount_";
  protected final String TEXT_131 = " + readRecordsSize_";
  protected final String TEXT_132 = ") {" + NL + "\t\t                    readRecordsSize_";
  protected final String TEXT_133 = " = limit_";
  protected final String TEXT_134 = " - retrievedCount_";
  protected final String TEXT_135 = ";" + NL + "\t\t                }" + NL + "                    \t" + NL + "                    \tfor(int i_";
  protected final String TEXT_136 = " = 1, itemsLength_";
  protected final String TEXT_137 = " = items_";
  protected final String TEXT_138 = ".length; i_";
  protected final String TEXT_139 = " < itemsLength_";
  protected final String TEXT_140 = "; i_";
  protected final String TEXT_141 = "++){" + NL + "\t\t\t\t\t\t\tnb_line_";
  protected final String TEXT_142 = " ++;" + NL + "\t\t\t\t\t\t\tString ";
  protected final String TEXT_143 = "_xml = items_";
  protected final String TEXT_144 = "[i_";
  protected final String TEXT_145 = "];\t" + NL + "            \t\t" + NL + "\t\t\t\t";
  protected final String TEXT_146 = NL + "\t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String destination = ElementParameterParser.getValue(node, "__DESTINATION__");
String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;
if(destination!=null && !"".equals(destination)){
	cid = destination;
}

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas != null) && (metadatas.size() > 0)) {//1
	IMetadataTable metadata = metadatas.get(0);
	
	if (metadata != null) {//2
	
		List<IMetadataColumn> columnList = metadata.getListColumns();
		List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();

		// if output columns are defined
		if (outgoingConns != null && outgoingConns.size() > 0){//3
		
			IConnection outgoingConn = outgoingConns.get(0);
			if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { //4
	
				boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
				String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
				String conn = "xtentisWS_" + connection;
				String mdmUrl = ElementParameterParser.getValue(node, "__MDMURL__");
				String username = ElementParameterParser.getValue(node, "__USERNAME__");
				String password = ElementParameterParser.getValue(node, "__PASSWORD__");
				String universe = ElementParameterParser.getValue(node, "__UNIVERSE__");
				String concept = ElementParameterParser.getValue(node, "__CONCEPT__");
				
				String dataCluster = ElementParameterParser.getValue(node, "__DATACLUSTER__");
				boolean isStaging = "STAGING".equalsIgnoreCase(ElementParameterParser.getValue(node, "__CONTAINER_TYPE__"));
				
				boolean isSingle = ("true").equals(ElementParameterParser.getValue(node, "__USE_ITEMS__"));
				List<Map<String, String>> ids = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__IDS__");
				List<Map<String, String>> operations = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__OPERATIONS__");
				
				String spellThrehold = ElementParameterParser.getValue(node, "__SPELLTHREHOLD__");
				String skip = ElementParameterParser.getValue(node, "__SKIP__");
				String bufferSize = ElementParameterParser.getValue(node, "__FETCHSIZE__");
				String limit = ElementParameterParser.getValue(node, "__MAXVALUE__");
				if(spellThrehold==null || ("").equals(spellThrehold)){
					spellThrehold = "0";
				} 
				if(skip==null || ("").equals(skip)){
					skip = "0";
				} 
				if(limit==null || ("").equals(limit)){
					limit = "0";
				}
				
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    if(!useExistingConn){
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(mdmUrl );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    if(universe==null || ("").equals(universe.trim())){
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_13);
    }else{
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(universe);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(password );
    stringBuffer.append(TEXT_20);
    }else{
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_23);
    }
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(dataCluster );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(isStaging?"#STAGING":"");
    stringBuffer.append(TEXT_27);
    if(!isSingle){//item
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    
						for(int i=0; i<ids.size(); i++){
							Map<String, String> map = ids.get(i);
							String idValue = map.get("IDVALUE");
							
    stringBuffer.append(TEXT_30);
    stringBuffer.append((i==0? "":","));
    stringBuffer.append(idValue );
    stringBuffer.append(TEXT_31);
    
						}
						
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(concept );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    if(dieOnError) {
    stringBuffer.append(TEXT_43);
     } else { 
    stringBuffer.append(TEXT_44);
     } 
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    
				}else{//items
				
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    
					boolean isOnlyOrPredicate=true;
					for(int i=0; i < operations.size(); i++){
						Map<String, String> map= operations.get(i);
						String xpath=map.get("XPATH");
						String operator=map.get("FUNCTION");
						String value = map.get("VALUE");
						String predicate = map.get("PREDICATE");
						if((i < operations.size()-1) && (!"OR".equals(predicate))){
							isOnlyOrPredicate = false;
						}
						
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(xpath );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(operator );
    stringBuffer.append(TEXT_53);
    stringBuffer.append("EMPTY_NULL".equals(operator)? null:value );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(predicate );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    
					}//for
					
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    
					if(!isOnlyOrPredicate){
					
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    
					}else{
					
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    
					}
					
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(limit);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(bufferSize);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(skip);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    //For TDI-26039
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(concept);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(spellThrehold);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    if(dieOnError) {
    stringBuffer.append(TEXT_116);
     } else { 
    stringBuffer.append(TEXT_117);
     } 
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    
				}//end items
				
    stringBuffer.append(TEXT_146);
    
			}//4
		}//3
	}//2
}//1

    return stringBuffer.toString();
  }
}
