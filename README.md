# Chess Backend

This is a **Spring Boot backend for a Chess game**, providing the game logic and REST APIs.  
It handles the chess board, pieces, and game state, and is designed to be connected to a UI later (web or desktop

---

## Features

- Initializes a standard 8x8 chess board
- Represents all chess pieces with type and color
- Provides a REST endpoint to get the current board state

---
## Project Structure
```
chess-backend/
├── src/
│ └── main/java/com/example/chess/
│   ├── ChessApplication.java # Main Spring Boot application
│   ├── controller/
│   │ └── ChessController.java # REST endpoints
│   ├── service/
│   │ └── GameService.java # Game state management
│   └── model/
│     ├── Board.java
│     ├── Piece.java
│     ├── PieceType.java
│     └── PieceColor.java
├── pom.xml
└── README.md
```

## Getting Started

### Prerequisites

- Java 21+
- Maven

### Run the Backend

```bash
# Clone the repository
git clone https://github.com/yourusername/chess-backend.git
cd chess-backend

# Build the project
mvn clean install

# Run the Spring Boot app
mvn spring-boot:run
