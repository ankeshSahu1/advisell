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
public class FillProfileDialogTest {

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
        return Arrays.asList(new Object[][]{{"", "garg", "preeti.garg125@gmail.com", "7530946836", "9466749855", "2-sec,fbd", "798789786785", "preet1255i"},
        {"pre%eti", "garg", "preeti.garg125@gmail.com", "7530946836", "9466749855", "2-sec,fbd", "798789786785", "preet1255i"},
        {"      ", "garg", "preeti.garg125@gmail.com", "7530946836", "9466749855", "2-sec,fbd", "798789786785", "preet1255i"},
        {"preeti125", "garg", "preeti.garg125@gmail.com", "7530946836", "9466749855", "2-sec,fbd", "798789786785", "preet1255i"},
        {"null", "garg", "preeti.garg125@gmail.com", "7530946836", "9466749855", "2-sec,fbd", "798789786785", "preet1255i"},
        {"preeti", "", "preeti.garg125@gmail.com", "7530946836", "9466749855", "2-sec,fbd", "798789786785", "preet1255i"},
        {"preeti", "ga*rg", "preeti.garg125@gmail.com", "7530946836", "9466749855", "2-sec,fbd", "798789786785", "preet1255i"},
        {"preeti", "    ", "preeti.garg125@gmail.com", "7530946836", "9466749855", "2-sec,fbd", "798789786785", "preet1255i"},
        {"preeti", "garg67", "preeti.garg125@gmail.com", "7530946836", "9466749855", "2-sec,fbd", "798789786785", "preet1255i"},
        {"preeti", "null", "preeti.garg125@gmail.com", "7530946836", "9466749855", "2-sec,fbd", "798789786785", "preet1255i"},
        {"preeti", "garg", "preeti.garg125@gmail.com@125", "7530946836", "9466749855", "Bukharpur,Blb,Fbd", "798789786785", "preet1255i"},
        {"preeti", "garg", "preeti*23@gmail.com", "7530946836", "9466749855", "Bukharpur,Blb,Fbd", "768456789786", "preet1255i"},
        {"preeti", "garg", "preeti#23@gmail.com", "7530946836", "9466749855", "Bukharpur,Blb,Fbd", "768456789786", "preet1255i"},
        {"preeti", "garg", "preeti_23@gmail.com", "7530946836", "9466749855", "Bukharpur,Blb,Fbd", "768456789786", "preet1255i"},
        {"preeti", "garg", "preeti23@gmail.com.op", "7530946836", "9466749855", "Bukharpur,Blb,Fbd", "768456789786", "preet1255i"},
        {"preeti", "garg", "preeti23@gmail@gmail.com", "7530946836", "9466749855", "Bukharpur,Blb,Fbd", "768456789786", "preet1255i"},
        {"preeti", "garg", "preeti.garg125@gmail.com.%gmail.com", "9211294005", "9466749855", "Bukharpur,Blb,Fbd", "748789786785", "preet1255i"},
        {"preeti", "garg", "preeti23@gmail.com.in.op", "7530946836", "9466749855", "Bukharpur,Blb,Fbd", "768456789786", "preet1255i"},
        {"preeti", "garg", "preeti23@gmail.com", "7530946836", "9466749855", "Bukharpur,Blb,Fbd", "768456789786", "preet1255i"},
        {"preeti", "garg", "pree@#ti.garg125_@gmail.com", "9211294005", "9466749855", "Bukharpur,Blb,Fbd", "748789786785", "preet1255i"},
        {"preeti", "garg", "null23@gmail.com", "9211294005", "9466749855", "Bukharpur,Blb,Fbd", "748789786785", "preet1255i"},
        {"preeti", "garg", "", "9211294005", "9466749855", "Bukharpur,Blb,Fbd", "748789786785", "preet1255i"},
        {"preeti", "garg", "   ", "9211294005", "9466749855", "Bukharpur,Blb,Fbd", "748789786785", "preet1255i"},
        {"preeti", "garg", "preeti23@gmail.com", "9466a67834", "9466749855", "Bukharpur,Blb,Fbd", "748789786785", "preet1255i"},
        {"preeti", "garg", "preeti23@gmail.com", "1266867834", "9466749855", "Bukharpur,Blb,Fbd", "748789786785", "preet1255i"},
        {"preeti", "garg", "preeti23@gmail.com", "9466", "9466749855", "Bukharpur,Blb,Fbd", "748789786785", "preet1255i"},
        {"preeti", "garg", "preeti23@gmail.com", "946667834098", "9466749855", "Bukharpur,Blb,Fbd", "748789786785", "preet1255i"},
        {"preeti", "garg", "preeti23@gmail.com", "9466&67834", "9466749855", "Bukharpur,Blb,Fbd", "748789786785", "preet1255i"},
        {"preeti", "garg", "preeti23@gmail.com", "9466a%67834", "9466749855", "Bukharpur,Blb,Fbd", "748789786785", "preet1255i"},
        {"preeti", "garg", "preeti23@gmail.com", "9466678346", "", "Bukharpur,Blb,Fbd", "748789786785", "preet1255i"},
        {"preeti", "garg", "preeti23@gmail.com", "9466678346", "946674985n", "Bukharpur,Blb,Fbd", "748789786785", "preet1255i"},
        {"preeti", "garg", "preeti23@gmail.com", "9466678345", "946674985534", "Bukharpur,Blb,Fbd", "748789786785", "preet1255i"},
        {"preeti", "garg", "preeti23@gmail.com", "9466678345", "946674955", "Bukharpur,Blb,Fbd", "748789786785", "preet1255i"},
        {"preeti", "garg", "preeti23@gmail.com", "9466678345", "94667^9855", "Bukharpur,Blb,Fbd", "748789786785", "preet1255i"},
        {"preeti", "garg", "preeti23@gmail.com", "9466678345", "946g&98550", "Bukharpur,Blb,Fbd", "748789786785", "preet1255i"},
        {"preeti", "garg", "preeti23@gmail.com", "9466678345", "1234567897", "Bukharpur,Blb,Fbd", "748789786785", "preet1255i"},
        {"preeti", "garg", "preeti23@gmail.com", "9466678345", "9466749855", "", "748789786785", "preet1255i"},
        {"preeti", "garg", "preeti23@gmail.com", "9466678345", "9466749855", "     ", "748789786785", "preet1255i"},
        {"preeti", "garg", "preeti23@gmail.com", "9466678345", "9466749855", "null", "748789786785", "preet1255i"},
        {"preeti", "garg", "preeti23@gmail.com", "9466678345", "9466749855", "Bukharpur,Blb,Fbd", "74878978678", "preet1255i"},
        {"preeti", "garg", "preeti23@gmail.com", "9466678345", "9466749855", "Bukharpur,Blb,Fbd", "74878978678567", "preet1255i"},
        {"preeti", "garg", "preeti23@gmail.com", "9466678345", "9466749855", "Bukharpur,Blb,Fbd", "184878978678", "preet1255i"},
        {"preeti", "garg", "preeti23@gmail.com", "9466678345", "9466749855", "Bukharpur,Blb,Fbd", "74878uj97867", "preet1255i"},
        {"preeti", "garg", "preeti23@gmail.com", "9466678345", "9466749855", "Bukharpur,Blb,Fbd", "7487%8978678", "preet1255i"},
        {"preeti", "garg", "preeti23@gmail.com", "9466678345", "9466749855", "Bukharpur,Blb,Fbd", "74g#8978678", "preet1255i"},
        {"preeti", "garg", "preeti23@gmail.com", "9466678345", "9466749855", "Bukharpur,Blb,Fbd", "fdtgfvhygfgh", "preet1255i"},
        {"preeti", "garg", "preeti23@gmail.com", "9466678345", "9466749855", "Bukharpur,Blb,Fbd", "@#$%^&*", "preet1255i"},
        {"preeti", "garg", "preeti23@gmail.com", "9466678345", "9466749855", "Bukharpur,Blb,Fbd", "748789786784", "12pre1255i"},
        {"preeti", "garg", "preeti23@gmail.com", "9466678345", "9466749855", "Bukharpur,Blb,Fbd", "748789786784", "preet1255"},
        {"preeti", "garg", "preeti23@gmail.com", "9466678345", "9466749855", "Bukharpur,Blb,Fbd", "748789786784", "reet1255i"},
        {"preeti", "garg", "preeti23@gmail.com", "9466678345", "9466749855", "Bukharpur,Blb,Fbd", "748789786784", "preet1pt5i"},
        {"preeti", "garg", "preeti23@gmail.com", "9466678345", "9466749855", "Bukharpur,Blb,Fbd", "748789786784", "preet55iko"},
        {"preeti", "garg", "preeti23@gmail.com", "9466678345", "9466749855", "Bukharpur,Blb,Fbd", "748789786784", "null"},
        {"preeti", "garg", "preeti23@gmail.com", "9466678345", "9466749855", "Bukharpur,Blb,Fbd", "748789786784", "preet1255itr5"}

        });
    }

//    /**
//     * Test of validateProfile method, of class FillProfileDialog.
//     */
//    @Test
//    public void testValidProfile() {
//        assertEquals(1,fillProfileDialog.validateProfile());
//    }
    
    /**
     * Test of validateProfile method, of class FillProfileDialog. 
     * Expected result 0 
     * Actual result 0
     */
    @Test
    public void testInvalidProfile() {
        assertEquals(0, fillProfileDialog.validateProfile());
    }

}
