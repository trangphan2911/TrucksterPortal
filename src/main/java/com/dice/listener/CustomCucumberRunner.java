package com.dice.listener;

import cucumber.api.junit.Cucumber;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

import java.io.IOException;

/**
 * Created by thuan.duong on 7/30/2018.
 */
public class CustomCucumberRunner extends Cucumber{
    public CustomCucumberRunner(Class clazz) throws InitializationError, IOException {
        super(clazz);
    }
    @Override
    public void run(RunNotifier notifier) {
        notifier.addListener(new JUnitExecutionListener());
        super.run(notifier);
    }
}
