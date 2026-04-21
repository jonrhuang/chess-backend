package com.chess.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

  @Test
  void testInitializeBoardSetup() {
    Board board = new Board();

    // Test black pawn
    assertEquals(PieceType.PAWN, board.getPiece(1,0).getType());
    assertEquals(PieceColor.BLACK, board.getPiece(1,0).getColor());
    // Test white pawn
    assertEquals(PieceType.PAWN, board.getPiece(1,7).getType());
    assertEquals(PieceColor.WHITE, board.getPiece(6,7).getColor());

    // Test black rook
    assertEquals(PieceType.ROOK, board.getPiece(0,7).getType());
    assertEquals(PieceColor.BLACK, board.getPiece(0,7).getColor());
    // Test white rook
    assertEquals(PieceType.ROOK, board.getPiece(7,7).getType());
    assertEquals(PieceColor.WHITE, board.getPiece(7,7).getColor());

    // Test black knight
    assertEquals(PieceType.KNIGHT, board.getPiece(0,1).getType());
    assertEquals(PieceColor.BLACK, board.getPiece(0,1).getColor());
    // Test white knight 
    assertEquals(PieceType.KNIGHT, board.getPiece(7,6).getType());
    assertEquals(PieceColor.WHITE, board.getPiece(7,6).getColor());

    // Test black bishop 
    assertEquals(PieceType.BISHOP, board.getPiece(0,2).getType());
    assertEquals(PieceColor.BLACK, board.getPiece(0,2).getColor());
    // Test white bishop 
    assertEquals(PieceType.BISHOP, board.getPiece(7,5).getType());
    assertEquals(PieceColor.WHITE, board.getPiece(7,5).getColor());

    // Test black queen 
    assertEquals(PieceType.QUEEN, board.getPiece(0,3).getType());
    assertEquals(PieceColor.BLACK, board.getPiece(0,3).getColor());
    // Test white queen  
    assertEquals(PieceType.QUEEN, board.getPiece(7,3).getType());
    assertEquals(PieceColor.WHITE, board.getPiece(7,3).getColor());

    // Test black king 
    assertEquals(PieceType.KING, board.getPiece(0,4).getType());
    assertEquals(PieceColor.BLACK, board.getPiece(0,4).getColor());
    // Test white king 
    assertEquals(PieceType.KING, board.getPiece(7,4).getType());
    assertEquals(PieceColor.WHITE, board.getPiece(7,4).getColor());
  }

  @Test
  void testGetPiece() {
    Board board = new Board();
    assertEquals(PieceType.ROOK, board.getPiece(0,0).getType());
    assertNull(board.getPiece(2,2));
  }

  @Test
  void testSetPiece() {
    Board board = new Board();
    Piece testPiece = new Piece(PieceType.KING, PieceColor.WHITE);
    board.setPiece(0, 0, testPiece);

    assertEquals(PieceType.KING, board.getPiece(0,0).getType());
    assertEquals(PieceColor.WHITE, board.getPiece(0,0).getColor());
  }
}