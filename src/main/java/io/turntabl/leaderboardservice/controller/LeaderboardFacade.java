package io.turntabl.leaderboardservice.controller;

import io.turntabl.leaderboardservice.client.response.AddUser;
import io.turntabl.leaderboardservice.controller.response.ProfileDto;
import io.turntabl.leaderboardservice.converter.ProfileToProfileDtoConverter;
import io.turntabl.leaderboardservice.model.Profile;
import io.turntabl.leaderboardservice.service.LeaderboardRepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@Component
public class LeaderboardFacade {

    private final LeaderboardRepositoryService leaderboardRepositoryService;
    private final ProfileToProfileDtoConverter profileToProfileDtoConverter;

    public List<ProfileDto> getLeaderboard() {
        return leaderboardRepositoryService.getProfiles().stream()
                .map(profileToProfileDtoConverter::convert)
                .collect(toList());
    }

//    public int countUsers() {
//        return 0;
//    }
    public List<ProfileDto> getOrderByHonor(){
        return  leaderboardRepositoryService.getProfiles().stream()
                .map(profileToProfileDtoConverter::convert)
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingInt(ProfileDto::getHonour).reversed())
                .collect(toList());
    }

    public List<ProfileDto> getOrderByOverall(){
        return  leaderboardRepositoryService.getProfiles().stream()
                .map(profileToProfileDtoConverter::convert)
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingInt(ProfileDto::getOverallRank).reversed())
                .collect(toList());
    }

    public String createUser(AddUser addUser){
        return leaderboardRepositoryService.addUser(addUser);
    }

    public List<ProfileDto> getUsersByCommonLanguage(String language) {
        return leaderboardRepositoryService.getProfiles().stream()
                .filter(x->x.getLanguageLevels().stream().anyMatch(y->y.getName().equals(language)))
                .sorted(Comparator.comparingInt(Profile::getHonour).reversed())
                .map(profileToProfileDtoConverter::convert)
                .collect(toList());

    }
}
