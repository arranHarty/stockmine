package org.talend.designer.codegen.translators.bigdata.googlebigquery;

public class TBigQueryInputEndJava
{
  protected static String nl;
  public static synchronized TBigQueryInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TBigQueryInputEndJava result = new TBigQueryInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "  }";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    return stringBuffer.toString();
  }
}
