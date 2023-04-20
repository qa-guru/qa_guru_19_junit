package guru.qa;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

import guru.qa.domain.Locale;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("WEB - тесты для демонстрации возможностей JUnit")
public class GoogleWebTest {

  @BeforeEach
  void setup() {
    open("https://www.google.com/");
  }

  @CsvSource(value = {
      "selenide | https://selenide.org",
      "JUnit | https://junit.org"
  },
  delimiter = '|')
  // OR
//  @CsvFileSource(resources = "/successfulSearchTest.csv", delimiter = '|')
  @ParameterizedTest(name = "Для поискового запроса: {0} в выдаче присутствует url: {1}")
  @Tags({
      @Tag("BLOCKER"),
      @Tag("WEB")
  })
  void successfulSearchTest(String searchQuery, String expectedUrl) {
    $("[name=q]").setValue(searchQuery).pressEnter();
    $("[id=search]").shouldHave(text(expectedUrl));
  }


  @ValueSource(strings = {
      "selenide",
      "junit"
  })
  @ParameterizedTest(name = "Для поискового запроса {0} в нажимается кнопка 'Мне повезет'")
  @Tags({
      @Tag("BLOCKER"),
      @Tag("WEB")
  })
  @DisplayName("")
  void fartTest(String searchQuery) {
    $("[name=q]").setValue(searchQuery);
    $$("input[name='btnI']").filter(visible)
        .first()
        .click();
  }
}
