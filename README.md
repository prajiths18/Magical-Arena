# Arena Game

## Description
The Arena Game simulates a turn-based battle between two players, Player A and Player B. Each player has attributes such as health, strength, and attack, and they take turns attacking each other until one player's health drops to zero or below.

## Players
- **Player A**: 
  - Initial Health: 50
  - Strength: 5
  - Attack: 10

- **Player B**:
  - Initial Health: 100
  - Strength: 10
  - Attack: 5

## Game Mechanics
- The game begins with Player A and Player B taking turns attacking each other.
- Attack damage is calculated based on the attacker's attack attribute and a random dice roll (1 to 6).
- Defense strength of the defender reduces the incoming attack damage.
- The game continues until one player's health drops to zero or below.

## Code Files
- **Arena.java**: Contains the main method that initializes the players and runs the game loop.
- **Player.java**: Defines the Player class with methods and attributes for managing player stats, attacking, and defense.

## How to Run
To run the game:
1. Compile both `Arena.java` and `Player.java`.
   ```bash
   java Arena
   ```
## Unit Testing
- The game includes a basic unit test case in **Magical_Arena_Unit_Test_Case.java**, which tests the match initialization and outcome.
