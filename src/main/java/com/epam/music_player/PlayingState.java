package com.epam.music_player;

class PlayingState implements PlayerState {
    MusicPlayer player;

    public PlayingState(MusicPlayer player) {
        this.player = player;
    }

    public void playOrPause() {
        System.out.println("Pausing: " + player.currentTrack());
        player.setState(player.getPausedState());
    }

    public void stop() {
        System.out.println("Stopping: " + player.currentTrack());
        player.setState(player.getStoppedState());
    }

    public void next() {
        int currentIndex = player.getCurrentTrackIndex();
        if (currentIndex < player.getTracks().size() - 1) {
            currentIndex++;
            player.setCurrentTrackIndex(currentIndex);
            System.out.println("Playing next track: " + player.currentTrack());
        } else {
            System.out.println("Already on the last track");
        }
    }

    public void previous() {
        int currentIndex = player.getCurrentTrackIndex();
        if (currentIndex > 0) {
            currentIndex--;
            player.setCurrentTrackIndex(currentIndex);
            System.out.println("Playing previous track: " + player.currentTrack());
        } else {
            System.out.println("Already on the first track");
        }
    }
}
