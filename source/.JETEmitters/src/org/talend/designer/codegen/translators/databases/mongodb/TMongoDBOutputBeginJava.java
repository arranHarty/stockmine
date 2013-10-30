package org.talend.designer.codegen.translators.databases.mongodb;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TMongoDBOutputBeginJava
{
  protected static String nl;
  public static synchronized TMongoDBOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMongoDBOutputBeginJava result = new TMongoDBOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\tint nb_line_";
  protected final String TEXT_3 = " = 0;";
  protected final String TEXT_4 = NL + "\t\t\tclass DBObjectUtil_";
  protected final String TEXT_5 = " {" + NL + "\t\t\t" + NL + "\t\t\t\tprivate com.mongodb.BasicDBObject object = null;" + NL + "\t\t\t\t//Put value to embedded document" + NL + "\t\t\t\t//If have no embedded document, put the value to root document" + NL + "\t\t\t\tpublic void put(String parentNode, String curentName, Object value) {" + NL + "\t\t\t\t\tif (parentNode == null || \"\".equals(parentNode)) {" + NL + "\t\t\t\t\t\tobject.put(curentName, value);" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tString objNames[]= parentNode.split(\"\\\\.\");" + NL + "\t\t\t\t\t\tcom.mongodb.BasicDBObject lastNode = getParentNode(parentNode, objNames.length-1);" + NL + "\t\t\t\t\t\tlastNode.put(curentName, value);" + NL + "\t\t\t\t\t\tcom.mongodb.BasicDBObject parenttNode = null;" + NL + "\t\t\t\t\t\tfor (int i = objNames.length - 1; i >=0; i--) {" + NL + "\t\t\t\t\t\t\tparenttNode=getParentNode(parentNode, i-1);" + NL + "\t\t\t\t\t\t\tparenttNode.put(objNames[i], lastNode);" + NL + "\t\t\t\t\t\t\tlastNode=(com.mongodb.BasicDBObject)parenttNode.clone();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tobject=lastNode;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\t//Get node(embedded document) by path configuration" + NL + "\t\t\t\tpublic com.mongodb.BasicDBObject getParentNode(String parentNode, int index) {" + NL + "\t\t\t\t\tcom.mongodb.BasicDBObject basicDBObject = object;" + NL + "\t\t\t\t\tif (parentNode == null || \"\".equals(parentNode)) {" + NL + "\t\t\t\t\t\treturn object;" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tString objNames[] = parentNode.split(\"\\\\.\");" + NL + "\t\t\t\t\t\tfor (int i = 0; i <= index; i++) {" + NL + "\t\t\t\t\t\t\tbasicDBObject = (com.mongodb.BasicDBObject) basicDBObject" + NL + "\t\t\t\t\t\t\t\t\t.get(objNames[i]);" + NL + "\t\t\t\t\t\t\tif (basicDBObject == null) {" + NL + "\t\t\t\t\t\t\t\tbasicDBObject = new com.mongodb.BasicDBObject();" + NL + "\t\t\t\t\t\t\t\treturn basicDBObject;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tif (i == index) {" + NL + "\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\treturn basicDBObject;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\tpublic void putkeyNode(String parentNode, String curentName, Object value){" + NL + "\t\t\t\t\tif (parentNode == null || \"\".equals(parentNode) || \".\".equals(parentNode)) {" + NL + "\t\t\t\t\t\tput(parentNode, curentName, value);" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tput(\"\", parentNode+\".\"+curentName, value);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t\tpublic com.mongodb.BasicDBObject getObject() {" + NL + "\t\t\t\t\treturn this.object;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\tpublic void setObject(com.mongodb.BasicDBObject object){" + NL + "\t\t\t\t\tthis.object=object;" + NL + "\t\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t}" + NL + "\t\t\tDBObjectUtil_";
  protected final String TEXT_6 = " updateObjectUtil_";
  protected final String TEXT_7 = "=new DBObjectUtil_";
  protected final String TEXT_8 = "();" + NL + "\t\t\tDBObjectUtil_";
  protected final String TEXT_9 = " queryObjectUtil_";
  protected final String TEXT_10 = "=new DBObjectUtil_";
  protected final String TEXT_11 = "();" + NL + "\t\t\tjava.util.Map<String, String> pathMap_";
  protected final String TEXT_12 = "=new java.util.HashMap<String, String>();" + NL + "\t\t\tcom.mongodb.Mongo mongo_";
  protected final String TEXT_13 = "=null;" + NL + "\t\t\tcom.mongodb.DB db_";
  protected final String TEXT_14 = " =null;";
  protected final String TEXT_15 = NL + "\t\t\t\tpathMap_";
  protected final String TEXT_16 = ".put(\"";
  protected final String TEXT_17 = "\",";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL + "\t\t\t\tmongo_";
  protected final String TEXT_20 = "=(com.mongodb.Mongo)globalMap.get(\"mongo_";
  protected final String TEXT_21 = "\");" + NL + "\t\t\t\tdb_";
  protected final String TEXT_22 = " = (com.mongodb.DB) globalMap.get(\"db_";
  protected final String TEXT_23 = "\");";
  protected final String TEXT_24 = NL + "\t\t\ttry{";
  protected final String TEXT_25 = NL + "\t\t\t\tList<com.mongodb.ServerAddress> addrs_";
  protected final String TEXT_26 = " = new java.util.ArrayList<com.mongodb.ServerAddress>();";
  protected final String TEXT_27 = NL + "\t\t\t\taddrs_";
  protected final String TEXT_28 = ".add(new com.mongodb.ServerAddress(";
  protected final String TEXT_29 = ",";
  protected final String TEXT_30 = "));";
  protected final String TEXT_31 = NL + "\t\t\t\tmongo_";
  protected final String TEXT_32 = " = new com.mongodb.Mongo(addrs_";
  protected final String TEXT_33 = ");";
  protected final String TEXT_34 = NL + "\t\t\t\tmongo_";
  protected final String TEXT_35 = " = new com.mongodb.Mongo(";
  protected final String TEXT_36 = ", ";
  protected final String TEXT_37 = ");";
  protected final String TEXT_38 = NL + "\t\t\t\tdb_";
  protected final String TEXT_39 = " = mongo_";
  protected final String TEXT_40 = ".getDB(";
  protected final String TEXT_41 = ");";
  protected final String TEXT_42 = NL + "    \t\t\tdb_";
  protected final String TEXT_43 = ".authenticate(";
  protected final String TEXT_44 = ", ";
  protected final String TEXT_45 = ".toCharArray());";
  protected final String TEXT_46 = NL + "\t\t\t\tif(db_";
  protected final String TEXT_47 = ".collectionExists(";
  protected final String TEXT_48 = ")){" + NL + "\t\t\t\t\tdb_";
  protected final String TEXT_49 = ".getCollection(";
  protected final String TEXT_50 = ").drop();" + NL + "\t\t\t\t}";
  protected final String TEXT_51 = NL + "\t\t\t\tcom.mongodb.DBCollection coll_";
  protected final String TEXT_52 = " = db_";
  protected final String TEXT_53 = ".getCollection(";
  protected final String TEXT_54 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
  	String cid = node.getUniqueName();

    String dbhost   = ElementParameterParser.getValue(node, "__HOST__");
    String dbname   = ElementParameterParser.getValue(node, "__DATABASE__");
    boolean authentication="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__REQUIRED_AUTHENTICATION__"));
    String dbuser   = ElementParameterParser.getValue(node, "__USERNAME__");
    String dbpass   = ElementParameterParser.getValue(node, "__PASSWORD__");
    String dbport  	= ElementParameterParser.getValue(node, "__PORT__");
    String collection=ElementParameterParser.getValue(node, "__COLLECTION__");
    boolean dropExistCollection="true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__DROP_COLLECTION_CREATE__"));
    boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
    
    List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValueXML(node, "__MAPPING__");
    boolean useReplicaSet="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_REPLICA_SET__"));

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    
    List<IMetadataTable> metadatas = node.getMetadataList();
  	if(metadatas != null && metadatas.size() > 0){
      	IMetadataTable metadata = metadatas.get(0);
      	if(metadata != null){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
			for (int i=0;i<mapping.size();i++) {
				String path = mapping.get(i).get("PARENT_NODE_PATH");
				if(path==null || "".equals(path)){
					path="\"\"";
				}
				String schemaColumn=mapping.get(i).get("SCHEMA_COLUMN");

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(schemaColumn);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_18);
    
			}
      		if (useExistingConnection){
      			String connection = ElementParameterParser.getValue(node, "__CONNECTION__");

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_23);
    
			}else{

    stringBuffer.append(TEXT_24);
    
 			List<Map<String,String>> replicaAddrs= (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__REPLICA_SET__");
   			if(useReplicaSet){

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
				for(Map<String,String> replicaAddr:replicaAddrs){

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(replicaAddr.get("REPLICA_HOST"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(replicaAddr.get("REPLICA_PORT"));
    stringBuffer.append(TEXT_30);
    
				}

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
			}else{

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_37);
    
			}

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_41);
    
				if (authentication){

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(dbpass);
    stringBuffer.append(TEXT_45);
    
				}
			}

    
			if(dropExistCollection){

    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(collection);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(collection);
    stringBuffer.append(TEXT_50);
    
			}

    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(collection);
    stringBuffer.append(TEXT_54);
    
    	}
    }

    return stringBuffer.toString();
  }
}
