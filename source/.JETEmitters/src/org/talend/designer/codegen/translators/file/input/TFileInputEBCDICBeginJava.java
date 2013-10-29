package org.talend.designer.codegen.translators.file.input;

import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TFileInputEBCDICBeginJava
{
  protected static String nl;
  public static synchronized TFileInputEBCDICBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputEBCDICBeginJava result = new TFileInputEBCDICBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t// open file" + NL + "\tjavax.xml.bind.JAXBContext jaxbContext_";
  protected final String TEXT_2 = " = javax.xml.bind.JAXBContext.newInstance(\"net.sf.cobol2j\");" + NL + "\tjavax.xml.bind.Unmarshaller unmarshaller_";
  protected final String TEXT_3 = " = jaxbContext_";
  protected final String TEXT_4 = ".createUnmarshaller();" + NL + "\tObject o_";
  protected final String TEXT_5 = " = unmarshaller_";
  protected final String TEXT_6 = ".unmarshal(new java.io.FileInputStream(";
  protected final String TEXT_7 = "));" + NL + "\tnet.sf.cobol2j.FileFormat fF_";
  protected final String TEXT_8 = " = (net.sf.cobol2j.FileFormat) o_";
  protected final String TEXT_9 = ";" + NL + "\tnet.sf.cobol2j.RecordSet rset_";
  protected final String TEXT_10 = " = new net.sf.cobol2j.RecordSet(new java.io.FileInputStream(";
  protected final String TEXT_11 = "), fF_";
  protected final String TEXT_12 = ");" + NL + "\tjava.util.Map recdefs_";
  protected final String TEXT_13 = " = new net.sf.cobol2j.RecordsMap(fF_";
  protected final String TEXT_14 = ");" + NL + "\t" + NL + "\t// read every record, for each record split into column definition" + NL + "\tList inrecord_";
  protected final String TEXT_15 = ";";
  protected final String TEXT_16 = NL + "\tclass EBCDICUtil_";
  protected final String TEXT_17 = "{";
  protected final String TEXT_18 = NL + "\t\t\t\tpublic void getValue_";
  protected final String TEXT_19 = "_";
  protected final String TEXT_20 = "(final ";
  protected final String TEXT_21 = "Struct ";
  protected final String TEXT_22 = ",List inrecord_";
  protected final String TEXT_23 = "){";
  protected final String TEXT_24 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_25 = ".";
  protected final String TEXT_26 = " = (String)inrecord_";
  protected final String TEXT_27 = ".get(";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_30 = ".";
  protected final String TEXT_31 = " = (";
  protected final String TEXT_32 = ")inrecord_";
  protected final String TEXT_33 = ".get(";
  protected final String TEXT_34 = ");";
  protected final String TEXT_35 = NL + "\t\t\t\t\t}";
  protected final String TEXT_36 = NL + "\t\t\t\t}";
  protected final String TEXT_37 = NL + "\t}" + NL + "\tEBCDICUtil_";
  protected final String TEXT_38 = " ebcdicUtil_";
  protected final String TEXT_39 = "=new EBCDICUtil_";
  protected final String TEXT_40 = "();";
  protected final String TEXT_41 = NL + "\twhile (rset_";
  protected final String TEXT_42 = ".hasNext()){" + NL + "\t\tinrecord_";
  protected final String TEXT_43 = " = rset_";
  protected final String TEXT_44 = ".next();" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\t\t";
  protected final String TEXT_46 = " = null;\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\tif(inrecord_";
  protected final String TEXT_48 = ".get(0).equals(\"";
  protected final String TEXT_49 = "\") || recdefs_";
  protected final String TEXT_50 = ".size() == 1 ){" + NL + "\t" + NL + "\t\t\t\t";
  protected final String TEXT_51 = " = new ";
  protected final String TEXT_52 = "Struct();";
  protected final String TEXT_53 = "\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_54 = ".";
  protected final String TEXT_55 = " = (String)inrecord_";
  protected final String TEXT_56 = ".get(";
  protected final String TEXT_57 = ");";
  protected final String TEXT_58 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_59 = ".";
  protected final String TEXT_60 = " = (";
  protected final String TEXT_61 = ")inrecord_";
  protected final String TEXT_62 = ".get(";
  protected final String TEXT_63 = ");";
  protected final String TEXT_64 = NL + "\t\t\t\t\t\tebcdicUtil_";
  protected final String TEXT_65 = ".getValue_";
  protected final String TEXT_66 = "_";
  protected final String TEXT_67 = "(";
  protected final String TEXT_68 = ",inrecord_";
  protected final String TEXT_69 = ");";
  protected final String TEXT_70 = "\t" + NL + "\t\t\t}\t";
  protected final String TEXT_71 = NL + "//////////////////////////////////////////////////" + NL + "the original size in the column:";
  protected final String TEXT_72 = " should be bigger than 0" + NL + "//////////////////////////////////////////////////";
  protected final String TEXT_73 = NL + "\t\t\tjava.io.FileInputStream fs_";
  protected final String TEXT_74 = " = new java.io.FileInputStream(";
  protected final String TEXT_75 = ");" + NL + "\t\t\tbyte[] bb_row_";
  protected final String TEXT_76 = " = new byte[";
  protected final String TEXT_77 = "];" + NL + "\t\t\tjava.nio.ByteBuffer bbRecord_";
  protected final String TEXT_78 = " = null;" + NL + "\t\t\tint iReadOffset_";
  protected final String TEXT_79 = " = 0;";
  protected final String TEXT_80 = NL + "\t\t\t\t\tclass EBCDICUtil_";
  protected final String TEXT_81 = "{";
  protected final String TEXT_82 = NL + "\t\t\t\t\t\t\tpublic void getValue_";
  protected final String TEXT_83 = "(final ";
  protected final String TEXT_84 = "Struct ";
  protected final String TEXT_85 = ",java.nio.ByteBuffer bbRecord_";
  protected final String TEXT_86 = ") throws java.lang.Exception{";
  protected final String TEXT_87 = NL + "//////////////////////////////////////////////////" + NL + "the original size in the column:";
  protected final String TEXT_88 = " in the schema should be bigger than 0 and DB Type shouldn't be null or Empty" + NL + "//////////////////////////////////////////////////";
  protected final String TEXT_89 = NL + "\t\t\t\t\t\t\tbyte[] bb_";
  protected final String TEXT_90 = "_";
  protected final String TEXT_91 = " = new byte[";
  protected final String TEXT_92 = "];" + NL + "\t\t\t\t\t\t\tbbRecord_";
  protected final String TEXT_93 = ".get(bb_";
  protected final String TEXT_94 = "_";
  protected final String TEXT_95 = ");";
  protected final String TEXT_96 = "\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_97 = ".";
  protected final String TEXT_98 = " = new String(bb_";
  protected final String TEXT_99 = "_";
  protected final String TEXT_100 = ",";
  protected final String TEXT_101 = ")";
  protected final String TEXT_102 = ";";
  protected final String TEXT_103 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_104 = ".";
  protected final String TEXT_105 = " = new java.lang.Float(java.nio.ByteBuffer.wrap(bb_";
  protected final String TEXT_106 = "_";
  protected final String TEXT_107 = ").order(java.nio.ByteOrder.BIG_ENDIAN).getFloat());";
  protected final String TEXT_108 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_109 = ".";
  protected final String TEXT_110 = " = new java.lang.Double(java.nio.ByteBuffer.wrap(bb_";
  protected final String TEXT_111 = "_";
  protected final String TEXT_112 = ").order(java.nio.ByteOrder.BIG_ENDIAN).getDouble());";
  protected final String TEXT_113 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_114 = ".";
  protected final String TEXT_115 = " = cobolConversion.EBCDICType3.readType3Value(bb_";
  protected final String TEXT_116 = "_";
  protected final String TEXT_117 = ",";
  protected final String TEXT_118 = ",";
  protected final String TEXT_119 = ");";
  protected final String TEXT_120 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_121 = ".";
  protected final String TEXT_122 = " = cobolConversion.EBCDICType9.readType9Value(bb_";
  protected final String TEXT_123 = "_";
  protected final String TEXT_124 = ",";
  protected final String TEXT_125 = ",";
  protected final String TEXT_126 = ",";
  protected final String TEXT_127 = ");";
  protected final String TEXT_128 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_129 = ".";
  protected final String TEXT_130 = " = new java.math.BigDecimal(new java.math.BigInteger(bb_";
  protected final String TEXT_131 = "_";
  protected final String TEXT_132 = "),0);";
  protected final String TEXT_133 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_134 = ".";
  protected final String TEXT_135 = " = bb_";
  protected final String TEXT_136 = "_";
  protected final String TEXT_137 = ";";
  protected final String TEXT_138 = NL + "//////////////////////////////////////////////////" + NL + "DB Type of the column:";
  protected final String TEXT_139 = " should be X, 1, 2, 3, 9, B, T" + NL + "//////////////////////////////////////////////////";
  protected final String TEXT_140 = NL + "\t\t\t\t\t\t\t}";
  protected final String TEXT_141 = NL + "\t\t\t\t\t\t\t}";
  protected final String TEXT_142 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tEBCDICUtil_";
  protected final String TEXT_143 = " ebcdicUtil_";
  protected final String TEXT_144 = "=new EBCDICUtil_";
  protected final String TEXT_145 = "();";
  protected final String TEXT_146 = NL + "\t\t\twhile((iReadOffset_";
  protected final String TEXT_147 = " = fs_";
  protected final String TEXT_148 = ".read(bb_row_";
  protected final String TEXT_149 = "))!= -1){" + NL + "\t\t\t\tbbRecord_";
  protected final String TEXT_150 = " = java.nio.ByteBuffer.wrap(bb_row_";
  protected final String TEXT_151 = ");";
  protected final String TEXT_152 = NL + "//////////////////////////////////////////////////" + NL + "the original size in the column:";
  protected final String TEXT_153 = " in the schema should be bigger than 0 and DB Type shouldn't be null or Empty" + NL + "//////////////////////////////////////////////////";
  protected final String TEXT_154 = NL + "\t\t\t\t\t\t\tbyte[] bb_";
  protected final String TEXT_155 = "_";
  protected final String TEXT_156 = " = new byte[";
  protected final String TEXT_157 = "];" + NL + "\t\t\t\t\t\t\tbbRecord_";
  protected final String TEXT_158 = ".get(bb_";
  protected final String TEXT_159 = "_";
  protected final String TEXT_160 = ");";
  protected final String TEXT_161 = "\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_162 = ".";
  protected final String TEXT_163 = " = new String(bb_";
  protected final String TEXT_164 = "_";
  protected final String TEXT_165 = ",";
  protected final String TEXT_166 = ")";
  protected final String TEXT_167 = ";";
  protected final String TEXT_168 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_169 = ".";
  protected final String TEXT_170 = " = new java.lang.Float(java.nio.ByteBuffer.wrap(bb_";
  protected final String TEXT_171 = "_";
  protected final String TEXT_172 = ").order(java.nio.ByteOrder.BIG_ENDIAN).getFloat());";
  protected final String TEXT_173 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_174 = ".";
  protected final String TEXT_175 = " = new java.lang.Double(java.nio.ByteBuffer.wrap(bb_";
  protected final String TEXT_176 = "_";
  protected final String TEXT_177 = ").order(java.nio.ByteOrder.BIG_ENDIAN).getDouble());";
  protected final String TEXT_178 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_179 = ".";
  protected final String TEXT_180 = " = cobolConversion.EBCDICType3.readType3Value(bb_";
  protected final String TEXT_181 = "_";
  protected final String TEXT_182 = ",";
  protected final String TEXT_183 = ",";
  protected final String TEXT_184 = ");";
  protected final String TEXT_185 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_186 = ".";
  protected final String TEXT_187 = " = cobolConversion.EBCDICType9.readType9Value(bb_";
  protected final String TEXT_188 = "_";
  protected final String TEXT_189 = ",";
  protected final String TEXT_190 = ",";
  protected final String TEXT_191 = ",";
  protected final String TEXT_192 = ");";
  protected final String TEXT_193 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_194 = ".";
  protected final String TEXT_195 = " = new java.math.BigDecimal(new java.math.BigInteger(bb_";
  protected final String TEXT_196 = "_";
  protected final String TEXT_197 = "),0);";
  protected final String TEXT_198 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_199 = ".";
  protected final String TEXT_200 = " = bb_";
  protected final String TEXT_201 = "_";
  protected final String TEXT_202 = ";";
  protected final String TEXT_203 = NL + "//////////////////////////////////////////////////" + NL + "DB Type of the column:";
  protected final String TEXT_204 = " should be X, 1, 2, 3, 9, B, T" + NL + "//////////////////////////////////////////////////";
  protected final String TEXT_205 = NL + "\t\t\t\t\t\t\tebcdicUtil_";
  protected final String TEXT_206 = ".getValue_";
  protected final String TEXT_207 = "(";
  protected final String TEXT_208 = ",bbRecord_";
  protected final String TEXT_209 = ");";
  protected final String TEXT_210 = NL + "\t\t\t\tbbRecord_";
  protected final String TEXT_211 = ".clear();";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    
	String filename = ElementParameterParser.getValue(node,"__FILENAME__");
	String copybook = ElementParameterParser.getValue(node,"__COPYBOOK__");
	String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
	String customSetOriginalLengthStr = ElementParameterParser.getValue(node,"__NO_X2CJ_FILE__");
	boolean customSetOriginalLength = (customSetOriginalLengthStr!=null&&!("").equals(customSetOriginalLengthStr))?("true").equals(customSetOriginalLengthStr):true;
	List<Map<String, String>> trimSelects = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIMSELECT__");
	String isTrimAllStr = ElementParameterParser.getValue(node,"__TRIMALL__");
	boolean isTrimAll = (isTrimAllStr!=null&&!("").equals(isTrimAllStr))?("true").equals(isTrimAllStr):true;
	int schemaOptNum=100;
	String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
	if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
		schemaOptNum  = Integer.parseInt(schemaOptNumStr);
	}
	boolean isOptimizeCode=false;

