package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TFileInputJSONEndJava
{
  protected static String nl;
  public static synchronized TFileInputJSONEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputJSONEndJava result = new TFileInputJSONEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "            }";
  protected final String TEXT_3 = NL + "\t}" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_4 = "_NB_LINE\",nb_line_";
  protected final String TEXT_5 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
boolean readByXPath = "true".equals(ElementParameterParser.getValue(node, "__READBYXPATH__"));

String cid = node.getUniqueName();

    
        if(readByXPath){

    stringBuffer.append(TEXT_2);
    
        }

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}
