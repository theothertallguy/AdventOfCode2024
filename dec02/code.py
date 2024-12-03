print("Hello World")

f=open('C:\\Users\\stern\\vs-projects\\Advent Of Code 2024\\dec02\\input.txt')
s=f.read()
f.close()

print(s)

r = s.split("\n")

print(r)

out = 0

for l in r:
    su = True
    m = l.split(" ")
    if (len(m)>1):
        j = int(m[0])
        k = int(m[1])
        di = False
        if ((j-k)>0):
            di = True
        if ((j-k)==0):
            su = False
        for i in range(1,len(m)):
            j = int(m[i-1])
            k = int(m[i])
            if (su):
                if ((j-k)<0):
                    if (di or abs(j-k)>3):
                        su = False
                elif (j-k>0):
                    if (not(di) or abs(j-k)>3):
                        su = False
                else:
                    su = False
        if (su):
            out = out + 1

print(out)

out2 = 0

for l in r:
    su = True
    m = l.split(" ")
    if (len(m)>2):
        j = int(m[0])
        k = int(m[1])
        di = False
        if ((j-k)>0):
            di = True
        if ((j-k)==0):
            su = False
        for i in range(1,len(m)):
            j = int(m[i-1])
            k = int(m[i])
            if (su):
                if ((j-k)<0):
                    if (di or abs(j-k)>3):
                        su = False
                elif (j-k>0):
                    if (not(di) or abs(j-k)>3):
                        su = False
                else:
                    su = False
        if (su):
            out2 = out2 + 1
        else:
            bad = True
            for e in range(len(m)):
                tmp = m.copy()
                del tmp[e]
                su = True
                if (len(tmp)>2):
                    j = int(tmp[0])
                    k = int(tmp[1])
                    di = False
                    if ((j-k)>0):
                        di = True
                    if ((j-k)==0):
                        su = False
                    for i in range(1,len(tmp)):
                        j = int(tmp[i-1])
                        k = int(tmp[i])
                        if (su):
                            if ((j-k)<0):
                                if (di or abs(j-k)>3):
                                    su = False
                            elif (j-k>0):
                                if (not(di) or abs(j-k)>3):
                                    su = False
                            else:
                                su = False
                    if (su and bad):
                        out2 = out2 + 1
                        bad = False
                
                

print(out2)