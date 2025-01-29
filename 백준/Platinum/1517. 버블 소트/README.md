# [Platinum V] 버블 소트 - 1517 

[문제 링크](https://www.acmicpc.net/problem/1517) 

### 성능 요약

메모리: 73288 KB, 시간: 496 ms

### 분류

자료 구조, 분할 정복, 세그먼트 트리, 정렬

### 제출 일자

2025년 1월 29일 16:11:07

### 아이디어
* 주어진 배열을 middle값을 기준으로 반으로 나누었을 때 아래의 그림과 같이 오른쪽에 있는 배열의 원소 값이 더 작아서 먼저 위치시킬 경우 이는 버블 정렬에서 swap이 발생한 것과 같다고 봐도 된다.
* ![image](https://github.com/user-attachments/assets/21fd13f1-e7bb-4d0a-b8af-0d5aac2d91b8)
* swap의 횟수를 구할 때 start와 end값은 분할 정복 때마다 달라지기 때문에 k값과 idx2값을 기준으로 구해야 한다.


