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

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mz.advisell.bean.Profile;

/**
 *
 * @author parii
 */
@RunWith(Parameterized.class)
public class ProfileServiceTest {

    Profile profile;
    ProfileService profileService;
    String firstName;
    String lastName;
    String emailId;
    String phoneNumber;
    String mobileNumber;
    String address;
    String aadharCardNumber;
    String panNumber;
    
    public ProfileServiceTest(String firstName, String lastName, String emailId, String phoneNumber, String mobileNumber, String address, String aadharCardNumber, String panNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.aadharCardNumber = aadharCardNumber;
        this.panNumber = panNumber;
    }

    @Before
    public void intilizeInstanceAndSetProfile(){
        profile = new Profile();
        profileService = new ProfileService();
        profile.setFirstName(firstName);
        profile.setLastName(lastName);
        profile.setMobileNumber(mobileNumber);
        profile.setPhoneNumber(phoneNumber);
        profile.setEmailId(emailId);
        profile.setAddress(address);
        profile.setAadharCardNumber(aadharCardNumber);
        profile.setPanNumber(panNumber);
    }
    
    @Parameterized.Parameters
    public static Collection<Object[]> input() {
        return Arrays.asList(new Object[][]{{"preeti", "garg", "preeti.garg125@gmail.com", "9211294005", "9466749855", "Bukharpur,Blb,Fbd", "788789786785", ""},
        {"preeti", "garg", "preeti.garg125@gmail.com", "", "9466749855", "Bukharpur,Blb,Fbd", "798789786785", "preet1255i"},
        {"preeti", "garg", "preeti.garg125@gmail.com", "", "9466749855", "Bukharpur,Blb,Fbd", "768789786785", ""},
        {"preeti", "garg", "preeti.garg125@gmail.com", "9211294005", "9466749855", "Bukharpur,Blb,Fbd", "748789786785", "preet1255i"}});
    }

    /**
     * TestCase 1 of addProfile method 
     * New Profile created 
     * Test of addProfile method, of class ProfileService. 
     * Expected result 1 
     * Actual result 1
     */
    @Test
    public void testAddProfile() {
        assertEquals(1, profileService.addProfile(profile));
        assertEquals(aadharCardNumber, profileService.getClientDetails(aadharCardNumber).getAadharCardNumber());
    }

    /**
     * TestCase 2 of addProfile method 
     * Profile already exists 
     * Test of addProfile method, of class ProfileService. 
     * Expected result throw MySQLIntegrityConstraintViolationException
     * Actual result throw MySQLIntegrityConstraintViolationException
     */
    @Test(expected=MySQLIntegrityConstraintViolationException.class)
    public void testAddExistedProfile() {
        profileService.addProfile(profileService.getClientDetails("735765456765"));
    }

    /**
     * TestCase 1 of updateProfile method 
     * Update Existed Profile 
     * Test of updateProfile method, of class ProfileService. 
     * Expected result 1 
     * Actual result 1
     */
    @Test
    public void testUpdateExistedProfile() {
        assertEquals(1, profileService.updateProfile(profile));
        assertEquals(aadharCardNumber, profileService.getClientDetails(aadharCardNumber).getAadharCardNumber());
    }

    /**
     * TestCase 2 of updateProfile method 
     * Update Profile but Profile not existed
     * Test of updateProfile method, of class ProfileService. 
     * Expected result 0
     * Actual result 0
     */
    @Test
    public void testUpdateNotExistedProfile() {
        assertEquals(0, profileService.updateProfile(new Profile()));
    }

    /**
     * TestCase 1 of getClientDetails method 
     * Get Profile but Profile not existed
     * Test of getClientDetails method, of class ProfileService. 
     * Expected result null 
     * Actual result return instance of Profile
     */
    @Test
    public void testGetNotExistedProfile() {
        assertEquals(null, profileService.getClientDetails("757658456765"));
    }

    /**
     * TestCase 2 of getClientDetails method 
     * Get Profile 
     * Test of getClientDetails method, of class ProfileService. 
     * Expected result getClientDetails method do not return null 
     * Actual result return instance of class Profile
     */
    @Test
    public void testGetProfile() {
        assertNotEquals(null, profileService.getClientDetails("748789786485"));
        assertEquals("748789786485",profileService.getClientDetails("748789786485").getAadharCardNumber());
    }
    
     /**
     * TestCase 1 of deleteProfile method
     * Delete Profile if Profile is existed 
     * Test of deleteProfile method, of class ProfileService. 
     * Expected result 1
     * Actual result 1
     */
    @Test
    public void testDeleteExistedProfile() {
        assertEquals(1, profileService.deleteProfile(aadharCardNumber));
        assertEquals(null,profileService.getClientDetails(aadharCardNumber));
    }
    
     /**
     * TestCase 2 of deleteProfile method
     * Delete Profile if Profile is not existed
     * Test of deleteProfile method, of class ProfileService. 
     * Expected result 0
     * Actual result 0
     */
    @Test
    public void testDeleteNotExistedProfile() {
        assertEquals(0, profileService.deleteProfile(new Profile().getAadharCardNumber()));
    }

}
