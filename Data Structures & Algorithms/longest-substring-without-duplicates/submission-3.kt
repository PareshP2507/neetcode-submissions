class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var left = 0
        var maxLength = 0

        val map = hashMapOf<Char, Int>()
        for (right in s.indices) {
            if (map.containsKey(s[right])) {
                left = maxOf(left, map.get(s[right])!! + 1)
            }

            map[s[right]] = right
            maxLength = maxOf(maxLength, right - left + 1)
        }
        return maxLength
    }
}
