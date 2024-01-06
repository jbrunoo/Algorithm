class Solution {
    fun solution(myString: String, pat: String): String {
        return myString.trimEnd { it !in pat }

    }
}