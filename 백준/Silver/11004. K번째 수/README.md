# [Silver V] K번째 수 - 11004 

[문제 링크](https://www.acmicpc.net/problem/11004) 

### 성능 요약

메모리: 368676 KB, 시간: 1052 ms

### 분류

정렬

### 제출 일자

2024년 9월 27일 03:27:11

### 아이디어
* Quick Sort 문제의 정석
* 가운데에 있는 값을 pivot으로 잡고 pivot을 기준으로 왼쪽에는 작은 값, 오른쪽에는 큰 값으로 나열 => findPivot 함수
* pivot의 위치가 K값과 같다면 K번째 값을 찾은 것이므로 값 반환 -> executeQuick함수
* 구체적인 로직은 아래의 그림 참고
  ![image](https://github.com/user-attachments/assets/e157d6f0-3694-4e7a-8274-a2066bfbca1f)
 

