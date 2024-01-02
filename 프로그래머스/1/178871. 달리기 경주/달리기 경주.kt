class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        val playerMap = mutableMapOf<String, Int>()

        for((i, str) in players.withIndex()) {
            playerMap[str] = i
        }
        for(calling in callings) {
            val idx = playerMap[calling] ?: continue
            val tmp = players[idx - 1]
            players[idx - 1] = calling
            players[idx] = tmp
            
            playerMap[calling] = idx - 1
            playerMap[tmp] = idx
            
        }
        return players
    }
}