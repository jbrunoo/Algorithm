import java.io.StreamTokenizer
import kotlin.math.min

fun main()=StreamTokenizer(System.`in`.bufferedReader()).run {
    fun l():Long{nextToken();return nval.toLong()}
    val n = l()
    val arr = LongArray(6) {l()}

    val nums = listOf(min(arr[0], arr[5]), min(arr[1], arr[4]), min(arr[2], arr[3])).sorted()

    val sum = when (n) {
        1L -> arr.sum()-arr.max()
        2L -> nums[0] * 8 + nums[1] * 8 + nums[2] * 4
        else -> {
            val f = nums[0] * (5 * n * n - 8 * n + 4)
            val s = nums[1] * 8 * (n-1)
            val t = nums[2] * 4
            f+s+t
        }
    }
    print(sum)
}