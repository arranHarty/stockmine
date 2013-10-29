package org.talend.designer.codegen.translators.databases.db_generic;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TDBInputEndJava
{
  protected static String nl;
  public static synchronized TDBInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDBInputEndJava result = new TDBInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "}" + NL + "stmt_";
  protected final String TEXT_3 = ".close();" + NL;
  protected final String TEXT_4 = NL + "\t\tconn_";
  protected final String TEXT_5 = ".commit();";
  protected final String TEXT_6 = NL + "\t\tif(conn_";
  protected final String TEXT_7 = " != null && !conn_";
  protected final String TEXT_8 = ".isClosed()) {" + NL + "\t\t\tconn_";
  protected final String TEXT_9 = " .close();" + NL + "\t\t}";
  protected final String TEXT_10 = NL + "globalMap.put(\"";
  protected final String TEXT_11 = "_NB_LINE\",nb_line_";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    	
	if(!useExistingConn){
		String useCursor = ElementParameterParser.getValue(node, "__USE_CURSOR__");
    	if(("true").equals(useCursor)) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
		}

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
	}

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}
