package org.talend.designer.codegen.translators.databases.neo4j;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TNeo4jRowEndJava
{
  protected static String nl;
  public static synchronized TNeo4jRowEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNeo4jRowEndJava result = new TNeo4jRowEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\ttx_";
  protected final String TEXT_2 = ".success();" + NL + "\ttx_";
  protected final String TEXT_3 = ".finish();" + NL + "\t" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_4 = "_NB_NODE_INSERTED\", nbNodeInserted_";
  protected final String TEXT_5 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_6 = "_NB_RELATIONSHIP_INSERTED\", nbRelationshipInserted_";
  protected final String TEXT_7 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_8 = "_NB_PROPERTY_UPDATED\", nbPropertiesUpdated_";
  protected final String TEXT_9 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_10 = "_NB_NODE_DELETED\", nbNodeDeleted_";
  protected final String TEXT_11 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_12 = "_NB_RELATIONSHIP_DELETED\", nbRelationshipDeleted_";
  protected final String TEXT_13 = ");" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	
    
    
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}
