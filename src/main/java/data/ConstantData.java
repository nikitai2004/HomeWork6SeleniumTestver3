package data;

public enum ConstantData {
    DELCONTACTS1OF2("div.js-formset-row:nth-child("),
    DELCONTACTS2OF2(") > div:nth-child(4) > div:nth-child(2) > button:nth-child(1)"),
    DELEXP1OF2("div:nth-child("),
    DELEXP2OF2(") > div.experience-row__remove.ic-close.js-formset-delete"),
    VAL("value"),
    VAL0("id_contact-0-value"),
    VAL1("id_contact-1-value"),
    VAL2("id_contact-2-value"),
    VAL3("id_contact-3-value"),
    FIELD_EMAIL_LOAD("#id_email"),
    FIELD_PHONE("#id_phone"),
    FIELD_COUNTRY("//div[@class='select lk-cv-block__input lk-cv-block__input_full js-lk-cv-dependent-master js-lk-cv-custom-select']//label//div[1]"),
    FIELD_TOWN_LOAD("//div[contains(@class,'select lk-cv-block__input lk-cv-block__input_full js-lk-cv-dependent-slave-city js-lk-cv-custom-select')]//label//div[1]"),
    FIELD_ENG_LEVEL("//div[contains(@class,'select lk-cv-block__input lk-cv-block__input_full js-lk-cv-custom-select')]//label//div[1]"),
    FIELD_RELOC_YES_LOAD("#id_ready_to_relocate_1"),
    FIELD_FULL_DAY_LOAD("input[title=\'Полный день\']"),
    FIELD_FLEX_LOAD("input[title=\'Гибкий график\']"),
    FIELD_DIST_LOAD("input[title=\'Удаленно\']"),
    FIELD_S2("#id_gender > option:nth-child(2)"),
    FIELD_SM("m"),
    FIELD_COMP("id_company"),
    FIELD_POS("id_work"),
    FIELD_ADD_1_JAVA("#id_experience-0-experience > option:nth-child(3)"),
    FIELD_ADD_1_TIME("#id_experience-0-level > option:nth-child(2)"),
    FIELD_ADD_2_PERL("#id_experience-1-experience > option:nth-child(8)"),
    FIELD_ADD_2_TIME("#id_experience-1-level > option:nth-child(3)");

    private String name;

    ConstantData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}