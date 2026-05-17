class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        return strs.groupBy { string: String -> 
                string.toCharArray().sorted().joinToString("") 
            }
            .values
            .toList()
    }
}
