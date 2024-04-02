package com.epam.music_player;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MusicPlayerApplication {

    public static void main(String[] args) {
        List<String> tracks = new ArrayList<>();
        tracks.add("Song 1");
        tracks.add("Song 2");
        tracks.add("Song 3");

        MusicPlayer player = new MusicPlayer(tracks);

        player.playOrPause();
        player.next();
        player.previous();
    }

}
