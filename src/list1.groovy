Point a = new Point(1, 2)
Point b = new Point(4, 3)
Point c = new Point(3, 4)

def list = [a, b, c]

def odd = [1,2,3].findAll{ item ->
    item % 2 == 1
}

println odd

def newlist = list.findAll{item ->
    return item.y <= 3
}.collect{ item ->
    return item.x
}.sort().join("-")

println newlist

println list.getClass()