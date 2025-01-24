n = int(input())

for i in range(n):
    stack=[]
    word = input()
    for i in range(len(word)):
        if word[i]=='(':
            stack.append(word[i])
        elif word[i]==')':
            if stack:
                stack.pop()
            else:
                print("NO")
                break
    else:
        if not stack:
            print("YES")
        else:
            print("NO")
