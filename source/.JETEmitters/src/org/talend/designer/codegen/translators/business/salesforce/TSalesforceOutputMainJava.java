package org.talend.designer.codegen.translators.business.salesforce;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class TSalesforceOutputMainJava
{
  protected static String nl;
  public static synchronized TSalesforceOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSalesforceOutputMainJava result = new TSalesforceOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "    java.util.Properties props_";
  protected final String TEXT_3 = " = System.getProperties();" + NL + "    props_";
  protected final String TEXT_4 = ".put(\"socksProxyHost\",";
  protected final String TEXT_5 = ");  " + NL + "    props_";
  protected final String TEXT_6 = ".put(\"socksProxyPort\",";
  protected final String TEXT_7 = ");" + NL + "    props_";
  protected final String TEXT_8 = ".put(\"java.net.socks.username\", ";
  protected final String TEXT_9 = ");" + NL + "    props_";
  protected final String TEXT_10 = ".put(\"java.net.socks.password\", ";
  protected final String TEXT_11 = "); " + NL + "    ";
  protected final String TEXT_12 = NL;
  protected final String TEXT_13 = NL + NL + "\t";
  protected final String TEXT_14 = " = null;\t\t\t";
  protected final String TEXT_15 = NL + "///////////////////////\t\t" + NL + "" + NL + "" + NL + "Object[] resultMessageObj_";
  protected final String TEXT_16 = " = null;";
  protected final String TEXT_17 = NL + NL + "\t\t\t\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tjava.util.List<org.apache.axiom.om.OMElement> list_";
  protected final String TEXT_19 = " = new java.util.ArrayList<org.apache.axiom.om.OMElement>();" + NL + "\t\t\t\t//the null value will be updated or inserted,so we can't treat it as key for updating(only Id can be the key) or upserting(Id,external id or indexed id)" + NL + "\t\t\t\tjava.util.List<String> nullList_";
  protected final String TEXT_20 = " = new java.util.ArrayList<String>();\t\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\t\t\t\t\torg.apache.axiom.om.OMElement reference_";
  protected final String TEXT_22 = "_";
  protected final String TEXT_23 = "_";
  protected final String TEXT_24 = " = fac_";
  protected final String TEXT_25 = ".createOMElement(";
  protected final String TEXT_26 = ", null);" + NL + "\t\t\t\t\t\t\t\treference_";
  protected final String TEXT_27 = "_";
  protected final String TEXT_28 = "_";
  protected final String TEXT_29 = ".addChild(sforceManagement_";
  protected final String TEXT_30 = ".newOMElement(\"type\",";
  protected final String TEXT_31 = "));";
  protected final String TEXT_32 = NL + "\t\t\t\t\t\t\t\t\tif(";
  protected final String TEXT_33 = ".";
  protected final String TEXT_34 = " != null){" + NL + "\t\t\t\t\t\t\t\t\t\treference_";
  protected final String TEXT_35 = "_";
  protected final String TEXT_36 = "_";
  protected final String TEXT_37 = ".addChild(sforceManagement_";
  protected final String TEXT_38 = ".newOMElement(";
  protected final String TEXT_39 = ",FormatterUtils.format_Date(";
  protected final String TEXT_40 = ".";
  protected final String TEXT_41 = ", ";
  protected final String TEXT_42 = ") ));" + NL + "\t\t\t\t\t\t\t\t\t}";
  protected final String TEXT_43 = NL + "\t\t\t\t\t\t\t\t\tif(";
  protected final String TEXT_44 = ".";
  protected final String TEXT_45 = " != null){" + NL + "\t\t\t\t\t\t\t\t\t\treference_";
  protected final String TEXT_46 = "_";
  protected final String TEXT_47 = "_";
  protected final String TEXT_48 = ".addChild(sforceManagement_";
  protected final String TEXT_49 = ".newOMElement(";
  protected final String TEXT_50 = ",java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_51 = ".";
  protected final String TEXT_52 = ")).toString() ));" + NL + "\t\t\t\t\t\t\t\t\t}";
  protected final String TEXT_53 = "   \t\t\t\t" + NL + "\t\t\t\t\t    \t\t\t";
  protected final String TEXT_54 = NL + "\t\t\t\t\t    \t\t\tif(";
  protected final String TEXT_55 = ".";
  protected final String TEXT_56 = " != null && !\"\".equals(String.valueOf(";
  protected final String TEXT_57 = ".";
  protected final String TEXT_58 = "))) { " + NL + "\t\t\t\t\t    \t\t\t";
  protected final String TEXT_59 = NL + "\t\t\t\t\t    \t\t\tif(!\"\".equals(String.valueOf(";
  protected final String TEXT_60 = ".";
  protected final String TEXT_61 = "))) { " + NL + "\t\t\t\t\t    \t\t\t";
  protected final String TEXT_62 = NL + "\t\t\t\t\t\t\t\t\t\treference_";
  protected final String TEXT_63 = "_";
  protected final String TEXT_64 = "_";
  protected final String TEXT_65 = ".addChild(sforceManagement_";
  protected final String TEXT_66 = ".newOMElement(";
  protected final String TEXT_67 = ",String.valueOf(";
  protected final String TEXT_68 = ".";
  protected final String TEXT_69 = ") ));" + NL + "\t\t\t\t\t\t\t\t\t}";
  protected final String TEXT_70 = NL + "\t\t\t\t\t\t\t\tlist_";
  protected final String TEXT_71 = ".add(reference_";
  protected final String TEXT_72 = "_";
  protected final String TEXT_73 = "_";
  protected final String TEXT_74 = ");";
  protected final String TEXT_75 = NL + "\t\t\t\t\t\tif(";
  protected final String TEXT_76 = ".";
  protected final String TEXT_77 = " != null){" + NL + "\t\t\t\t\t\t\tlist_";
  protected final String TEXT_78 = ".add(sforceManagement_";
  protected final String TEXT_79 = ".newOMElement(\"";
  protected final String TEXT_80 = "\",FormatterUtils.format_Date(";
  protected final String TEXT_81 = ".";
  protected final String TEXT_82 = ", ";
  protected final String TEXT_83 = ") ));" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_84 = NL + "\t\t\t\t\t\tif(";
  protected final String TEXT_85 = ".";
  protected final String TEXT_86 = " != null){" + NL + "\t\t\t\t\t\t\tlist_";
  protected final String TEXT_87 = ".add(sforceManagement_";
  protected final String TEXT_88 = ".newOMElement(\"";
  protected final String TEXT_89 = "\",java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_90 = ".";
  protected final String TEXT_91 = ")).toString() ));" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_92 = "   \t\t\t\t" + NL + "\t\t    \t\t\t";
  protected final String TEXT_93 = NL + "\t\t    \t\t\tif(";
  protected final String TEXT_94 = ".";
  protected final String TEXT_95 = " != null && !\"\".equals(String.valueOf(";
  protected final String TEXT_96 = ".";
  protected final String TEXT_97 = "))) { " + NL + "\t\t    \t\t\t";
  protected final String TEXT_98 = NL + "\t\t    \t\t\tif(!\"\".equals(String.valueOf(";
  protected final String TEXT_99 = ".";
  protected final String TEXT_100 = "))) { " + NL + "\t\t    \t\t\t";
  protected final String TEXT_101 = NL + "\t\t\t\t\t\t\tlist_";
  protected final String TEXT_102 = ".add(sforceManagement_";
  protected final String TEXT_103 = ".newOMElement(\"";
  protected final String TEXT_104 = "\",String.valueOf(";
  protected final String TEXT_105 = ".";
  protected final String TEXT_106 = ") ));" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_107 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_108 = NL + "\t\t\t\t\t    else{" + NL + "\t\t\t\t\t\t\tnullList_";
  protected final String TEXT_109 = ".add(\"";
  protected final String TEXT_110 = "\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_111 = NL + "\t\t\t\t\t\t\t" + NL + " \t\t\t" + NL + "    \t\t\t";
  protected final String TEXT_112 = " " + NL + "\t\t\t";
  protected final String TEXT_113 = NL + NL + "resultMessageObj_";
  protected final String TEXT_114 = " = sforceManagement_";
  protected final String TEXT_115 = ".insert(";
  protected final String TEXT_116 = ", (org.apache.axiom.om.OMElement[])list_";
  protected final String TEXT_117 = ".toArray(new org.apache.axiom.om.OMElement[list_";
  protected final String TEXT_118 = ".size()]));    \t\t\t" + NL;
  protected final String TEXT_119 = NL + NL + "resultMessageObj_";
  protected final String TEXT_120 = " = sforceManagement_";
  protected final String TEXT_121 = ".update(";
  protected final String TEXT_122 = ", ";
  protected final String TEXT_123 = ".Id, (org.apache.axiom.om.OMElement[])list_";
  protected final String TEXT_124 = ".toArray(new org.apache.axiom.om.OMElement[list_";
  protected final String TEXT_125 = ".size()]),(String[])nullList_";
  protected final String TEXT_126 = ".toArray(new String[nullList_";
  protected final String TEXT_127 = ".size()]));    \t\t\t" + NL;
  protected final String TEXT_128 = " " + NL + "" + NL + "resultMessageObj_";
  protected final String TEXT_129 = " = sforceManagement_";
  protected final String TEXT_130 = ".upsert(";
  protected final String TEXT_131 = ", \"";
  protected final String TEXT_132 = "\", (org.apache.axiom.om.OMElement[])list_";
  protected final String TEXT_133 = ".toArray(new org.apache.axiom.om.OMElement[list_";
  protected final String TEXT_134 = ".size()]),(String[])nullList_";
  protected final String TEXT_135 = ".toArray(new String[nullList_";
  protected final String TEXT_136 = ".size()]));    \t\t\t" + NL;
  protected final String TEXT_137 = NL + "    \t\t\t";
  protected final String TEXT_138 = NL + NL + "resultMessageObj_";
  protected final String TEXT_139 = " = sforceManagement_";
  protected final String TEXT_140 = ".delete(";
  protected final String TEXT_141 = ".Id);    \t\t\t" + NL;
  protected final String TEXT_142 = "     \t\t\t" + NL + "    \t\t\t" + NL + "\t\t\t\tnb_line_";
  protected final String TEXT_143 = "++; " + NL;
  protected final String TEXT_144 = NL + "\t\t\t\tjava.util.Map<String,String> resultMessage_";
  protected final String TEXT_145 = " = sforceManagement_";
  protected final String TEXT_146 = ".readResult(resultMessageObj_";
  protected final String TEXT_147 = ");" + NL + "\t\t\t\tif(resultMessage_";
  protected final String TEXT_148 = "!=null){" + NL + "\t\t\t\t\tif(\"true\".equals(resultMessage_";
  protected final String TEXT_149 = ".get(\"success\"))){";
  protected final String TEXT_150 = NL + "\t\t\tnb_success_";
  protected final String TEXT_151 = "++;" + NL + "\t\t\t";
  protected final String TEXT_152 = " = new ";
  protected final String TEXT_153 = "Struct();";
  protected final String TEXT_154 = NL + "\t\t\t";
  protected final String TEXT_155 = ".salesforce_id = resultMessage_";
  protected final String TEXT_156 = ".get(\"id\");";
  protected final String TEXT_157 = "\t\t\t" + NL + "\t\t    ";
  protected final String TEXT_158 = ".";
  protected final String TEXT_159 = " = ";
  protected final String TEXT_160 = ".";
  protected final String TEXT_161 = ";\t\t\t";
  protected final String TEXT_162 = NL + "\t\t\t\t}else{";
  protected final String TEXT_163 = NL + "\t\t\tnb_reject_";
  protected final String TEXT_164 = "++;" + NL + "\t\t\t";
  protected final String TEXT_165 = " = new ";
  protected final String TEXT_166 = "Struct();" + NL + "\t\t\t";
  protected final String TEXT_167 = ".errorCode = resultMessage_";
  protected final String TEXT_168 = ".get(\"StatusCode\");" + NL + "\t\t\t";
  protected final String TEXT_169 = ".errorFields = resultMessage_";
  protected final String TEXT_170 = ".get(\"Fields\");" + NL + "\t\t\t";
  protected final String TEXT_171 = ".errorMessage = resultMessage_";
  protected final String TEXT_172 = ".get(\"Message\");";
  protected final String TEXT_173 = "\t\t\t" + NL + "\t\t    ";
  protected final String TEXT_174 = ".";
  protected final String TEXT_175 = " = ";
  protected final String TEXT_176 = ".";
  protected final String TEXT_177 = ";\t\t\t";
  protected final String TEXT_178 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}";
  protected final String TEXT_179 = "\t";
  protected final String TEXT_180 = NL + "\t\t\tnb_success_";
  protected final String TEXT_181 = "++;" + NL + "\t\t\t";
  protected final String TEXT_182 = " = new ";
  protected final String TEXT_183 = "Struct();";
  protected final String TEXT_184 = "\t\t\t" + NL + "\t\t    ";
  protected final String TEXT_185 = ".";
  protected final String TEXT_186 = " = ";
  protected final String TEXT_187 = ".";
  protected final String TEXT_188 = ";\t\t\t";
  protected final String TEXT_189 = "\t\t \t";
  protected final String TEXT_190 = "\t\t\t    \t\t\t" + NL + "///////////////////////    \t\t\t";
  protected final String TEXT_191 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();    	

	boolean useProxy = ("true").equals(ElementParameterParser.getValue(node,"__USE_PROXY__"));
	String proxyHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
   	String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");
   	String proxyUsername = ElementParameterParser.getValue(node,"__PROXY_USERNAME__");
   	String proxyPassword = ElementParameterParser.getValue(node,"__PROXY_PASSWORD__");

