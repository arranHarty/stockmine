package org.talend.designer.codegen.translators.databases.riak;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TRiakBucketListBeginJava
{
  protected static String nl;
  public static synchronized TRiakBucketListBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRiakBucketListBeginJava result = new TRiakBucketListBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tcom.basho.riak.client.IRiakClient client_";
  protected final String TEXT_3 = " = null;" + NL + "\tint nb_line_";
  protected final String TEXT_4 = " = 0;";
  protected final String TEXT_5 = NL + "\tclient_";
  protected final String TEXT_6 = " = (com.basho.riak.client.IRiakClient)globalMap.get(\"client_";
  protected final String TEXT_7 = "\");";
  protected final String TEXT_8 = NL + "\ttry{" + NL + "\t\tcom.basho.riak.client.raw.http.HTTPClusterConfig  clusterConfig_";
  protected final String TEXT_9 = " = new com.basho.riak.client.raw.http.HTTPClusterConfig(com.basho.riak.client.raw.config.ClusterConfig.UNLIMITED_CONNECTIONS);";
  protected final String TEXT_10 = NL + "\t\tcom.basho.riak.client.raw.http.HTTPClientConfig clientConfig_";
  protected final String TEXT_11 = "_";
  protected final String TEXT_12 = " = new com.basho.riak.client.raw.http.HTTPClientConfig.Builder()";
  protected final String TEXT_13 = NL + "\t\t\t.withPort(";
  protected final String TEXT_14 = ")";
  protected final String TEXT_15 = NL + "\t\t\t.withRiakPath(";
  protected final String TEXT_16 = ")";
  protected final String TEXT_17 = NL + "\t\t\t.build();" + NL + "\t\t\tclusterConfig_";
  protected final String TEXT_18 = ".addHosts(clientConfig_";
  protected final String TEXT_19 = "_";
  protected final String TEXT_20 = ", ";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = NL + "\t\tclient_";
  protected final String TEXT_23 = " =com.basho.riak.client.RiakFactory.newClient(clusterConfig_";
  protected final String TEXT_24 = ");" + NL + "\t\tclient_";
  protected final String TEXT_25 = ".ping();";
  protected final String TEXT_26 = NL + "\t\tcom.basho.riak.client.query.StreamingOperation<String> bucketsStreamOpts_";
  protected final String TEXT_27 = " = client_";
  protected final String TEXT_28 = ".listBucketsStreaming();" + NL + "\t\tjava.util.List<String> buckets_";
  protected final String TEXT_29 = " = bucketsStreamOpts_";
  protected final String TEXT_30 = ".getAll();" + NL + "\t\tfor(String bucketName_";
  protected final String TEXT_31 = ":buckets_";
  protected final String TEXT_32 = "){" + NL + "\t\t\tnb_line_";
  protected final String TEXT_33 = "++;" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_34 = "_CURRENT_BUCKET_NAME\", bucketName_";
  protected final String TEXT_35 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
	
    String cid = node.getUniqueName();
    List<Map<String, String>> riakNodes = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__NODES__");
    
    boolean useExistingConn = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
	if(useExistingConn){
		String connection = ElementParameterParser.getValue(node, "__CONNECTION__");

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_7);
    
	}else{

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
    	if(riakNodes.size()>0){
	    	for(int i=0;i<riakNodes.size();i++){
	    		Map<String, String> riakNode = riakNodes.get(i);
				String host =riakNode.get("HOST");
				String port =riakNode.get("PORT");
				String riakPath =riakNode.get("RIAK_PATH");
				if(host!=null && host.trim().length()>0 && !"\"\"".equals(host)){

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_12);
    
					if(port!=null && port.trim().length()>0){

    stringBuffer.append(TEXT_13);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_14);
    
					}
					if(riakPath!=null && riakPath.trim().length()>0 && !"\"\"".equals(riakPath)){

    stringBuffer.append(TEXT_15);
    stringBuffer.append(riakPath);
    stringBuffer.append(TEXT_16);
    
					}

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_21);
    
				}
			}

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
		}
    }

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    return stringBuffer.toString();
  }
}
