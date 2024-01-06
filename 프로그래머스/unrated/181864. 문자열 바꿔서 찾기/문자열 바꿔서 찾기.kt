class Solution {
    fun solution(myString: String, pat: String): Int {
        var s = StringBuilder(myString)
       for(i in s.indices) {
           if(s[i] == 'A') s[i] = 'B'
           else s[i] = 'A'
       }
       return if(s.contains(pat)) 1 else 0
    }
}