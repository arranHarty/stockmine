package org.talend.designer.codegen.translators.databases.mongodb;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.utils.NodeUtil;

public class TMongoDBWriteConfBeginJava
{
  protected static String nl;
  public static synchronized TMongoDBWriteConfBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMongoDBWriteConfBeginJava result = new TMongoDBWriteConfBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t";
  protected final String TEXT_2 = NL + "\tint nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "\t";
  protected final String TEXT_4 = NL + "\t\t\tcom.mongodb.Mongo mongo_";
  protected final String TEXT_5 = "=null;" + NL + "\t\t\tcom.mongodb.DB db_";
  protected final String TEXT_6 = " =null;" + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\tmongo_";
  protected final String TEXT_8 = "=(com.mongodb.Mongo)globalMap.get(\"mongo_";
  protected final String TEXT_9 = "\");" + NL + "\t\t\t\tdb_";
  protected final String TEXT_10 = " = (com.mongodb.DB) globalMap.get(\"db_";
  protected final String TEXT_11 = "\");" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\ttry{" + NL + "\t\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\t\tList<com.mongodb.ServerAddress> addrs_";
  protected final String TEXT_14 = " = new java.util.ArrayList<com.mongodb.ServerAddress>();" + NL + "\t\t\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\t\t\taddrs_";
  protected final String TEXT_16 = ".add(new com.mongodb.ServerAddress(";
  protected final String TEXT_17 = ",";
  protected final String TEXT_18 = "));" + NL + "\t\t\t\t\t";
  protected final String TEXT_19 = NL + "\t\t\t\t\tmongo_";
  protected final String TEXT_20 = " = new com.mongodb.Mongo(addrs_";
  protected final String TEXT_21 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_22 = NL + "\t\t\t\t\tmongo_";
  protected final String TEXT_23 = " = new com.mongodb.Mongo(";
  protected final String TEXT_24 = ", ";
  protected final String TEXT_25 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\tdb_";
  protected final String TEXT_27 = " = mongo_";
  protected final String TEXT_28 = ".getDB(";
  protected final String TEXT_29 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_30 = NL + "    \t\t\t\tdb_";
  protected final String TEXT_31 = ".authenticate(";
  protected final String TEXT_32 = ", ";
  protected final String TEXT_33 = ".toCharArray());" + NL + "\t\t\t\t";
  protected final String TEXT_34 = NL + "\t\t\t\tif(db_";
  protected final String TEXT_35 = ".collectionExists(";
  protected final String TEXT_36 = ")){" + NL + "\t\t\t\t\tdb_";
  protected final String TEXT_37 = ".getCollection(";
  protected final String TEXT_38 = ").drop();" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\tcom.mongodb.DBCollection coll_";
  protected final String TEXT_40 = " = db_";
  protected final String TEXT_41 = ".getCollection(";
  protected final String TEXT_42 = ");" + NL + "\t\t\t\t" + NL + "\t\t\tnet.sf.json.xml.XMLSerializer xmlSerializer_";
  protected final String TEXT_43 = " = new net.sf.json.xml.XMLSerializer(); " + NL + "\t\t    xmlSerializer_";
  protected final String TEXT_44 = ".clearNamespaces();" + NL + "\t\t    xmlSerializer_";
  protected final String TEXT_45 = ".setSkipNamespaces(true);" + NL + "\t\t    xmlSerializer_";
  protected final String TEXT_46 = ".setForceTopLevelObject(";
  protected final String TEXT_47 = ");" + NL + "\t\t    ";
  protected final String TEXT_48 = NL + "\t\t\t\tjava.util.Queue<String> queue_";
  protected final String TEXT_49 = " = new java.util.concurrent.ConcurrentLinkedQueue<String>();" + NL + "\t\t\t\t" + NL + "\t\t\t\tclass ThreadXMLField_";
  protected final String TEXT_50 = " extends Thread {" + NL + "\t\t\t\t\tjava.util.Queue<String> queue;" + NL + "\t\t\t\t\tjava.util.List<java.util.Map<String,String>> flows;" + NL + "\t\t\t\t\tjava.lang.Exception lastException;" + NL + "\t\t\t\t\tString currentComponent;" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tThreadXMLField_";
  protected final String TEXT_51 = "(java.util.Queue q) {" + NL + "\t\t\t\t\t\tthis.queue = q;" + NL + "\t\t\t\t\t\tglobalMap.put(\"queue_";
  protected final String TEXT_52 = "\", queue);" + NL + "\t\t\t\t\t\tlastException = null;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tThreadXMLField_";
  protected final String TEXT_53 = "(java.util.Queue q, java.util.List<java.util.Map<String,String>> l) {" + NL + "\t\t\t\t\t\tthis.queue = q;" + NL + "\t\t\t\t\t\tthis.flows = l;" + NL + "\t\t\t\t\t\tlastException = null;" + NL + "\t\t\t\t\t\tglobalMap.put(\"queue_";
  protected final String TEXT_54 = "\", queue);" + NL + "\t\t\t\t\t\tglobalMap.put(\"flows_";
  protected final String TEXT_55 = "\", flows);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tpublic java.lang.Exception getLastException() {" + NL + "\t\t\t\t\t\treturn this.lastException;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tpublic String getCurrentComponent() {" + NL + "\t\t\t\t\t\treturn this.currentComponent;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\t\t@Override" + NL + "\t\t\t\t\tpublic void run() {" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_56 = "Process(globalMap);" + NL + "\t\t\t\t\t\t} catch (TalendException te) {" + NL + "\t\t\t\t\t\t\tthis.lastException = te.getException();" + NL + "\t\t\t\t\t\t\tthis.currentComponent = te.getCurrentComponent();" + NL + "\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_57 = "_FINISH\", \"true\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\tThreadXMLField_";
  protected final String TEXT_58 = " txf_";
  protected final String TEXT_59 = " = new ThreadXMLField_";
  protected final String TEXT_60 = "(queue_";
  protected final String TEXT_61 = ");" + NL + "\t\t\t\ttxf_";
  protected final String TEXT_62 = ".start();" + NL + "\t\t\t";
  protected final String TEXT_63 = NL + "\t\t\t\tjava.util.Queue<String> queue_";
  protected final String TEXT_64 = " = (java.util.Queue<String>) globalMap.get(\"queue_";
  protected final String TEXT_65 = "\");" + NL + "\t\t\t";
  protected final String TEXT_66 = NL + "\t\t\t\t" + NL + "\t\t\tString str_";
  protected final String TEXT_67 = " = null;" + NL + "\t\t\t" + NL + "\t\t\twhile(true) {" + NL + "\t\t\t\tif (!queue_";
  protected final String TEXT_68 = ".isEmpty()) {" + NL + "\t\t\t\t\tstr_";
  protected final String TEXT_69 = " = queue_";
  protected final String TEXT_70 = ".poll();" + NL + "\t\t\t\t\t//Convert XML to JSON" + NL + "\t\t\t        net.sf.json.JSON json_";
  protected final String TEXT_71 = " = xmlSerializer_";
  protected final String TEXT_72 = ".read(str_";
  protected final String TEXT_73 = ");" + NL + "\t\t\t\t\tnb_line_";
  protected final String TEXT_74 = "++;" + NL + "\t\t";

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
    boolean useReplicaSet="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_REPLICA_SET__"));
    boolean removeRoot="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__REMOVE_ROOT__"));
	
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
			if(dropExistCollection){
			
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(collection);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(collection);
    stringBuffer.append(TEXT_38);
    
			}
			
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(collection);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append((removeRoot?false:true));
    stringBuffer.append(TEXT_47);
    
		    INode sourceNode = node.getIncomingConnections(EConnectionType.ON_COMPONENT_OK).get(0).getSource();
			String virtualSourceCid = sourceNode.getUniqueName();
			INode startNode = NodeUtil.getSpecificStartNode(sourceNode);
			String startNodeCid = null; 
			if(startNode != null){
				startNodeCid = startNode.getUniqueName();
			} 
			IConnection nextMergeConn = NodeUtil.getNextMergeConnection(node);
			if(nextMergeConn != null && nextMergeConn.getInputId()>1 && startNodeCid != null){
			
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(virtualSourceCid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(virtualSourceCid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(virtualSourceCid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(startNodeCid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    
			}else{
			
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    
			}
		    
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
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
    }
	
    return stringBuffer.toString();
  }
}
