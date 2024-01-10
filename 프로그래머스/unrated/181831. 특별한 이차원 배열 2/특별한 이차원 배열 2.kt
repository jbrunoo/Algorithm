class Solution {
    fun solution(arr: Array<IntArray>): Int {
        for(i in 0 until arr.size/2 + 1) {
            for(j in 0 until arr.size/2 + 1) {
                if(arr[i][j] == arr[j][i]) continue
                else return 0
            }
        }
        return 1
    }
}