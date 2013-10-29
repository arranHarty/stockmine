package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.Map;

public class TMDMDeleteMainJava
{
  protected static String nl;
  public static synchronized TMDMDeleteMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMDeleteMainJava result = new TMDMDeleteMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "String[] wsIds_";
  protected final String TEXT_2 = " = {";
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = ".";
  protected final String TEXT_5 = "};" + NL + "org.talend.mdm.webservice.WSItemPK wsPK_";
  protected final String TEXT_6 = " = new org.talend.mdm.webservice.WSItemPK(dataCluster_";
  protected final String TEXT_7 = ",";
  protected final String TEXT_8 = ",wsIds_";
  protected final String TEXT_9 = ");" + NL + "///////////////////////\t" + NL + "" + NL + "try{";
  protected final String TEXT_10 = NL + "\torg.talend.mdm.webservice.WSDropItem item_";
  protected final String TEXT_11 = " = new org.talend.mdm.webservice.WSDropItem(wsPK_";
  protected final String TEXT_12 = ",";
  protected final String TEXT_13 = ",false);" + NL + "\txtentisWS_";
  protected final String TEXT_14 = ".dropItem(item_";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL + "\torg.talend.mdm.webservice.WSDeleteItem item_";
  protected final String TEXT_17 = " = new org.talend.mdm.webservice.WSDeleteItem(wsPK_";
  protected final String TEXT_18 = ",false);" + NL + "\txtentisWS_";
  protected final String TEXT_19 = ".deleteItem(item_";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "}catch(java.lang.Exception e){";
  protected final String TEXT_22 = NL + "\tthrow(e);";
  protected final String TEXT_23 = NL + "\tSystem.err.println(e.getMessage());";
  protected final String TEXT_24 = NL + "}" + NL + "nb_line_";
  protected final String TEXT_25 = "++;    \t\t\t" + NL + "" + NL + "///////////////////////    \t\t\t";
  protected final String TEXT_26 = NL + "\torg.talend.mdm.webservice.WSWhereCondition wc_";
  protected final String TEXT_27 = " = null;" + NL + "\tjava.util.List<org.talend.mdm.webservice.WSWhereItem> conditions_";
  protected final String TEXT_28 = " = new java.util.ArrayList<org.talend.mdm.webservice.WSWhereItem>();";
  protected final String TEXT_29 = NL + "\twc_";
  protected final String TEXT_30 = " =new org.talend.mdm.webservice.WSWhereCondition(";
  protected final String TEXT_31 = ",org.talend.mdm.webservice.WSWhereOperator.";
  protected final String TEXT_32 = ", ";
  protected final String TEXT_33 = ", org.talend.mdm.webservice.WSStringPredicate.";
  protected final String TEXT_34 = ",false);" + NL + "\torg.talend.mdm.webservice.WSWhereItem wsItem_";
  protected final String TEXT_35 = "_";
  protected final String TEXT_36 = "=new org.talend.mdm.webservice.WSWhereItem(wc_";
  protected final String TEXT_37 = ",null,null);" + NL + "\tconditions_";
  protected final String TEXT_38 = ".add(wsItem_";
  protected final String TEXT_39 = "_";
  protected final String TEXT_40 = ");";
  protected final String TEXT_41 = NL + "\torg.talend.mdm.webservice.WSWhereItem wsItem_";
  protected final String TEXT_42 = " = null;" + NL + "\tif(conditions_";
  protected final String TEXT_43 = ".size() > 0){";
  protected final String TEXT_44 = NL + "\t\twsItem_";
  protected final String TEXT_45 = " =new org.talend.mdm.webservice.WSWhereItem(null,conditions_";
  protected final String TEXT_46 = ".toArray(new org.talend.mdm.webservice.WSWhereItem[conditions_";
  protected final String TEXT_47 = ".size()]),null);";
  protected final String TEXT_48 = NL + "\t\twsItem_";
  protected final String TEXT_49 = " =new org.talend.mdm.webservice.WSWhereItem(null,null,conditions_";
  protected final String TEXT_50 = ".toArray(new org.talend.mdm.webservice.WSWhereItem[conditions_";
  protected final String TEXT_51 = ".size()]));";
  protected final String TEXT_52 = NL + "\t}" + NL + "\ttry{" + NL + "\t\torg.talend.mdm.webservice.WSDeleteItems items_";
  protected final String TEXT_53 = " = new org.talend.mdm.webservice.WSDeleteItems(dataCluster_";
  protected final String TEXT_54 = ",";
  protected final String TEXT_55 = ",wsItem_";
  protected final String TEXT_56 = ",";
  protected final String TEXT_57 = ",false);" + NL + "\t\txtentisWS_";
  protected final String TEXT_58 = ".deleteItems(items_";
  protected final String TEXT_59 = ");" + NL + "\t}catch(java.lang.Exception e_";
  protected final String TEXT_60 = "){";
  protected final String TEXT_61 = NL + "\t\tthrow(e_";
  protected final String TEXT_62 = ");";
  protected final String TEXT_63 = NL + "\t\tSystem.err.println(e_";
  protected final String TEXT_64 = ".getMessage());";
  protected final String TEXT_65 = NL + "\t}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

boolean isDropItem = ("true").equals(ElementParameterParser.getValue(node,"__USE_DROP_ITEM__"));
String partPath = ElementParameterParser.getValue(node,"__PART_PATH__");

boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node,"__DIE_ON_ERROR__"));

String dataModule = ElementParameterParser.getValue(node, "__CONCEPT__");
List<Map<String,String>> keyValues = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__KEYS__");

boolean useMultConditions = ("true").equals(ElementParameterParser.getValue(node, "__USE_ITEMS__"));
List<Map<String, String>> operations = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__OPERATIONS__");
String spellThrehold = ElementParameterParser.getValue(node, "__SPELLTHREHOLD__");
if(spellThrehold==null || ("").equals(spellThrehold)){
	spellThrehold = "0";
} 
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {//1
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {//2

    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	for (IConnection conn : conns) {//3
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//4
    			if(!useMultConditions){//5

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    
			    for(int i=0;i<keyValues.size();i++){
			    	String columnName=keyValues.get(i).get("KEY");

    stringBuffer.append(TEXT_3);
    stringBuffer.append(i==0?"":",");
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(columnName );
    
			    }

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(dataModule );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
if(isDropItem){

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(partPath );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    }else{
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
    
if(dieOnError){

    stringBuffer.append(TEXT_22);
    
}else{

    stringBuffer.append(TEXT_23);
    
}

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    
				}
    		}//4
    	}//3
    }//2
}//1

    
	if(useMultConditions){

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
		boolean isOnlyOrPredicate=true;
		for(int i=0; i < operations.size(); i++){
			Map<String, String> map= operations.get(i);
			String xpath=map.get("XPATH");
			String operator=map.get("FUNCTION");
			String value = map.get("VALUE");
			String predicate = map.get("PREDICATE");
			if((i < operations.size()-1) && (!"OR".equals(predicate))){
				isOnlyOrPredicate = false;
			}

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(xpath );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(operator );
    stringBuffer.append(TEXT_32);
    stringBuffer.append("EMPTY_NULL".equals(operator)? null:value );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(predicate );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    
		}//for

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    
		if(!isOnlyOrPredicate){

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    
		}else{

    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    
		}

    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(dataModule );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(spellThrehold);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    
		if(dieOnError){

    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    
		}else{

    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    
		}

    stringBuffer.append(TEXT_65);
    
	}

    return stringBuffer.toString();
  }
}
