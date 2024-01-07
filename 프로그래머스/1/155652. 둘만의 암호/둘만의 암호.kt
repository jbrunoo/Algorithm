class Solution {
    fun solution(s: String, skip: String, index: Int): String {
        // var stringBuilder = StringBuilder()
        // for(c in s) {
        //     var tmp = c
        //     for(i in 1..index) {
        //         tmp++
        //         if(tmp > 'z') tmp -= 26
        //         while(tmp in skip) {
        //             tmp++
        //             if(tmp > 'z') tmp -= 26
        //         }                    
        //     }
        //     // 1반례. 아스키코드 'z' == 122, 127 넘어간 뒤 -26
        //     // 앞에서 -26 해주면 skip도 -26 해야함 
        //     // for문 안에서 처리
        //     // 2반례. while로 연속된 skip에 대응 
        //     stringBuilder.append(tmp)
        // }
        // return stringBuilder.toString()
        
        var answer: String = ""
        val alphabet = ('a'..'z').filter { it !in skip }
        s.forEach {
            val i = (alphabet.indexOf(it) + index) % alphabet.size
            answer += alphabet[i]
        }
        return answer
    }
}