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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mz.advisell.bean.Document;

/**
 *
 * @author parii
 */
public class DocumentService {

    public int uploadDocuments(ArrayList<Document> documentList, String aadharNo) {
        int result = 0;
        File directory = new File("documents/" + aadharNo);
        result = uploadDocuments(directory, documentList);
        return result;
    }

    public int resetDocuments(ArrayList<Document> documentList, String aadhar) {
        int result = 0;
        result = uploadDocuments(new File("documents/" + aadhar + "/temp_Documents"), documentList);
        if (result == 0) {
            return result;
        }
        result = deleteDocuments(aadhar);
        if (result==-1) {
            return result;
        }
        result = moveDocuments(new File("documents/" + aadhar), documentList);
        return result;
    }

    private int uploadDocuments(File directory, ArrayList<Document> documentList) {
        int result = 0;
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        File file = null;
        boolean deleteDirResult=deleteDirectory(directory);
        if(!(deleteDirResult)){
            return result=-2;
        }
        directory.mkdir();
        try {
            for (Document document : documentList) {
                file = new File(directory + File.separator + document.getFileName());
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
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            }
        }

        return result;
    }

    private int moveDocuments(File directory, ArrayList<Document> documentList) {
        int result = -2;
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        File file = null;
        try {
            for (Document document : documentList) {
                file = new File(directory + File.separator + document.getFileName());
                fileInputStream = new FileInputStream(directory + "/temp_Documents/" + document.getFileName());
                fileOutputStream = new FileOutputStream(file);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = fileInputStream.read(buffer)) > 0) {
                    fileOutputStream.write(buffer, 0, length);
                }
            }
            result = 1;
        } catch (FileNotFoundException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            }
        }

        return result;
    }

    public int deleteDocuments(String aadharNo) {
        int result = -1;
        File directory = new File("documents/" + aadharNo);
        File[] fileArray = directory.listFiles();
        for (File file : fileArray) {
            if (file.isFile()) {
                if(file.delete()){
                    result=1;
                }else{
                    return result=-1;
                }
            }
        }
        if(!(fileArray[0].isDirectory())){
          if(deleteDirectory(directory)){
              result=1;
          }else{
              result=-1;
          }  
        }
        return result;
    }
    
    private boolean deleteDirectory(File directory){
        boolean result=false;
        result=directory.delete();
        return result;
    }
}
