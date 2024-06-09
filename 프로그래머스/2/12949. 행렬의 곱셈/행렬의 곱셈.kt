class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        val row = arr1.size
        val col = arr2[0].size
        var answer = Array(row) { IntArray(col) { 0 } }
        
        for(i in 0 until row) {
            for(j in 0 until col) {
                for(k in 0 until arr2.size) {
                  answer[i][j] += arr1[i][k] * arr2[k][j]   
                }
            }
        }
        
        return answer
    }
}