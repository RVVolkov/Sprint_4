import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountParameterizedTest {
    private final String name;
    private final boolean expected;

    public AccountParameterizedTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}, {1}")
    public static Object[][] setName() {
        return new Object[][]{
                {"АБ", false}, //2 символа (граничное значение)
                {"А Б", true}, //3 символа с 1 пробелом (граничное значение)
                {"Аа Бб", true}, //4 символа с 1 пробелом (граничное значение)
                {"Тимоти Шаламе", true}, //между 3 и 19 символами
                {"Джастин Тимберлейк", true}, //18 символов (граничное значение)
                {"Бенедикт Камбербэтч", true}, //19 символов (граничное значение)
                {"Арнольд Шварценеггер", false}, //20 символов (граничное значение)
                {"Карим Абдул-Джаббар", true}, //знаки препинания в имени
                {"Шакил О'Нил", true}, //специальные символы в имени
                {"Леонардо Ди Каприо", false}, //2 пробела
                {" Вин Дизель", false}, //первый символ - пробел
                {"Бен Аффлек ", false}, //последний символ - пробел
                {"Стинг", false}, //без пробелов
                {"Brad Pitt", true}, //латинские буквы
                {"", false}, //пустые данные
                {"1234 56789", true}, //цифры
                {null, false}, //null
        };
    }

    @Test
    @DisplayName("Проверка корректности указанного имени")
    public void checkNameToEmbossTest() {
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expected, actual);
    }
}
