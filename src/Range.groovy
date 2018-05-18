def age = 12
def edu

switch (age) {
    case 1..5:
        edu = "kindergarten"
        break
    case 6..10:
        edu = "primary school"
        break
    case 11..14:
        edu = "middle school"
        break
    case 15..18:
        edu = "high school"
        break
}

println edu

assert [10, 20, 30, 40].grep(11..34) == [20, 30]