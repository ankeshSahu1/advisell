/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mz.advisell.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author metazone
 */
public class DBConnection {
    private Connection connection;
	
    public Connection createConnection(){
		try{
                    Class.forName("com.mysql.jdbc.Driver");
                    connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/investmentrecord","root","root");
		}catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException ex) {
                    Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
		return connection;
	}
	
	public void closeConnection(){
		try{
			if(connection!=null){
				connection.close();
			}
		}catch(SQLException e){
				e.printStackTrace();
			}
		}
}
