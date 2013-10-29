package org.talend.designer.codegen.translators.business.bonita;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaTypesManager;

public class TBonitaInstantiateProcessMainJava
{
  protected static String nl;
  public static synchronized TBonitaInstantiateProcessMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TBonitaInstantiateProcessMainJava result = new TBonitaInstantiateProcessMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "parameters_";
  protected final String TEXT_3 = ".append(\"&variables=<map>\");";
  protected final String TEXT_4 = NL + "parameters_";
  protected final String TEXT_5 = ".append(\"<entry><string>";
  protected final String TEXT_6 = "</string><string>\");";
  protected final String TEXT_7 = NL + "if(";
  protected final String TEXT_8 = ".";
  protected final String TEXT_9 = " != null) {";
  protected final String TEXT_10 = NL + "parameters_";
  protected final String TEXT_11 = ".append(\"<![CDATA[\");" + NL + "parameters_";
  protected final String TEXT_12 = ".append(java.net.URLEncoder.encode(java.net.URLEncoder.encode(String.valueOf(";
  protected final String TEXT_13 = ".";
  protected final String TEXT_14 = "), utf8Charset),utf8Charset));" + NL + "parameters_";
  protected final String TEXT_15 = ".append(\"]]>\");";
  protected final String TEXT_16 = NL + "}";
  protected final String TEXT_17 = NL + "parameters_";
  protected final String TEXT_18 = ".append(\"</string></entry>\");";
  protected final String TEXT_19 = NL + "parameters_";
  protected final String TEXT_20 = ".append(\"</map>\");";
  protected final String TEXT_21 = NL + "\t\t\t\t\t\t\t\tparameters_";
  protected final String TEXT_22 = ".put(\"";
  protected final String TEXT_23 = "\", ";
  protected final String TEXT_24 = ".";
  protected final String TEXT_25 = ");";
  protected final String TEXT_26 = NL + "\t\tjava.io.DataOutputStream output_";
  protected final String TEXT_27 = " = new java.io.DataOutputStream(httpConn_";
  protected final String TEXT_28 = ".getOutputStream());" + NL + "\t\toutput_";
  protected final String TEXT_29 = ".writeBytes(parameters_";
  protected final String TEXT_30 = ".toString());" + NL + "\t\toutput_";
  protected final String TEXT_31 = ".flush();" + NL + "\t\tif (output_";
  protected final String TEXT_32 = " != null) {" + NL + "\t\t\toutput_";
  protected final String TEXT_33 = ".close();" + NL + "\t\t\toutput_";
  protected final String TEXT_34 = " = null;" + NL + "\t\t}" + NL + "\t    int responseCode_";
  protected final String TEXT_35 = " = httpConn_";
  protected final String TEXT_36 = ".getResponseCode();" + NL + "\t    " + NL + "\t    if(responseCode_";
  protected final String TEXT_37 = " != java.net.HttpURLConnection.HTTP_OK){" + NL + "\t    \tSystem.out.println(\"----------\\nRequest failled: \" + responseCode_";
  protected final String TEXT_38 = "+ \"----------\");" + NL + "\t      \tthrow new java.lang.Exception(\"Request the url:\" + url_";
  protected final String TEXT_39 = " + \" failed: \" + responseCode_";
  protected final String TEXT_40 = ");" + NL + "\t    } else {" + NL + "\t      \tjava.io.InputStream is_";
  protected final String TEXT_41 = " = httpConn_";
  protected final String TEXT_42 = ".getInputStream();" + NL + "\t      \tjavax.xml.xpath.XPath xPath_";
  protected final String TEXT_43 = " = javax.xml.xpath.XPathFactory.newInstance().newXPath();" + NL + "\t      \torg.xml.sax.InputSource inputSource_";
  protected final String TEXT_44 = " = new org.xml.sax.InputSource(is_";
  protected final String TEXT_45 = ");" + NL + "\t      \tprocessInstanceUUID_";
  protected final String TEXT_46 = " = (String) xPath_";
  protected final String TEXT_47 = ".evaluate(\"/ProcessInstanceUUID/value/text()\", inputSource_";
  protected final String TEXT_48 = ", javax.xml.xpath.XPathConstants.STRING);" + NL + "\t      \tif (is_";
  protected final String TEXT_49 = " != null) {" + NL + "\t      \t\tis_";
  protected final String TEXT_50 = ".close();" + NL + "\t      \t\tis_";
  protected final String TEXT_51 = " = null;" + NL + "\t      \t}" + NL + "\t    }";
  protected final String TEXT_52 = NL + NL + "\t\torg.ow2.bonita.facade.uuid.ProcessInstanceUUID instanceUUID_";
  protected final String TEXT_53 = " = runtimeAPI_";
  protected final String TEXT_54 = ".instantiateProcess(processID_";
  protected final String TEXT_55 = ", parameters_";
  protected final String TEXT_56 = ");" + NL + "\t\tprocessInstanceUUID_";
  protected final String TEXT_57 = " = instanceUUID_";
  protected final String TEXT_58 = ".getValue();";
  protected final String TEXT_59 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_60 = ".";
  protected final String TEXT_61 = " = processInstanceUUID_";
  protected final String TEXT_62 = ";";
  protected final String TEXT_63 = NL + NL + "\t\t " + NL + "\tSystem.out.println(\"**** Instance \"+ processInstanceUUID_";
  protected final String TEXT_64 = " + \" created ****\");" + NL + "\t" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_65 = "_ProcessInstanceUUID\", processInstanceUUID_";
  protected final String TEXT_66 = "); ";
  protected final String TEXT_67 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

