/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mz.advisell.dao.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mz.advisell.dao.connection.DBConnection;
import org.mz.advisell.dao.search.SearchDaoImp1;

/**
 *
 * @author parii
 */
public class CompanyDaoImp1 implements CompanyDao{
    
    private Connection connection;
    
    @Override
    public int addCompanyName(String companyName) {
        DBConnection dbConnection = new DBConnection();
        PreparedStatement statement = null;
        int result = 0;
        try {
            connection = dbConnection.createConnection();
            statement = connection.prepareStatement("INSERT INTO company(company_name) VALUES(?);");
            statement.setString(1,companyName);
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
    public int updateCompanyName(String oldCompanyName,String updatedCompanyName) {
        PreparedStatement statement = null;
        DBConnection dbConnection = new DBConnection();
        int result=0;
        try {
            connection = dbConnection.createConnection();
            statement = connection.prepareStatement("UPDATE company SET company_name=? WHERE  company_name=?");
            statement.setString(1,updatedCompanyName);
            statement.setString(2,oldCompanyName);
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
    public int deleteCompanyName(String companyName) {
        PreparedStatement statement = null;
        DBConnection dbConnection = new DBConnection();
        int result=0;
        try {
            connection = dbConnection.createConnection();
            statement = connection.prepareStatement("DELETE FROM company WHERE company_name=?;");
            statement.setString(1,companyName);
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
    public ArrayList<String> getCompaniesName() {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<String> companyNameList=new ArrayList<String>();
        DBConnection dbConnection = new DBConnection();
        try {
            connection = dbConnection.createConnection();
            statement = connection.prepareStatement("SELECT * FROM company");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
               companyNameList.add(resultSet.getString(1));
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
        return companyNameList;
    }
}
