/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mz.advisell.bo.profile;

import java.util.ArrayList;
import org.mz.advisell.model.Profile;
import org.mz.advisell.dao.profile.ProfileDao;
import org.mz.advisell.dao.profile.ProfileDaoImp1;
import org.mz.advisell.model.Document;

/**
 *
 * @author metazone
 */
public class ProfileBoImp1 implements ProfileBo{

    @Override
    public int createProfile(Profile profile) {
      ProfileDao profileDao=new ProfileDaoImp1();
      return profileDao.addProfile(profile);  
    }

    @Override
    public int updateProfile(Profile profile,ArrayList<Document> deleteDocumentlist) {
      ProfileDao profileDao=new ProfileDaoImp1();
      return profileDao.updateProfile(profile,deleteDocumentlist);    
    }
    
    @Override
    public int deleteProfile(String aadharCardNo) {
      ProfileDao profileDao=new ProfileDaoImp1();
      return profileDao.deleteProfile(aadharCardNo);    
    }
}
