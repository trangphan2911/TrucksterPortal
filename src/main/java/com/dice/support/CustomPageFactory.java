package com.dice.support;

import com.dice.sandbox.RepeatingAnnotations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class CustomPageFactory {
    public static void initElements(WebDriver driver, Object page){
        Class pageClass = page.getClass();
        Field[] ageFields = pageClass.getDeclaredFields();
        for(int i = 0; i < ageFields.length ; i++) {
            Class<?> fieldType = ageFields[i].getType();
            if(fieldType.getSimpleName().equals("WebElement")) {
//                Annotation anno = ageFields[i].getAnnotation(CustomFindBy.class);
                Annotation [] anno = ageFields[i].getDeclaredAnnotations();
                for (int j = 0; j < anno.length; j++) {
                    if ( anno[j] instanceof CustomFindBy) {
                        System.out.println("check Annotation.");
                        CustomFindBy myAnnotation = (CustomFindBy) anno[j];
//                        checkAnnotationCustomFindBy(myAnnotation);
//                        WebElement el = null;
//                        try {
//                            el = driver.findElement(By.xpath(myAnnotation.xpath()));
//                        } catch (Exception e) {
//                            System.out.println(e);
//                        }
                        try {
                            WebElement el = driver.findElement(By.xpath(myAnnotation.xpath()));
                            ageFields[i].setAccessible(true);
                            ageFields[i].set(page, el);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

//    public static String checkAnnotationCustomFindBy(CustomFindBy myAnnotation) {
//
//        RepeatingAnnotations.Filters filters = RepeatingAnnotations.Filterable.class.getAnnotation(RepeatingAnnotations.Filters.class);
//        for (RepeatingAnnotations.Filter filter : filters.value()) {
//            System.out.println(filter.annotationType().getSimpleName());
//            System.out.println(filter.value());
//        }

//        if(!myAnnotation.id().isEmpty())
//            return myAnnotation.id();
//        else if(!myAnnotation.name().isEmpty())
//            return myAnnotation.name();
//        else if(!myAnnotation.className().isEmpty())
//            return myAnnotation.className();
//        else if(!myAnnotation.css().isEmpty())
//            return myAnnotation.css();
//        else if(!myAnnotation.xpath().isEmpty())
//            return myAnnotation.xpath();
//        else if(!myAnnotation.tagName().isEmpty())
//            return myAnnotation.tagName();
//        else if(!myAnnotation.linkText().isEmpty())
//            return myAnnotation.linkText();
//        else if(!myAnnotation.partialLinkText().isEmpty())
//            return myAnnotation.partialLinkText();
//        return null;
//    }
}
