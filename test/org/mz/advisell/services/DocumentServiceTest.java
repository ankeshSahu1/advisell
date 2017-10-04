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
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.mz.advisell.bean.Document;

/**
 *
 * @author parii
 */
public class DocumentServiceTest {

    DocumentService documentService;

    public DocumentServiceTest() {
    }

    @Before()
    public void createInstance() {
        documentService = new DocumentService();
    }

    /**
     * TestCase 1 of uploadDocuments method
     * No document upload
     * Test of uploadDocuments method, of class DocumentService.
     * Expected result 0
     * Actual result 1
     */
    @Test
    public void testNoDocumentUpload() {
        assertEquals(0, documentService.uploadDocuments(new ArrayList<Document>(), "776575678767"));
    }

    /**
     * TestCase 2 of uploadDocuments method
     * Single document upload
     * Test of uploadDocuments method, of class DocumentService.
     * Expected result 1
     * Actual result 1
     */
    @Test
    public void testSingleDocumentUpload() {
        ArrayList<Document> documentsList = new ArrayList<Document>();
        Document document = new Document();
        document.setFile(new File("D:/mz app images/91870a_1489163243725.jpg"));
        document.setFileName("91870a_1489163243725.jpg");
        documentsList.add(document);
        assertEquals(1, documentService.uploadDocuments(documentsList, "776595678767"));
    }
    
    /**
     * TestCase 3 of uploadDocuments method
     * Multi documents upload
     * Test of uploadDocuments method, of class DocumentService.
     * Expected result 1
     * Actual result 1
     */
    @Test
    public void testMultiDocumentsUpload() {
        ArrayList<Document> documentsList = new ArrayList<Document>();
        Document document = new Document();
        document.setFile(new File("D:/mz app images/91870a_1489163243725.jpg"));
        document.setFileName("91870a_1489163243725.jpg");
        documentsList.add(document);
        Document document2 = new Document();
        document2.setFile(new File("D:/mz app images/162bfe0b3d89c7af38d734eb582bc859.jpg"));
        document2.setFileName("162bfe0b3d89c7af38d734eb582bc859.jpg");
        documentsList.add(document2);
        Document document3 = new Document();
        document3.setFile(new File("D:/mz app images/2.jpg"));
        document3.setFileName("2.jpg");
        documentsList.add(document3);
        assertEquals(1, documentService.uploadDocuments(documentsList, "776595678767"));
    }
    
    /**
     * TestCase 1 of resetDocuments method
     * No document upload
     * Test of resetDocuments method, of class DocumentService.
     * Expected result 0
     * Actual result 1
     */
    @Test
    public void testResetNoDocument() {
        assertEquals(0,documentService.resetDocuments(new ArrayList<Document>(), "753595678767")); 
    }

    /**
     * TestCase 2 of resetDocuments method
     * Single document upload
     * Test of resetDocuments method, of class DocumentService.
     * Expected result 1
     * Actual result 1
     */
    @Test
    public void testResetSingleDocument() {
        ArrayList<Document> documentsList = new ArrayList<Document>();
        Document document = new Document();
        document.setFile(new File("D:/mz app images/91870a_1489163243725.jpg"));
        document.setFileName("91870a_1489163243725.jpg");
        documentsList.add(document);
        assertEquals(1, documentService.resetDocuments(documentsList, "753595678767")); 
    }
    
    /**
     * TestCase 3 of resetDocuments method
     * Multi documents upload
     * Test of resetDocuments method, of class DocumentService.
     * Expected result 1
     * Actual result 1
     */
    @Test
    public void testResetMultiDocuments() {
        ArrayList<Document> documentsList = new ArrayList<Document>();
        Document document = new Document();
        document.setFile(new File("D:/mz app images/91870a_1489163243725.jpg"));
        document.setFileName("91870a_1489163243725.jpg");
        documentsList.add(document);
        Document document2 = new Document();
        document2.setFile(new File("D:/mz app images/162bfe0b3d89c7af38d734eb582bc859.jpg"));
        document2.setFileName("162bfe0b3d89c7af38d734eb582bc859.jpg");
        documentsList.add(document2);
        Document document3 = new Document();
        document3.setFile(new File("D:/mz app images/2.jpg"));
        document3.setFileName("2.jpg");
        documentsList.add(document3);
        assertEquals(1, documentService.uploadDocuments(documentsList, "753595678767")); 
    }

    /**
     * TestCase 1 of deleteDocuments method
     * Directory not existed and try to delete documents
     * Test of deleteDocuments method, of class DocumentService.
     * Expected result 0
     * Actual result 1
     */
    @Test
    public void testNotExistedDirectoryDeleted() {
        assertEquals(0,documentService.deleteDocuments("7534564"));
    }
    
    /**
     * TestCase 2 of deleteDocuments method
     * Delete documents
     * Test of deleteDocuments method, of class DocumentService.
     * Expected result 1
     * Actual result 1
     */
    @Test
    public void testDeleteDocuments() {
        assertEquals(1,documentService.deleteDocuments("753595678767"));
        assertArrayEquals(null,new File("documents/753595678767").listFiles());
    }

}
