urls = {}
counter = 1

while True:
    u = input("Enter URL (or exit): ")
    if u == "exit":
        break
    key = f"u{counter}"
    urls[key] = u
    print("Short:", key)
    counter += 1
