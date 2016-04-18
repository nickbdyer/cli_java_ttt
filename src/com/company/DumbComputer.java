package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DumbComputer extends Player {

    @Override
    public void markBoard(int position, Board board) {
        board.mark(3, getMark());
    }

    public int generateMove(Board board) {
        determineAvailableMoves(board).get(0);
        return 1;
    }

    private List<Character> determineAvailableMoves(Board board) {
        List<Character> availableMoves = new ArrayList<Character>();
        for (Character cell : board.showCells()) {
            if (Character.isDigit(cell)) {
                availableMoves.add(cell);
            }
        }
        return availableMoves;
    }


}
