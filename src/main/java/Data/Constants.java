package Data;

public enum Constants {
    INDEX_HTML_URL("https://yandex.ru/"),
    TITLE("Газинформсервис - информационная безопасность"),
    GIS_URL("https://www.gaz-is.ru/"),
    GIS_NAME("Газинформсервис");

    private String value;

    Constants(String value) {this.value = value;}

    @Override
    public String toString() {
        return value;
    }
}
