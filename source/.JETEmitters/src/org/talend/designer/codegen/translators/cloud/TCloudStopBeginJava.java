package org.talend.designer.codegen.translators.cloud;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;

public class TCloudStopBeginJava
{
  protected static String nl;
  public static synchronized TCloudStopBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCloudStopBeginJava result = new TCloudStopBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\torg.jclouds.compute.ComputeServiceContext context_";
  protected final String TEXT_3 = " = new org.jclouds.compute.ComputeServiceContextFactory().createContext(\"";
  protected final String TEXT_4 = "\", ";
  protected final String TEXT_5 = ", ";
  protected final String TEXT_6 = ");" + NL + "\torg.jclouds.compute.ComputeService client_";
  protected final String TEXT_7 = " = context_";
  protected final String TEXT_8 = ".getComputeService();" + NL;
  protected final String TEXT_9 = NL + "\t" + NL + "\t\tclient_";
  protected final String TEXT_10 = ".";
  protected final String TEXT_11 = "NodesMatching(org.jclouds.compute.predicates.NodePredicates.";
  protected final String TEXT_12 = NL + "\t\t\tRUNNING);";
  protected final String TEXT_13 = NL + "\t\t\tinGroup(";
  protected final String TEXT_14 = ".toLowerCase()));";
  protected final String TEXT_15 = NL + "\t\t\trunningInGroup(";
  protected final String TEXT_16 = ".toLowerCase()));";
  protected final String TEXT_17 = NL + "\t\tclient_";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = "Node(";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String accesskey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");
	String secretkey = ElementParameterParser.getValue(node, "__SECRET_KEY__");
	String provider = ElementParameterParser.getValue(node, "__PROVIDER__");
	String predicates = ElementParameterParser.getValue(node, "__PREDICATES__");
	
	String instanceName = ElementParameterParser.getValue(node, "__INSTANCE_NAME__");
	String id = ElementParameterParser.getValue(node, "__ID__");
	
	String providerId = "";
	if("AWS_EC2".equals(provider)) {
		providerId = "aws-ec2";
	}


    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(providerId);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(accesskey);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(secretkey);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
	if(!("WITH_IDS".equals(predicates))) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ACTION__").toLowerCase());
    stringBuffer.append(TEXT_11);
    
		if("RUNNING".equals(predicates)) {

    stringBuffer.append(TEXT_12);
    
		}
		if("IN_GROUP".equals(predicates)) {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(instanceName);
    stringBuffer.append(TEXT_14);
    
		}
		if("RUNNING_IN_GROUP".equals(predicates)) {

    stringBuffer.append(TEXT_15);
    stringBuffer.append(instanceName);
    stringBuffer.append(TEXT_16);
    
		}
	} else {

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ACTION__").toLowerCase());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_20);
    
	}

    stringBuffer.append(TEXT_21);
    return stringBuffer.toString();
  }
}
