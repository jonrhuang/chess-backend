package com.chess.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.chess.model.board.*;
import com.chess.model.piece.*;

public class BoardTest {

  @Test
  void testInitializeBoardSetup() {
    Board board = BoardFactory.createStandardBoard();

    // Test black pawn
    assertInstanceOf(Pawn.class, board.getPiece(1,0));
    assertEquals(PieceColor.BLACK, board.getPiece(1,0).getColor());
    // Test white pawn
    assertInstanceOf(Pawn.class, board.getPiece(1,7));
    assertEquals(PieceColor.WHITE, board.getPiece(6,7).getColor());

    // Test black rook
    assertInstanceOf(Rook.class, board.getPiece(0,7));
    assertEquals(PieceColor.BLACK, board.getPiece(0,7).getColor());
    // Test white rook
    assertInstanceOf(Rook.class, board.getPiece(7,7));
    assertEquals(PieceColor.WHITE, board.getPiece(7,7).getColor());

    // Test black knight
    assertInstanceOf(Knight.class, board.getPiece(0,1));
    assertEquals(PieceColor.BLACK, board.getPiece(0,1).getColor());
    // Test white knight 
    assertInstanceOf(Knight.class, board.getPiece(7,6));
    assertEquals(PieceColor.WHITE, board.getPiece(7,6).getColor());

    // Test black bishop 
    assertInstanceOf(Bishop.class, board.getPiece(0,2));
    assertEquals(PieceColor.BLACK, board.getPiece(0,2).getColor());
    // Test white bishop 
    assertInstanceOf(Bishop.class, board.getPiece(7,5));
    assertEquals(PieceColor.WHITE, board.getPiece(7,5).getColor());

    // Test black queen 
    assertInstanceOf(Queen.class, board.getPiece(0,3));
    assertEquals(PieceColor.BLACK, board.getPiece(0,3).getColor());
    // Test white queen  
    assertInstanceOf(Queen.class, board.getPiece(7,3));
    assertEquals(PieceColor.WHITE, board.getPiece(7,3).getColor());

    // Test black king 
    assertInstanceOf(King.class, board.getPiece(0,4));
    assertEquals(PieceColor.BLACK, board.getPiece(0,4).getColor());
    // Test white king 
    assertInstanceOf(King.class, board.getPiece(7,4));
    assertEquals(PieceColor.WHITE, board.getPiece(7,4).getColor());
  }

  @Test
  void testGetPiece() {
    Board board = BoardFactory.createStandardBoard();
    assertInstanceOf(Rook.class, board.getPiece(0,0));
    assertNull(board.getPiece(2,2));
  }

  @Test
  void testSetPiece() {
    Board board = BoardFactory.createStandardBoard();
    Piece testPiece = new King(PieceColor.WHITE);
    board.setPiece(0, 0, testPiece);

    assertInstanceOf(King.class, board.getPiece(0,0));
    assertEquals(PieceColor.WHITE, board.getPiece(0,0).getColor());
  }

  @Test
  void testEmptyBoardSetUp() {
    Board board = BoardFactory.createEmptyBoard();

    assertNull(board.getPiece(0, 0));
  }
}