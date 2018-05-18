class Weekday implements Comparable {
    static final DAYS = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat']
    private int index = 0;

    Weekday(String day) {
        this.index = DAYS.indexOf(day)
    }

    Weekday next() {
        return new Weekday(DAYS[(index + 1) % DAYS.size()])
    }
    Weekday previous() {
        return new Weekday(DAYS[index - 1])
    }

    int compareTo(Object other) {
        return this.index.compareTo(other.index)
    }
    String toString() {
        return DAYS[index]
    }

    int getIndex() {
        return index
    }
}

def mon = new Weekday("Mon")
def fri = new Weekday("Fri")
def sun = new Weekday("Sun")

(mon..fri).each {item ->
    println item
}

def newSat = sun.previous()
println newSat.getIndex()
