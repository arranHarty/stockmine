package org.talend.designer.codegen.translators.processing;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class TAggregateSortedRowBeginJava
{
  protected static String nl;
  public static synchronized TAggregateSortedRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAggregateSortedRowBeginJava result = new TAggregateSortedRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "final ";
  protected final String TEXT_3 = "Struct[] emmitArray_";
  protected final String TEXT_4 = " = new ";
  protected final String TEXT_5 = "Struct[2];" + NL + "emmitArray_";
  protected final String TEXT_6 = "[0] = new ";
  protected final String TEXT_7 = "Struct();" + NL + "emmitArray_";
  protected final String TEXT_8 = "[1] = new ";
  protected final String TEXT_9 = "Struct();";
  protected final String TEXT_10 = NL + "\tlog.info(\"";
  protected final String TEXT_11 = " - Start to work.\");";
  protected final String TEXT_12 = NL + "int nb_line_";
  protected final String TEXT_13 = " = 0;" + NL + "int currentRowIndex_";
  protected final String TEXT_14 = " = 0;" + NL + "boolean  flag_";
  protected final String TEXT_15 = " = true;//flag for the encounter of first row." + NL;
  protected final String TEXT_16 = " group_";
  protected final String TEXT_17 = "_";
  protected final String TEXT_18 = "=false";
  protected final String TEXT_19 = "=(";
  protected final String TEXT_20 = ")0";
  protected final String TEXT_21 = "=null";
  protected final String TEXT_22 = ";";
  protected final String TEXT_23 = NL + "if(true){" + NL + "\t";
  protected final String TEXT_24 = NL + "\t\tlog.fatal(\"";
  protected final String TEXT_25 = " - Job Error: can't use function \\\"";
  protected final String TEXT_26 = "\\\" on column \\\"";
  protected final String TEXT_27 = "\\\", the data type is \\\"";
  protected final String TEXT_28 = "\\\"\");" + NL + "\t";
  protected final String TEXT_29 = NL + "\tthrow new RuntimeException(\"Job Error: can't use function \\\"";
  protected final String TEXT_30 = "\\\" on column \\\"";
  protected final String TEXT_31 = "\\\", the data type is \\\"";
  protected final String TEXT_32 = "\\\"\");" + NL + "}";
  protected final String TEXT_33 = NL;
  protected final String TEXT_34 = " ";
  protected final String TEXT_35 = "_";
  protected final String TEXT_36 = "_";
  protected final String TEXT_37 = "_";
  protected final String TEXT_38 = " = ";
  protected final String TEXT_39 = "null";
  protected final String TEXT_40 = "false";
  protected final String TEXT_41 = "(";
  protected final String TEXT_42 = ")0";
  protected final String TEXT_43 = "null";
  protected final String TEXT_44 = ";";
  protected final String TEXT_45 = "int count_";
  protected final String TEXT_46 = "_";
  protected final String TEXT_47 = "_";
  protected final String TEXT_48 = "=0;";
  protected final String TEXT_49 = "double sum_";
  protected final String TEXT_50 = "_";
  protected final String TEXT_51 = "_";
  protected final String TEXT_52 = " = 0d;";
  protected final String TEXT_53 = "BigDecimal sum_";
  protected final String TEXT_54 = "_";
  protected final String TEXT_55 = "_";
  protected final String TEXT_56 = " = new BigDecimal(\"0.0\");";
  protected final String TEXT_57 = NL + "if(true){" + NL + "\t";
  protected final String TEXT_58 = NL + "\t\tlog.fatal(\"";
  protected final String TEXT_59 = " - Job Error: can't use function \\\"";
  protected final String TEXT_60 = "\\\" on column \\\"";
  protected final String TEXT_61 = "\\\", the data type is \\\"";
  protected final String TEXT_62 = "\\\"\");" + NL + "\t";
  protected final String TEXT_63 = NL + "\tthrow new RuntimeException(\"Job Error: can't use function \\\"";
  protected final String TEXT_64 = "\\\" on column \\\"";
  protected final String TEXT_65 = "\\\", the data type is \\\"";
  protected final String TEXT_66 = "\\\"\");" + NL + "}";
  protected final String TEXT_67 = "double sum_";
  protected final String TEXT_68 = "_";
  protected final String TEXT_69 = "_";
  protected final String TEXT_70 = " = 0d;";
  protected final String TEXT_71 = "BigDecimal sum_";
  protected final String TEXT_72 = "_";
  protected final String TEXT_73 = "_";
  protected final String TEXT_74 = " = new BigDecimal(\"0.0\");";
  protected final String TEXT_75 = NL + "if(true){" + NL + "\t";
  protected final String TEXT_76 = NL + "\t\tlog.fatal(\"";
  protected final String TEXT_77 = " - Job Error: can't use function \\\"";
  protected final String TEXT_78 = "\\\" on column \\\"";
  protected final String TEXT_79 = "\\\", the data type is \\\"";
  protected final String TEXT_80 = "\\\"\");" + NL + "\t";
  protected final String TEXT_81 = NL + "\tthrow new RuntimeException(\"Job Error: can't use function \\\"";
  protected final String TEXT_82 = "\\\" on column \\\"";
  protected final String TEXT_83 = "\\\", the data type is \\\"";
  protected final String TEXT_84 = "\\\"\");" + NL + "}";
  protected final String TEXT_85 = "int count_";
  protected final String TEXT_86 = "_";
  protected final String TEXT_87 = "_";
  protected final String TEXT_88 = "=0;";
  protected final String TEXT_89 = "java.util.Set set_";
  protected final String TEXT_90 = "_";
  protected final String TEXT_91 = "_";
  protected final String TEXT_92 = " = null;";
  protected final String TEXT_93 = "StringBuilder list_";
  protected final String TEXT_94 = "_";
  protected final String TEXT_95 = "_";
  protected final String TEXT_96 = "=null;";
  protected final String TEXT_97 = "java.util.List list_object_";
  protected final String TEXT_98 = "_";
  protected final String TEXT_99 = "_";
  protected final String TEXT_100 = "=null;";
  protected final String TEXT_101 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {

    IMetadataTable metadata = metadatas.get(0);
    List< ? extends IConnection> conns = node.getIncomingConnections();
    IMetadataTable inMetadata = null;
    if(conns != null){ 
    for (IConnection conn : conns) { 
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { 
			inMetadata = conn.getMetadataTable();
    		break;
		}
	}
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    if (metadata != null && inMetadata != null) { 
    	List<IMetadataColumn> inColumns = inMetadata.getListColumns();
		List<Map<String, String>> operations = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__OPERATIONS__");
		IMetadataColumn[] column_op = new IMetadataColumn[operations.size()];
		String[] functions = new String[operations.size()];
		boolean[] needTestForNull = new boolean[operations.size()];
		List<Map<String, String>> groupbys = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUPBYS__");
		IMetadataColumn[] column_gr = new IMetadataColumn[groupbys.size()];
		for(int i = 0; i < column_op.length; i++){
			Map<String, String> operation = operations.get(i);
			String in = operation.get("INPUT_COLUMN");
			functions[i] = operation.get("FUNCTION");
			for (IMetadataColumn column: inColumns) {
				if(column.getLabel().equals(in)){
					column_op[i] = column;
					JavaType inputJavaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					needTestForNull[i] = !(JavaTypesManager.isJavaPrimitiveType(inputJavaType, column.isNullable())) && (operation.get("IGNORE_NULL").equals("true"));
					break;
				}
			}
		}
		for(int i = 0; i < column_gr.length; i++){
			Map<String, String> groupby = groupbys.get(i);
			String in = groupby.get("INPUT_COLUMN");
			for (IMetadataColumn column: inColumns) {
				if(column.getLabel().equals(in)){
					column_gr[i] = column;
					break;
				}
			}
		}
		conns = null;
		conns = node.getOutgoingSortedConnections();
		if (conns!=null) {
			if (conns.size()>0) {
				IConnection conn = conns.get(0);

    stringBuffer.append(TEXT_2);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_9);
    
			}
		}

    if(isLog4jEnabled){
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    
	//gen groups variable
	for(int i = 0; i < column_gr.length; i++){
		JavaType javaType = JavaTypesManager.getJavaTypeFromId(column_gr[i].getTalendType());

    stringBuffer.append( JavaTypesManager.getTypeToGenerate(column_gr[i].getTalendType(), column_gr[i].isNullable()) );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(column_gr[i].getLabel() );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    
if(javaType == JavaTypesManager.BOOLEAN){
    stringBuffer.append(TEXT_18);
    }else if(javaType == JavaTypesManager.BYTE || javaType == JavaTypesManager.SHORT || 
	javaType == JavaTypesManager.CHARACTER || javaType == JavaTypesManager.INTEGER || javaType == JavaTypesManager.LONG || 
	javaType == JavaTypesManager.FLOAT || javaType == JavaTypesManager.DOUBLE){
	
    stringBuffer.append(TEXT_19);
    stringBuffer.append( JavaTypesManager.getTypeToGenerate(column_gr[i].getTalendType(), false) );
    stringBuffer.append(TEXT_20);
    }else{
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(TEXT_22);
    	}
	//gen aggre variable
	for(int i = 0; i < column_op.length; i++){
		JavaType javaType = JavaTypesManager.getJavaTypeFromId(column_op[i].getTalendType());
		boolean duplicate = false;
		for(int j = 0; j < i; j++){
			if(functions[j].equals(functions[i]) && column_op[j].getLabel().equals(column_op[i].getLabel()) && needTestForNull[i] == needTestForNull[j]){
				duplicate = true;
				break;
			}
		}
		if(duplicate){
			continue;
		}
		if(("min").equals(functions[i]) || ("max").equals(functions[i]) || ("first").equals(functions[i]) || ("last").equals(functions[i])){
			if((javaType == JavaTypesManager.LIST || javaType == JavaTypesManager.OBJECT || javaType == JavaTypesManager.BYTE_ARRAY) && (("min").equals(functions[i]) || ("max").equals(functions[i]))){

    stringBuffer.append(TEXT_23);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(column_op[i].getLabel() );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(JavaTypesManager.getTypeToGenerate(column_op[i].getTalendType(), column_op[i].isNullable()) );
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(column_op[i].getLabel() );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(JavaTypesManager.getTypeToGenerate(column_op[i].getTalendType(), column_op[i].isNullable()) );
    stringBuffer.append(TEXT_32);
    
			}else{

    stringBuffer.append(TEXT_33);
    stringBuffer.append( JavaTypesManager.getTypeToGenerate(column_op[i].getTalendType(), column_op[i].isNullable()) );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(column_op[i].getLabel() );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(needTestForNull[i] );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    
if(column_op[i].isNullable()){
    stringBuffer.append(TEXT_39);
    
}else{
	if(javaType == JavaTypesManager.BOOLEAN){
    stringBuffer.append(TEXT_40);
    
	}else if(javaType == JavaTypesManager.BYTE || javaType == JavaTypesManager.SHORT || 
	javaType == JavaTypesManager.CHARACTER || javaType == JavaTypesManager.INTEGER || javaType == JavaTypesManager.LONG || 
	javaType == JavaTypesManager.FLOAT || javaType == JavaTypesManager.DOUBLE){
	
    stringBuffer.append(TEXT_41);
    stringBuffer.append(JavaTypesManager.getTypeToGenerate(column_op[i].getTalendType(), false) );
    stringBuffer.append(TEXT_42);
    
	}else{
    stringBuffer.append(TEXT_43);
    
	}
}
    stringBuffer.append(TEXT_44);
    
			}
		}else if(("count").equals(functions[i])){
			boolean countHasAvg = false;
			for(int j = 0; j < functions.length; j++){
				if(("avg").equals(functions[j]) && column_op[j].getLabel().equals(column_op[i].getLabel()) && needTestForNull[i] == needTestForNull[j]){
					countHasAvg = true;
					break;
				}
			}
			if(!countHasAvg){

    stringBuffer.append(TEXT_45);
    stringBuffer.append(column_op[i].getLabel() );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(needTestForNull[i] );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    			}
		}else if(("sum").equals(functions[i])){
			boolean sumHasAvg = false;
			for(int j = 0; j < functions.length; j++){
				if(("avg").equals(functions[j]) && column_op[j].getLabel().equals(column_op[i].getLabel()) && needTestForNull[i] == needTestForNull[j]){
					sumHasAvg = true;
					break;
				}
			}
			if(!sumHasAvg){
				if(javaType == JavaTypesManager.BYTE || javaType == JavaTypesManager.SHORT || javaType == JavaTypesManager.CHARACTER || 
					javaType == JavaTypesManager.INTEGER || javaType == JavaTypesManager.LONG || javaType == JavaTypesManager.FLOAT || 
					javaType == JavaTypesManager.DOUBLE){

    stringBuffer.append(TEXT_49);
    stringBuffer.append(column_op[i].getLabel() );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(needTestForNull[i] );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    
				}else if(javaType == JavaTypesManager.BIGDECIMAL){

    stringBuffer.append(TEXT_53);
    stringBuffer.append(column_op[i].getLabel() );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(needTestForNull[i] );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    
				}else{

    stringBuffer.append(TEXT_57);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(column_op[i].getLabel() );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(JavaTypesManager.getTypeToGenerate(column_op[i].getTalendType(), column_op[i].isNullable()) );
    stringBuffer.append(TEXT_62);
    }
    stringBuffer.append(TEXT_63);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(column_op[i].getLabel() );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(JavaTypesManager.getTypeToGenerate(column_op[i].getTalendType(), column_op[i].isNullable()) );
    stringBuffer.append(TEXT_66);
    
				}
			}
		}else if(("avg").equals(functions[i])){
			if(javaType == JavaTypesManager.BYTE || javaType == JavaTypesManager.SHORT || javaType == JavaTypesManager.CHARACTER || 
				javaType == JavaTypesManager.INTEGER || javaType == JavaTypesManager.LONG || javaType == JavaTypesManager.FLOAT || 
				javaType == JavaTypesManager.DOUBLE){

    stringBuffer.append(TEXT_67);
    stringBuffer.append(column_op[i].getLabel() );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(needTestForNull[i] );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    
			}else if(javaType == JavaTypesManager.BIGDECIMAL){

    stringBuffer.append(TEXT_71);
    stringBuffer.append(column_op[i].getLabel() );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(needTestForNull[i] );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    
			}else{

    stringBuffer.append(TEXT_75);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(column_op[i].getLabel() );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(JavaTypesManager.getTypeToGenerate(column_op[i].getTalendType(), column_op[i].isNullable()) );
    stringBuffer.append(TEXT_80);
    }
    stringBuffer.append(TEXT_81);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(column_op[i].getLabel() );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(JavaTypesManager.getTypeToGenerate(column_op[i].getTalendType(), column_op[i].isNullable()) );
    stringBuffer.append(TEXT_84);
    
			}

    stringBuffer.append(TEXT_85);
    stringBuffer.append(column_op[i].getLabel() );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(needTestForNull[i] );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    		}else if(("distinct").equals(functions[i])){

    stringBuffer.append(TEXT_89);
    stringBuffer.append(column_op[i].getLabel() );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(needTestForNull[i] );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    		}else if(functions[i].equals("list")){

    stringBuffer.append(TEXT_93);
    stringBuffer.append(column_op[i].getLabel() );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(needTestForNull[i] );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    		}else {

    stringBuffer.append(TEXT_97);
    stringBuffer.append(column_op[i].getLabel() );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(needTestForNull[i] );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    		}
	}
	
    
	}
	}
}

    stringBuffer.append(TEXT_101);
    return stringBuffer.toString();
  }
}
