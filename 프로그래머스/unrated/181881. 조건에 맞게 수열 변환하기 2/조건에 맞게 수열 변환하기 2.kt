class Solution {
    fun solution(arr: IntArray): Int {
        var answer: Int = 0
        var intArray: IntArray = arr
        var temp: IntArray = intArrayOf()
        while(true) {
            temp = intArray
            intArray = intArray.map {
                if(it >= 50 && it % 2 == 0) it / 2
                else if(it < 50 && it % 2 != 0) it * 2 + 1
                else it
            }.toIntArray()
            answer++
            // println(temp.contentToString()) // joinToString || contentToString 출력크기초과때문에 주석처리
            if(intArray.contentEquals(temp)) break // collection == 가능. intArray는 contentEquals
        }
        return answer - 1
    }
}