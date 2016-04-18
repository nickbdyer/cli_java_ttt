package com.company;

public class GameEngine {

    private final Announcer announcer;
    private int calls = 0;

    public GameEngine(Announcer announcer) {
        this.announcer = announcer;
    }

    public void putMark(int space) {
        calls++;

        if (calls == 5)
            announcer.announceWinner("X");

        if (calls == 6)
            announcer.announceWinner("O");
    }
}
