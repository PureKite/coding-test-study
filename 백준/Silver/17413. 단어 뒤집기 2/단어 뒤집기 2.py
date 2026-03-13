import sys

s = input().strip()

result = ""
word = ""
tag = False

for i in s:
    if i == "<":
        tag = True
        result += word[::-1]
        word = ""
        result += i
    elif i == ">":
        tag = False
        result += i
    elif tag:
        result += i
    else:
        if i == " ":
            result += word[::-1] + " "
            word = ""
        else:
            word += i

print(result + word[::-1])