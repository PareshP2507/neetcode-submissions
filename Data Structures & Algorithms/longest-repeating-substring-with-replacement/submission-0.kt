class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        // We will be using the sliding-window approach
        var left = 0
        var maxLength = 0

        // We will find the window that contains characters with
        // a most frequency. We'll manage the map for this 
        val map = hashMapOf<Char, Int>()
        for (right in s.indices) {
            // Update the current char freq
            map[s[right]] = map.getOrDefault(s[right], 0) + 1
            val currLength = right - left + 1
            // Finding the value with a mac free
            // This is linear search O(n)
            val currMaxFreq = map.maxByOrNull { it.value }?.value ?: 0
            // If the no. of the other chars are less or equals to the
            // max allowed replacement, we update the maxLength
            if (currLength - currMaxFreq <= k) {
                maxLength = maxOf(maxLength, currLength)
            } else {
                // If not will shift the left pointer and update the remmoved
                // char's freq
                map[s[left]] = (map.getOrDefault(s[left], 0) - 1).coerceAtLeast(0)
                left += 1
            }
        }
        return maxLength
    }
}
