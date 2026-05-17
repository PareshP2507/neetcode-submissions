class Solution {

    private val DELIMETER = "#"

    fun encode(strs: List<String>): String {
        return buildString {
            strs.forEach { str ->
                append(str.length)
                append(DELIMETER)
                append(str)
            }
        }
    }

    fun decode(str: String): List<String> {
        val result = mutableListOf<String>()
        var i = 0
        while (i < str.length) {
            val delimeterIndex = str.indexOf(DELIMETER, i)
            val length = str.substring(i, delimeterIndex).toInt()

            i = delimeterIndex + 1
            val content = str.substring(i, i + length)
            result.add(content)

            i += length
        }
        return result
    }
}
