# [Silver I] 구간 합 구하기 5 - 11660 

[문제 링크](https://www.acmicpc.net/problem/11660) 

### 성능 요약

메모리: 328728 KB, 시간: 1892 ms

### 분류

다이나믹 프로그래밍, 누적 합

### 제출 일자

2025년 1월 28일 18:16:27

### 아이디어

![image](https://github.com/user-attachments/assets/c06b18e1-4bb2-49cf-b228-8f6662ff047b)
<br/>
![image](https://github.com/user-attachments/assets/4d82af34-2ec8-4f1b-bc15-24cfda6f1510)

* 2차원 배열에서 구간합을 구하는 공식을 알아야 함
* -> hap[i][j] = hap[i-1][j] + hap[i][j-1] - hap[i-1][j-1] + origin[i][j]
