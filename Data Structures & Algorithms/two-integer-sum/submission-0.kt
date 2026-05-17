class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val set = mutableMapOf<Int, Int>()
        for ((index, num) in nums.withIndex()) {
            val compliment = target - num
            if (set.contains(compliment)) {
                return intArrayOf(set[compliment]?:0, index)
            } else {
                set[num] = index
            }
        }
        return intArrayOf(0, 0)
    }
}
