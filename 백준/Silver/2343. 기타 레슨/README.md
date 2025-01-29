# [Silver I] 기타 레슨 - 2343 

[문제 링크](https://www.acmicpc.net/problem/2343) 

### 성능 요약

메모리: 24088 KB, 시간: 296 ms

### 분류

이분 탐색, 매개 변수 탐색

### 제출 일자

2025년 1월 29일 18:42:59

### 아이디어
* start값을 주어진 강의들 중 최댓값, end값을 모든 강의의 합으로 두고 그 사이에서 적절한 값을 찾는 과정을 이진 탐색으로 구한다
* 코드를 그림으로 이해하면 다음과 같다
* ![image](https://github.com/user-attachments/assets/ec10ed20-9ce5-48fb-b27b-8f3b60e2a664)
* 블루레이에는 모든 강의가 포함되어야 하기 때문에 end값이 아닌 start값으로 답을 도출한다


