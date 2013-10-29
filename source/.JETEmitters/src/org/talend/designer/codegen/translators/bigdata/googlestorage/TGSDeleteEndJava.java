package org.talend.designer.codegen.translators.bigdata.googlestorage;

import java.util.List;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.Map;

public class TGSDeleteEndJava
{
  protected static String nl;
  public static synchronized TGSDeleteEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGSDeleteEndJava result = new TGSDeleteEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "\t\t   \t\t}" + NL + "\t\t    }";
  protected final String TEXT_3 = NL + "\t}catch(java.lang.Exception e_";
  protected final String TEXT_4 = "){";
  protected final String TEXT_5 = NL + "\t\tthrow(e_";
  protected final String TEXT_6 = ");";
  protected final String TEXT_7 = NL + "\t\tSystem.err.println(e_";
  protected final String TEXT_8 = ".getMessage());";
  protected final String TEXT_9 = NL + "\t}finally{" + NL + "\t\tif(service_";
  protected final String TEXT_10 = " !=null){" + NL + "\t\t\tservice_";
  protected final String TEXT_11 = ".shutdown();" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_12 = NL + "\t}" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_13 = "_NB_LINE\", nb_line_";
  protected final String TEXT_14 = ");";
  protected final String TEXT_15 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	boolean queryDelObjInListBuckets = "true".equals(ElementParameterParser.getValue(node,"__DEL_IN_LIST_BUCKETS__"));
	List<Map<String, String>> buckets = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__BUCKETS__");
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	
	if(!queryDelObjInListBuckets || buckets.size()>0){

    stringBuffer.append(TEXT_2);
    
	}

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
		if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
		} else {

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
		}
		if(!("true").equals(useExistingConn)) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
		}

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(TEXT_15);
    return stringBuffer.toString();
  }
}
