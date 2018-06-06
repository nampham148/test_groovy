class PretendFieldCounter {
    public count = 0
    Object get (String name) {
        return 'pretend value'
    }
    void set (String name, Object value) {
        count++
    }
}
def pretender = new PretendFieldCounter()
assert pretender.isNoField == 'pretend value'
println pretender.count
println pretender['count']
pretender.isNoFieldEither = 'just to increase counter'
println pretender.isNoFieldEither
println pretender['count']
assert pretender.count == 1
