package example.luhn

fun String.isValidCardNumber(): Boolean {
    val reversedCardNumber = this.reversed()
    val digits = reversedCardNumber.map { ch -> ch.digitToInt() }
    
    var checkSum = 0
    digits.forEachIndexed { index, digit ->
        val digitComponent = when (index % 2) {
            0 -> digit
            else -> digit * 2
        }
        
        checkSum += when {
            digitComponent >= 10 -> digitComponent / 10 + digitComponent % 10
            else -> digitComponent
        }
    }
    
    return checkSum % 10 == 0
}
