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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mz.advisell.bean.Document;
import org.mz.advisell.bean.Profile;
import org.mz.advisell.services.dao.DBConnection;

/**
 *
 * @author metazone
 */
public class ProfileService {

    private Connection connection;

    public int addProfile(Profile profile) {
        DBConnection dbConnection = new DBConnection();
        PreparedStatement statement = null;
        int result = 0;
        try {
            connection = dbConnection.createConnection();
            statement = connection.prepareStatement("INSERT INTO profile(first_name,last_name,mobile,phone,email,address,aadhar,pan_no,documents) VALUES(?,?,?,?,?,?,?,?,?);");
            statement.setString(1, (String) profile.getFirstName());
            statement.setString(2, (String) profile.getLastName());
            statement.setString(3, (String) profile.getContactNumber());
            statement.setString(4, (String) profile.getPhoneNumber());
            statement.setString(5, (String) profile.getEmailId());
            statement.setString(6, (String) profile.getAddress());
            statement.setString(7, (String) profile.getAadharCardNumber());
            statement.setString(8, (String) profile.getPanNumber());
            StringBuilder documents = new StringBuilder();
            for (Document document : profile.getDocumentList()) {
                if (documents.length() != 0) {
                    documents.append(",");
                }
                documents.append(document.getFileName());
            }
            statement.setString(9, documents.toString());
            result = statement.executeUpdate();
            
            if(result == 0){
                return result;
            }
            DocumentService uploadService = new DocumentService();
            result = uploadService.uploadDocuments(profile.getDocumentList(), profile.getAadharCardNumber());
        
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            }
            dbConnection.closeConnection();
        }
        return result;
    }

    public int updateProfile(Profile profile) {
        PreparedStatement statement = null;
        DBConnection dbConnection = new DBConnection();
        int result = 0;
        StringBuilder documents = new StringBuilder();
        try {
            connection = dbConnection.createConnection();
            String query = "UPDATE profile SET first_name=?,last_name=?,mobile=?,phone=?,email=?,address=?,aadhar=?,pan_no=?,documents=? WHERE  aadhar=" + profile.getAadharCardNumber();
            statement = connection.prepareStatement(query);
            statement.setString(1, (String) profile.getFirstName());
            statement.setString(2, (String) profile.getLastName());
            statement.setString(3, (String) profile.getContactNumber());
            statement.setString(4, (String) profile.getPhoneNumber());
            statement.setString(5, (String) profile.getEmailId());
            statement.setString(6, (String) profile.getAddress());
            statement.setString(7, (String) profile.getAadharCardNumber());
            statement.setString(8, (String) profile.getPanNumber());
            for (Document document : profile.getDocumentList()) {
                if (documents.length() != 0) {
                    documents.append(",");
                }
                documents.append(document.getFileName());
            }
            statement.setString(9, documents.toString());
            result = statement.executeUpdate();
            
            if(result == 0){
                return result;
            }
            DocumentService resetService = new DocumentService();
            result = resetService.resetDocuments(profile.getDocumentList(), profile.getAadharCardNumber());

        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            }
            dbConnection.closeConnection();
        }
        return result;
    }

    public int deleteProfile(String aadharCardNo) {
        PreparedStatement statement = null;
        DBConnection dbConnection = new DBConnection();
        int result = 0;
        try {
            connection = dbConnection.createConnection();
            statement = connection.prepareStatement("DELETE FROM profile WHERE aadhar=?;");
            statement.setString(1, aadharCardNo);
            result = statement.executeUpdate();
            
            if(result == 0){
                return result;
            }
            DocumentService documentService = new DocumentService();
            result = documentService.deleteDocuments(aadharCardNo);
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            }
            dbConnection.closeConnection();
        }
        return result;
    }
    
    public Profile getClientDetails(String aadharCardNo) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Profile profile = null;
        DBConnection dbConnection = new DBConnection();
        try {
            connection = dbConnection.createConnection();
            statement = connection.prepareStatement("SELECT * FROM profile WHERE aadhar=?");
            statement.setString(1, aadharCardNo);
            resultSet = statement.executeQuery();
            profile = new Profile();
            if (resultSet.next()) {
                profile.setFirstName(resultSet.getString(1));
                profile.setLastName(resultSet.getString(2));
                profile.setGender(resultSet.getString(3));
                profile.setContactNumber(resultSet.getString(4));
                profile.setPanNumber(resultSet.getString("pan_no"));
                profile.setPhoneNumber(resultSet.getString("phone"));
                profile.setEmailId(resultSet.getString(5));
                profile.setAddress(resultSet.getString(6));
                profile.setCity(resultSet.getString(7));
                profile.setState(resultSet.getString(8));
                profile.setPinNumber(resultSet.getString(9));
                profile.setAadharCardNumber(resultSet.getString(10));
                profile.setDocumentList(createDocumentList(resultSet.getString("documents"), aadharCardNo));
                profile.setInvestmentList(new InvestmentService().getInvestmentList(aadharCardNo));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            }
            dbConnection.closeConnection();
        }
        return profile;
    }
    
    private ArrayList<Document> createDocumentList(String documents, String aadhar){
        ArrayList<Document> documentList = new ArrayList<>();
        String[] fileNameArray = documents.split(",");
        for(String fileName: fileNameArray){
            Document document = new Document();
            document.setFile(new File("documents/"+aadhar+"/"+fileName));
            document.setFileName(fileName);
            documentList.add(document);
        }
        return documentList;
    }
}
