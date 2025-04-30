import sys
input = sys.stdin.readline

N = int(input()) #노드의 개수
Tree = list(map(int, input().split())) #부모 노드의 정보
delete = int(input()) #지울 노드

def dfs(index): #지워지는 노드 구하는 함수
        Tree[index] = "X" #X면 해당 인덱스 번째의 노드는 지워졌다는 뜻.
        for i in range(N):
                if Tree[i] == index:
                        dfs(i)

dfs(delete)
leaf_cnt = 0

for i in range(N):
        if Tree[i] != "X" and i not in Tree:
                leaf_cnt += 1

print(leaf_cnt)
