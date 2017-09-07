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
package org.mz.advisell.dao.search;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mz.advisell.constant.Constant;
import org.mz.advisell.dao.connection.DBConnection;
import org.mz.advisell.model.Document;
import org.mz.advisell.model.Profile;

/**
 *
 * @author metazone
 */
public class SearchDaoImp1 implements SearchDao {

    private Connection connection;

    @Override
    public Profile getClientDetails(String aadharCardNo) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Profile profile = new Profile();
        DBConnection dbConnection = new DBConnection();
        try {
            connection = dbConnection.createConnection();
            statement = connection.prepareStatement("SELECT * FROM profile WHERE aadhar=?");
            statement.setString(1, aadharCardNo);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                profile.setFirstName(resultSet.getString(1));
                profile.setLastName(resultSet.getString(2));
                profile.setGender(resultSet.getString(3));
                profile.setContactNumber(resultSet.getString(4));
                profile.setEmailId(resultSet.getString(5));
                profile.setAddress(resultSet.getString(6));
                profile.setCity(resultSet.getString(7));
                profile.setState(resultSet.getString(8));
                profile.setPinNumber(resultSet.getString(9));
                profile.setAadharCardNumber(resultSet.getString(10));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchDaoImp1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
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
        return profile;
    }

    @Override
    public ArrayList<Profile> getClientList(String searchValue) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<Profile> clientDetails = new ArrayList<Profile>();
        DBConnection dbConnection = new DBConnection();
        String query = "SELECT * FROM profile WHERE";
        StringBuilder queryBuilder = new StringBuilder(query);
        try {
            connection = dbConnection.createConnection();
            if (searchValue != "" && searchValue != null) {
                if (!searchValue.isEmpty()) {
                    queryBuilder.append(Constant.QUERY_AADHAR);
                    queryBuilder.append(Constant.QUERY_LIKE);
                    queryBuilder.append("'%" + searchValue + "%'");
                    queryBuilder.append(Constant.QUERY_OR);
                    queryBuilder.append(Constant.QUERY_PAN_NUMBER);
                    queryBuilder.append(Constant.QUERY_LIKE);
                    queryBuilder.append("'%" + searchValue + "%'");
                    queryBuilder.append(Constant.QUERY_OR);
                    queryBuilder.append(Constant.QUERY_NUMBER);
                    queryBuilder.append(Constant.QUERY_LIKE);
                    queryBuilder.append("'%" + searchValue + "%'");
                    queryBuilder.append(Constant.QUERY_OR);
                    queryBuilder.append(Constant.QUERY_CONCAT + ('(' + Constant.QUERY_FIRST_NAME + ',' + "''" + ',' + Constant.QUERY_LAST_NAME + ')'));
                    queryBuilder.append(Constant.QUERY_LIKE);
                    queryBuilder.append("'%" + searchValue + "%'");
                    statement = connection.prepareStatement(queryBuilder.toString());
                }else{
                    statement = connection.prepareStatement(queryBuilder.substring(0,queryBuilder.length()-6));
                }
            }
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Profile profile = new Profile();
//                profile.setFirstName(resultSet.getString(1));
//                profile.setLastName(resultSet.getString(2));
//                profile.setGender(resultSet.getString(3));
//                profile.setContactNumber(resultSet.getString(4));
//                profile.setEmailId(resultSet.getString(5));
//                profile.setAddress(resultSet.getString(6));
//                profile.setCity(resultSet.getString(7));
//                profile.setState(resultSet.getString(8));
//                profile.setPinNumber(resultSet.getString(9));
//                profile.setAadharCardNumber(resultSet.getString(10));
                
                profile.setFirstName(resultSet.getString(1));
                profile.setLastName(resultSet.getString(2));
                profile.setContactNumber(resultSet.getString(4));
                profile.setEmailId(resultSet.getString(5));
                profile.setAddress(resultSet.getString(6));
                profile.setAadharCardNumber(resultSet.getString(10));
                profile.setPanNumber(resultSet.getString(11));
                profile.setPhoneNumber(resultSet.getString(12));
                ArrayList<Document> documentList=new ArrayList<Document>();
                String[] filesName=resultSet.getString(13).split(",");
                for(String fileName:filesName){
                    Document document=new Document();
                    document.setFileName(fileName);
                    documentList.add(document);
                }
                profile.setDocumentList(documentList);
                clientDetails.add(profile);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
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
        return clientDetails;
    }
}
