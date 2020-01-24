import time
x = time.time()
day = x//86400
hour = (x-day*86400)//3600
print(day,hour)