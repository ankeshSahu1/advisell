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

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author parii
 */
@RunWith(Parameterized.class)
public class SearchServiceTest {
    
    SearchService searchService;
    String searchValue;   
    public SearchServiceTest(String searchValue) {
        this.searchValue=searchValue;
    }
    
    @Before
    public void setup(){
        searchService=new SearchService();
    }
    
    @Parameterized.Parameters
    public static Collection<Object[]> input() {
        return Arrays.asList(new Object[][]{{""},{"9466749855"},{"preeti"},{"preetigarg"},{"748789786485"},{"pkjhj4567k"},
            {"0000"},{"12"},{"mo"},{"$%^"},{"754645654566"},{"8586874694"},{"priyanka"}});
    }
    
    /**
     * Test case 1 of getClientList method
     * Get Client List,if ProfilePreview existed in database
     * Test of getClientList method, of class SearchService.
     * Expected result not empty client list
     * Actual result if ProfilePreview existed in database than client list otherwise test case fails
     */
    @Test
    public void testGetClientList() {
        assertFalse(searchService.getClientList(searchValue).isEmpty());
    }
    
    /**
     * Test case 2 of getClientList method
     * Get Client List,if ProfilePreview not existed in database
     * Test of getClientList method, of class SearchService.
     * Expected result empty client list
     * Actual result if ProfilePreview not existed in database than empty client list otherwise test case fails
     */
    @Test
    public void testGetEmptyClientList() {
        assertTrue(searchService.getClientList(searchValue).isEmpty());
    }
    
}
