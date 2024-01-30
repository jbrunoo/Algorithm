// 인접한 원소끼리 비교. 한 사이클 후 가장 큰 원소 마지막 인덱스 위치.
// 4 3 2 5 1 init
// 3 4 2 5 1
// 3 2 4 5 1
// 3 2 4 5 1
// 3 2 4 1 5
// 2 3 4 1 5
// 2 3 4 1 5
// 2 3 1 4 5
// 2 3 1 4 5
// 2 1 3 4 5
// 1 2 3 4 5

fun main() {
    val arr = intArrayOf(4, 3, 2, 5, 1)
    bubbleSort(arr)
}

fun bubbleSort(arr: IntArray): IntArray {
    for(i in 1 until arr.size) {
        for(j in 0 until arr.size - i) {
            if (arr[j] > arr[j + 1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
            println(arr.contentToString())
        }
    }
    return arr
}
