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
