import kotlin.math.max

private lateinit var dp: Array<Array<IntArray>>

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i():Int{nextToken();return nval.toInt()}
    val arr = IntArray(3)
    repeat(i()) { arr[it] = i() }
    dp = Array(61) { Array(61) { IntArray(61) { -1 } } }
    dp[0][0][0] = 0

    print(attack(arr[0], arr[1], arr[2]))
}

fun attack(scv1: Int=0, scv2: Int=0, scv3: Int=0): Int {
    val x = max(scv1, 0)
    val y = max(scv2, 0)
    val z = max(scv3, 0)

    if (dp[x][y][z] != -1) return dp[x][y][z]

    dp[x][y][z] = minOf(
        attack(x - 9, y - 3, z - 1) + 1,
        attack(x - 9, y - 1, z - 3) + 1,
        attack(x - 3, y - 9, z - 1) + 1,
        attack(x - 3, y - 1, z - 9) + 1,
        attack(x - 1, y - 9, z - 3) + 1,
        attack(x - 1, y - 3, z - 9) + 1
    )

    return dp[x][y][z]
}