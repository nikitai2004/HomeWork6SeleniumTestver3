package data;

public enum PersonalData {

    FIELD_FNAME_STRING("Алексей"),
    FIELD_LNAME_STRING("Петров"),
    FIELD_FNAME_LATIN_STRING("Alex"),
    FIELD_LNAME_LATIN_STRING("Petroff"),
    FIELD_DATE_OF_BIRTH_STRING("12.05.2009"),
    FIELD_ID_BLOG_NAME_STRING("AlexPetroffBlog"),
    FIELD_COMP_NAME("ООО \"ХОМЯЧКИ\""),
    FIELD_POS_NAME("Главный хомяк");




    private String name;

    PersonalData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


//    private final static String field_lname_string = "Петров";
//    private final static String field_fname_latin_string = "Alex";
//    private final static String field_lname_latin_string = "Petroff";
//    private final static String field_id_blog_name_string = "AlexPetroffBlog";
//    private final static String field_date_of_birth_string = "12.05.2009";
//    private final static String field_rus_string = "Россия";
//    private final static String field_town_string = "Санкт-Петербург";
//    private final static String field_eng_level_string = "Продвинутый (Advanced)";
//    private final static String field_comp_name = "ООО \"ХОМЯЧКИ\"";
//    private final static String field_pos_name = "Главный хомяк";


}
