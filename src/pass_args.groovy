class pass_args {
    static boolean test_eq (Integer x, Integer y) {
        return x == y
    }

    static void main(String[] args) {
        List a = [1, 1]
        println test_eq(a)
    }
}
