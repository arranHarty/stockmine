package org.talend.designer.codegen.translators.databases.couchdb;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import java.util.Map;
import java.util.List;

public class TCouchDBReadConfBeginJava
{
  protected static String nl;
  public static synchronized TCouchDBReadConfBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCouchDBReadConfBeginJava result = new TCouchDBReadConfBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\torg.jcouchdb.db.Server server_";
  protected final String TEXT_2 = " =null;" + NL + "\torg.jcouchdb.db.Database db_";
  protected final String TEXT_3 = " = null;" + NL + "\torg.apache.log4j.Logger.getRootLogger().setLevel(org.apache.log4j.Level.OFF);" + NL + "\t";
  protected final String TEXT_4 = NL + "\tserver_";
  protected final String TEXT_5 = " = (org.jcouchdb.db.Server)globalMap.get(\"server_";
  protected final String TEXT_6 = "\");" + NL + "\tdb_";
  protected final String TEXT_7 = " = (org.jcouchdb.db.Database)globalMap.get(\"db_";
  protected final String TEXT_8 = "\");";
  protected final String TEXT_9 = NL + "\t\tserver_";
  protected final String TEXT_10 = "=new org.jcouchdb.db.ServerImpl(";
  protected final String TEXT_11 = ",";
  protected final String TEXT_12 = ");" + NL + "\t\tdb_";
  protected final String TEXT_13 = " = new org.jcouchdb.db.Database(server_";
  protected final String TEXT_14 = ",";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL + "\t\tjava.util.Map<String, Object> createParams_";
  protected final String TEXT_17 = "=new java.util.HashMap<String,Object>();" + NL + "\t\tjava.util.List<java.util.Map<String, Object>> replicates_";
  protected final String TEXT_18 = " = new java.util.ArrayList<java.util.Map<String, Object>>();" + NL + "\t\tcreateParams_";
  protected final String TEXT_19 = ".put(\"source\",";
  protected final String TEXT_20 = ");" + NL + "\t\torg.jcouchdb.db.Response reponse_";
  protected final String TEXT_21 = " = null;";
  protected final String TEXT_22 = NL + NL + "\t\t\tcreateParams_";
  protected final String TEXT_23 = ".put(\"target\",";
  protected final String TEXT_24 = ");" + NL + "\t\t\tcreateParams_";
  protected final String TEXT_25 = ".put(\"create_target\",";
  protected final String TEXT_26 = ");" + NL + "\t\t\tcreateParams_";
  protected final String TEXT_27 = ".put(\"continuous\",";
  protected final String TEXT_28 = ");" + NL + "\t\t\treponse_";
  protected final String TEXT_29 = " = server_";
  protected final String TEXT_30 = ".post(\"/_replicate\",org.svenson.JSON.defaultJSON().forValue(createParams_";
  protected final String TEXT_31 = "));" + NL + "\t\t\tif(!reponse_";
  protected final String TEXT_32 = ".isOk()){" + NL + "\t\t\t\tSystem.err.println(reponse_";
  protected final String TEXT_33 = ".getContentAsString());" + NL + "\t\t\t}";
  protected final String TEXT_34 = NL + "\t\t\tif(reponse_";
  protected final String TEXT_35 = ".isOk()){" + NL + "\t\t\t\tjava.util.HashMap<String,Object> cancelParams_";
  protected final String TEXT_36 = " = null;" + NL + "\t\t\t\tcancelParams_";
  protected final String TEXT_37 = " = new java.util.HashMap<String,Object>();" + NL + "\t\t\t\tcancelParams_";
  protected final String TEXT_38 = ".put(\"source\",";
  protected final String TEXT_39 = ");" + NL + "\t\t\t\tcancelParams_";
  protected final String TEXT_40 = ".put(\"target\",";
  protected final String TEXT_41 = ");" + NL + "\t\t\t\tcancelParams_";
  protected final String TEXT_42 = ".put(\"continuous\",true);" + NL + "\t\t\t\tcancelParams_";
  protected final String TEXT_43 = ".put(\"create_target\",true);" + NL + "\t\t\t\tcancelParams_";
  protected final String TEXT_44 = ".put(\"cancel\",true);" + NL + "\t\t\t\treplicates_";
  protected final String TEXT_45 = ".add(cancelParams_";
  protected final String TEXT_46 = ");" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_47 = NL + "\t\tint nb_line_";
  protected final String TEXT_48 = " = 0;";
  protected final String TEXT_49 = NL + "\t\torg.jcouchdb.db.Options options_";
  protected final String TEXT_50 = "=new org.jcouchdb.db.Options();" + NL + "\t\torg.svenson.JSONParser parser_";
  protected final String TEXT_51 = " = new org.svenson.JSONParser();";
  protected final String TEXT_52 = NL + "\t\toptions_";
  protected final String TEXT_53 = ".startKey(";
  protected final String TEXT_54 = ");";
  protected final String TEXT_55 = NL + "\t\toptions_";
  protected final String TEXT_56 = ".endKey(";
  protected final String TEXT_57 = ");";
  protected final String TEXT_58 = NL + "\t\toptions_";
  protected final String TEXT_59 = ".startKeyDocId(";
  protected final String TEXT_60 = ");";
  protected final String TEXT_61 = NL + "\t\toptions_";
  protected final String TEXT_62 = ".endKeyDocId(";
  protected final String TEXT_63 = ");";
  protected final String TEXT_64 = NL + "\t\toptions_";
  protected final String TEXT_65 = ".limit(";
  protected final String TEXT_66 = ");";
  protected final String TEXT_67 = NL + "\t\toptions_";
  protected final String TEXT_68 = ".includeDocs(";
  protected final String TEXT_69 = ");";
  protected final String TEXT_70 = NL + "\t\toptions_";
  protected final String TEXT_71 = ".descending(";
  protected final String TEXT_72 = ");";
  protected final String TEXT_73 = NL + "\t\toptions_";
  protected final String TEXT_74 = ".put(";
  protected final String TEXT_75 = ",";
  protected final String TEXT_76 = ");";
  protected final String TEXT_77 = NL + "\t\toptions_";
  protected final String TEXT_78 = ".reduce(";
  protected final String TEXT_79 = ");";
  protected final String TEXT_80 = NL + "\t\toptions_";
  protected final String TEXT_81 = ".groupLevel(";
  protected final String TEXT_82 = ");";
  protected final String TEXT_83 = NL + NL + "\t\torg.jcouchdb.document.DesignDocument designDoc_";
  protected final String TEXT_84 = "=null;" + NL + "\t\ttry {" + NL + "\t\t\tdesignDoc_";
  protected final String TEXT_85 = "= db_";
  protected final String TEXT_86 = ".getDesignDocument(";
  protected final String TEXT_87 = ");" + NL + "\t\t} catch (java.lang.Exception e_";
  protected final String TEXT_88 = ") {" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_89 = NL + "\t\tdesignDoc_";
  protected final String TEXT_90 = " = new org.jcouchdb.document.DesignDocument(";
  protected final String TEXT_91 = ");" + NL + "\t\tdb_";
  protected final String TEXT_92 = ".createDocument(designDoc_";
  protected final String TEXT_93 = ");";
  protected final String TEXT_94 = NL + "\t\tif(designDoc_";
  protected final String TEXT_95 = " != null){" + NL + "\t\t\tdb_";
  protected final String TEXT_96 = ".delete(designDoc_";
  protected final String TEXT_97 = ");" + NL + "\t\t}else{" + NL + "\t\t\tSystem.err.println(\"Design Document named \" + ";
  protected final String TEXT_98 = " + \"not exist\");" + NL + "\t\t}" + NL + "\t\tdesignDoc_";
  protected final String TEXT_99 = " = new org.jcouchdb.document.DesignDocument(";
  protected final String TEXT_100 = ");";
  protected final String TEXT_101 = NL + "\t\tif(designDoc_";
  protected final String TEXT_102 = " != null){" + NL + "\t\t\tdb_";
  protected final String TEXT_103 = ".delete(designDoc_";
  protected final String TEXT_104 = ");" + NL + "\t\t}" + NL + "\t\tdesignDoc_";
  protected final String TEXT_105 = " = new org.jcouchdb.document.DesignDocument(";
  protected final String TEXT_106 = ");";
  protected final String TEXT_107 = NL + "\t\tdesignDoc_";
  protected final String TEXT_108 = ".addView(";
  protected final String TEXT_109 = ",new org.jcouchdb.document.View(";
  protected final String TEXT_110 = ",";
  protected final String TEXT_111 = "));";
  protected final String TEXT_112 = NL + "\t\tSystem.err.println(\"You should create a new view for the design document.\");";
  protected final String TEXT_113 = NL + "\t\tdb_";
  protected final String TEXT_114 = ".createDocument(designDoc_";
  protected final String TEXT_115 = ");";
  protected final String TEXT_116 = NL + "\t\tif(designDoc_";
  protected final String TEXT_117 = " != null){" + NL + "\t\t\tdesignDoc_";
  protected final String TEXT_118 = ".addView(";
  protected final String TEXT_119 = ",new org.jcouchdb.document.View(";
  protected final String TEXT_120 = ",";
  protected final String TEXT_121 = "));" + NL + "\t\t\t" + NL + "\t\t}else{" + NL + "\t\t\tSystem.err.println(\"Design Document named \" + ";
  protected final String TEXT_122 = " + \"not exist\");" + NL + "\t\t}";
  protected final String TEXT_123 = NL + "\t\tif(designDoc_";
  protected final String TEXT_124 = " == null){" + NL + "\t\t\tdesignDoc_";
  protected final String TEXT_125 = " = new org.jcouchdb.document.DesignDocument(";
  protected final String TEXT_126 = ");";
  protected final String TEXT_127 = NL + "\t\t\tSystem.err.println(\"You should create a new view for the design document.\");";
  protected final String TEXT_128 = NL + "\t\t}else{";
  protected final String TEXT_129 = NL + "\t\t\tdesignDoc_";
  protected final String TEXT_130 = ".addView(";
  protected final String TEXT_131 = ",new org.jcouchdb.document.View(";
  protected final String TEXT_132 = ",";
  protected final String TEXT_133 = "));";
  protected final String TEXT_134 = NL + "\t\t}" + NL + "\t\tdb_";
  protected final String TEXT_135 = ".createOrUpdateDocument(designDoc_";
  protected final String TEXT_136 = ");";
  protected final String TEXT_137 = NL + "\t\torg.jcouchdb.document.ViewResult<Object> results_";
  protected final String TEXT_138 = " =\tdb_";
  protected final String TEXT_139 = ".queryView(" + NL + "\t\t\t\t\t";
  protected final String TEXT_140 = "+\"/\"+";
  protected final String TEXT_141 = ", Object.class, options_";
  protected final String TEXT_142 = ",org.svenson.JSONParser.defaultJSONParser());";
  protected final String TEXT_143 = NL + "\t\torg.jcouchdb.document.ViewResult<java.util.Map> results_";
  protected final String TEXT_144 = " = db_";
  protected final String TEXT_145 = ".listDocuments(options_";
  protected final String TEXT_146 = ", org.svenson.JSONParser.defaultJSONParser());";
  protected final String TEXT_147 = NL + "\t\tjava.util.Map<String,Object> values_";
  protected final String TEXT_148 = "=null;" + NL + "\t\tfor(org.jcouchdb.document.ValueRow valueRow_";
  protected final String TEXT_149 = ":results_";
  protected final String TEXT_150 = ".getRows()){" + NL + "\t\t\t nb_line_";
  protected final String TEXT_151 = " ++;";
  protected final String TEXT_152 = NL + "\t\t\t ";
  protected final String TEXT_153 = ".id=valueRow_";
  protected final String TEXT_154 = ".getId();";
  protected final String TEXT_155 = NL + "\t\t\tObject key_";
  protected final String TEXT_156 = "=valueRow_";
  protected final String TEXT_157 = ".getKey();" + NL + "\t\t\tif(key_";
  protected final String TEXT_158 = "!=null){" + NL + "\t\t\t\tif(key_";
  protected final String TEXT_159 = " instanceof String){" + NL + "\t\t\t \t\t";
  protected final String TEXT_160 = ".key=key_";
  protected final String TEXT_161 = ";" + NL + "\t\t\t \t}else{" + NL + "\t\t\t \t\t";
  protected final String TEXT_162 = ".key=org.svenson.JSON.defaultJSON().forValue(key_";
  protected final String TEXT_163 = ");" + NL + "\t\t\t \t}" + NL + "\t\t\t}";
  protected final String TEXT_164 = NL + "\t\t\tObject value_";
  protected final String TEXT_165 = "=valueRow_";
  protected final String TEXT_166 = ".getValue();" + NL + "\t\t\tif(value_";
  protected final String TEXT_167 = "!=null){" + NL + "\t\t\t\tif(value_";
  protected final String TEXT_168 = " instanceof String){" + NL + "\t\t\t\t\t";
  protected final String TEXT_169 = ".value =value_";
  protected final String TEXT_170 = ";" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\t";
  protected final String TEXT_171 = ".value = org.svenson.JSON.defaultJSON().forValue(value_";
  protected final String TEXT_172 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_173 = NL + "\t\t\t ";
  protected final String TEXT_174 = ".jsonDoc = new org.svenson.JSON().forValue(valueRow_";
  protected final String TEXT_175 = ".getProperty(\"doc\")";
  protected final String TEXT_176 = ");";
  protected final String TEXT_177 = NL + "\t";
  protected final String TEXT_178 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;

    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    cid = cid.replace("_In", "");
    String dbhost = ElementParameterParser.getValue(node, "__HOST__");
    String dbname = ElementParameterParser.getValue(node, "__DATABASE__");
    boolean useTriggerReplicate="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_TRIGGER_REPLICATE__"));
    String dbport  	= ElementParameterParser.getValue(node, "__PORT__");
    List<Map<String,String>> replicaTargetDB= (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__REPLICATE_TARGET_DB__");
    boolean useExistingConn = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
    String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
    
   
    boolean isQueryByView = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__QUERY_BY_VIEW__"));
    boolean include_docs = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__INCLUDE_DOCS__"));
    
    Object startKey = ElementParameterParser.getValue(node,"__STARTKEY__");
    Object endKey = ElementParameterParser.getValue(node,"__ENDKEY__");
    String startKeyDocId = ElementParameterParser.getValue(node,"__STARTKEY_DOCID__");
    String endKeyDocId = ElementParameterParser.getValue(node,"__ENDKEY_DOCID__");
    boolean descending = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__DESCENDING__"));
    boolean isAddOptions = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__ADD_OPTION__"));
    
    String docName = ElementParameterParser.getValue(node, "__DOC__");
    String viewName = ElementParameterParser.getValue(node, "__VIEW__");
    String doc_action = ElementParameterParser.getValue(node,"__DOC_ACTION__");
    String view_action = ElementParameterParser.getValue(node,"__VIEW_ACTION__");
    String map = ElementParameterParser.getValue(node,"__MAP__");
    map = map.replaceAll("\n"," ");
    map = map.replaceAll("\r"," ");
    boolean isReduce = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__ISREDUCE__"));
    String reduce = ElementParameterParser.getValue(node,"__REDUCE__");
    reduce = reduce.replaceAll("\n"," ");
    reduce = reduce.replaceAll("\r"," ");
    boolean isGroup = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__GROUP__"));
    String group_level = ElementParameterParser.getValue(node,"__GROUP_LEVEL__");
    
    String limit = ElementParameterParser.getValue(node, "__LIMIT__");
    
    List<IMetadataTable> metadatas = node.getMetadataList();
  	List<? extends IConnection> outputs = node.getOutgoingSortedConnections();
  	String firstConnName = "";
  	if (outputs.size() > 0){
		IConnection out = outputs.get(0);
		if(out!=null && out.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
			firstConnName = out.getName();
		}
    }

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
	if(useExistingConn){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_8);
    
	}else{

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_15);
    
		if(useTriggerReplicate){

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
			for(Map<String,String> targetDB:replicaTargetDB){
				String targetDBName=targetDB.get("TARGET_DB_NAME");
				boolean isCreateTargetDB = "true".equalsIgnoreCase(targetDB.get("CREATE_TARGET"));
				boolean isContinuous = "true".equalsIgnoreCase(targetDB.get("CONTINUOUS"));
				boolean isCancel = "true".equalsIgnoreCase(targetDB.get("CANCEL_REPLICATE"));

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(targetDBName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(isCreateTargetDB);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(isContinuous);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
				if(isContinuous && isCancel){

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(targetDBName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
				}
			}
		}
	}

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    
  	if(metadatas != null && metadatas.size() > 0){
      	IMetadataTable metadata = metadatas.get(0);
      	if(metadata != null){

    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
		if(startKey!=null && !"".equals(startKey)){

    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(startKey);
    stringBuffer.append(TEXT_54);
    
		}	
		if(endKey!=null && !"".equals(endKey)){

    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(endKey);
    stringBuffer.append(TEXT_57);
    
		}	
		if(startKeyDocId!=null && !"".equals(startKeyDocId)){

    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(startKeyDocId);
    stringBuffer.append(TEXT_60);
    
		}	
		if(endKeyDocId!=null && !"".equals(endKeyDocId)){

    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(endKeyDocId);
    stringBuffer.append(TEXT_63);
    
		}	
		if (limit != null && limit.length() > 0){

    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(limit);
    stringBuffer.append(TEXT_66);
    
		}
		if(!isReduce){

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(include_docs);
    stringBuffer.append(TEXT_69);
    
		}

    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(descending);
    stringBuffer.append(TEXT_72);
    
		if(isAddOptions){
			List<Map<String, String>> options = (List<Map<String,String>>)ElementParameterParser.getObjectValueXML(node, "__OPTIONS__");
			for(Map<String,String>option:options){
				if(option.get("PARAMETER")!=null && option.get("VALUE")!=null){

    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(option.get("PARAMETER"));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(option.get("VALUE"));
    stringBuffer.append(TEXT_76);
    
				}
			}
		}
      	if(isQueryByView){

    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(isReduce);
    stringBuffer.append(TEXT_79);
    
      		if(isReduce && isGroup){

    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(group_level);
    stringBuffer.append(TEXT_82);
    
      		}

    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(docName);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    
			//A1:create design document or view
			if(!"NONE".equals(doc_action) && !"CREATE_IF_NOT_EXISTS".equals(doc_action)){
				if("CREATE".equals(view_action)){
      				if("CREATE".equals(doc_action)){

    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(docName);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    
					}else if("DROP_CREATE".equals(doc_action)){

    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(docName);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(docName);
    stringBuffer.append(TEXT_100);
    
					}else if("DROP_IF_EXISTS_AND_CREATE".equals(doc_action)){

    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(docName);
    stringBuffer.append(TEXT_106);
    
					}

    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(viewName);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(map);
    if(isReduce){
    stringBuffer.append(TEXT_110);
    stringBuffer.append(reduce);
    }
    stringBuffer.append(TEXT_111);
    
				}else{

    stringBuffer.append(TEXT_112);
    
				}

    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    
			}else{
				if("NONE".equals(doc_action)){
					if("CREATE".equals(view_action)){

    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(viewName);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(map);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(reduce);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(docName);
    stringBuffer.append(TEXT_122);
    
					}
				}else{

    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(docName);
    stringBuffer.append(TEXT_126);
    
					if("NONE".equals(view_action)){

    stringBuffer.append(TEXT_127);
    
					}

    stringBuffer.append(TEXT_128);
    
					if("CREATE".equals(view_action)){

    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(viewName);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(map);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(reduce);
    stringBuffer.append(TEXT_133);
    
					}

    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    
				}
			}//A1:end
		}
      	if(isQueryByView){

    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(docName);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(viewName);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    
		}else{

    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    
		}

    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    
		  if(firstConnName!=null && firstConnName.length()>0){
			if(metadata.getColumn("id")!=null){

    stringBuffer.append(TEXT_152);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    
			}
			if(metadata.getColumn("key")!=null){

    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    
			}
			if(metadata.getColumn("value")!=null){

    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    
			}
			if(metadata.getColumn("jsonDoc")!=null){

    stringBuffer.append(TEXT_173);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    if(include_docs && !isReduce){
    stringBuffer.append(TEXT_175);
    }
    stringBuffer.append(TEXT_176);
    
			}
		  }
		}
	}

    stringBuffer.append(TEXT_177);
    stringBuffer.append(TEXT_178);
    return stringBuffer.toString();
  }
}
