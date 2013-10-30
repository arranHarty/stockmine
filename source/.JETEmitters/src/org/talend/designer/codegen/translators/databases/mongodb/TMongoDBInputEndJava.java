package org.talend.designer.codegen.translators.databases.mongodb;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;

public class TMongoDBInputEndJava
{
  protected static String nl;
  public static synchronized TMongoDBInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMongoDBInputEndJava result = new TMongoDBInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\t}";
  protected final String TEXT_2 = NL + "\t}finally{" + NL + "\t\tif(mongo_";
  protected final String TEXT_3 = " != null )" + NL + "\t\t{" + NL + "\t\t\tmongo_";
  protected final String TEXT_4 = ".close();" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_5 = NL + "globalMap.put(\"";
  protected final String TEXT_6 = "_NB_LINE\", nb_line_";
  protected final String TEXT_7 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null) && (metadatas.size() > 0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata != null) {

    stringBuffer.append(TEXT_1);
    
		if(!"true".equals(useExistingConn)){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
		}
	}
}

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
