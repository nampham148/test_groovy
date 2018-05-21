class AIPlayer extends Player{
    private int lookahead

    AIPlayer(String name, String type, int lookahead) {
        super(name, type)
        this.lookahead = lookahead
    }

    List evalMove(Board board) {
        def scores = []
        if (lookahead == 1) {
            5.times {row ->
                5.times {col ->
                    if (board.occupied(row, col)) {
                        scores << -1
                    } else {
                        board.addChecker(this.type, row, col)
                        if (board.isWinner(this.type)) {
                            scores << 200
                        } else {
                            scores << (board.openness(row, col) + board.centerness(row, col) + 10)
                        }
                        board.removeChecker(row, col)
                    }
                }
            }
        }
        else {
            5.times {row ->
                5.times {col ->
                    if (board.occupied(row, col)) {
                        scores << -1
                    } else {
                        board.addChecker(this.type, row, col)
                        if (board.isWinner(this.type)) {
                            scores << 200
                            board.removeChecker(row, col)
                        } else {
                            AIPlayer opp = new AIPlayer(null, board.otherType(this.type), lookahead - 1)
                            def opp_score = opp.evalMove(board)
                            if (opp_score.any {item -> item == 200}) {
                                scores << 0
                            } else if (opp_score.every {item -> item <= 0}) {
                                scores << 200
                            } else {
                                scores << (board.openness(row, col) + board.centerness(row, col) + 10)
                            }
                            board.removeChecker(row, col)
                        }
                    }
                }
            }
        }
        //println scores
        return scores
    }

    boolean makeMove(Board board) {
        //get the score eval
        List scores = this.evalMove(board)
        int maxScore = scores.max()
        List possibleMove = []
        scores.eachWithIndex{ item, index ->
            if (item == maxScore) {
                possibleMove << index
            }
        }

        //choose a random move from best moves
        Collections.shuffle possibleMove
        int move = possibleMove[0]
        println(move.intdiv(5) + " " + move.mod(5))

        //make the move
        board.addChecker(this.type, move.intdiv(5), move.mod(5))
        boolean winner = board.isWinner(this.type)
        return winner
    }

}
