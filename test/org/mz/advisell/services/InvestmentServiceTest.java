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

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mz.advisell.bean.Investment;

/**
 *
 * @author parii
 */
public class InvestmentServiceTest {
    
    InvestmentService investmentService;
    Investment investment;
    
    @Before
    public void setup(){
        investmentService=new InvestmentService();
        investment=new Investment();
        investment.setAmount(1000);
        investment.setScheme("HCL");
    }
    
    /**
     * TestCase 1 of addInvestment method
     * Add Investment
     * Test of addInvestment method, of class InvestmentService.
     * Expected result 1
     * Actual result 1
     */
    @Test
    public void testAddInvestment() {
        assertEquals(1,investmentService.addInvestment(investment, "748789786485"));
        assertEquals(investment.getScheme(),investmentService.getInvestmentList("748789786485").get(0).getScheme());
    }
    
    /**
     * TestCase 2 of addInvestment method
     * Investment not added,if Aadhar number not existed in Profile
     * Test of addInvestment method, of class InvestmentService.
     * Expected result 0
     * Actual result 0
     */
    @Test
    public void testInvestmentNotAdded() {
        assertEquals(0,investmentService.addInvestment(investment, "754345645567"));
    }  

    /**
     * TestCase 1 of getInvestmentList method
     * Get Empty Investment list if client not invested
     * Test of getInvestmentList method, of class InvestmentService.
     * Expected result empty ArrayList
     * Actual result empty ArrayList,if client not invested otherwise test case fails
     */
    @Test
    public void testGetEmptyInvestmentList() {
        assertTrue(investmentService.getInvestmentList("748789786185").isEmpty());
    }
    
    
    /**
     * TestCase 2 of getInvestmentList method
     * Get Investment list 
     * Test of getInvestmentList method, of class InvestmentService.
     * Expected result ArrayList of Investment
     * Actual result ArrayList of Investment
     */
    @Test
    public void testGetInvestmentList() {
        assertFalse(investmentService.getInvestmentList("748789786485").isEmpty());
    }
    
    /**
     * TestCase 3 of getInvestmentList method
     * Get Empty Investment list whenever this aadhar number does not existed in Profile
     * Test of getInvestmentList method, of class InvestmentService.
     * Expected result empty ArrayList
     * Actual result empty ArrayList
     */
    @Test
    public void testGetEmptyInvstmntList() {
        assertTrue(investmentService.getInvestmentList("748789").isEmpty());
    }
    
}
