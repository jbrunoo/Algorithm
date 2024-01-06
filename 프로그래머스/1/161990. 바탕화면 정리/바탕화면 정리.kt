class Solution {
    fun solution(wallpaper: Array<String>): IntArray {
        // # 좌표 받아서 최소 x,y 최대 x+1, y+1 찾았음.
        // map 사용했다가 key가 set이라 pair로 받았음.
        var pos: Array<Pair<Int, Int>> = arrayOf()
        for(i in wallpaper.indices) {
            for(j in wallpaper[i].indices) {
                if(wallpaper[i][j] == '#') pos += Pair(i, j)
            }
        }
        return intArrayOf(pos.minOf { it.first }, pos.minOf { it.second }, pos.maxOf { it.first } + 1, pos.maxOf { it.second } + 1)
    }
}