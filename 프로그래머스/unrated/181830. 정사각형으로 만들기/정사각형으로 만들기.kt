class Solution {
    fun solution(arr: Array<IntArray>): Array<IntArray> {
        var answer: Array<IntArray> = arr
        val diff = arr.size - arr[0].size 
        if(diff > 0) {
            for(i in arr.indices) {
                answer[i] += IntArray(diff)
            }
        } 
        else if(diff < 0) {
            answer += Array(-diff) { IntArray(arr[0].size) }
        }
        return answer
    }
}