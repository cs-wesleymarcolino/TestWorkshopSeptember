package br.com.concrete.testworkshopseptember

import android.content.Intent
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private val passwordValidator = PasswordValidator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        login.setOnClickListener {
            when {
                email.text.isEmpty() -> showAlert(R.string.error_email_is_empty)
                password.text.isEmpty() -> showAlert(R.string.error_password_is_empty)
                passwordValidator.isValid(password.text.toString()).not() -> showAlert(R.string.error_invalid_password)
                else -> {
                    val homeIntent = Intent(this@LoginActivity, HomeActivity::class.java)
                    startActivity(homeIntent)
                }
            }
        }
    }

    private fun showAlert(@StringRes errorMessageRes: Int) {
        AlertDialog.Builder(this)
            .setMessage(errorMessageRes)
            .show()
    }
}