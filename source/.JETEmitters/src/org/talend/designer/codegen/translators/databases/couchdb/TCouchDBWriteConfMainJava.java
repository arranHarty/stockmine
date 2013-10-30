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

public class TCouchDBWriteConfMainJava
{
  protected static String nl;
  public static synchronized TCouchDBWriteConfMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCouchDBWriteConfMainJava result = new TCouchDBWriteConfMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\ttry{" + NL + "\t\tmap_";
  protected final String TEXT_2 = "=org.svenson.JSONParser.defaultJSONParser().parse(java.util.Map.class, ";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = ".toString());" + NL + "\t\tmap_";
  protected final String TEXT_5 = ".put(\"_id\",";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = ");";
  protected final String TEXT_8 = NL + "\t\tdb_";
  protected final String TEXT_9 = ".createDocument(map_";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "\t\tString rev_";
  protected final String TEXT_12 = "=null;" + NL + "   \t\tdoc_";
  protected final String TEXT_13 = "=org.svenson.JSONParser.defaultJSONParser().parse(org.jcouchdb.document.BaseDocument.class,org.svenson.JSON.defaultJSON().forValue(map_";
  protected final String TEXT_14 = "));" + NL + "  \t\tdoc_";
  protected final String TEXT_15 = ".setId(";
  protected final String TEXT_16 = ".";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "\t\trev_";
  protected final String TEXT_19 = "=db_";
  protected final String TEXT_20 = ".getDocument(org.jcouchdb.document.BaseDocument.class,";
  protected final String TEXT_21 = ".";
  protected final String TEXT_22 = ").getRevision();" + NL + "\t\tdoc_";
  protected final String TEXT_23 = ".setRevision(rev_";
  protected final String TEXT_24 = ");" + NL + "\t\tdb_";
  protected final String TEXT_25 = ".updateDocument(doc_";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL + "\t\ttry{" + NL + "\t\t\trev_";
  protected final String TEXT_28 = "=db_";
  protected final String TEXT_29 = ".getDocument(org.jcouchdb.document.BaseDocument.class,";
  protected final String TEXT_30 = ".";
  protected final String TEXT_31 = ").getRevision();" + NL + "\t\t}catch(java.lang.Exception e_";
  protected final String TEXT_32 = "){" + NL + "\t\t}" + NL + "\t\tif(rev_";
  protected final String TEXT_33 = "!=null){" + NL + "\t\t\tdoc_";
  protected final String TEXT_34 = ".setRevision(rev_";
  protected final String TEXT_35 = ");" + NL + "\t\t}" + NL + "\t\tdb_";
  protected final String TEXT_36 = ".createOrUpdateDocument(doc_";
  protected final String TEXT_37 = ");";
  protected final String TEXT_38 = NL + "\t\trev_";
  protected final String TEXT_39 = "=db_";
  protected final String TEXT_40 = ".getDocument(org.jcouchdb.document.BaseDocument.class,";
  protected final String TEXT_41 = ".";
  protected final String TEXT_42 = ").getRevision();" + NL + "\t\tdoc_";
  protected final String TEXT_43 = ".setRevision(rev_";
  protected final String TEXT_44 = ");" + NL + "\t\tdb_";
  protected final String TEXT_45 = ".delete(doc_";
  protected final String TEXT_46 = ");";
  protected final String TEXT_47 = NL + "\t\tnb_line_";
  protected final String TEXT_48 = " ++;" + NL + "\t}catch(java.lang.Exception e_";
  protected final String TEXT_49 = "){";
  protected final String TEXT_50 = NL + "\t\tthrow e_";
  protected final String TEXT_51 = ";";
  protected final String TEXT_52 = NL + "\t\tSystem.err.println(e_";
  protected final String TEXT_53 = ".getMessage());";
  protected final String TEXT_54 = NL + "\t}";
  protected final String TEXT_55 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;

    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    cid = cid.replace("_Out", "");
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
	String jsonfield = ElementParameterParser.getValue(node,"__JSONFIELD__");
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

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(jsonfield);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_7);
    
               	if("INSERT".equals(dataAction)){

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
                }else {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_17);
    
                	if("UPDATE".equals(dataAction)){

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
                	}else if("UPSERT".equals(dataAction)){

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
					}else{

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
					}
				}

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
				if(dieOnError){

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
				}else{

    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    
				}

    stringBuffer.append(TEXT_54);
    
			}
		}
	}

    stringBuffer.append(TEXT_55);
    return stringBuffer.toString();
  }
}
