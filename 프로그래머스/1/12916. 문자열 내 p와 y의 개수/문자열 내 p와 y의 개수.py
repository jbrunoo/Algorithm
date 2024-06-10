def solution(s):
    cnt1 = 0
    cnt2 = 0
    
    for c in s:
        if c == 'p' or c == 'P':
            cnt1 += 1
        elif c == 'y' or c == 'Y':
            cnt2 += 1
            
    if cnt1 == cnt2:
        return True
    else: 
        return False