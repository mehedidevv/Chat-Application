package com.mehedihasan.chatapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    private lateinit var emailTv: EditText
    private lateinit var passwordTv: EditText
    private lateinit var loginBtn: Button
    private lateinit var signupBtn: Button

    //Firebase Auth
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //Connection with XML
        connection()
        //OnClick Listner to signUp Button
        signupBtn.setOnClickListener {
            val intent=Intent(this,SignUp::class.java)
            startActivity(intent)
        }
        //OnClickListner to Login Button
        loginBtn.setOnClickListener {
            val email=emailTv.text.toString()
            val password=passwordTv.text.toString()
            //LogIn Method
            login(email,password)
        }
    }
//  LogIn Method
    private fun login(email: String, password: String) {

    mAuth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                val intent = Intent(this@Login, MainActivity::class.java)
                finish()
                startActivity(intent)
            } else {
                Toast.makeText(this@Login,"User Doesn't Exists....", Toast.LENGTH_SHORT).show()
            }
        }
    }

    //Connection With Xml
    private fun connection() {
        mAuth=FirebaseAuth.getInstance()
        emailTv=findViewById(R.id.emailTV)
        passwordTv=findViewById(R.id.passwordTV)
        loginBtn=findViewById(R.id.loginBtn)
        signupBtn=findViewById(R.id.signupBtn)
    }
}