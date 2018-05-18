def myMap = [a:1, b:2, c:3]

def doubled = myMap.collect { entry -> entry.value *= 2 }

println doubled