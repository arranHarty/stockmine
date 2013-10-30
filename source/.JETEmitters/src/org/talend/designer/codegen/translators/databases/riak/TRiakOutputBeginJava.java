package org.talend.designer.codegen.translators.databases.riak;

import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.Map;

public class TRiakOutputBeginJava
{
  protected static String nl;
  public static synchronized TRiakOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRiakOutputBeginJava result = new TRiakOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tcom.basho.riak.client.IRiakClient client_";
  protected final String TEXT_3 = " = null;" + NL + "\tint upsert_nb_line_";
  protected final String TEXT_4 = " = 0;" + NL + "\tint delete_nb_line_";
  protected final String TEXT_5 = " = 0;" + NL + "\ttry{";
  protected final String TEXT_6 = NL + "\t\tclient_";
  protected final String TEXT_7 = " = (com.basho.riak.client.IRiakClient)globalMap.get(\"client_";
  protected final String TEXT_8 = "\");";
  protected final String TEXT_9 = NL + "\t\tcom.basho.riak.client.raw.http.HTTPClusterConfig  clusterConfig_";
  protected final String TEXT_10 = " = new com.basho.riak.client.raw.http.HTTPClusterConfig(com.basho.riak.client.raw.config.ClusterConfig.UNLIMITED_CONNECTIONS);";
  protected final String TEXT_11 = NL + "\t\tcom.basho.riak.client.raw.http.HTTPClientConfig clientConfig_";
  protected final String TEXT_12 = "_";
  protected final String TEXT_13 = " = new com.basho.riak.client.raw.http.HTTPClientConfig.Builder()";
  protected final String TEXT_14 = NL + "\t\t\t.withPort(";
  protected final String TEXT_15 = ")";
  protected final String TEXT_16 = NL + "\t\t\t.withRiakPath(";
  protected final String TEXT_17 = ")";
  protected final String TEXT_18 = NL + "\t\t\t.build();" + NL + "\t\t\tclusterConfig_";
  protected final String TEXT_19 = ".addHosts(clientConfig_";
  protected final String TEXT_20 = "_";
  protected final String TEXT_21 = ", ";
  protected final String TEXT_22 = ");";
  protected final String TEXT_23 = NL + "\t\tclient_";
  protected final String TEXT_24 = " =com.basho.riak.client.RiakFactory.newClient(clusterConfig_";
  protected final String TEXT_25 = ");" + NL + "\t\tclient_";
  protected final String TEXT_26 = ".ping();";
  protected final String TEXT_27 = NL + "\t\tcom.basho.riak.client.bucket.Bucket bucket_";
  protected final String TEXT_28 = " = client_";
  protected final String TEXT_29 = ".fetchBucket(";
  protected final String TEXT_30 = ").execute();" + NL + "\t\tjava.util.Map<String,Object> object_";
  protected final String TEXT_31 = " = null;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
	
    String cid = node.getUniqueName();
    List<Map<String, String>> riakNodes = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__NODES__");
    
    boolean useExistingConn = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
    String bucket = ElementParameterParser.getValue(node,"__BUCKET__");
    
  	List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
    IConnection inConn = null;
	IMetadataTable metadata = null;
	if(inConns!=null && inConns.size()> 0) {
		inConn = inConns.get(0);
		metadata = inConn.getMetadataTable();
	}
  	List< ? extends IConnection> conns = node.getIncomingConnections();
	for (IConnection conn : conns) {
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	      	if(metadata != null){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			if(useExistingConn){
				String connection = ElementParameterParser.getValue(node, "__CONNECTION__");

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_8);
    
			}else{
		    	if(riakNodes.size()>0){

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
			    	for(int i=0;i<riakNodes.size();i++){
			    		Map<String, String> riakNode = riakNodes.get(i);
						String host =riakNode.get("HOST");
						String port =riakNode.get("PORT");
						String riakPath =riakNode.get("RIAK_PATH");
						if(host!=null && host.trim().length()>0 && !"\"\"".equals(host)){

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_13);
    
							if(port!=null && port.trim().length()>0){

    stringBuffer.append(TEXT_14);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_15);
    
							}
							if(riakPath!=null && riakPath.trim().length()>0 && !"\"\"".equals(riakPath)){

    stringBuffer.append(TEXT_16);
    stringBuffer.append(riakPath);
    stringBuffer.append(TEXT_17);
    
							}

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_22);
    
				}
			}

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
		}
    }

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(bucket);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
			}
    	}
    }

    return stringBuffer.toString();
  }
}
