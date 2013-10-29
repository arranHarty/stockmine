package org.talend.designer.codegen.translators.business.sap;

import java.util.List;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSAPOutputBeginJava
{
  protected static String nl;
  public static synchronized TSAPOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSAPOutputBeginJava result = new TSAPOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t";
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + "\tcom.sap.mw.jco.JCO.Client client_";
  protected final String TEXT_6 = " = null;" + NL + "\t";
  protected final String TEXT_7 = "\t    " + NL + "\t\t  client_";
  protected final String TEXT_8 = " = (com.sap.mw.jco.JCO.Client)globalMap.get(\"conn_";
  protected final String TEXT_9 = "\");\t" + NL + "\t";
  protected final String TEXT_10 = NL + "\t\t";
  protected final String TEXT_11 = NL + "\t\ttry{" + NL + "\t\t";
  protected final String TEXT_12 = "    " + NL + "\t\t\t//Create a client connection to a dedicated R/3 system" + NL + "\t\t  \tclient_";
  protected final String TEXT_13 = " = com.sap.mw.jco.JCO.createClient( ";
  protected final String TEXT_14 = ",      // SAP client" + NL + "\t\t\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_15 = ",   \t// userid" + NL + "\t\t\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_16 = ",    // password" + NL + "\t\t\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_17 = ",    // language" + NL + "\t\t\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_18 = ",    // host name" + NL + "\t\t\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_19 = " );      // system number" + NL + "\t\t";
  protected final String TEXT_20 = NL + "\t\t\t//Create a client connection to Message Server " + NL + "\t\t\tclient_";
  protected final String TEXT_21 = " = com.sap.mw.jco.JCO.createClient( ";
  protected final String TEXT_22 = ",      // SAP client" + NL + "\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_23 = ",   \t// userid" + NL + "\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_24 = ",    // password" + NL + "\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_25 = ",    // language" + NL + "\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_26 = ",    // host name" + NL + "\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_27 = ",    // system ID,defined in sapmsg.ini" + NL + "\t\t\t\t            \t\t\t\t ";
  protected final String TEXT_28 = " );  // group name    " + NL + "\t\t";
  protected final String TEXT_29 = "\t        \t\t\t\t " + NL + "\t\t// Open the connection" + NL + "\t\tclient_";
  protected final String TEXT_30 = ".connect();" + NL + "\t\t";
  protected final String TEXT_31 = NL + "\t\tcom.sap.mw.jco.JCO.setMiddlewareProperty(\"jco.middleware.allow_start_of_programs\", \"ftp;sapftp;sapftpa;sapkprotp;http;saphttp;saphttpa\");" + NL + "\t\tclient_";
  protected final String TEXT_32 = ".setSapGui(2);" + NL + "\t\t";
  protected final String TEXT_33 = NL + "\t";
  protected final String TEXT_34 = " \t" + NL + "      " + NL + "    com.sap.mw.jco.IRepository repository_";
  protected final String TEXT_35 = " = com.sap.mw.jco.JCO.createRepository(\"REPOSITORY\", client_";
  protected final String TEXT_36 = ");" + NL + "" + NL + "    com.sap.mw.jco.IFunctionTemplate functionTemplate_";
  protected final String TEXT_37 = " = repository_";
  protected final String TEXT_38 = ".getFunctionTemplate(";
  protected final String TEXT_39 = ");" + NL + "" + NL + "\tif(functionTemplate_";
  protected final String TEXT_40 = " == null){" + NL + "\t\tcom.sap.mw.jco.JCO.releaseClient(client_";
  protected final String TEXT_41 = ");" + NL + "\t\tthrow new RuntimeException(\"The RFC can't support the function: \" + ";
  protected final String TEXT_42 = " + \".\");" + NL + "\t}      " + NL + "\t" + NL + "    com.sap.mw.jco.JCO.Function function_";
  protected final String TEXT_43 = " = functionTemplate_";
  protected final String TEXT_44 = ".getFunction();" + NL + "" + NL + "    com.sap.mw.jco.JCO.ParameterList importParameterList_";
  protected final String TEXT_45 = " = function_";
  protected final String TEXT_46 = ".getImportParameterList();" + NL + "    com.sap.mw.jco.JCO.ParameterList exportParameterList_";
  protected final String TEXT_47 = " = function_";
  protected final String TEXT_48 = ".getExportParameterList();" + NL + "    com.sap.mw.jco.JCO.ParameterList tableParameterList_";
  protected final String TEXT_49 = " = function_";
  protected final String TEXT_50 = ".getTableParameterList();" + NL + "    " + NL + "    com.sap.mw.jco.JCO.Structure input_structure_";
  protected final String TEXT_51 = "=null;" + NL + "    com.sap.mw.jco.JCO.Table input_table_";
  protected final String TEXT_52 = "=null; " + NL + "    com.sap.mw.jco.JCO.Table table_input_";
  protected final String TEXT_53 = "=null; ";
  protected final String TEXT_54 = NL + "\tcom.sap.conn.jco.JCoDestination dest_";
  protected final String TEXT_55 = " = null;" + NL + "\t";
  protected final String TEXT_56 = "\t" + NL + "\t\tdest_";
  protected final String TEXT_57 = " = (com.sap.conn.jco.JCoDestination)globalMap.get(\"conn_";
  protected final String TEXT_58 = "\");" + NL + "\t";
  protected final String TEXT_59 = NL + "\t";
  protected final String TEXT_60 = NL + "\ttry{" + NL + "\t\torg.talend.sap.TalendDestinationData destinationData_";
  protected final String TEXT_61 = " = null;" + NL + "\t\t";
  protected final String TEXT_62 = NL + "\t\t\tdestinationData_";
  protected final String TEXT_63 = " = new org.talend.sap.TalendDestinationData(";
  protected final String TEXT_64 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_65 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_66 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_67 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_68 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_69 = ");" + NL + "\t\t";
  protected final String TEXT_70 = "\t\t\t" + NL + "\t\t\tdestinationData_";
  protected final String TEXT_71 = " = new org.talend.sap.TalendDestinationData(";
  protected final String TEXT_72 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_73 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_74 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_75 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_76 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_77 = "," + NL + "\t\t\t\t\t            \t\t\t\t \t\t\t\t\t\t\t\t";
  protected final String TEXT_78 = " );" + NL + "\t\t";
  protected final String TEXT_79 = NL + "\t    org.talend.sap.TalendDestinationDataProvider destinationDataProvider_";
  protected final String TEXT_80 = " = org.talend.sap.TalendDestinationDataProvider.getInstance();" + NL + "\t    destinationDataProvider_";
  protected final String TEXT_81 = ".addDestination(\"SAP_SERVER_";
  protected final String TEXT_82 = "\", destinationData_";
  protected final String TEXT_83 = ");" + NL + "\t    ";
  protected final String TEXT_84 = NL + "\t    destinationDataProvider_";
  protected final String TEXT_85 = ".getDestinationProperties(\"SAP_SERVER_";
  protected final String TEXT_86 = "\").setProperty(com.sap.conn.jco.ext.DestinationDataProvider.JCO_USE_SAPGUI, \"2\");" + NL + "\t\tcom.sap.conn.jco.JCo.setMiddlewareProperty(\"jco.middleware.allow_start_of_programs\", \"ftp;sapftp;sapftpa;sapkprotp;http;saphttp;saphttpa\");" + NL + "\t\t";
  protected final String TEXT_87 = NL + "\t    try {" + NL + "\t    \tcom.sap.conn.jco.ext.Environment.registerDestinationDataProvider(destinationDataProvider_";
  protected final String TEXT_88 = ");" + NL + "\t\t} catch (java.lang.IllegalStateException ex) {" + NL + "\t\t\t//ignore if the provider already registered." + NL + "\t    }" + NL + "\t    dest_";
  protected final String TEXT_89 = " = com.sap.conn.jco.JCoDestinationManager.getDestination(\"SAP_SERVER_";
  protected final String TEXT_90 = "\");" + NL + "\t    // Begins the stateful call sequence for calls to the specified destination." + NL + "\t\tcom.sap.conn.jco.JCoContext.begin(dest_";
  protected final String TEXT_91 = ");" + NL + "\t";
  protected final String TEXT_92 = " " + NL + "\tcom.sap.conn.jco.JCoRepository repository_";
  protected final String TEXT_93 = " = dest_";
  protected final String TEXT_94 = ".getRepository();" + NL + "\t" + NL + "\tcom.sap.conn.jco.JCoFunctionTemplate functionTemplate_";
  protected final String TEXT_95 = " = repository_";
  protected final String TEXT_96 = ".getFunctionTemplate(";
  protected final String TEXT_97 = ");" + NL + "\tif(functionTemplate_";
  protected final String TEXT_98 = " == null){" + NL + "\t\tcom.sap.conn.jco.JCoContext.end(dest_";
  protected final String TEXT_99 = ");" + NL + "\t\tthrow new RuntimeException(\"The RFC can't support the function: \" + ";
  protected final String TEXT_100 = " + \".\");" + NL + "\t}  " + NL + "\tcom.sap.conn.jco.JCoFunction function_";
  protected final String TEXT_101 = " = functionTemplate_";
  protected final String TEXT_102 = ".getFunction();" + NL + "\t" + NL + "\tcom.sap.conn.jco.JCoParameterList importParameterList_";
  protected final String TEXT_103 = " = function_";
  protected final String TEXT_104 = ".getImportParameterList();" + NL + "    com.sap.conn.jco.JCoParameterList exportParameterList_";
  protected final String TEXT_105 = " = function_";
  protected final String TEXT_106 = ".getExportParameterList();" + NL + "    com.sap.conn.jco.JCoParameterList tableParameterList_";
  protected final String TEXT_107 = " = function_";
  protected final String TEXT_108 = ".getTableParameterList();" + NL + "    " + NL + "    com.sap.conn.jco.JCoStructure input_structure_";
  protected final String TEXT_109 = "=null;" + NL + "    com.sap.conn.jco.JCoTable input_table_";
  protected final String TEXT_110 = "=null; " + NL + "    com.sap.conn.jco.JCoTable table_input_";
  protected final String TEXT_111 = "=null; ";
  protected final String TEXT_112 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

    stringBuffer.append(TEXT_2);
    	
	IConnection firstDataConn = null;
	List<IMetadataColumn> firstColumnList = null;

	//1. get first DATA Link
	List< ? extends IConnection> conns = node.getIncomingConnections();	
	if(conns != null && conns.size() > 0){
		for(IConnection conn : conns){
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				firstDataConn = conn;
				break;
			}
		}
	}

	//2. get first columnList (with real columns data) 	
	List<IMetadataTable> metadatas = node.getMetadataList();
	IMetadataTable metadata = null;
	if ( metadatas != null && metadatas.size() > 0 ) {
		metadata = metadatas.get(0);
		if(metadata != null){
			firstColumnList = metadata.getListColumns(); 
			if ( firstColumnList == null || firstColumnList.size() == 0 ) {
				firstColumnList = null;
			}
		}
	}
	
	//3. check the config Link and Schema
	if(firstDataConn == null || firstColumnList == null)
	{
		return "";
	}

    stringBuffer.append(TEXT_3);
    
