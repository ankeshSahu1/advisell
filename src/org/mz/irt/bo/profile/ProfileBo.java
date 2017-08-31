/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mz.irt.bo.profile;

import org.mz.irt.model.Profile;

/**
 *
 * @author metazone
 */
public interface ProfileBo {
    int createProfile(Profile profile);
    int updateProfile(Profile profile);

    public int deleteProfile(String aadharCardNumber);
}
