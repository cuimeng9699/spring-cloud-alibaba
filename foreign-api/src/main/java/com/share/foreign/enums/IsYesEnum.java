package com.share.foreign.enums;

import lombok.Getter;

@Getter
public enum IsYesEnum {

    ROOT(0,"是"),
    MENU(1,"否");

    private Integer code;
    private String desc;
    IsYesEnum(Integer code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public static IsYesEnum getEnumByCode(Integer code){
        IsYesEnum[] permissionTypeEnums = IsYesEnum.values();
        for(IsYesEnum permissionTypeEnum:permissionTypeEnums){
            if(permissionTypeEnum.getCode().equals(code)){
                return permissionTypeEnum;
            }
        }
        return null;
    }

    public static IsYesEnum getEnumByName(String name){
        IsYesEnum[] permissionTypeEnums = IsYesEnum.values();
        for(IsYesEnum permissionTypeEnum:permissionTypeEnums){
            if(permissionTypeEnum.name().equals(name)){
                return permissionTypeEnum;
            }
        }
        return null;
    }
}
