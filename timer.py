import time

input("Press Enter to start")
start = time.time()
input("Press Enter to stop")
print(round(time.time() - start, 2), "seconds")
