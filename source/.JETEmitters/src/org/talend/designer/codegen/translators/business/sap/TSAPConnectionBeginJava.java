package org.talend.designer.codegen.translators.business.sap;

import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSAPConnectionBeginJava
{
  protected static String nl;
  public static synchronized TSAPConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSAPConnectionBeginJava result = new TSAPConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tcom.sap.mw.jco.JCO.Client client_";
  protected final String TEXT_3 = " = null;" + NL + "\t";
  protected final String TEXT_4 = NL + "\t\t//Create a client connection to a dedicated R/3 system" + NL + "\t\tclient_";
  protected final String TEXT_5 = " = com.sap.mw.jco.JCO.createClient( ";
  protected final String TEXT_6 = ",      // SAP client" + NL + "\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_7 = ",   \t// userid" + NL + "\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_8 = ",    // password" + NL + "\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_9 = ",    // language" + NL + "\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_10 = ",    // host name" + NL + "\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_11 = " );      // system number" + NL + "\t";
  protected final String TEXT_12 = NL + "\t\t//Create a client connection to Message Server " + NL + "\t\tclient_";
  protected final String TEXT_13 = " = com.sap.mw.jco.JCO.createClient( ";
  protected final String TEXT_14 = ",      // SAP client" + NL + "\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_15 = ",   \t// userid" + NL + "\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_16 = ",    // password" + NL + "\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_17 = ",    // language" + NL + "\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_18 = ",    // host name" + NL + "\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_19 = ",    // system ID,defined in sapmsg.ini" + NL + "\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_20 = " );  // group name    " + NL + "\t";
  protected final String TEXT_21 = NL + "\t// Open the connection" + NL + "\tclient_";
  protected final String TEXT_22 = ".connect();" + NL + "\t";
  protected final String TEXT_23 = NL + "\tcom.sap.mw.jco.JCO.setMiddlewareProperty(\"jco.middleware.allow_start_of_programs\", \"ftp;sapftp;sapftpa;sapkprotp;http;saphttp;saphttpa\");" + NL + "\tclient_";
  protected final String TEXT_24 = ".setSapGui(2);" + NL + "\t";
  protected final String TEXT_25 = NL + "\tglobalMap.put(\"conn_";
  protected final String TEXT_26 = "\", client_";
  protected final String TEXT_27 = ");";
  protected final String TEXT_28 = NL + "\torg.talend.sap.TalendDestinationData destinationData_";
  protected final String TEXT_29 = " = null;" + NL + "\t";
  protected final String TEXT_30 = NL + "\t\tdestinationData_";
  protected final String TEXT_31 = " = new org.talend.sap.TalendDestinationData(";
  protected final String TEXT_32 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_33 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_34 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_35 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_36 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_37 = ");" + NL + "\t";
  protected final String TEXT_38 = "\t\t\t" + NL + "\t\tdestinationData_";
  protected final String TEXT_39 = " = new org.talend.sap.TalendDestinationData(";
  protected final String TEXT_40 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_41 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_42 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_43 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_44 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_45 = "," + NL + "\t\t\t\t            \t\t\t\t \t\t\t\t\t\t\t\t";
  protected final String TEXT_46 = " );" + NL + "\t";
  protected final String TEXT_47 = NL + "    org.talend.sap.TalendDestinationDataProvider destinationDataProvider_";
  protected final String TEXT_48 = " = org.talend.sap.TalendDestinationDataProvider.getInstance();" + NL + "    destinationDataProvider_";
  protected final String TEXT_49 = ".addDestination(\"SAP_SERVER_";
  protected final String TEXT_50 = "\", destinationData_";
  protected final String TEXT_51 = ");";
  protected final String TEXT_52 = NL + "    destinationDataProvider_";
  protected final String TEXT_53 = ".getDestinationProperties(\"SAP_SERVER_";
  protected final String TEXT_54 = "\").setProperty(com.sap.conn.jco.ext.DestinationDataProvider.JCO_USE_SAPGUI, \"2\");" + NL + "\tcom.sap.conn.jco.JCo.setMiddlewareProperty(\"jco.middleware.allow_start_of_programs\", \"ftp;sapftp;sapftpa;sapkprotp;http;saphttp;saphttpa\");" + NL + "\t";
  protected final String TEXT_55 = NL + "    try {" + NL + "    \tcom.sap.conn.jco.ext.Environment.registerDestinationDataProvider(destinationDataProvider_";
  protected final String TEXT_56 = ");" + NL + "\t} catch (java.lang.IllegalStateException ex) {" + NL + "\t\t//ignore if the provider already registered." + NL + "    }" + NL + "    com.sap.conn.jco.JCoDestination dest_";
  protected final String TEXT_57 = " = com.sap.conn.jco.JCoDestinationManager.getDestination(\"SAP_SERVER_";
  protected final String TEXT_58 = "\");" + NL + "    // Begins the stateful call sequence for calls to the specified destination." + NL + "    com.sap.conn.jco.JCoContext.begin(dest_";
  protected final String TEXT_59 = ");" + NL + "\tdest_";
  protected final String TEXT_60 = ".ping();" + NL + "    globalMap.put(\"conn_";
  protected final String TEXT_61 = "\", dest_";
  protected final String TEXT_62 = ");";
  protected final String TEXT_63 = NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

	String version = ElementParameterParser.getValue(node, "__DB_VERSION__");
    String client = ElementParameterParser.getValue(node, "__CLIENT__");
    String userid = ElementParameterParser.getValue(node, "__USERID__");
    String password = ElementParameterParser.getValue(node, "__PASSWORD__");
    String language = ElementParameterParser.getValue(node, "__LANGUAGE__");
    String hostname = ElementParameterParser.getValue(node, "__HOSTNAME__");
    String systemnumber = ElementParameterParser.getValue(node, "__SYSTEMNUMBER__");
    
    String serverType = ElementParameterParser.getValue(node,"__SERVERTYPE__");
    String systemId = ElementParameterParser.getValue(node,"__SYSTEMID__");
    String groupName = ElementParameterParser.getValue(node,"__GROUPNAME__");
    boolean useFtpHttp = ("true").equals(ElementParameterParser.getValue(node,"__FTP_HTTP_FUNCTION__"));

    if("sapjco.jar".equals(version)){
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    if("ApplicationServer".equals(serverType)){
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(client );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(userid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(password );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(language );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(hostname );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(systemnumber );
    stringBuffer.append(TEXT_11);
    }else{
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(client );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(userid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(password );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(language );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(hostname );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(systemId );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(groupName);
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    if(useFtpHttp){
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    }
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    }else{
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    if("ApplicationServer".equals(serverType)){
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(client);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(userid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(language);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(hostname);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(systemnumber);
    stringBuffer.append(TEXT_37);
    }else{
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(client);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(userid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(language);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(hostname);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(systemId );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(groupName);
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    if(useFtpHttp){
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    }
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    }
    stringBuffer.append(TEXT_63);
    return stringBuffer.toString();
  }
}
