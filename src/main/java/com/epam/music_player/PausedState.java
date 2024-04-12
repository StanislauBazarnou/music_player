package com.epam.music_player;

public class PausedState implements PlayerState {
    MusicPlayer player;

    public PausedState(MusicPlayer player) {
        this.player = player;
    }

    public void playOrPause() {
        System.out.println("Playing: " + player.currentTrack());
        player.setState(player.getPlayingState());
    }

    public void stop() {
        System.out.println("Stopping: " + player.currentTrack());
        player.setState(player.getStoppedState());
    }

    public void next() {
        if (player.getCurrentTrackIndex() < player.getTracks().size() - 1) {
            player.setCurrentTrackIndex(player.getCurrentTrackIndex() + 1);
        } else if (player.isRepeatEnabled()) {
            player.setCurrentTrackIndex(0);
        } else {
            System.out.println("Already on the last track");
        }
        System.out.println("Playing: " + player.currentTrack());
    }

    public void previous() {
        if (player.getCurrentTrackIndex() > 0) {
            player.setCurrentTrackIndex(player.getCurrentTrackIndex() - 1);
        } else if (player.isRepeatEnabled()) {
            player.setCurrentTrackIndex(player.getTracks().size() - 1); // Goes to the end of the list
        } else {
            System.out.println("Already on the first track");
        }
        System.out.println("Playing: " + player.currentTrack());
    }
}
