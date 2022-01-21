package io.turntabl.leaderboardservice.controller;

import io.turntabl.leaderboardservice.client.response.AddUser;
import io.turntabl.leaderboardservice.controller.response.ProfileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/save")
    public String addUser(@RequestBody AddUser addUser){
        leaderboardFacade.createUser(addUser);

        return addUser.getUsername() + " created";
    }


    @GetMapping("/orderByHonor")
    public List<ProfileDto> getOrderByHonor(){
        return leaderboardFacade.getOrderByHonor();
    }

    @GetMapping("/orderByOverall")
    public List<ProfileDto> getOrderByOverall(){
        return leaderboardFacade.getOrderByOverall();
    }

    @GetMapping("language/{language}")
    public List<ProfileDto> getUsersByLanguage(@PathVariable("language") String language ){
        return leaderboardFacade.getUsersByCommonLanguage(language);
    }
}
