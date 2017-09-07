/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mz.advisell.bo.company;

import java.util.ArrayList;
import org.mz.advisell.dao.company.CompanyDao;
import org.mz.advisell.dao.company.CompanyDaoImp1;
/**
 *
 * @author parii
 */
public class CompanyBoImp1 implements CompanyBo{

    @Override
    public int addCompanyName(String companyName) {
        CompanyDao companyDao=new CompanyDaoImp1();
        return companyDao.addCompanyName(companyName);
    }

    @Override
    public int updateCompanyName(String oldCompanyName,String updatedCompanyName) {
        CompanyDao companyDao=new CompanyDaoImp1();
        return companyDao.updateCompanyName(oldCompanyName,updatedCompanyName);
    }
    
    @Override
    public int deleteCompanyName(String companyName) {
        CompanyDao companyDao=new CompanyDaoImp1();
        return companyDao.deleteCompanyName(companyName);
    }
    
    @Override
    public ArrayList<String> getCompaniesName() {
        CompanyDao companyDao=new CompanyDaoImp1();
        return companyDao.getCompaniesName();
    }
    
}
