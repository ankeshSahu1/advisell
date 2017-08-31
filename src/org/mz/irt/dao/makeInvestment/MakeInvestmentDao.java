/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mz.irt.dao.makeInvestment;

/**
 *
 * @author metazone
 */
public interface MakeInvestmentDao {
    int addInvestment(String companyName,String investment,String aadharNumber);
}
