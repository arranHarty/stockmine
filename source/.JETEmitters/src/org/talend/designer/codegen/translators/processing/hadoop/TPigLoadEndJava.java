package org.talend.designer.codegen.translators.processing.hadoop;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TPigLoadEndJava
{
  protected static String nl;
  public static synchronized TPigLoadEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPigLoadEndJava result = new TPigLoadEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "\t\t" + NL + "\t} catch (Exception e) {";
  protected final String TEXT_3 = NL + "\t\t\tSystem.err.println(e.getMessage() +\"\\nCaused by: \\n\\t\"+ e.getCause());";
  protected final String TEXT_4 = NL + "\t\t\tthrow(e);";
  protected final String TEXT_5 = NL + "\t}";
  protected final String TEXT_6 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();

	boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));

    stringBuffer.append(TEXT_2);
    
		if(!dieOnError) {

    stringBuffer.append(TEXT_3);
    
		} else {

    stringBuffer.append(TEXT_4);
    
		}

    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
