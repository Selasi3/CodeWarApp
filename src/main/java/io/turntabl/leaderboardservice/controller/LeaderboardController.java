package io.turntabl.leaderboardservice.controller;

import io.turntabl.leaderboardservice.controller.response.ProfileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/leaderboard")
@CrossOrigin(origins = "http://localhost:4200")
public class LeaderboardController {

    private final LeaderboardFacade leaderboardFacade;

    @GetMapping
    public List<ProfileDto> getLeaderboard() {
        return leaderboardFacade.getLeaderboard();
    }

//    @GetMapping("/countUsers")
//    public int countUsers(){
//        return leaderboardFacade.countUsers();
//    }

    @GetMapping("/orderByHonor")
    public List<ProfileDto> getOrderByHonor(){
        return leaderboardFacade.getOrderByHonor();
    }

    @GetMapping("/orderByOverall")
    public List<ProfileDto> getOrderByOverall(){
        return leaderboardFacade.getOrderByOverall();
    }
}
