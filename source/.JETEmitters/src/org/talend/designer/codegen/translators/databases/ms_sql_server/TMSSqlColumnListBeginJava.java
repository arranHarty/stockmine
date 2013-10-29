package org.talend.designer.codegen.translators.databases.ms_sql_server;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;

public class TMSSqlColumnListBeginJava
{
  protected static String nl;
  public static synchronized TMSSqlColumnListBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMSSqlColumnListBeginJava result = new TMSSqlColumnListBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tjava.sql.Connection conn_";
  protected final String TEXT_3 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_4 = "\");" + NL + "" + NL + "\tString db_";
  protected final String TEXT_5 = " = (String)globalMap.get(\"";
  protected final String TEXT_6 = "\");" + NL + "" + NL + "\tString table_";
  protected final String TEXT_7 = " = ";
  protected final String TEXT_8 = ";" + NL + "" + NL + "\tString dbSchema_";
  protected final String TEXT_9 = " = (String)globalMap.get(\"";
  protected final String TEXT_10 = "\");" + NL + "" + NL + "\tString query_";
  protected final String TEXT_11 = " = \"\";" + NL + "" + NL + "\tif(dbSchema_";
  protected final String TEXT_12 = " != null && dbSchema_";
  protected final String TEXT_13 = ".length() > 0){" + NL + "\t\tquery_";
  protected final String TEXT_14 = " = \"SELECT t.COLUMN_NAME, t.COLUMN_DEFAULT, t.IS_NULLABLE, t.DATA_TYPE, t.CHARACTER_MAXIMUM_LENGTH, \" +" + NL + "\t\t\t\t\"t.CHARACTER_OCTET_LENGTH, t.NUMERIC_PRECISION, t.NUMERIC_PRECISION_RADIX, t.NUMERIC_SCALE, t.DATETIME_PRECISION,\" +" + NL + "\t\t\t\t\" c.COLUMN_NAME, t.ORDINAL_POSITION FROM (SELECT * FROM information_schema.columns WHERE TABLE_CATALOG='\" +" + NL + "\t\t\t\tdb_";
  protected final String TEXT_15 = " + \"' AND TABLE_SCHEMA='\" + dbSchema_";
  protected final String TEXT_16 = " + \"' AND TABLE_NAME='\" + table_";
  protected final String TEXT_17 = " +" + NL + "\t\t\t\t\"') AS t  LEFT OUTER JOIN (SELECT isK.COLUMN_NAME,isK.CONSTRAINT_NAME FROM information_schema.KEY_COLUMN_USAGE isK,\" +" + NL + "\t\t\t\t\"information_schema.TABLE_CONSTRAINTS isT WHERE isK.TABLE_CATALOG='\" + db_";
  protected final String TEXT_18 = " + " + NL + "\t\t\t\t\"' AND isK.TABLE_SCHEMA='\" + dbSchema_";
  protected final String TEXT_19 = " + \"' AND isK.TABLE_NAME='\" + table_";
  protected final String TEXT_20 = "+ " + NL + "\t\t\t\t\"' AND isT.CONSTRAINT_TYPE='PRIMARY KEY'AND isK.CONSTRAINT_NAME=isT.CONSTRAINT_NAME) \" +" + NL + "\t\t\t\t\"AS c ON t.COLUMN_NAME=c.COLUMN_NAME ORDER BY t.ORDINAL_POSITION\";" + NL + "\t" + NL + "\t}else{" + NL + "\t\tquery_";
  protected final String TEXT_21 = " = \"SELECT t.COLUMN_NAME, t.COLUMN_DEFAULT, t.IS_NULLABLE, t.DATA_TYPE, \" +" + NL + "\t\t\t\"t.CHARACTER_MAXIMUM_LENGTH, t.CHARACTER_OCTET_LENGTH, t.NUMERIC_PRECISION, \" + " + NL + "\t\t\t\"t.NUMERIC_PRECISION_RADIX, t.NUMERIC_SCALE, t.DATETIME_PRECISION, c.COLUMN_NAME, \" + " + NL + "\t\t\t\"t.ORDINAL_POSITION FROM (SELECT * FROM information_schema.columns WHERE TABLE_CATALOG='\" + db_";
  protected final String TEXT_22 = " + " + NL + "\t\t\t\"' AND TABLE_NAME='\" + table_";
  protected final String TEXT_23 = " +\"') AS t LEFT OUTER JOIN (SELECT isK.COLUMN_NAME,isK.CONSTRAINT_NAME FROM information_schema.KEY_COLUMN_USAGE isK,\" +" + NL + "\t\t\t\"information_schema.TABLE_CONSTRAINTS isT WHERE isK.TABLE_CATALOG='\" + db_";
  protected final String TEXT_24 = " + " + NL + "\t\t\t\"' AND isK.TABLE_NAME='\" + table_";
  protected final String TEXT_25 = "+ " + NL + "\t\t\t\"' AND isT.CONSTRAINT_TYPE='PRIMARY KEY'AND isK.CONSTRAINT_NAME=isT.CONSTRAINT_NAME) AS c ON t.COLUMN_NAME=c.COLUMN_NAME ORDER BY t.ORDINAL_POSITION\";\t" + NL + "\t}" + NL + "" + NL + "\tint nb_column_";
  protected final String TEXT_26 = " = 0;" + NL + "\t" + NL + "\tjava.sql.Statement stmt2_";
  protected final String TEXT_27 = " = conn_";
  protected final String TEXT_28 = ".createStatement();" + NL + "\t" + NL + "\tjava.sql.ResultSet rs_";
  protected final String TEXT_29 = " = stmt2_";
  protected final String TEXT_30 = ".executeQuery(query_";
  protected final String TEXT_31 = ");" + NL + "\t" + NL + "\t" + NL + "\twhile (rs_";
  protected final String TEXT_32 = ".next()) {" + NL + "\t" + NL + "\t\tString currentColumnName_";
  protected final String TEXT_33 = " = rs_";
  protected final String TEXT_34 = ".getString(1);" + NL + "\t\t" + NL + "\t\tString columnDefault_";
  protected final String TEXT_35 = " = rs_";
  protected final String TEXT_36 = ".getString(2);" + NL + "\t\t" + NL + "\t\tString isNullable_";
  protected final String TEXT_37 = " = rs_";
  protected final String TEXT_38 = ".getString(3);" + NL + "\t\t" + NL + "\t\tString dataType_";
  protected final String TEXT_39 = " = rs_";
  protected final String TEXT_40 = ".getString(4);" + NL + "\t\t" + NL + "\t\tString characterMaximumLength_";
  protected final String TEXT_41 = " = rs_";
  protected final String TEXT_42 = ".getString(5);" + NL + "\t\t" + NL + "\t\tString characterOctetLength_";
  protected final String TEXT_43 = " = rs_";
  protected final String TEXT_44 = ".getString(6);" + NL + "\t\t" + NL + "\t\tString numericPrecision_";
  protected final String TEXT_45 = " = rs_";
  protected final String TEXT_46 = ".getString(7);" + NL + "\t" + NL + "\t\tString numericPrecisionRadix_";
  protected final String TEXT_47 = " = rs_";
  protected final String TEXT_48 = ".getString(8);" + NL + "\t\t" + NL + "\t\tString numericScale_";
  protected final String TEXT_49 = " = rs_";
  protected final String TEXT_50 = ".getString(9);" + NL + "\t\t" + NL + "\t\tString dateTimePrecision_";
  protected final String TEXT_51 = " = rs_";
  protected final String TEXT_52 = ".getString(10);" + NL + "\t\t" + NL + "\t\tString columKey_";
  protected final String TEXT_53 = " = \"NO\";" + NL + "\t\t" + NL + "\t\tif(rs_";
  protected final String TEXT_54 = ".getString(11) != null){" + NL + "\t\t\tcolumKey_";
  protected final String TEXT_55 = " = \"YES\";" + NL + "\t\t}" + NL + "\t" + NL + "\t\tnb_column_";
  protected final String TEXT_56 = "++;" + NL + "\t        " + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_57 = "_COLUMN_NAME\", currentColumnName_";
  protected final String TEXT_58 = ");" + NL + "\t\t" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_59 = "_COLUMN_DEFAULT\", columnDefault_";
  protected final String TEXT_60 = ");" + NL + "\t\t" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_61 = "_IS_NULLABLE\", isNullable_";
  protected final String TEXT_62 = ");" + NL + "\t\t" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_63 = "_DATA_TYPE\", dataType_";
  protected final String TEXT_64 = ");" + NL + "\t\t" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_65 = "_CHARACTER_MAXIMUM_LENGTH\", characterMaximumLength_";
  protected final String TEXT_66 = ");" + NL + "\t" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_67 = "_CHARACTER_OCTET_LENGTH\", characterOctetLength_";
  protected final String TEXT_68 = ");" + NL + "\t\t" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_69 = "_NUMERIC_PRECISION\", numericPrecision_";
  protected final String TEXT_70 = ");" + NL + "\t\t" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_71 = "_NUMERIC_PRECISION_RADIX\", numericPrecisionRadix_";
  protected final String TEXT_72 = ");" + NL + "\t" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_73 = "_NUMERIC_SCALE\", numericScale_";
  protected final String TEXT_74 = ");" + NL + "\t\t" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_75 = "_DATETIME_PRECISION\", dateTimePrecision_";
  protected final String TEXT_76 = ");" + NL + "\t" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_77 = "_COLUMN_KEY\", columKey_";
  protected final String TEXT_78 = ");";
  protected final String TEXT_79 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();

    String cid = node.getUniqueName();
    
    String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
    
    String conn = "conn_" + connection;
    
    String db = "db_" + connection;
    
    String dbSchema = "dbschema_" + connection;
    
    String table = ElementParameterParser.getValue(node,"__TABLE_NAME__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(db );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(table );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(dbSchema );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(TEXT_79);
    return stringBuffer.toString();
  }
}
