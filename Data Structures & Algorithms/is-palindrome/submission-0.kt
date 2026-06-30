class Solution {
    fun isPalindrome(s: String): Boolean {
        var start = 0
        var end = s.length - 1

        while (start <= end) {
            when {
                !s[start].isLetterOrDigit() -> start += 1
                !s[end].isLetterOrDigit() -> end -= 1
                else -> {
                    if (s[start].lowercase() == s[end].lowercase()) {
                        start += 1
                        end -= 1
                    } else {
                        return false
                    }
                }
            }
        }
        return true
    }
}
