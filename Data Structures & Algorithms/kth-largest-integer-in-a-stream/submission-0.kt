class KthLargest(k: Int, nums: IntArray) {

    private val capacity: Int
    private val queue = PriorityQueue<Int>()

    init {
        capacity = k
        for (num in nums) {
            queue.offer(num)
        }
    }

    fun add(`val`: Int): Int {
        queue.offer(`val`)

        while (queue.size > capacity) {
            queue.poll()
        }

        return queue.peek()
    }
}
