# Task 2
Implement a Music Player

You have to implement a class for the following interface:

```java
interface Player { 
    void playOrPause();
    void stop();
    void next();
    void previous();
    void repeatOnOrOff();
}
```

This interface imitates a set of buttons of a software or hardware player

- **Play/Pause** button: Should start or pause playback, depending on what the player is currently doing.
- **Stop** button: Should stop playback, if "Play" button is pressed afterward, the current track should start from the beginning.
- **Next** button: Should skip the current track to the next one, considering if repeat is enabled or disabled. A warning message should be shown if "Stop" is pressed when the track is already stopped, or "Next" is pressed and the player is already on the last track.
- **Previous** button: Should play the track before the current one.
- **Repeat** button: Should toggle the repeat on or off.

The constructor of this class implementation should accept a list of track names (`List<String>`)

### Actions:

- Press "Play" button: Displays the message: *"Playing: [current track name]"*
- Press "Stop" button: Displays the message: *"Stopping: [current track name]"* or *"Already stopped"* (as appropriate)
- Press "Next" button: Displays the message: *"Playing next track: [name of the next track]"* or *"Replaying first track: [name of the first track]"* or *"Already on the last track"* (as appropriate)
- Press "Previous" button: Displays the message: *"Playing previous track: [name of the previous track]"* or *"Already on the first track"* (as appropriate)
- Press "Repeat" button: Displays the message: *"Repeat on"* or *"Repeat off"* (depending on the situation)

### Scenario example:

**Skip to next track:**

- Press "Next" button
    - If there is a next track, it will play and display the message *"Playing next track: [name of next track]"*
    - If the current track is the last one and repeat is enabled, the first track is played and the message *"Replaying first track: [name of the first track]"* is displayed
    - If the current track is the last one and repeat is turned off, the message *"Already on the last track"* is displayed

---