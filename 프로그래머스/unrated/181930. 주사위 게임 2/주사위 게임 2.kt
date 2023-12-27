class Solution {
    fun solution(a: Int, b: Int, c: Int): Int {
        if(a == b && b == c) {
            return 27*a*a*a*a*a*a
        } else if(a!=b && b!=c && c!=a) {
            return a+b+c
        } else {
            return (a+b+c)*(a*a+b*b+c*c)
        }
    }
}