package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;



public class SimpleTest {


    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }


    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Zhanna");
        $("#lastName").setValue("Zhirnova");
        $("#userEmail").setValue("zhzhv@yandex.ru");
        $("[for = 'gender-radio-2']").click();
        $("#userNumber").setValue("9040168579");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1991");
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__day--016").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("[for = 'hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFile(new File("C:/Users/Zhanna/Desktop/cat.jpg"));
        $("#currentAddress").setValue("Tver, street 66");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();
        $("#submit").pressEnter();

        $("[id=search]").shouldHave(text("https://selenide.org"));
    }



}


