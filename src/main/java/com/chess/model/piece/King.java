package com.chess.model.piece;

import java.util.List;
import java.util.ArrayList;

import com.chess.model.board.*;


public class King extends Piece {

  public King(PieceColor color) {
    super(color);
  }

  public List<Square> getCandidateMoves(Square current, Board board) {
    List<Square> moves = new ArrayList<Square>();

    return moves;
  }
  
}
