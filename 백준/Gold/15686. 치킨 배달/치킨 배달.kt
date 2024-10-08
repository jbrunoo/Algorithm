import kotlin.math.abs
import kotlin.math.min

private lateinit var chicken: MutableList<Pos>
private lateinit var house: MutableList<Pos>
private lateinit var chosen_chicken: MutableList<Pos>
private lateinit var chosen_chickens: MutableList<List<Pos>>
private var m: Int = 0

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int { nextToken();return nval.toInt() }
    val n = i(); m = i(); chicken = mutableListOf(); house = mutableListOf()

    for (i in 1..n) {
        for (j in 1..n) {
            when (i()) {
                1 -> house += Pos(i, j)
                2 -> chicken += Pos(i, j)
            }
        }
    }

    chosen_chicken = mutableListOf(); chosen_chickens = mutableListOf()
    chooseChickenPos(depth = m)

    println(calcCityChickenDistance())
}

fun chooseChickenPos(cnt: Int = 0, begin: Int = 0, depth: Int) {
    if (cnt == depth) {
        chosen_chickens.add(chosen_chicken.toList())
        return
    }

    for (i in begin until chicken.size) {
        chosen_chicken.add(chicken[i])
        chooseChickenPos(cnt + 1, i + 1, depth)
        chosen_chicken.remove(chicken[i])
    }
}

fun calcCityChickenDistance(): Int {
    val chickenDistances = mutableListOf<Int>()
    var minCityChickenDistance = Int.MAX_VALUE
    var currentCityChickenDistance = 0

    chosen_chickens.forEach { cPositions ->
            house.forEach { hPos ->
                cPositions.forEach { cPos ->
                    chickenDistances += abs(hPos.x - cPos.x) + abs(hPos.y - cPos.y)
                }
                currentCityChickenDistance += chickenDistances.min()
                chickenDistances.clear()
            }
            minCityChickenDistance = min(minCityChickenDistance, currentCityChickenDistance)
            currentCityChickenDistance = 0
        }

    return minCityChickenDistance
}

data class Pos(val x: Int = 0, val y: Int = 0)