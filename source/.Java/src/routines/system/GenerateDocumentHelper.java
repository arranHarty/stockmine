// ============================================================================
//
// Copyright (C) 2006-2013 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package routines.system;


/**
 * created by talend2 on 2013-10-17 Detailled comment
 * 
 */
public class GenerateDocumentHelper {
    
    //do some work after document has been generated
    public static void generateOk(routines.system.Document doc,boolean removeEmptyElement) {
        if(doc == null || doc.getDocument() == null) {
            return;
        }
        NestXMLTool.replaceDefaultNameSpace(doc.getDocument().getRootElement(),null);
        
        if(removeEmptyElement) {
            NestXMLTool.removeEmptyElement(doc.getDocument().getRootElement());
        }
    }
    
}
