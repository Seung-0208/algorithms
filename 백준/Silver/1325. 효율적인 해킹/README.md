# [Silver I] 효율적인 해킹 - 1325 

[문제 링크](https://www.acmicpc.net/problem/1325) 

### 성능 요약

메모리: 306988 KB, 시간: 10992 ms

### 분류

너비 우선 탐색, 깊이 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 3월 11일 23:42:10

### 아이디어

- 신뢰도가 제일 높은 컴퓨터를 해킹했을 때 가장 많은 컴퓨터를 해킹할 수 있다.
- 탐색을 기준으로 생각했을 때 모든 컴퓨터를 시작점으로 두고 경우의 수를 구해야하고 가장 거리가 긴 값을 구해야 하기 때문에 BFS로 접근한다.

