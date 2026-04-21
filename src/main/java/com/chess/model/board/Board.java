package com.chess.model.board;

import com.chess.model.piece.*;

public class Board {
  private final Square[][] grid;

  public Board(Square[][] grid) {
    this.grid = grid;
  }

  public Piece getPiece(int row, int col) {
    return grid[row][col].getPiece();
  }

  public void setPiece(int row, int col, Piece piece) {
    grid[row][col].setPiece(piece);
  }

  public Square[][] getGrid() {
    return grid;
  }
}