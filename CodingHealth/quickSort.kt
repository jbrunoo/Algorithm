// 퀵 정렬 (시간복잡도 - 최선: nlogn, 평균: nlogn, 최악: n^2)
// pivot 설정 (위치는 상관 없으나 정렬되어 있을 경우 양 끝 인덱스라면 최악이 나올 수 있으니 중간 값 설정)
// 분할 정복 기법 (재귀로 구현)
// pivot 기준으로 리스트를 나누고 다시 합치면서 정렬

fun main() {
    val list = listOf(3, 5, 6, 4, 2, 8, 1, 7)
    println(quickSort(list))
}

fun quickSort(list: List<Int>): List<Int> {
    if(list.size < 2) return list

    val pivot = list[list.size / 2]
    val left = list.filter { it < pivot }
    val right = list.filter { it > pivot }

    return quickSort(left) + pivot + quickSort(right)
}
