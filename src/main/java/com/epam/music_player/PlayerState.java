package com.epam.music_player;

public interface PlayerState {
    void playOrPause();

    void stop();

    void next();

    void previous();

}
