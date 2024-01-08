class Solution {
    fun solution(arr1: IntArray, arr2: IntArray): Int {
        var answer: Int = 0
        if(arr1.size > arr2.size) answer = 1
        else if(arr1.size < arr2.size) answer = -1
        else {
            if(arr1.sum() > arr2.sum()) answer = 1
            else if(arr1.sum() < arr2.sum()) answer = -1
            else answer = 0
        }
        return answer
    }
}