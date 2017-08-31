/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mz.irt.dao.search;

import java.util.ArrayList;
import org.mz.irt.model.Profile;

/**
 *
 * @author metazone
 */
public interface SearchDao {
    ArrayList<Profile> getClientList(String searchValue);
    Profile getClientDetails(String aadharCardNo);
}
