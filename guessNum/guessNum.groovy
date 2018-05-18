class guessNum {

    static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        println "Let me guess your integer!"
        print "Maximum Value: "
        def max = br.readLine().toInteger()
        print "Minimum Value: "
        def min = br.readLine().toInteger()

        def options = ["correct", "higher", "lower"]
        def feedback

        while (min <= max) {
            def middle = (max + min).intdiv(2)
            print "Im guessing $middle! Is this the correct number, or higher or lower? "
            feedback = options.indexOf(br.readLine())

            while (feedback == -1) {
                print "Please enter a valid feedback: "
                feedback = options.indexOf(br.readLine())
            }

            if (feedback == 0) {
                println "Got it"
                return
            } else if (feedback == 1) {
                min = middle + 1
            } else if (feedback == 2){
                max = middle - 1
            }
        }

        println "The number you're thinking of is not in range"
        return


    }
}
