/*
 * Copyright (C) 2017 Metazone Infotech Pvt Ltd
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.mz.advisell.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.mz.advisell.bean.Document;

/**
 *
 * @author parii
 */
public class DocumentService{

    public int uploadDocuments(ArrayList<Document> documentList, String aadharNo) {
        int result = 0;
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
            result = 1;
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
        
        return result;
    }
    
    public int resetDocuments(ArrayList<Document> documentList, String aadhar){
        
    }

    public int deleteDocuments(String aadharNo) {
        File file = new File("documents/" + aadharNo);
        File[] documentArray=file.listFiles();
        for(File document:documentArray){
            document.delete();
        }
        file.delete();
        return result;
    }
}
