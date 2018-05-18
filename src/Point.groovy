class Point {
    Integer x
    Integer y
    Integer size


    Point(int x, int y, int z) {
        this.x = x
        this.y = y
        this.size = z
    }

    Point(Integer x, Integer y) {
        this.x = x
        this.y = y
        this.size = 0
    }

    static void main(String[] args) {
        Point topLeft = new Point(0, 0) // classic
        Point botRight = [100, 100] // List cast
        Point center = [x:50, y:50, z:50] // Map cast

        assert botRight instanceof Point
        //assert center instanceof Point

        println(topLeft.x + " " + topLeft.y)
        println(botRight.x + " " + botRight.y)
        println(center.x + " " + center.y)
        //println(center.size)
    }
}
