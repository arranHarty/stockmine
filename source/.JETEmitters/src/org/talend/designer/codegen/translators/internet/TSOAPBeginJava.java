package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSOAPBeginJava
{
  protected static String nl;
  public static synchronized TSOAPBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSOAPBeginJava result = new TSOAPBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = " ";
  protected final String TEXT_3 = "final";
  protected final String TEXT_4 = " org.talend.soap.SOAPUtil soapUtil_";
  protected final String TEXT_5 = " = new org.talend.soap.SOAPUtil();";
  protected final String TEXT_6 = "   " + NL + "System.setProperty(\"java.protocol.handler.pkgs\", \"com.sun.net.ssl.internal.www.protocol\");" + NL + "System.setProperty(\"javax.net.ssl.trustStore\", ";
  protected final String TEXT_7 = ");" + NL + "System.setProperty(\"javax.net.ssl.trustStorePassword\", ";
  protected final String TEXT_8 = ");";
  protected final String TEXT_9 = NL + "soapUtil_";
  protected final String TEXT_10 = ".setBasicAuth(";
  protected final String TEXT_11 = ",";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL + "soapUtil_";
  protected final String TEXT_14 = ".setNTLMAuth(";
  protected final String TEXT_15 = ",";
  protected final String TEXT_16 = ",";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "soapUtil_";
  protected final String TEXT_19 = ".setProxy(";
  protected final String TEXT_20 = ",";
  protected final String TEXT_21 = ",";
  protected final String TEXT_22 = ",";
  protected final String TEXT_23 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

    stringBuffer.append(TEXT_2);
    
boolean useNTLM = ("true").equals(ElementParameterParser.getValue(node,"__USE_NTLM__"));
String domain = ElementParameterParser.getValue(node,"__NTLM_DOMAIN__");
        
boolean needAuth = ("true").equals(ElementParameterParser.getValue(node,"__NEED_AUTH__"));
String username = ElementParameterParser.getValue(node,"__AUTH_USERNAME__");
String password = ElementParameterParser.getValue(node,"__AUTH_PASSWORD__");

boolean useProxy = ("true").equals(ElementParameterParser.getValue(node,"__USE_PROXY__"));
String proxyHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");
String proxyUser = ElementParameterParser.getValue(node,"__PROXY_USERNAME__");
String proxyPassword = ElementParameterParser.getValue(node,"__PROXY_PASSWORD__");
        
boolean needSSLtoTrustServer = ("true").equals(ElementParameterParser.getValue(node,"__NEED_SSL_TO_TRUSTSERVER__"));
String trustStoreFile = ElementParameterParser.getValue(node,"__SSL_TRUSTSERVER_TRUSTSTORE__");
String trustStorePassword = ElementParameterParser.getValue(node,"__SSL_TRUSTSERVER_PASSWORD__");

boolean useKerberos = ("true").equals(ElementParameterParser.getValue(node,"__USE_KERBEROS__"));
String kerberosConfiguration = ElementParameterParser.getValue(node,"__KERBEROS_CONFIGURATION__");

    if(useKerberos){
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    		
if (needSSLtoTrustServer) {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(trustStoreFile );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(trustStorePassword );
    stringBuffer.append(TEXT_8);
     
}
if(needAuth&&!useNTLM){

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_12);
    
}
if(needAuth&&useNTLM){

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(domain);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_17);
    
}
if(useProxy){

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(proxyHost);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(proxyPort);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(proxyUser);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(proxyPassword);
    stringBuffer.append(TEXT_23);
    
}

    return stringBuffer.toString();
  }
}
