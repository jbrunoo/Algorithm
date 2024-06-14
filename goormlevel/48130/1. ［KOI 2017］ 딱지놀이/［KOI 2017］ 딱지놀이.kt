fun main(args: Array<String>) {
	val N = readLine()!!.toInt()
	
	val arr = Array(2 * N) { IntArray(100) }
	
	for(i in 0 until 2 * N) {
		arr[i] = readLine()!!.split(" ").map {it.toInt()}.toIntArray()
	}
	
	for(i in 0 until N) {
		val A = arr[i * 2].toMutableList()
		val B = arr[i * 2 + 1].toMutableList()
		A.removeFirst()
		B.removeFirst()
		
		if(A.calcCnt(4) > B.calcCnt(4)) println("A")
		else if(A.calcCnt(4) < B.calcCnt(4)) println("B")
		else if(A.calcCnt(3) > B.calcCnt(3)) println("A")
		else if(A.calcCnt(3) < B.calcCnt(3)) println("B")
		else if(A.calcCnt(2) > B.calcCnt(2)) println("A")
		else if(A.calcCnt(2) < B.calcCnt(2)) println("B")
		else if(A.calcCnt(1) > B.calcCnt(1)) println("A")
		else if(A.calcCnt(1) < B.calcCnt(1)) println("B")
		else println("D")
	}
	println("")
}

fun List<Int>.calcCnt(n: Int): Int {
	return this.count { it == n }
}