class Solution {
    fun solution(str_list: Array<String>, ex: String) = str_list.filter { !it.contains(ex) }.joinToString("")
}