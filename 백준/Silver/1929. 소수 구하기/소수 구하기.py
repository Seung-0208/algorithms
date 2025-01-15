M, N = list(map(int, input().split()))
prime = [True] * (N+1)
x = int((N+1)**0.5)
for i in range(2,x+1):
    if prime[i]==True:
        for j in range(i+i,N+1,i):
            prime[j]=False

answer = [i for i in range(2,N+1) if prime[i]==True]

for i in range(len(answer)):
    if answer[i]>=M:
        print(answer[i])
        