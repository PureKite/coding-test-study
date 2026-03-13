import sys
from collections import Counter
input = sys.stdin.readline

n = int(input())
data = [int(input()) for _ in range(n)]
avg = sum(data) / len(data)
avgResult = round(avg)
print(avgResult)

data.sort()
print(data[n//2])

counts = Counter(data).most_common()

counts.sort(key=lambda x: (-x[1], x[0]))
if len(counts) > 1 and counts[0][1] == counts[1][1]:
    print(counts[1][0])
else:
    print(counts[0][0])
print(data[-1] - data[0])