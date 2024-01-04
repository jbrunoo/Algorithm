class Solution {
    fun solution(numbers: IntArray, n: Int): Int {
        return numbers.fold(0) { acc, i -> if (n >= acc) acc + i else acc }
        // var answer: Int = 0
        // for(num in numbers) {
        //     answer += num
        //     if(answer > n) return answer
        // }
        // return answer
    }
}