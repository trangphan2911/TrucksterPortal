package com.dice.support;

import com.google.common.base.Preconditions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.pagefactory.AbstractAnnotations;

import java.io.FileNotFoundException;
import java.lang.reflect.Field;

public class CustomAnnotations extends AbstractAnnotations {
    private final Field field;

    CustomAnnotations(Field field) {
        this.field = field;
    }

    @Override
    public By buildBy() {
//        SearchWith search = field.getAnnotation(SearchWith.class);
        CustomFindBy customFindBy = field.getAnnotation(CustomFindBy.class);
//        Preconditions.checkArgument(search != null, "Failed to locate the annotation @SearchWith");
//        String elementName = search.name();
//        String pageName = search.inPage();
//        String locatorsFile = search.locatorsFile();
//        Preconditions
//                .checkArgument(isNotNullAndEmpty(elementName), "Element name is not found.");
//        Preconditions.checkArgument(isNotNullAndEmpty(pageName), "Page name is missing.");
//        Preconditions.checkArgument(isNotNullAndEmpty(locatorsFile), "Locators File name not provided");
        Preconditions.checkArgument(customFindBy != null, "Failed to locate the annotation @SearchWith");
        String xpathEle = customFindBy.xpath();
        Preconditions.checkArgument(isNotNullAndEmpty(xpathEle), "Xpath is not provided");
//        File file = new File(locatorsFile);
//        Preconditions.checkArgument(file.exists(), "Unable to locate " + locatorsFile);
//        try {
//            JsonArray array = new JsonParser().parse(new FileReader(file)).getAsJsonArray();
//            Iterator&amp;lt;JsonElement&amp;gt; iterator = array.iterator();
//            JsonObject foundObject = null;
//            while (iterator.hasNext()) {
//                JsonObject object = iterator.next().getAsJsonObject();
//                if (pageName.equalsIgnoreCase(object.get("pageName").getAsString()) &&
//                        elementName.equalsIgnoreCase(object.get("name").getAsString())) {
//                    foundObject = object;
//                    break;
//                }
//            }
//            Preconditions.checkState(foundObject != null, "No entry found for the page [" + pageName + "] in the "
//                    + "locators file [" + locatorsFile + "]");
//            String locateUsing = foundObject.get("locateUsing").getAsString();
//            if (! ("xpath".equalsIgnoreCase(locateUsing))) {
//                throw new UnsupportedOperationException("Currently " + locateUsing + " is NOT supported. Only xPaths "
//                        + "are supported");
//            }
//
//            String locator = foundObject.get("locator").getAsString();
//            Preconditions.checkArgument(isNotNullAndEmpty(locator), "Locator cannot be null (or) empty.");

        return new By.ByXPath(xpathEle);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }

    }

    @Override
    public boolean isLookupCached() {
        return (field.getAnnotation(CacheLookup.class) != null);
    }

    private boolean isNotNullAndEmpty(String arg) {
        return ((arg != null) && (! arg.trim().isEmpty()));
    }
}
