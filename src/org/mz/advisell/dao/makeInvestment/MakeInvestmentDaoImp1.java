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
package org.mz.advisell.dao.makeInvestment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.mz.advisell.dao.connection.DBConnection;

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