	String processID = ElementParameterParser.getValue(node, "__PROCESS_ID__");
	String clientMode = ElementParameterParser.getValue(node, "__CLIENT_MODE__");

		List< ? extends IConnection> conns = node.getIncomingConnections();
		if(conns != null && conns.size() > 0 && conns.get(0) != null) {
	    	IConnection conn = conns.get(0);
	    	if(conn!=null && conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
		    	INode previousNode = conn.getSource();
		    	if(previousNode != null) {
					List<IMetadataTable> metadatas = previousNode.getMetadataList();
					if ((metadatas!=null)&&(metadatas.size()>0)) {
						IMetadataTable metadata = metadatas.get(0);
						if (metadata!=null) {
							List<IMetadataColumn> columns = metadata.getListColumns();
							int sizeColumns = columns.size();
							for (int i = 0; i < sizeColumns; i++) {
								if ("HTTP_CLIENT".equals(clientMode)) {
									if (i==0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
									}

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(columns.get(i).getLabel() );
    stringBuffer.append(TEXT_6);
    if(!JavaTypesManager.isJavaPrimitiveType(columns.get(i).getTalendType(), columns.get(i).isNullable())) {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append((columns.get(i)).getLabel());
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append((columns.get(i)).getLabel());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    if(!JavaTypesManager.isJavaPrimitiveType(columns.get(i).getTalendType(), columns.get(i).isNullable())) {
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
									if (i==sizeColumns-1) {

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
									}
								} else {

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append((columns.get(i)).getLabel());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_24);
    stringBuffer.append((columns.get(i)).getLabel());
    stringBuffer.append(TEXT_25);
    
								}
							}
						}
					}
		    	}
		    }
	    }
	    
		if ("HTTP_CLIENT".equals(clientMode)) {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
		} else { // Java Client

    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    
		}
		
		List<IMetadataTable> metadatas = node.getMetadataList();
		if ((metadatas!=null)&&(metadatas.size()>0)) {
			IMetadataTable metadata = metadatas.get(0);
			if (metadata!=null) {
				List< ? extends IConnection> conns_out = node.getOutgoingConnections();
				for (IConnection conn : conns_out) {
					String connName = conn.getName();
					if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
						List<IMetadataColumn> columns = metadata.getListColumns();
						int sizeColumns = columns.size();
						for (int i = 0; i < sizeColumns; i++) {
							if ("ProcessInstanceUUID".equals(columns.get(i).getLabel()) ) {

    stringBuffer.append(TEXT_59);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_60);
    stringBuffer.append((columns.get(i)).getLabel());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    
								break;
							}
						}
					}
				}
			}
		}

    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(TEXT_67);
    return stringBuffer.toString();
  }
}
