package com.awsexample.awsimageupload.datastore;

import com.awsexample.awsimageupload.profile.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeUserProfileDataStore {
    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();
    static {
        USER_PROFILES.add(new UserProfile(UUID.fromString("c6594582-23b1-4624-a07c-502c267b339a"), "janetjones", "pexels-pixabay-415829.jpg-8d6f6048-e7fc-48dd-9c95-f970e9c59297"));
        USER_PROFILES.add(new UserProfile(UUID.fromString("ad3309d8-e960-49e4-821b-3a72fcc95d4b"), "antoniojunior", "pexels-pixabay-220453.jpg-89f75d96-da37-4f44-8ef9-44af1b45d083"));

    }
    public List<UserProfile> getUserProfiles(){
        return USER_PROFILES;
    }
}
