/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mz.advisell.bo.uploadDocument;

import java.io.File;
import java.util.ArrayList;
import org.mz.advisell.model.Document;





/**
 *
 * @author parii
 */
public interface ClientProfileUploadDocumentBo {
    void uploadDocument(ArrayList<Document> documentList,String aadharNo);

    public void deleteDocument(ArrayList<Document> deleteDocumentList, String aadharNo);
}
