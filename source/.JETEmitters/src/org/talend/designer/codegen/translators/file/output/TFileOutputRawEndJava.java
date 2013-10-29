package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;

public class TFileOutputRawEndJava
{
  protected static String nl;
  public static synchronized TFileOutputRawEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputRawEndJava result = new TFileOutputRawEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "\tglobalMap.put(\"";
  protected final String TEXT_3 = "_FILENAME_PATH\", ";
  protected final String TEXT_4 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String filename = ElementParameterParser.getValue(node, "__FILENAME__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}
