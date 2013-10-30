package org.talend.designer.codegen.translators.bigdata.couchbase;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;

public class TCouchbaseOutMainJava
{
  protected static String nl;
  public static synchronized TCouchbaseOutMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCouchbaseOutMainJava result = new TCouchbaseOutMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    ";
  protected final String TEXT_2 = " = null;";
  protected final String TEXT_3 = NL + "                        whetherReject_";
  protected final String TEXT_4 = " = false;" + NL + "                    try {";
  protected final String TEXT_5 = NL + "                            net.spy.memcached.internal.OperationFuture<Boolean> operation_";
  protected final String TEXT_6 = " = client_";
  protected final String TEXT_7 = ".delete(";
  protected final String TEXT_8 = ".";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "                                net.spy.memcached.internal.OperationFuture<Boolean> operation_";
  protected final String TEXT_11 = " = client_";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = "(";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = ", ";
  protected final String TEXT_16 = ", ";
  protected final String TEXT_17 = ".";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL + "                                net.spy.memcached.internal.OperationFuture<Boolean> operation_";
  protected final String TEXT_20 = " = client_";
  protected final String TEXT_21 = ".";
  protected final String TEXT_22 = "(";
  protected final String TEXT_23 = ".";
  protected final String TEXT_24 = ", ";
  protected final String TEXT_25 = ", ";
  protected final String TEXT_26 = ".";
  protected final String TEXT_27 = ");";
  protected final String TEXT_28 = NL + "                        if (operation_";
  protected final String TEXT_29 = ".get().booleanValue()) {";
  protected final String TEXT_30 = NL + "                                nb_line_inserted_";
  protected final String TEXT_31 = "++;";
  protected final String TEXT_32 = NL + "                                nb_line_update_";
  protected final String TEXT_33 = "++;";
  protected final String TEXT_34 = NL + "                                nb_line_inserted_updated_";
  protected final String TEXT_35 = "++;";
  protected final String TEXT_36 = NL + "                                nb_line_deleted_";
  protected final String TEXT_37 = "++;";
  protected final String TEXT_38 = NL + "                        }else{" + NL + "                            whetherReject_";
  protected final String TEXT_39 = " = true;";
  protected final String TEXT_40 = NL + "                                ";
  protected final String TEXT_41 = " = new ";
  protected final String TEXT_42 = "Struct();";
  protected final String TEXT_43 = NL + "                                    ";
  protected final String TEXT_44 = ".";
  protected final String TEXT_45 = " = ";
  protected final String TEXT_46 = ".";
  protected final String TEXT_47 = ";";
  protected final String TEXT_48 = NL + "                                nb_line_rejected_";
  protected final String TEXT_49 = " ++;";
  protected final String TEXT_50 = NL + "                                ";
  protected final String TEXT_51 = ".errorMessage = \"";
  protected final String TEXT_52 = " key:\"+";
  protected final String TEXT_53 = ".";
  protected final String TEXT_54 = "+\" - Line: \" + tos_count_";
  protected final String TEXT_55 = ";";
  protected final String TEXT_56 = NL + "                        }" + NL + "                    } catch (java.lang.Exception e_";
  protected final String TEXT_57 = ") {" + NL + "                        whetherReject_";
  protected final String TEXT_58 = " = true;";
  protected final String TEXT_59 = NL + "                            throw(e_";
  protected final String TEXT_60 = ");";
  protected final String TEXT_61 = NL + "                                ";
  protected final String TEXT_62 = " = new ";
  protected final String TEXT_63 = "Struct();";
  protected final String TEXT_64 = NL + "                                    ";
  protected final String TEXT_65 = ".";
  protected final String TEXT_66 = " = ";
  protected final String TEXT_67 = ".";
  protected final String TEXT_68 = ";";
  protected final String TEXT_69 = NL + "                                nb_line_rejected_";
  protected final String TEXT_70 = " ++;";
  protected final String TEXT_71 = NL + "                                ";
  protected final String TEXT_72 = ".errorMessage = e_";
  protected final String TEXT_73 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_74 = ";";
  protected final String TEXT_75 = NL + "                                System.err.println(\"ExecutionException while doing set: \" + e_";
  protected final String TEXT_76 = ".getMessage());";
  protected final String TEXT_77 = NL + "                    }" + NL + "                    nb_line_";
  protected final String TEXT_78 = "++;";
  protected final String TEXT_79 = NL + "                        if(!whetherReject_";
  protected final String TEXT_80 = ") {";
  protected final String TEXT_81 = NL + "                                        ";
  protected final String TEXT_82 = " = new ";
  protected final String TEXT_83 = "Struct();";
  protected final String TEXT_84 = NL + "                                            ";
  protected final String TEXT_85 = ".";
  protected final String TEXT_86 = " = ";
  protected final String TEXT_87 = ".";
  protected final String TEXT_88 = ";";
  protected final String TEXT_89 = NL + "                        }";
  protected final String TEXT_90 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;

INode node = (INode)codeGenArgument.getArgument();
String rejectConnName = null;
List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
List<IMetadataColumn> rejectColumnList = null;
if(rejectConns != null && rejectConns.size() > 0) {
    IConnection rejectConn = rejectConns.get(0);
	if(rejectConn!=null){
    	rejectConnName = rejectConn.getName();
    	IMetadataTable metadataTable = rejectConn.getMetadataTable();
    	if(metadataTable!=null){
        	rejectColumnList = metadataTable.getListColumns();
    	}
  	}
}
List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
List<IMetadataColumn> columnList = null;

for(IConnection tmpconn : outgoingConns) {
  if (tmpconn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    if(rejectConnName==null || !rejectConnName.equals(tmpconn.getName())){
      IMetadataTable outputMetadata = tmpconn.getMetadataTable();
      if(outputMetadata!=null){
          columnList = outputMetadata.getListColumns();
      }
    }
  
    stringBuffer.append(TEXT_1);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_2);
    
  }
}
String cid = node.getUniqueName();
String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
List<IMetadataTable> metadatas = node.getMetadataList();

