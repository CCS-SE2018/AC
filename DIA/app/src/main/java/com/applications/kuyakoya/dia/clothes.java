package com.applications.kuyakoya.dia;

public class clothes {
    String image_Path;
    String clothesID;
    String clothes_type;
    String clothes_kind;
    String clothes_description;
    String clothes_available;

    public  clothes(){

    }

    public clothes(String clothesID, String type, String kind, String desc, String available, String image) {
        this.clothesID = clothesID;
        this.clothes_type = type;
        this.clothes_kind = kind;
        this.clothes_description = desc;
        this.clothes_available = available;
        this.image_Path = image;
    }

    public String getImage_Path() {
        return image_Path;
    }

    public String getClothesID() {
        return clothesID;
    }

    public String getClothes_type() {
        return clothes_type;
    }

    public String getClothes_kind() {
        return clothes_kind;
    }

    public String getClothes_description() {
        return clothes_description;
    }

    public String getClothes_available() {
        return clothes_available;
    }

    public void setImage_Path(String image_Path) {
        this.image_Path = image_Path;
    }
}
