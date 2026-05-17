class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val letterCountMap = HashMap<Char, Int>()
        for (char in s) {
            letterCountMap.put(char, letterCountMap.getOrDefault(char, 0) + 1)
        }

        for (char in t) {
            letterCountMap.put(char, letterCountMap.getOrDefault(char, 0) - 1)
        }

        for (entry in letterCountMap.entries) {
            if (entry.value != 0) {
                return false
            }
        }
        return true
    }
}
