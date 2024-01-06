class Solution {
    fun solution(my_string: String): Array<String> {
        return my_string.split(" ").filter { it.isNotBlank() }.toTypedArray()
        // var s = StringBuilder()
        // var answer = arrayOf<String>()
        // for(i in my_string.trim()) {
        //     if(i != ' ') s.append(i)
        //     else {
        //         if(s.isNotEmpty()) {
        //             answer += s.toString()
        //             s.clear()
        //         }
        //         else continue
        //     }
        // }
        // answer += s.toString()
        // return answer
    }
}