package org.talend.designer.codegen.translators.databases.mongodb;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;

public class TMongoDBOutputMainJava
{
  protected static String nl;
  public static synchronized TMongoDBOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMongoDBOutputMainJava result = new TMongoDBOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\t" + NL + "\t\t\t\tcom.mongodb.WriteResult resultMessage_";
  protected final String TEXT_2 = "=null;" + NL + "\t\t\t\tupdateObjectUtil_";
  protected final String TEXT_3 = ".setObject(new com.mongodb.BasicDBObject());";
  protected final String TEXT_4 = NL + "\t\t\t\tqueryObjectUtil_";
  protected final String TEXT_5 = ".setObject(new com.mongodb.BasicDBObject());" + NL + "\t\t\t\tint countKey_";
  protected final String TEXT_6 = "=0;";
  protected final String TEXT_7 = NL + "\t\t\t\t\t\tqueryObjectUtil_";
  protected final String TEXT_8 = ".putkeyNode(pathMap_";
  protected final String TEXT_9 = ".get(\"";
  protected final String TEXT_10 = "\"),\"";
  protected final String TEXT_11 = "\", ";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = ");" + NL + "\t\t\t\t\t\tcountKey_";
  protected final String TEXT_14 = "++;";
  protected final String TEXT_15 = NL + "\t\t\t\t\t" + NL + "      \t\t\t\tupdateObjectUtil_";
  protected final String TEXT_16 = ".put(pathMap_";
  protected final String TEXT_17 = ".get(\"";
  protected final String TEXT_18 = "\"),\"";
  protected final String TEXT_19 = "\", ";
  protected final String TEXT_20 = ".";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = NL + "\t\t\t\tcom.mongodb.BasicDBObject updateObj_";
  protected final String TEXT_23 = " = updateObjectUtil_";
  protected final String TEXT_24 = ".getObject();";
  protected final String TEXT_25 = NL + "\t\t\t\t\tresultMessage_";
  protected final String TEXT_26 = "=coll_";
  protected final String TEXT_27 = ".insert(updateObj_";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = NL + "\t\t\t\t\tif(countKey_";
  protected final String TEXT_30 = " <=0){";
  protected final String TEXT_31 = NL + "\t\t\t\t\t\tthrow new Exception(\"Must have at least one key in schema\");";
  protected final String TEXT_32 = NL + "\t\t\t\t\t\tSystem.err.println(\"Must have at least one key in schema\");";
  protected final String TEXT_33 = NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tcom.mongodb.BasicDBObject queryObj_";
  protected final String TEXT_34 = " = queryObjectUtil_";
  protected final String TEXT_35 = ".getObject();";
  protected final String TEXT_36 = "\t" + NL + "\t\t\t\t\t\tresultMessage_";
  protected final String TEXT_37 = "=coll_";
  protected final String TEXT_38 = ".update(queryObj_";
  protected final String TEXT_39 = ",updateObj_";
  protected final String TEXT_40 = ");";
  protected final String TEXT_41 = "\t" + NL + "\t\t\t\t\t\tresultMessage_";
  protected final String TEXT_42 = "=coll_";
  protected final String TEXT_43 = ".update(queryObj_";
  protected final String TEXT_44 = ",updateObj_";
  protected final String TEXT_45 = ",true,false);";
  protected final String TEXT_46 = "\t" + NL + "\t\t\t\t\t\tresultMessage_";
  protected final String TEXT_47 = "=coll_";
  protected final String TEXT_48 = ".remove(queryObj_";
  protected final String TEXT_49 = ");";
  protected final String TEXT_50 = NL + "\t\t\t\t\t}";
  protected final String TEXT_51 = "\t" + NL + "\t\t\t\tif(resultMessage_";
  protected final String TEXT_52 = "!=null && resultMessage_";
  protected final String TEXT_53 = ".getError()!=null){";
  protected final String TEXT_54 = NL + "\t\t\t\t\tthrow new Exception(resultMessage_";
  protected final String TEXT_55 = ".getError());";
  protected final String TEXT_56 = NL + "\t\t\t\t\tSystem.err.println(resultMessage_";
  protected final String TEXT_57 = ".getError());";
  protected final String TEXT_58 = NL + "\t\t\t\t}" + NL + "\t\t\t\tnb_line_";
  protected final String TEXT_59 = " ++;";
  protected final String TEXT_60 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
	boolean dieOnError = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
	List<? extends IConnection> inConns = node.getIncomingConnections(EConnectionType.FLOW_MAIN);
	IConnection inConn = null;
	IMetadataTable metadata = null;
	
	if(inConns!=null && inConns.size()> 0) {
		inConn = inConns.get(0);
		metadata = inConn.getMetadataTable();
	}
	
	if (metadata!=null) {    
		List< ? extends IConnection> conns = node.getIncomingConnections();
		for (IConnection conn : conns) {
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				List<IMetadataColumn> columnList = metadata.getListColumns();
				int sizeColumns = columnList.size();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
				if(!"INSERT".equalsIgnoreCase(dataAction)){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
				}
				for (int i = 0; i < sizeColumns; i++) {
					IMetadataColumn column = columnList.get(i);
					if (!"INSERT".equalsIgnoreCase(dataAction) && column.isKey()){

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(column.getOriginalDbColumnName() );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
					}

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(column.getOriginalDbColumnName() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_21);
    
  				}

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
				if ("INSERT".equalsIgnoreCase(dataAction)) {

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
				}else {

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
					if(dieOnError){

    stringBuffer.append(TEXT_31);
    
					}else{

    stringBuffer.append(TEXT_32);
    
					}

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
					if("UPDATE".equalsIgnoreCase(dataAction)){	

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    
					}else if("UPSERT".equalsIgnoreCase(dataAction)){

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    
					}else if("DELETE".equalsIgnoreCase(dataAction)){

    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
					}

    stringBuffer.append(TEXT_50);
    
				}

    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    
					if(dieOnError){

    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    
					}else{

    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    
					}

    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    
			}
		}
	}

    stringBuffer.append(TEXT_60);
    return stringBuffer.toString();
  }
}
