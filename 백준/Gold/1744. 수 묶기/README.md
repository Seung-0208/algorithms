# [Gold IV] 수 묶기 - 1744 

[문제 링크](https://www.acmicpc.net/problem/1744) 

### 성능 요약

메모리: 14256 KB, 시간: 112 ms

### 분류

많은 조건 분기, 그리디 알고리즘, 정렬

### 제출 일자

2025년 1월 13일 23:47:14

### 아이디어

처음 문제를 풀었을 때 아래의 조건들을 고려하지 못함
* 음수끼리 곱하면 양수가 됨 (이 경우 가장 작은 음수끼리 곱해야 가장 큰 값을 만들 수 있음)
* 1과 어떤 양수 a를 곱하면 항상 a가 나오기 때문에 1은 그냥 더해주는 게 더 큰 값을 만들 수 있음

