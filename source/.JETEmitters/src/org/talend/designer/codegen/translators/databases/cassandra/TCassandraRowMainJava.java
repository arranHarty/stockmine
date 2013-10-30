package org.talend.designer.codegen.translators.databases.cassandra;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TCassandraRowMainJava
{
  protected static String nl;
  public static synchronized TCassandraRowMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCassandraRowMainJava result = new TCassandraRowMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\tme.prettyprint.hector.api.Cluster cluster_";
  protected final String TEXT_2 = " =null;" + NL + "\t\tme.prettyprint.hector.api.Keyspace keyspace_";
  protected final String TEXT_3 = " =null;" + NL + "\t\ttry{";
  protected final String TEXT_4 = NL + "\t\tcluster_";
  protected final String TEXT_5 = "=(me.prettyprint.hector.api.Cluster)globalMap.get(\"cluster_";
  protected final String TEXT_6 = "\");";
  protected final String TEXT_7 = NL + "\t\t\tString hostIps_";
  protected final String TEXT_8 = "=";
  protected final String TEXT_9 = "+\":\"+";
  protected final String TEXT_10 = ";" + NL + "\t\t\tme.prettyprint.cassandra.service.CassandraHostConfigurator hosts_";
  protected final String TEXT_11 = " = new me.prettyprint.cassandra.service.CassandraHostConfigurator(hostIps_";
  protected final String TEXT_12 = ");" + NL + "\t\t\tjava.util.Map<String, String> credentials_";
  protected final String TEXT_13 = " = new java.util.HashMap<String, String>();";
  protected final String TEXT_14 = NL + "\t\t\tcredentials_";
  protected final String TEXT_15 = ".put(\"username\",";
  protected final String TEXT_16 = ");" + NL + "\t\t\tcredentials_";
  protected final String TEXT_17 = ".put(\"password\",";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL + "\t\t\tcluster_";
  protected final String TEXT_20 = " = me.prettyprint.hector.api.factory.HFactory.getOrCreateCluster(\"cluster_";
  protected final String TEXT_21 = "_\"+pid,hosts_";
  protected final String TEXT_22 = ",credentials_";
  protected final String TEXT_23 = ");";
  protected final String TEXT_24 = NL + "\t\t\tme.prettyprint.cassandra.model.ConfigurableConsistencyLevel clpolicy_";
  protected final String TEXT_25 = " = new me.prettyprint.cassandra.model.ConfigurableConsistencyLevel();" + NL + "\t\t\tme.prettyprint.hector.api.HConsistencyLevel consistencyLevel_";
  protected final String TEXT_26 = " = me.prettyprint.hector.api.HConsistencyLevel.ONE;" + NL + "\t\t\tclpolicy_";
  protected final String TEXT_27 = ".setDefaultWriteConsistencyLevel(consistencyLevel_";
  protected final String TEXT_28 = ");" + NL + "\t\t\tkeyspace_";
  protected final String TEXT_29 = " = me.prettyprint.hector.api.factory.HFactory.createKeyspace(";
  protected final String TEXT_30 = ", cluster_";
  protected final String TEXT_31 = ",clpolicy_";
  protected final String TEXT_32 = ");" + NL + "\t\t\tme.prettyprint.cassandra.model.CqlQuery cql_";
  protected final String TEXT_33 = "=new me.prettyprint.cassandra.model.CqlQuery(keyspace_";
  protected final String TEXT_34 = ",me.prettyprint.cassandra.serializers.StringSerializer.get()," + NL + "\t\t\t\tme.prettyprint.cassandra.serializers.StringSerializer.get(),me.prettyprint.cassandra.serializers.StringSerializer.get());" + NL + "\t\t\tcql_";
  protected final String TEXT_35 = ".setQuery(";
  protected final String TEXT_36 = ");" + NL + "\t\t\tcql_";
  protected final String TEXT_37 = ".execute();" + NL + "\t\t}catch(Exception e_";
  protected final String TEXT_38 = "){";
  protected final String TEXT_39 = NL + "\t\t\tthrow(e_";
  protected final String TEXT_40 = ");";
  protected final String TEXT_41 = NL + "\t\t\tSystem.err.println(e_";
  protected final String TEXT_42 = ".getMessage());";
  protected final String TEXT_43 = NL + "\t\t}finally{" + NL + "\t\t\tif(cluster_";
  protected final String TEXT_44 = "!=null){" + NL + "\t\t\t\tcluster_";
  protected final String TEXT_45 = ".getConnectionManager().shutdown();" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_46 = NL + "\t\t}";
  protected final String TEXT_47 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    
	String host = ElementParameterParser.getValue(node,"__HOST__");
    String port = ElementParameterParser.getValue(node,"__PORT__");
    //String cluster= ElementParameterParser.getValue(node, "__CLUSTER__");
    String userName = ElementParameterParser.getValue(node, "__USERNAME__");
    String passWord = ElementParameterParser.getValue(node, "__PASSWORD__");
	String keySpace = ElementParameterParser.getValue(node,"__KEY_SPACE__");
	boolean authentication="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__REQUIRED_AUTHENTICATION__"));
    boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
    String columnFamily = ElementParameterParser.getValue(node,"__COLUMN_FAMILY__");
    String query = ElementParameterParser.getValue(node,"__QUERY__");
    query = query.replaceAll("\n"," ");
    query = query.replaceAll("\r"," ");
    boolean dieOnError = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
	if (useExistingConnection){
		String connection = ElementParameterParser.getValue(node, "__CONNECTION__");

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_6);
    
	}else{

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
		if (authentication){

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(passWord);
    stringBuffer.append(TEXT_18);
    
		}

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
	}

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(keySpace);
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
    stringBuffer.append(query);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
	if(dieOnError){

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    
	}else{

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
	}
	if (!useExistingConnection){

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    
	}else{

    stringBuffer.append(TEXT_46);
    
	}

    stringBuffer.append(TEXT_47);
    return stringBuffer.toString();
  }
}
