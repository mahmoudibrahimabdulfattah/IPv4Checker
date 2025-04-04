fun main() {
    // Valid IPv4
    test("Valid IP - Standard Case", isValidIPv4("192.168.1.1"), true)
    test("Valid IP - Zero Values", isValidIPv4("0.0.0.0"), true)
    test("Valid IP - Max Values", isValidIPv4("255.255.255.255"), true)
    test("Valid IP - Mixed Values", isValidIPv4("10.0.255.1"), true)

    // Invalid IPv4 - Number of parts
    test("Invalid IP - Too Few Segments", isValidIPv4("192.168.1"), false)
    test("Invalid IP - Too Many Segments", isValidIPv4("192.168.1.1.5"), false)
    test("Invalid IP - Empty String", isValidIPv4(""), false)
    test("Invalid IP - Only Dots", isValidIPv4("..."), false)

    // Invalid IPv4 - values out
    test("Invalid IP - Negative Value", isValidIPv4("192.168.-1.1"), false)
    test("Invalid IP - Value Too Large", isValidIPv4("192.168.1.256"), false)
    test("Invalid IP - Value Way Too Large", isValidIPv4("192.168.1.1000"), false)

    // Invalid IPv4 - Invalid format
    test("Invalid IP - Leading Zeros", isValidIPv4("192.168.01.1"), false)
    test("Invalid IP - Double Leading Zeros", isValidIPv4("192.168.001.1"), false)
    test("Invalid IP - Non-Numeric Characters", isValidIPv4("192.168.a.1"), false)
    test("Invalid IP - Special Characters", isValidIPv4("192.168.*.1"), false)
    test("Invalid IP - Spaces", isValidIPv4("192.168. 1.1"), false)
    test("Invalid IP - Empty Segment", isValidIPv4("192.168..1"), false)

    // Invalid IPv4 - special cases
    test("Invalid IP - Missing Segment", isValidIPv4("192.168.1."), false)
    test("Invalid IP - Starting With Dot", isValidIPv4(".192.168.1"), false)
    test("Invalid IP - Extra Whitespace", isValidIPv4(" 192.168.1.1 "), false)
    test("Invalid IP - Extra Characters", isValidIPv4("192.168.1.1abc"), false)
}

fun test(name: String, result: Boolean, correctResult: Boolean) {
    if (result == correctResult) {
        println("success - $name")
    } else {
        println("failed - $name")
    }
}