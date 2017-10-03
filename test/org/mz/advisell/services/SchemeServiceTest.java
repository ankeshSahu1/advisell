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

/**
 *
 * @author parii
 */
public class SchemeServiceTest {
    
    SchemeService schemeService;
    
    @Before
    public void setup(){
        schemeService=new SchemeService();
    }

    /**
     * Test case 1 of addScheme method
     * Add Scheme
     * Test of addScheme method, of class SchemeService.
     * Expected result 1
     * Actual result 1
     */
    @Test
    public void testAddScheme() {
        if(!schemeService.getSchemes().contains("HCL")){
            assertEquals(1,schemeService.addScheme("HCL"));
        }
        assertTrue(schemeService.getSchemes().contains("HCL"));
    }
    
    /**
     * Test case 2 of addScheme method
     * Add existed Scheme
     * Test of addScheme method, of class SchemeService.
     * Expected result 0
     * Actual result 1
     */
    @Test
    public void testADDExistedScheme() {
        if(schemeService.getSchemes().contains("HCL")){
            assertEquals(0,schemeService.addScheme("HCL"));
        }
    }

    /**
     * TestCase 1 of updateScheme method
     * Update Scheme 
     * Test of updateScheme method, of class SchemeService.
     * Expected result 1
     * Actual result 0
     */
    @Test
    public void testUpdateScheme() {
        if(schemeService.getSchemes().contains("HC")){
            assertEquals(1,schemeService.updateScheme("HC", "HL"));
            assertTrue(schemeService.getSchemes().contains("HL"));
        }
    }
    
    /**
     * TestCase 2 of updateScheme method
     * Update Scheme but updated Scheme already exists
     * Test of updateScheme method, of class SchemeService.
     * Expected result 0
     * Actual result 
     */
    @Test
    public void testUpdateSchemeExisted() {
        if(schemeService.getSchemes().contains("HP")){
            assertEquals(0,schemeService.updateScheme("DELL", "HP"));
        }
    }

    /**
     * TestCase 1 of deleteScheme method
     * Delete Scheme
     * Test of deleteScheme method, of class SchemeService.
     * Expected result 1
     * Actual result 1
     */
    @Test
    public void testDeleteExistedScheme() {
        if(schemeService.getSchemes().contains("HCL")){
            assertEquals(1,schemeService.deleteScheme("HCL"));
            assertFalse(schemeService.getSchemes().contains("HCL"));
        }
    }
    
    /**
     * TestCase 2 of deleteScheme method
     * Delete Scheme but this scheme not existed
     * Test of deleteScheme method, of class SchemeService.
     * Expected result 0
     * Actual result 0
     */
    @Test
    public void testDeleteNotExistedScheme() {
        if(!schemeService.getSchemes().contains("Honda")){
            assertEquals(0,schemeService.deleteScheme("Honda"));
        }
    }

    /**
     * TestCase 1 of getSchemes method
     * Get Schemes
     * Test of getSchemes method, of class SchemeService.
     * Expected result ArrayList which is not empty
     * Actual result ArrayList which is not empty
     */
    @Test
    public void testGetSchemes() {
        schemeService.addScheme("HCL");
        assertFalse(schemeService.getSchemes().isEmpty());
    }
    
    /**
     * TestCase 2 of getSchemes method
     * Get Schemes but no scheme have in database
     * Test of getSchemes method, of class SchemeService.
     * Expected result empty ArrayList
     * Actual result if schemes not have in database than empty ArrayList otherwise test case fails
     */
    @Test
    public void testGetEmptySchemesList() {
        schemeService.getSchemes().forEach((scheme) -> {
            schemeService.deleteScheme(scheme);
        });
        assertTrue(schemeService.getSchemes().isEmpty());
    }
    
}
