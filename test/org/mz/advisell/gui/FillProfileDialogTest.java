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
package org.mz.advisell.gui;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mz.advisell.bean.Profile;
import org.mz.advisell.services.ProfileService;

/**
 *
 * @author parii
 */
@RunWith(Parameterized.class)
public class FillProfileDialogTest {
    
    Profile profile;
    FillProfileDialog fillProfileDialog;
    String firstName;
    String lastName;
    String emailId;
    String phoneNumber;
    String mobileNumber;
    String address;
    String aadharCardNumber;
    String panNumber;
    
    public FillProfileDialogTest(String firstName, String lastName, String emailId, String phoneNumber, String mobileNumber, String address, String aadharCardNumber, String panNumber) {
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
    public void intilizeInstanceAndSetProfile() throws SQLException {
        fillProfileDialog=new FillProfileDialog(new AdvisellGUI(), true, profile);
        profile = new Profile();
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
        return Arrays.asList(new Object[][]{{"", "", "", "", "", "", "", ""},
        {"preeti125", "garg", "preeti.garg125@gmail.com@125", "", "9466749855", "Bukharpur,Blb,Fbd", "798789786785", "preet1255i"},
        {"preeti", "garg$%", "preeti.garg125@gmail.com", "", "946ad6749855", "Bukharpur,Blb,Fbd", "768456789786785", ""},
        {"preeti", "garg", "preeti.garg125@gmail.com.%gmail.com", "9211294005", "9466749855", "Bukharpur,Blb,Fbd", "748789786785", "preet1255i"},
        {"preeti", "garg", "preeti.garg125@gmail.com", "9211294005", "9466749855", "Bukharpur,Blb,Fbd", "748789786785", "preet1255i"}
        });
    }

    /**
     * Test of validateProfile method, of class FillProfileDialog.
     */
    @Test
    public void testValidProfile() {
        assertEquals(1,fillProfileDialog.validateProfile());
    }
    
    @Test
    public void testInvalidProfile() {
        assertEquals(0,fillProfileDialog.validateProfile());
    }
    
}
