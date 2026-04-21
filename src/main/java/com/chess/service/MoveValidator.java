package com.chess.service;

import com.chess.model.board.*;
import com.chess.model.piece.*;

public class MoveValidator {

  public static boolean isValidMove(Board board, int startRow, int startCol, int endRow, int endCol) {
    Piece piece = board.getPiece(startRow, startCol);

    // No piece at start
    if (piece == null) {
      return false;
    }

    // Can't move to same square
    if (startRow == endRow && startCol == endCol) {
      return false;
    }

    // Can't capture your own piece
    Piece target = board.getPiece(endRow, endCol);
    if (target != null && target.getColor() == piece.getColor()) {
      return false;
    }

    // Out of bounds
    if (endRow < 0 || endRow > 7 || endCol < 0 || endCol > 7) {
      return false;
    }

    return switch (piece.getType()) {
      case PieceType.PAWN -> isValidPawnMove(board, piece, startRow, startCol, endRow, endCol);
      case PieceType.ROOK -> isValidRookMove(board, startRow, startCol, endRow, endCol);
      case PieceType.KNIGHT -> isValidKnightMove(startRow, startCol, endRow, endCol);
      case PieceType.BISHOP -> isValidBishopMove(board, startRow, startCol, endRow, endCol);
      case PieceType.QUEEN -> isValidRookMove(board, startRow, startCol, endRow, endCol) ||
        isValidBishopMove(board, startRow, startCol, endRow, endCol);
      case PieceType.KING -> isValidKingMove(startRow, startCol, endRow, endCol);
    };
  }

  private static boolean isValidPawnMove(Board board, Piece piece, int startRow, int startCol, int endRow, int endCol) {
    int direction = piece.getColor() == PieceColor.WHITE ? -1 : 1;
    int startingRow = piece.getColor() == PieceColor.WHITE ? 6 : 1;

    // Move forward one square
    if (endCol == startCol && endRow == startRow + direction 
        && board.getPiece(endRow, endCol) == null) {
      return true;
    }

    // Move forward two squares from starting row
    if (endCol == startCol && startRow == startingRow && endRow == startRow + 2 * direction
        && board.getPiece(endRow, endCol) == null
        && board.getPiece(startRow + direction, startCol) == null) {
      return true;
    }

    // Diagonal capture
    if (endRow == startRow + direction && Math.abs(endCol - startCol) == 1
        && board.getPiece(endRow, endCol) != null) {
      return true;
    }

    return false;
  }

  private static boolean isValidRookMove(Board board, int startRow, int startCol, int endRow, int endCol) {
    // Must move in a straight line
    if (startRow != endRow && startCol != endCol)
      return false;
    return isPathClear(board, startRow, startCol, endRow, endCol);
  }

  private static boolean isValidKnightMove(int startRow, int startCol, int endRow, int endCol) {
    int rowDiff = Math.abs(endRow - startRow);
    int colDiff = Math.abs(endCol - startCol);
    return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
  }

  private static boolean isValidBishopMove(Board board, int startRow, int startCol, int endRow, int endCol) {
    // Must move diagonally
    if (Math.abs(endRow - startRow) != Math.abs(endCol - startCol))
      return false;
    return isPathClear(board, startRow, startCol, endRow, endCol);
  }

  private static boolean isValidKingMove(int startRow, int startCol, int endRow, int endCol) {
    return Math.abs(endRow - startRow) <= 1 && Math.abs(endCol - startCol) <= 1;
  }

  private static boolean isPathClear(Board board, int startRow, int startCol, int endRow, int endCol) {
    int rowStep = Integer.signum(endRow - startRow);
    int colStep = Integer.signum(endCol - startCol);

    int row = startRow + rowStep;
    int col = startCol + colStep;

    while (row != endRow || col != endCol) {
      if (board.getPiece(row, col) != null)
        return false;
      row += rowStep;
      col += colStep;
    }

    return true;
  }
}