package org.talend.designer.codegen.translators.databases.mysql;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;

public class TMysqlOutputBulkMainJava
{
  protected static String nl;
  public static synchronized TMysqlOutputBulkMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMysqlOutputBulkMainJava result = new TMysqlOutputBulkMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "  \t" + NL + "                    \tString[] row_";
  protected final String TEXT_2 = "=new String[]{";
  protected final String TEXT_3 = ", ";
  protected final String TEXT_4 = "\"\\\\N\"";
  protected final String TEXT_5 = "};\t\t//empty value must be NULL('\\N' in bulk file)" + NL + "                    \t";
  protected final String TEXT_6 = NL + "                \t\t\t\t\trow_";
  protected final String TEXT_7 = "[";
  protected final String TEXT_8 = "] = String.valueOf(" + NL + "                \t\t\t\t\t\t\ttrue == ";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = " ?\"1\":\"0\"" + NL + "                \t\t\t\t\t\t\t);" + NL + "                \t\t\t\t";
  protected final String TEXT_11 = NL + "                \t\t\t    \trow_";
  protected final String TEXT_12 = "[";
  protected final String TEXT_13 = "] = String.valueOf(";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = ");" + NL + "                \t\t\t    ";
  protected final String TEXT_16 = NL + "                \t\t\t    if(";
  protected final String TEXT_17 = ".";
  protected final String TEXT_18 = " != null){" + NL + "                \t\t\t        ";
  protected final String TEXT_19 = NL + "                \t\t\t            row_";
  protected final String TEXT_20 = "[";
  protected final String TEXT_21 = "] = ";
  protected final String TEXT_22 = ".";
  protected final String TEXT_23 = ";" + NL + "                \t\t\t            ";
  protected final String TEXT_24 = NL + "                \t\t\t            row_";
  protected final String TEXT_25 = "[";
  protected final String TEXT_26 = "] = FormatterUtils.format_Date(";
  protected final String TEXT_27 = ".";
  protected final String TEXT_28 = ", ";
  protected final String TEXT_29 = ");" + NL + "                \t\t\t            ";
  protected final String TEXT_30 = NL + "                \t\t\t            row_";
  protected final String TEXT_31 = "[";
  protected final String TEXT_32 = "] = java.nio.charset.Charset.forName(";
  protected final String TEXT_33 = ").decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_34 = ".";
  protected final String TEXT_35 = ")).toString();" + NL + "                \t\t\t            ";
  protected final String TEXT_36 = NL + "                \t\t\t\t\t\trow_";
  protected final String TEXT_37 = "[";
  protected final String TEXT_38 = "] = String.valueOf(" + NL + "                \t\t\t\t\t\t\ttrue == ";
  protected final String TEXT_39 = ".";
  protected final String TEXT_40 = " ?\"1\":\"0\"" + NL + "                \t\t\t\t\t\t\t);" + NL + "                \t\t\t\t\t";
  protected final String TEXT_41 = NL + "                \t\t\t            row_";
  protected final String TEXT_42 = "[";
  protected final String TEXT_43 = "] = String.valueOf(";
  protected final String TEXT_44 = ".";
  protected final String TEXT_45 = ");" + NL + "                \t\t\t            ";
  protected final String TEXT_46 = "                \t\t\t    " + NL + "                \t\t\t    }" + NL + "                \t\t ";
  protected final String TEXT_47 = NL + "\t            \t\t\t";
  protected final String TEXT_48 = NL + "\t            \t\t\t\tdiskSpace_";
  protected final String TEXT_49 = " = file_";
  protected final String TEXT_50 = ".getFreeSpace();" + NL + "\t            \t\t\t\tif(diskSpace_";
  protected final String TEXT_51 = " <= 0){" + NL + "\t\t\t\t\t\t\t\t\tthrow new java.io.IOException(\"The disk space is not enough,please check it!\");" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t            \t\t\t";
  protected final String TEXT_52 = NL + "\t\t\t\t\t\t\tfor (int i_";
  protected final String TEXT_53 = " = 0; i_";
  protected final String TEXT_54 = " < row_";
  protected final String TEXT_55 = ".length; i_";
  protected final String TEXT_56 = "++) {" + NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\tString temp_";
  protected final String TEXT_57 = " = row_";
  protected final String TEXT_58 = "[i_";
  protected final String TEXT_59 = "];" + NL + "\t\t\t\t\t\t\t\tif(!\"\\\\N\".equals(temp_";
  protected final String TEXT_60 = ")) {" + NL + "\t\t\t\t\t\t\t\t\tif (escape_mode_";
  protected final String TEXT_61 = " == 0 ) { // double quotes" + NL + "\t\t\t\t\t\t\t\t\t\ttemp_";
  protected final String TEXT_62 = " = temp_";
  protected final String TEXT_63 = ".replace(\"\" + textEnclosure_";
  protected final String TEXT_64 = ", \"\" + textEnclosure_";
  protected final String TEXT_65 = " + textEnclosure_";
  protected final String TEXT_66 = ");" + NL + "\t\t\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t\t\t\ttemp_";
  protected final String TEXT_67 = " = temp_";
  protected final String TEXT_68 = ".replace(\"\\\\\", \"\\\\\\\\\");" + NL + "\t\t\t\t\t\t\t\t\t\ttemp_";
  protected final String TEXT_69 = " = temp_";
  protected final String TEXT_70 = ".replace(\"\" + textEnclosure_";
  protected final String TEXT_71 = ", \"\\\\\" + textEnclosure_";
  protected final String TEXT_72 = ");" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\tif(i_";
  protected final String TEXT_73 = " != 0) {" + NL + "\t\t\t\t\t\t\t\t\tcsvWriter_";
  protected final String TEXT_74 = ".write(fieldSeparator_";
  protected final String TEXT_75 = ");" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\tcsvWriter_";
  protected final String TEXT_76 = ".append(textEnclosure_";
  protected final String TEXT_77 = ");" + NL + "\t\t\t\t\t\t\t\tcsvWriter_";
  protected final String TEXT_78 = ".write(temp_";
  protected final String TEXT_79 = ");" + NL + "\t\t\t\t\t\t\t\tcsvWriter_";
  protected final String TEXT_80 = ".append(textEnclosure_";
  protected final String TEXT_81 = ");" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tcsvWriter_";
  protected final String TEXT_82 = ".write(rowSeparator_";
  protected final String TEXT_83 = ");" + NL + "\t            \t\t\t";
  protected final String TEXT_84 = NL + "        \t\t\t    \t\tcsvWriter_";
  protected final String TEXT_85 = ".flush();" + NL + "\t            \t\t\t";
  protected final String TEXT_86 = NL + "            \t\t\t    ";
  protected final String TEXT_87 = NL + "        \t\t                if(nb_line_";
  protected final String TEXT_88 = "%";
  protected final String TEXT_89 = " == 0) {            \t\t\t    " + NL + "            \t\t\t    \t\tcsvWriter_";
  protected final String TEXT_90 = ".flush();" + NL + "            \t\t\t    \t}\t " + NL + "            \t\t\t    ";
  protected final String TEXT_91 = NL + "            \t\t\t\tnb_line_";
  protected final String TEXT_92 = "++;" + NL + "            \t\t\t";
  protected final String TEXT_93 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    
        boolean checkDiskSpace = ("true").equals(ElementParameterParser.getValue(node,"__CHECK_DISK_SPACE__"));
    	boolean flushOnRow = ("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__"));
    	String flushMod = ElementParameterParser.getValue(node, "__FLUSHONROW_NUM__");
    	
