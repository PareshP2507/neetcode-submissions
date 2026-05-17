class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for (num in nums) {
            map.put(num, map.getOrDefault(num, 0) + 1)
        }
        val sortedList = map.entries.sortedByDescending { it.value }
        return sortedList.take(k).map { it.key }.toIntArray()
    }
}
