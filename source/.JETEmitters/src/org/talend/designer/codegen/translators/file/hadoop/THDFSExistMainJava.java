package org.talend.designer.codegen.translators.file.hadoop;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class THDFSExistMainJava
{
  protected static String nl;
  public static synchronized THDFSExistMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THDFSExistMainJava result = new THDFSExistMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t";
  protected final String TEXT_2 = NL + "\t" + NL + "\tString hdfsDir_";
  protected final String TEXT_3 = " = ";
  protected final String TEXT_4 = ".replaceAll(\"\\\\\\\\\",\"/\");" + NL + "\torg.apache.hadoop.fs.Path path_";
  protected final String TEXT_5 = " = new org.apache.hadoop.fs.Path(";
  protected final String TEXT_6 = " + \"/\" + ";
  protected final String TEXT_7 = ");" + NL + "\tif(fs_";
  protected final String TEXT_8 = ".exists(path_";
  protected final String TEXT_9 = ")){" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_10 = "_EXISTS\", true);" + NL + "\t}else{" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_11 = "_EXISTS\", false);" + NL + "\t}" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_12 = "_FILENAME\",";
  protected final String TEXT_13 = ");" + NL + "" + NL + "" + NL + "\t";
  protected final String TEXT_14 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String hdfsDir = ElementParameterParser.getValue(node, "__HDFSDIR__");
	String filename = ElementParameterParser.getValue(node, "__FILENAME__");
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(hdfsDir );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(hdfsDir );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(TEXT_14);
    return stringBuffer.toString();
  }
}
