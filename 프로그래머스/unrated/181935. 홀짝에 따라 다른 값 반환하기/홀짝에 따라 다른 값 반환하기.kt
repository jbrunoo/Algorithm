class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        if(n % 2 != 0) {
            for(i in 1..n) if(i % 2 != 0) answer += i
        } else {
            for(i in 1..n) if(i % 2 == 0) answer += i * i
        }
        return answer
    }
}