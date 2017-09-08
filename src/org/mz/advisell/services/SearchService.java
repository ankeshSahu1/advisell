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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mz.advisell.constant.Constant;
import org.mz.advisell.bean.Document;
import org.mz.advisell.bean.Profile;
import org.mz.advisell.bean.ProfilePreview;
import org.mz.advisell.services.dao.DBConnection;

/**
 *
 * @author metazone
 */
public class SearchService {

    private Connection connection;

    public ArrayList<ProfilePreview> getClientList(String searchValue) {
        ArrayList<ProfilePreview> clientDetails = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        DBConnection dbConnection = new DBConnection();
        String query = "SELECT first_name,last_name,contact,aadhar, FROM profile WHERE";
        StringBuilder queryBuilder = new StringBuilder(query);
        try {
            connection = dbConnection.createConnection();
            if (searchValue != null && !searchValue.isEmpty()) {
                queryBuilder.append(Constant.QUERY_AADHAR);
                queryBuilder.append(Constant.QUERY_LIKE);
                queryBuilder.append("'%").append(searchValue).append("%'");
                queryBuilder.append(Constant.QUERY_OR);
                queryBuilder.append(Constant.QUERY_PAN_NUMBER);
                queryBuilder.append(Constant.QUERY_LIKE);
                queryBuilder.append("'%").append(searchValue).append("%'");
                queryBuilder.append(Constant.QUERY_OR);
                queryBuilder.append(Constant.QUERY_NUMBER);
                queryBuilder.append(Constant.QUERY_LIKE);
                queryBuilder.append("'%").append(searchValue).append("%'");
                queryBuilder.append(Constant.QUERY_OR);
                queryBuilder.append(Constant.QUERY_CONCAT + ('(' + Constant.QUERY_FIRST_NAME + ',' + "''" + ',' + Constant.QUERY_LAST_NAME + ')'));
                queryBuilder.append(Constant.QUERY_LIKE);
                queryBuilder.append("'%").append(searchValue).append("%'");
                statement = connection.prepareStatement(queryBuilder.toString());
            }else{
                statement = connection.prepareStatement(queryBuilder.substring(0,queryBuilder.length()-6));
            }
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ProfilePreview profilePreview = new ProfilePreview();
                profilePreview.setFirstName(resultSet.getString(1));
                profilePreview.setLastName(resultSet.getString(2));
                profilePreview.setContactNumber(resultSet.getString(4));
                profilePreview.setAadharCardNumber(resultSet.getString(10));
                clientDetails.add(profilePreview);
            }
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
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
        return clientDetails;
    }
}
