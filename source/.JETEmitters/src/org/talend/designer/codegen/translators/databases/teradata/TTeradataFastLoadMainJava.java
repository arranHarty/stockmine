package org.talend.designer.codegen.translators.databases.teradata;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class TTeradataFastLoadMainJava
{
  protected static String nl;
  public static synchronized TTeradataFastLoadMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTeradataFastLoadMainJava result = new TTeradataFastLoadMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "\t";
  protected final String TEXT_3 = NL + "if(";
  protected final String TEXT_4 = ".";
  protected final String TEXT_5 = "==null){" + NL + "\t";
  protected final String TEXT_6 = ".setNull(";
  protected final String TEXT_7 = ",java.sql.Types.CHAR);" + NL + "\t";
  protected final String TEXT_8 = NL + "if(";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = "==null){" + NL + "\t";
  protected final String TEXT_11 = ".setNull(";
  protected final String TEXT_12 = ",java.sql.Types.DATE);" + NL + "\t";
  protected final String TEXT_13 = NL + "if(";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = "==null){";
  protected final String TEXT_16 = NL + "    ";
  protected final String TEXT_17 = ".setNull(";
  protected final String TEXT_18 = ",java.sql.Types.TIMESTAMP);";
  protected final String TEXT_19 = NL + "if(";
  protected final String TEXT_20 = ".";
  protected final String TEXT_21 = "==null){" + NL + "\t";
  protected final String TEXT_22 = ".setNull(";
  protected final String TEXT_23 = ",java.sql.Types.ARRAY);\t\t\t" + NL + "\t";
  protected final String TEXT_24 = NL + "if(";
  protected final String TEXT_25 = ".";
  protected final String TEXT_26 = "==null){" + NL + "\t";
  protected final String TEXT_27 = ".setNull(";
  protected final String TEXT_28 = ",java.sql.Types.INTEGER);" + NL + "\t";
  protected final String TEXT_29 = NL + "if(";
  protected final String TEXT_30 = ".";
  protected final String TEXT_31 = "==null){" + NL + "\t";
  protected final String TEXT_32 = ".setNull(";
  protected final String TEXT_33 = ",java.sql.Types.VARCHAR);" + NL + "\t";
  protected final String TEXT_34 = NL + "if(";
  protected final String TEXT_35 = ".";
  protected final String TEXT_36 = "==null){" + NL + "\t";
  protected final String TEXT_37 = ".setNull(";
  protected final String TEXT_38 = ",java.sql.Types.OTHER);" + NL + "\t";
  protected final String TEXT_39 = NL + "if(";
  protected final String TEXT_40 = ".";
  protected final String TEXT_41 = "==null){" + NL + "\t";
  protected final String TEXT_42 = ".setNull(";
  protected final String TEXT_43 = ",java.sql.Types.BOOLEAN);\t" + NL + "\t";
  protected final String TEXT_44 = NL + "if(";
  protected final String TEXT_45 = ".";
  protected final String TEXT_46 = "==null){" + NL + "\t";
  protected final String TEXT_47 = ".setNull(";
  protected final String TEXT_48 = ",java.sql.Types.DOUBLE);\t" + NL + "\t";
  protected final String TEXT_49 = NL + "if(";
  protected final String TEXT_50 = ".";
  protected final String TEXT_51 = "==null){" + NL + "\t";
  protected final String TEXT_52 = ".setNull(";
  protected final String TEXT_53 = ",java.sql.Types.FLOAT);\t" + NL + "\t";
  protected final String TEXT_54 = NL + NL + "}else{" + NL + "" + NL + "\t";
  protected final String TEXT_55 = NL + "\t";
  protected final String TEXT_56 = NL + "\tif(";
  protected final String TEXT_57 = ".";
  protected final String TEXT_58 = "==null){" + NL + "\t";
  protected final String TEXT_59 = NL + "\tif((\"null\").equals(String.valueOf(";
  protected final String TEXT_60 = ".";
  protected final String TEXT_61 = ").toLowerCase())){" + NL + "\t";
  protected final String TEXT_62 = NL + "\t\t";
  protected final String TEXT_63 = ".setNull(";
  protected final String TEXT_64 = ",java.sql.Types.CHAR);" + NL + "\t\t" + NL + "\t}else if(";
  protected final String TEXT_65 = ".";
  protected final String TEXT_66 = " == '\\0'){" + NL + "\t" + NL + "\t\t";
  protected final String TEXT_67 = ".setString(";
  protected final String TEXT_68 = ",\"\");" + NL + "\t\t" + NL + "\t}else{" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_69 = ".setString(";
  protected final String TEXT_70 = ",String.valueOf(";
  protected final String TEXT_71 = ".";
  protected final String TEXT_72 = "));" + NL + "\t}" + NL + "\t";
  protected final String TEXT_73 = NL + "\tif(";
  protected final String TEXT_74 = ".";
  protected final String TEXT_75 = "!=null){" + NL + "\t" + NL + "\t\t";
  protected final String TEXT_76 = ".setDate(";
  protected final String TEXT_77 = ",new java.sql.Date(";
  protected final String TEXT_78 = ".";
  protected final String TEXT_79 = ".getTime()));" + NL + "\t\t" + NL + "\t}else{" + NL + "\t" + NL + "\t\t";
  protected final String TEXT_80 = ".setNull(";
  protected final String TEXT_81 = ",java.sql.Types.DATE);" + NL + "\t\t" + NL + "\t}" + NL + "\t";
  protected final String TEXT_82 = NL + "\tif(";
  protected final String TEXT_83 = ".";
  protected final String TEXT_84 = "!=null){" + NL + "\t    " + NL + "\t   ";
  protected final String TEXT_85 = ".setTimestamp(";
  protected final String TEXT_86 = ",new java.sql.Timestamp(";
  protected final String TEXT_87 = ".";
  protected final String TEXT_88 = ".getTime()));" + NL + "\t        " + NL + "\t}else{" + NL + "\t    " + NL + "\t   ";
  protected final String TEXT_89 = ".setNull(";
  protected final String TEXT_90 = ",java.sql.Types.TIMESTAMP);" + NL + "\t        " + NL + "    }" + NL + "\t";
  protected final String TEXT_91 = NL + "\t";
  protected final String TEXT_92 = ".set";
  protected final String TEXT_93 = "(";
  protected final String TEXT_94 = ",";
  protected final String TEXT_95 = ".";
  protected final String TEXT_96 = ");" + NL + "\t";
  protected final String TEXT_97 = NL + "\t\t" + NL + "}" + NL + "\t";
  protected final String TEXT_98 = NL + "        try{" + NL + "\t\tpstmt_";
  protected final String TEXT_99 = ".addBatch();" + NL + "        }catch(java.lang.Exception e)" + NL + "        {";
  protected final String TEXT_100 = NL + "\t\t\t\t";
  protected final String TEXT_101 = NL + "\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_102 = " - \" + e.getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_103 = NL + "                throw(e);";
  protected final String TEXT_104 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_105 = " - \" + e.getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_106 = NL + "                        ";
  protected final String TEXT_107 = ".";
  protected final String TEXT_108 = " = ";
  protected final String TEXT_109 = ".";
  protected final String TEXT_110 = ";";
  protected final String TEXT_111 = NL + "                    ";
  protected final String TEXT_112 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_113 = ";";
  protected final String TEXT_114 = NL + "                    System.err.print(e.getMessage());";
  protected final String TEXT_115 = NL + "        }" + NL + "\t";
  protected final String TEXT_116 = NL + "        try{" + NL + "\t\tpstmt_";
  protected final String TEXT_117 = ".addBatch();" + NL + "        }catch(java.lang.Exception e)" + NL + "        {";
  protected final String TEXT_118 = NL + "\t\t\t\t";
  protected final String TEXT_119 = NL + "\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_120 = " - \" + e.getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_121 = NL + "                throw(e);";
  protected final String TEXT_122 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_123 = " - \" + e.getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_124 = NL + "                        ";
  protected final String TEXT_125 = ".";
  protected final String TEXT_126 = " = ";
  protected final String TEXT_127 = ".";
  protected final String TEXT_128 = ";";
  protected final String TEXT_129 = NL + "                    ";
  protected final String TEXT_130 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_131 = ";";
  protected final String TEXT_132 = NL + "                    System.err.print(e.getMessage());";
  protected final String TEXT_133 = NL + "        }";
  protected final String TEXT_134 = NL;
  protected final String TEXT_135 = NL + NL + "\t\tjava.sql.ResultSet rs_";
  protected final String TEXT_136 = " = pstmt_";
  protected final String TEXT_137 = ".executeQuery();" + NL + "\t\tint checkCount_";
  protected final String TEXT_138 = " = -1;" + NL + "\t\twhile(rs_";
  protected final String TEXT_139 = ".next())" + NL + "\t\t{" + NL + "\t\t\tcheckCount_";
  protected final String TEXT_140 = " = rs_";
  protected final String TEXT_141 = ".getInt(1);" + NL + "\t\t}" + NL + "\t\tif(checkCount_";
  protected final String TEXT_142 = " > 0)" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_143 = NL + "            try{" + NL + "\t\tpstmt_";
  protected final String TEXT_144 = ".addBatch();" + NL + "\t\t\t}catch(java.lang.Exception e)" + NL + "\t\t\t{" + NL + "\t            ";
  protected final String TEXT_145 = NL + "\t\t\t\t\t";
  protected final String TEXT_146 = NL + "\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_147 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_148 = NL + "\t                throw(e);" + NL + "\t                ";
  protected final String TEXT_149 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_150 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_151 = NL + "\t                        ";
  protected final String TEXT_152 = ".";
  protected final String TEXT_153 = " = ";
  protected final String TEXT_154 = ".";
  protected final String TEXT_155 = ";" + NL + "\t                        ";
  protected final String TEXT_156 = NL + "\t                    ";
  protected final String TEXT_157 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_158 = ";" + NL + "\t                    ";
  protected final String TEXT_159 = NL + "\t                    System.err.print(e.getMessage());" + NL + "\t                    ";
  protected final String TEXT_160 = NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\telse" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_161 = NL + "            try{" + NL + "\t\tpstmt_";
  protected final String TEXT_162 = ".addBatch();" + NL + "\t\t\t}catch(java.lang.Exception e)" + NL + "\t\t\t{" + NL + "\t            ";
  protected final String TEXT_163 = NL + "\t\t\t\t\t";
  protected final String TEXT_164 = NL + "\t\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_165 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_166 = NL + "\t                throw(e);" + NL + "\t                ";
  protected final String TEXT_167 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_168 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_169 = NL + "\t                        ";
  protected final String TEXT_170 = ".";
  protected final String TEXT_171 = " = ";
  protected final String TEXT_172 = ".";
  protected final String TEXT_173 = ";" + NL + "\t                        ";
  protected final String TEXT_174 = NL + "\t                    ";
  protected final String TEXT_175 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_176 = ";" + NL + "\t                    ";
  protected final String TEXT_177 = NL + "\t                    System.err.print(e.getMessage());" + NL + "\t                    ";
  protected final String TEXT_178 = NL + "\t\t\t}" + NL + "\t\t}" + NL;
  protected final String TEXT_179 = NL;
  protected final String TEXT_180 = NL + NL + "    try{" + NL + "\t\tpstmt_";
  protected final String TEXT_181 = ".addBatch();" + NL + "\t}catch(java.lang.Exception e)" + NL + "\t{";
  protected final String TEXT_182 = NL + "\t\t\t";
  protected final String TEXT_183 = NL + "\t\t\t\tlog.fatal(\"";
  protected final String TEXT_184 = " - \" + e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_185 = NL + "            throw(e);";
  protected final String TEXT_186 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_187 = " - \" + e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_188 = NL + "                    ";
  protected final String TEXT_189 = ".";
  protected final String TEXT_190 = " = ";
  protected final String TEXT_191 = ".";
  protected final String TEXT_192 = ";";
  protected final String TEXT_193 = NL + "                ";
  protected final String TEXT_194 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_195 = ";";
  protected final String TEXT_196 = NL + "                System.err.print(e.getMessage());";
  protected final String TEXT_197 = NL + "\t}" + NL + "\tif(updatedCount_";
  protected final String TEXT_198 = " == 0) {" + NL + "\t\t";
  protected final String TEXT_199 = NL + "        try{" + NL + "\t\tpstmt_";
  protected final String TEXT_200 = ".addBatch();" + NL + "            nb_line_inserted_";
  protected final String TEXT_201 = "++;" + NL + "\t\t}catch(java.lang.Exception e)" + NL + "\t\t{";
  protected final String TEXT_202 = NL + "\t\t\t\t";
  protected final String TEXT_203 = NL + "\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_204 = " - \" + e.getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_205 = NL + "                throw(e);";
  protected final String TEXT_206 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_207 = " - \" + e.getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_208 = NL + "                        ";
  protected final String TEXT_209 = ".";
  protected final String TEXT_210 = " = ";
  protected final String TEXT_211 = ".";
  protected final String TEXT_212 = ";";
  protected final String TEXT_213 = NL + "                    ";
  protected final String TEXT_214 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_215 = ";";
  protected final String TEXT_216 = NL + "                    System.err.print(e.getMessage());";
  protected final String TEXT_217 = NL + "\t\t}" + NL + "\t} else {" + NL + "\t    nb_line_update_";
  protected final String TEXT_218 = " ++;" + NL + "\t}" + NL;
  protected final String TEXT_219 = NL + "    try{" + NL + "\t\tpstmt_";
  protected final String TEXT_220 = ".addBatch();" + NL + "\t\t}catch(java.lang.Exception e)" + NL + "\t\t{";
  protected final String TEXT_221 = NL + "\t\t\t\t";
  protected final String TEXT_222 = NL + "\t\t\t\t\tlog.fatal(\"";
  protected final String TEXT_223 = " - \" + e.getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_224 = NL + "                throw(e);";
  protected final String TEXT_225 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_226 = " - \" + e.getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_227 = NL + "                        ";
  protected final String TEXT_228 = ".";
  protected final String TEXT_229 = " = ";
  protected final String TEXT_230 = ".";
  protected final String TEXT_231 = ";";
  protected final String TEXT_232 = NL + "                    ";
  protected final String TEXT_233 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_234 = ";";
  protected final String TEXT_235 = NL + "                    System.err.print(e.getMessage());";
  protected final String TEXT_236 = NL + "\t\t}" + NL + "\t";
  protected final String TEXT_237 = NL + "                log4jSb_";
  protected final String TEXT_238 = ".append(";
  protected final String TEXT_239 = ".";
  protected final String TEXT_240 = ");";
  protected final String TEXT_241 = NL + "                \tlog4jSb_";
  protected final String TEXT_242 = ".append(\"|\");";
  protected final String TEXT_243 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_244 = " - Writing the record \" + nb_line_";
  protected final String TEXT_245 = " + \" \" + log4jSb_";
  protected final String TEXT_246 = ");" + NL + "\t\t\tlog4jSb_";
  protected final String TEXT_247 = ".delete(0,log4jSb_";
  protected final String TEXT_248 = ".length());" + NL + "\t";
  protected final String TEXT_249 = NL + "\t                ";
  protected final String TEXT_250 = ".";
  protected final String TEXT_251 = " = ";
  protected final String TEXT_252 = ".";
  protected final String TEXT_253 = ";" + NL + "\t                ";
  protected final String TEXT_254 = NL + "\t    commitCounter_";
  protected final String TEXT_255 = "++;";
  protected final String TEXT_256 = NL + "        " + NL + "        if(commitEvery_";
  protected final String TEXT_257 = " <= commitCounter_";
  protected final String TEXT_258 = "){" + NL + "        " + NL + "\t\t\tpstmt_";
  protected final String TEXT_259 = ".executeBatch();" + NL + "\t\t\tpstmt_";
  protected final String TEXT_260 = ".clearBatch();" + NL + "        \tcommitCounter_";
  protected final String TEXT_261 = "=0;" + NL + "        \t" + NL + "        }\t" + NL + "\t";
  protected final String TEXT_262 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	String cid = node.getUniqueName();
	
	String dataAction = "INSERT";
    String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	String tableName = ElementParameterParser.getValue(node,"__TABLE__");
            
    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
	
	String incomingConnName = null;
	List<IMetadataColumn> columnList = null;
	
	List< ? extends IConnection> conns = node.getIncomingConnections();
	if(conns!=null && conns.size()>0){
		IConnection conn = conns.get(0);
		incomingConnName = conn.getName();
	}
	
	List<IMetadataTable> metadatas = node.getMetadataList();
	
	if(metadatas != null && metadatas.size()>0){
		IMetadataTable metadata = metadatas.get(0);
		if(metadata != null){
			columnList = metadata.getListColumns();
		}
	}
	
    String rejectConnName = null;
    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
    if(rejectConns != null && rejectConns.size() > 0) {
        IConnection rejectConn = rejectConns.get(0);
        rejectConnName = rejectConn.getName();
    }
    List<IMetadataColumn> rejectColumnList = null;
    IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
    if(metadataTable != null) {
        rejectColumnList = metadataTable.getListColumns();      
    }
    
    List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

///////////////Inner Class Column///////////////////////////
class Column{

	IMetadataColumn column;
	
	String name;
	
	String sqlStmt;
	
	String value;
	
	boolean addCol;
	
	List<Column> replacement = new ArrayList<Column>();
	
	public Column(String colName,String sqlStmt,boolean addCol){
		this.column = null;
		this.name = colName;
		this.sqlStmt = sqlStmt;
		this.value = "?";
		this.addCol =addCol;
	}
	
	public Column(IMetadataColumn column){
		this.column = column;
		this.name = column.getLabel();
		this.sqlStmt = "=?";
		this.value = "?";
		this.addCol =false;
	}
	
	public boolean isReplaced(){
		return replacement.size()>0;
	}
	
	public void replace(Column column){
		this.replacement.add(column);
	}
	
	public List<Column> getReplacement(){
		return this.replacement;
	}
	
	public void setColumn(IMetadataColumn column){
		this.column = column;
	}
	
	public IMetadataColumn getColumn(){
		return this.column;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}
	
	public void setIsAddCol(boolean isadd){
		this.addCol = isadd;
	}
	
	public boolean isAddCol(){
		return this.addCol;
	}
	
	public void setSqlStmt(String sql){
		this.sqlStmt = sql;
	}
	
	public String getSqlStmt(){
		return this.sqlStmt;
	}
	
	public void setValue(String value){
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}
}
	StringBuilder insertColName = new StringBuilder();
	
	StringBuilder insertValueStmt = new StringBuilder();
	
	StringBuilder updateSetStmt = new StringBuilder();
	
	StringBuilder updateWhereStmt = new StringBuilder();
	
	List<Column> stmtStructure =  new LinkedList<Column>();
	
for(IMetadataColumn column:columnList){
	stmtStructure.add(new Column(column));
}

////////////////////////////////////////////////////////////
List<Column> colStruct =  new ArrayList();
for(Column colStmt:stmtStructure){
	if(!colStmt.isReplaced()&&!colStmt.isAddCol()){
		colStruct.add(colStmt);
	}
}

/////////////////Inner Class Operation///////////////////////
class Operation{
	public static final int NORMAL_TYPE = 0;
	public static final int INSERT_TYPE = 1;
	public static final int UPDATE_TYPE = 2;
	
	public String generateType(String typeToGenerate){
		if(("byte[]").equals(typeToGenerate)){
 	  		typeToGenerate = "Bytes";
 	   	}else if(("java.util.Date").equals(typeToGenerate)){
 	   		typeToGenerate = "Date";
 	  	}else if(("java.util.Timestamp").equals(typeToGenerate)){
            typeToGenerate = "Timestamp";
        }else if(("Integer").equals(typeToGenerate)){
 	   		typeToGenerate = "Int";
 	   	}else{
			typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
		}
		return typeToGenerate;
	}
	
	public void generateSetStmt(String typeToGenerate,Column column,
								int counter,String incomingConnName,String cid,int stmtType){
		boolean isObject = false;								
		String prefix = null;								
		if(stmtType == Operation.NORMAL_TYPE){
			prefix = "pstmt_";
		}else if(stmtType == Operation.INSERT_TYPE){
			prefix = "pstmtInsert_";
		}else if(stmtType == Operation.UPDATE_TYPE){
			prefix = "pstmtUpdate_";
		}
		
    stringBuffer.append(TEXT_2);
    if(("Character").equals(typeToGenerate)){
	isObject = true;
	
    stringBuffer.append(TEXT_3);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_7);
    
	}else if(("Date").equals(typeToGenerate)){
	isObject = true;
	
    stringBuffer.append(TEXT_8);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_12);
    
	}else if(("Timestamp").equals(typeToGenerate)){
    isObject = true;
    
    stringBuffer.append(TEXT_13);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_18);
    
    }else if(("byte[]").equals(typeToGenerate)){
	isObject = true;
	
    stringBuffer.append(TEXT_19);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_23);
    
	}else if(("Long").equals(typeToGenerate)||("Byte").equals(typeToGenerate)||("Integer").equals(typeToGenerate)||("Short").equals(typeToGenerate)){
	isObject = true;
	
    stringBuffer.append(TEXT_24);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_28);
    
	}else if(("String").equals(typeToGenerate)){
	isObject = true;
	
    stringBuffer.append(TEXT_29);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_33);
    
	}else if(("Object").equals(typeToGenerate)){
	isObject = true;
	
    stringBuffer.append(TEXT_34);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_38);
    
	}else if(("Boolean").equals(typeToGenerate)){
	isObject = true;
	
    stringBuffer.append(TEXT_39);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_43);
    
	}else if(("Double").equals(typeToGenerate)){
	isObject = true;
	
    stringBuffer.append(TEXT_44);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_48);
    
	}else if(("Float").equals(typeToGenerate)){
	isObject = true;
	
    stringBuffer.append(TEXT_49);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_53);
    
	}
