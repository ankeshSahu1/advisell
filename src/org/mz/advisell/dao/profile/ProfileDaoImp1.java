/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mz.advisell.dao.profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.mz.advisell.dao.connection.DBConnection;
import org.mz.advisell.model.Document;
import org.mz.advisell.model.Profile;

/**
 *
 * @author metazone
 */
public class ProfileDaoImp1 implements ProfileDao {

    private Connection connection;

    @Override
    public int addProfile(Profile profile) {
        DBConnection dbConnection = new DBConnection();
        PreparedStatement statement = null;
        int result = 0;
        try {
            connection = dbConnection.createConnection();
            statement = connection.prepareStatement("INSERT INTO profile(first_name,last_name,contact,phone,email,address,aadhar,pan_no,documents)"
                    + " VALUES(?,?,?,?,?,?,?,?,?);");
            statement.setString(1, (String) profile.getFirstName());
            statement.setString(2, (String) profile.getLastName());
//            statement.setString(3, (String) profile.getGender());
            statement.setString(3, (String) profile.getContactNumber());
            statement.setString(4, (String) profile.getPhoneNumber());
            statement.setString(5, (String) profile.getEmailId());
            statement.setString(6, (String) profile.getAddress());
//            statement.setString(7, (String) profile.getCity());
//            statement.setString(8, (String) profile.getState());
//            statement.setString(9, (String) profile.getPinNumber());
            statement.setString(7, (String) profile.getAadharCardNumber());
            statement.setString(8, (String) profile.getPanNumber());
            String documents = "";
            if (!(profile.getDocumentList().isEmpty())) {
                for (Document document : profile.getDocumentList()) {
                    if (documents.equals("")) {
                        documents = documents.concat(document.getFileName());
                    } else {
                        documents = documents.concat("," + document.getFileName());
                    }
                }
            }
            statement.setString(9, documents);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public int updateProfile(Profile profile, ArrayList<Document> deleteDocumentList) {
        PreparedStatement statement = null;
        DBConnection dbConnection = new DBConnection();
        int result = 0;
        ResultSet resultSet = null;
        String documents = "";
        try {
            connection = dbConnection.createConnection();
            statement = connection.prepareStatement("SELECT documents FROM profile WHERE aadhar=?");
            statement.setString(1, (String) profile.getAadharCardNumber());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                documents = resultSet.getString("documents");
            }
            statement.close();
            resultSet.close();
            String query = "UPDATE profile SET first_name=?,last_name=?,contact=?,phone=?,email=?,address=?,aadhar=?,pan_no=?,documents=? WHERE  aadhar=" + profile.getAadharCardNumber();
            statement = connection.prepareStatement(query);
            statement.setString(1, (String) profile.getFirstName());
            statement.setString(2, (String) profile.getLastName());
            //statement.setString(3, (String) profile.getGender());
            statement.setString(3, (String) profile.getContactNumber());
            statement.setString(4, (String) profile.getPhoneNumber());
            statement.setString(5, (String) profile.getEmailId());
            statement.setString(6, (String) profile.getAddress());
            //statement.setString(7, (String) profile.getCity());
            //statement.setString(8, (String) profile.getState());
            //statement.setString(9, (String) profile.getPinNumber());
            statement.setString(7, (String) profile.getAadharCardNumber());
            statement.setString(8, (String) profile.getPanNumber());
            //System.out.println(deleteDocumentList);
            if (!(deleteDocumentList.isEmpty())) {
                for (Document document : deleteDocumentList) {
                    if (documents.contains(",")) {
                        String[] filesName = documents.split(",");
                        for (String fileName : filesName) {
                            if (fileName.equals(document.getFileName())) {
                                if (filesName[0].equals(document.getFileName())) {
                                    documents = documents.replace(fileName+",", "");
                                } else {
                                    documents = documents.replace("," + fileName, "");
                                }
                            }
                        }
                    } else {
                        documents = documents.replace(documents, "");
                    }
                }
            }
            //System.out.println(documents);
            if (!(profile.getDocumentList().isEmpty())) {
                for (Document document : profile.getDocumentList()) {
                    if (documents.equals("")) {
                        documents = documents.concat(document.getFileName());
                    } else {
                        documents = documents.concat("," + document.getFileName());
                    }
                }
            }
            statement.setString(9, documents);
            result = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
        return result;
    }

    @Override
    public int deleteProfile(String aadharCardNo) {
        PreparedStatement statement = null;
        DBConnection dbConnection = new DBConnection();
        int result = 0;
        try {
            connection = dbConnection.createConnection();
            statement = connection.prepareStatement("DELETE FROM profile WHERE aadhar=?;");
            statement.setString(1, aadharCardNo);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
        return result;
    }

    // @Override
//    public int uploadDocument(Document documentList, String aadharNo) {
//        PreparedStatement statement = null;
//        DBConnection dbConnection = new DBConnection();
//        int result = 0;
//        try {
//            connection = dbConnection.createConnection();
//            statement = connection.prepareStatement("Insert into client_documents values(?,?)");
//            for (int i = 0; i < documentsList.size(); i++) {
//                if (documentsList.get(i) != null) {
//                    statement.setString(1, aadhar_no);
//                    if (!documentsList.isEmpty()) {
//                        statement.setString(2, documentsList.get(i).toString());
//                    }
//                    result = statement.executeUpdate();
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (statement != null) {
//                    statement.close();
//                }
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//
//            }
//        }
//        return result;
//    }
}
