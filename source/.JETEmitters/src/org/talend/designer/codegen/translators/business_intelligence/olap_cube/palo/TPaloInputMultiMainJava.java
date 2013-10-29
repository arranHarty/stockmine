package org.talend.designer.codegen.translators.business_intelligence.olap_cube.palo;

import java.util.List;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;

public class TPaloInputMultiMainJava
{
  protected static String nl;
  public static synchronized TPaloInputMultiMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPaloInputMultiMainJava result = new TPaloInputMultiMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + NL + "\tjava.util.Hashtable <String[], org.talend.jpalo.palodatavalue> htPLD_";
  protected final String TEXT_4 = " = pDT_";
  protected final String TEXT_5 = ".getResultHashTable();" + NL + "\tjava.util.Enumeration enPLD_";
  protected final String TEXT_6 = " = htPLD_";
  protected final String TEXT_7 = ".keys();" + NL + "\twhile (enPLD_";
  protected final String TEXT_8 = ".hasMoreElements()) {" + NL + "\t\tString[] strKey =(String[])enPLD_";
  protected final String TEXT_9 = ".nextElement();" + NL + "\t\t// System.out.println(org.talend.jpalo.palohelpers.makeStrinOfArray(strKey)+ \",\" + htPLD_";
  protected final String TEXT_10 = ".get(strKey).getDoubleValue());";
  protected final String TEXT_11 = NL + "\t\t\t\t";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = " = strKey[";
  protected final String TEXT_14 = "];";
  protected final String TEXT_15 = NL + "\t\t";
  protected final String TEXT_16 = ".MEASURE =  htPLD_";
  protected final String TEXT_17 = ".get(strKey).getDoubleValue();" + NL + "\t\t";
  protected final String TEXT_18 = ".TEXT =  htPLD_";
  protected final String TEXT_19 = ".get(strKey).getStringValue();";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

    stringBuffer.append(TEXT_2);
    
	String strOutputConnectionName="";
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
 	if(conns!=null){
		if (conns.size()>0){
            IConnection conn =conns.get(0);
            if(conn!=null && conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
		    	strOutputConnectionName=conn.getName();
		    }
		}
	}

if(null!=strOutputConnectionName && strOutputConnectionName.length()>0){

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    
		List<IMetadataTable> metadatas = node.getMetadataList();
		if ((metadatas!=null)&&(metadatas.size()>0)) {
			IMetadataTable metadata = metadatas.get(0);
			List<IMetadataColumn> columns = metadata.getListColumns();
			for (int i = 0; i < columns.size()-2; i++) {
				IMetadataColumn column = columns.get(i);

    stringBuffer.append(TEXT_11);
    stringBuffer.append(strOutputConnectionName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_14);
    
			}
		}

    stringBuffer.append(TEXT_15);
    stringBuffer.append(strOutputConnectionName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(strOutputConnectionName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    
}

    return stringBuffer.toString();
  }
}
