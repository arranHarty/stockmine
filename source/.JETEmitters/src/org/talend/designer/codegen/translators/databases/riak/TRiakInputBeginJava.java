package org.talend.designer.codegen.translators.databases.riak;

import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.Map;

public class TRiakInputBeginJava
{
  protected static String nl;
  public static synchronized TRiakInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRiakInputBeginJava result = new TRiakInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tcom.basho.riak.client.IRiakClient client_";
  protected final String TEXT_3 = " = null;" + NL + "\tint nb_line_";
  protected final String TEXT_4 = " = 0;";
  protected final String TEXT_5 = NL + "\tclient_";
  protected final String TEXT_6 = " = (com.basho.riak.client.IRiakClient)globalMap.get(\"client_";
  protected final String TEXT_7 = "\");";
  protected final String TEXT_8 = NL + "\ttry{" + NL + "\t\tcom.basho.riak.client.raw.http.HTTPClusterConfig  clusterConfig_";
  protected final String TEXT_9 = " = new com.basho.riak.client.raw.http.HTTPClusterConfig(com.basho.riak.client.raw.config.ClusterConfig.UNLIMITED_CONNECTIONS);";
  protected final String TEXT_10 = NL + "\t\tcom.basho.riak.client.raw.http.HTTPClientConfig clientConfig_";
  protected final String TEXT_11 = "_";
  protected final String TEXT_12 = " = new com.basho.riak.client.raw.http.HTTPClientConfig.Builder()";
  protected final String TEXT_13 = NL + "\t\t\t.withPort(";
  protected final String TEXT_14 = ")";
  protected final String TEXT_15 = NL + "\t\t\t.withRiakPath(";
  protected final String TEXT_16 = ")";
  protected final String TEXT_17 = NL + "\t\t\t.build();" + NL + "\t\t\tclusterConfig_";
  protected final String TEXT_18 = ".addHosts(clientConfig_";
  protected final String TEXT_19 = "_";
  protected final String TEXT_20 = ", ";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = NL + "\t\tclient_";
  protected final String TEXT_23 = " =com.basho.riak.client.RiakFactory.newClient(clusterConfig_";
  protected final String TEXT_24 = ");" + NL + "\t\tclient_";
  protected final String TEXT_25 = ".ping();";
  protected final String TEXT_26 = NL + "\t\tcom.basho.riak.client.bucket.Bucket bucket_";
  protected final String TEXT_27 = " = client_";
  protected final String TEXT_28 = ".fetchBucket(";
  protected final String TEXT_29 = ").execute();" + NL + "\t\tjava.util.List<String> keys_";
  protected final String TEXT_30 = "=new java.util.ArrayList<String>();";
  protected final String TEXT_31 = NL + "\t\tkeys_";
  protected final String TEXT_32 = ".add(";
  protected final String TEXT_33 = ");";
  protected final String TEXT_34 = NL + "\t\tcom.basho.riak.client.query.StreamingOperation<String> keysStreamOpts_";
  protected final String TEXT_35 = " = bucket_";
  protected final String TEXT_36 = ".keys();" + NL + "\t\tkeys_";
  protected final String TEXT_37 = " = keysStreamOpts_";
  protected final String TEXT_38 = ".getAll();";
  protected final String TEXT_39 = NL + "\t\tfor(String key_";
  protected final String TEXT_40 = ":keys_";
  protected final String TEXT_41 = "){" + NL + "\t\t\tnb_line_";
  protected final String TEXT_42 = "++;" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_43 = "_CURRENT_KEY\", key_";
  protected final String TEXT_44 = ");";
  protected final String TEXT_45 = NL + "\t\t\t\tObject valueCol_";
  protected final String TEXT_46 = "=null;" + NL + "\t\t\t\tjava.util.Map valueObj_";
  protected final String TEXT_47 = "=null;" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\tvalueObj_";
  protected final String TEXT_48 = "= bucket_";
  protected final String TEXT_49 = ".fetch(key_";
  protected final String TEXT_50 = ",java.util.HashMap.class).execute();" + NL + "\t\t\t\t}catch(java.lang.Exception e_";
  protected final String TEXT_51 = "){" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif(valueObj_";
  protected final String TEXT_52 = "!=null){";
  protected final String TEXT_53 = NL + "\t\t\t\t\tvalueCol_";
  protected final String TEXT_54 = " = key_";
  protected final String TEXT_55 = ";";
  protected final String TEXT_56 = NL + "\t\t\t\t\tvalueCol_";
  protected final String TEXT_57 = "=valueObj_";
  protected final String TEXT_58 = ".get(\"";
  protected final String TEXT_59 = "\");";
  protected final String TEXT_60 = NL + "\t\t\t\t\t";
  protected final String TEXT_61 = ".";
  protected final String TEXT_62 = " = valueCol_";
  protected final String TEXT_63 = ";";
  protected final String TEXT_64 = NL + "\t\t\t\t\tif(valueCol_";
  protected final String TEXT_65 = "!=null ) {";
  protected final String TEXT_66 = NL + "\t\t\t\t\t\tif(valueCol_";
  protected final String TEXT_67 = " instanceof Long){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_68 = ".";
  protected final String TEXT_69 = " = ParserUtils.parseTo_Date(new java.util.Date((Long)valueCol_";
  protected final String TEXT_70 = "), ";
  protected final String TEXT_71 = ");" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_72 = ".";
  protected final String TEXT_73 = " = ";
  protected final String TEXT_74 = ";" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_75 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_76 = ".";
  protected final String TEXT_77 = " = (new sun.misc.BASE64Decoder()).decodeBuffer(valueCol_";
  protected final String TEXT_78 = ".toString());";
  protected final String TEXT_79 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_80 = ".";
  protected final String TEXT_81 = " = valueCol_";
  protected final String TEXT_82 = ".toString();";
  protected final String TEXT_83 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_84 = ".";
  protected final String TEXT_85 = " = ParserUtils.parseTo_";
  protected final String TEXT_86 = "(valueCol_";
  protected final String TEXT_87 = ".toString());";
  protected final String TEXT_88 = NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_89 = ".";
  protected final String TEXT_90 = " = ";
  protected final String TEXT_91 = ";" + NL + "\t\t\t\t\t}";
  protected final String TEXT_92 = NL + "\t\t\t\t}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
	
    String cid = node.getUniqueName();
    List<Map<String, String>> riakNodes = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__NODES__");
    List<Map<String, String>> valueColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__VALUE_COLUMNS__");
    List<String> valueColumnNames = new java.util.ArrayList<String>();
    
    boolean useExistingConn = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
    boolean outPutKey = "true".equals(ElementParameterParser.getValue(node,"__OUTPUT_KEY_COLUMN__"));
    
    String bucket = ElementParameterParser.getValue(node,"__BUCKET__");
    String key = ElementParameterParser.getValue(node,"__KEY__");
    String outKeyCol = ElementParameterParser.getValue(node,"__OUTPUT_KEY__");
    
    List<IMetadataTable> metadatas = node.getMetadataList();
  	List<? extends IConnection> outputs = node.getOutgoingSortedConnections();
  	String firstConnName = "";
  	if (outputs.size() > 0){
		IConnection out = outputs.get(0);
		if(out!=null && out.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
			firstConnName = out.getName();
		}
    }
    
    java.util.List<IMetadataColumn> tempValuesColumns = new java.util.ArrayList<IMetadataColumn>();
	if(metadatas != null && metadatas.size() > 0){
      	IMetadataTable metadata = metadatas.get(0);
      	if(metadata != null){
      		for(int i=0;i<valueColumns.size();i++){
	    		Map<String, String> columnValue = valueColumns.get(i);
				valueColumnNames.add(columnValue.get("SCHEMA_COLUMN"));
			}
			for(IMetadataColumn inputCol : metadata.getListColumns()){
				if(valueColumnNames.contains(inputCol.getLabel()) || (outPutKey && inputCol.getLabel().equals(outKeyCol))){
					tempValuesColumns.add(inputCol);
				}
			}

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
			if(useExistingConn){
				String connection = ElementParameterParser.getValue(node, "__CONNECTION__");

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_7);
    
			}else{

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
		    	if(riakNodes.size()>0){
			    	for(int i=0;i<riakNodes.size();i++){
			    		Map<String, String> riakNode = riakNodes.get(i);
						String host =riakNode.get("HOST");
						String port =riakNode.get("PORT");
						String riakPath =riakNode.get("RIAK_PATH");
						if(host!=null && host.trim().length()>0 && !"\"\"".equals(host)){

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_12);
    
							if(port!=null && port.trim().length()>0){

    stringBuffer.append(TEXT_13);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_14);
    
							}
							if(riakPath!=null && riakPath.trim().length()>0 && !"\"\"".equals(riakPath)){

    stringBuffer.append(TEXT_15);
    stringBuffer.append(riakPath);
    stringBuffer.append(TEXT_16);
    
							}

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_21);
    
						}
					}

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
				}
    		}

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(bucket);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
		if(key!=null && !"".equals(key) && !"\"\"".equals(key)){

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_33);
    
		}else{

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
		}

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
			if(firstConnName.length()>0) {

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    				
				for (IMetadataColumn column:tempValuesColumns) {
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
					if(outPutKey && outKeyCol!=null && outKeyCol.equals(column.getLabel())){

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    
					}else{

    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_59);
    
					}
          			if(javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_60);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    
          			}else{

    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    
						if(javaType == JavaTypesManager.DATE) {

    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_74);
    
						}else if(javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(TEXT_75);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    
						} else if(javaType == JavaTypesManager.STRING){

    stringBuffer.append(TEXT_79);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
						} else {

    stringBuffer.append(TEXT_83);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    
						}

    stringBuffer.append(TEXT_88);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_91);
    
          			}
				}

    stringBuffer.append(TEXT_92);
    
			}
    	}
    }

    return stringBuffer.toString();
  }
}