String action = ElementParameterParser.getValue(node, "__ACTION__");
String modulename = ElementParameterParser.getValue(node, "__MODULENAME__");

String customModulename = ElementParameterParser.getValue(node, "__CUSTOM_MODULE_NAME__");

boolean retreiveInsertID = ("true").equals(ElementParameterParser.getValue(node, "__RETREIVE_INSERT_ID__"));
boolean extendedInsert = ("true").equals(ElementParameterParser.getValue(node, "__EXTENDINSERT__"));

boolean ignoreNullValue = ("true").equals(ElementParameterParser.getValue(node, "__IGNORE_NULL__"));

//var for upsert(contain upsert by relationship)
String upsertkey = ElementParameterParser.getValue(node, "__UPSERT_KEY_COLUMN__");
List<Map<String, String>> relationshipMappings = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__UPSERT_RELATION__");

    stringBuffer.append(TEXT_1);
    
	String loginType = ElementParameterParser.getValue(node,"__LOGIN_TYPE__");
	boolean useOAuth = "OAUTH".equals(loginType);
if(!useOAuth && useProxy){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(proxyPort );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(proxyUsername );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(proxyPassword );
    stringBuffer.append(TEXT_11);
    
}

    stringBuffer.append(TEXT_12);
    
if ("CustomModule".equals(modulename)) {
	//modulename = customModulename; 
	modulename = customModulename;
}else{
	modulename = "\""+modulename+"\"";
}

