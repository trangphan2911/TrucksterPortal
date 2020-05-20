package com.dice.sandbox;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Field;

public class ConstructorExample {

    public static void main(String[] args) throws NoSuchMethodException,
            SecurityException, InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, NoSuchFieldException {

        // Lấy ra đối tượng Class mô tả class Cat
        Class<Cat> aClass = Cat.class;

        // Lấy ra cấu tử có tham số (String,int) của class Cat

//        Constructor<?> constructor = aClass.getConstructor(String.class,
//                int.class);
//
//        // Lấy ra thông tin kiểu tham số của cấu tử.
//        Class<?>[] paramClasses = constructor.getParameterTypes();
//
//        for (Class<?> paramClass : paramClasses) {
//            System.out.println("Param: " + paramClass.getSimpleName());
//        }

        // Khởi tạo đối tượng Cat theo cách thông thường.
//        Cat tom = new Cat("Tom", 3);
//        System.out
//                .println("Cat 1: " + tom.getName() + ", age =" + tom.getAge());
//
//
//
//        // Khởi tạo đối tượng Cat theo cách của reflect.
//        Cat tom2 = (Cat) constructor.newInstance("Tom", 2);
//        System.out.println("Cat 2: " + tom.getName() + ", age ="
//                + tom2.getAge());

        Field ageField = aClass.getDeclaredField("name");
        Field[] ageFields = aClass.getDeclaredFields();
        for (int i = 0 ; i< ageFields.length; i++) {
            Class<?> fieldType = ageFields[i].getType();
            if(fieldType.getSimpleName().equals("WebElement"))
                System.out.println("Field name: " + ageFields[i].getName());
        }

        Cat tom = new Cat(5);

        // Lấy ra giá trị của trường "age" theo cách của Reflect.
//        Integer age = (Integer) ageField.get(tom);
        String name = (String) ageField.get(tom);
        System.out.println("Name = " + name);

        // Sét đặt giá trị mới cho trường "age".
//        ageField.set(tom, 7);
        ageField.set(tom, "Teo");

        System.out.println("New Name = "+ tom.getName());

        Student std1 = new Student();
        Class<Student> stClass = Student.class;

        Field idField = stClass.getField("name");
        Annotation anno = idField.getAnnotation(ExcelColumn.class);
        System.out.println(anno);
        if(anno instanceof ExcelColumn){
            ExcelColumn myAnnotation = (ExcelColumn) anno;
            System.out.println("index: " + myAnnotation.index());
            System.out.println("title: " + myAnnotation.title());
        }
    }
}
