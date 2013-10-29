package org.talend.designer.codegen.translators.orchestration;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TForeachBeginJava
{
  protected static String nl;
  public static synchronized TForeachBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TForeachBeginJava result = new TForeachBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "Object[] values_";
  protected final String TEXT_3 = " = new Object[]{";
  protected final String TEXT_4 = NL + "    ";
  protected final String TEXT_5 = ",";
  protected final String TEXT_6 = NL + "};" + NL + "" + NL + "for(Object tmp_";
  protected final String TEXT_7 = " :values_";
  protected final String TEXT_8 = ") {" + NL + "    globalMap.put(\"";
  protected final String TEXT_9 = "_CURRENT_VALUE\", tmp_";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
        List<Map<String, String>> values =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,
                "__VALUES__"
            );

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
        for (int i=0; i<values.size(); i++) {
            Map<String, String> line = values.get(i);

    stringBuffer.append(TEXT_4);
    stringBuffer.append( line.get("VALUE") );
    stringBuffer.append(TEXT_5);
    
        }

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}
