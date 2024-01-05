class Solution {
    fun solution(myString: String): String {
        return myString.map {
            if(it in "aA") it.uppercase()
            else it.lowercase()
        }.joinToString("")
    }
}