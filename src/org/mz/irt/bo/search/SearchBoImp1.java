/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mz.irt.bo.search;

import java.util.ArrayList;
import org.mz.irt.dao.search.SearchDaoImp1;
import org.mz.irt.dao.search.SearchDao;
import org.mz.irt.model.Profile;

/**
 *
 * @author metazone
 */
public class SearchBoImp1 implements SearchBo{

    @Override
    public ArrayList<Profile> getClientList(String searchValue) {
        SearchDao searchDao=new SearchDaoImp1();
            return searchDao.getClientList(searchValue);
    }
    
    @Override
    public Profile getClientDetails(String aadharCardNo) {
        SearchDao searchDao=new SearchDaoImp1();
            return searchDao.getClientDetails(aadharCardNo);
    }
    
}
