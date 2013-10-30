package org.talend.designer.codegen.translators.databases.mongodb;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.Map;

public class TMongoDBInputBeginJava
{
  protected static String nl;
  public static synchronized TMongoDBInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMongoDBInputBeginJava result = new TMongoDBInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\tint nb_line_";
  protected final String TEXT_3 = " = 0;";
  protected final String TEXT_4 = NL + "\t\t\tcom.mongodb.Mongo mongo_";
  protected final String TEXT_5 = "=null;" + NL + "\t\t\tcom.mongodb.DB db_";
  protected final String TEXT_6 = "=null;";
  protected final String TEXT_7 = NL + "\t\t\t\tmongo_";
  protected final String TEXT_8 = "=(com.mongodb.Mongo)globalMap.get(\"mongo_";
  protected final String TEXT_9 = "\");" + NL + "\t\t\t\tdb_";
  protected final String TEXT_10 = " = (com.mongodb.DB) globalMap.get(\"db_";
  protected final String TEXT_11 = "\");";
  protected final String TEXT_12 = NL + "\t\t\ttry{";
  protected final String TEXT_13 = NL + "\t\t\t\tList<com.mongodb.ServerAddress> addrs_";
  protected final String TEXT_14 = " = new java.util.ArrayList<com.mongodb.ServerAddress>();";
  protected final String TEXT_15 = NL + "\t\t\t\taddrs_";
  protected final String TEXT_16 = ".add(new com.mongodb.ServerAddress(";
  protected final String TEXT_17 = ",";
  protected final String TEXT_18 = "));";
  protected final String TEXT_19 = NL + "\t\t\t\tmongo_";
  protected final String TEXT_20 = " = new com.mongodb.Mongo(addrs_";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = NL + "\t\t\t\tmongo_";
  protected final String TEXT_23 = " = new com.mongodb.Mongo(";
  protected final String TEXT_24 = ", ";
  protected final String TEXT_25 = ");";
  protected final String TEXT_26 = NL + "\t\t\t\tdb_";
  protected final String TEXT_27 = " = mongo_";
  protected final String TEXT_28 = ".getDB(";
  protected final String TEXT_29 = ");";
  protected final String TEXT_30 = NL + "    \t\t\tdb_";
  protected final String TEXT_31 = ".authenticate(";
  protected final String TEXT_32 = ", ";
  protected final String TEXT_33 = ".toCharArray());";
  protected final String TEXT_34 = NL + NL + "\t\t\t\tcom.mongodb.DBCollection coll_";
  protected final String TEXT_35 = " = db_";
  protected final String TEXT_36 = ".getCollection(";
  protected final String TEXT_37 = ");" + NL + "\t    \t\tcom.mongodb.DBObject myQuery_";
  protected final String TEXT_38 = " = (com.mongodb.DBObject) com.mongodb.util.JSON.parse(";
  protected final String TEXT_39 = ");" + NL + "" + NL + "\t    \t\tcom.mongodb.DBObject fields_";
  protected final String TEXT_40 = " = new com.mongodb.BasicDBObject();" + NL + "\t  \t\t\tcom.mongodb.DBCursor cursor_";
  protected final String TEXT_41 = " = coll_";
  protected final String TEXT_42 = ".find(myQuery_";
  protected final String TEXT_43 = ", fields_";
  protected final String TEXT_44 = ");" + NL + "\t\t\t\t" + NL + "\t\t\t\tclass DBObjectInputUtil_";
  protected final String TEXT_45 = "{" + NL + "\t\t\t\t\t// Get the node value in embedded document, " + NL + "\t\t\t\t\t//If have no embedded document get root document node." + NL + "\t\t\t\t\tpublic Object getValue(String parentNode,String currentName,com.mongodb.DBObject dbObject){" + NL + "\t\t\t\t\t\tObject value=null;" + NL + "\t\t\t\t\t\tif(dbObject==null){" + NL + "\t\t\t\t\t\t\treturn null;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif (parentNode == null || \"\".equals(parentNode)) {" + NL + "\t\t\t\t\t\t\tif(dbObject.get(currentName)!=null){" + NL + "\t\t\t\t\t\t\t\tvalue=dbObject.get(currentName);" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tString objNames[] = objNames = parentNode.split(\"\\\\.\");" + NL + "\t\t\t\t\t\t\tcom.mongodb.DBObject currentObj=dbObject;" + NL + "\t\t\t\t\t\t\tfor(int i=0;i<objNames.length;i++){" + NL + "\t\t\t\t\t\t\t\tcurrentObj=(com.mongodb.DBObject)currentObj.get(objNames[i]);" + NL + "\t\t\t\t\t\t\t\tif(currentObj==null){" + NL + "\t\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tif(currentObj!=null){" + NL + "\t\t\t\t\t\t\t\tvalue=currentObj.get(currentName);" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\treturn value;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\tDBObjectInputUtil_";
  protected final String TEXT_46 = " dbObjectInputUtil_";
  protected final String TEXT_47 = "=new DBObjectInputUtil_";
  protected final String TEXT_48 = "();" + NL + "\t\t\t\tjava.util.Map<String, String> pathMap_";
  protected final String TEXT_49 = "=new java.util.HashMap<String, String>();";
  protected final String TEXT_50 = NL + "\t\t\t\tpathMap_";
  protected final String TEXT_51 = ".put(\"";
  protected final String TEXT_52 = "\",";
  protected final String TEXT_53 = ");";
  protected final String TEXT_54 = NL + "\t  \t\t\tcursor_";
  protected final String TEXT_55 = " = cursor_";
  protected final String TEXT_56 = ".limit(";
  protected final String TEXT_57 = ");";
  protected final String TEXT_58 = NL + "\t\t  \t\tcom.mongodb.DBObject orderBy_";
  protected final String TEXT_59 = " = new com.mongodb.BasicDBObject();";
  protected final String TEXT_60 = NL + "\t\t  \t\torderBy_";
  protected final String TEXT_61 = ".put(";
  protected final String TEXT_62 = ",";
  protected final String TEXT_63 = ");";
  protected final String TEXT_64 = NL + "\t\t\t\tcursor_";
  protected final String TEXT_65 = ".sort(orderBy_";
  protected final String TEXT_66 = ");";
  protected final String TEXT_67 = NL + "\t\t\t\twhile (cursor_";
  protected final String TEXT_68 = ".hasNext()){";
  protected final String TEXT_69 = NL + "\t\t\t\tcom.mongodb.DBObject o_";
  protected final String TEXT_70 = " = cursor_";
  protected final String TEXT_71 = ".next();" + NL + "\t\t\t\tnb_line_";
  protected final String TEXT_72 = "++;";
  protected final String TEXT_73 = NL + "\t\t\t\tObject valueObj_";
  protected final String TEXT_74 = "=null;";
  protected final String TEXT_75 = NL + "\t\t\t\t\tvalueObj_";
  protected final String TEXT_76 = "=dbObjectInputUtil_";
  protected final String TEXT_77 = ".getValue(pathMap_";
  protected final String TEXT_78 = ".get(\"";
  protected final String TEXT_79 = "\"),\"";
  protected final String TEXT_80 = "\",o_";
  protected final String TEXT_81 = ");";
  protected final String TEXT_82 = NL + "\t\t\t\t";
  protected final String TEXT_83 = ".";
  protected final String TEXT_84 = " = valueObj_";
  protected final String TEXT_85 = ";";
  protected final String TEXT_86 = NL + "\t\t\t\tif(valueObj_";
  protected final String TEXT_87 = "!=null && valueObj_";
  protected final String TEXT_88 = ".toString().length() > 0) {";
  protected final String TEXT_89 = NL + "\t\t\t\t\t";
  protected final String TEXT_90 = ".";
  protected final String TEXT_91 = " = ParserUtils.parseTo_Date((java.util.Date)valueObj_";
  protected final String TEXT_92 = ", ";
  protected final String TEXT_93 = ");";
  protected final String TEXT_94 = NL + "\t\t\t\t\t";
  protected final String TEXT_95 = ".";
  protected final String TEXT_96 = " = java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap((byte[])valueObj_";
  protected final String TEXT_97 = ")).toString().getBytes(utf8Charset);";
  protected final String TEXT_98 = NL + "\t\t\t\t\t";
  protected final String TEXT_99 = ".";
  protected final String TEXT_100 = " = valueObj_";
  protected final String TEXT_101 = ".toString();";
  protected final String TEXT_102 = NL + "\t\t\t\t\t";
  protected final String TEXT_103 = ".";
  protected final String TEXT_104 = " = ParserUtils.parseTo_";
  protected final String TEXT_105 = "(valueObj_";
  protected final String TEXT_106 = ".toString());";
  protected final String TEXT_107 = NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\t";
  protected final String TEXT_108 = ".";
  protected final String TEXT_109 = " = ";
  protected final String TEXT_110 = ";" + NL + "\t\t\t\t}";
  protected final String TEXT_111 = NL;
  protected final String TEXT_112 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
  	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
  	INode node = (INode)codeGenArgument.getArgument();
  	String cid = node.getUniqueName();

    String dbhost   = ElementParameterParser.getValue(node, "__HOST__");
    String dbname   = ElementParameterParser.getValue(node, "__DATABASE__");
    String dbuser   = ElementParameterParser.getValue(node, "__USERNAME__");
    boolean authentication="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__REQUIRED_AUTHENTICATION__"));
    String dbpass   = ElementParameterParser.getValue(node, "__PASSWORD__");
    String dbport  	= ElementParameterParser.getValue(node, "__PORT__");
    boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
    String collection = ElementParameterParser.getValue(node,"__COLLECTION__");
    String query = ElementParameterParser.getValue(node,"__QUERY__");
    query = query.replaceAll("\n","");
    query = query.replaceAll("\r","");
  	String limit = ElementParameterParser.getValue(node,"__LIMIT__");
  	
  	List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValueXML(node, "__MAPPING__");
  	List<Map<String, String>> sorts = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SORT__");
  	boolean useReplicaSet="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_REPLICA_SET__"));
  	
  	List<IMetadataTable> metadatas = node.getMetadataList();
  	List<IMetadataColumn> columnList = null;
  	List<? extends IConnection> outputs = node.getOutgoingSortedConnections();
  	String firstConnName = "";
  	if (outputs.size() > 0){
		IConnection out = outputs.get(0);
		if(out!=null && out.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
			firstConnName = out.getName();
		}
    }

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    
  	if(metadatas != null && metadatas.size() > 0){
      	IMetadataTable metadata = metadatas.get(0);
      	if(metadata != null){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
      		if (useExistingConnection){
      			String connection = ElementParameterParser.getValue(node, "__CONNECTION__");

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_11);
    
			}else{

    stringBuffer.append(TEXT_12);
    
 			List<Map<String,String>> replicaAddrs= (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__REPLICA_SET__");
   			if(useReplicaSet){

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
				for(Map<String,String> replicaAddr:replicaAddrs){

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(replicaAddr.get("REPLICA_HOST"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(replicaAddr.get("REPLICA_PORT"));
    stringBuffer.append(TEXT_18);
    
				}

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
			}else{

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_25);
    
			}

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_29);
    
				if (authentication){

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(dbpass);
    stringBuffer.append(TEXT_33);
    
				}

    
			}

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(collection);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(query);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
			for (int i=0;i<mapping.size();i++) {
				String path = mapping.get(i).get("PARENT_NODE_PATH");
				if(path==null || "".equals(path)){
					path="\"\"";
				}
				String schemaColumn=mapping.get(i).get("SCHEMA_COLUMN");

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(schemaColumn);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_53);
    
			}
			
			if (limit != null && !"\"\"".equals(limit) && limit.length() > 0){

    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(limit);
    stringBuffer.append(TEXT_57);
    
			}
			if(sorts.size()>0){

    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
				for(Map<String, String> line:sorts){
					int order=-1;
					if(("asc").equals(line.get("ORDER"))){
        				order=1;
        			}

    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(line.get("COLNAME"));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(order);
    stringBuffer.append(TEXT_63);
    
				}

    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    
			}

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    
          	columnList = metadata.getListColumns();
          	int sizeColumns = columnList.size();

    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    
			if(firstConnName.length()>0){

    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    
				for (int i = 0; i < sizeColumns; i++) {
					IMetadataColumn column = columnList.get(i);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();

    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(column.getOriginalDbColumnName() );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    
          			if(javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_82);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    
          			}else{

    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    
						if(javaType == JavaTypesManager.DATE) {

    stringBuffer.append(TEXT_89);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_93);
    
						}else if(javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(TEXT_94);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    
						} else if(javaType == JavaTypesManager.STRING){

    stringBuffer.append(TEXT_98);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    
						} else {

    stringBuffer.append(TEXT_102);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    
						}

    stringBuffer.append(TEXT_107);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_110);
    
          			}
				}
			}
      	}
  	}

    stringBuffer.append(TEXT_111);
    stringBuffer.append(TEXT_112);
    return stringBuffer.toString();
  }
}
