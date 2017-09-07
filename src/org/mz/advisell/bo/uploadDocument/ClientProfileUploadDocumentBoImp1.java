/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mz.advisell.bo.uploadDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.mz.advisell.model.Document;

/**
 *
 * @author parii
 */
public class ClientProfileUploadDocumentBoImp1 implements ClientProfileUploadDocumentBo {

    @Override
    public void uploadDocument(ArrayList<Document> documentList, String aadharNo) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        File file = null;
        File dir = new File("documents/" + aadharNo);
        dir.mkdir();
        try {
            for (Document document : documentList) {
                file = new File(dir + File.separator + document.getFileName());
                fileInputStream = new FileInputStream(document.getFile());
                fileOutputStream = new FileOutputStream(file);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = fileInputStream.read(buffer)) > 0) {
                    fileOutputStream.write(buffer, 0, length);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteDocument(ArrayList<Document> deleteDocumentList, String aadharNo) {
        for (Document document : deleteDocumentList) {
            File file = new File("documents/" + aadharNo+"/"+document.getFileName());
            file.delete();
        } 
    }

}
