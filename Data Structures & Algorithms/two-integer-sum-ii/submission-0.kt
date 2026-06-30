class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var left = 0
        var right = numbers.size - 1

        while (left < right) {
            if (numbers[left] + numbers[right] < target) {
                left += 1
            } else if (numbers[left] + numbers[right] > target) {
                right -= 1
            } else {
                return intArrayOf(left + 1, right + 1)
            }
        }
        return intArrayOf()
    }
}
