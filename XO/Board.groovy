class Board {
    private List board = []
    private int occupied
    private String type1
    private String type2

    Board(String type1, String type2) {
        5.times {
            board += [[" "] * 5]
        }
        occupied = 0
        this.type1 = type1
        this.type2 = type2
    }

    String otherType(String type) {
        if (type == type1) {
            return type2
        } else if (type == type2) {
            return type1
        } else {
            return null
        }
    }

    String toString() {
        String ret = ""
        def count = 0
        board.each{row ->
            ret += count.toString().center(3) + "|"
            row.each{item ->
                ret += item.center(3)
                ret += "|"
            }
            ret += "\n"
            count++
        }
        ret += "    "
        board[0].size().times{
            ret += it.toString().center(3) + " "
        }
        return ret
    }

    boolean addChecker(String type, int row, int col) {
        if (board[row][col] != " ") {
            println "Slot is occupied"
            return false
        }

        board[row][col] = type
        occupied++
        return true
    }

    boolean removeChecker(int row, int col){
        if (board[row][col] == " ") {
            println "Slot is empty"
            return false
        }
        board[row][col] = " "
        occupied--
        return true
    }

    boolean isWinner(String type) {
        def condition = type * 4
        def check

        //check rows
        for (row in board) {
            if (row.join("").contains(condition)){
                return true
            }
        }

        //check cols
        for (it in 0..4){
            check = ""
            for (int i = 0; i < 5; i++) {
                check += board[i][it]
            }

            if (check.contains(condition)) {
                return true
            }
        }

        //check top left - down right diagonals
        for (i in -1..1) {
            check = ""
            def row, col
            if (i >= 0) {
                col = i
                row = 0
            } else {
                col = 0
                row = -i
            }

            while (row < 5 && col < 5) {
                check += board[row][col]
                row++; col++
            }
            if (check.contains(condition)) {
                return true
            }
        }

        //check top right - down left diagonals
        for (i in 3..5) {
            check = ""
            def row, col
            if (i < 5) {
                row = 0
                col = i
            } else {
                col = 4
                row = i - col
            }

            while (col >= 0 && row < 5) {
                check += board[row][col]
                col--; row++
            }
            if (check.contains(condition)) {
                return true
            }
        }

        return false

    }

    boolean isFull() {
        return occupied >= 25
    }

    int centerness(int row, int col) {
        if (row == 2 && col == 2) {
            return 20
        } else if (row in 1..3 && col in 1..3) {
            return 10
        } else {
            return 0
        }
    }

    int openness (int row, int col) {
        int lowRow = Math.max(row - 1, 0)
        int highRow = Math.min(row + 1, 4)
        int lowCol = Math.max(col - 1, 0)
        int highCol = Math.min(col + 1, 4)
        int count = 0

        for (i in lowRow..highRow) {
            for (j in lowCol..highCol) {
                if (this.board[i][j] == " ") {
                    count += 10
                }
            }
        }

        return count

    }

    boolean occupied (int row, int col) {
        return (board[row][col] != " ")
    }

    static void main (String[] args) {
        Board a = new Board()
        println a
        println a.isWinner("o")
    }

}
