from collections import deque

M, N = map(int, input().split())
graph = []
for _ in range(N):
    graph.append(list(map(int, input().split())))
queue = deque()
for i in range(N):
    for j in range(M):
        if graph[i][j] == 1:
            queue.append((i,j))

def BFS():
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx<0 or nx>=N or ny<0 or ny>=M:
                continue
            if graph[nx][ny] == -1: #토마토 없음
                continue
            if graph[nx][ny] == 0:
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx,ny))

BFS()
temp = 0
for i in graph:
    for j in i:
        if j==0:
            print(-1)
            exit(0)
        temp = max(temp, j)

print(temp-1)