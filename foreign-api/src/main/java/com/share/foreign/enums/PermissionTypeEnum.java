package com.share.foreign.enums;


public enum PermissionTypeEnum {

    /***
     * 权限类型
     */
    ROOT(0,"资源根节点"),
    MENU(1,"菜单"),
    URL(2,"链接");

    private Integer code;
    private String desc;
    PermissionTypeEnum(Integer code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public static PermissionTypeEnum getEnumByCode(Integer code){
        PermissionTypeEnum[] permissionTypeEnums = PermissionTypeEnum.values();
        for(PermissionTypeEnum permissionTypeEnum:permissionTypeEnums){
            if(permissionTypeEnum.getCode().equals(code)){
                return permissionTypeEnum;
            }
        }
        return null;
    }

    public static PermissionTypeEnum getEnumByName(String name){
        PermissionTypeEnum[] permissionTypeEnums = PermissionTypeEnum.values();
        for(PermissionTypeEnum permissionTypeEnum:permissionTypeEnums){
            if(permissionTypeEnum.name().equals(name)){
                return permissionTypeEnum;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
