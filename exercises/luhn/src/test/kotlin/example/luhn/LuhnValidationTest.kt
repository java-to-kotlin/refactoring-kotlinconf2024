package example.luhn

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DynamicNode
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import kotlin.random.Random
import kotlin.random.nextInt

private val validTestCardNumbers = listOf(
    "378282246310005",  // American Express
    "378734493671000",  // American Express Corporate
    "30569309025904",   // Diners Club
    "3566002020360505", // JCB
    "5425233430109903", // Mastercard
    "4012888888881881", // VISA
    "4701322211111234", // VISA Debit
)


class LuhnValidationTest {
    @TestFactory
    fun `positive cases`(): List<DynamicNode> {
        return validTestCardNumbers.map { cardNumber ->
            dynamicTest(cardNumber) {
                assertTrue(cardNumber.isValidCardNumber())
            }
        }
    }
    
    @TestFactory
    fun `negative cases`(): List<DynamicNode> {
        return validTestCardNumbers
            .map { it.withSingleDigitMistyped() }
            .map { (description, cardNumber) ->
                dynamicTest(description) {
                    assertFalse(cardNumber.isValidCardNumber())
                }
            }
    }
    
    private fun String.withSingleDigitMistyped(): Pair<String, String> {
        val i = Random.nextInt(indices)
        val oldDigit = get(i)
        val newDigit = oldDigit.digitToInt().plus(1).rem(10)
        
        val description = replaceRange(i, i + 1, "[$oldDigit → $newDigit]")
        val badCardNumber = replaceRange(i, i + 1, newDigit.toString())
        
        return description to badCardNumber
    }
}