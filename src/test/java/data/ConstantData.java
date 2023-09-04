package data;

public enum ConstantData {
    DELCONTACTS1OF2("div.js-formset-row:nth-child("),
    DELCONTACTS2OF2(") > div:nth-child(4) > div:nth-child(2) > button:nth-child(1)"),
    DELEXP1OF2("div:nth-child("),
    DELEXP2OF2(") > div.experience-row__remove.ic-close.js-formset-delete"),
    VKSTRING("https://vk.ru/profile/132456"),
    OKSTRING("https://ok.ru/profile/846341"),
    TLGSTRING("TELEGRAM:131853131"),
    SKSTRING("SKYPE:8431351313"),
    FIELD_ADD_1_TIME_STRING("1 год"),
    FIELD_ADD_2_TIME_STRING("2 года"),
    VAL("value"),
    VAL0("id_contact-0-value"),
    VAL1("id_contact-1-value"),
    VAL2("id_contact-2-value"),
    VAL3("id_contact-3-value");

    private String name;

    ConstantData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
