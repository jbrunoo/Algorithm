fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        val s = readLine()
        if (s == "#") break
        val alphabet = IntArray(26)

        for (c in s) {
            if (c in 'a'..'z') alphabet[c - 'a']++
            else if(c in 'A'..'Z') alphabet[c - 'A']++
        }

        println(alphabet.count { it != 0 })
    }
}