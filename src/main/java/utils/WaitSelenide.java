package utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

public class WaitSelenide {

    public void waitAppear(SelenideElement element){
        element.should(Condition.appear, Duration.ofSeconds(10));
    }

    public void waitVisible(SelenideElement element){
        element.should(Condition.visible, Duration.ofSeconds(10));
    }

    public void waitEnable(SelenideElement element){
        element.should(Condition.enabled, Duration.ofSeconds(10));
    }

    public void waitDisappear(SelenideElement element){
        element.should(Condition.disappear, Duration.ofSeconds(10));
    }

    public void waitDisabled(SelenideElement element){
        element.should(Condition.disabled, Duration.ofSeconds(10));
    }
}

