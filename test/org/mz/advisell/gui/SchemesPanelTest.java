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

import java.util.Arrays;
import java.util.Collection;
import javax.swing.JTextField;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mz.advisell.services.SchemeService;
import org.mz.advisell.services.extra.TestUtils;

/**
 *
 * @author parii
 */
@RunWith(Parameterized.class)
public class SchemesPanelTest {
    
    SchemesPanel schemesPanel;
    String scheme;
    JTextField schemeTextField;
    
    public SchemesPanelTest(String scheme) {
        this.scheme=scheme;
    }
    
    @Before
    public void setup(){
        schemesPanel=new SchemesPanel(new SchemeService().getSchemes());
        schemeTextField=(JTextField)TestUtils.getChildNamed(schemesPanel,"scheme");
        schemeTextField.setText(scheme);
    }
    
    @Parameterized.Parameters
    public static Collection<Object[]> input() {
        return Arrays.asList(new Object[][]{{""},{"    "},{"null"},{"%$#"},{"fgd$%"},{"567^&"},{"as45#d4"}});
    }
    
    /**
     * Test of validateSchemes method, of class SchemesPanel.
     * Expected result 0
     * Actual result 0
     */
    @Test
    public void testInvalidSchemes() {
        assertEquals(0,schemesPanel.validateSchemes());
    }
    
    
    /**
     * Test of validateSchemes method, of class SchemesPanel.
     * Expected result 1
     * Actual result 1
     */
    @Test
    public void testValidSchemes() {
        schemeTextField.setText("abc34");
        assertEquals(1,schemesPanel.validateSchemes());
    }
    
}
