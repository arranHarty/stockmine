package org.talend.designer.codegen.translators.processing.fields;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class TDenormalizeSortedRowBeginJava
{
  protected static String nl;
  public static synchronized TDenormalizeSortedRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDenormalizeSortedRowBeginJava result = new TDenormalizeSortedRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "int nb_line_";
  protected final String TEXT_3 = " = 0;";
  protected final String TEXT_4 = "final ";
  protected final String TEXT_5 = "Struct[] emmitArray_";
  protected final String TEXT_6 = " = new ";
  protected final String TEXT_7 = "Struct[2];" + NL + "emmitArray_";
  protected final String TEXT_8 = "[0] = new ";
  protected final String TEXT_9 = "Struct();" + NL + "emmitArray_";
  protected final String TEXT_10 = "[1] = new ";
  protected final String TEXT_11 = "Struct();";
  protected final String TEXT_12 = NL + "int currentRowIndex_";
  protected final String TEXT_13 = " = 0;" + NL + "boolean  flag_";
  protected final String TEXT_14 = " = true;//flag for the encounter of first row." + NL;
  protected final String TEXT_15 = " group_";
  protected final String TEXT_16 = "_";
  protected final String TEXT_17 = "=null";
  protected final String TEXT_18 = "=false";
  protected final String TEXT_19 = "=(";
  protected final String TEXT_20 = ")0";
  protected final String TEXT_21 = ";";
  protected final String TEXT_22 = NL + "StringBuilder tempSB_";
  protected final String TEXT_23 = " = new StringBuilder();";
  protected final String TEXT_24 = NL + "java.util.List<";
  protected final String TEXT_25 = "> denormalize_";
  protected final String TEXT_26 = "_";
  protected final String TEXT_27 = " = new java.util.ArrayList<";
  protected final String TEXT_28 = ">();";
  protected final String TEXT_29 = NL + "StringBuilder denormalize_";
  protected final String TEXT_30 = "_";
  protected final String TEXT_31 = " = new StringBuilder();";
  protected final String TEXT_32 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
if ((metadatas!=null)&&(metadatas.size()>0)) {

    IMetadataTable metadata = metadatas.get(0);
    List< ? extends IConnection> inConns = node.getIncomingConnections();
    IMetadataTable inMetadata = null;
    if(inConns != null){ 
    	for (IConnection conn : inConns) { 
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { 
				inMetadata = conn.getMetadataTable();
    			break;
			}
		}
	}
    if (metadata != null && inMetadata != null) { 
    	List<IMetadataColumn> inColumns = inMetadata.getListColumns();
    	Map<String, String> typesMap = new HashMap<String, String>();
    	for(IMetadataColumn column : inColumns){
    		String type = JavaTypesManager.getTypeToGenerate(column.getTalendType(), true);
    		typesMap.put(column.getLabel(), type);
    	}
        List<Map<String, String>> denormalizes = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__DENORMALIZE_COLUMNS__");
        List<String> denormalizeColumns = new ArrayList<String>();
        List<String> denormalizeColumnsType = new ArrayList<String>();
        List<String> denormalizeDelimiters = new ArrayList<String>();
        List<Boolean> denormalizeMergeFlags = new ArrayList<Boolean>();
        List<String> groupColumns = new ArrayList<String>();
        for(Map<String, String> denormalize : denormalizes){
        	String columnName = denormalize.get("INPUT_COLUMN");
        	if(denormalizeColumns.contains(columnName)){
        		continue;
        	}
        	denormalizeColumns.add(columnName);
        	denormalizeColumnsType.add(typesMap.get(columnName));
        	denormalizeDelimiters.add(denormalize.get("DELIMITER"));
        	denormalizeMergeFlags.add(("true").equals(denormalize.get("MERGE")));
        }
        for(IMetadataColumn column : inColumns){
        	String columnName = column.getLabel();
        	if(denormalizeColumns.contains(columnName)){
        		continue;
        	}
        	groupColumns.add(column.getLabel());
        }
        
		List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		if (conns!=null) {
			if (conns.size()>0) {
				IConnection conn = conns.get(0);
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_11);
    
				}
			}
		}

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    	
	//gen groups variable
	for(String columnName : groupColumns){
		String type = typesMap.get(columnName);

    stringBuffer.append(type );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    
if(("String").equals(type) || ("Object").equals(type) || ("java.util.Date").equals(type) || ("byte[]").equals(type) || "BigDecimal".equals(type) || "Double".equals(type) || "Float".equals(type) || "Long".equals(type)){
    stringBuffer.append(TEXT_17);
    }else if(("boolean").equals(type) || ("Boolean").equals(type)){
    stringBuffer.append(TEXT_18);
    }else{
    stringBuffer.append(TEXT_19);
    stringBuffer.append(type );
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
    	}
	
	//gen denormalize variable
	boolean flag = false;
	for(int i = 0; i < denormalizeColumns.size(); i++){
		String columnName = denormalizeColumns.get(i);
		String columnType = denormalizeColumnsType.get(i);
		if(denormalizeMergeFlags.get(i)){
			if(!flag){
				flag = true;

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    
			}

    stringBuffer.append(TEXT_24);
    stringBuffer.append(columnType );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(columnType );
    stringBuffer.append(TEXT_28);
    
		}else{

    stringBuffer.append(TEXT_29);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    
		}
	}
	}
}

    stringBuffer.append(TEXT_32);
    return stringBuffer.toString();
  }
}
