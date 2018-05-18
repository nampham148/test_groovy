
Point topLeft = new Point(0, 0) // classic
Point botRight = [100, 100, 20] // List cast
Point center = [x:50, y:50] // Map cast

assert botRight instanceof Point

println(topLeft.x + " " + topLeft.y)
println(botRight.x + " " + botRight.y + " " + botRight.size)
println(center.x)
