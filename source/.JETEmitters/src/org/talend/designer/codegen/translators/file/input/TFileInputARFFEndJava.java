package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TFileInputARFFEndJava
{
  protected static String nl;
  public static synchronized TFileInputARFFEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputARFFEndJava result = new TFileInputARFFEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\tnb_line_";
  protected final String TEXT_3 = "++;" + NL + "\t\t\t}" + NL + "\t\t}finally{" + NL + "\t\t\tif(bufferedReader_";
  protected final String TEXT_4 = "!=null){" + NL + "\t\t\t\tbufferedReader_";
  protected final String TEXT_5 = ".close();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_6 = "_NB_LINE\",nb_line_";
  protected final String TEXT_7 = ");";
  protected final String TEXT_8 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}
