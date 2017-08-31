/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mz.irt.bo.search;

import java.util.ArrayList;
import org.mz.irt.model.Profile;

/**
 *
 * @author metazone
 */
public interface SearchBo {
    ArrayList<Profile> getClientList(String searchvalue);
    Profile getClientDetails(String aadharCardNo);
}
