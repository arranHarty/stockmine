package org.talend.designer.codegen.translators.databases.neo4j;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class TNeo4jOutputEndJava
{
  protected static String nl;
  public static synchronized TNeo4jOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNeo4jOutputEndJava result = new TNeo4jOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\ttx_";
  protected final String TEXT_2 = ".success();" + NL + "\ttx_";
  protected final String TEXT_3 = ".finish();" + NL + "\t";
  protected final String TEXT_4 = NL + "\t\tdatabaseService_";
  protected final String TEXT_5 = ".shutdown();" + NL + "\t\t";
  protected final String TEXT_6 = NL + "\t\t\tdatabaseService_";
  protected final String TEXT_7 = ".shutdown();" + NL + "\t\t";
  protected final String TEXT_8 = NL + "\t    \tindexInserterMap_";
  protected final String TEXT_9 = ".get(";
  protected final String TEXT_10 = ").flush();" + NL + "\t    \t";
  protected final String TEXT_11 = NL + "\t\tindexProvider_";
  protected final String TEXT_12 = ".shutdown();" + NL + "\t\tinserter_";
  protected final String TEXT_13 = ".shutdown();" + NL + "\t\t";
  protected final String TEXT_14 = NL + "\t\t\tdatabaseService_";
  protected final String TEXT_15 = " = new org.neo4j.kernel.EmbeddedGraphDatabase(storeDir_";
  protected final String TEXT_16 = ");" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_17 = "\", databaseService_";
  protected final String TEXT_18 = ");" + NL + "\t\t\t";
  protected final String TEXT_19 = NL + "globalMap.put(\"";
  protected final String TEXT_20 = "_NB_LINE\", nb_line_";
  protected final String TEXT_21 = ");";

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
    
    
    boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__"));
    boolean batchImport = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__BATCH_IMPORT__"));
    boolean shutdownDb = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SHUTDOWN_DB__"));
    String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
    String dbconn = "dbService_" + connection;
    List<Map<String, String>> values = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__VALUES__");

	if (!useExistingConnection && !batchImport) {
		
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
	} else {		
		if (shutdownDb) {
		
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
		}
	}
	if (batchImport) {
		Set<String> indexNames = new HashSet();
	    for (Map<String, String> value : values) {
	   		String strIndexNames = value.get("INDEX_NAMES");
	   		if (strIndexNames != null && !strIndexNames.isEmpty()) {
	   			indexNames.addAll(Arrays.asList(strIndexNames.split(",")));
	   		}
	    }
	    for (String indexName : indexNames) {
	    	
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(indexName);
    stringBuffer.append(TEXT_10);
    
	    }
		// Must shutdown database to prevent data corruption after batch importation
		
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
		if (useExistingConnection && !shutdownDb) {
			
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(dbconn);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
		}
	}

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    return stringBuffer.toString();
  }
}
