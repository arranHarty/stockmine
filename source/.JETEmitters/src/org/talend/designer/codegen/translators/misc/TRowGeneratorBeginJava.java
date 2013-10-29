package org.talend.designer.codegen.translators.misc;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;

public class TRowGeneratorBeginJava
{
  protected static String nl;
  public static synchronized TRowGeneratorBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRowGeneratorBeginJava result = new TRowGeneratorBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "\t";
  protected final String TEXT_3 = NL + "\t\tlog.info(\"";
  protected final String TEXT_4 = " - Start to work.\");" + NL + "\t";
  protected final String TEXT_5 = NL + "int nb_line_";
  protected final String TEXT_6 = " = 0;" + NL + "int nb_max_row_";
  protected final String TEXT_7 = " = ";
  protected final String TEXT_8 = ";" + NL;
  protected final String TEXT_9 = NL + NL + "class ";
  protected final String TEXT_10 = "Randomizer {";
  protected final String TEXT_11 = NL + "\tpublic ";
  protected final String TEXT_12 = " getRandom";
  protected final String TEXT_13 = "() {" + NL + "\t\t";
  protected final String TEXT_14 = NL + "\t\treturn ";
  protected final String TEXT_15 = ";" + NL + "\t\t";
  protected final String TEXT_16 = NL + "\t\t";
  protected final String TEXT_17 = "[] ";
  protected final String TEXT_18 = "Table = new ";
  protected final String TEXT_19 = "[] { ";
  protected final String TEXT_20 = " };" + NL + "\t\tjava.util.Random random";
  protected final String TEXT_21 = " = new java.util.Random();" + NL + "\t\treturn ";
  protected final String TEXT_22 = "Table[random";
  protected final String TEXT_23 = ".nextInt(";
  protected final String TEXT_24 = "Table.length)];" + NL + "\t\t";
  protected final String TEXT_25 = " " + NL + "\t\treturn ";
  protected final String TEXT_26 = ";" + NL + "\t\t";
  protected final String TEXT_27 = NL + "\t}";
  protected final String TEXT_28 = NL + "}" + NL + "\t";
  protected final String TEXT_29 = "Randomizer rand";
  protected final String TEXT_30 = " = new ";
  protected final String TEXT_31 = "Randomizer();" + NL + "\t";
  protected final String TEXT_32 = NL + "\t\tStringBuffer log4jSb_";
  protected final String TEXT_33 = " = new StringBuffer();" + NL + "    \tlog.info(\"";
  protected final String TEXT_34 = " - Generating records.\");";
  protected final String TEXT_35 = NL + "\tfor (int i";
  protected final String TEXT_36 = "=0; i";
  protected final String TEXT_37 = "<nb_max_row_";
  protected final String TEXT_38 = " ;i";
  protected final String TEXT_39 = "++) {";
  protected final String TEXT_40 = NL + "\t\t";
  protected final String TEXT_41 = ".";
  protected final String TEXT_42 = " = rand";
  protected final String TEXT_43 = ".getRandom";
  protected final String TEXT_44 = "();" + NL + "\t\t\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_46 = ".append(";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\t\t\t\t\tlog4jSb_";
  protected final String TEXT_50 = ".append(\"|\");\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_51 = NL + "\t\tnb_line_";
  protected final String TEXT_52 = "++;" + NL + "\t\t";
  protected final String TEXT_53 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_54 = " - Retrieving the record \" + nb_line_";
  protected final String TEXT_55 = " + \".\");" + NL + "\t\t\tlog.trace(\"";
  protected final String TEXT_56 = " - Content of the record \" + nb_line_";
  protected final String TEXT_57 = " + \": \" + log4jSb_";
  protected final String TEXT_58 = ");" + NL + "\t\t\tlog4jSb_";
  protected final String TEXT_59 = ".delete(0,log4jSb_";
  protected final String TEXT_60 = ".length());" + NL + "\t\t";
  protected final String TEXT_61 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	String cid = node.getUniqueName();
	List<Map<String, String>> tableValues = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__VALUES__");
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_2);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    }
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append((("").equals(ElementParameterParser.getValue(node, "__NB_ROWS__"))? 100: ElementParameterParser.getValue(node, "__NB_ROWS__")));
    stringBuffer.append(TEXT_8);
    
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    
		List<IMetadataColumn> listColumns = metadata.getListColumns(); 
		for (int i=0; i<tableValues.size(); i++) {
			Map<String, String> lineValue = tableValues.get(i);
			//lineValue.get("ARRAY")

    stringBuffer.append(TEXT_11);
    stringBuffer.append(JavaTypesManager.getTypeToGenerate(listColumns.get(i).getTalendType(), listColumns.get(i).isNullable()) );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(listColumns.get(i).getLabel() );
    stringBuffer.append(TEXT_13);
    
			/* if column parameter looks like abcd(efgh,...) )  */
			if (lineValue.get("ARRAY").indexOf("(") >0) {
		
    stringBuffer.append(TEXT_14);
    stringBuffer.append(lineValue.get("ARRAY") );
    stringBuffer.append(TEXT_15);
     
			/* else if parameter is  separated by , */
			} else if (lineValue.get("ARRAY").indexOf(",") >0) {
		
    stringBuffer.append(TEXT_16);
    stringBuffer.append(JavaTypesManager.getTypeToGenerate(listColumns.get(i).getTalendType(), listColumns.get(i).isNullable()) );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(listColumns.get(i).getLabel() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(JavaTypesManager.getTypeToGenerate(listColumns.get(i).getTalendType(), listColumns.get(i).isNullable()) );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(lineValue.get("ARRAY") );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(listColumns.get(i).getLabel() );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(listColumns.get(i).getLabel() );
    stringBuffer.append(TEXT_24);
     } else { 
    stringBuffer.append(TEXT_25);
    stringBuffer.append(lineValue.get("ARRAY") );
    stringBuffer.append(TEXT_26);
     } 
    stringBuffer.append(TEXT_27);
    
		}

    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    }
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    
		List< ? extends IConnection> conns = node.getOutgoingConnections();
		for (int i=0;i<conns.size();i++) {
			IConnection conn = conns.get(i);
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA) 
			   && (!conn.getLineStyle().hasConnectionCategory(IConnectionCategory.USE_HASH))) {
			    int currentColNo = 0;
				for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_40);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_44);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_48);
    if(currentColNo < metadata.getListColumns().size()-1){
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    }
					}
    
                currentColNo++;
				}
			}
		}

    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
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
    return stringBuffer.toString();
  }
}
