
import random

a = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-+/*!@#$%^&.,"

for file in range(4000,5000):
    file_name = "data/f{}.txt".format(file)
    f = open(file_name, "w")
    size = random.randint(2000, 200000)
    s = ''

    for i in range(size):
        s += random.choice(a)
    f.write(s)
    f.close()
