class Solution {
    fun solution(babbling: Array<String>): Int {
        // var sentence = arrayOf<String>("aya", "ye", "woo", "ma")
        // return babbling.map { b ->
        //     sentence.fold(b) {acc, word ->
        //         acc.replace(word, " ")
        //     }
        // }.filter { it.isBlank() }.count()
        
        var re = "aya|ye|woo|ma".toRegex()
        return babbling.map { it.replace(re, "") }.count { it.isEmpty() } // blank는 empty보다 오래걸림
    }
}