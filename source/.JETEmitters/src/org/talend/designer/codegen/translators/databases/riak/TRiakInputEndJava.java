package org.talend.designer.codegen.translators.databases.riak;

import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TRiakInputEndJava
{
  protected static String nl;
  public static synchronized TRiakInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRiakInputEndJava result = new TRiakInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t}";
  protected final String TEXT_3 = NL + "\t}finally{" + NL + "\t\tif(client_";
  protected final String TEXT_4 = " !=null){" + NL + "\t\t\tclient_";
  protected final String TEXT_5 = ".shutdown();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_6 = NL + "\tglobalMap.put(\"";
  protected final String TEXT_7 = "_NB_LINE\", nb_line_";
  protected final String TEXT_8 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    
	boolean useExistingConn = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
    List<IMetadataTable> metadatas = node.getMetadataList();
    
	if(metadatas != null && metadatas.size() > 0){
      	IMetadataTable metadata = metadatas.get(0);
      	if(metadata != null){

    stringBuffer.append(TEXT_2);
    
			if(!useExistingConn){

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
		}
	}

    return stringBuffer.toString();
  }
}
