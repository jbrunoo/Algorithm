import java.util.*

class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = intArrayOf()
        var cnt = 0
        val stack = Stack<Int>()
        
        progresses.reversed().forEach {
            stack.push(it)
        }
        
        while(!stack.empty()) {
            while(!stack.empty() && stack.peek() >= 100) {
                stack.pop()
                cnt++
            }
            if(cnt != 0) answer += cnt
            cnt = 0
            stack.mapIndexed { i, v ->
                stack[i] += speeds.reversed()[i]
            }
        }
        
        return answer
    }
}