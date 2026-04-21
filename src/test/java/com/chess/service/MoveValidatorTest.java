package com.chess.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.chess.model.board.*;
import com.chess.model.piece.*;

public class MoveValidatorTest {

  @Test
  void testPawnMoveOneSpace() {
    Board board = BoardFactory.createStandardBoard();

    assertTrue(MoveValidator.isValidMove(board,
        1, 0,
        2, 0));

    assertTrue(MoveValidator.isValidMove(board,
        6, 0,
        5, 0));
  }

  @Test
  void testPawnMoveTwoSpace() {
    Board board = BoardFactory.createStandardBoard();

    assertTrue(MoveValidator.isValidMove(board,
        1, 0,
        3, 0));

    assertTrue(MoveValidator.isValidMove(board,
        6, 0,
        4, 0));
  }

  @Test
  void testPawnIllegalMove() {
    Board board = BoardFactory.createStandardBoard();

    assertFalse(MoveValidator.isValidMove(board,
        1, 0,
        3, 1));

    assertFalse(MoveValidator.isValidMove(board,
        6, 0,
        3, 0));
  }

  @Test
  void testRookMove() {
    Board board = BoardFactory.createEmptyBoard();

    // Put Rook in middle of board
    board.setPiece(4, 4, new Rook(PieceColor.BLACK));

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
    Board board = BoardFactory.createStandardBoard();

    // Blocked
    assertFalse(MoveValidator.isValidMove(board,
        0, 0,
        2, 0));

    assertFalse(MoveValidator.isValidMove(board,
        0, 0,
        0, 4));

    board.setPiece(4, 4,
        new Rook(PieceColor.BLACK));

    assertFalse(MoveValidator.isValidMove(board,
        4, 4,
        5, 5));
  }

  @Test
  void testKnightMove() {
    Board board = BoardFactory.createEmptyBoard();

    // Put knight in middle of board
    board.setPiece(3, 3,
        new Knight(PieceColor.BLACK));

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
        new Knight(PieceColor.BLACK));

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
    Board board = BoardFactory.createEmptyBoard();

    // Put knight in middle of board
    board.setPiece(3, 3,
        new Knight(PieceColor.BLACK));

    assertFalse(MoveValidator.isValidMove(board,
        3, 3,
        4, 4));

    assertFalse(MoveValidator.isValidMove(board,
        3, 3,
        3, 0));
  }

  @Test
  void testBishopMove() {
    Board board = BoardFactory.createEmptyBoard();

    // Put bishop in middle of board
    board.setPiece(3, 3,
        new Bishop(PieceColor.BLACK));

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
    Board board = BoardFactory.createEmptyBoard();

    // Put bishop in middle of board
    board.setPiece(3, 3,
        new Bishop(PieceColor.BLACK));

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
    Board board = BoardFactory.createEmptyBoard();

    board.setPiece(3, 3,
        new Queen(PieceColor.WHITE));

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
    Board board = BoardFactory.createEmptyBoard();

    board.setPiece(3, 3,
        new Queen(PieceColor.WHITE));

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
    Board board = BoardFactory.createEmptyBoard();

    board.setPiece(3, 3,
        new King(PieceColor.WHITE));

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
    Board board = BoardFactory.createEmptyBoard();

    board.setPiece(3, 3,
        new King(PieceColor.WHITE));

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
