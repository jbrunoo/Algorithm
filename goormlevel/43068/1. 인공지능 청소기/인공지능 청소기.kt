import kotlin.math.abs
fun main(args: Array<String>) {
	val N = readLine()!!.toInt()
	val arr = Array(N) { IntArray(3) }
	
	for(i in 0 until arr.size) {
		arr[i] = readLine()!!.split(" ").map{it.toInt()}.toIntArray()
	}
	
	for((x, y, n) in arr) {
		val distance = abs(x) + abs(y)
		if(distance <= n && n % 2 == distance % 2) println("YES")
		else println("NO")
	}
	
}