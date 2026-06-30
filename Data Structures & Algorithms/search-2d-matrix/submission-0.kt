class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val m = matrix.size
        val n = matrix[0].size

        for (i in 0..m-1) {
            val currRow = matrix[i]
            if (currRow.isNotEmpty()) {
                if (currRow[0] == target) {
                    return true
                }
                if (currRow.size > 1 && currRow[currRow.size - 1] == target) {
                    return true
                }
                if (currRow[0] < target && currRow[currRow.size - 1] > target) {
                    // do a binary search
                    var low = 0
                    var high = currRow.size - 1
                    while (low <= high) {
                        val mid = low + (high - low) / 2
                        when {
                           target == currRow[mid] -> return true 
                           target < currRow[mid] -> high = mid - 1
                           else -> low = mid + 1
                        }
                    }
                }
            }
        }
        return false
    }
}
