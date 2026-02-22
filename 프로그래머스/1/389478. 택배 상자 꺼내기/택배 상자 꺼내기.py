def solution(n, w, num):
    warehouse = []
    
    for i in range(1, n+1, w):
        row = list(range(i, min(i+w, n+1)))
        
        if len(row) <= w:
            row += [0] * (w - len(row))
            
        if (i // w) % 2 == 1:
            row.reverse()
            
        warehouse.append(row)
        
    for k in warehouse:
        if num in k:
            floor, rack = warehouse.index(k), k.index(num)
            break
            
    if warehouse[-1][rack] != 0:
        answer = len(warehouse) - floor
    else:
        answer = len(warehouse) - floor - 1
    return answer