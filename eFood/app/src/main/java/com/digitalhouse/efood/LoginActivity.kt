package com.digitalhouse.efood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {

    val emailTextLayout by lazy { findViewById<TextInputLayout>(R.id.login_email_layout) }
    val passwordTextLayout by lazy { findViewById<TextInputLayout>(R.id.login_password_layout) }
    val emailEditText by lazy { findViewById<TextInputEditText>(R.id.login_email_edit_text) }
    val passwordEditText by lazy { findViewById<TextInputEditText>(R.id.login_password_edit_text) }
    val submitButton by lazy { findViewById<Button>(R.id.login_submit_button) }
    val signupButton by lazy { findViewById<Button>(R.id.login_signup_button) }

    lateinit var email: String
    lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Get the email and password from the signup activity
        emailEditText.setText(intent.getStringExtra("email"))
        passwordEditText.setText(intent.getStringExtra("password"))

        // Clear field errors when editing the text
        emailEditText.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                emailTextLayout.error = null
            }
            override fun afterTextChanged(s: Editable?) {}
        })
        passwordEditText.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                passwordTextLayout.error = null
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        submitButton.setOnClickListener() {
            submit()
        }
        signupButton.setOnClickListener() {
            email = emailEditText?.text.toString()
            password = passwordEditText?.text.toString()
            startActivity(Intent(this, SignupActivity::class.java).apply {
                // Store the e-mail and password so the user doesn't have to type them in again
                putExtra("email", email)
                putExtra("password", password)
            })
        }
    }
    // Check if the fields are valid and launch the main activity
    private fun submit() {
        if(!invalidEmail() && !invalidPassword()) {
            Toast.makeText(this,getString(R.string.login_success),Toast.LENGTH_LONG)
                .show()
            startActivity(Intent(this, RestaurantsActivity::class.java))
            // Kill the login activity, to get it off the stack
            finish()
            return
        }
        // Set field errors if they're invalid
        if (invalidEmail()) emailTextLayout.error = getString(R.string.required)
        if (invalidPassword()) passwordTextLayout.error = getString(R.string.required)
    }
    // Validate fields
    private fun invalidEmail() = emailEditText.text?.isEmpty() ?: true
    private fun invalidPassword() = passwordEditText.text?.isEmpty() ?: true
}