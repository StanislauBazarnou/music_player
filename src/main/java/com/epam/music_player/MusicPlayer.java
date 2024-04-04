package com.epam.music_player;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MusicPlayer {

    private PlayerState playingState;
    private PlayerState pausedState;
    private PlayerState stoppedState;
    @Setter
    private PlayerState state;
    private List<String> tracks;
    @Setter
    private int currentTrackIndex = 0;
    private boolean repeat;

    public MusicPlayer(List<String> tracks) {
        this.tracks = new ArrayList<>(tracks);
        this.playingState = new PlayingState(this);
        this.pausedState = new PausedState(this);
        this.stoppedState = new StoppedState(this);
        this.state = stoppedState;
        this.repeat = false;
    }

    public String currentTrack() {
        return tracks.get(currentTrackIndex);
    }

    public void playOrPause() {
        state.playOrPause();
    }

    public void stop() {
        state.stop();
    }

    public void next() {
        state.next();
    }

    public void previous() {
        state.previous();
    }

    public void repeatOnOrOff() {
        repeat = !repeat;
        System.out.println("Repeat is now " + (repeat ? "on" : "off"));
    }
}
