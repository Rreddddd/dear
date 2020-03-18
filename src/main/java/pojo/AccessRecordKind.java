package pojo;

public enum AccessRecordKind {

    birthday_twenty_start("20岁生日起始页面","birthday_twenty_start"),
    birthday_twenty_view("20岁生日中间页面","birthday_twenty_start"),
    birthday_twenty_memories("20岁生日作文页面","birthday_twenty_start");

    private String name;
    private String code;

    AccessRecordKind(String name,String code){
        this.name=name;
        this.code=code;
    }

    public String getCode() {
        return code;
    }

    public String getName(){
        return name;
    }
}
