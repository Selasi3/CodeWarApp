package io.turntabl.leaderboardservice.service;

import io.turntabl.leaderboardservice.client.response.AddUser;
import io.turntabl.leaderboardservice.model.Profile;
import io.turntabl.leaderboardservice.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LeaderboardRepositoryService {

    private final ProfileRepository profileRepository;

    public List<Profile> getProfiles() {
        return profileRepository.findAll();
    }

    public String addUser(AddUser addUser) {
        Profile profile = new Profile();
        profile.setId(addUser.getUsername());
        profileRepository.save(profile);

        return addUser.getUsername() + " saved";

    }
}
