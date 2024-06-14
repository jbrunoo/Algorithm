import kotlin.math.floor
fun main(args: Array<String>) {
	val (N, M) = readLine()!!.split(" ").map { it.toInt() }
	
	val salt = N * 0.07
	val water = N + M
	val result = salt / water * 100

	print(String.format("%.2f", floor(result*100)/100))
}