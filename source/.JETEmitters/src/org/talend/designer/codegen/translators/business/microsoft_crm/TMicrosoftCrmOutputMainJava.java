package org.talend.designer.codegen.translators.business.microsoft_crm;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMicrosoftCrmOutputMainJava
{
  protected static String nl;
  public static synchronized TMicrosoftCrmOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMicrosoftCrmOutputMainJava result = new TMicrosoftCrmOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t\t\t\t\tStringBuffer OperXml_";
  protected final String TEXT_3 = " = new StringBuffer();" + NL + "\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_4 = NL + "\t\t    \t\t\t\t\tOperXml_";
  protected final String TEXT_5 = ".append(\"<Create xmlns=\\\"http://schemas.microsoft.com/crm/2007/WebServices\\\" xmlns:xsi=\\\"http://www.w3.org/2001/XMLSchema-instance\\\">\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_6 = NL + "\t\t    \t\t\t\t\tOperXml_";
  protected final String TEXT_7 = ".append(\"<Update xmlns=\\\"http://schemas.microsoft.com/crm/2007/WebServices\\\" xmlns:xsi=\\\"http://www.w3.org/2001/XMLSchema-instance\\\">\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t\t\t        OperXml_";
  protected final String TEXT_9 = ".append(\"\\n\");" + NL + "\t\t\t\t\t    \tOperXml_";
  protected final String TEXT_10 = ".append(\"<entity xsi:type=\\\"web:\");" + NL + "\t\t\t\t\t    \tOperXml_";
  protected final String TEXT_11 = ".append(\"";
  protected final String TEXT_12 = "\");" + NL + "\t\t\t\t\t    \tOperXml_";
  protected final String TEXT_13 = ".append(\"\\\" xmlns:web=\\\"http://schemas.microsoft.com/crm/2007/WebServices\\\">\");" + NL + "\t\t\t\t\t    \tOperXml_";
  protected final String TEXT_14 = ".append(\"\\n\");" + NL + "\t\t    \t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_15 = "   \t\t\t\t" + NL + "\t\t\t    \t\t\t\t\tif(";
  protected final String TEXT_16 = ".";
  protected final String TEXT_17 = " != null ) { //" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_18 = "   " + NL + "\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_19 = ".append(\"<\");" + NL + "\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_20 = ".append(\"";
  protected final String TEXT_21 = "\");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_22 = NL + "\t\t\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_23 = ".append(\" type=\\\"\");\t" + NL + "\t\t\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_24 = ".append(";
  protected final String TEXT_25 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_26 = ".append(\"\\\"\");\t" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_28 = ".append(\">\");" + NL + "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_29 = ".append(\"<![CDATA[\");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_30 = NL + "\t\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_31 = ".append(FormatterUtils.format_Date(";
  protected final String TEXT_32 = ".";
  protected final String TEXT_33 = ", ";
  protected final String TEXT_34 = "));" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_36 = ".append(String.valueOf(";
  protected final String TEXT_37 = ".";
  protected final String TEXT_38 = "));" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_40 = ".append(\"]]>\");" + NL + "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_41 = ".append(\"</\");" + NL + "\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_42 = ".append(\"";
  protected final String TEXT_43 = "\");" + NL + "\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_44 = ".append(\">\");" + NL + "\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_45 = ".append(\"\\n\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_46 = NL + "\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_47 = ".append(\"<\");" + NL + "\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_48 = ".append(\"";
  protected final String TEXT_49 = "\");" + NL + "\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_50 = ".append(\"id>\");" + NL + "\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_51 = ".append(";
  protected final String TEXT_52 = ".Id);" + NL + "\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_53 = ".append(\"</\");" + NL + "\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_54 = ".append(\"";
  protected final String TEXT_55 = "\");" + NL + "\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_56 = ".append(\"id>\");" + NL + "\t\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_57 = ".append(\"\\n\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_58 = NL + "\t\t\t    \t\t\t\t\t} //" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_59 = NL + "\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_60 = ".append(\"</entity>\");" + NL + "\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_61 = ".append(\"\\n\");" + NL + "\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_62 = ".append(\"</Create>\");" + NL + "\t\t\t\t\t\t\t\tcom.microsoft.schemas.crm._2007.webservices.CreateDocument createDoc_";
  protected final String TEXT_63 = " =  com.microsoft.schemas.crm._2007.webservices.CreateDocument.Factory.parse(OperXml_";
  protected final String TEXT_64 = ".toString());" + NL + "\t\t\t\t\t\t\t\tservice_";
  protected final String TEXT_65 = ".create(createDoc_";
  protected final String TEXT_66 = ", catd_";
  protected final String TEXT_67 = ", null, null);" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_68 = NL + "\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_69 = ".append(\"</entity>\");" + NL + "\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_70 = ".append(\"\\n\");" + NL + "\t\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_71 = ".append(\"</Update>\");" + NL + "\t\t\t\t\t\t\t\tcom.microsoft.schemas.crm._2007.webservices.UpdateDocument updateDoc_";
  protected final String TEXT_72 = " = com.microsoft.schemas.crm._2007.webservices.UpdateDocument.Factory.parse(OperXml_";
  protected final String TEXT_73 = ".toString());" + NL + "\t\t\t\t\t\t\t\tservice_";
  protected final String TEXT_74 = ".update(updateDoc_";
  protected final String TEXT_75 = ",catd_";
  protected final String TEXT_76 = ",null,null);\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_77 = NL + "\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_78 = ".append(\"<Delete xmlns=\\\"http://schemas.microsoft.com/crm/2007/WebServices\\\">\");" + NL + "\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_79 = ".append(\"\\n\");" + NL + "\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_80 = ".append(\"<entityName>\");" + NL + "\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_81 = ".append(\"";
  protected final String TEXT_82 = "\");" + NL + "\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_83 = ".append(\"</entityName>\");" + NL + "\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_84 = ".append(\"\\n\");" + NL + "\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_85 = ".append(\"<id>\");" + NL + "\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_86 = ".append(";
  protected final String TEXT_87 = ".Id);" + NL + "\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_88 = ".append(\"</id>\\n\");" + NL + "\t\t\t\t\t\t\tOperXml_";
  protected final String TEXT_89 = ".append(\"</Delete>\");" + NL + "\t\t\t\t\t\t\tcom.microsoft.schemas.crm._2007.webservices.DeleteDocument deleteDoc_";
  protected final String TEXT_90 = " = com.microsoft.schemas.crm._2007.webservices.DeleteDocument.Factory.parse(OperXml_";
  protected final String TEXT_91 = ".toString());" + NL + "\t\t\t\t\t\t\tservice_";
  protected final String TEXT_92 = ".delete(deleteDoc_";
  protected final String TEXT_93 = ",catd_";
  protected final String TEXT_94 = ",null,null);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_95 = NL + "\t\t\t\t\t\t\tcom.microsoft.schemas.crm._2007.webservices.ExecuteDocument.Execute execute_";
  protected final String TEXT_96 = " = com.microsoft.schemas.crm._2007.webservices.ExecuteDocument.Execute.Factory" + NL + "\t\t\t\t\t\t            .newInstance();" + NL + "\t\t\t\t\t\t    com.microsoft.schemas.crm._2007.webservices.ExecuteDocument executeDoc_";
  protected final String TEXT_97 = " = com.microsoft.schemas.crm._2007.webservices.ExecuteDocument.Factory" + NL + "\t\t\t\t\t\t            .newInstance();" + NL + "\t\t\t\t\t\t    com.microsoft.schemas.crm._2007.webservices.AssignRequest assignRequest_";
  protected final String TEXT_98 = " = com.microsoft.schemas.crm._2007.webservices.AssignRequest.Factory" + NL + "\t\t\t\t\t\t            .newInstance();" + NL + "\t\t\t\t\t\t    com.microsoft.schemas.crm._2006.coretypes.SecurityPrincipal assignee_";
  protected final String TEXT_99 = " = com.microsoft.schemas.crm._2006.coretypes.SecurityPrincipal.Factory.newInstance();" + NL + "\t\t\t\t\t\t    assignee_";
  protected final String TEXT_100 = ".setPrincipalId(String.valueOf(";
  protected final String TEXT_101 = ".ownerid));" + NL + "\t\t\t\t\t\t    assignee_";
  protected final String TEXT_102 = ".setType(com.microsoft.schemas.crm._2006.coretypes.SecurityPrincipalType.Enum.forString(\"User\"));" + NL + "\t\t\t\t\t\t    assignRequest_";
  protected final String TEXT_103 = ".setAssignee(assignee_";
  protected final String TEXT_104 = ");" + NL + "\t\t\t\t\t\t    " + NL + "\t\t\t\t\t\t    com.microsoft.schemas.crm._2007.webservices.TargetOwnedDynamic dynamicTarget_";
  protected final String TEXT_105 = " = com.microsoft.schemas.crm._2007.webservices.TargetOwnedDynamic.Factory" + NL + "\t\t\t\t\t\t            .newInstance();" + NL + "\t\t\t\t\t\t    dynamicTarget_";
  protected final String TEXT_106 = ".setEntityName(\"";
  protected final String TEXT_107 = "\");" + NL + "\t\t\t\t\t\t    dynamicTarget_";
  protected final String TEXT_108 = ".setEntityId(String.valueOf(";
  protected final String TEXT_109 = ".Id));" + NL + "\t\t\t\t\t\t    " + NL + "\t\t\t\t\t\t    assignRequest_";
  protected final String TEXT_110 = ".setTarget(dynamicTarget_";
  protected final String TEXT_111 = ");" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t    execute_";
  protected final String TEXT_112 = ".setRequest(assignRequest_";
  protected final String TEXT_113 = ");" + NL + "\t\t\t\t\t\t    executeDoc_";
  protected final String TEXT_114 = ".setExecute(execute_";
  protected final String TEXT_115 = ");" + NL + "\t\t\t\t\t\t    " + NL + "\t\t\t\t\t\t    executeDoc_";
  protected final String TEXT_116 = " = com.microsoft.schemas.crm._2007.webservices.ExecuteDocument.Factory.parse(executeDoc_";
  protected final String TEXT_117 = ".toString());" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t    service_";
  protected final String TEXT_118 = ".execute(executeDoc_";
  protected final String TEXT_119 = ", catd_";
  protected final String TEXT_120 = ", null,null);" + NL + "\t\t            " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_121 = " \t " + NL + "\t\t\t\t\t";
  protected final String TEXT_122 = NL + "\t\t\t\t\t\t\tcom.microsoft.schemas.xrm._2011.contracts.Entity entity_";
  protected final String TEXT_123 = " = com.microsoft.schemas.xrm._2011.contracts.Entity.Factory.newInstance();" + NL + "\t\t\t\t\t\t\tentity_";
  protected final String TEXT_124 = ".setLogicalName(\"";
  protected final String TEXT_125 = "\");" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\tcom.microsoft.schemas.xrm._2011.contracts.AttributeCollection attributes_";
  protected final String TEXT_126 = " = com.microsoft.schemas.xrm._2011.contracts.AttributeCollection.Factory.newInstance();" + NL + "\t\t\t\t\t\t\torg.datacontract.schemas._2004._07.system_collections_generic.KeyValuePairOfstringanyType attribute_";
  protected final String TEXT_127 = " = null;" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\torg.apache.xmlbeans.XmlObject xmlObject_";
  protected final String TEXT_128 = " = null;" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_129 = "   \t\t\t\t" + NL + "\t\t\t    \t\t\t\t\tif(";
  protected final String TEXT_130 = ".";
  protected final String TEXT_131 = " != null){" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_132 = NL + "\t    \t\t\t\t\t\tattribute_";
  protected final String TEXT_133 = " = attributes_";
  protected final String TEXT_134 = ".addNewKeyValuePairOfstringanyType();" + NL + "\t    \t\t\t\t\t\tattribute_";
  protected final String TEXT_135 = ".setKey(\"";
  protected final String TEXT_136 = "\");" + NL + "\t\t    \t\t\t\t\t";
  protected final String TEXT_137 = NL + "\t\t\t\t\t\t\t\t\t\t\t\txmlObject_";
  protected final String TEXT_138 = " = com.microsoft.schemas.xrm._2011.contracts.EntityReference.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t((com.microsoft.schemas.xrm._2011.contracts.EntityReference)xmlObject_";
  protected final String TEXT_139 = ").setId(";
  protected final String TEXT_140 = ".";
  protected final String TEXT_141 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t((com.microsoft.schemas.xrm._2011.contracts.EntityReference)xmlObject_";
  protected final String TEXT_142 = ").setLogicalName(";
  protected final String TEXT_143 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_144 = NL + "\t\t\t\t\t\t\t\t\t\"The type of column \"";
  protected final String TEXT_145 = "\" is EntityReference, need to specify the reference entity logical name in EntityReference Type Mapping table.\"" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_146 = NL + "\t\t\t\t\t\t\t\t\txmlObject_";
  protected final String TEXT_147 = " = com.microsoft.schemas.xrm._2011.contracts.OptionSetValue.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\t((com.microsoft.schemas.xrm._2011.contracts.OptionSetValue)xmlObject_";
  protected final String TEXT_148 = ").setValue(";
  protected final String TEXT_149 = ".";
  protected final String TEXT_150 = "); " + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_151 = NL + "\t\t\t\t\t\t\t\t\txmlObject_";
  protected final String TEXT_152 = " = com.microsoft.schemas.xrm._2011.contracts.Money.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\t((com.microsoft.schemas.xrm._2011.contracts.Money)xmlObject_";
  protected final String TEXT_153 = ").setValue(";
  protected final String TEXT_154 = ".";
  protected final String TEXT_155 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_156 = NL + "\t\t\t\t\t\t\t\t\txmlObject_";
  protected final String TEXT_157 = " = com.microsoft.schemas._2003._10.serialization.Guid.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\t((com.microsoft.schemas._2003._10.serialization.Guid)xmlObject_";
  protected final String TEXT_158 = ").setStringValue(";
  protected final String TEXT_159 = ".";
  protected final String TEXT_160 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_161 = NL + "\t\t\t\t\t\t\t\t\txmlObject_";
  protected final String TEXT_162 = " = org.apache.xmlbeans.XmlString.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\t((org.apache.xmlbeans.XmlString)xmlObject_";
  protected final String TEXT_163 = ").setStringValue(";
  protected final String TEXT_164 = ".";
  protected final String TEXT_165 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_166 = NL + "\t\t\t\t\t\t\t\t\txmlObject_";
  protected final String TEXT_167 = " = org.apache.xmlbeans.XmlDateTime.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\t((org.apache.xmlbeans.XmlDateTime)xmlObject_";
  protected final String TEXT_168 = ").setDateValue(";
  protected final String TEXT_169 = ".";
  protected final String TEXT_170 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_171 = NL + "\t\t\t\t\t\t\t\t\txmlObject_";
  protected final String TEXT_172 = " = org.apache.xmlbeans.XmlBoolean.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\t((org.apache.xmlbeans.XmlBoolean)xmlObject_";
  protected final String TEXT_173 = ").setBooleanValue(";
  protected final String TEXT_174 = ".";
  protected final String TEXT_175 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_176 = NL + "\t\t\t\t\t\t\t\t\txmlObject_";
  protected final String TEXT_177 = " = org.apache.xmlbeans.XmlDecimal.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\t((org.apache.xmlbeans.XmlDecimal)xmlObject_";
  protected final String TEXT_178 = ").setBigDecimalValue(";
  protected final String TEXT_179 = ".";
  protected final String TEXT_180 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_181 = NL + "\t\t\t\t\t\t\t\t\txmlObject_";
  protected final String TEXT_182 = " = org.apache.xmlbeans.XmlInt.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\t((org.apache.xmlbeans.XmlInt)xmlObject_";
  protected final String TEXT_183 = ").setIntValue(";
  protected final String TEXT_184 = ".";
  protected final String TEXT_185 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_186 = NL + "\t\t\t\t\t\t\t\t\txmlObject_";
  protected final String TEXT_187 = " = org.apache.xmlbeans.XmlLong.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\t((org.apache.xmlbeans.XmlLong)xmlObject_";
  protected final String TEXT_188 = ").setLongValue(";
  protected final String TEXT_189 = ".";
  protected final String TEXT_190 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_191 = NL + "\t\t\t\t\t\t\t\t\txmlObject_";
  protected final String TEXT_192 = " = org.apache.xmlbeans.XmlDouble.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\t((org.apache.xmlbeans.XmlDouble)xmlObject_";
  protected final String TEXT_193 = ").setDoubleValue(";
  protected final String TEXT_194 = ".";
  protected final String TEXT_195 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_196 = NL + "\t\t\t\t\t\t\t\t\t\"don't support entityCollection yet;\"" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_197 = NL + "\t\t\t\t\t\t\t\t\t\"don't support booleanManagedProperty yet;\"" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_198 = NL + "\t\t\t\t\t\t\t\t\t\"wrong type ";
  protected final String TEXT_199 = "\"" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_200 = NL + "\t\t\t\t\t\t\t\tattribute_";
  protected final String TEXT_201 = ".setValue(xmlObject_";
  protected final String TEXT_202 = ");\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_203 = NL + "\t\t\t    \t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_204 = NL + "\t\t\t\t\t\t\tentity_";
  protected final String TEXT_205 = ".setAttributes(attributes_";
  protected final String TEXT_206 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_207 = NL + "\t\t\t\t\t\t\t\tcom.microsoft.schemas.xrm._2011.contracts.services.CreateDocument.Create create_";
  protected final String TEXT_208 = " = com.microsoft.schemas.xrm._2011.contracts.services.CreateDocument.Create.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\tcreate_";
  protected final String TEXT_209 = ".setEntity(entity_";
  protected final String TEXT_210 = ");" + NL + "\t\t\t\t\t\t\t\tcom.microsoft.schemas.xrm._2011.contracts.services.CreateDocument createDoc_";
  protected final String TEXT_211 = " = com.microsoft.schemas.xrm._2011.contracts.services.CreateDocument.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\tcreateDoc_";
  protected final String TEXT_212 = ".setCreate(create_";
  protected final String TEXT_213 = ");" + NL + "\t\t\t\t\t\t\t\tcom.microsoft.schemas.xrm._2011.contracts.services.CreateResponseDocument.CreateResponse createResp_";
  protected final String TEXT_214 = " = null;" + NL + "\t\t\t\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\t\t\t\tcreateResp_";
  protected final String TEXT_215 = " = serviceStub_";
  protected final String TEXT_216 = ".create(createDoc_";
  protected final String TEXT_217 = ").getCreateResponse();" + NL + "\t\t\t\t\t\t\t\t}catch(com.microsoft.schemas.xrm._2011.contracts.IOrganizationService_Create_OrganizationServiceFaultFault_FaultMessage ex_";
  protected final String TEXT_218 = "){" + NL + "\t\t\t\t\t\t\t\t\tthrow new Exception(ex_";
  protected final String TEXT_219 = ".getFaultMessage().getOrganizationServiceFault().getMessage());" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t//String returnId_";
  protected final String TEXT_220 = " = createResp_";
  protected final String TEXT_221 = ".getCreateResult();" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_222 = NL + "\t\t\t\t\t\t\t\t\tcom.microsoft.schemas.xrm._2011.contracts.services.UpdateDocument.Update update_";
  protected final String TEXT_223 = " = com.microsoft.schemas.xrm._2011.contracts.services.UpdateDocument.Update.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\tupdate_";
  protected final String TEXT_224 = ".setEntity(entity_";
  protected final String TEXT_225 = ");" + NL + "\t\t\t\t\t\t\t\t\tcom.microsoft.schemas.xrm._2011.contracts.services.UpdateDocument updateDoc_";
  protected final String TEXT_226 = " = com.microsoft.schemas.xrm._2011.contracts.services.UpdateDocument.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\tupdateDoc_";
  protected final String TEXT_227 = ".setUpdate(update_";
  protected final String TEXT_228 = ");" + NL + "\t\t\t\t\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\t\t\t\t\tserviceStub_";
  protected final String TEXT_229 = ".update(updateDoc_";
  protected final String TEXT_230 = ");" + NL + "\t\t\t\t\t\t\t\t\t}catch(com.microsoft.schemas.xrm._2011.contracts.IOrganizationService_Update_OrganizationServiceFaultFault_FaultMessage ex_";
  protected final String TEXT_231 = "){" + NL + "\t\t\t\t\t\t\t\t\t\tthrow new Exception(ex_";
  protected final String TEXT_232 = ".getFaultMessage().getOrganizationServiceFault().getMessage());" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_233 = NL + "\t\t\t\t\t\t\t\t\tcom.microsoft.schemas.xrm._2011.contracts.OrganizationRequest request_";
  protected final String TEXT_234 = " = com.microsoft.schemas.xrm._2011.contracts.OrganizationRequest.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\trequest_";
  protected final String TEXT_235 = ".setNilRequestId();" + NL + "\t\t\t\t\t\t\t\t\trequest_";
  protected final String TEXT_236 = ".setRequestName(\"Assign\");" + NL + "\t\t\t\t\t\t\t\t\tcom.microsoft.schemas.xrm._2011.contracts.ParameterCollection parameters_";
  protected final String TEXT_237 = " = com.microsoft.schemas.xrm._2011.contracts.ParameterCollection.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\torg.datacontract.schemas._2004._07.system_collections_generic.KeyValuePairOfstringanyType parameter_";
  protected final String TEXT_238 = " = null;" + NL + "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\tparameter_";
  protected final String TEXT_239 = " = parameters_";
  protected final String TEXT_240 = ".addNewKeyValuePairOfstringanyType();" + NL + "\t\t\t\t\t\t\t\t\tparameter_";
  protected final String TEXT_241 = ".setKey(\"Target\");" + NL + "\t\t\t\t\t\t\t\t\tcom.microsoft.schemas.xrm._2011.contracts.EntityReference targetEntity_";
  protected final String TEXT_242 = " = com.microsoft.schemas.xrm._2011.contracts.EntityReference.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\ttargetEntity_";
  protected final String TEXT_243 = ".setId(";
  protected final String TEXT_244 = ".";
  protected final String TEXT_245 = ");" + NL + "\t\t\t\t\t\t\t\t\ttargetEntity_";
  protected final String TEXT_246 = ".setLogicalName(\"";
  protected final String TEXT_247 = "\");" + NL + "\t\t\t\t\t\t\t\t\tparameter_";
  protected final String TEXT_248 = ".setValue(targetEntity_";
  protected final String TEXT_249 = ");" + NL + "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\tparameter_";
  protected final String TEXT_250 = " = parameters_";
  protected final String TEXT_251 = ".addNewKeyValuePairOfstringanyType();" + NL + "\t\t\t\t\t\t\t\t\tparameter_";
  protected final String TEXT_252 = ".setKey(\"Assignee\");" + NL + "\t\t\t\t\t\t\t\t\tcom.microsoft.schemas.xrm._2011.contracts.EntityReference assigneeEntity_";
  protected final String TEXT_253 = " = com.microsoft.schemas.xrm._2011.contracts.EntityReference.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\tassigneeEntity_";
  protected final String TEXT_254 = ".setId(";
  protected final String TEXT_255 = ".";
  protected final String TEXT_256 = ");" + NL + "\t\t\t\t\t\t\t\t\tassigneeEntity_";
  protected final String TEXT_257 = ".setLogicalName(\"systemuser\");" + NL + "\t\t\t\t\t\t\t\t\tparameter_";
  protected final String TEXT_258 = ".setValue(assigneeEntity_";
  protected final String TEXT_259 = ");" + NL + "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\trequest_";
  protected final String TEXT_260 = ".setParameters(parameters_";
  protected final String TEXT_261 = ");" + NL + "\t\t\t\t\t\t\t\t\tcom.microsoft.schemas.xrm._2011.contracts.services.ExecuteDocument.Execute execute_";
  protected final String TEXT_262 = " = com.microsoft.schemas.xrm._2011.contracts.services.ExecuteDocument.Execute.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\texecute_";
  protected final String TEXT_263 = ".setRequest(request_";
  protected final String TEXT_264 = ");" + NL + "\t\t\t\t\t\t\t\t\tcom.microsoft.schemas.xrm._2011.contracts.services.ExecuteDocument executeDoc_";
  protected final String TEXT_265 = " = com.microsoft.schemas.xrm._2011.contracts.services.ExecuteDocument.Factory.newInstance();" + NL + "\t\t\t\t\t\t\t\t\texecuteDoc_";
  protected final String TEXT_266 = ".setExecute(execute_";
  protected final String TEXT_267 = ");" + NL + "\t\t\t\t\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\t\t\t\t\tserviceStub_";
  protected final String TEXT_268 = ".execute(executeDoc_";
  protected final String TEXT_269 = ");" + NL + "\t\t\t\t\t\t\t\t\t}catch(com.microsoft.schemas.xrm._2011.contracts.IOrganizationService_Execute_OrganizationServiceFaultFault_FaultMessage ex_";
  protected final String TEXT_270 = "){" + NL + "\t\t\t\t\t\t\t\t\t\tthrow new Exception(ex_";
  protected final String TEXT_271 = ".getFaultMessage().getOrganizationServiceFault().getMessage());" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_272 = NL + "\t\t\t\t\t\t\tcom.microsoft.schemas.xrm._2011.contracts.services.DeleteDocument.Delete delete_";
  protected final String TEXT_273 = " = com.microsoft.schemas.xrm._2011.contracts.services.DeleteDocument.Delete.Factory.newInstance();" + NL + "\t\t\t\t\t\t\tdelete_";
  protected final String TEXT_274 = ".setEntityName(\"";
  protected final String TEXT_275 = "\");" + NL + "\t\t\t\t\t\t\tdelete_";
  protected final String TEXT_276 = ".setId(";
  protected final String TEXT_277 = ".Id);" + NL + "\t\t\t\t\t\t\tcom.microsoft.schemas.xrm._2011.contracts.services.DeleteDocument deleteDoc_";
  protected final String TEXT_278 = " = com.microsoft.schemas.xrm._2011.contracts.services.DeleteDocument.Factory.newInstance();" + NL + "\t\t\t\t\t\t\tdeleteDoc_";
  protected final String TEXT_279 = ".setDelete(delete_";
  protected final String TEXT_280 = ");" + NL + "\t\t\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\t\t\tserviceStub_";
  protected final String TEXT_281 = ".delete(deleteDoc_";
  protected final String TEXT_282 = ");" + NL + "\t\t\t\t\t\t\t}catch(com.microsoft.schemas.xrm._2011.contracts.IOrganizationService_Delete_OrganizationServiceFaultFault_FaultMessage ex_";
  protected final String TEXT_283 = "){" + NL + "\t\t\t\t\t\t\t\tthrow new Exception(ex_";
  protected final String TEXT_284 = ".getFaultMessage().getOrganizationServiceFault().getMessage());" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_285 = NL + "\t\t\t\t\tnb_line_";
  protected final String TEXT_286 = "++;" + NL + "\t\t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	String authType = ElementParameterParser.getValue(node, "__AUTH_TYPE__");
	boolean isAPI2011 = ("API_2011").equals(ElementParameterParser.getValue(node,"__API_VERSION__"));
	
    String entityname = ElementParameterParser.getValue(node, "__ENTITYNAME__").trim();
    String customEntityname = ElementParameterParser.getValue(node, "__CUSTOM_ENTITY_NAME__");
    if("CustomEntity".equals(entityname)){
		entityname = customEntityname.replaceAll("\"","");
	}
	entityname = entityname.toLowerCase();
    String action = ElementParameterParser.getValue(node,"__ACTION__");

	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {//1
	    IMetadataTable metadata = metadatas.get(0);
	    if (metadata!=null) {//2
	        String cid = node.getUniqueName();
	
	    	List< ? extends IConnection> conns = node.getIncomingConnections();
	    	for (IConnection conn : conns) {//3
	    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//4
	    			String connName = conn.getName();
	    			List<IMetadataColumn> columns = metadata.getListColumns();
	    			int sizeColumns = columns.size();
				 	List<Map<String, String>> lookupMapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__LOOKUP_MAPPING__");
	    			
	    			if(!isAPI2011 || ("ON_PREMISE").equals(authType)){
		    			
		    			if("update".equals(action) && sizeColumns == 2 && "ownerid".equals(columns.get(1).getLabel())){
		    				 action = "reassignOwnerID";
		    			}
		    			boolean hasOwnerID = false;
						
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
						if("insert".equals(action) || "update".equals(action)){//************
						 	List activityEntities = java.util.Arrays.asList(new String[]{"activitypointer","appointment","bulkoperation","campaignactivity","campaignresponse","email","fax","incidentresolution","letter","opportunityclose","orderclose","phonecall","quoteclose","serviceappointment","task"});
				
		    				if("insert".equals(action))	{
							
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
		    				}else if("update".equals(action))	{
							
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
		    				}
							
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(entityname);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
        			
		    				for(int i = 0; i < sizeColumns; i++){//5  			
		
		    					IMetadataColumn column = columns.get(i);
		    				
								JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
							
								String entityMethodTemp = column.getLabel();
								String entityMethod = "";
							
								if("update".equals(action) && "ownerid".equals(column.getLabel()))	{
									hasOwnerID = true;
									continue;
								}
		
								boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
								if(!isPrimitive) { //begin
								
    stringBuffer.append(TEXT_15);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_17);
    
		    					}
		    					if(!"Id".equals(column.getLabel())){ 
								
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_21);
    
									if(lookupMapping.size()>0){
										for(Map<String, String> lookupMapper:lookupMapping){
											if(column.getLabel().equals(lookupMapper.get("INPUT_COLUMN"))){
											
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(lookupMapper.get("TYPE"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
											}
										}
									}						
									
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
         
			    					String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
			        				if(javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0){//Date
									
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_33);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_34);
    				
									} else {//others
									
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_38);
    				
									}
									
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    
								}else{
									String entityIdStr = entityname;
									if(activityEntities.contains(entityIdStr)){
										entityIdStr = "activity";
									}
									
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(entityIdStr);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(entityIdStr);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    
								}	
								
								if(!isPrimitive) {//end
								
    stringBuffer.append(TEXT_58);
    
								} 
							}//5	
		 					if("insert".equals(action)){//#######
							
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    
							}else if("update".equals(action)){//#######
							
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    
		  					}//#######
						}else if("delete".equals(action)){//*************	
						
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(entityname);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    
		  				}//************
		  				if("reassignOwnerID".equals(action) || ("update".equals(action) && hasOwnerID)){
						
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(entityname);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
      
						}
						
    stringBuffer.append(TEXT_121);
    
					}else{
						Map<String, String> crmTypeMapping = new HashMap<String, String>();
						crmTypeMapping.put("BOOLEAN", "bool");
						crmTypeMapping.put("CUSTOMER", "entityRef");
						crmTypeMapping.put("DATETIME", "datatime");
						crmTypeMapping.put("DECIMAL", "bigDecimal");
						crmTypeMapping.put("DOUBLE", "double");
						crmTypeMapping.put("INTEGER", "int");
						crmTypeMapping.put("LOOKUP", "entityRef");
						crmTypeMapping.put("MEMO", "string");
						crmTypeMapping.put("MONEY", "money");
						crmTypeMapping.put("OWNER", "entityRef");
						crmTypeMapping.put("PARTYLIST", "entityCollection");
						crmTypeMapping.put("PICKLIST", "optionSetValue");
						crmTypeMapping.put("STATE", "optionSetValue");
						crmTypeMapping.put("STATUS", "optionSetValue");
						crmTypeMapping.put("STRING", "string");
						crmTypeMapping.put("UNIQUEIDENTIFIER", "guid");
						crmTypeMapping.put("CALENDARRULES", "entityCollection");
						crmTypeMapping.put("BIGINT", "long");
						crmTypeMapping.put("MANAGEDPROPERTY", "booleanManagedProperty");
						crmTypeMapping.put("ENTITYNAME", "string");
						
						if("insert".equals(action) || "update".equals(action)){
							String ownerColumnName = null;
							String idColumnName = null; 
							
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(entityname);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    
							for(int i = 0; i < sizeColumns; i++){			
		    					IMetadataColumn column = columns.get(i);
								JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
								String crmType = column.getType();
								String columnName = column.getLabel();
								if("update".equals(action)){
									if("OWNER".equals(crmType)){
										ownerColumnName = columnName;
										continue;
									}
									if(column.isKey() && idColumnName == null){
										idColumnName = columnName;
									}
								}
								boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType(javaType, column.isNullable());
								if(!isPrimitive) {
								//if you want to set null, just skip this step. 
								
    stringBuffer.append(TEXT_129);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_131);
    
		    					}
		    					
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_136);
    
		    					if("entityRef".equals(crmTypeMapping.get(crmType))){
									boolean hasFound = false;
									if(lookupMapping.size()>0){
										for(Map<String, String> lookupMapper:lookupMapping){
											if(columnName.equals(lookupMapper.get("INPUT_COLUMN"))){
												hasFound = true;
												
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(lookupMapper.get("TYPE"));
    stringBuffer.append(TEXT_143);
    
											}
										}
									}
									if(!hasFound){
									
    stringBuffer.append(TEXT_144);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_145);
    						
									}
								}else if("optionSetValue".equals(crmTypeMapping.get(crmType))){
								
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_150);
    	
								}else if("money".equals(crmTypeMapping.get(crmType))){
								
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_155);
    
								}else if("guid".equals(crmTypeMapping.get(crmType))){
								
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_160);
    
								}else if("string".equals(crmTypeMapping.get(crmType))){
								
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_165);
    
								}else if("datatime".equals(crmTypeMapping.get(crmType))){
								
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_170);
    
								}else if("bool".equals(crmTypeMapping.get(crmType))){
								
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_175);
    
								}else if("bigDecimal".equals(crmTypeMapping.get(crmType))){
								
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_180);
    
								}else if("int".equals(crmTypeMapping.get(crmType))){
								
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_185);
    
								}else if("long".equals(crmTypeMapping.get(crmType))){
								
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_190);
    
								}else if("double".equals(crmTypeMapping.get(crmType))){
								
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_195);
    
								}else if("entityCollection".equals(crmTypeMapping.get(crmType))){
								
    stringBuffer.append(TEXT_196);
    
								}else if("booleanManagedProperty".equals(crmTypeMapping.get(crmType))){
								
    stringBuffer.append(TEXT_197);
    
								}else{
								
    stringBuffer.append(TEXT_198);
    stringBuffer.append(crmType);
    stringBuffer.append(TEXT_199);
    
								}
								
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    
								if(!isPrimitive) {
								
    stringBuffer.append(TEXT_203);
     
								} 
							}
							
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    if("insert".equals(action)){
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    
							}else if("update".equals(action)){
								if(ownerColumnName != null && columns.size() == 2){
								//don't need to update, just do reassign opertion is enough.
								}else{
								
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    
								}
								if(ownerColumnName != null){
								
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(idColumnName);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(entityname);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(ownerColumnName);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    	
								}
							}
						}
						else if("delete".equals(action)){
						
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(entityname);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    
						}
					}
					
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_286);
     
	    		}//4
	    	}//3
	    }//2
	}//1
	
    return stringBuffer.toString();
  }
}
