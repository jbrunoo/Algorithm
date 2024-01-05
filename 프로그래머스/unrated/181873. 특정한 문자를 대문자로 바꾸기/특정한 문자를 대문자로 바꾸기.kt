class Solution {
    fun solution(my_string: String, alp: String): String {
        // return my_string.map {
        //     if(it in alp) it.uppercase()
        //     else it
        // }.joinToString("")
        return my_string.replace(alp, alp.uppercase())
    }
}