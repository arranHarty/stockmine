package org.talend.designer.codegen.translators.processing.fields;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.ArrayList;

public class TExtractDelimitedFieldsMainJava
{
  protected static String nl;
  public static synchronized TExtractDelimitedFieldsMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExtractDelimitedFieldsMainJava result = new TExtractDelimitedFieldsMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = " = null;";
  protected final String TEXT_4 = NL + "try{" + NL + "" + NL + "\t";
  protected final String TEXT_5 = " = new ";
  protected final String TEXT_6 = "Struct();";
  protected final String TEXT_7 = NL + "\tString field_";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = ";" + NL + "\tif(field_";
  protected final String TEXT_11 = "==null){" + NL + "\t\tthrow(new java.lang.Exception(\"Value of field to split is null.\"));" + NL + "\t}" + NL + "\tString[] newFields_";
  protected final String TEXT_12 = " = field_";
  protected final String TEXT_13 = ".split(";
  protected final String TEXT_14 = ",-1);" + NL + "\tint length_";
  protected final String TEXT_15 = " = newFields_";
  protected final String TEXT_16 = ".length;";
  protected final String TEXT_17 = NL + "\t\tfor(int i_";
  protected final String TEXT_18 = " = 0;i_";
  protected final String TEXT_19 = " < length_";
  protected final String TEXT_20 = ";i_";
  protected final String TEXT_21 = "++){" + NL + "\t\t\tnewFields_";
  protected final String TEXT_22 = "[i_";
  protected final String TEXT_23 = "] = newFields_";
  protected final String TEXT_24 = "[i_";
  protected final String TEXT_25 = "].trim();" + NL + "\t\t}";
  protected final String TEXT_26 = NL + "\t\toptimizedCodeUtil_";
  protected final String TEXT_27 = ".putOirginalValue_";
  protected final String TEXT_28 = "(";
  protected final String TEXT_29 = ",";
  protected final String TEXT_30 = ");";
  protected final String TEXT_31 = NL + "\t\t";
  protected final String TEXT_32 = ".";
  protected final String TEXT_33 = " = ";
  protected final String TEXT_34 = ".";
  protected final String TEXT_35 = " ;";
  protected final String TEXT_36 = NL + "\tString temp_";
  protected final String TEXT_37 = " = null;";
  protected final String TEXT_38 = NL + "\t\toptimizedCodeUtil_";
  protected final String TEXT_39 = ".putExtractValue_";
  protected final String TEXT_40 = "(";
  protected final String TEXT_41 = ",";
  protected final String TEXT_42 = ",length_";
  protected final String TEXT_43 = ",newFields_";
  protected final String TEXT_44 = ",temp_";
  protected final String TEXT_45 = " );";
  protected final String TEXT_46 = NL + "\t";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = " = ";
  protected final String TEXT_49 = ">=length_";
  protected final String TEXT_50 = "?\"\":newFields_";
  protected final String TEXT_51 = "[";
  protected final String TEXT_52 = "];";
  protected final String TEXT_53 = NL + "\ttemp_";
  protected final String TEXT_54 = " = ";
  protected final String TEXT_55 = ">=length_";
  protected final String TEXT_56 = "?\"\":newFields_";
  protected final String TEXT_57 = "[";
  protected final String TEXT_58 = "];" + NL + "\tif(temp_";
  protected final String TEXT_59 = ".length() > 0) {";
  protected final String TEXT_60 = NL + "\t\t";
  protected final String TEXT_61 = ".";
  protected final String TEXT_62 = " = temp_";
  protected final String TEXT_63 = ".getBytes();";
  protected final String TEXT_64 = NL + "\t\t";
  protected final String TEXT_65 = ".";
  protected final String TEXT_66 = " = ParserUtils.parseTo_Date(temp_";
  protected final String TEXT_67 = ", ";
  protected final String TEXT_68 = ", false);";
  protected final String TEXT_69 = NL + "\t\t";
  protected final String TEXT_70 = ".";
  protected final String TEXT_71 = " = ParserUtils.parseTo_Date(temp_";
  protected final String TEXT_72 = ", ";
  protected final String TEXT_73 = ");";
  protected final String TEXT_74 = NL + "\t\t";
  protected final String TEXT_75 = ".";
  protected final String TEXT_76 = " = ParserUtils.parseTo_";
  protected final String TEXT_77 = "(ParserUtils.parseTo_Number(temp_";
  protected final String TEXT_78 = ", ";
  protected final String TEXT_79 = ", ";
  protected final String TEXT_80 = "));";
  protected final String TEXT_81 = NL + "\t\t";
  protected final String TEXT_82 = ".";
  protected final String TEXT_83 = " = ParserUtils.parseTo_";
  protected final String TEXT_84 = "(temp_";
  protected final String TEXT_85 = ");";
  protected final String TEXT_86 = NL + "\t} else {\t\t\t\t\t\t";
  protected final String TEXT_87 = NL + "\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_88 = "' in '";
  protected final String TEXT_89 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_90 = NL + "\t\t";
  protected final String TEXT_91 = ".";
  protected final String TEXT_92 = " = ";
  protected final String TEXT_93 = ";";
  protected final String TEXT_94 = NL + "\t}";
  protected final String TEXT_95 = NL + "\t int filedsum_";
  protected final String TEXT_96 = " = newFields_";
  protected final String TEXT_97 = ".length;" + NL + "\t if(filedsum_";
  protected final String TEXT_98 = " < ";
  protected final String TEXT_99 = "){" + NL + "\t \tthrow new RuntimeException(\"Column(s) missing\");" + NL + "\t } else if(filedsum_";
  protected final String TEXT_100 = " > ";
  protected final String TEXT_101 = ") {" + NL + "\t \tthrow new RuntimeException(\"Too many columns\");" + NL + "\t }     ";
  protected final String TEXT_102 = NL + "\t";
  protected final String TEXT_103 = " = null;";
  protected final String TEXT_104 = NL + "\tnb_line_";
  protected final String TEXT_105 = "++;" + NL + "}catch(java.lang.Exception ex_";
  protected final String TEXT_106 = "){";
  protected final String TEXT_107 = NL + "\tthrow(ex_";
  protected final String TEXT_108 = ");";
  protected final String TEXT_109 = NL + "\t";
  protected final String TEXT_110 = " = new ";
  protected final String TEXT_111 = "Struct();";
  protected final String TEXT_112 = NL + "\toptimizedCodeUtil_";
  protected final String TEXT_113 = ".putRejectValue_";
  protected final String TEXT_114 = "(";
  protected final String TEXT_115 = ",";
  protected final String TEXT_116 = ");";
  protected final String TEXT_117 = NL + "    ";
  protected final String TEXT_118 = ".";
  protected final String TEXT_119 = " = ";
  protected final String TEXT_120 = ".";
  protected final String TEXT_121 = ";";
  protected final String TEXT_122 = "    ";
  protected final String TEXT_123 = NL + "    ";
  protected final String TEXT_124 = ".errorMessage = ex_";
  protected final String TEXT_125 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_126 = ";";
  protected final String TEXT_127 = NL + "    ";
  protected final String TEXT_128 = " = null;";
  protected final String TEXT_129 = NL + "    System.err.println(ex_";
  protected final String TEXT_130 = ".getMessage());";
  protected final String TEXT_131 = NL + "    ";
  protected final String TEXT_132 = " = null;";
  protected final String TEXT_133 = NL + "\t";
  protected final String TEXT_134 = ".errorMessage = ex_";
  protected final String TEXT_135 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_136 = ";";
  protected final String TEXT_137 = NL + "}";
  protected final String TEXT_138 = NL + NL;
  protected final String TEXT_139 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String field = ElementParameterParser.getValue(node, "__FIELD__");
String separator = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");

int schemaOptNum=100;
String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
	schemaOptNum  = Integer.parseInt(schemaOptNumStr);
}

