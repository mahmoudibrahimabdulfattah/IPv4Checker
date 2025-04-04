fun isValidIPv4(ip: String): Boolean {
    // Split Address by dot
    val segments = ip.split(".")

    // is contained 4 parts
    if (segments.size != 4) {
        return false
    }

    // check every part
    for (segment in segments) {
        if (segment.isEmpty()) {
            return false
        }

        // Shouldn't contain 0 until 0
        if (segment.length > 1 && segment[0] == '0') {
            return false
        }

        // should contain only digit
        try {
            val value = segment.toInt()

            // is value between 0 and 255?
            if (value < 0 || value > 255) {
                return false
            }
        } catch (e: NumberFormatException) {
            return false
        }
    }

    val reconstructed = segments.joinToString(".")
    if (reconstructed != ip) {
        return false
    }

    return true
}