boolean startIterate = false;
String firstDataConnName = firstDataConn.getName();

String client = ElementParameterParser.getValue(node, "__CLIENT__");
String userid = ElementParameterParser.getValue(node, "__USERID__");
String password = ElementParameterParser.getValue(node, "__PASSWORD__");
String language = ElementParameterParser.getValue(node, "__LANGUAGE__");
String hostname = ElementParameterParser.getValue(node, "__HOSTNAME__");
String systemnumber = ElementParameterParser.getValue(node, "__SYSTEMNUMBER__");

String serverType = ElementParameterParser.getValue(node,"__SERVERTYPE__");
String systemId = ElementParameterParser.getValue(node,"__SYSTEMID__");
String groupName = ElementParameterParser.getValue(node,"__GROUPNAME__");

String functionName = ElementParameterParser.getValue(node, "__SAP_FUNCTION__");

String iterate_out_type = ElementParameterParser.getValue(node, "__SAP_ITERATE_OUT_TYPE__");
String iterate_out_tablename = ElementParameterParser.getValue(node, "__SAP_ITERATE_OUT_TABLENAME__");
boolean useFtpHttp = ("true").equals(ElementParameterParser.getValue(node,"__FTP_HTTP_FUNCTION__"));
boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
String version = "sapjco.jar";
if(useExistingConn){
    List<? extends INode> nodes = node.getProcess().getGeneratingNodes();
    for(INode targetNode : nodes){
    	if (targetNode.getUniqueName().equals(connection)) {
	      version = ElementParameterParser.getValue(targetNode, "__DB_VERSION__");
	    }
    }
}else{
	version = ElementParameterParser.getValue(node, "__DB_VERSION__");
}

    stringBuffer.append(TEXT_4);
    if("sapjco.jar".equals(version)){
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    if(useExistingConn){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_9);
    }else{
    stringBuffer.append(TEXT_10);
    //big try
    stringBuffer.append(TEXT_11);
    if("ApplicationServer".equals(serverType)){
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
    stringBuffer.append(systemnumber );
    stringBuffer.append(TEXT_19);
    }else{
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(client );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(userid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(password );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(language );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(hostname );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(systemId );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(groupName);
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    if(useFtpHttp){
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    }
    stringBuffer.append(TEXT_33);
    }
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(functionName );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(functionName );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    }else if("sapjco3.jar".equals(version)){
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    if(useExistingConn){
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_58);
    }else{
    stringBuffer.append(TEXT_59);
    //big try
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    if("ApplicationServer".equals(serverType)){
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(client);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(userid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(language);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(hostname);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(systemnumber);
    stringBuffer.append(TEXT_69);
    }else{
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(client);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(userid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(language);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(hostname);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(systemId );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(groupName);
    stringBuffer.append(TEXT_78);
    }
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    if(useFtpHttp){
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    }
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    }
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(functionName );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(functionName );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    }
    stringBuffer.append(TEXT_112);
    return stringBuffer.toString();
  }
}
