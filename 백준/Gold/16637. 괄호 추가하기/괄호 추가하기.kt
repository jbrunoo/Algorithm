import kotlin.math.max
private lateinit var nums: IntArray
private lateinit var operators: CharArray
private var ret = Int.MIN_VALUE

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    nums = IntArray(n/2+1)
    operators = CharArray(n/2)

    for((i, c) in readLine().withIndex()) {
        if(i % 2 == 0) nums[i/2] = c.digitToInt()
        else operators[i/2] = c
    }

    print(dfs(0, nums[0]))
}

fun dfs(idx: Int, total: Int): Int {
    if(idx == nums.size - 1) {
        ret = max(ret, total)
        return ret
    }

    val tmp1 = oper(total, operators[idx], nums[idx+1])
    dfs(idx + 1, tmp1)

    if(idx + 2 <= nums.size - 1) {
        val next = oper(nums[idx+1], operators[idx+1], nums[idx+2])
        val tmp2 = oper(total, operators[idx], next)
        dfs(idx + 2, tmp2)
    }

    return ret
}

fun oper(num1: Int, operator: Char, num2: Int): Int {
    return when(operator) {
        '+' -> num1 + num2
        '-' -> num1 - num2
        else -> num1 * num2
    }
}