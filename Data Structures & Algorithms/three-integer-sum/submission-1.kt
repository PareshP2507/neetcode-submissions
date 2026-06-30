class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()

        val result = mutableSetOf<List<Int>>()
        for (i in 0 until nums.size) {
            val seenSet = hashSetOf<Int>()
            for (j in i + 1 until nums.size) {
                val complement = -(nums[i] + nums[j])
                if (seenSet.contains(complement)) {
                    result.add(listOf(nums[i], nums[j], complement))
                }
                seenSet.add(nums[j])
            }
        }
        return result.toList()
    }
}
