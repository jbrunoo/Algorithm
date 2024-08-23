fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine()
    var str = readLine()

    while("PS4" in str || "PS5" in str) {
        str = str.replace("PS4", "PS")
        str = str.replace("PS5", "PS")
    }
    print(str)
}