package com.epam.music_player;

class StoppedState implements PlayerState {
    MusicPlayer player;

    public StoppedState(MusicPlayer player) {
        this.player = player;
    }

    public void playOrPause() {
        System.out.println("Playing: " + player.currentTrack());
        player.setState(player.getPlayingState());
    }

    public void stop() {
        System.out.println("Already stopped");
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
