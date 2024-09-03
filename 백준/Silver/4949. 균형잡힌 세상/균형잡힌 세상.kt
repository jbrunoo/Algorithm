import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    while(true) {
        val str = readLine()
        val stack = LinkedList<Char>()
        if(str == ".") break

        for(c in str) {
            if(stack.isEmpty() && (c == ']' || c == ')')) {
                stack.add(0, ']')
                break
            }
            if(c == '[' || c == '(') stack.add(0, c)
            else if(c == ']') {
                if(stack.peek() == '[') stack.pop()
                else break
            } else if(c == ')') {
                if(stack.peek() == '(') stack.pop()
                else break
            }
        }

        sb.appendLine(if(stack.isEmpty()) "yes" else "no")
    }

    print(sb)
}

// 열린 건 자유, 닫힌 건 검사 + 닫힌 거 부터 시작도 안됨.