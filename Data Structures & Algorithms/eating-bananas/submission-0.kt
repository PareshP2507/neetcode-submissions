class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var high = piles.maxOrNull() ?: 1
        var result = high
        
        var low = 1 // Min speed of eating banana 1 banana/hour
        // Now that we have range defined (low, high), let's do a binary search
        // to find the miniumum speed at which the banana can be eaten
        while (low <= high) {
            val mid = low + (high - low) / 2
            if (canItAll(piles, mid, h)) {
                high = mid - 1
                result = mid // This could be the optimal solution but let's keep looking
            } else {
                low = mid + 1
            }
        }
        
        return result
    }

    private fun canItAll(piles: IntArray, speed: Int, h: Int): Boolean {
        var totalHours = 0
        for (pile in piles) {
            totalHours += (pile + speed - 1) / speed
        }
        return totalHours <= h
    }
}
