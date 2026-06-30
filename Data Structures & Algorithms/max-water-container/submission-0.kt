class Solution {
    fun maxArea(heights: IntArray): Int {
        var result = 0
        var leftPointer = 0
        var rightPointer = heights.size - 1

        while (leftPointer < rightPointer) {
            // The capacity of container would be width * height
            // Between both bars, the bar with a lower height will be taken,
            // because the water would be overflowed otherwise
            val width = rightPointer - leftPointer
            val height = min(heights[leftPointer], heights[rightPointer])
            val storageCapacity = width * height
            result = max(storageCapacity, result)

            // Find the optimal height
            if (heights[leftPointer] < heights[rightPointer]) {
                leftPointer += 1
            } else {
                rightPointer -= 1
            }
        }
        return result
    }
}
