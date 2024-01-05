class Solution {
    fun solution(strArr: Array<String>): Array<String> {
        return strArr.indices.map {
            if(it % 2 == 0) strArr[it].lowercase()
            else strArr[it].uppercase()
        }.toTypedArray()
    }
}