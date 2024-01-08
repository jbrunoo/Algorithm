class Solution {
    fun solution(babbling: Array<String>): Int {
        var sentence = arrayOf<String>("aya", "ye", "woo", "ma")
        // 조합 14가지 경우의 수 list에 담아서 비교 이런건..?
        // fold의 재발견
        return babbling.map { b ->
            sentence.fold(b) {acc, word ->
                acc.replace(word, " ") // ""로 하면 반례 wyeoo x
            }
        }.filter { it.isBlank() }.count()
    }
}