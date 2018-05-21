class Game {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
    static List playerCheckerList = []

    static Player setupPlayer(int n) {
        //setup Player n
        print "Is player $n a human or AI player? (0 if human, 1 if AI): "
        String playerType = br.readLine()
        while (playerType != "1" && playerType != "0"){
            print "Please enter a valid choice: "
            playerType = br.readLine()
        }
        print "Please enter player $n name: "
        String name = br.readLine()
        print "Please enter your character: "
        String type = br.readLine()
        while (type.size() > 3 || type.size() == 0 || type in playerType) {
            print "Please enter something different between 1 and 3 characters: "
            type = br.readLine()
        }

        playerCheckerList << type

        if (playerType == "1") {
            return new AIPlayer(name, type, 4)
        } else {
            return new Player(name, type)
        }
    }

    static void main(String[] args) {
        println "Welcome to the game of XO!"

        //setup players
        Player player1 = setupPlayer(1)
        Player player2 = setupPlayer(2)

        Board gameBoard = new Board(player1.getType(), player2.getType())
        println gameBoard
        //loop through the game
        while (true) {
            def endGame

            println "Player ${player1.getName()}! It's your turn"
            endGame = player1.makeMove(gameBoard)
            println gameBoard
            if (endGame) {
                println "Congratulations! ${player1.getName()} is the winner!"
                break
            }

            if (gameBoard.isFull()) {
                println "The board is full! It's a draw"
                break
            }

            println "Player ${player2.getName()}! It's your turn"
            endGame = player2.makeMove(gameBoard)
            println gameBoard
            if (endGame) {
                println "Congratulations! ${player2.getName()} is the winner!"
                break
            }
        }
    }
}
