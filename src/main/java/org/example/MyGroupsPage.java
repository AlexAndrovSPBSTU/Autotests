package org.example;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;

public class MyGroupsPage {
    private final SelenideElement groupName = $x("//a[@class='group-detailed-card_name'][1]");
    private final SelenideElement joinGroupButton = $x("//a[@class='button-pro group-join_btn __small __sec'][1]");
    private final ElementsCollection myJoinedGroups = $$x("//li[@class='scroll-slider_item mr-x']//img");

    public MyGroupsPage() {
    }

    public String getGroupName() {
        return groupName.text();
    }

    public void clickJoinGroupButton() {
        joinGroupButton.click();
    }

    public List<String> getMyJoinedGroupsName() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return myJoinedGroups
                .stream()
                .map(e -> e.getAttribute("alt"))
                .collect(Collectors.toList());
    }
}
