package org.talend.designer.codegen.translators.business.salesforce;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;

public class TSalesforceInputEndJava
{
  protected static String nl;
  public static synchronized TSalesforceInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSalesforceInputEndJava result = new TSalesforceInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t                // (for salesforce wizard preview)" + NL + "\t\t\t                if(limit_";
  protected final String TEXT_2 = " > 0 && nb_line_";
  protected final String TEXT_3 = " >= limit_";
  protected final String TEXT_4 = "){ " + NL + "\t\t\t                \tbContinue_";
  protected final String TEXT_5 = " = false;" + NL + "\t\t\t                \tbreak;" + NL + "\t\t\t                }" + NL + "\t\t\t            " + NL + "\t\t\t            }" + NL + "\t\t\t            // handle the loop + 1 problem by checking the most recent queryResult" + NL + "\t\t\t            if (qr_";
  protected final String TEXT_6 = ".getDone()) {" + NL + "\t\t\t                bContinue_";
  protected final String TEXT_7 = " = false;" + NL + "\t\t\t            } else {" + NL + "\t\t\t                qr_";
  protected final String TEXT_8 = " = sfMgr_";
  protected final String TEXT_9 = ".queryMore(qr_";
  protected final String TEXT_10 = ".getQueryLocator(),new Integer(";
  protected final String TEXT_11 = "));" + NL + "\t\t\t            \ttopqr_";
  protected final String TEXT_12 = " = new org.talend.salesforce.TopQueryResult();" + NL + "\t\t\t\t\t\t\ttopqr_";
  protected final String TEXT_13 = ".processTopQueryResult(qr_";
  protected final String TEXT_14 = ");" + NL + "\t\t\t            }" + NL + "\t\t\t        }" + NL + "\t\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\tsfMgr_";
  protected final String TEXT_17 = ".logout();" + NL + "\t\t";
  protected final String TEXT_18 = NL + "globalMap.put(\"";
  protected final String TEXT_19 = "_NB_LINE\", nb_line_";
  protected final String TEXT_20 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;

INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();
String api = ElementParameterParser.getValue(node,"__API__");
String batchSize = ElementParameterParser.getValue(node,"__BATCH_SIZE__");
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas != null) && (metadatas.size() > 0)) {
	IMetadataTable metadata = metadatas.get(0);
	
	if (metadata != null) {
		List<IMetadataColumn> columnList = metadata.getListColumns();
		int nbSchemaColumns = columnList.size();
			
		List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();

		// if output columns are defined
		if (nbSchemaColumns > 0 && outgoingConns != null && outgoingConns.size() > 0){

			IConnection outgoingConn = outgoingConns.get(0);

			if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				if("soap".equals(api)){		
				
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
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
    stringBuffer.append(batchSize);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
				}else{
				
    stringBuffer.append(TEXT_15);
    
				}
			}
		}
		if("soap".equals(api)){	
		
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
		}
	}
}

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    return stringBuffer.toString();
  }
}
