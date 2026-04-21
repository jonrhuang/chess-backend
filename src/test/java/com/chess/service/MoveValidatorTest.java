package com.chess.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.chess.model.board.*;
import com.chess.model.piece.*;

public class MoveValidatorTest {

  @Test
  void testPawnMoveOneSpace() {
    Board board = new Board();

    assertTrue(MoveValidator.isValidMove(board,
        1, 0,
        2, 0));

    assertTrue(MoveValidator.isValidMove(board,
        6, 0,
        5, 0));
  }

  @Test
  void testPawnMoveTwoSpace() {
    Board board = new Board();

    assertTrue(MoveValidator.isValidMove(board,
        1, 0,
        3, 0));

    assertTrue(MoveValidator.isValidMove(board,
        6, 0,
        4, 0));
  }

  @Test
  void testPawnIllegalMove() {
    Board board = new Board();

    assertFalse(MoveValidator.isValidMove(board,
        1, 0,
        3, 1));

    assertFalse(MoveValidator.isValidMove(board,
        6, 0,
        3, 0));
  }

  @Test
  void testRookMove() {
    Board board = new Board();

    Piece piece = new Piece(PieceType.ROOK, PieceColor.BLACK);

    // Put Rook in middle of board
    board.setPiece(4, 4, piece);

    assertTrue(MoveValidator.isValidMove(board,
        4, 4,
        4, 7));

    assertTrue(MoveValidator.isValidMove(board,
        4, 4,
        2, 4));

    assertTrue(MoveValidator.isValidMove(board,
        4, 4,
        4, 0));

    assertTrue(MoveValidator.isValidMove(board,
        4, 4,
        5, 4));
  }

  @Test
  void testRookIllegalMove() {
    Board board = new Board();

    // Blocked
    assertFalse(MoveValidator.isValidMove(board,
        0, 0,
        2, 0));

    assertFalse(MoveValidator.isValidMove(board,
        0, 0,
        0, 4));

    board.setPiece(4, 4,
        new Piece(PieceType.ROOK, PieceColor.BLACK));

    assertFalse(MoveValidator.isValidMove(board,
        4, 4,
        5, 5));
  }

  @Test
  void testKnightMove() {
    Board board = new Board();
    board.clear();

    // Put knight in middle of board
    board.setPiece(3, 3,
        new Piece(PieceType.KNIGHT, PieceColor.BLACK));

    assertTrue(MoveValidator.isValidMove(board,
        3, 3,
        5, 4));

    assertTrue(MoveValidator.isValidMove(board,
        3, 3,
        5, 2));

    assertTrue(MoveValidator.isValidMove(board,
        3, 3,
        4, 5));

    assertTrue(MoveValidator.isValidMove(board,
        3, 3,
        4, 1));

    board.setPiece(5, 3,
        new Piece(PieceType.KNIGHT, PieceColor.BLACK));

    assertTrue(MoveValidator.isValidMove(board,
        5, 3,
        3, 4));

    assertTrue(MoveValidator.isValidMove(board,
        5, 3,
        3, 2));

    assertTrue(MoveValidator.isValidMove(board,
        5, 3,
        4, 5));

    assertTrue(MoveValidator.isValidMove(board,
        5, 3,
        4, 1));
  }

  @Test
  void testKnightIllegalMove() {
    Board board = new Board();
    board.clear();

    // Put knight in middle of board
    board.setPiece(3, 3,
        new Piece(PieceType.KNIGHT, PieceColor.BLACK));

    assertFalse(MoveValidator.isValidMove(board,
        3, 3,
        4, 4));

    assertFalse(MoveValidator.isValidMove(board,
        3, 3,
        3, 0));
  }

  @Test
  void testBishopMove() {
    Board board = new Board();
    board.clear();

    // Put bishop in middle of board
    board.setPiece(3, 3,
        new Piece(PieceType.BISHOP, PieceColor.BLACK));

    assertTrue(MoveValidator.isValidMove(board,
        3, 3,
        0, 0));

    assertTrue(MoveValidator.isValidMove(board,
        3, 3,
        5, 5));

    assertTrue(MoveValidator.isValidMove(board,
        3, 3,
        1, 5));

    assertTrue(MoveValidator.isValidMove(board,
        3, 3,
        5, 1));
  }

