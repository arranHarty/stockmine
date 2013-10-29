package org.talend.designer.codegen.translators.internet.momandjms;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TMomConnectionBeginJava
{
  protected static String nl;
  public static synchronized TMomConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomConnectionBeginJava result = new TMomConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tjava.util.Hashtable props_";
  protected final String TEXT_3 = "=new java.util.Hashtable();" + NL + "" + NL + "\t/*---------------------------------------1.initial jms connection factry---------------------------------*/ " + NL + "" + NL + "\t\t\tString url_";
  protected final String TEXT_4 = " =\"\";";
  protected final String TEXT_5 = NL + "\t\t\turl_";
  protected final String TEXT_6 = " = \"failover:(\";" + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\t\turl_";
  protected final String TEXT_8 = " = url_";
  protected final String TEXT_9 = " +\",\";" + NL + "\t\t\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\t\turl_";
  protected final String TEXT_11 = " = url_";
  protected final String TEXT_12 = " +\"tcp://\";" + NL + "\t\t\t\t\turl_";
  protected final String TEXT_13 = " = url_";
  protected final String TEXT_14 = " +";
  protected final String TEXT_15 = ";" + NL + "\t\t\t\t\turl_";
  protected final String TEXT_16 = " = url_";
  protected final String TEXT_17 = " +\":\";" + NL + "\t\t\t\t\turl_";
  protected final String TEXT_18 = " = url_";
  protected final String TEXT_19 = " +";
  protected final String TEXT_20 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\turl_";
  protected final String TEXT_22 = " = url_";
  protected final String TEXT_23 = " +\")?randomize=false\";" + NL + "\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\turl_";
  protected final String TEXT_25 = " = \"tcp://\"+";
  protected final String TEXT_26 = "+\":\"+";
  protected final String TEXT_27 = ";" + NL + "\t\t\t";
  protected final String TEXT_28 = "\t\t\t" + NL + "\t\t" + NL + "\t\t\t" + NL + "\t\t\tSystem.out.println(\"Connecting to URL: \" + url_";
  protected final String TEXT_29 = ");" + NL + "" + NL + "\t\t\t" + NL + "\t\t\torg.apache.activemq.ActiveMQConnectionFactory factory_";
  protected final String TEXT_30 = " = " + NL + "\t\t\t\tnew org.apache.activemq.ActiveMQConnectionFactory(url_";
  protected final String TEXT_31 = ");";
  protected final String TEXT_32 = "\t" + NL + "\t\t\t\t";
  protected final String TEXT_33 = NL + "\t\t\tjavax.jms.Connection connection_";
  protected final String TEXT_34 = " = factory_";
  protected final String TEXT_35 = ".createConnection();";
  protected final String TEXT_36 = NL + "\t\t\tjavax.jms.Connection connection_";
  protected final String TEXT_37 = " = factory_";
  protected final String TEXT_38 = ".createConnection(";
  protected final String TEXT_39 = ",";
  protected final String TEXT_40 = ");";
  protected final String TEXT_41 = NL + NL + "        connection_";
  protected final String TEXT_42 = ".start();" + NL + "\t\tglobalMap.put(\"connection_";
  protected final String TEXT_43 = "\", connection_";
  protected final String TEXT_44 = ");" + NL + "" + NL + "\t\tjavax.jms.Session session_";
  protected final String TEXT_45 = " = connection_";
  protected final String TEXT_46 = ".createSession(";
  protected final String TEXT_47 = ", javax.jms.Session.";
  protected final String TEXT_48 = ");" + NL + "        globalMap.put(\"session_";
  protected final String TEXT_49 = "\", session_";
  protected final String TEXT_50 = ");";
  protected final String TEXT_51 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String host=ElementParameterParser.getValue(node, "__SERVERADDRESS__");
	String port=ElementParameterParser.getValue(node, "__SERVERPORT__");
	String to = ElementParameterParser.getValue(node, "__TO__");
	String deliverMode = ElementParameterParser.getValue(node, "__DELIVERY_MODE__");
	
	boolean transacted = "true".equals(ElementParameterParser.getValue(node, "__IS_TRANSACTED__"));
	String acknowledgmentMode = ElementParameterParser.getValue(node, "__ACKNOWLEDGMENT_MODE__");
	
	boolean failover =  ("true").equals(ElementParameterParser.getValue(node, "__FAILOVER__"));
	List<Map<String,String>> servers = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SERVERS__");

	String dbuser= ElementParameterParser.getValue(node, "__USER__");
	String dbpwd= ElementParameterParser.getValue(node, "__PASS__");

	String strHost = null;
	String strPort = null;

	IMetadataTable metadata=null;
	List<IMetadataTable> metadatas = node.getMetadataList();
		if ((metadatas!=null)&&(metadatas.size()>0)) {
			metadata = metadatas.get(0);
		}

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    if(failover){
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    
				int i=0;
				for(Map<String, String> serversMap : servers) {
					strHost = serversMap.get("SERVERS_HOST");
					strPort = serversMap.get("SERVERS_PORT");

					if(i>0) {
					
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
					}
					
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(strHost);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(strPort);
    stringBuffer.append(TEXT_20);
    
					i++;
				}
				
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    }else{
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_27);
    }
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    
		
		/*---------------------------------------2.create Queue Or Topic from connection ---------------------------------*/ 

    stringBuffer.append(TEXT_32);
    		if(dbuser == null || ("\"\"").equals(dbuser) || ("").equals(dbuser)) { 
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    		} else { 
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_40);
    		} 
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(transacted);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(acknowledgmentMode);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(TEXT_51);
    return stringBuffer.toString();
  }
}
