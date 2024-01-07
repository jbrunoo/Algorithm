import java.util.Stack
class Solution {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var answer = "Yes"
        var stack1 = Stack<String>()
        var stack2 = Stack<String>()

        for (i in cards1.size - 1 downTo 0) {
            stack1.push(cards1[i])
        }
        for (i in cards2.size - 1 downTo 0) {
            stack2.push(cards2[i])
        }
        // 또는 val idx1, idx2로 idx++해서 idx1, 2 < cards1, 2.size로 검사
        for(s in goal) {
            if(stack1.isNotEmpty() && s == stack1.peek()) stack1.pop()
            else if(stack2.isNotEmpty() && s == stack2.peek()) stack2.pop()
            else {
                answer = "No"
                break
            }
        }

        return answer
    }
}