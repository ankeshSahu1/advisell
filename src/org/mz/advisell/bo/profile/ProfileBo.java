/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mz.advisell.bo.profile;

import java.util.ArrayList;
import org.mz.advisell.model.Document;
import org.mz.advisell.model.Profile;

/**
 *
 * @author metazone
 */
public interface ProfileBo {
    int createProfile(Profile profile);
    int updateProfile(Profile profile,ArrayList<Document> deleteDocumentList);

    public int deleteProfile(String aadharCardNumber);
}
