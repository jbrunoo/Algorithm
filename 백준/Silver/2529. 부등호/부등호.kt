private lateinit var li: List<String>
private lateinit var ret: MutableList<Int>
private lateinit var visited: BooleanArray
var n = 0
var flag = false
var minRet = ""
var maxRet = ""

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    li = readLine().split(" ")
    val nums = mutableListOf(0,1,2,3,4,5,6,7,8,9)

    visited = BooleanArray(10)
    ret = mutableListOf()

    permutation(0, n+1, true, nums)

    visited = BooleanArray(10)
    ret.clear()

    permutation(0, n+1, false, nums.reversed())

    println(minRet)
    print(maxRet)
}

fun permutation(cnt: Int, depth: Int, isMinFlag: Boolean, nums: List<Int>) {
    if(cnt == depth) {
        if(check()) {
            if(isMinFlag) minRet = ret.joinToString("") else maxRet = ret.joinToString("")
        }
        return
    }

    for(n in nums.indices) {
        if(visited[n]) continue
        ret.add(nums[n])
        visited[n] = true
        permutation(cnt + 1, depth, isMinFlag, nums)
        ret.removeLast()
        visited[n] = false
    }

    return
}

fun check(): Boolean {
    for(i in 0 until n){
        val bool = when(li[i]) {
            "<" -> ret[i] < ret[i+1]
            ">" -> ret[i] > ret[i+1]
            else -> {true}
        }
        if(!bool) return false
    }
    return true
}