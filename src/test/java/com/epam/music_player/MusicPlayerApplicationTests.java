package com.epam.music_player;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
class MusicPlayerApplicationTests {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private MusicPlayer player;

    @BeforeEach
    void setUp() {
        List<String> tracks = Arrays.asList("Track 1", "Track 2", "Track 3");
        player = new MusicPlayer(tracks);

        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testPlayOrPause() {
        player.playOrPause();
        assertEquals("Playing: Track 1", outContent.toString().trim());

        player.playOrPause();
        assertEquals("Playing: Track 1" + System.lineSeparator() + "Pausing: Track 1",
                outContent.toString().trim());

        player.playOrPause();
        assertEquals("Playing: Track 1" + System.lineSeparator() + "Pausing: Track 1" +
                System.lineSeparator() + "Playing: Track 1", outContent.toString().trim());
    }

    @Test
    void testStop() {
        player.playOrPause();
        player.stop();
        assertEquals("Playing: Track 1" + System.lineSeparator() +
                "Stopping: Track 1", outContent.toString().trim());
    }

    @Test
    void testNext() {
        player.next();
        assertEquals("Playing next track: Track 2", outContent.toString().trim());
    }

    @Test
    void testPrevious() {
        player.next();
        player.previous();
        assertEquals("Playing next track: Track 2" + System.lineSeparator() +
                "Playing previous track: Track 1", outContent.toString().trim());
    }

    @Test
    void testRepeatOnOrOff() {
        player.repeatOnOrOff();
        assertEquals("Repeat is now on", outContent.toString().trim());
        player.repeatOnOrOff();
        assertEquals("Repeat is now on" + System.lineSeparator() +
                "Repeat is now off", outContent.toString().trim());
    }

}
