public class Arena {
    public static void main(String[] args) {
        Player playerA = new Player("Player A", 50, 5, 10);
        Player playerB = new Player("Player B", 100, 10, 5);

        Player currentPlayer = playerA.getHealth() < playerB.getHealth() ? playerA : playerB; //@finds the cuurent player
        Player opponent = currentPlayer == playerA ? playerB : playerA; //@finds the opponent

        while (playerA.isAlive() && playerB.isAlive()) {
            currentPlayer.attack(opponent);

            // Swap turns
            Player temp = currentPlayer;
            currentPlayer = opponent;
            opponent = temp;
        }

        System.out.printf("%s wins the match!%n", playerA.isAlive() ? playerA.getName() : playerB.getName());
        System.out.println("Unit testcase Begins");
        Magical_Arena_Unit_Test_Case.MatchBegin();
        System.out.println("Unit testcase End");
    }
}