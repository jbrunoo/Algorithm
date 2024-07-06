fun main() {
    val list = mutableListOf<Int>()

    for(i in 0..9) {
        list.add(readln().toInt())
    }
    
    val mean = list.sum() / 10
    val mode = list.groupBy { it }.maxBy { it.value.size }.key

    println(mean)
    println(mode)
}