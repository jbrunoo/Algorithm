// 피보나치 수열

// 1. 재귀함수 구현
// 2. DP - memoization / caching 활용
// 2-1. top down - 재귀
// 2-2. bottom up - 반복문

// cf. n > 48 -> int overflow
// cf. 분할 정복은 부분 문제 중복 x -> 재사용 x
// ps. 재귀 호출 스택 깊이 이슈 -> 함수형 언어: 꼬리 재귀(TCO 지원) / 파이썬: 재귀 제한 풀면 됨
// cf. 꼬리 재귀 : 값을 반환하므로 함수 호출 스택 쌓지 않고 이전 호출 스택 프레임 재사용으로 최적화

fun main() {
    val memo2 = LongArray(51) { 0 }
    val memo3 = MutableList(51) { 0L }

    println(fibo1(5))
    println(fibo2(50, memo2))
    println(fibo3(50, memo3))
}
// 재귀 활용
fun fibo1(n: Int): Long {
    if(n <= 0) return 0
    if(n == 1) return 1
    return fibo1(n-1) + fibo1(n-2)
}

// 값 재사용. top-down: n부터 아래로 재귀
fun fibo2(n: Int, memo: LongArray): Long {
    memo[0] = 0
    memo[1] = 1
    if(memo[n] == 0L && n != 0) {
        memo[n] = fibo2(n-1, memo) + fibo2(n-2, memo)
    }
    return memo[n]
}
// 값 재사용. bottom-up: 2부터 n까지 반복
fun fibo3(n: Int, memo: MutableList<Long>): Long {
    memo[0] = 0
    memo[1] = 1
    for(i in 2..n) {
        memo[i] = memo[i-1] + memo[i-2]
    }
    return memo[n]
}
