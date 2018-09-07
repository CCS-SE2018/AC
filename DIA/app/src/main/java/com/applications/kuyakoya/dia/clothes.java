package com.applications.kuyakoya.dia;

public class clothes {
    String clothesID;
    String type;
    String kind;
    String desc;

    public clothes(){

    }

    public clothes(String clothesID, String type, String kind, String desc) {
        this.clothesID = clothesID;
        this.type = type;
        this.kind = kind;
        this.desc = desc;
    }

    public String getClothesID() {
        return clothesID;
    }

    public String getType() {
        return type;
    }

    public String getKind() {
        return kind;
    }

    public String getDesc() {
        return desc;
    }
}
