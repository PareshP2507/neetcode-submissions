class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rowSetList = mutableListOf<MutableSet<Char>>()
        val colSetList = mutableListOf<MutableSet<Char>>()
        val subMatSetList = mutableListOf<MutableSet<Char>>()

        val rows = board.size
        val cols = board[0].size
        
        repeat(rows) {
            rowSetList.add(mutableSetOf<Char>())
            colSetList.add(mutableSetOf<Char>())
            subMatSetList.add(mutableSetOf<Char>())
        }

        for(i in 0 until rows) {
            for(j in 0 until cols) {
                val item = board[i][j]

                if (item == '.') continue

                val rowSet = rowSetList[i]
                if (rowSet.add(item) == false) {
                    return false
                }

                val colSet = colSetList[j]
                if (colSet.add(item) == false) {
                    return false
                }

                val subMatIndex = (i / 3) + (j / 3) * 3
                val subMatSet = subMatSetList[subMatIndex]
                if (subMatSet.add(item) == false) {
                    return false
                }
            }
        }

        return true
    }
}
