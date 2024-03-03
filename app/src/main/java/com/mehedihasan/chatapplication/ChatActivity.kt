package com.mehedihasan.chatapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ChatActivity : AppCompatActivity() {

    private lateinit var chatRecylerView: RecyclerView
    private lateinit var messageBox: EditText
    private  lateinit var sendMessage: ImageView

    private lateinit var messageAdapter: MessageAdapter
    private lateinit var messagelist: ArrayList<Message>

    private lateinit var mDbRef: DatabaseReference

    var receiverRoom: String?= null
    var senderRoom: String?= null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val name=intent.getStringExtra("name")
        val receiveruid= intent.getStringExtra("uid")

        val senderuid=FirebaseAuth.getInstance().currentUser?.uid
        mDbRef=FirebaseDatabase.getInstance().getReference()

        senderRoom= receiverRoom + senderuid
        receiverRoom= senderuid + receiveruid

        supportActionBar?.title=name
        //Connection With Xml
        chatRecylerView=findViewById(R.id.chatRecyclerView)
        messageBox=findViewById(R.id.messageBox)
        sendMessage=findViewById(R.id.sendButton)
        messagelist=ArrayList()


        messageAdapter=MessageAdapter(this,messagelist)
        chatRecylerView.layoutManager=LinearLayoutManager(this)
        chatRecylerView.adapter=messageAdapter

        //ligic For Adding Data in recyclerView
        mDbRef.child("Chats").child(senderRoom!!).child("Messages")
            .addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    messagelist.clear()


                    for (postSnapshot in snapshot.children){
                        val message=postSnapshot.getValue(Message::class.java)
                        messagelist.add(message!!)
                    }
                    messageAdapter.notifyDataSetChanged()
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })

        //SetOnclick Listner to Send Message
        sendMessage.setOnClickListener {
            val message=messageBox.text.toString()
            val messageObject = Message(message,senderuid)

            mDbRef.child("Chats").child(senderRoom!!).child("Message").push()
                .setValue(messageObject).addOnSuccessListener {
                    mDbRef.child("Chats").child(receiverRoom!!).child("Message").push()
                        .setValue(messageObject)
                }
            messageBox.setText("")


        }

    }
}