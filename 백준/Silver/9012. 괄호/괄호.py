N = int(input())

for _ in range(N):
        is_true = True
        string = input()
        stk = []
        for a in string:
                if a == ')':
                        if not stk:
                                print("NO")
                                is_true = False
                                break
                        else:
                                stk.pop()
                else:
                        stk.append('(')
        if is_true:
                if stk:
                        print("NO")
                else:
                        print("YES")