String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);

boolean trim = ("true").equals(ElementParameterParser.getValue(node, "__TRIM__"));

String checkDateStr = ElementParameterParser.getValue(node,"__CHECK_DATE__");
boolean checkDate = (checkDateStr!=null&&!("").equals(checkDateStr))?("true").equals(checkDateStr):false;

String checkNumStr = ElementParameterParser.getValue(node, "__CHECK_FIELDS_NUM__");
boolean checkNum = (checkNumStr!=null&&!("").equals(checkNumStr))?("true").equals(checkNumStr):false; 

String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;

IConnection inConn = null;
List< ? extends IConnection> inConns = node.getIncomingConnections();
if(inConns!=null){
    for (IConnection conn : inConns) {
    	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    		inConn = conn;
    		break;
    	}
    }
}

String rejectConnName = "";
List<IMetadataColumn> rejectColumnList = null;
List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
if(rejectConns != null && rejectConns.size() > 0) {
    IConnection rejectConn = rejectConns.get(0);
    rejectColumnList = rejectConn.getMetadataTable().getListColumns();
    rejectConnName = rejectConn.getName();
}

String firstConnName = "";
IConnection outConn = null;
List< ? extends IConnection> outConns = node.getOutgoingConnections();
if(outConns!=null){
    for (IConnection conn : outConns) {
    	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    		outConn = conn;
    		firstConnName = outConn.getName();
    		break;
    	}
    }
}

