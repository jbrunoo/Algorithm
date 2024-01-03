class Solution {
    fun solution(n: Int, slicer: IntArray, num_list: IntArray): IntArray {
        val (a, b, c) = slicer
        return when(n) {
            1 -> num_list.slice(0..b)
            2 -> num_list.slice(a until num_list.size)
            3 -> num_list.slice(a..b)
            4 -> num_list.slice(a..b step c)
            else -> throw IllegalArgumentException("Invalid value")
        }.toIntArray() // 반환값을 List<Int>일 때, slice가 List<Int>를 반환하니 명시안했는데 .toList()를 쓰지않아서 4번 경우 말고 실행값이 undefined 오류가 남. 원인은 잘 모르겠으나 when절 안에 있어서 그런지 ? 명시적으로 써줘야 할듯 함..
    }
}