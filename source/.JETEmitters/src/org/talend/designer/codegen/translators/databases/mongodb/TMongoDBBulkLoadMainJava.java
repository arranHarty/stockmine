package org.talend.designer.codegen.translators.databases.mongodb;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import java.util.List;
import java.util.Map;

public class TMongoDBBulkLoadMainJava
{
  protected static String nl;
  public static synchronized TMongoDBBulkLoadMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMongoDBBulkLoadMainJava result = new TMongoDBBulkLoadMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\tRuntime runtime_";
  protected final String TEXT_3 = " = Runtime.getRuntime();" + NL + "\t\tStringBuffer comand_";
  protected final String TEXT_4 = "=new StringBuffer();";
  protected final String TEXT_5 = NL + "\t\tcomand_";
  protected final String TEXT_6 = ".append(";
  protected final String TEXT_7 = ");";
  protected final String TEXT_8 = NL + "\t\tcomand_";
  protected final String TEXT_9 = ".append(\"/bin/mongoimport\");";
  protected final String TEXT_10 = NL + "\t\tcomand_";
  protected final String TEXT_11 = ".append(\" --dbpath \"+";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL + "\t\tcomand_";
  protected final String TEXT_14 = ".append(\" --host \"+";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL + "\t\tcomand_";
  protected final String TEXT_17 = ".append(\" --port \"+";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL + "\t\tStringBuffer repHosts_";
  protected final String TEXT_20 = "=new StringBuffer();" + NL + "\t\trepHosts_";
  protected final String TEXT_21 = ".append(";
  protected final String TEXT_22 = "+\"/\");";
  protected final String TEXT_23 = NL + "\t\trepHosts_";
  protected final String TEXT_24 = ".append(\",\");";
  protected final String TEXT_25 = NL + "\t\trepHosts_";
  protected final String TEXT_26 = ".append(";
  protected final String TEXT_27 = ");";
  protected final String TEXT_28 = NL + "\t\trepHosts_";
  protected final String TEXT_29 = ".append(\":\"+";
  protected final String TEXT_30 = ");";
  protected final String TEXT_31 = NL + "\t\tcomand_";
  protected final String TEXT_32 = ".append(\" --host \"+repHosts_";
  protected final String TEXT_33 = ".toString());";
  protected final String TEXT_34 = NL + "\t\tcomand_";
  protected final String TEXT_35 = ".append(\" --db \"+";
  protected final String TEXT_36 = ");";
  protected final String TEXT_37 = NL + "\t\tcomand_";
  protected final String TEXT_38 = ".append(\" --collection \"+";
  protected final String TEXT_39 = ");";
  protected final String TEXT_40 = NL + " \t\tcomand_";
  protected final String TEXT_41 = ".append(\" --username \"+";
  protected final String TEXT_42 = "); ";
  protected final String TEXT_43 = NL + " \t\tcomand_";
  protected final String TEXT_44 = ".append(\" --password \"+";
  protected final String TEXT_45 = "); ";
  protected final String TEXT_46 = NL + "\t\tcomand_";
  protected final String TEXT_47 = ".append(\" --type \"+\"";
  protected final String TEXT_48 = "\");";
  protected final String TEXT_49 = NL + "\t\tcomand_";
  protected final String TEXT_50 = ".append(\" --file \"+";
  protected final String TEXT_51 = ");";
  protected final String TEXT_52 = NL + "\t\tcomand_";
  protected final String TEXT_53 = ".append(\" --drop\");";
  protected final String TEXT_54 = NL + "\t\tcomand_";
  protected final String TEXT_55 = ".append(\" --upsert\");";
  protected final String TEXT_56 = NL + "\t\tcomand_";
  protected final String TEXT_57 = ".append(\" --upsertFields \"+\"";
  protected final String TEXT_58 = "\");";
  protected final String TEXT_59 = NL + "\t\tcomand_";
  protected final String TEXT_60 = ".append(\" --ignoreBlanks\");";
  protected final String TEXT_61 = NL + "\t\tcomand_";
  protected final String TEXT_62 = ".append(\" --fields \"+\"";
  protected final String TEXT_63 = "\");";
  protected final String TEXT_64 = NL + "\t\tcomand_";
  protected final String TEXT_65 = ".append(\" --headerline\");";
  protected final String TEXT_66 = NL + "\t\tcomand_";
  protected final String TEXT_67 = ".append(\" \"+";
  protected final String TEXT_68 = ");";
  protected final String TEXT_69 = NL + "\t\tcomand_";
  protected final String TEXT_70 = ".append(\" \"+";
  protected final String TEXT_71 = ");";
  protected final String TEXT_72 = NL + "\t\tfinal Process process_";
  protected final String TEXT_73 = " = runtime_";
  protected final String TEXT_74 = ".exec(comand_";
  protected final String TEXT_75 = ".toString());" + NL + "" + NL + "\t\tThread normal_";
  protected final String TEXT_76 = " = new Thread() {" + NL + "\t\t\tpublic void run() {" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tjava.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(process_";
  protected final String TEXT_77 = ".getInputStream()));" + NL + "\t\t\t\t\tString line = \"\";" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\twhile((line = reader.readLine()) != null) {";
  protected final String TEXT_78 = NL + "\t\t\t\t\t\t\tSystem.out.println(line);";
  protected final String TEXT_79 = "\t\t\t\t" + NL + "\t\t\t\t\t\t\tint im=line.indexOf(\"imported\");" + NL + "\t\t\t\t\t\t\tint obj=line.indexOf(\"objects\");" + NL + "\t\t\t\t\t\t\tif(im > 0 && obj > 0){" + NL + "\t\t\t\t\t\t\t\tline = line.substring(im+8, obj).trim();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tif(line.matches(\"^[\\\\d]+$\")){" + NL + "\t\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_80 = "_NB_LINE\", Integer.parseInt(line));" + NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_81 = "_NB_LINE\", 0);" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t} finally {" + NL + "\t\t\t\t\t\treader.close();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} catch(java.io.IOException ioe) {" + NL + "\t\t\t\t\tioe.printStackTrace();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tnormal_";
  protected final String TEXT_82 = ".start();";
  protected final String TEXT_83 = NL + "\t\tThread error_";
  protected final String TEXT_84 = " = new Thread() {" + NL + "\t\t\tpublic void run() {" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tjava.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(process_";
  protected final String TEXT_85 = ".getErrorStream()));" + NL + "\t\t\t\t\tString line = \"\";" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\twhile((line = reader.readLine()) != null) {" + NL + "\t\t\t\t\t\t\tSystem.err.println(line);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t} finally {" + NL + "\t\t\t\t\t\treader.close();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} catch(java.io.IOException ioe) {" + NL + "\t\t\t\t\tioe.printStackTrace();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\terror_";
  protected final String TEXT_86 = ".start();";
  protected final String TEXT_87 = "\t\t\t" + NL + "\t\tprocess_";
  protected final String TEXT_88 = ".waitFor();" + NL + "\t\tnormal_";
  protected final String TEXT_89 = ".interrupt();";
  protected final String TEXT_90 = NL + "\t\terror_";
  protected final String TEXT_91 = ".interrupt();";
  protected final String TEXT_92 = "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
  	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
  	INode node = (INode)codeGenArgument.getArgument();
  	String cid = node.getUniqueName();

    String dbhost   = ElementParameterParser.getValue(node, "__HOST__");
    String dbname   = ElementParameterParser.getValue(node, "__DATABASE__");
    String collection = ElementParameterParser.getValue(node,"__COLLECTION__");
    boolean authentication="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__REQUIRED_AUTHENTICATION__"));
    String dbuser   = ElementParameterParser.getValue(node, "__USERNAME__");
    String dbpass   = ElementParameterParser.getValue(node, "__PASSWORD__");
    String dbport  	= ElementParameterParser.getValue(node, "__PORT__");
  	String mongoBinFolder = ElementParameterParser.getValue(node, "__MONGODB_DIR__");
  	String dataFileName = ElementParameterParser.getValue(node, "__DATA__");
  	String fileType = ElementParameterParser.getValue(node, "__FILE_TYPE__");
  	boolean isFirstLineHeader = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__HEADERLINE__"));
  	boolean useReplicaSet="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_REPLICA_SET__"));
  	boolean useLocalDBpath="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_LOCAL_DBPATH__"));
  	String localDBpath=ElementParameterParser.getValue(node, "__LOCAL_DB_PATH__");
  	boolean printLog="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__PRINT_LOG__"));
  	boolean dropCreateColl="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__DROP_COLLECTION_CREATE__"));
  	boolean ignoreBlanks="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__IGNORE_BLANKS__"));
  	
  	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
  	List<Map<String, String>> additionalParams = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADDITIONAL_ARGS__");
  	
  	List<IMetadataTable> metadatas = node.getMetadataList();
  	String fileds="";
  	if(!"JSON".equalsIgnoreCase(fileType) && metadatas != null && metadatas.size() > 0){
      	IMetadataTable metadata = metadatas.get(0);
      	if(metadata != null){
      		List<IMetadataColumn> columnList = metadata.getListColumns();
      		boolean isFirstColumn=true;
      		for (IMetadataColumn column:columnList) {
      			if(isFirstColumn){
      				isFirstColumn=false;
      			}else{
      				fileds=fileds+",";
      			}
      			fileds=fileds + column.getOriginalDbColumnName();
			}
		}
	}
  	

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    	
	if(mongoBinFolder!= null && !"".equals(mongoBinFolder)&& !"\"\"".equals(mongoBinFolder)){

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(mongoBinFolder);
    stringBuffer.append(TEXT_7);
    
	}

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    	
	if(useLocalDBpath){

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(localDBpath);
    stringBuffer.append(TEXT_12);
    
	}else{
		if(!useReplicaSet){
			if(dbhost!= null && !"".equals(dbhost)&& !"\"\"".equals(dbhost)){

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_15);
    	
			}
			if(dbport!= null && !"".equals(dbport)&& !"\"\"".equals(dbport)){

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_18);
    
			}
		}else{
			String replicaSetName = ElementParameterParser.getValue(node, "__REPLICA_NAME__");

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(replicaSetName);
    stringBuffer.append(TEXT_22);
    
		  	List<Map<String,String>> replicaAddrs= (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__REPLICA_SET__");
		  	boolean isFirstHost=true;
		  	for(Map<String,String> replicaAddr:replicaAddrs){
		  		String repHost = replicaAddr.get("REPLICA_HOST");
		  		String repPort = replicaAddr.get("REPLICA_PORT");
				if(repHost!= null && !"".equals(repHost)&& !"\"\"".equals(repHost)){
					if(isFirstHost){
						isFirstHost=false;
					}else{

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
					}

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(repHost);
    stringBuffer.append(TEXT_27);
    
					if(repPort!= null && !"".equals(repPort)&& !"\"\"".equals(repPort)){

    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(repPort);
    stringBuffer.append(TEXT_30);
    
					}
				}else{
					break;
				}
		  	}

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
		}
	}
	
	if(dbname!= null && !"".equals(dbname)&& !"\"\"".equals(dbname)){

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_36);
    
	}
	if(collection!= null && !"".equals(collection)&& !"\"\"".equals(collection)){

    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(collection);
    stringBuffer.append(TEXT_39);
    
	}
	if (authentication){
		if(dbuser!= null && !"".equals(dbuser)&& !"\"\"".equals(dbuser)){

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_42);
    
		}
		if(dbpass!= null && !"".equals(dbpass)&& !"\"\"".equals(dbpass)){

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(dbpass);
    stringBuffer.append(TEXT_45);
    
		}
	}
	if(fileType!= null && !"".equals(fileType)&& !"\"\"".equals(fileType)){

    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(fileType);
    stringBuffer.append(TEXT_48);
    
	}
	if(dataFileName!= null && !"".equals(dataFileName)&& !"\"\"".equals(dataFileName)){

    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(dataFileName);
    stringBuffer.append(TEXT_51);
    
	}
	if(dropCreateColl){

    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    
	}
	if("UPSERT".equalsIgnoreCase(dataAction)){
		List<Map<String, String>> upsertFieldList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__UPSERT_FIELDS__");
		String upsertFields = "";
		if(upsertFieldList!=null && upsertFieldList.size()>0){
			upsertFields = upsertFieldList.get(0).get("COLNAME");
			for(int i=1;i<upsertFieldList.size();i++){
				Map<String, String> field = upsertFieldList.get(i);
				upsertFields=upsertFields+","+field.get("COLNAME");
			}
		}

    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    
		if(!"".equals(upsertFields)){

    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(upsertFields);
    stringBuffer.append(TEXT_58);
    
		}
	}
	if(!"JSON".equalsIgnoreCase(fileType)){
		if(ignoreBlanks){

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    
		}
		if(!"".equals(fileds)){

    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(fileds);
    stringBuffer.append(TEXT_63);
    
		}
		if(isFirstLineHeader){

    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    
		}
	}
	if(additionalParams != null && additionalParams.size()>0){
		for(Map<String, String> param : additionalParams){
			String arg = param.get("ARGUMENT");
			String value = param.get("VALUE");
			if(arg!=null && !"".equals(arg)){

    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(arg);
    stringBuffer.append(TEXT_68);
    
				if(value!=null && !"".equals(value)){

    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_71);
    
				}
			}
		}
	}

    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    
    if(printLog){

    stringBuffer.append(TEXT_78);
    
    }

    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
    if(printLog){

    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    
    }

    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
    if(printLog){

    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    
    }

    stringBuffer.append(TEXT_92);
    return stringBuffer.toString();
  }
}
