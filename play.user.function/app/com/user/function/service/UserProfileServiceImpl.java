package com.user.function.service;

import com.google.inject.Inject;
import com.user.function.dao.UserProfileDao;
import com.user.function.entities.UserProfile;
import play.Logger;

public class UserProfileServiceImpl implements UserProfileService {
    private final Logger.ALogger logger = Logger.of(this.getClass());

    @Inject
    private UserProfileDao userProfileDao;

    /**
     * Load User Profile.
     *
     * @param userId user id to query in DB
     * @return
     */
    @Override
    public UserProfile loadUserProfile(String userId) {
        logger.info("Loading UserProfile for {}", userId);
        UserProfile userProfile = this.userProfileDao.getUserProfileById(userId);
        if (userProfile == null) {
            return new UserProfile();
        }
        return userProfile;
    }
}
