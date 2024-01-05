class Solution {
    fun solution(num_list: IntArray): Int {
        var answer: Int = 0
        num_list.map { 
            var n = it
            while(n != 1) {
                if(n % 2 == 0) n /= 2
                else n = (n - 1) / 2
                answer++
            } 
        }
        return answer
    }
}