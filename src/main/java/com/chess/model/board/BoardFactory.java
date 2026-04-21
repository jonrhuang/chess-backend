package com.chess.model.board;

import com.chess.model.piece.*;

public class BoardFactory {

  public static Board createEmptyBoard() {
    Square[][] grid = new Square[8][8];
    for (int row = 0; row < 8; row++) {
      for (int col = 0; col < 8; col++) {
        grid[row][col] = new Square(row, col);
      }
    }

    return new Board(grid);
  }

  public static Board createStandardBoard() {
    Board board = createEmptyBoard();

    // Place pawns
    for (int col = 0; col < 8; col++) {
      board.setPiece(1, col, new Pawn(PieceColor.BLACK));
      board.setPiece(6, col, new Pawn(PieceColor.WHITE));
    }

    // Place rooks
    board.setPiece(0, 0, new Rook(PieceColor.BLACK));
    board.setPiece(0, 7, new Rook(PieceColor.BLACK));
    board.setPiece(7, 0, new Rook(PieceColor.WHITE));
    board.setPiece(7, 7, new Rook(PieceColor.WHITE));

    // Place knights
    board.setPiece(0, 1, new Knight(PieceColor.BLACK));
    board.setPiece(0, 6, new Knight(PieceColor.BLACK));
    board.setPiece(7, 1, new Knight(PieceColor.WHITE));
    board.setPiece(7, 6, new Knight(PieceColor.WHITE));

    // Place bishops
    board.setPiece(0, 2, new Bishop(PieceColor.BLACK));
    board.setPiece(0, 5, new Bishop(PieceColor.BLACK));
    board.setPiece(7, 2, new Bishop(PieceColor.WHITE));
    board.setPiece(7, 5, new Bishop(PieceColor.WHITE));

    // Place queens
    board.setPiece(0, 3, new Queen(PieceColor.BLACK));
    board.setPiece(7, 3, new Queen(PieceColor.WHITE));

    // Place kings
    board.setPiece(0, 4, new King(PieceColor.BLACK));
    board.setPiece(7, 4, new King(PieceColor.WHITE));

    return board;
  }
}
