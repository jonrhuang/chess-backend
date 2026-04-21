package com.chess.model.piece;

import java.util.List;

import com.chess.model.board.*;

public abstract class Piece {
  private PieceColor color;
  private boolean hasMoved;

  public Piece(PieceColor color) {
    this.color = color;
    hasMoved = false;
  }

  public PieceColor getColor() {
    return color;
  }

  public boolean hasMoved() {
    return this.hasMoved;
  }

  abstract public List<Square> getCandidateMoves(Square current, Board board);

  public String emote() {
    return "implement emote";
  }
}