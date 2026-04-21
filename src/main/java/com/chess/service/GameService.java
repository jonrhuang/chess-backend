package com.chess.service;

import org.springframework.stereotype.Service;

import com.chess.model.board.*;
import com.chess.model.piece.*;

@Service
public class GameService {
  private Board board;

  public GameService() {
    startNewGame();
  }

  public void startNewGame() {
    board = new Board();
    System.out.println(board);
  }

  public Board getBoard() {
    return board;
  }

  public void movePiece(int startRow, int startCol, int endRow, int endCol) {
    if (!MoveValidator.isValidMove(board, startRow, startCol, endRow, endCol)) {
      throw new IllegalArgumentException("Invalid move");
    }

    Piece piece = board.getPiece(startRow, startCol);

    board.setPiece(endRow, endCol, piece); 
    board.setPiece(startRow, startCol, null); 
  }

}