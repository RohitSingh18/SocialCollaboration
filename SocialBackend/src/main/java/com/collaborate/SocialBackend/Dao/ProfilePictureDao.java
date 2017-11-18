package com.collaborate.SocialBackend.Dao;

import com.collaborate.SocialBackend.model.ProfilePicture;

public interface ProfilePictureDao {
	void uploadpic(ProfilePicture profilepic);
	ProfilePicture getProfilePic(String username);

}

		