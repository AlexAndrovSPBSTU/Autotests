package org.example;

import com.codeborne.selenide.*;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class MyGroupsPage {
    private final SelenideElement FIRST_GROUP_NAME_FIELD = $x("//a[@class='group-detailed-card_name']");
    private final SelenideElement JOIN_GROUP_BUTTON = $x("//a[@class='button-pro group-join_btn __small __sec']");
    private final ElementsCollection MY_JOINED_GROUPS_LIST = $$x("//li[@class='scroll-slider_item mr-x']");
    private final SelenideElement GROUP_NAME_FIELD = $x("//h1[@class='group-name_h']");

    public MyGroupsPage() {
    }

    public String getFirstGroupName() {
        return FIRST_GROUP_NAME_FIELD
                .shouldBe(Condition.visible.because("Группа не найдена"))
                .text();
    }

    public void clickJoinGroupButton() {
        JOIN_GROUP_BUTTON
                .shouldBe(Condition.visible.because("Кнопка присоединения к группе не найдена"))
                .click();
    }


    public List<String> getMyJoinedGroupsName() {
        List<String> list = new ArrayList<>();
        int size = MY_JOINED_GROUPS_LIST.size();
        for (int i = 0; i < size; i++) {
            MY_JOINED_GROUPS_LIST.get(i).shouldBe(Condition.visible.because("Группа не найдена")).click();
            list.add(GROUP_NAME_FIELD.shouldBe(Condition.visible.because("Поле названия группы не найдено")).text());
            Selenide.back();
        }
        return list;
    }

}
