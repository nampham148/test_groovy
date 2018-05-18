class Board {
    private List board

    Board() {
        board = [[" "] * 5] * 5
    }

    String toString() {
        String ret = ""
        board.each{row ->
            row.each{item ->
                ret += item.center(3)
                ret += "|"
            }
            ret += "\n"
        }
        board[0].size().times{
            ret += it.toString().center(3) + " "
        }
        return ret
    }

    void addChecker(String type, int row, int col) {
        board[row][col] = type
    }

    String getChecker(int row, int col) {
        return board[row][col]
    }

    static void main (String[] args) {
        Board a = new Board()
        println a
        a.addChecker("x", 0, 3)
        println a
        for (int i = 0; i < 5; i++) {
            println a.getChecker(i, 3)
        }
    }


}
