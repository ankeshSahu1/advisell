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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mz.advisell.bean.Profile;
import org.mz.advisell.services.extra.TestUtils;

/**
 *
 * @author parii
 */
@RunWith(Parameterized.class)
public class FillProfileDialogValidTest {

    FillProfileDialog fillProfileDialog;
    String firstName;
    String lastName;
    String emailId;
    String phoneNumber;
    String mobileNumber;
    String address;
    String aadharCardNumber;
    String panNumber;

    public FillProfileDialogValidTest(String firstName, String lastName, String emailId, String phoneNumber, String mobileNumber, String address, String aadharCardNumber, String panNumber) {
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
        fillProfileDialog = new FillProfileDialog(new AdvisellGUI(), true, new Profile());
        ((JTextField) TestUtils.getChildNamed(fillProfileDialog, "firstName")).setText(firstName);
        ((JTextField) TestUtils.getChildNamed(fillProfileDialog, "lastName")).setText(lastName);
        ((JTextField) TestUtils.getChildNamed(fillProfileDialog, "mobileNumber")).setText(mobileNumber);
        ((JTextField) TestUtils.getChildNamed(fillProfileDialog, "phoneNumber")).setText(phoneNumber);
        ((JTextField) TestUtils.getChildNamed(fillProfileDialog, "email")).setText(emailId);
        ((JTextArea) TestUtils.getChildNamed(fillProfileDialog, "address")).setText(address);
        ((JTextField) TestUtils.getChildNamed(fillProfileDialog, "aadhar")).setText(aadharCardNumber);
        ((JTextField) TestUtils.getChildNamed(fillProfileDialog, "panNumber")).setText(panNumber);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> input() {
        return Arrays.asList(new Object[][]{{"preeti", "garg", "preeti*23@gmail.com", "7530946836", "9466749855", "Bukharpur,Blb,Fbd", "768456789786", "preet1255i"},
        {"preeti", "garg", "preeti#23@gmail.com", "7530946836", "9466749855", "Bukharpur,Blb,Fbd", "768456789786", "preet1255i"},
        {"preeti", "garg", "preeti_23@gmail.com", "7530946836", "9466749855", "Bukharpur,Blb,Fbd", "768456789786", "preet1255i"},
        {"preeti", "garg", "preeti23@gmail.com.op", "7530946836", "9466749855", "Bukharpur,Blb,Fbd", "768456789786", "preet1255i"},
        {"preeti", "garg", "preeti23@gmail.com.in.op", "7530946836", "9466749855", "Bukharpur,Blb,Fbd", "768456789786", "preet1255i"},
        {"preeti", "garg", "preeti23@gmail.com", "7530946836", "9466749855", "Bukharpur,Blb,Fbd", "768456789786", "preet1255i"},});
    }

    /**
     * Test of validateProfile method, of class FillProfileDialog. 
     * Expected result 1 
     * Actual result 1
     */
    @Test
    public void testValidProfile() {
        assertEquals(1, fillProfileDialog.validateProfile());
    }
}
