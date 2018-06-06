def testString = "test"

switch (testString) {
    case "a":
        println "a"
        break
    case "test":
        println "test"
        break
    default:
        println "default"
        break
}

assert "test" in "test"
def odd = {it % 2 == 1}
println 1 in odd