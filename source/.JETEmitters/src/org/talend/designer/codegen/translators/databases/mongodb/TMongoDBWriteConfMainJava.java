package org.talend.designer.codegen.translators.databases.mongodb;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import java.util.List;

public class TMongoDBWriteConfMainJava
{
  protected static String nl;
  public static synchronized TMongoDBWriteConfMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMongoDBWriteConfMainJava result = new TMongoDBWriteConfMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\tcom.mongodb.WriteResult resultMessage_";
  protected final String TEXT_2 = "=null;" + NL + "\t\t\tObject data_";
  protected final String TEXT_3 = "=com.mongodb.util.JSON.parse(json_";
  protected final String TEXT_4 = ".toString());" + NL + "\t\t\tObject queryObj_";
  protected final String TEXT_5 = "=null;" + NL + "\t\t\tif(data_";
  protected final String TEXT_6 = "!=null){";
  protected final String TEXT_7 = NL + "\t\t\t\tresultMessage_";
  protected final String TEXT_8 = "=coll_";
  protected final String TEXT_9 = ".insert((com.mongodb.DBObject)data_";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "\t\t\t\tresultMessage_";
  protected final String TEXT_12 = "=coll_";
  protected final String TEXT_13 = ".remove((com.mongodb.DBObject)data_";
  protected final String TEXT_14 = ");";
  protected final String TEXT_15 = NL + "\t\t\t\tqueryObj_";
  protected final String TEXT_16 = " =((com.mongodb.DBObject)data_";
  protected final String TEXT_17 = ").get(";
  protected final String TEXT_18 = ");" + NL + "\t\t\t\tdata_";
  protected final String TEXT_19 = "=((com.mongodb.DBObject)data_";
  protected final String TEXT_20 = ").get(";
  protected final String TEXT_21 = ");" + NL + "\t\t\t\tif(data_";
  protected final String TEXT_22 = "!=null && queryObj_";
  protected final String TEXT_23 = "!=null){";
  protected final String TEXT_24 = "\t" + NL + "\t\t\t\t\tresultMessage_";
  protected final String TEXT_25 = "=coll_";
  protected final String TEXT_26 = ".update((com.mongodb.DBObject)queryObj_";
  protected final String TEXT_27 = ",(com.mongodb.DBObject)data_";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = "\t" + NL + "\t\t\t\t\tresultMessage_";
  protected final String TEXT_30 = "=coll_";
  protected final String TEXT_31 = ".update((com.mongodb.DBObject)queryObj_";
  protected final String TEXT_32 = ",(com.mongodb.DBObject)data_";
  protected final String TEXT_33 = ",true,false);";
  protected final String TEXT_34 = "\t" + NL + "\t\t\t\t}else{";
  protected final String TEXT_35 = NL + "\t\t\t\t\tthrow new Exception(\"Data node or Query node configuration error! \");";
  protected final String TEXT_36 = NL + "\t\t\t\t\tSystem.err.println(\"Data node or Query node configuration error!\");";
  protected final String TEXT_37 = "\t" + NL + "\t\t\t\t}";
  protected final String TEXT_38 = NL + "\t\t\t\t\tif(resultMessage_";
  protected final String TEXT_39 = "!=null && resultMessage_";
  protected final String TEXT_40 = ".getError()!=null){";
  protected final String TEXT_41 = NL + "\t\t\t\t\t\tthrow new Exception(resultMessage_";
  protected final String TEXT_42 = ".getError());";
  protected final String TEXT_43 = NL + "\t\t\t\t\t\tSystem.err.println(resultMessage_";
  protected final String TEXT_44 = ".getError());";
  protected final String TEXT_45 = NL + "\t\t\t\t\t}" + NL + "\t\t\t}else{";
  protected final String TEXT_46 = NL + "\t\t\t\t\tthrow new Exception(\"There no data in json,Please check the json configuration\");";
  protected final String TEXT_47 = NL + "\t\t\t\t\tSystem.err.println(\"There no data in json,Please check the json configuration\");";
  protected final String TEXT_48 = "\t" + NL + "\t\t\t}\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
	String dataNode = ElementParameterParser.getValue(node,"__DATA_NODE__");
	String queryNode = ElementParameterParser.getValue(node,"__QUERY_NODE__");
	boolean dieOnError = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
    List<IMetadataTable> metadatas = node.getMetadataList();
  	if(metadatas != null && metadatas.size() > 0){
      	IMetadataTable metadata = metadatas.get(0);
      	if(metadata != null){

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
			if("Insert".equalsIgnoreCase(dataAction)){

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
			}else if("DELETE".equalsIgnoreCase(dataAction)){

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
			}else{

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(queryNode);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(dataNode);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
				if("UPDATE".equalsIgnoreCase(dataAction)){	

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
				}else if("UPSERT".equalsIgnoreCase(dataAction)){

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
				}

    stringBuffer.append(TEXT_34);
    
				if(dieOnError){

    stringBuffer.append(TEXT_35);
    
				}else{

    stringBuffer.append(TEXT_36);
    
				}

    stringBuffer.append(TEXT_37);
    
			}

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    
				if(dieOnError){

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
				}else{

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
				}

    stringBuffer.append(TEXT_45);
    
				if(dieOnError){

    stringBuffer.append(TEXT_46);
    
				}else{

    stringBuffer.append(TEXT_47);
    
				}

    stringBuffer.append(TEXT_48);
    
		}
	}

    return stringBuffer.toString();
  }
}
