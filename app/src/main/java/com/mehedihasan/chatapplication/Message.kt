package com.mehedihasan.chatapplication

class Message {
    var message: String?= null
    var senderId: String?= null
    //Empty Constructor
    constructor(){}
    //Constructor With parameter
    constructor(message: String?, senderId: String?){
        this.message= message
        this.senderId= senderId

    }
}