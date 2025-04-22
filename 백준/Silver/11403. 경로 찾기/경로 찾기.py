import sys
input = sys.stdin.readline

graph = []
N = int(input())
for _ in range(N):
        temp = list(map(int, input().split()))
        graph.append(temp)

for k in range(N):
        for i in range(N):
                for j in range(N):
                        if graph[i][j] == 0:
                                        if graph[i][k]==1 and graph[k][j]==1:
                                                graph[i][j]=1

for row in graph:
        for col in row:
                print(col, end=' ')
        print()