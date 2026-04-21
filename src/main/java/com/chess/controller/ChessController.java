package com.chess.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chess.service.GameService;
import com.chess.model.Board;
import com.chess.model.MoveRequest;

@RestController
public class ChessController {

  private final GameService gameService;

  public ChessController(GameService gameService) {
    this.gameService = gameService;
  }

  @GetMapping("/")
  public String home() {
    return "Home page";
  }

  @GetMapping("/board")
  public Board getBoard() {
    return gameService.getBoard();
  }

  @GetMapping("/hello")
  public String hello() {
    return "chess server running";
  }

  @PostMapping("/move")
  public Board move(
    @RequestBody MoveRequest move
  ) {
    gameService.movePiece(
      move.getStartRow(),
      move.getStartCol(),
      move.getEndRow(),
      move.getEndCol()
    );

    return gameService.getBoard();
  }
  

}