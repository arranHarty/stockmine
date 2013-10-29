package org.talend.designer.codegen.translators.databases.postgresql;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import org.talend.core.model.process.ElementParameterParser;

public class TPostgresqlOutputBulkMainJava
{
  protected static String nl;
  public static synchronized TPostgresqlOutputBulkMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPostgresqlOutputBulkMainJava result = new TPostgresqlOutputBulkMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "               \tString[] row_";
  protected final String TEXT_2 = "=new String[]{";
  protected final String TEXT_3 = ", ";
  protected final String TEXT_4 = "};";
  protected final String TEXT_5 = NL + "                        \trow_";
  protected final String TEXT_6 = "[";
  protected final String TEXT_7 = "] = String.valueOf(";
  protected final String TEXT_8 = ".";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = "   \t\t\t\t" + NL + "\t\t\t\t       \tif(";
  protected final String TEXT_11 = ".";
  protected final String TEXT_12 = " != null){";
  protected final String TEXT_13 = NL + "                            \trow_";
  protected final String TEXT_14 = "[";
  protected final String TEXT_15 = "] = ";
  protected final String TEXT_16 = ".";
  protected final String TEXT_17 = ";";
  protected final String TEXT_18 = NL + "    \t                    \trow_";
  protected final String TEXT_19 = "[";
  protected final String TEXT_20 = "] = FormatterUtils.format_Date(";
  protected final String TEXT_21 = ".";
  protected final String TEXT_22 = ", ";
  protected final String TEXT_23 = ");";
  protected final String TEXT_24 = NL + "            \t            \trow_";
  protected final String TEXT_25 = "[";
  protected final String TEXT_26 = "] = java.nio.charset.Charset.forName(";
  protected final String TEXT_27 = ").decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = ")).toString();";
  protected final String TEXT_30 = NL + "    \t                    \trow_";
  protected final String TEXT_31 = "[";
  protected final String TEXT_32 = "] = String.valueOf(";
  protected final String TEXT_33 = ".";
  protected final String TEXT_34 = ");";
  protected final String TEXT_35 = NL + "  \t\t\t\t\t\t}";
  protected final String TEXT_36 = NL + "\t\t\t\t\tfor (int i_";
  protected final String TEXT_37 = " = 0; i_";
  protected final String TEXT_38 = " < row_";
  protected final String TEXT_39 = ".length; i_";
  protected final String TEXT_40 = "++) {" + NL + "\t               \t\tString temp_";
  protected final String TEXT_41 = " = row_";
  protected final String TEXT_42 = "[i_";
  protected final String TEXT_43 = "];" + NL + "\t               \t\t" + NL + "\t    \t\t        if(i_";
  protected final String TEXT_44 = " != 0) {" + NL + "    \t    \t       \t\tout";
  protected final String TEXT_45 = ".write(OUT_DELIM_";
  protected final String TEXT_46 = ");" + NL + "        \t        \t}" + NL + "        \t        \tif(!";
  protected final String TEXT_47 = ".equals(temp_";
  protected final String TEXT_48 = ")){" + NL + "        \t        \t  temp_";
  protected final String TEXT_49 = " = temp_";
  protected final String TEXT_50 = ".replaceAll(\"\\\\\\\\\",\"\\\\\\\\\\\\\\\\\");" + NL + "        \t        \t}" + NL + "\t\t           \t\tout";
  protected final String TEXT_51 = ".write(temp_";
  protected final String TEXT_52 = ");" + NL + "    \t\t        }";
  protected final String TEXT_53 = NL + "\t\t\t\t\tfor (int i_";
  protected final String TEXT_54 = " = 0; i_";
  protected final String TEXT_55 = " < row_";
  protected final String TEXT_56 = ".length; i_";
  protected final String TEXT_57 = "++) {" + NL + "\t\t\t\t\t\tif(i_";
  protected final String TEXT_58 = " != 0) {" + NL + "                        \tout";
  protected final String TEXT_59 = ".write(OUT_DELIM_";
  protected final String TEXT_60 = ");" + NL + "                        }" + NL + "                \t\tString temp_";
  protected final String TEXT_61 = " = row_";
  protected final String TEXT_62 = "[i_";
  protected final String TEXT_63 = "];" + NL + "                        if(!";
  protected final String TEXT_64 = ".equals(temp_";
  protected final String TEXT_65 = ")) {" + NL + "                            if (escape_mode_";
  protected final String TEXT_66 = " == 0 ) { // double quotes" + NL + "                                temp_";
  protected final String TEXT_67 = " = temp_";
  protected final String TEXT_68 = ".replace(\"\" + textEnclosure_";
  protected final String TEXT_69 = ", \"\" + textEnclosure_";
  protected final String TEXT_70 = " + textEnclosure_";
  protected final String TEXT_71 = ");" + NL + "                            }else{" + NL + "                                temp_";
  protected final String TEXT_72 = " = temp_";
  protected final String TEXT_73 = ".replace(\"\\\\\", \"\\\\\\\\\");" + NL + "                                temp_";
  protected final String TEXT_74 = " = temp_";
  protected final String TEXT_75 = ".replace(\"\" + textEnclosure_";
  protected final String TEXT_76 = ", \"\\\\\" + textEnclosure_";
  protected final String TEXT_77 = ");" + NL + "                            }" + NL + "                            out";
  protected final String TEXT_78 = ".append(textEnclosure_";
  protected final String TEXT_79 = ");" + NL + "                        \tout";
  protected final String TEXT_80 = ".write(temp_";
  protected final String TEXT_81 = ");" + NL + "                        \tout";
  protected final String TEXT_82 = ".append(textEnclosure_";
  protected final String TEXT_83 = ");" + NL + "                        }else{" + NL + "                            out";
  protected final String TEXT_84 = ".write(temp_";
  protected final String TEXT_85 = ");" + NL + "                        }" + NL + "                \t}";
  protected final String TEXT_86 = NL + "    \t\t\tout";
  protected final String TEXT_87 = ".write(OUT_DELIM_ROWSEP_";
  protected final String TEXT_88 = ");" + NL + "    \t\t\tnb_line_";
  protected final String TEXT_89 = "++;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();
    
    String fileType = ElementParameterParser.getValue(node, "__FILETYPE__");
    
    String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
    
    String nullString = ElementParameterParser.getValue(node,"__NULLSTRING__");   
    
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	for (IConnection conn : conns) {
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    			List<IMetadataColumn> columns = metadata.getListColumns();
    			int sizeColumns = columns.size();
    			//for bug TDI-22555

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    for(int j=0;j<sizeColumns;j++){if(j != 0) {
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(nullString);
    }
    stringBuffer.append(TEXT_4);
    
    			for (int i = 0; i < sizeColumns; i++) {
    				IMetadataColumn column = columns.get(i);
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
					if(JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable())){

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_9);
    
					}else {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_12);
                      
                    		if(javaType == JavaTypesManager.STRING ){

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_17);
    
							}else if(javaType == JavaTypesManager.DATE && pattern != null){

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_22);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_23);
    
        					}else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_29);
    
							}else{

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_34);
    
        					}

    stringBuffer.append(TEXT_35);
    
					}
				}
    			if("TXTFILE".equals(fileType)){

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(nullString );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    
    			}else if("CSVFILE".equals(fileType)){

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(nullString);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    
				}

    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    
    		}
    	}
    }
}

    return stringBuffer.toString();
  }
}
