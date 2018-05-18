def benchmark(Closure worker, int repeat) {
    def start = System.nanoTime()
    repeat.times { worker(it) }
    def stop = System.nanoTime()
    return stop - start
}

def close1 = {(int) it / 2}
def close2 = {it.intdiv(2)}

def slow = benchmark({(int) it/2}, 1000)
def fast = benchmark({it.intdiv(2)}, 1000)

println slow
println fast

def adder = { x, y=5 -> x+y }
println adder(4, 3)
println adder.call(7)