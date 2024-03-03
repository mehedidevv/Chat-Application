package com.mehedihasan.chatapplication

class User {
    var name:String?=null
    var email:String?=null
    var uid:String?=null
    //Create An Empty Constructor
    constructor(){}
    //Create Constructor With Parameter
    constructor(name:String?,email:String?,uid:String?){
        this.name=name
        this.email=email
        this.uid=uid
    }
}