class Solution {
    fun solution(str_list: Array<String>): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        for(c in str_list.indices) {
            if(str_list[c] == "l") {
                answer = str_list.take(c).toTypedArray()
                break
            }
            else if(str_list[c] == "r") {
                answer = str_list.drop(c+1).toTypedArray()
                break
            }
        }
        return answer
    }
}