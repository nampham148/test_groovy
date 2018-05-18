String headline = "1.3 Hello world 1.4 Hi world 1.5 Bam 1a3"
def headfirst = "Hello world!"

def finder = headline =~ /(\d+)\.(\d+)/
def found = ''
def notFound = headfirst =~ /\d\.\d/

println(headline.getClass())

println notFound as Boolean
println finder as Boolean

finder.hasGroup()

finder.each{ match ->
    found += match + " "
}


println found