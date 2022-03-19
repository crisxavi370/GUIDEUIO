package com.example.adoptame.adapter

class Adapter_Categorias(image:Int, title:String) {
    var image:Int = 0
        internal set
    var title:String
        internal set
    init{
        this.image = image
        this.title = title
    }
}