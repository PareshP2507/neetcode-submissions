class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val res = IntArray(nums.size)
        res[0] = 1
        for (i in 1 until nums.size) {
            res[i] = nums[i - 1] * res[i - 1]
        }
        
        var rightSideProduct = 1
        for (i in nums.size - 1 downTo 0) {
            res[i] = res[i] * rightSideProduct
            rightSideProduct *= nums[i]
        }
        
        return res
    }
}
