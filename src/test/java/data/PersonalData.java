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
    VKSTRING("https://vk.ru/profile/132456"),
    OKSTRING("https://ok.ru/profile/846341"),
    TLGSTRING("TELEGRAM:131853131"),
    SKSTRING("SKYPE:8431351313"),
    LOGIN("ceyogo9446@bitvoo.com"),
    PHONE("+7 999 999-99-99"),
    FIELD_RUS_STRING("Россия"),
    FIELD_TOWN_STRING("Санкт-Петербург"),
    FIELD_ENG_LEVEL_STRING("Продвинутый (Advanced)"),
    FIELD_ADD_1_TIME_STRING("1 год"),
    FIELD_ADD_2_TIME_STRING("2 года");

    private String name;

    PersonalData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}