        String encoding = ElementParameterParser.getValue(node,"__ENCODING__");    	
    	
    	List< ? extends IConnection> conns = node.getIncomingConnections();
        	if(conns!=null){
        		if (conns.size()>0){
        		    IConnection conn =conns.get(0);
            		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
            			List<IMetadataColumn> columns = metadata.getListColumns();
                		int sizeColumns = columns.size();
            			
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    for(int j=0;j<sizeColumns;j++){if(j != 0) {
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    }
    stringBuffer.append(TEXT_5);
    
            			for (int i = 0; i < sizeColumns; i++) {
                			IMetadataColumn column = columns.get(i);
                			JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                			String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                			if(JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable())){
                			
                				if(javaType == JavaTypesManager.BOOLEAN ){
                				
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_10);
    
                				} else {
                			    
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_15);
    
                			    }
                			}else {
                			    
    stringBuffer.append(TEXT_16);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_18);
    					
                			        if(javaType == JavaTypesManager.STRING ){
                			            
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_23);
    
                			        }else if(javaType == JavaTypesManager.DATE && pattern != null){
                			            
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_28);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_29);
    
                			        }else if(javaType == JavaTypesManager.BYTE_ARRAY){
                			            
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_35);
    
                			        }else if(javaType == JavaTypesManager.BOOLEAN ){
                					
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_40);
    
                					}	             			        
                			        else{
                			            
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_45);
    
                			        }
                			        
    stringBuffer.append(TEXT_46);
     
                			}
            			} 

            			
    stringBuffer.append(TEXT_47);
    if(checkDiskSpace){
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    }
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
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
    if(checkDiskSpace){
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    }
    stringBuffer.append(TEXT_86);
     if(flushOnRow) { 
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    }
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
       		
            		}
        		
        		}
        	}
    }
}

    stringBuffer.append(TEXT_93);
    return stringBuffer.toString();
  }
}
