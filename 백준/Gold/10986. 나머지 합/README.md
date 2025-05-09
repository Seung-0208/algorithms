# [Gold III] 나머지 합 - 10986 

[문제 링크](https://www.acmicpc.net/problem/10986) 

### 성능 요약

메모리: 345012 KB, 시간: 2072 ms

### 분류

수학, 누적 합

### 제출 일자

2025년 1월 28일 18:37:36

### 아이디어
*  `(a+b) % m==(a % m) + (b % m)` 과 같다. → 우선 누적합 배열을 구해서 배열 각각의 원소들이 m으로 나누어 떨어지는지 확인해보면 된다.
*  앞선 문제와 같이 구간합을 구하는 공식은 S[i]-S[j]이다. 이때 `(S[i]-S[j]) % m == (S[i] % m) - (S[j] % m)`
*  => 따라서, S[i], S[j] 각각이 m으로 나누어 떨어지지 않더라도 나머지 값만 같다면 i부터 j까지의 구간합은 m으로 나누어 떨어지는 것이다.
* ⚠️ 누적합 배열에서 나머지 값이 같은 원소를 찾기 위해 반복문을 돌 때, 앞에서 나머지 값이 0인 원소의 개수를 찾았다고 하더라도 0부터 M-1까지 돌아야 한다!!
