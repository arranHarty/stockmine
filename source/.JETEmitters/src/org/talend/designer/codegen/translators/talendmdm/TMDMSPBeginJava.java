package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMDMSPBeginJava
{
  protected static String nl;
  public static synchronized TMDMSPBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMSPBeginJava result = new TMDMSPBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "       " + NL + "\tint nb_line_";
  protected final String TEXT_2 = " = 0;" + NL + "" + NL + "\t";
  protected final String TEXT_3 = NL + "\t\torg.talend.mdm.webservice.XtentisServiceLocator xtentisService_";
  protected final String TEXT_4 = " = new org.talend.mdm.webservice.XtentisServiceLocator();" + NL + "\t\txtentisService_";
  protected final String TEXT_5 = ".setXtentisPortEndpointAddress(";
  protected final String TEXT_6 = ");" + NL + "\t\torg.talend.mdm.webservice.XtentisPort xtentisWS_";
  protected final String TEXT_7 = " = xtentisService_";
  protected final String TEXT_8 = ".getXtentisPort();    " + NL + "\t\torg.talend.mdm.webservice.XtentisBindingStub stub_";
  protected final String TEXT_9 = " = (org.talend.mdm.webservice.XtentisBindingStub)xtentisWS_";
  protected final String TEXT_10 = ";" + NL + "\t" + NL + "\t\t// Authentification" + NL + "\t\t";
  protected final String TEXT_11 = NL + "\t\tstub_";
  protected final String TEXT_12 = ".setUsername(";
  protected final String TEXT_13 = ");" + NL + "\t\t";
  protected final String TEXT_14 = NL + "\t\tstub_";
  protected final String TEXT_15 = ".setUsername(";
  protected final String TEXT_16 = " + \"/\" + ";
  protected final String TEXT_17 = ");" + NL + "\t\t";
  protected final String TEXT_18 = NL + "\t\tstub_";
  protected final String TEXT_19 = ".setPassword(";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "\t\torg.talend.mdm.webservice.XtentisPort xtentisWS_";
  protected final String TEXT_22 = " = (org.talend.mdm.webservice.XtentisPort)globalMap.get(\"";
  protected final String TEXT_23 = "\");";
  protected final String TEXT_24 = NL + NL + "\torg.talend.mdm.webservice.WSDataClusterPK dataCluster_";
  protected final String TEXT_25 = " = new org.talend.mdm.webservice.WSDataClusterPK(";
  protected final String TEXT_26 = " + \"";
  protected final String TEXT_27 = "\");" + NL + "" + NL + "\torg.talend.mdm.webservice.WSExecuteStoredProcedure wsExeProc_";
  protected final String TEXT_28 = " = new org.talend.mdm.webservice.WSExecuteStoredProcedure();" + NL + "\twsExeProc_";
  protected final String TEXT_29 = ".setWsDataClusterPK(dataCluster_";
  protected final String TEXT_30 = ");" + NL + "\torg.talend.mdm.webservice.WSStoredProcedurePK wsStoredProcPK_";
  protected final String TEXT_31 = " = new org.talend.mdm.webservice.WSStoredProcedurePK();" + NL + "\twsStoredProcPK_";
  protected final String TEXT_32 = ".setPk(";
  protected final String TEXT_33 = ");" + NL + "\twsExeProc_";
  protected final String TEXT_34 = ".setWsStoredProcedurePK(wsStoredProcPK_";
  protected final String TEXT_35 = ");";
  protected final String TEXT_36 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String conn = "xtentisWS_" + connection;
	String mdmUrl = ElementParameterParser.getValue(node, "__MDMURL__");
	String username = ElementParameterParser.getValue(node, "__USERNAME__");
	String password = ElementParameterParser.getValue(node, "__PASSWORD__");
	String universe = ElementParameterParser.getValue(node, "__UNIVERSE__");
	String dataCluster = ElementParameterParser.getValue(node, "__DATACLUSTER__");
	boolean isStaging = "STAGING".equalsIgnoreCase(ElementParameterParser.getValue(node, "__CONTAINER_TYPE__"));
	String spName = ElementParameterParser.getValue(node, "__SPNAME__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    if(!useExistingConn){
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(mdmUrl );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    if(universe==null || ("").equals(universe.trim())){
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_13);
    }else{
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(universe);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(password );
    stringBuffer.append(TEXT_20);
    
	}else{

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_23);
    
	}

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(dataCluster );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(isStaging?"#STAGING":"");
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(spName );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(TEXT_36);
    return stringBuffer.toString();
  }
}
