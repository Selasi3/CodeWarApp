package io.turntabl.leaderboardservice.client.response;

public class AddUser {
    String username;

    public AddUser() {
    }

    public AddUser(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
