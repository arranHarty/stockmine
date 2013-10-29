package org.talend.designer.codegen.translators.business.salesforce;

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

public class TSalesforceOutputBulkMainJava
{
  protected static String nl;
  public static synchronized TSalesforceOutputBulkMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSalesforceOutputBulkMainJava result = new TSalesforceOutputBulkMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "  \t" + NL + "                    \tString[] row_";
  protected final String TEXT_2 = "=new String[]{";
  protected final String TEXT_3 = " \"\",";
  protected final String TEXT_4 = "\"#N/A\",";
  protected final String TEXT_5 = "};\t\t//empty value must be NULL('#N/A' in bulk file)" + NL + "                    \t";
  protected final String TEXT_6 = NL + "                \t\t\t    \trow_";
  protected final String TEXT_7 = "[";
  protected final String TEXT_8 = "] = String.valueOf(";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = ");" + NL + "                \t\t\t    ";
  protected final String TEXT_11 = NL + "                \t\t\t    if(";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = " != null){" + NL + "                \t\t\t        ";
  protected final String TEXT_14 = NL + "                \t\t\t            row_";
  protected final String TEXT_15 = "[";
  protected final String TEXT_16 = "] = FormatterUtils.format_Date(";
  protected final String TEXT_17 = ".";
  protected final String TEXT_18 = ", ";
  protected final String TEXT_19 = ");" + NL + "                \t\t\t            ";
  protected final String TEXT_20 = NL + "                \t\t\t            row_";
  protected final String TEXT_21 = "[";
  protected final String TEXT_22 = "] = String.valueOf(";
  protected final String TEXT_23 = ".";
  protected final String TEXT_24 = ");" + NL + "                \t\t\t            ";
  protected final String TEXT_25 = "                \t\t\t    " + NL + "                \t\t\t    }" + NL + "                \t\t ";
  protected final String TEXT_26 = NL + "            \t\t\t    csvWriter_";
  protected final String TEXT_27 = ".writeNext(row_";
  protected final String TEXT_28 = ");\t" + NL + "            \t\t\t    " + NL + "            \t\t\t\tnb_line_";
  protected final String TEXT_29 = "++;" + NL + "            \t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

List<IMetadataTable> metadatas = node.getMetadataList();

boolean ignoreNullValue = ("true").equals(ElementParameterParser.getValue(node, "__IGNORE_NULL__"));

if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
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
    for(int j=0;j<sizeColumns;j++){ if(ignoreNullValue){
    stringBuffer.append(TEXT_3);
    }else{
    stringBuffer.append(TEXT_4);
    }}
    stringBuffer.append(TEXT_5);
    
                    
            			for (int i = 0; i < sizeColumns; i++) {
                			IMetadataColumn column = columns.get(i);
                			JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                			String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                			if(JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable())){
                			    
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_10);
    
                			}else {
                			    
    stringBuffer.append(TEXT_11);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_13);
    					
                			        if(javaType == JavaTypesManager.DATE && pattern != null){
                			            
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_19);
    
                			        }else{
                			            
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_24);
    
                			        }
                			        
    stringBuffer.append(TEXT_25);
     
                			}
            			} 

            			
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
       		
            		}
        		
        		}
        	}
    }
}

    return stringBuffer.toString();
  }
}
