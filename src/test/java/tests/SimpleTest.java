package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


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
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
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
        $("#uploadPicture").uploadFromClasspath("cat.jpg");
        $("#currentAddress").setValue("Tver, street 66");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();
        $("#submit").pressEnter();

        $(".table-responsive").shouldHave(text("Zhanna Zhirnova"));
        $(".table-responsive").shouldHave(text("zhzhv@yandex.ru"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("9040168579"));
        $(".table-responsive").shouldHave(text("16 March,1991"));
        $(".table-responsive").shouldHave(text("English"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("cat.jpg"));
        $(".table-responsive").shouldHave(text("Tver, street 66"));
        $(".table-responsive").shouldHave(text("NCR Noida"));
    }
}


