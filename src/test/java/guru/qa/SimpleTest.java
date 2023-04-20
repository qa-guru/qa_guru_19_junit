package guru.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Демонстрационные тесты")
public class SimpleTest {

  @Test
  @DisplayName("Демонстрационный тест для проверки того, как работают аннотации")
  void simpleTest() {
    Assertions.assertEquals(3, 2 + 1, "");
  }
}
