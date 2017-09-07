/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mz.advisell.dao.company;

import java.util.ArrayList;

/**
 *
 * @author parii
 */
public interface CompanyDao {
    int addCompanyName(String companyName);
    int updateCompanyName(String oldCompanyName,String updatedCompanyName);
    int deleteCompanyName(String companyName);
    ArrayList<String> getCompaniesName();
}
