class Player {
    private String name
    private String type

    Player (String name, String type) {
        this.name = name
        this.type = type
    }

    boolean makeMove(Board board) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in))

        while (true) {
            print "Enter a row: "
            def row = br.readLine()
            boolean satisfy = false

            while (!satisfy) {
                while (!row.isInteger()) {
                    print "Please enter an integer: "
                    row = br.readLine()
                }
                row = row.toInteger()
                if (row in 0..4) {
                    satisfy = true
                } else {
                    print "Please enter a number between 0 and 4: "
                    row = br.readLine()
                }
            }

            print "Enter a col: "
            def col = br.readLine()
            satisfy = false

            while (!satisfy) {
                while (!col.isInteger()) {
                    print "Please enter an integer: "
                    col = br.readLine()
                }
                col = col.toInteger()
                if (col in 0..4) {
                    satisfy = true
                } else {
                    print "Please enter a number between 0 and 4: "
                    col = br.readLine()
                }
            }

            boolean validMove = board.addChecker(this.type, row, col)
            if (validMove) {
                break
            } else {
                println "This slot is already taken! Please re-enter"
            }
        }

        boolean winner = board.isWinner(this.type)
        return winner
    }

    String getName() {
        return name
    }

    String getType() {
        return type
    }

    static void main(String[] args) {

    }
}
