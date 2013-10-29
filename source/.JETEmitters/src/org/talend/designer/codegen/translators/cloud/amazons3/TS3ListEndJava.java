package org.talend.designer.codegen.translators.cloud.amazons3;

import java.util.List;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.Map;

public class TS3ListEndJava
{
  protected static String nl;
  public static synchronized TS3ListEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TS3ListEndJava result = new TS3ListEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "\t\t            }" + NL + "\t\t            objects_";
  protected final String TEXT_3 = " = conn_";
  protected final String TEXT_4 = ".listNextBatchOfObjects(objects_";
  protected final String TEXT_5 = ");" + NL + "\t\t    } while (objects_";
  protected final String TEXT_6 = ".isTruncated());";
  protected final String TEXT_7 = NL + "\t\t\t\t}catch(com.amazonaws.AmazonClientException e_";
  protected final String TEXT_8 = "){";
  protected final String TEXT_9 = NL + "\t\t\t\t\t\tthrow(e_";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "\t\t\t\t\t\tSystem.err.println(e_";
  protected final String TEXT_12 = ".getMessage());";
  protected final String TEXT_13 = NL + "\t\t\t\t}";
  protected final String TEXT_14 = NL + "\t\t}";
  protected final String TEXT_15 = NL + "\t}catch(com.amazonaws.AmazonClientException e_";
  protected final String TEXT_16 = "){";
  protected final String TEXT_17 = NL + "\t\tthrow(e_";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL + "\t\tSystem.err.println(e_";
  protected final String TEXT_20 = ".getMessage());";
  protected final String TEXT_21 = NL + "\t}finally{" + NL + "\t\tif(conn_";
  protected final String TEXT_22 = " !=null){" + NL + "\t\t\tconn_";
  protected final String TEXT_23 = ".shutdown();" + NL + "\t\t}";
  protected final String TEXT_24 = NL + "\t}" + NL + "globalMap.put(\"";
  protected final String TEXT_25 = "_NB_BUCKET\", nb_bucket_";
  protected final String TEXT_26 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_27 = "_NB_BUCKET_OBJECT\", nb_bucket_object_";
  protected final String TEXT_28 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	boolean listAll = "true".equals(ElementParameterParser.getValue(node,"__LISTALL__"));
	List<Map<String, String>> buckets = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__BUCKETS__");
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	if(listAll || buckets.size()>0){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
		    if(!listAll){

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
					if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
					} else {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
					}

    stringBuffer.append(TEXT_13);
    
			}

    stringBuffer.append(TEXT_14);
    
	}

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
		if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
		} else {

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
		}
		if(!("true").equals(useExistingConn)) {

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
    return stringBuffer.toString();
  }
}
