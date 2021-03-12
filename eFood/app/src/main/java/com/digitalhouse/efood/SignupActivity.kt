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

class SignupActivity : AppCompatActivity() {

    val nameTextLayout by lazy { findViewById<TextInputLayout>(R.id.signup_name_layout) }
    val emailTextLayout by lazy { findViewById<TextInputLayout>(R.id.signup_email_layout) }
    val passwordTextLayout by lazy { findViewById<TextInputLayout>(R.id.signup_password_layout) }
    val passwordRepeatTextLayout by lazy { findViewById<TextInputLayout>(R.id.signup_password_repeat_layout) }
    val nameEditText by lazy { findViewById<TextInputEditText>(R.id.signup_name_edit_text) }
    val emailEditText by lazy { findViewById<TextInputEditText>(R.id.signup_email_edit_text) }
    val passwordEditText by lazy { findViewById<TextInputEditText>(R.id.signup_password_edit_text) }
    val passwordRepeatEditText by lazy { findViewById<TextInputEditText>(R.id.signup_password_repeat_edit_text) }
    val submitButton by lazy { findViewById<Button>(R.id.signup_submit_button) }

    lateinit var email: String
    lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        // Get the email and password from the login activity
        emailEditText.setText(intent.getStringExtra("email"))
        passwordEditText.setText(intent.getStringExtra("password"))

        // Set the title of the action bar
        supportActionBar?.title = getString(R.string.label_sign_up)

        // Clear field errors when editing the text
        nameEditText.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                nameTextLayout.error = null
            }
            override fun afterTextChanged(s: Editable?) {}
        })
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
        passwordRepeatEditText.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                passwordRepeatTextLayout.error = null
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        submitButton.setOnClickListener() {
            submit()
        }
    }
    // Check if the fields are valid, registers the user and launch the login activity
    private fun submit() {
        email = emailEditText.text.toString()
        password = passwordEditText.text.toString()
        if(validate()) {
            Toast.makeText(this,getString(R.string.signup_sucess), Toast.LENGTH_LONG)
                .show()
            startActivity(Intent(this, LoginActivity::class.java).apply {
                // Store the e-mail and password so the user doesn't have to type them in again
                putExtra("email", email)
                putExtra("password", password)
            })
            // Kill the activity to get it off the stack
            finish()
            return
        }
        // Set field errors if they're invalid
        if (emptyName()) nameTextLayout.error = getString(R.string.required)
        if (emptyEmail()) emailTextLayout.error = getString(R.string.required)
        if (emptyPassword()) passwordTextLayout.error = getString(R.string.required)
        when {
            emptyPasswordRepeat() -> passwordRepeatTextLayout.error = getString(R.string.required)
            unmatchedPassword() -> {
                passwordTextLayout.error = getString(R.string.password_unmatched)
                passwordRepeatTextLayout.error = getString(R.string.password_unmatched)
            }
        }
    }
    // Validate fields
    private fun emptyName() = nameEditText.text?.isEmpty() ?: true
    private fun emptyEmail() = emailEditText.text?.isEmpty() ?: true
    private fun emptyPassword() = passwordEditText.text?.isEmpty() ?: true
    private fun emptyPasswordRepeat() = passwordRepeatEditText.text?.isEmpty() ?: true
    private fun unmatchedPassword() = passwordEditText.text.toString() != passwordRepeatEditText.text.toString()
    private fun validate() = !emptyName() && !emptyEmail() && !emptyPassword() && !emptyPasswordRepeat() && !unmatchedPassword()
}