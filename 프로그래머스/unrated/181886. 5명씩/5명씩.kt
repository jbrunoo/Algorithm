class Solution {
    fun solution(names: Array<String>): Array<String> {
        return names.filterIndexed {i, name -> i % 5 == 0 }.toTypedArray()
    }
}