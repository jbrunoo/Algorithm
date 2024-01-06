class Solution {
    fun solution(myString: String, pat: String) = myString.substring(0 until myString.lastIndexOf(pat) + pat.length)
}