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
import org.mz.advisell.services.dao.DBConnection;
import org.mz.advisell.services.extra.Logging;

/**
 *
 * @author parii
 */
public class SchemeService {
    
    private Connection connection;
    
    public int addScheme(String scheme) {
        DBConnection dbConnection = new DBConnection();
        PreparedStatement statement = null;
        int result = 0;
        try {
            connection = dbConnection.createConnection();
            statement = connection.prepareStatement("INSERT INTO scheme(scheme_name) VALUES(?);");
            statement.setString(1,scheme);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            //Logging.showLogs(Logger.getLogger(this.getClass().getName()));
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                Logging.showLogs(Logger.getLogger(this.getClass().getName()));
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            }
            dbConnection.closeConnection();
        }
        return result;
    }

    public int updateScheme(String oldScheme,String newScheme) {
        PreparedStatement statement = null;
        DBConnection dbConnection = new DBConnection();
        int result=0;
        try {
            connection = dbConnection.createConnection();
            statement = connection.prepareStatement("UPDATE scheme SET scheme_name=? WHERE  scheme_name=?");
            statement.setString(1,newScheme);
            statement.setString(2,oldScheme);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            //Logging.showLogs(Logger.getLogger(this.getClass().getName()));
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                Logging.showLogs(Logger.getLogger(this.getClass().getName()));
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);

            }
            dbConnection.closeConnection();
        }
        return result;
    }
    
    public int deleteScheme(String scheme) {
        PreparedStatement statement = null;
        DBConnection dbConnection = new DBConnection();
        int result=0;
        try {
            connection = dbConnection.createConnection();
            statement = connection.prepareStatement("DELETE FROM scheme WHERE scheme_name=?;");
            statement.setString(1,scheme);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            Logging.showLogs(Logger.getLogger(this.getClass().getName()));
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                Logging.showLogs(Logger.getLogger(this.getClass().getName()));
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            }
            dbConnection.closeConnection();
        }
        return result;
    }
    
    public ArrayList<String> getSchemes() {
        ArrayList<String> schemes=new ArrayList<>();
        
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        DBConnection dbConnection = new DBConnection();
        try {
            connection = dbConnection.createConnection();
            statement = connection.prepareStatement("SELECT * FROM scheme");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
               schemes.add(resultSet.getString(1));
             }
        } catch (SQLException e) {
            Logging.showLogs(Logger.getLogger(this.getClass().getName()));
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
                Logging.showLogs(Logger.getLogger(this.getClass().getName()));
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            }
            dbConnection.closeConnection();
        }
        return schemes;
    }
}
