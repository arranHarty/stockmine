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
import java.util.Map;

public class TExtractEBCDICFieldsMainJava
{
  protected static String nl;
  public static synchronized TExtractEBCDICFieldsMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExtractEBCDICFieldsMainJava result = new TExtractEBCDICFieldsMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = " = null;";
  protected final String TEXT_4 = NL + "\t\t\tbyte [] byteData_";
  protected final String TEXT_5 = " = ";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = ";";
  protected final String TEXT_8 = NL + "try{" + NL + "\t";
  protected final String TEXT_9 = " = new ";
  protected final String TEXT_10 = "Struct();";
  protected final String TEXT_11 = NL + "\t\t\t\t\t";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = " = ";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = ";";
  protected final String TEXT_16 = NL + "\t\t\t\t\t";
  protected final String TEXT_17 = ".";
  protected final String TEXT_18 = " = ";
  protected final String TEXT_19 = ".";
  protected final String TEXT_20 = ";";
  protected final String TEXT_21 = NL + "\t\t\t\t\textractEBCDICFieldUtil_";
  protected final String TEXT_22 = ".putValue_Oirginal_";
  protected final String TEXT_23 = "(";
  protected final String TEXT_24 = ",";
  protected final String TEXT_25 = ");";
  protected final String TEXT_26 = NL + "\t\tbbRecord_";
  protected final String TEXT_27 = " = java.nio.ByteBuffer.wrap(byteData_";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = NL + "//////////////////////////////////////////////////" + NL + "the original size in the column:";
  protected final String TEXT_30 = " in the schema should be bigger than 0 and DB Type shouldn't be null or Empty" + NL + "//////////////////////////////////////////////////";
  protected final String TEXT_31 = NL + "\t\t\tbyte[] bb_";
  protected final String TEXT_32 = "_";
  protected final String TEXT_33 = " = new byte[";
  protected final String TEXT_34 = "];" + NL + "\t\t\tbbRecord_";
  protected final String TEXT_35 = ".get(bb_";
  protected final String TEXT_36 = "_";
  protected final String TEXT_37 = ");";
  protected final String TEXT_38 = "\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_39 = ".";
  protected final String TEXT_40 = " = new String(bb_";
  protected final String TEXT_41 = "_";
  protected final String TEXT_42 = ",";
  protected final String TEXT_43 = ")";
  protected final String TEXT_44 = ";";
  protected final String TEXT_45 = NL + "\t\t\t\t";
  protected final String TEXT_46 = ".";
  protected final String TEXT_47 = " = new java.lang.Float(java.nio.ByteBuffer.wrap(bb_";
  protected final String TEXT_48 = "_";
  protected final String TEXT_49 = ").order(java.nio.ByteOrder.BIG_ENDIAN).getFloat());";
  protected final String TEXT_50 = NL + "\t\t\t\t";
  protected final String TEXT_51 = ".";
  protected final String TEXT_52 = " = new java.lang.Double(java.nio.ByteBuffer.wrap(bb_";
  protected final String TEXT_53 = "_";
  protected final String TEXT_54 = ").order(java.nio.ByteOrder.BIG_ENDIAN).getDouble());";
  protected final String TEXT_55 = NL + "\t\t\t\t\t";
  protected final String TEXT_56 = ".";
  protected final String TEXT_57 = " = cobolConversion.EBCDICType3.readType3Value(bb_";
  protected final String TEXT_58 = "_";
  protected final String TEXT_59 = ",";
  protected final String TEXT_60 = ",";
  protected final String TEXT_61 = ");";
  protected final String TEXT_62 = NL + "\t\t\t\t\t";
  protected final String TEXT_63 = ".";
  protected final String TEXT_64 = " = cobolConversion.EBCDICType9.readType9Value(bb_";
  protected final String TEXT_65 = "_";
  protected final String TEXT_66 = ",";
  protected final String TEXT_67 = ",";
  protected final String TEXT_68 = ",";
  protected final String TEXT_69 = ");";
  protected final String TEXT_70 = NL + "\t\t\t\t";
  protected final String TEXT_71 = ".";
  protected final String TEXT_72 = " = new java.math.BigDecimal(new java.math.BigInteger(bb_";
  protected final String TEXT_73 = "_";
  protected final String TEXT_74 = "),0);";
  protected final String TEXT_75 = NL + "\t\t\t\t";
  protected final String TEXT_76 = ".";
  protected final String TEXT_77 = " = bb_";
  protected final String TEXT_78 = "_";
  protected final String TEXT_79 = ";";
  protected final String TEXT_80 = NL + "//////////////////////////////////////////////////" + NL + "DB Type of the column:";
  protected final String TEXT_81 = " should be X, 1, 2, 3, 9, B, T" + NL + "//////////////////////////////////////////////////";
  protected final String TEXT_82 = NL + "\t\t\textractEBCDICFieldUtil_";
  protected final String TEXT_83 = ".putValue_unOirginal_";
  protected final String TEXT_84 = "(";
  protected final String TEXT_85 = ",bbRecord_";
  protected final String TEXT_86 = ");";
  protected final String TEXT_87 = NL + "\t\t";
  protected final String TEXT_88 = " = null;";
  protected final String TEXT_89 = NL + "\tbbRecord_";
  protected final String TEXT_90 = ".clear();" + NL + "\tnb_line_";
  protected final String TEXT_91 = "++;" + NL + "}catch(java.lang.Exception ex_";
  protected final String TEXT_92 = "){";
  protected final String TEXT_93 = NL + "\t\tthrow(ex_";
  protected final String TEXT_94 = ");";
  protected final String TEXT_95 = NL + "\t\t\t";
  protected final String TEXT_96 = " = new ";
  protected final String TEXT_97 = "Struct();";
  protected final String TEXT_98 = NL + "    \t\t\t";
  protected final String TEXT_99 = ".";
  protected final String TEXT_100 = " = ";
  protected final String TEXT_101 = ".";
  protected final String TEXT_102 = ";";
  protected final String TEXT_103 = NL + "\t\t\textractEBCDICFieldUtil_";
  protected final String TEXT_104 = ".putValue_reject_";
  protected final String TEXT_105 = "(";
  protected final String TEXT_106 = ",";
  protected final String TEXT_107 = ");";
  protected final String TEXT_108 = "    " + NL + "\t\t    ";
  protected final String TEXT_109 = ".errorMessage = ex_";
  protected final String TEXT_110 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_111 = ";" + NL + "\t\t    ";
  protected final String TEXT_112 = " = null;";
  protected final String TEXT_113 = NL + "\t\t    System.err.println(ex_";
  protected final String TEXT_114 = ".getMessage());" + NL + "\t\t    ";
  protected final String TEXT_115 = " = null;";
  protected final String TEXT_116 = NL + "\t\t\t";
  protected final String TEXT_117 = ".errorMessage = ex_";
  protected final String TEXT_118 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_119 = ";";
  protected final String TEXT_120 = NL + "}";
  protected final String TEXT_121 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String field = ElementParameterParser.getValue(node, "__FIELD__");

String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;
String encoding  = ElementParameterParser.getValue(node, "__ENCODING__");
int schemaOptNum=100;
String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
	schemaOptNum  = Integer.parseInt(schemaOptNumStr);
}
List<Map<String, String>> trimSelects = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIMSELECT__");
String isTrimAllStr = ElementParameterParser.getValue(node,"__TRIMALL__");
boolean isTrimAll = (isTrimAllStr!=null&&!("").equals(isTrimAllStr))?("true").equals(isTrimAllStr):true;

