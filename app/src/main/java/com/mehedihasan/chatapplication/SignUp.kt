package com.mehedihasan.chatapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUp : AppCompatActivity() {
    private lateinit var nameTv: EditText
    private lateinit var emailTv: EditText
    private lateinit var passwordTv: EditText
    private lateinit var signupBtn: Button
    private lateinit var mDBRef: DatabaseReference

    //Firebase Auth
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        //Connection To XMl
        connection()
        //OnClickListner to SignUp Button
        signupBtn.setOnClickListener {
            val name=nameTv.text.toString()
            val email=emailTv.text.toString()
            val password=passwordTv.text.toString()
            //Method For SignUp
            signup(name,email,password)
        }
    }
//Method For Sign up Button
    private fun signup(name:String, email: String, password: String) {

    mAuth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                //AddUserTo Database
                addUserToDatabase(name,email,mAuth.currentUser?.uid!!)
                val intent = Intent(this@SignUp, MainActivity::class.java)
                finish()
                startActivity(intent)
            }else {
                Toast.makeText(this@SignUp,"Some Error...",Toast.LENGTH_SHORT).show()

            }

        }
    }
//AddUser To Database Method
    private fun addUserToDatabase(name: String, email: String, uid: String) {
        mDBRef=FirebaseDatabase.getInstance().getReference()
    mDBRef.child("user").child(uid).setValue(User(name,email,uid))

    }

    //Connection To XML
   private fun connection() {
    mAuth=FirebaseAuth.getInstance()
    nameTv=findViewById(R.id.nameTV)
    emailTv=findViewById(R.id.emailTV)
    passwordTv=findViewById(R.id.passwordTV)
    signupBtn=findViewById(R.id.signupBtn)
    }
}