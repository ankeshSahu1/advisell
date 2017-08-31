/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mz.irt.dao.profile;

import org.mz.irt.model.Document;
import org.mz.irt.model.Profile;

/**
 *
 * @author metazone
 */
public interface ProfileDao {
    int addProfile(Profile profile);
    int updateProfile(Profile profile);
    public int deleteProfile(String aadharCardNo);
    //int uploadDocument(Document document,String aadharNo);
}
