package com.chess.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import tools.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.chess.model.board.*;
import com.chess.controller.ChessController;
import com.chess.service.GameService;
import com.chess.model.move.*;

@WebMvcTest(ChessController.class)
class ChessControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @MockitoBean
  private GameService gameService;

  @Test
  public void getBoard_returnsBoard() throws Exception {
    Board mockBoard = new Board();
    when(gameService.getBoard()).thenReturn(mockBoard);

    mockMvc.perform(get("/board"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    verify(gameService, times(1)).getBoard();
  }

  @Test
  public void move_validRequest_returnsBoard() throws Exception {
    MoveRequest moveRequest = new MoveRequest(1, 0, 3, 0);
    Board mockBoard = new Board();
    when(gameService.getBoard()).thenReturn(mockBoard);

    mockMvc.perform(post("/move")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(moveRequest)))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    verify(gameService, times(1)).movePiece(1, 0, 3, 0);
    verify(gameService, times(1)).getBoard();
  }

  @Test
  public void move_callsMovePieceWithCorrectArgs() throws Exception {
    MoveRequest moveRequest = new MoveRequest(6, 4, 4, 4);
    when(gameService.getBoard()).thenReturn(new Board());

    mockMvc.perform(post("/move")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(moveRequest)))
        .andExpect(status().isOk());

    verify(gameService).movePiece(6, 4, 4, 4);
  }

  @Test
  public void move_missingBody_returnsBadRequest() throws Exception {
    mockMvc.perform(post("/move")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest());
  }

  // @Test
  // public void move_movePieceThrowsException_returnsServerError() throws Exception {
  //   MoveRequest moveRequest = new MoveRequest(0, 0, 7, 7);

  //   doThrow(new RuntimeException("Invalid move")).when(gameService)
  //       .movePiece(anyInt(), anyInt(), anyInt(), anyInt());

  //   mockMvc.perform(post("/move")
  //       .contentType(MediaType.APPLICATION_JSON)
  //       .content(objectMapper.writeValueAsString(moveRequest)))
  //       .andExpect(status().isInternalServerError());
  // }
}