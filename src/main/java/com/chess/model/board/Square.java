package com.chess.model.board;

import com.chess.model.piece.*;

public class Square {
  private final int row;
  private final int col;
  private Piece piece;
  
  public Square(int row, int col) {
    this.row = row;
    this.col = col;
    piece = null;
  }
  
  public int getRow() {
    return row;
  }

  public int getCol() {
    return col;
  }

  public Piece getPiece() {
    return piece;
  }

  public void setPiece(Piece piece) {
    this.piece = piece;
  }
}
