package org.talend.designer.codegen.translators.bigdata.couchbase;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.Map;

public class TCouchbaseInBeginJava
{
  protected static String nl;
  public static synchronized TCouchbaseInBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCouchbaseInBeginJava result = new TCouchbaseInBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "com.couchbase.client.CouchbaseClient client_";
  protected final String TEXT_2 = " = null;";
  protected final String TEXT_3 = NL + "    client_";
  protected final String TEXT_4 = " = (com.couchbase.client.CouchbaseClient)globalMap.get(\"conn_";
  protected final String TEXT_5 = "\");";
  protected final String TEXT_6 = NL + "    java.util.ArrayList<java.net.URI> uris_";
  protected final String TEXT_7 = " = new java.util.ArrayList<java.net.URI>();";
  protected final String TEXT_8 = NL + "    uris_";
  protected final String TEXT_9 = ".add(java.net.URI.create(";
  protected final String TEXT_10 = "));";
  protected final String TEXT_11 = NL + "        client_";
  protected final String TEXT_12 = " = new com.couchbase.client.CouchbaseClient(uris_";
  protected final String TEXT_13 = ", ";
  protected final String TEXT_14 = ",";
  protected final String TEXT_15 = ",";
  protected final String TEXT_16 = " ";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + NL + "int nb_line_";
  protected final String TEXT_19 = " = 0;" + NL;
  protected final String TEXT_20 = NL + "                                            ";
  protected final String TEXT_21 = ".";
  protected final String TEXT_22 = " = jsonRow_";
  protected final String TEXT_23 = ".get";
  protected final String TEXT_24 = "();";
  protected final String TEXT_25 = NL + "                                            ";
  protected final String TEXT_26 = ".";
  protected final String TEXT_27 = " = ParserUtils.parseTo_Date(new Date(jsonRow_";
  protected final String TEXT_28 = ".get";
  protected final String TEXT_29 = "()),";
  protected final String TEXT_30 = ");";
  protected final String TEXT_31 = NL + "                                            ";
  protected final String TEXT_32 = ".";
  protected final String TEXT_33 = " = jsonRow_";
  protected final String TEXT_34 = ".get";
  protected final String TEXT_35 = "().getBytes();";
  protected final String TEXT_36 = NL + "                                            ";
  protected final String TEXT_37 = ".";
  protected final String TEXT_38 = " = ParserUtils.parseTo_";
  protected final String TEXT_39 = "(jsonRow_";
  protected final String TEXT_40 = ".get";
  protected final String TEXT_41 = "());";
  protected final String TEXT_42 = NL + "                                nb_line_";
  protected final String TEXT_43 = "++;";
  protected final String TEXT_44 = NL + "\t                                key_";
  protected final String TEXT_45 = " = ";
  protected final String TEXT_46 = ";" + NL + "\t                                if(key_";
  protected final String TEXT_47 = " instanceof String){" + NL + "\t                                    query_";
  protected final String TEXT_48 = ".";
  protected final String TEXT_49 = "(key_";
  protected final String TEXT_50 = ".toString());" + NL + "\t                                }else if(key_";
  protected final String TEXT_51 = " instanceof Object[]){" + NL + "\t                                    query_";
  protected final String TEXT_52 = ".";
  protected final String TEXT_53 = "(com.couchbase.client.protocol.views.ComplexKey.of((Object[])key_";
  protected final String TEXT_54 = "));" + NL + "\t                                }else{" + NL + "\t                                    throw new RuntimeException(\"The type of \"+key_";
  protected final String TEXT_55 = "+\" should be String or Object[]!\");" + NL + "\t                                }" + NL + "\t                                ";
  protected final String TEXT_56 = NL + "                                    ";
  protected final String TEXT_57 = ".";
  protected final String TEXT_58 = " = str_";
  protected final String TEXT_59 = ";";
  protected final String TEXT_60 = NL + "                                    ";
  protected final String TEXT_61 = ".";
  protected final String TEXT_62 = " = ParserUtils.parseTo_Date(new Date(str_";
  protected final String TEXT_63 = "),";
  protected final String TEXT_64 = ");";
  protected final String TEXT_65 = NL + "                                    ";
  protected final String TEXT_66 = ".";
  protected final String TEXT_67 = " = str_";
  protected final String TEXT_68 = ".getBytes();";
  protected final String TEXT_69 = NL + "                                    ";
  protected final String TEXT_70 = ".";
  protected final String TEXT_71 = " = ParserUtils.parseTo_";
  protected final String TEXT_72 = "(str_";
  protected final String TEXT_73 = ");";
  protected final String TEXT_74 = NL + "                                nb_line_";
  protected final String TEXT_75 = "++;";
  protected final String TEXT_76 = NL + "                                com.couchbase.client.protocol.views.DesignDocument dd_";
  protected final String TEXT_77 = " = client_";
  protected final String TEXT_78 = ".getDesignDocument(";
  protected final String TEXT_79 = ");";
  protected final String TEXT_80 = NL + "\t\t\t\t\t            com.couchbase.client.protocol.views.DesignDocument dd_";
  protected final String TEXT_81 = " = new com.couchbase.client.protocol.views.DesignDocument(";
  protected final String TEXT_82 = ");" + NL + "\t\t\t\t\t            ";
  protected final String TEXT_83 = NL + "                                client_";
  protected final String TEXT_84 = ".deleteDesignDoc(";
  protected final String TEXT_85 = ");" + NL + "                                com.couchbase.client.protocol.views.DesignDocument dd_";
  protected final String TEXT_86 = " = new com.couchbase.client.protocol.views.DesignDocument(";
  protected final String TEXT_87 = ");";
  protected final String TEXT_88 = NL + "                                com.couchbase.client.protocol.views.ViewDesign vd_";
  protected final String TEXT_89 = " = new com.couchbase.client.protocol.views.ViewDesign(";
  protected final String TEXT_90 = ",";
  protected final String TEXT_91 = ",";
  protected final String TEXT_92 = ");" + NL + "                                dd_";
  protected final String TEXT_93 = ".setView(vd_";
  protected final String TEXT_94 = ");";
  protected final String TEXT_95 = NL + "                                client_";
  protected final String TEXT_96 = ".createDesignDoc(dd_";
  protected final String TEXT_97 = ");";
  protected final String TEXT_98 = NL + "                            " + NL + "                            com.couchbase.client.protocol.views.View view_";
  protected final String TEXT_99 = " = client_";
  protected final String TEXT_100 = ".getView(";
  protected final String TEXT_101 = ", ";
  protected final String TEXT_102 = ");" + NL + "                            com.couchbase.client.protocol.views.Query query_";
  protected final String TEXT_103 = " = new com.couchbase.client.protocol.views.Query();" + NL + "                            Object key_";
  protected final String TEXT_104 = " = null;";
  protected final String TEXT_105 = NL + "                                query_";
  protected final String TEXT_106 = ".setStartkeyDocID(";
  protected final String TEXT_107 = ");";
  protected final String TEXT_108 = NL + "                                query_";
  protected final String TEXT_109 = ".setEndkeyDocID(";
  protected final String TEXT_110 = ");";
  protected final String TEXT_111 = NL + "                                query_";
  protected final String TEXT_112 = ".setKey(";
  protected final String TEXT_113 = ");";
  protected final String TEXT_114 = NL + "                                query_";
  protected final String TEXT_115 = ".setLimit(";
  protected final String TEXT_116 = ");";
  protected final String TEXT_117 = NL + "                                query_";
  protected final String TEXT_118 = ".setSkip(";
  protected final String TEXT_119 = ");";
  protected final String TEXT_120 = NL + "                                query_";
  protected final String TEXT_121 = ".setIncludeDocs(";
  protected final String TEXT_122 = "); ";
  protected final String TEXT_123 = NL + "                                query_";
  protected final String TEXT_124 = ".setReduce(";
  protected final String TEXT_125 = ");";
  protected final String TEXT_126 = NL + "                                    query_";
  protected final String TEXT_127 = ".setGroup(";
  protected final String TEXT_128 = ");";
  protected final String TEXT_129 = NL + "                                    query_";
  protected final String TEXT_130 = ".setGroupLevel(";
  protected final String TEXT_131 = ");";
  protected final String TEXT_132 = NL + "                            query_";
  protected final String TEXT_133 = ".setStale(com.couchbase.client.protocol.views.Stale.";
  protected final String TEXT_134 = ");" + NL + "                            query_";
  protected final String TEXT_135 = ".setDescending(";
  protected final String TEXT_136 = ");" + NL + "                            query_";
  protected final String TEXT_137 = ".setDebug(";
  protected final String TEXT_138 = ");" + NL + "                            query_";
  protected final String TEXT_139 = ".setInclusiveEnd(";
  protected final String TEXT_140 = "); " + NL + "                            com.couchbase.client.protocol.views.ViewResponse result_";
  protected final String TEXT_141 = " = client_";
  protected final String TEXT_142 = ".query(view_";
  protected final String TEXT_143 = ", query_";
  protected final String TEXT_144 = ");" + NL + "                            java.util.Iterator<com.couchbase.client.protocol.views.ViewRow> itr_";
  protected final String TEXT_145 = " = result_";
  protected final String TEXT_146 = ".iterator();" + NL + "                            while (itr_";
  protected final String TEXT_147 = ".hasNext()) {" + NL + "                                com.couchbase.client.protocol.views.ViewRow  jsonRow_";
  protected final String TEXT_148 = " = itr_";
  protected final String TEXT_149 = ".next();";
  protected final String TEXT_150 = "                            " + NL + "                            java.util.Map<String, Object> Map_";
  protected final String TEXT_151 = " = client_";
  protected final String TEXT_152 = ".getBulk(";
  protected final String TEXT_153 = ");" + NL + "                            for (java.util.Map.Entry<String, Object> m_";
  protected final String TEXT_154 = " : Map_";
  protected final String TEXT_155 = ".entrySet()) {" + NL + "                                Object obj_";
  protected final String TEXT_156 = " = m_";
  protected final String TEXT_157 = ".getValue();" + NL + "                                if(obj_";
  protected final String TEXT_158 = "!=null){" + NL + "                                    String str_";
  protected final String TEXT_159 = " = obj_";
  protected final String TEXT_160 = ".toString();";
  protected final String TEXT_161 = NL + "                                        ";
  protected final String TEXT_162 = ".Key = m_";
  protected final String TEXT_163 = ".getKey();";
  protected final String TEXT_164 = NL + "                                }";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;

INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();
boolean useExistingConn = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
if(useExistingConn){
    String connection = ElementParameterParser.getValue(node,"__CONNECTION__");

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_5);
    
}else{
    String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
    String username = ElementParameterParser.getValue(node, "__USER__");
    String dbpwd = ElementParameterParser.getValue(node, "__PASS__");
    List<Map<String, String>> URIList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__URIS__");

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
        for(java.util.Map<String,String> map:URIList){
    
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(map.get("URI"));
    stringBuffer.append(TEXT_10);
    
        }
    
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_14);
    if(username!=null && !"".equals(username)){
    stringBuffer.append(username);
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_17);
    
}

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
List<IMetadataTable> metadatas = node.getMetadataList();

