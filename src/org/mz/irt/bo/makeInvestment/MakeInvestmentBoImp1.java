/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mz.irt.bo.makeInvestment;

import org.mz.irt.dao.makeInvestment.MakeInvestmentDao;
import org.mz.irt.dao.makeInvestment.MakeInvestmentDaoImp1;

/**
 *
 * @author metazone
 */
public class MakeInvestmentBoImp1 implements MakeInvestmentBo{

    @Override
    public int addInvestment(String companyName, String investment, String aadharNumber) {
        MakeInvestmentDao makeInvestmentDao=new MakeInvestmentDaoImp1();
        return  makeInvestmentDao.addInvestment(companyName,investment,aadharNumber);
    }
    
}
