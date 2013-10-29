package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;

public class TFileInputRegexEndJava
{
  protected static String nl;
  public static synchronized TFileInputRegexEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputRegexEndJava result = new TFileInputRegexEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    \t\t}";
  protected final String TEXT_2 = NL + "\t\t\tif(!(source_";
  protected final String TEXT_3 = " instanceof java.io.InputStream)){" + NL + "            \tin";
  protected final String TEXT_4 = ".close();" + NL + "            }" + NL + "            in";
  protected final String TEXT_5 = " = null;" + NL + "            globalMap.put(\"";
  protected final String TEXT_6 = "_NB_LINE\",nb_line_";
  protected final String TEXT_7 = ");";
  protected final String TEXT_8 = "      ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String row_separator = ElementParameterParser.getValue(node, "__ROWSEPARATOR__");

    stringBuffer.append(TEXT_1);
    
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata!=null) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
		}
	}

    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}
