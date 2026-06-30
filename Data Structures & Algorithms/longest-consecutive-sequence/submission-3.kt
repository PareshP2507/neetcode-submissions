class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        var result = 0
        val set = mutableSetOf<Int>()

        // Let's add all the elements into the set
        for (i in nums) {
            set.add(i)
        }

        // First, decide that the current num can be the starting of 
        // a sequence. Which means there no number less than the curr
        for (num in nums) {
            if (set.contains(num) && !set.contains(num - 1)) {
                var curr = num
                var count = 0
                // Check if the next num in the sequence is available
                // If yes, increase the count
                while (set.contains(curr)) {
                    set.remove(curr)
                    curr += 1
                    count += 1
                }
                // Keep the maximum as a result
                result = Math.max(result, count)
            }
        }
        return result
    }
}
