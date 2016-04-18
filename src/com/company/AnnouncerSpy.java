package com.company;

public class AnnouncerSpy implements Announcer {

    private String announcedMark;

    public String announcedWinnerMark() {
        return announcedMark;
    }

    @Override
    public void announceWinner(String mark) {
        announcedMark = mark;
    }
}
