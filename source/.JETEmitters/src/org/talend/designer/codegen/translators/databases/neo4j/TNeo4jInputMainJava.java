package org.talend.designer.codegen.translators.databases.neo4j;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class TNeo4jInputMainJava
{
  protected static String nl;
  public static synchronized TNeo4jInputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNeo4jInputMainJava result = new TNeo4jInputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tjava.util.Map<String, Object> row_";
  protected final String TEXT_2 = " = resultIterator_";
  protected final String TEXT_3 = ".next();";
  protected final String TEXT_4 = NL + "\t\texpression_";
  protected final String TEXT_5 = " = ";
  protected final String TEXT_6 = "!=null?";
  protected final String TEXT_7 = ":\"\";" + NL + "\t\tObject value_";
  protected final String TEXT_8 = " = row_";
  protected final String TEXT_9 = ".get(expression_";
  protected final String TEXT_10 = ");" + NL + "\t\tif (value_";
  protected final String TEXT_11 = " == null) {" + NL + "\t\t\tif(expression_";
  protected final String TEXT_12 = ".contains(\".\")) {" + NL + "\t\t\t\tif (row_";
  protected final String TEXT_13 = ".get(expression_";
  protected final String TEXT_14 = ".split(\"\\\\.\")[0]) != null && row_";
  protected final String TEXT_15 = ".get(expression_";
  protected final String TEXT_16 = ".split(\"\\\\.\")[0]) instanceof org.neo4j.graphdb.PropertyContainer) {" + NL + "\t\t\t\t\torg.neo4j.graphdb.PropertyContainer propertyContainer = (org.neo4j.graphdb.PropertyContainer) row_";
  protected final String TEXT_17 = ".get(expression_";
  protected final String TEXT_18 = ".split(\"\\\\.\")[0]);" + NL + "\t\t\t\t\tvalue_";
  protected final String TEXT_19 = " = propertyContainer.getProperty(expression_";
  protected final String TEXT_20 = ".split(\"\\\\.\")[1]);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_21 = NL + "\t\t\tif (value_";
  protected final String TEXT_22 = " == null) {" + NL + "\t\t\t\t";
  protected final String TEXT_23 = ".";
  protected final String TEXT_24 = " = null;" + NL + "\t\t\t} else {" + NL + "\t\t\t\t";
  protected final String TEXT_25 = NL + "\t\t\t\t\tif (value_";
  protected final String TEXT_26 = " instanceof Number) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_27 = ".";
  protected final String TEXT_28 = " = new java.util.Date(((Number) value_";
  protected final String TEXT_29 = ").longValue());" + NL + "\t\t\t\t\t";
  protected final String TEXT_30 = NL + "\t\t\t\t\t\t} else if (value instanceof String) {" + NL + "\t\t\t\t\t\t\tjava.text.SimpleDateFormat formater = new SimpleDateFormat(\"";
  protected final String TEXT_31 = "\");" + NL + "\t\t\t\t\t\t\ttry {" + NL + "            \t\t\t\t\t";
  protected final String TEXT_32 = ".";
  protected final String TEXT_33 = " = simpleDateFormat.parse(value_";
  protected final String TEXT_34 = ");" + NL + "        \t\t\t\t\t} catch (ParseException e) {" + NL + "            \t\t\t\t\tthrow new RuntimeException(\"Unable to parse date\");" + NL + "        \t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\tthrow new RuntimeException(\"Unable to parse date, review your configuration\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_36 = NL + "\t\t\t\t\tif (value_";
  protected final String TEXT_37 = " instanceof java.util.Collection<?>) {\t\t\t\t" + NL + "\t\t\t\t\t\tjava.util.Collection<?> collection = (java.util.Collection<?>) value_";
  protected final String TEXT_38 = ";\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_39 = ".";
  protected final String TEXT_40 = " = new java.util.ArrayList(collection);" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tthrow new RuntimeException(\"The returned parameter is not a Collection\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_41 = NL + "\t\t\t\t\tif (value_";
  protected final String TEXT_42 = " instanceof String) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_43 = ".";
  protected final String TEXT_44 = " = (String) value_";
  protected final String TEXT_45 = ";" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_46 = ".";
  protected final String TEXT_47 = " = value_";
  protected final String TEXT_48 = ".toString();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\t\t\tif (value_";
  protected final String TEXT_50 = " instanceof Long) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_51 = ".";
  protected final String TEXT_52 = " = (Long) value_";
  protected final String TEXT_53 = ";" + NL + "\t\t\t\t\t} else if (value_";
  protected final String TEXT_54 = " instanceof Double) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_55 = ".";
  protected final String TEXT_56 = " = (Long) Math.round((Double) value_";
  protected final String TEXT_57 = ");" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_58 = ".";
  protected final String TEXT_59 = " = new Long(value_";
  protected final String TEXT_60 = ".toString());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_61 = NL + "\t\t\t\t\tif (value_";
  protected final String TEXT_62 = " instanceof Integer) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_63 = ".";
  protected final String TEXT_64 = " = (Integer) value_";
  protected final String TEXT_65 = ";" + NL + "\t\t\t\t\t} else if (value_";
  protected final String TEXT_66 = " instanceof Double) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_67 = ".";
  protected final String TEXT_68 = " = (int) Math.round((Double) value_";
  protected final String TEXT_69 = ");" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_70 = ".";
  protected final String TEXT_71 = " = new Integer(value_";
  protected final String TEXT_72 = ".toString());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_73 = NL + "\t\t\t\t\tif (value_";
  protected final String TEXT_74 = " instanceof Float) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_75 = ".";
  protected final String TEXT_76 = " = (Float) value_";
  protected final String TEXT_77 = ";" + NL + "\t\t\t\t\t} else if (value_";
  protected final String TEXT_78 = " instanceof Double) {" + NL + "\t\t\t\t\t \t";
  protected final String TEXT_79 = ".";
  protected final String TEXT_80 = " = ((Double) value_";
  protected final String TEXT_81 = ").floatValue();" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_82 = ".";
  protected final String TEXT_83 = " = new Float(value_";
  protected final String TEXT_84 = ".toString());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_85 = NL + "\t\t\t\t\tif (value_";
  protected final String TEXT_86 = " instanceof Boolean) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_87 = ".";
  protected final String TEXT_88 = " = (Boolean) value_";
  protected final String TEXT_89 = ";" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_90 = ".";
  protected final String TEXT_91 = " = new Boolean(value_";
  protected final String TEXT_92 = ".toString());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_93 = NL + "\t\t\t\t\t";
  protected final String TEXT_94 = ".";
  protected final String TEXT_95 = " = value_";
  protected final String TEXT_96 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_97 = NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_98 = NL + "nb_line_";
  protected final String TEXT_99 = "++;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode) codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    List<Map<String, String>> mapping = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__MAPPING__");
    
    // Retrieve internal schema
    List<IMetadataColumn> columns = null;
    List<IMetadataTable> metadatas = node.getMetadataList();    
   	Map<String, IMetadataColumn> columnsMapped = new HashMap<String, IMetadataColumn>();
    if (metadatas != null && metadatas.size() > 0) {
    	IMetadataTable metadata = metadatas.get(0);
    	if (metadata != null){
    		columns = metadata.getListColumns();
    	}
    	for (Map<String, String> rowMapping : mapping) {
	    	String returnParameter = rowMapping.get("RETURN_PARAMETER");
	    	IMetadataColumn column = metadata.getColumn(rowMapping.get("SCHEMA_COLUMN"));
	    	columnsMapped.put(returnParameter, column);
    	}
    }
    
    // Retrieve input and output Talend connections
    List<? extends IConnection> inputs = node.getIncomingConnections();
    List<? extends IConnection> outputs = node.getOutgoingSortedConnections();
    String incomingConnName = null;
    String outgoingConnName = null;
    
    if (inputs.size() > 0) {
    	IConnection in = inputs.get(0);
    	incomingConnName = in.getName();
   	}
   	
   	if (outputs.size() > 0) {
   		IConnection out = outputs.get(0);
   		outgoingConnName = out.getName();
   	}
    

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
	for (Map.Entry<String, IMetadataColumn> columnMapped : columnsMapped.entrySet()) {
		String returnParameter = columnMapped.getKey();	
		IMetadataColumn column = columnMapped.getValue();	
		
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(returnParameter);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(returnParameter);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
		String cType = column.getTalendType();
		if (outgoingConnName != null) {
			
    stringBuffer.append(TEXT_21);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_24);
    
				if (cType.equals("id_Date")) {
					
    stringBuffer.append(TEXT_25);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_29);
    
					if (column.getPattern() != null && !column.getPattern().isEmpty()) {
						
    stringBuffer.append(TEXT_30);
    stringBuffer.append(column.getPattern());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_34);
    
					} else {
						
    stringBuffer.append(TEXT_35);
    
					}
				} else if (cType.equals("id_List")) {
					
    stringBuffer.append(TEXT_36);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_40);
    
				} else if (cType.equals("id_String")) {
					
    stringBuffer.append(TEXT_41);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_48);
    
				} else if (cType.equals("id_Long")) {
					
    stringBuffer.append(TEXT_49);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_60);
    
				} else if (cType.equals("id_Integer")) {
					
    stringBuffer.append(TEXT_61);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_72);
    
				} else if (cType.equals("id_Float")) {
					
    stringBuffer.append(TEXT_73);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_84);
    
				} else if (cType.equals("id_Boolean")) {
					
    stringBuffer.append(TEXT_85);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_92);
    
				} else if (cType.equals("id_Object")) {
					
    stringBuffer.append(TEXT_93);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_96);
    
				}
			
    stringBuffer.append(TEXT_97);
    
		}
	}

    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    return stringBuffer.toString();
  }
}