if(!customSetOriginalLength){//------11111

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append( copybook );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( filename );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    
		List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		List<Map<String, String>> schemas = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SCHEMAS__");
		for(Map<String, String> schemaMap : schemas) {
			String schemaName = schemaMap.get("SCHEMA");
			if(conns != null && conns.size() > 0){
				for(IConnection conn : conns){
					if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
						if(schemaName.equals(conn.getMetadataTable().getLabel())){
							IMetadataTable justMetadata = conn.getMetadataTable();
							List<IMetadataColumn> justColumnList = justMetadata.getListColumns();
							if(schemaOptNum<justColumnList.size()){
								isOptimizeCode=true;
							}
							break;
						}
					}
				}
			}
			if(isOptimizeCode){
				break;
			}
		}
	if(isOptimizeCode){

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
	
	for(Map<String, String> schemaMap : schemas) {//------AAA0
		String schemaName = schemaMap.get("SCHEMA");
		IConnection justConn = null; //------->get the right output connection--->to get the columns info
		if(conns != null && conns.size() > 0){
			for(IConnection conn : conns){
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
					if(schemaName.equals(conn.getMetadataTable().getLabel())){
						justConn = conn;
						break;
					}
				}
			}
		}

		if(justConn != null){//------BBB0
			IMetadataTable justMetadata = justConn.getMetadataTable();
			List<IMetadataColumn> justColumnList = justMetadata.getListColumns();
			int sizeListColumns = justColumnList.size();
				for (int valueN=0; valueN<sizeListColumns; valueN++) {
					IMetadataColumn column = justColumnList.get(valueN);
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					if(valueN%schemaOptNum==0){

    stringBuffer.append(TEXT_18);
    stringBuffer.append(schemaName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(valueN/schemaOptNum);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    
					}
					if(javaType == JavaTypesManager.STRING){

    stringBuffer.append(TEXT_24);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_28);
    
					}else{

    stringBuffer.append(TEXT_29);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(javaType.getLabel() );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_34);
    
					}
				    if((valueN+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_35);
    
					}
				}
				if(sizeListColumns>0&&(sizeListColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_36);
    
				}
		}
	}

    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    
	}

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    

    		if (conns!=null && conns.size()>0) {
				for (int i=0;i<conns.size();i++) {
					IConnection connTemp = conns.get(i);
					if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_45);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_46);
    
					}
				}
    		}
    		
	for(Map<String, String> schemaMap : schemas) {//------AAA0
		String schemaName = schemaMap.get("SCHEMA");
		String code = schemaMap.get("CODE");
	
		IConnection justConn = null; //------->get the right output connection--->to get the columns info
		if(conns != null && conns.size() > 0){
			for(IConnection conn : conns){
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
					if(schemaName.equals(conn.getMetadataTable().getLabel())){
						justConn = conn;
						break;
					}
				}
			}
		}

		if(justConn != null){//------BBB0
		IMetadataTable justMetadata = justConn.getMetadataTable();
		List<IMetadataColumn> justColumnList = justMetadata.getListColumns();

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(code );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_52);
    
				int sizeListColumns = justColumnList.size();
				for (int valueN=0; valueN<sizeListColumns; valueN++) {
					IMetadataColumn column = justColumnList.get(valueN);
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					if(!isOptimizeCode){
						if(javaType == JavaTypesManager.STRING){

    stringBuffer.append(TEXT_53);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_57);
    
						}else {

    stringBuffer.append(TEXT_58);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(javaType.getLabel() );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_63);
    
						}
					}else{
						if(valueN%schemaOptNum==0){

    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(schemaName);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(valueN/schemaOptNum);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(justConn.getName() );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    
						}
					}
				}

    stringBuffer.append(TEXT_70);
    
		}//------BBB0
	}//------AAA0
}else{//------11111
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	if(conns!=null && conns.size()>0){//------conns
		IConnection conn = conns.get(0);
			int totalRealSize = 0;
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//--------AAA00
				IMetadataTable justMetadata = conn.getMetadataTable();
				List<IMetadataColumn> justColumnList = justMetadata.getListColumns();
				int sizeListColumns = justColumnList.size();
				if(schemaOptNum < sizeListColumns){
					isOptimizeCode=true;
				}
				for (int valueN=0; valueN<sizeListColumns; valueN++) {//------BBB00
					IMetadataColumn column = justColumnList.get(valueN);
					Integer orgainLength  = column.getOriginalLength();
					if(orgainLength==null || orgainLength.intValue()==0) {

    stringBuffer.append(TEXT_71);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_72);
    
						break;
					}
					totalRealSize = totalRealSize + orgainLength.intValue();
				}//------BBB00
			}//--------AAA00

    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(totalRealSize );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    
			if(isOptimizeCode){//------B01
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//------B02
					IMetadataTable justMetadata = conn.getMetadataTable();
					List<IMetadataColumn> justColumnList = justMetadata.getListColumns();
					int sizeListColumns = justColumnList.size();
					if(sizeListColumns>0){

    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    
						for (int valueN=0; valueN<sizeListColumns; valueN++) {//------B02
							IMetadataColumn column = justColumnList.get(valueN);
							Integer orgainLength = column.getOriginalLength();
							String orgainType = column.getType();
							Integer precision = column.getPrecision();
							if(valueN%schemaOptNum==0){

    stringBuffer.append(TEXT_82);
    stringBuffer.append(valueN/schemaOptNum);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    
							}
							if(precision==null) precision = 0;
							if(orgainLength==null || orgainLength.intValue()==0 || orgainType==null || "".endsWith(orgainType.trim())) {

    stringBuffer.append(TEXT_87);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_88);
    
								continue;
							}

    stringBuffer.append(TEXT_89);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(orgainLength );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    
							if(orgainType.equals("X")){

    stringBuffer.append(TEXT_96);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_98);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_101);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(valueN).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_102);
    
							}else if(orgainType.equals("1")) {

    stringBuffer.append(TEXT_103);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_105);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    
							}else if(orgainType.equals("2")) {

    stringBuffer.append(TEXT_108);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_110);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    
							}else if(orgainType.equals("3") || orgainType.equals("9")) {
								String isImpliedDecimalStr = column.getAdditionalField().get("ImpliedDecimal");
								boolean isImpliedDecimal = (isImpliedDecimalStr!=null&&!("").equals(isImpliedDecimalStr))?("true").equals(isImpliedDecimalStr):true;
								if(orgainType.equals("3")){

    stringBuffer.append(TEXT_113);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_115);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(precision );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(isImpliedDecimal );
    stringBuffer.append(TEXT_119);
    
								}else{

    stringBuffer.append(TEXT_120);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_122);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(precision );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(isImpliedDecimal );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_127);
    
								}
							}else if(orgainType.equals("B")) {

    stringBuffer.append(TEXT_128);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_130);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    
							}else if (orgainType.equals("T")) {

    stringBuffer.append(TEXT_133);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_135);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    
							}else {

    stringBuffer.append(TEXT_138);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_139);
    
							}
				    		if((valueN+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_140);
    
							}
						}//------B02
						if(sizeListColumns>0&&(sizeListColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_141);
    
						}

    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    
					}
				}//------B02
			}//------B01

    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//------BBB1
					IMetadataTable justMetadata = conn.getMetadataTable();
					List<IMetadataColumn> justColumnList = justMetadata.getListColumns();
					int sizeListColumns = justColumnList.size();
					for (int valueN=0; valueN<sizeListColumns; valueN++) {//------BBB12
						IMetadataColumn column = justColumnList.get(valueN);
						Integer orgainLength = column.getOriginalLength();
						String orgainType = column.getType();
						Integer precision = column.getPrecision();
						if(!isOptimizeCode){
							if(precision==null) precision = 0;
							if(orgainLength==null || orgainLength.intValue()==0 || orgainType==null || "".endsWith(orgainType.trim())) {

    stringBuffer.append(TEXT_152);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_153);
    
								continue;
							}

    stringBuffer.append(TEXT_154);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(orgainLength );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    
							if(orgainType.equals("X")){

    stringBuffer.append(TEXT_161);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_163);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_166);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(valueN).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_167);
    
							}else if(orgainType.equals("1")) {

    stringBuffer.append(TEXT_168);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_170);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    
							}else if(orgainType.equals("2")) {

    stringBuffer.append(TEXT_173);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_175);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    
							}else if(orgainType.equals("3") || orgainType.equals("9")) {
								String isImpliedDecimalStr = column.getAdditionalField().get("ImpliedDecimal");
								boolean isImpliedDecimal = (isImpliedDecimalStr!=null&&!("").equals(isImpliedDecimalStr))?("true").equals(isImpliedDecimalStr):true;
								if(orgainType.equals("3")){

    stringBuffer.append(TEXT_178);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_180);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(precision );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(isImpliedDecimal );
    stringBuffer.append(TEXT_184);
    
								}else{

    stringBuffer.append(TEXT_185);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_187);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(precision );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(isImpliedDecimal );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_192);
    
								}
							}else if(orgainType.equals("B")) {

    stringBuffer.append(TEXT_193);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_195);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    
							}else if (orgainType.equals("T")) {

    stringBuffer.append(TEXT_198);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_200);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    
							}else {

    stringBuffer.append(TEXT_203);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_204);
    
							}
						}else{
							if(valueN%schemaOptNum==0){

    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(valueN/schemaOptNum);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    
							}
						}
					}//------BBB12
			}//------BBB1

    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    
	}//------conns
}//------11111

    return stringBuffer.toString();
  }
}
