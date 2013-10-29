package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMDMConnectionBeginJava
{
  protected static String nl;
  public static synchronized TMDMConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMConnectionBeginJava result = new TMDMConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + NL + "org.talend.mdm.webservice.XtentisServiceLocator xtentisService_";
  protected final String TEXT_3 = " = new org.talend.mdm.webservice.XtentisServiceLocator();" + NL + "xtentisService_";
  protected final String TEXT_4 = ".setXtentisPortEndpointAddress(";
  protected final String TEXT_5 = ");" + NL + "org.talend.mdm.webservice.XtentisPort xtentisWS_";
  protected final String TEXT_6 = " = xtentisService_";
  protected final String TEXT_7 = ".getXtentisPort();    " + NL + "org.talend.mdm.webservice.XtentisBindingStub stub_";
  protected final String TEXT_8 = " = (org.talend.mdm.webservice.XtentisBindingStub)xtentisWS_";
  protected final String TEXT_9 = ";" + NL + "" + NL + "// Authentification";
  protected final String TEXT_10 = NL + "stub_";
  protected final String TEXT_11 = ".setUsername(";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL + "stub_";
  protected final String TEXT_14 = ".setUsername(";
  protected final String TEXT_15 = " + \"/\" + ";
  protected final String TEXT_16 = ");";
  protected final String TEXT_17 = NL + "stub_";
  protected final String TEXT_18 = ".setPassword(";
  protected final String TEXT_19 = ");" + NL;
  protected final String TEXT_20 = NL + "String turl_";
  protected final String TEXT_21 = " = com.talend.mdm.transaction.client.MDMTransactionClient.getMDMTransactionURL(";
  protected final String TEXT_22 = ");" + NL + "com.talend.mdm.transaction.client.MDMTransaction mdmTransaction_";
  protected final String TEXT_23 = " = com.talend.mdm.transaction.client.MDMTransactionClient.newTransaction(turl_";
  protected final String TEXT_24 = ",stub_";
  protected final String TEXT_25 = ".getUsername(),stub_";
  protected final String TEXT_26 = ".getPassword());" + NL + "stub_";
  protected final String TEXT_27 = ".setHeader(new org.apache.axis.message.SOAPHeaderElement(\"http://www.talend.com/mdm\", \"transaction-id\", mdmTransaction_";
  protected final String TEXT_28 = ".getId()));" + NL + "globalMap.put(\"mdmTransaction_";
  protected final String TEXT_29 = "\", mdmTransaction_";
  protected final String TEXT_30 = ");";
  protected final String TEXT_31 = NL + NL + "stub_";
  protected final String TEXT_32 = ".ping(new org.talend.mdm.webservice.WSPing());";
  protected final String TEXT_33 = NL + NL + "globalMap.put(\"xtentisWS_";
  protected final String TEXT_34 = "\", xtentisWS_";
  protected final String TEXT_35 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String mdmUrl = ElementParameterParser.getValue(node, "__MDMURL__");
String username = ElementParameterParser.getValue(node, "__USER__");
String password = ElementParameterParser.getValue(node, "__PASS__");
String universe = ElementParameterParser.getValue(node, "__UNIVERSE__");
boolean useTransaction = "false".equals(ElementParameterParser.getValue(node, "__AUTO_COMMIT__"));

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(mdmUrl );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    if(universe==null || ("").equals(universe.trim())){
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_12);
    }else{
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(universe);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(password );
    stringBuffer.append(TEXT_19);
    if(useTransaction) {
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(mdmUrl );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    }
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    //For TDI-26109
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    return stringBuffer.toString();
  }
}
