package com.example.chess.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.example.chess.model.*;
import com.example.chess.service.*;

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
  }

  @Test
  void testRookIllegalMove() {
    Board board = new Board();

    assertFalse(MoveValidator.isValidMove(board,
        0, 0,
        2, 0));

    assertFalse(MoveValidator.isValidMove(board,
        0, 0,
        0, 4));

    assertFalse(MoveValidator.isValidMove(board,
        0, 0,
        4, 4));
  }

  @Test
  void testKnightMove() {
    Board board = new Board();

    Piece piece = new Piece(PieceType.KNIGHT, PieceColor.BLACK);

    // Put Rook in middle of board
    board.setPiece(3, 3, piece);

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

    board.setPiece(5, 3, piece);

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

  // @Test
  // void testBishopMove() {
  //   Board board = new Board();

  //   assertFalse(MoveValidator.isValidMove(board,
  //       1, 0,
  //       3, 1));

  //   assertFalse(MoveValidator.isValidMove(board,
  //       6, 0,
  //       3, 0));
  // }

  // @Test
  // void testQueenMove() {
  //   Board board = new Board();

  //   assertFalse(MoveValidator.isValidMove(board,
  //       1, 0,
  //       3, 1));

  //   assertFalse(MoveValidator.isValidMove(board,
  //       6, 0,
  //       3, 0));
  // }

  // @Test
  // void testKingMove() {
  //   Board board = new Board();

  //   assertFalse(MoveValidator.isValidMove(board,
  //       1, 0,
  //       3, 1));

  //   assertFalse(MoveValidator.isValidMove(board,
  //       6, 0,
  //       3, 0));
  // }
}