IConnection inConn = null;
Integer byteLength = null;
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

IConnection outConn = null;
String firstConnName = "";
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
if(inConn!=null){
	IMetadataTable inputMetadataTable = inConn.getMetadataTable();
	for (IMetadataColumn inputCol : inputMetadataTable.getListColumns()) {
		if(inputCol.getLabel().equals(field) && JavaTypesManager.getJavaTypeFromId(inputCol.getTalendType()) == JavaTypesManager.BYTE_ARRAY){
			byteLength = inputCol.getLength();

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(inputCol.getLabel());
    stringBuffer.append(TEXT_7);
    
			break;
		}
	}
}

//set original columns
List<IMetadataColumn> newColumnList = new ArrayList<IMetadataColumn>();
if(outConn!=null && inConn!=null){

    stringBuffer.append(TEXT_8);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_10);
    
	IMetadataTable outputMetadataTable = outConn.getMetadataTable();
	IMetadataTable inputMetadataTable = inConn.getMetadataTable();
	int oirginalColumnsSize=0;
	for (IMetadataColumn outputCol : outputMetadataTable.getListColumns()) {
		if(outputCol.getLabel().equals(field)){
			continue;
		}
		boolean isOirginalColumn = false;
		for(IMetadataColumn inputCol : inputMetadataTable.getListColumns()){	
			JavaType stringType =  JavaTypesManager.getJavaTypeFromId(inputCol.getTalendType());
			if( outputCol.getLabel().equals( inputCol.getLabel()) ){
			isOirginalColumn = true;
				if(outputMetadataTable.getListColumns().size() <= schemaOptNum){
				if(stringType == JavaTypesManager.STRING){
					boolean trimStr = false;
					if(trimSelects!=null){
						for(Map<String, String> mapTrim : trimSelects){
							if(outputCol.getLabel().equals(mapTrim.get("SCHEMA_COLUMN")) && "true".equals(mapTrim.get("TRIM"))){
								trimStr = true;
								break;
							}
						}
					}

    stringBuffer.append(TEXT_11);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(outputCol.getLabel());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(inputCol.getLabel());
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && (trimStr)))?".trim()":"" );
    stringBuffer.append(TEXT_15);
    
				}else{

    stringBuffer.append(TEXT_16);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(outputCol.getLabel());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(inputCol.getLabel());
    stringBuffer.append(TEXT_20);
    
				}	
				}else{
					if(oirginalColumnsSize%schemaOptNum==0){
						isOirginalColumn = true;

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(oirginalColumnsSize/schemaOptNum);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_25);
    
					}
				}
				oirginalColumnsSize++;
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

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
	for(int valueN = 0 ; valueN < newColumnList.size();valueN++){//----- for begin
			IMetadataColumn column = newColumnList.get(valueN);
			Integer orgainLength = column.getOriginalLength();
			String orgainType = column.getType();
			Integer precision = column.getPrecision();
			if(precision==null) precision = 0;
			if(outputMetadataTable.getListColumns().size() <= schemaOptNum){
			if(orgainLength==null || orgainLength.intValue()==0 || orgainType==null || "".endsWith(orgainType.trim())) {

    stringBuffer.append(TEXT_29);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_30);
    
				continue;
			}

    stringBuffer.append(TEXT_31);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(orgainLength );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_37);
    
			if(orgainType.equals("X")){
					boolean trimStr = false;
					if(trimSelects!=null){
						for(Map<String, String> mapTrim : trimSelects){
							if(column.getLabel().equals(mapTrim.get("SCHEMA_COLUMN")) && "true".equals(mapTrim.get("TRIM"))){
								trimStr = true;
								break;
							}
						}
					}

    stringBuffer.append(TEXT_38);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_43);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && (trimStr)))?".trim()":"" );
    stringBuffer.append(TEXT_44);
    
			}else if(orgainType.equals("1")) {

    stringBuffer.append(TEXT_45);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_49);
    
			}else if(orgainType.equals("2")) {

    stringBuffer.append(TEXT_50);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_54);
    
			}else if(orgainType.equals("3") || orgainType.equals("9")) {
				String isImpliedDecimalStr = column.getAdditionalField().get("ImpliedDecimal");
				boolean isImpliedDecimal = (isImpliedDecimalStr!=null&&!("").equals(isImpliedDecimalStr))?("true").equals(isImpliedDecimalStr):true;
				if(orgainType.equals("3")){

    stringBuffer.append(TEXT_55);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_57);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(precision );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(isImpliedDecimal );
    stringBuffer.append(TEXT_61);
    
				}else {

    stringBuffer.append(TEXT_62);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_64);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(precision );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(isImpliedDecimal );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_69);
    
				}
			}else if(orgainType.equals("B")) {

    stringBuffer.append(TEXT_70);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_74);
    
			}else if (orgainType.equals("T")) {

    stringBuffer.append(TEXT_75);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_79);
    
			}else {

    stringBuffer.append(TEXT_80);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_81);
    
			}
			}else{
				if(valueN%schemaOptNum==0){

    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(valueN/schemaOptNum);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    
				}
			}
	}//----- for end
	if(!("").equals(rejectConnName) && rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_87);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_88);
    
	}

    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    
	if(dieOnError){

    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    
	}else{
		if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_95);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_97);
    
            int outputColumnSize=outConn.getMetadataTable().getListColumns().size();
            for(int rejectColNo=0;rejectColNo<outputColumnSize;rejectColNo++) {
            	IMetadataColumn column=outConn.getMetadataTable().getListColumns().get(rejectColNo);
            	if(outputColumnSize <= schemaOptNum){

    stringBuffer.append(TEXT_98);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_100);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_102);
    
				}else{
					if(rejectColNo%schemaOptNum==0){

    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(rejectColNo/schemaOptNum);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_107);
    
					}
				}
			}

    stringBuffer.append(TEXT_108);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_112);
    
		} else if(("").equals(rejectConnName)){

    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_115);
    
		} else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_116);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_119);
    
		}
	}

    stringBuffer.append(TEXT_120);
    
}

    stringBuffer.append(TEXT_121);
    return stringBuffer.toString();
  }
}