if ((metadatas!=null) && (metadatas.size() > 0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata != null) {
    	
		List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		if (conns != null){
		
			if (conns.size()>0){
		
				IConnection conn =conns.get(0);
				String connName = conn.getName();
				metadata = conn.getMetadataTable();
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		
					List<IMetadataColumn> columns = metadata.getListColumns();
					int nbColumns = columns.size();
					if(nbColumns>0){
					    class Generate{
					        
					        public void generate(String connName,String cid,IMetadataTable metadata){
                                String[] columns = new String[]{"Id","Key","Value","jsonDoc"};
                                for(String columnName:columns){
                                    IMetadataColumn column = metadata.getColumn(columnName);
                                    if(column!=null){
                                        String talendType = column.getTalendType();
                                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(talendType, column.isNullable());
                                        JavaType javaType = JavaTypesManager.getJavaTypeFromId(talendType);
                                        String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                                        String method = columnName;
                                        if("jsonDoc".equals(columnName)){
                                            method = "Document";
                                        }
                                        if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_20);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_24);
    
                                        }else if(javaType == JavaTypesManager.DATE) {

    stringBuffer.append(TEXT_25);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(patternValue);
    stringBuffer.append(TEXT_30);
    
                                        }else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_31);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_35);
    
                                        }else{

    stringBuffer.append(TEXT_36);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_38);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_41);
    
                                        }
                                    }
                                }

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
					        }
					        public void generateParameter(String cid,Object key,String method){
					            if(key!=null && !"".equals(key.toString().trim()) && !"\"\"".equals(key.toString().trim())){
	                                
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    
	                            }
					        }
					        public void generateMap(String connName,String cid,IMetadataColumn column){
					            String columnName = column.getLabel();
                                String talendType = column.getTalendType();
                                String typeToGenerate = JavaTypesManager.getTypeToGenerate(talendType, column.isNullable());
                                JavaType javaType = JavaTypesManager.getJavaTypeFromId(talendType);
                                String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                                if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_56);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
                                }else if(javaType == JavaTypesManager.DATE) {

    stringBuffer.append(TEXT_60);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(patternValue);
    stringBuffer.append(TEXT_64);
    
                                }else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_65);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    
                                }else{

    stringBuffer.append(TEXT_69);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_71);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    
                                }

    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    
					        }
					    }
					    Generate generateCode = new Generate();
					    String fromview = ElementParameterParser.getValue(node,"__FROMVIEW__");
					    
					    if("true".equals(fromview)){
					        String docName = ElementParameterParser.getValue(node, "__DOC__");
					        String viewName = ElementParameterParser.getValue(node, "__VIEW__");
					        String include_docs = ElementParameterParser.getValue(node,"__INCLUDE_DOCS__");
					        String inclusiveend = ElementParameterParser.getValue(node,"__INCLUSIVEEND__");
					        String isreduce = ElementParameterParser.getValue(node,"__ISREDUCE__");
					        String stale = ElementParameterParser.getValue(node,"__STALE__");
					        String debug = ElementParameterParser.getValue(node,"__DEBUG__");
					        String descending = ElementParameterParser.getValue(node,"__DESCENDING__");
					        String useComplexkey = ElementParameterParser.getValue(node,"__USECOMPLEXKEY__");
					        Object complexkey = ElementParameterParser.getValue(node,"__COMPLEXKEY__");
					        String viewkey = ElementParameterParser.getValue(node, "__VIEWKEY__");
					        Object startkey = ElementParameterParser.getValue(node,"__STARTKEY__");
					        Object endkey = ElementParameterParser.getValue(node,"__ENDKEY__");
					        String startkey_docid = ElementParameterParser.getValue(node,"__STARTKEY_DOCID__");
					        String endkey_docid = ElementParameterParser.getValue(node,"__ENDKEY_DOCID__");
					        String group = ElementParameterParser.getValue(node,"__GROUP__");
					        String group_level = ElementParameterParser.getValue(node,"__GROUP_LEVEL__");
					        String doc_action = ElementParameterParser.getValue(node,"__DOC_ACTION__");
					        String view_action = ElementParameterParser.getValue(node,"__VIEW_ACTION__");
					        String map = ElementParameterParser.getValue(node,"__MAP__");
					        String reduce = ElementParameterParser.getValue(node,"__REDUCE__");
					        String limit = ElementParameterParser.getValue(node, "__LIMIT__");
					        String skip = ElementParameterParser.getValue(node, "__SKIP__");
					        if("NONE".equals(doc_action) && "CREATE".equals(view_action)){
                                
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(docName);
    stringBuffer.append(TEXT_79);
    
                            }else if("CREATE".equals(doc_action)){
					            
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(docName);
    stringBuffer.append(TEXT_82);
    
					        }else if("DROP_CREATE".equals(doc_action)){
                                
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(docName);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(docName);
    stringBuffer.append(TEXT_87);
    
                            }
					        if("CREATE".equals(view_action)){

    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(viewName);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(map);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(reduce);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    
					        }
					        if("CREATE".equals(view_action) || !"NONE".equals(doc_action)){

    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    
					        }

    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(docName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(viewName);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    
                            generateCode.generateParameter(cid,startkey,"setRangeStart");
                            generateCode.generateParameter(cid,endkey,"setRangeEnd");
                            if(startkey_docid!=null && !"".equals(startkey_docid.replaceAll("\\\"", ""))){
                                
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(startkey_docid);
    stringBuffer.append(TEXT_107);
    
                            }
                            if(endkey_docid!=null && !"".equals(endkey_docid.replaceAll("\\\"", ""))){
                                
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(endkey_docid);
    stringBuffer.append(TEXT_110);
    
                            }
                            if("true".equals(useComplexkey)){
                                generateCode.generateParameter(cid,complexkey,"setKeys");
                            } else if(viewkey!=null &&!"".equals(viewkey.replaceAll("\\\"", ""))){

    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(viewkey);
    stringBuffer.append(TEXT_113);
    
                            }
                            if(limit!=null &&!"".equals(limit)){

    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(limit);
    stringBuffer.append(TEXT_116);
    
                            }
                            if(skip!=null &&!"".equals(skip)){

    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(skip);
    stringBuffer.append(TEXT_119);
    
                            }
                            if("false".equals(isreduce)&&"true".equals(include_docs)){

    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(include_docs);
    stringBuffer.append(TEXT_122);
    
                            }else if("true".equals(isreduce)&&"false".equals(include_docs)){

    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(isreduce);
    stringBuffer.append(TEXT_125);
    
                                if("true".equals(group)){

    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(group);
    stringBuffer.append(TEXT_128);
    
                                }
                                if(group_level!=null && !"".equals(group_level.trim())){

    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(group_level);
    stringBuffer.append(TEXT_131);
    
                                }
                            }
                            // fromview true reduce false doc false --->id,key,value ----->real component
                            // fromview true reduce true doc false --->key value ----->real component
                            // fromview true reduce false doc true --->id key value doc
                            // fromview false isjson true --->id doc
                            // fromview false isjson false --->id value ----->real component

    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(stale);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(descending);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(debug);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(inclusiveend);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    
                                generateCode.generate(connName,cid,metadata);
                        }else{
                            String searchKey = ElementParameterParser.getValue(node, "__KEY__");

    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(searchKey);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    
                                    if(metadata.getColumn("Key")!=null){

    stringBuffer.append(TEXT_161);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    
                                    }
                                    IMetadataColumn column = metadata.getColumn("Value");
                                    if(column!=null){
                                        generateCode.generateMap(connName,cid,column);
                                    }

    stringBuffer.append(TEXT_164);
    
                        }
                    }		
				}
			}
		}			 
	}	    
}

    return stringBuffer.toString();
  }
}
