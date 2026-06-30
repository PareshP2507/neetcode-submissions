class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val lengthS1 = s1.length
        val lengthS2 = s2.length
        if (lengthS1 > lengthS2) return false

        val mapS1 = mutableMapOf<Char, Int>()
        val mapS2 = mutableMapOf<Char, Int>()
        for (i in 0 until lengthS1) {
            mapS1[s1[i]] = mapS1.getOrDefault(s1[i], 0) + 1
            mapS2[s2[i]] = mapS2.getOrDefault(s2[i], 0) + 1
        }

        for (i in 0 until lengthS2 - lengthS1) {
            if (mapS1 == mapS2) return true

            val nextChar = s2[i + lengthS1]
            mapS2[nextChar] = mapS2.getOrDefault(nextChar, 0) + 1
            
            val prevChar = s2[i]
            val currCount = mapS2.getOrDefault(prevChar, -1)
            if (currCount == 1) {
                mapS2.remove(prevChar)
            }

            if (currCount > 1) {
                mapS2[prevChar] = currCount - 1
            }
        }
        return mapS1 == mapS2
    }
}
