/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mz.advisell.dao.profile;

import java.util.ArrayList;
import org.mz.advisell.model.Document;
import org.mz.advisell.model.Profile;

/**
 *
 * @author metazone
 */
public interface ProfileDao {
    int addProfile(Profile profile);
    int updateProfile(Profile profile,ArrayList<Document> deleteDocumentList);
    public int deleteProfile(String aadharCardNo);
    //int uploadDocument(Document document,String aadharNo);
}
