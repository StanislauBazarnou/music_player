package com.epam.music_player;

import java.util.List;

public class MusicPlayer implements Player {

    private final List<String> tracks;
    private int currentTrackIndex;
    private boolean isPaused;
    private boolean isStopped;
    private boolean isRepeat;

    public MusicPlayer(List<String> tracks) {
        this.tracks = tracks;
        this.currentTrackIndex = 0;
        this.isPaused = false;
        this.isStopped = true;
        this.isRepeat = false;
    }

    @Override
    public void playOrPause() {
        if (isStopped) {
            System.out.println("Playing: " + tracks.get(currentTrackIndex));
            isStopped = false;
            isPaused = false;
        }
        else if (isPaused) {
            System.out.println("Resuming: " + tracks.get(currentTrackIndex));
            isPaused = false;
        }
        else {
            System.out.println("Pausing: " + tracks.get(currentTrackIndex));
            isPaused = true;
        }
    }

    @Override
    public void stop() {
        if (isStopped) {
            System.out.println("Already stopped");
        }
        else {
            System.out.println("Stopping: " + tracks.get(currentTrackIndex));
            isStopped = true;
            isPaused = false;
        }
    }

    @Override
    public void next() {
        if (currentTrackIndex == tracks.size() - 1) {
            if (isRepeat) {
                currentTrackIndex = 0;
                System.out.println("Replaying first track: " + tracks.get(currentTrackIndex));
            }
            else {
                System.out.println("Already on the last track");
            }
        }
        else {
            currentTrackIndex++;
            System.out.println("Playing next track: " + tracks.get(currentTrackIndex));
        }
    }

    @Override
    public void previous() {
        if (currentTrackIndex == 0) {
            System.out.println("Already on the first track");
        }
        else {
            currentTrackIndex--;
            System.out.println("Playing previous track: " + tracks.get(currentTrackIndex));
        }
    }

    @Override
    public void repeatOnOrOff() {
        isRepeat = !isRepeat;
        System.out.println(isRepeat ? "Repeat on" : "Repeat off");
    }
}
