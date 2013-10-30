package org.talend.designer.codegen.translators.databases.riak;

import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.Map;

public class TRiakOutputMainJava
{
  protected static String nl;
  public static synchronized TRiakOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRiakOutputMainJava result = new TRiakOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\tif(";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = "!=null){" + NL + "\t\t\t\t\tbucket_";
  protected final String TEXT_5 = ".delete(String.valueOf(";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = ")).execute();" + NL + "\t\t\t\t\tdelete_nb_line_";
  protected final String TEXT_8 = "++;" + NL + "\t\t\t\t}";
  protected final String TEXT_9 = NL + "\t\t\tobject_";
  protected final String TEXT_10 = "=new java.util.HashMap<String,Object>();";
  protected final String TEXT_11 = NL + "\t\t\tobject_";
  protected final String TEXT_12 = ".put(\"";
  protected final String TEXT_13 = "\", ";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL + "\t\t\tbucket_";
  protected final String TEXT_17 = ".store(object_";
  protected final String TEXT_18 = ").withoutFetch().execute();";
  protected final String TEXT_19 = NL + "\t\t\tif(";
  protected final String TEXT_20 = ".";
  protected final String TEXT_21 = "!=null){" + NL + "\t\t\t\tbucket_";
  protected final String TEXT_22 = ".store(String.valueOf(";
  protected final String TEXT_23 = ".";
  protected final String TEXT_24 = "), object_";
  protected final String TEXT_25 = ").execute();" + NL + "\t\t\t}else{" + NL + "\t\t\t\tbucket_";
  protected final String TEXT_26 = ".store(object_";
  protected final String TEXT_27 = ").execute();" + NL + "\t\t\t}";
  protected final String TEXT_28 = NL + "\t\t\tupsert_nb_line_";
  protected final String TEXT_29 = "++;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
	
    String cid = node.getUniqueName();
    List<Map<String, String>> valueColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__VALUE_COLUMNS__");
    List<String> valueColumnNames = new java.util.ArrayList<String>();
    
    boolean autoGenKey = "true".equals(ElementParameterParser.getValue(node,"__AUTO_GEN_KEY__"));
    String key = ElementParameterParser.getValue(node,"__KEY__");
    String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
    
  	List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
    java.util.List<IMetadataColumn> tempValuesColumns = new java.util.ArrayList<IMetadataColumn>();
    IConnection inConn = null;
	IMetadataTable metadata = null;
	if(inConns!=null && inConns.size()> 0) {
		inConn = inConns.get(0);
		metadata = inConn.getMetadataTable();
	}
  	List< ? extends IConnection> conns = node.getIncomingConnections();
	for (IConnection conn : conns) {
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	      	if(metadata != null){
	      		if(!"DELETE".equals(dataAction)){
		      		if(valueColumns.size()>0){
			      		for(int i=0;i<valueColumns.size();i++){
				    		Map<String, String> columnValue = valueColumns.get(i);
							valueColumnNames.add(columnValue.get("SCHEMA_COLUMN"));
						}
					}
					for(IMetadataColumn inputCol : metadata.getListColumns()){
						if(valueColumnNames.contains(inputCol.getLabel())){
							tempValuesColumns.add(inputCol);
						}
					}
				}
				int sizeColumns = tempValuesColumns.size();
				if("DELETE".equals(dataAction)){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
				}else{
					if(sizeColumns>0){

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
						for (int i = 0; i < sizeColumns; i++) {
							IMetadataColumn column = tempValuesColumns.get(i);

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_15);
    
						}
						if(autoGenKey){

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
						}else{

    stringBuffer.append(TEXT_19);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
						}
					}

    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
				}
			}
    	}
    }

    return stringBuffer.toString();
  }
}
