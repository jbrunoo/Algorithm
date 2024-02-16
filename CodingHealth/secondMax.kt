// list에서 2번째로 큰 값 찾기
// max, secondMax 초기화
// list 순회하면서 value와 max 비교
// value > max -> secondMax = max, max = value (max 값을 먼저 할당하지 않도록 주의)
// secondMax < value < max -> secondMax = value

fun main() {
    val list = listOf(5, 1, 52, 57, 13, 53)
    println(secondMax(list))
    println(nMax(list, 2))
}

fun secondMax(list: List<Int>): Int {
    var max = Int.MIN_VALUE
    var secondMax = Int.MIN_VALUE
    list.forEach { value ->
        if(value > max) {
            secondMax = max
            max = value
        }
        else if(value in (secondMax + 1) until max) { // IDE에서 Two comparisons should be converted to a range check 
            secondMax = value
        }
    }
    // std exception class : RuntimeException, IllegalArgumentException, IllegalStateException, NoSuchElementException
    if(secondMax == Int.MIN_VALUE) throw NoSuchElementException("secondMax non-exist")

    return secondMax
}

// cf
// n번째 큰 값
// 내림차순 정렬 구현한 후 index 접근
// list size 체크
// ps. 중복 값 제거 toSet, distinct, groupBy 등
fun nMax(list: List<Int>, n: Int) = if(list.size >= n) list.sortedDescending()[n-1] else null
