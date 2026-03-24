package com.example.chess.model;

public class Board {
    private final Piece[][] grid = new Piece[8][8];

    public Board() {
        setupInitialBoard();
    }

    private void setupInitialBoard() {
        // Place pawns
        for (int i = 0; i < 8; i++) {
            grid[1][i] = new Piece(PieceType.PAWN, PieceColor.BLACK);
            grid[6][i] = new Piece(PieceType.PAWN, PieceColor.WHITE);
        }

        // Place rooks
        grid[0][0] = new Piece(PieceType.ROOK, PieceColor.BLACK);
        grid[0][7] = new Piece(PieceType.ROOK, PieceColor.BLACK);
        grid[7][0] = new Piece(PieceType.ROOK, PieceColor.WHITE);
        grid[7][7] = new Piece(PieceType.ROOK, PieceColor.WHITE);

        // Place knights
        grid[0][1] = new Piece(PieceType.KNIGHT, PieceColor.BLACK);
        grid[0][6] = new Piece(PieceType.KNIGHT, PieceColor.BLACK);
        grid[7][1] = new Piece(PieceType.KNIGHT, PieceColor.WHITE);
        grid[7][6] = new Piece(PieceType.KNIGHT, PieceColor.WHITE);

        // Place bishops
        grid[0][2] = new Piece(PieceType.BISHOP, PieceColor.BLACK);
        grid[0][5] = new Piece(PieceType.BISHOP, PieceColor.BLACK);
        grid[7][2] = new Piece(PieceType.BISHOP, PieceColor.WHITE);
        grid[7][5] = new Piece(PieceType.BISHOP, PieceColor.WHITE);

        // Place queens
        grid[0][3] = new Piece(PieceType.QUEEN, PieceColor.BLACK);
        grid[7][3] = new Piece(PieceType.QUEEN, PieceColor.WHITE);

        // Place kings
        grid[0][4] = new Piece(PieceType.KING, PieceColor.BLACK);
        grid[7][4] = new Piece(PieceType.KING, PieceColor.WHITE);
    }

    public Piece getPiece(int row, int col) {
        return grid[row][col];
    }

    public void setPiece(int row, int col, Piece piece) {
        grid[row][col] = piece;
    }
}