import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val st = StringTokenizer(readLine())
    val arr = IntArray(n) { st.nextToken().toInt() }

    val answer = selectionSort(arr, k)
    if(answer != Pair(0, 0)) println("${answer.first} ${answer.second}")
    else println(-1)

}

fun selectionSort(arr: IntArray, k: Int): Pair<Int, Int> {
    var cnt = 0
    var result = Pair(0, 0)
    for(last in arr.size - 1 downTo 1) {
        var maxIndex = 0
        for(i in 0..last) {
            if(arr[maxIndex] < arr[i]) maxIndex = i
        }

        if(last != maxIndex) {
            arr[last] = arr[maxIndex].also { arr[maxIndex] = arr[last] }
            cnt++
            if(cnt == k) result = Pair(arr[maxIndex], arr[last])
        }
    }

    return result
}