boolean ceaseForError = ("true").equals(ElementParameterParser.getValue(node, "__CEASE_FOR_ERROR__"));

List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
if(outgoingConns!=null){
	for (int i=0;i<outgoingConns.size();i++) {
    IConnection outgoingConn = outgoingConns.get(i);
    	if (outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_14);
    
    	}
    }
}
    	
List<? extends IConnection> connsSuccess = node.getOutgoingConnections("MAIN");
List<? extends IConnection> connsReject = node.getOutgoingConnections("REJECT");

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {//1
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {//2
    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	for (IConnection conn : conns) {//3
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//4

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
 if ("insert".equals(action) || "update".equals(action) || "upsert".equals(action)) {//************

    stringBuffer.append(TEXT_17);
      
    			List<IMetadataColumn> columns = metadata.getListColumns();
    			int sizeColumns = columns.size();

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
        			
    			for (int i = 0; i < sizeColumns; i++) {//5  			

  			        
    				IMetadataColumn column = columns.get(i);
    				JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				
    				boolean generateFinished = false;
    				if("upsert".equals(action) && (relationshipMappings.size() > 0)) {//TD512
    					int j = 0;
						for(Map<String,String> row : relationshipMappings) {
							String columnName = row.get("COLUMN_NAME");
							if(columnName.equals(column.getLabel())) {
								j++;
								String loookupFieldName = row.get("LOOKUP_FIELD_NAME");
								String externalIdFromLookupField = row.get("LOOKUP_FIELD_EXTERNAL_ID_NAME");
								String moduleNameOfLookupField = row.get("LOOKUP_FIELD_MODULE_NAME");
								generateFinished = true;

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(loookupFieldName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(moduleNameOfLookupField);
    stringBuffer.append(TEXT_31);
    
								if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {

    stringBuffer.append(TEXT_32);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(externalIdFromLookupField );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_41);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_42);
    
								} else if (javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(TEXT_43);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(externalIdFromLookupField );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_52);
    
								} else {//TD1024

    stringBuffer.append(TEXT_53);
    if(!isPrimitive) {
    stringBuffer.append(TEXT_54);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_58);
    }else{
    stringBuffer.append(TEXT_59);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_61);
    }
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(externalIdFromLookupField );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_69);
    
								}////TD1024

    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_74);
    
							}
						}
    				}//TD512
    				
    				//make sure to filter the schema "Id", when updating (but not when upserting)
  			        if(("Id".equals(column.getLabel()) && !("upsert".equals(action))) || generateFinished) continue;
    				
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {//Date

    stringBuffer.append(TEXT_75);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_82);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_83);
    				
					} else if (javaType == JavaTypesManager.BYTE_ARRAY) {//byte[]

    stringBuffer.append(TEXT_84);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_91);
    				
					} else {//others
						

    stringBuffer.append(TEXT_92);
    if(!isPrimitive) {
    stringBuffer.append(TEXT_93);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_97);
    }else{
    stringBuffer.append(TEXT_98);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_100);
    }
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_106);
    				
					}

    stringBuffer.append(TEXT_107);
    if(!ignoreNullValue && !(("Id".equals(column.getLabel()) || upsertkey.equals(column.getLabel())) && ("upsert".equals(action)))){
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_110);
    }
    stringBuffer.append(TEXT_111);
    
				}//5	

    stringBuffer.append(TEXT_112);
    
 if ("insert".equals(action)) {//#######

    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(modulename );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    
	} else if ("update".equals(action)) {//#######

    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(modulename );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    
    } else if ("upsert".equals(action)) {//#######

    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(modulename );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(upsertkey);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    
    }//#######

    stringBuffer.append(TEXT_137);
    
	} else if ("delete".equals(action)) {//*************	

    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_141);
    
  }//************

    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    
	if(!extendedInsert){ 

    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    
			if (connsSuccess != null && connsSuccess.size() == 1) {
				IConnection connSuccess = connsSuccess.get(0);
				if (connSuccess.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_153);
    
					if(retreiveInsertID&&"insert".equals(action)){

    stringBuffer.append(TEXT_154);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    
					}

    
					for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_157);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_161);
    					 
					}
				}
			}

    stringBuffer.append(TEXT_162);
    
			if (connsReject != null && connsReject.size() == 1) {
				IConnection connReject = connsReject.get(0);
				if (connReject.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    
					for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_173);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_177);
    					 
					}
				}
			}

    stringBuffer.append(TEXT_178);
    
	}else{//batch start

    stringBuffer.append(TEXT_179);
    
			if (connsSuccess != null && connsSuccess.size() == 1) {
				IConnection connSuccess = connsSuccess.get(0);
				if (connSuccess.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_183);
    
					for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_184);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_188);
    					 
					}
				}
			}

    stringBuffer.append(TEXT_189);
    
	}  //batch end

    stringBuffer.append(TEXT_190);
    
    		}//4
    	}//3
    }//2
}//1


    stringBuffer.append(TEXT_191);
    return stringBuffer.toString();
  }
}
