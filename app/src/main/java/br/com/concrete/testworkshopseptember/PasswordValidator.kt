package br.com.concrete.testworkshopseptember

private val validationRegexes = listOf(
    "(\\d)+", "[A-Z]", "[a-z]", "[^a-zA-Z0-9]+", ".{8,}"
).map { it.toRegex() }

class PasswordValidator {
    fun isValid(password: String) = validationRegexes.all { validation ->
        password.contains(validation)
    }
}