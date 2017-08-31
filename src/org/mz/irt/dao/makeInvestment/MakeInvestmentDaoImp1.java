/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mz.irt.dao.makeInvestment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.mz.irt.dao.connection.DBConnection;

/**
 *
 * @author metazone
 */
public class MakeInvestmentDaoImp1 implements MakeInvestmentDao{

    @Override
    public int addInvestment(String companyName, String investment, String aadharNumber) {
     DBConnection dbConnection = new DBConnection();
	Connection conn=null;
	PreparedStatement statement=null;
        int result = 0;
	try{
            Connection connection = dbConnection.createConnection();
            statement=connection.prepareStatement("INSERT INTO investment(aadhar,company_name,investment)"
					+ " VALUES(?,?,?);");
            statement.setString(1,aadharNumber);
            statement.setString(2,companyName);
            statement.setString(3,investment);
            result=statement.executeUpdate();
	}catch(SQLException e){	
            e.printStackTrace();	
	}finally{
            try {
                if(statement!=null){
                    statement.close();
		}
                if(conn!=null){
                    conn.close();
		}
            }catch (SQLException e) {
		e.printStackTrace();
            }
	}
	return result;   
    }
    
}
