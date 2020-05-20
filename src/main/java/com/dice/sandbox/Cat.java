package com.dice.sandbox;

import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;

public class Cat {

    // Private field.
    public String name;

    // Private field
    public int age;

    WebElement webEl;

    public Cat (){
    }

    public Cat(int age) {
        this.name = "";
        this.age = age ;
    }

    public Cat(String name, int age) throws NoSuchFieldException, IllegalAccessException {
        this.name = name;
        this.age = age;
        Class<Cat> aClass = Cat.class;
        Field ageField = aClass.getDeclaredField("name");
        ageField.set(this, "Teo");
    }

    public String getName() {
        return this.name;
    }

    // Private Method.
    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
