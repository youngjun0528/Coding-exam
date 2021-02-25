# 소수 판별

a = int(input())


check = True

if a > 1:
    for i in range(2, a):
        if(a % i == 0):
            check = False
            break

if(check):
    print("YES")
else:
    print("NO")

# 에라스토테네스의 체
n = 1000
a = [False, False] + [True]*(n-1)
primes = []

for i in range(2, n+1):
    if a[i]:
        primes.append(i)
        for j in range(2*i, n+1, i):
            a[j] = False
print(primes)
