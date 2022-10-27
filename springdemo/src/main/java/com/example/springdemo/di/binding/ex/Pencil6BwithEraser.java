package com.example.springdemo.di.binding.ex;

public class Pencil6BwithEraser extends Pencil6B implements Pencil{

    @Override
    public void use() {
        super.use();
        System.out.println("with Eraser");
    }
}

