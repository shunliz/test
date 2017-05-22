
dic_a = {'a':'a', 'c':'b'}
dic_b = {'a':'a','b':'b','c':'c'}

flag = True

for key in dic_a:
    if not (key in dic_b and dic_a.get(key) == dic_b.get(key)):
	    flag = False

print flag