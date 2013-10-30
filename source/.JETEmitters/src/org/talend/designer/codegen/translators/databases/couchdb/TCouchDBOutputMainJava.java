package org.talend.designer.codegen.translators.databases.couchdb;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;

public class TCouchDBOutputMainJava
{
  protected static String nl;
  public static synchronized TCouchDBOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCouchDBOutputMainJava result = new TCouchDBOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\ttry{" + NL + "\t\tmap_";
  protected final String TEXT_2 = " = new java.util.HashMap();" + NL + "\t\tnb_line_";
  protected final String TEXT_3 = " ++;";
  protected final String TEXT_4 = NL + "\t\tif(";
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = "!=null){" + NL + "\t\t\tString columnValue_";
  protected final String TEXT_7 = "=";
  protected final String TEXT_8 = ".";
  protected final String TEXT_9 = ".toString();" + NL + "\t\t\ttry{" + NL + "\t\t\t\tmap_";
  protected final String TEXT_10 = ".put(\"";
  protected final String TEXT_11 = "\",org.svenson.JSONParser.defaultJSONParser().parse(columnValue_";
  protected final String TEXT_12 = "));" + NL + "\t\t\t}catch(Exception e_";
  protected final String TEXT_13 = "){" + NL + "\t\t\t\tmap_";
  protected final String TEXT_14 = ".put(\"";
  protected final String TEXT_15 = "\",";
  protected final String TEXT_16 = ".";
  protected final String TEXT_17 = ");" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_18 = NL + "\t\tmap_";
  protected final String TEXT_19 = ".put(\"_id\",";
  protected final String TEXT_20 = ".";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = NL + "\t\tdb_";
  protected final String TEXT_23 = ".createDocument(map_";
  protected final String TEXT_24 = ");";
  protected final String TEXT_25 = NL + "\t\tString rev_";
  protected final String TEXT_26 = "=null;" + NL + "   \t\tdoc_";
  protected final String TEXT_27 = "=org.svenson.JSONParser.defaultJSONParser().parse(org.jcouchdb.document.BaseDocument.class,org.svenson.JSON.defaultJSON().forValue(map_";
  protected final String TEXT_28 = "));" + NL + "  \t\tdoc_";
  protected final String TEXT_29 = ".setId(";
  protected final String TEXT_30 = ".";
  protected final String TEXT_31 = ");";
  protected final String TEXT_32 = NL + "\t\trev_";
  protected final String TEXT_33 = "=db_";
  protected final String TEXT_34 = ".getDocument(org.jcouchdb.document.BaseDocument.class,";
  protected final String TEXT_35 = ".";
  protected final String TEXT_36 = ").getRevision();" + NL + "\t\tdoc_";
  protected final String TEXT_37 = ".setRevision(rev_";
  protected final String TEXT_38 = ");" + NL + "\t\tdb_";
  protected final String TEXT_39 = ".updateDocument(doc_";
  protected final String TEXT_40 = ");";
  protected final String TEXT_41 = NL + "\t\ttry{" + NL + "\t\t\trev_";
  protected final String TEXT_42 = "=db_";
  protected final String TEXT_43 = ".getDocument(org.jcouchdb.document.BaseDocument.class,";
  protected final String TEXT_44 = ".";
  protected final String TEXT_45 = ").getRevision();" + NL + "\t\t}catch(java.lang.Exception e_";
  protected final String TEXT_46 = "){" + NL + "\t\t}" + NL + "\t\tif(rev_";
  protected final String TEXT_47 = "!=null){" + NL + "\t\t\tdoc_";
  protected final String TEXT_48 = ".setRevision(rev_";
  protected final String TEXT_49 = ");" + NL + "\t\t}" + NL + "\t\tdb_";
  protected final String TEXT_50 = ".createOrUpdateDocument(doc_";
  protected final String TEXT_51 = ");";
  protected final String TEXT_52 = NL + "\t\trev_";
  protected final String TEXT_53 = "=db_";
  protected final String TEXT_54 = ".getDocument(org.jcouchdb.document.BaseDocument.class,";
  protected final String TEXT_55 = ".";
  protected final String TEXT_56 = ").getRevision();" + NL + "\t\tdoc_";
  protected final String TEXT_57 = ".setRevision(rev_";
  protected final String TEXT_58 = ");" + NL + "\t\tdb_";
  protected final String TEXT_59 = ".delete(doc_";
  protected final String TEXT_60 = ");";
  protected final String TEXT_61 = NL + "\t}catch(java.lang.Exception e_";
  protected final String TEXT_62 = "){";
  protected final String TEXT_63 = NL + "\t\tthrow e_";
  protected final String TEXT_64 = ";";
  protected final String TEXT_65 = NL + "\t\tSystem.err.println(e_";
  protected final String TEXT_66 = ".getMessage());";
  protected final String TEXT_67 = NL + "\t}";
  protected final String TEXT_68 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;

    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
	String key = ElementParameterParser.getValue(node,"__KEY__");
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
    
				for (int i = 0; i < sizeColumns; i++) {
					IMetadataColumn column = columnList.get(i);
					if(!column.getLabel().equals(key)){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(column.getOriginalDbColumnName() );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(column.getOriginalDbColumnName() );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_17);
    
					}
				}

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_21);
    
               	if("INSERT".equals(dataAction)){

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
                }else {

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_31);
    
                	if("UPDATE".equals(dataAction)){

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    
                	}else if("UPSERT".equals(dataAction)){

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(key);
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
    
					}else{

    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    
					}
				}

    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    
				if(dieOnError){

    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    
				}else{

    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    
				}

    stringBuffer.append(TEXT_67);
    
			}
		}
	}

    stringBuffer.append(TEXT_68);
    return stringBuffer.toString();
  }
}
