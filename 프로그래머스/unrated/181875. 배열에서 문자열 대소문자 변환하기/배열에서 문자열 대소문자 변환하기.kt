class Solution {
    fun solution(strArr: Array<String>): Array<String> {
        // return strArr.indices.map {
        //     if(it % 2 == 0) strArr[it].lowercase()
        //     else strArr[it].uppercase()
        // }.toTypedArray()
        // mapIndexed 가 훨씬 빠름
        return strArr.mapIndexed { i, v ->
            if(i % 2 == 0) v.lowercase()
            else v.uppercase()
        }.toTypedArray()
    }
}