if(outConns!=null){
    for (IConnection conn : outConns) {
    	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_3);
    
    	}
    }
}

//get field column
if(outConn!=null && inConn!=null){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_6);
    
	IMetadataTable inputMetadataTable = inConn.getMetadataTable();
	for (IMetadataColumn inputCol : inputMetadataTable.getListColumns()) {
		if(inputCol.getLabel().equals(field)){

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(field);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
			if(trim){

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
			}
			break;
		}
	}


//set original columns
List<IMetadataColumn> newColumnList = new ArrayList<IMetadataColumn>();
List<IMetadataColumn> oirginalColumnsList = new ArrayList<IMetadataColumn>();
IMetadataTable outputMetadataTable = outConn.getMetadataTable();
int sizeColumns=outputMetadataTable.getListColumns().size();

	for (IMetadataColumn outputCol : outputMetadataTable.getListColumns()) {
		boolean isOirginalColumn = false;
		for (IMetadataColumn inputCol : inputMetadataTable.getListColumns()) {
			if( outputCol.getLabel().equals( inputCol.getLabel()) ){
				isOirginalColumn = true;
				oirginalColumnsList.add(outputCol);
				break;
			}
		}
		if(!isOirginalColumn){
			if(!("").equals(rejectConnName)&&rejectConnName.equals(firstConnName)
				&& (outputCol.getLabel().equals("errorMessage") || outputCol.getLabel().equals("errorCode"))){
			}else{
				newColumnList.add(outputCol);
			}
		}
	}
	for(int i=0; i<oirginalColumnsList.size();i++){
		IMetadataColumn column = oirginalColumnsList.get(i);
		if(sizeColumns> schemaOptNum){//D1
			if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(inConn.getName() );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_30);
    
			}
		}else{

    stringBuffer.append(TEXT_31);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_35);
    
		}//D1
	}

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
	for(int i=0; i<newColumnList.size();i++){
		IMetadataColumn column = newColumnList.get(i);
		String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
		JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
		String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    
		if(sizeColumns> schemaOptNum){//D2
			if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(inConn.getName() );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    
			}
		}else{
		  if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){

    stringBuffer.append(TEXT_46);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_52);
    
		  }else{ 

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    
			if(javaType == JavaTypesManager.BYTE_ARRAY){ 

    stringBuffer.append(TEXT_60);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    
			}else if(javaType == JavaTypesManager.DATE) {
				if(checkNum || checkDate){

    stringBuffer.append(TEXT_64);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_68);
    
				}else{

    stringBuffer.append(TEXT_69);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_73);
    
				}
			}else if(advancedSeparator && JavaTypesManager.isNumberType(javaType)) { 

    stringBuffer.append(TEXT_74);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_76);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_79);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_80);
    
			} else {

    stringBuffer.append(TEXT_81);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_83);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    
			}

    stringBuffer.append(TEXT_86);
    
			String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
			if(defaultValue == null) {

    stringBuffer.append(TEXT_87);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_89);
    
			} else {

    stringBuffer.append(TEXT_90);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_93);
    
			}

    stringBuffer.append(TEXT_94);
    
		 }
		}
	}
	
	if(checkNum) {

    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(newColumnList.size() );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(newColumnList.size() );
    stringBuffer.append(TEXT_101);
    
	}
	
	if(!("").equals(rejectConnName) && rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_102);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_103);
    
	}

    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    
	if(dieOnError){

    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    
	}else{
		if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_109);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_111);
    
			for(int i=0; i<sizeColumns;i++){
				IMetadataColumn column = outputMetadataTable.getListColumns().get(i);
				if(sizeColumns> schemaOptNum){//D1
					if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_116);
    
					}
				}else{

    stringBuffer.append(TEXT_117);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_119);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_121);
    
				}
			}

    stringBuffer.append(TEXT_122);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_128);
    
		} else if(("").equals(rejectConnName)){

    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_132);
    
		} else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_133);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_136);
    
		}
	}

    stringBuffer.append(TEXT_137);
    
}

    stringBuffer.append(TEXT_138);
    stringBuffer.append(TEXT_139);
    return stringBuffer.toString();
  }
}
