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
    val submitButton by lazy { findViewById<Button>(R.id.login_submit_button) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        supportActionBar?.title = getString(R.string.label_sign_up)
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

    private fun submit() {
        val email = emailEditText?.text ?: ""
        val password = passwordEditText?.text ?: ""
        if(!invalidName() && !invalidEmail() && !invalidPassword() && !invalidPasswordRepeat()) {
            Toast.makeText(this,getString(R.string.signup_sucess), Toast.LENGTH_LONG)
                .show()
            startActivity(Intent(this, LoginActivity::class.java).apply {
                putExtra("email", email)
            })
            finish()
            return
        }
        if (invalidName()) {
            nameTextLayout.error = getString(R.string.required)
        }
        if (invalidEmail()) {
            emailTextLayout.error = getString(R.string.required)
        }
        if (invalidPassword()) {
            passwordTextLayout.error = getString(R.string.required)
        }
        if (invalidPasswordRepeat()) {
            passwordRepeatTextLayout.error = getString(R.string.required)
        }
    }

    private fun invalidName() = nameEditText.text?.isEmpty() ?: true
    private fun invalidEmail() = emailEditText.text?.isEmpty() ?: true
    private fun invalidPassword() = passwordEditText.text?.isEmpty() ?: true
    private fun invalidPasswordRepeat() = passwordRepeatEditText.text?.isEmpty() ?: true
}