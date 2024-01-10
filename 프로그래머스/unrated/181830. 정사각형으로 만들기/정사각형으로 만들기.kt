import kotlin.math.max
class Solution {
    fun solution(arr: Array<IntArray>): Array<IntArray> {
        // var answer: Array<IntArray> = arr
        // val diff = arr.size - arr[0].size 
        // if(diff > 0) {
        //     for(i in arr.indices) {
        //         answer[i] += IntArray(diff)
        //     }
        // } 
        // else if(diff < 0) {
        //     answer += Array(-diff) { IntArray(arr[0].size) }
        // }
        // return answer
        
        // size를 계산해서 미리 array를 만들고 arr을 붙임.
        // 매우 빠름..
        val max = max(arr.size, arr[0].size)
        val array = Array(max) { IntArray(max) }

        for (i in arr.indices) {
            System.arraycopy(arr[i], 0, array[i], 0, arr[0].size)
        }
        return array
    }
}