if ((metadatas!=null) && (metadatas.size() > 0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata != null) {
        
        String expire = ElementParameterParser.getValue(node, "__EXPIRE__");
        String isjson = ElementParameterParser.getValue(node,"__IS_VIRTUAL_COMPONENT__");
        List< ? extends IConnection> conns = node.getIncomingConnections();
        if (conns != null){
            if (conns.size()>0){
                IConnection conn =conns.get(0);
                String connName = conn.getName();
                if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                    IMetadataTable meta =  conn.getMetadataTable();
                    if(meta.getListColumns().size()>0){
                        String key = ElementParameterParser.getValue(node,"__KEY__");

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
                        if("delete".equals(dataAction)){

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_9);
    
                        }else {
                            if("true".equals(isjson)){
                                String jsonfield = ElementParameterParser.getValue(node,"__JSONFIELD__");

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(dataAction);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(expire);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(jsonfield);
    stringBuffer.append(TEXT_18);
    
                            }else{
                                String value = ElementParameterParser.getValue(node,"__VALUE__");

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(dataAction);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(expire);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_27);
    
                            }
                        }

    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
                            if("add".equals(dataAction)){
                                
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
                            }else if("replace".equals(dataAction)){
                                
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
                            }else if("set".equals(dataAction)){
                                
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
                            }else if("delete".equals(dataAction)){
                                
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
                            } 
                            
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    
                            if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                                
    stringBuffer.append(TEXT_40);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_42);
    
                                for(IMetadataColumn column1 : columnList) {
                                    
    stringBuffer.append(TEXT_43);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(column1.getLabel());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(column1.getLabel());
    stringBuffer.append(TEXT_47);
    
                                }
                                
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(dataAction);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_55);
    
                            }
                            
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    
                        if (("true").equals(dieOnError)) {
                            
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    
                        } else {
                            if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                                
    stringBuffer.append(TEXT_61);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_63);
    
                                for(IMetadataColumn column1 : columnList) {
                                    
    stringBuffer.append(TEXT_64);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(column1.getLabel());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(column1.getLabel());
    stringBuffer.append(TEXT_68);
    
                                }
                                
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_74);
    
                            } else {
                                
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    
                            }
                        } 
                        
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    
                    }       
                    if(outgoingConns != null && outgoingConns.size() > 0) {
                        
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    
                            for(IConnection outgoingConn : outgoingConns) {
                                if(rejectConnName == null || (rejectConnName != null && !outgoingConn.getName().equals(rejectConnName))) {
                                    if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                                        
                                        
    stringBuffer.append(TEXT_81);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_82);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_83);
    
                                        for(IMetadataColumn column : columnList) {
                                            
    stringBuffer.append(TEXT_84);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_86);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_88);
                      
                                        }
                                    }
                                }
                            }
                            
    stringBuffer.append(TEXT_89);
    
                    }
                }
            }
        }            
    }       
}

    stringBuffer.append(TEXT_90);
    return stringBuffer.toString();
  }
}