if(isObject){
	
    stringBuffer.append(TEXT_54);
    
}
	typeToGenerate = generateType(typeToGenerate);
	
	if(("Char").equals(typeToGenerate)||("Character").equals(typeToGenerate)){
	
    stringBuffer.append(TEXT_55);
    if(isObject){
    stringBuffer.append(TEXT_56);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_58);
    }else{
    stringBuffer.append(TEXT_59);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_61);
    }
    stringBuffer.append(TEXT_62);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_72);
    
	}else if(("Date").equals(typeToGenerate)){
	
    stringBuffer.append(TEXT_73);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_81);
    
	}else if(("Timestamp").equals(typeToGenerate)){
	
    stringBuffer.append(TEXT_82);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_88);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_90);
    
	}else{
	
    stringBuffer.append(TEXT_91);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_96);
    
	}
if(isObject){
	
    stringBuffer.append(TEXT_97);
    
}
	}
}


Operation operation = new Operation();

if(incomingConnName != null && columnList != null){
	if(("INSERT").equals(dataAction)){
		int counter = 1;
		
		for(Column column:colStruct){
			String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
			
			//typeToGenerate = operation.generateType(typeToGenerate);
			
			operation.generateSetStmt(typeToGenerate,column,counter,incomingConnName,cid,0);
			
        	counter++;
		}
	
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    
            if (("true").equals(dieOnError)) {
                
    stringBuffer.append(TEXT_100);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    }
    stringBuffer.append(TEXT_103);
    
            } else {
				if(isLog4jEnabled){
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    }
                if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                    for(IMetadataColumn column : columnList) {
                        
    stringBuffer.append(TEXT_106);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_108);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_110);
    
                    }
                    
    stringBuffer.append(TEXT_111);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_113);
    
                } else {
                    
    stringBuffer.append(TEXT_114);
    
                }
            } 
            
    stringBuffer.append(TEXT_115);
    
	}else if(("UPDATE").equals(dataAction)){
		int counterCol = 1;
		
		for(Column column:colStruct){
			String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
			
			//typeToGenerate = operation.generateType(typeToGenerate);
			
			if(!column.getColumn().isKey()){
				
				operation.generateSetStmt(typeToGenerate,column,counterCol,incomingConnName,cid,0);
				
        		counterCol++;
			}
		}

		for(Column column:colStruct){
			String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
			
			//typeToGenerate = operation.generateType(typeToGenerate);
			
			if(column.getColumn().isKey()){
			
				operation.generateSetStmt(typeToGenerate,column,counterCol,incomingConnName,cid,0);
				
        		counterCol++;
			}
		}

	
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    
            if (("true").equals(dieOnError)) {
                
    stringBuffer.append(TEXT_118);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    }
    stringBuffer.append(TEXT_121);
    
            } else {
				if(isLog4jEnabled){
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    }
                if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                    for(IMetadataColumn column : columnList) {
                        
    stringBuffer.append(TEXT_124);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_126);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_128);
    
                    }
                    
    stringBuffer.append(TEXT_129);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_131);
    
                } else {
                    
    stringBuffer.append(TEXT_132);
    
                }
            } 
            
    stringBuffer.append(TEXT_133);
    
	}else if (("INSERT_OR_UPDATE").equals(dataAction)){

    stringBuffer.append(TEXT_134);
    
		int columnIndex = 1;
		for(Column column:colStruct)
		{
			if(column.getColumn().isKey())
			{
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
				operation.generateSetStmt(typeToGenerate,column,columnIndex,incomingConnName,cid,0);
				columnIndex++;				
			}
		}

    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    
			int counterCol = 1;
			for(Column column:colStruct)
			{
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
				if(!column.getColumn().isKey())
				{
					operation.generateSetStmt(typeToGenerate,column,counterCol,incomingConnName,cid,2);
					counterCol++;
				}
			}
			for(Column column:colStruct)
			{
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
				if(column.getColumn().isKey())
				{
					operation.generateSetStmt(typeToGenerate,column,counterCol,incomingConnName,cid,2);					
	        		counterCol++;
				}
			}
			
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    
	            if (("true").equals(dieOnError)) {
	                
    stringBuffer.append(TEXT_145);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    }
    stringBuffer.append(TEXT_148);
    
	            } else {
					if(isLog4jEnabled){
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    }
	                if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
	                    for(IMetadataColumn column : columnList) {
	                        
    stringBuffer.append(TEXT_151);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_153);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_155);
    
	                    }
	                    
    stringBuffer.append(TEXT_156);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_158);
    
	                } else {
	                    
    stringBuffer.append(TEXT_159);
    
	                }
	            } 
	            
    stringBuffer.append(TEXT_160);
    
			int counterInsert = 1;
			for(Column columnInsert:colStruct)
			{
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(columnInsert.getColumn().getTalendType(), columnInsert.getColumn().isNullable());
				operation.generateSetStmt(typeToGenerate,columnInsert,counterInsert,incomingConnName,cid,1);
				counterInsert++;
			}
			
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    
	            if (("true").equals(dieOnError)) {
	                
    stringBuffer.append(TEXT_163);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    }
    stringBuffer.append(TEXT_166);
    
	            } else {
					if(isLog4jEnabled){
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    }
	                if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
	                    for(IMetadataColumn column : columnList) {
	                        
    stringBuffer.append(TEXT_169);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_171);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_173);
    
	                    }
	                    
    stringBuffer.append(TEXT_174);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_176);
    
	                } else {
	                    
    stringBuffer.append(TEXT_177);
    
	                }
	            } 
	            
    stringBuffer.append(TEXT_178);
    
	}else if (("UPDATE_OR_INSERT").equals(dataAction)){

    stringBuffer.append(TEXT_179);
    
		int counterColUpdate = 1;
		for(Column columnUpdate:colStruct){
			String typeToGenerate = JavaTypesManager.getTypeToGenerate(columnUpdate.getColumn().getTalendType(), columnUpdate.getColumn().isNullable());
			
			//typeToGenerate = operation.generateType(typeToGenerate);
			
			if(!columnUpdate.getColumn().isKey()){
			
				operation.generateSetStmt(typeToGenerate,columnUpdate,counterColUpdate,incomingConnName,cid,2);
				
        		counterColUpdate++;
			}
		}

		for(Column columnUpdate:colStruct){
			String typeToGenerate = JavaTypesManager.getTypeToGenerate(columnUpdate.getColumn().getTalendType(), columnUpdate.getColumn().isNullable());
			
			//typeToGenerate = operation.generateType(typeToGenerate);
			
			if(columnUpdate.getColumn().isKey()){
			
				operation.generateSetStmt(typeToGenerate,columnUpdate,counterColUpdate,incomingConnName,cid,2);
				
        		counterColUpdate++;
			}
		}
	
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    
        if (("true").equals(dieOnError)) {
            
    stringBuffer.append(TEXT_182);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    }
    stringBuffer.append(TEXT_185);
    
        } else {
			if(isLog4jEnabled){
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    }
            if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                for(IMetadataColumn column : columnList) {
                    
    stringBuffer.append(TEXT_188);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_190);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_192);
    
                }
                
    stringBuffer.append(TEXT_193);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_195);
    
            } else {
                
    stringBuffer.append(TEXT_196);
    
            }
        } 
        
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    
		int counter = 1;
		
		for(Column column:colStruct){
			String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
			
			//typeToGenerate = operation.generateType(typeToGenerate);
			
			operation.generateSetStmt(typeToGenerate,column,counter,incomingConnName,cid,1);
			
        	counter++;
		}
		
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    
            if (("true").equals(dieOnError)) {
                
    stringBuffer.append(TEXT_202);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    }
    stringBuffer.append(TEXT_205);
    
            } else {
				if(isLog4jEnabled){
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    }
                if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                    for(IMetadataColumn column : columnList) {
                        
    stringBuffer.append(TEXT_208);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_210);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_212);
    
                    }
                    
    stringBuffer.append(TEXT_213);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_215);
    
                } else {
                    
    stringBuffer.append(TEXT_216);
    
                }
            } 
            
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    
	
	}else if (("DELETE").equals(dataAction)){
		int keyCounter = 1;
		for(Column column:colStruct){
			String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
			
			//typeToGenerate = operation.generateType(typeToGenerate);
			
			if(column.getColumn().isKey()){
				
				operation.generateSetStmt(typeToGenerate,column,keyCounter,incomingConnName,cid,0);
				
        		keyCounter++;
			}
		}
	
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_220);
    
            if (("true").equals(dieOnError)) {
                
    stringBuffer.append(TEXT_221);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    }
    stringBuffer.append(TEXT_224);
    
            } else {
				if(isLog4jEnabled){
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    }
                if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                    for(IMetadataColumn column : columnList) {
                        
    stringBuffer.append(TEXT_227);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_229);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_231);
    
                    }
                    
    stringBuffer.append(TEXT_232);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_234);
    
                } else {
                    
    stringBuffer.append(TEXT_235);
    
                }
            } 
            
    stringBuffer.append(TEXT_236);
    
	}
	
	if(isLog4jEnabled){
			int count = 0;
			for(IMetadataColumn column : columnList) {
				count++;
		
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_240);
    if(count < columnList.size()){
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    }
            }
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    }
	if(outgoingConns != null && outgoingConns.size() > 0) {
	    for(IConnection outgoingConn : outgoingConns) {
	        if(!outgoingConn.getName().equals(rejectConnName) &&
	        	outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA) ) {
	            for(IMetadataColumn column : columnList) {
	                
    stringBuffer.append(TEXT_249);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_250);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_251);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_253);
    	                
	            }
	        }
	    }
	}

    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    
	////////////commit every////////////
	if(!("").equals(commitEvery) && !("0").equals(commitEvery)){
	
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    
	}
}

    stringBuffer.append(TEXT_262);
    return stringBuffer.toString();
  }
}
