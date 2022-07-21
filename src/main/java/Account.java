public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */
        if (name == null) {
            return false;
        }
        return
                name.length() >= 3
                        && name.length() <= 19
                        && name.contains(" ")
                        && name.split(" ").length == 2
                        && !name.startsWith(" ")
                        && !name.endsWith(" ");
    }
}