  @Test
  void testBishopIllegalMove() {
    Board board = new Board();
    board.clear();

    // Put bishop in middle of board
    board.setPiece(3, 3,
        new Piece(PieceType.BISHOP, PieceColor.BLACK));

    assertFalse(MoveValidator.isValidMove(board,
        3, 3,
        0, 1));

    assertFalse(MoveValidator.isValidMove(board,
        3, 3,
        5, 7));

    assertFalse(MoveValidator.isValidMove(board,
        3, 3,
        1, 6));

    assertFalse(MoveValidator.isValidMove(board,
        3, 3,
        5, 0));
  }

  @Test
  void testQueenMove() {
    Board board = new Board();
    board.clear();

    board.setPiece(3, 3,
        new Piece(PieceType.QUEEN, PieceColor.WHITE));

    // Lateral moves
    assertTrue(MoveValidator.isValidMove(board,
        3, 3,
        3, 0));
    assertTrue(MoveValidator.isValidMove(board,
        3, 3,
        3, 6));
    assertTrue(MoveValidator.isValidMove(board,
        3, 3,
        0, 3));
    assertTrue(MoveValidator.isValidMove(board,
        3, 3,
        5, 3));

    // Diagonal moves
    assertTrue(MoveValidator.isValidMove(board,
        3, 3,
        5, 5));
    assertTrue(MoveValidator.isValidMove(board,
        3, 3,
        1, 1));
    assertTrue(MoveValidator.isValidMove(board,
        3, 3,
        5, 1));
    assertTrue(MoveValidator.isValidMove(board,
        3, 3,
        1, 5));
  }

  @Test
  void testQueenIllegalMove() {
    Board board = new Board();
    board.clear();

    board.setPiece(3, 3,
        new Piece(PieceType.QUEEN, PieceColor.WHITE));

    assertFalse(MoveValidator.isValidMove(board,
        3, 3,
        5, 6));
    assertFalse(MoveValidator.isValidMove(board,
        3, 3,
        1, 2));
    assertFalse(MoveValidator.isValidMove(board,
        3, 3,
        5, 2));
    assertFalse(MoveValidator.isValidMove(board,
        3, 3,
        1, 4));
  }

  @Test
  void testKingMove() {
    Board board = new Board();
    board.clear();

    board.setPiece(3, 3,
        new Piece(PieceType.KING, PieceColor.WHITE));

    assertTrue(MoveValidator.isValidMove(board,
        3, 3,
        3, 2));

    assertTrue(MoveValidator.isValidMove(board,
        3, 3,
        3, 4));

    assertTrue(MoveValidator.isValidMove(board,
        3, 3,
        2, 3));

    assertTrue(MoveValidator.isValidMove(board,
        3, 3,
        4, 3));

    assertTrue(MoveValidator.isValidMove(board,
        3, 3,
        4, 4));

    assertTrue(MoveValidator.isValidMove(board,
        3, 3,
        2, 2));

    assertTrue(MoveValidator.isValidMove(board,
        3, 3,
        2, 4));

    assertTrue(MoveValidator.isValidMove(board,
        3, 3,
        4, 2));
  }

  @Test
  void testKingIllegalMove() {
    Board board = new Board();
    board.clear();

    board.setPiece(3, 3,
        new Piece(PieceType.KING, PieceColor.WHITE));

    assertFalse(MoveValidator.isValidMove(board,
        3, 3,
        3, 1));

    assertFalse(MoveValidator.isValidMove(board,
        3, 3,
        6, 3));

    assertFalse(MoveValidator.isValidMove(board,
        3, 3,
        4, 5));

    assertFalse(MoveValidator.isValidMove(board,
        3, 3,
        2, 0));
  }
}
