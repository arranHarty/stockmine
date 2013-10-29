package org.talend.designer.codegen.translators.bigdata.googlestorage;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TGSConnectionBeginJava
{
  protected static String nl;
  public static synchronized TGSConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGSConnectionBeginJava result = new TGSConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\torg.jets3t.service.security.GSCredentials credentials_";
  protected final String TEXT_3 = " = new org.jets3t.service.security.GSCredentials(";
  protected final String TEXT_4 = ",";
  protected final String TEXT_5 = ");" + NL + "\torg.jets3t.service.impl.rest.httpclient.GoogleStorageService service_";
  protected final String TEXT_6 = " = " + NL + "\t\tnew org.jets3t.service.impl.rest.httpclient.GoogleStorageService(credentials_";
  protected final String TEXT_7 = ");" + NL + "\tservice_";
  protected final String TEXT_8 = ".getAccountOwner();" + NL + "\tglobalMap.put(\"service_\" + \"";
  protected final String TEXT_9 = "\",service_";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
	
    String cid = node.getUniqueName();
    String accessKey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");
    String secretKey = ElementParameterParser.getValue(node, "__SECRET_KEY__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(accessKey);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(secretKey);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}
