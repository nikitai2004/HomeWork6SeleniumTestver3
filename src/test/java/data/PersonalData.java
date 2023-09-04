package data;

public enum PersonalData {
    FIELD_FNAME_STRING("Алексей"),
    FIELD_LNAME_STRING("Петров"),
    FIELD_FNAME_LATIN_STRING("Alex"),
    FIELD_LNAME_LATIN_STRING("Petroff"),
    FIELD_DATE_OF_BIRTH_STRING("12.05.2009"),
    FIELD_ID_BLOG_NAME_STRING("AlexPetroffBlog"),
    FIELD_COMP_NAME("ООО \"ХОМЯЧКИ\""),
    FIELD_POS_NAME("Главный хомяк"),
    FIELD_RUS_STRING("Россия"),
    FIELD_TOWN_STRING("Санкт-Петербург"),
    FIELD_ENG_LEVEL_STRING("Продвинутый (Advanced)");

    private String name;

    PersonalData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
