class Solution {
    fun solution(absolutes: IntArray, signs: BooleanArray): Int {
        var sum = 0
        signs.mapIndexed {i, v ->
            if(v) sum += absolutes[i]
            else sum -= absolutes[i]
        }
        return sum
    }
}