package com.example.chess.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.example.chess.model.*;

public class ChessServiceTest {

  @Test
  void testMovePiece() {
    GameService service = new GameService();

    // Move white pawn from (6,4) -> (4,4)
    service.movePiece(6, 4, 4, 4);

    Piece movedPiece = service.getBoard().getPiece(4, 4);

    // New position has the piece
    assertNotNull(movedPiece);
    assertEquals(PieceType.PAWN, movedPiece.getType());
    assertEquals(PieceColor.WHITE, movedPiece.getColor());

    // Old position is empty
    assertNull(service.getBoard().getPiece(6, 4));
  }
}
