package br.com.concrete.testworkshopseptember

import org.junit.Test
import org.junit.Assert.*

class PasswordValidatorTest {
    private val passwordValidator = PasswordValidator()

    @Test
    fun givenPasswordIsShorterThan8_whenValidate_shouldReturnFalse() {
        // arrange / act
        val result = passwordValidator.isValid("1234567")

        // assert
        assertFalse(result)
    }

    @Test
    fun givenPasswordDoesNotHaveUppercaseLetter_whenValidate_shouldReturnFalse() {
        val result = passwordValidator.isValid("a#345678")

        assertFalse(result)
    }

    @Test
    fun givenPasswordDoesNotHaveLowercaseLetter_whenValidate_shouldReturnFalse() {
        val result = passwordValidator.isValid("A#345678")

        assertFalse(result)
    }

    @Test
    fun givenPasswordDoesNotHaveANumber_whenValidate_shouldReturnFalse() {
        val result = passwordValidator.isValid("A#aabbcc")

        assertFalse(result)
    }

    @Test
    fun givenPasswordDoesNotASpecialCharacter_whenValidate_shouldReturnFalse() {
        val result = passwordValidator.isValid("A3aabbcc")

        assertFalse(result)
    }

    @Test
    fun givenPasswordIsValid_whenValidate_shouldReturnTrue() {
        val result = passwordValidator.isValid("aA#3iiii")

        assertTrue(result)
    }
}
