package com.example.chess.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChessController {

  @GetMapping("/")
  public String home() {
    return "Home page";
  }

  @GetMapping("/hello")
  public String hello() {
    return "chess server running";
  }

}