package com.example.openfeign.enums.systemEnums;

public enum ErrorCode {
    FAILED_REQUEST(500, "系统内部异常", "FAILED"),
    SUCCESS_REQUEST(0, "调用成功", "SUCCESS"),
    BIZ_ERROR(1000, "业务逻辑异常", "business error"),
    PARAM_ERROR(1001, "参数错误", "param error"),
    MISS_PARAM_ERROR(1002, "缺少参数", "miss param error"),
    NO_AUTH(1003, "无操作权限", "Unauthorized operation"),
    SYSTEM_IS_BUSY(1004, "系统繁忙,请稍后重试", "system is busy, please try again later"),
    TASK_IS_RUNNING(1005, "任务执行中,请等待", "task is running, please wait"),
    DATABASE_ERROR(1006, "数据库操作错误", "operate db error"),
    NOT_LOGIN(1007, "账号未登录或已过期", "not login or expired"),
    NOT_FOUND(1008, "请求资源不存在", "resource not found"),
    ACCOUNT_NOT_EXIST(1009, "账号不存在,请联系管理员", "account not exist,please contact the administrator"),
    HERO_FLOW_NOT_FOUND(1010, "流程不存在", "hero_flow_not_found"),
    ILLEGAL_REQUEST(1011, "请求不合法", "illegal request"),
    USER_NEED_LOGIN(11001, "用户未登录，请登陆后进行访问", "USER_NEED_LOGIN"),
    USER_MAX_LOGIN(11002, "该用户已在其它地方登录", "USER_MAX_LOGIN"),
    USER_LOGIN_TIMEOUT(11003, "长时间未操作，自动退出", "USER_LOGIN_TIMEOUT"),
    USER_DISABLED(11004, "用户被禁11005用", "USER_DISABLED"),
    USER_LOCKED(11005, "用户被锁定", "USER_LOCKED"),
    USER_PASSWORD_ERROR(11006, "用户名或密码错误", "USER_PASSWORD_ERROR"),
    USER_PASSWORD_EXPIRED(11007, "用户密码过期", "USER_PASSWORD_EXPIRED"),
    USER_ACCOUNT_EXPIRED(11008, "用户账号过期", "USER_ACCOUNT_EXPIRED"),
    USER_NOT_EXIST(11009, "用户不存在", "USER_NOT_EXIST"),
    USER_LOGIN_FAIL(11010, "用户登录失败", "USER_LOGIN_FAIL"),
    VERIFY_CODE_ERROR(11011, "验证码错误", "VERIFY_CODE_ERROR"),
    USER_IS_EXIST(11012, "用户已存在", "USER_IS_EXIST"),
    NO_AUTHENTICATION(1003006, "无权访问", "NO_AUTHENTICATION"),
    USER_CAN_NOT_DELETE(11013, "自己不能删除自己", "USER_CAN_NOT_DELETE"),
    GIFT_INITIAL_ERROR(2000, "gift初始化异常", "gift initial failed"),
    GIFT_UPLOAD_ERROR(2001, "gift上传文件失败", "upload file to gift failed"),
    LOGIN_KICK_OUT(3009, "账号未登录或已在其他终端登录", "user login on other desk"),
    TIME_OVER(3500, "超出时间范围", "user login on other desk"),
    USER_INSERT_FAIL(4001, "添加用户失败", "fail insert user"),
    USER_DEL_FAIL(4002, "删除用户失败", "fail delete user"),
    HAS_NO_SUCH_USER(4003, "删除用户失败", "has no such user"),
    POLICE_NUMBER_HAS_EXIST(4004, "警员编号已存在", "police number has exist"),
    DEPT_NOT_EXIST(4005, "部门不存在", "dept not exist"),
    ROLE_NOT_EXIST(4006, "角色不存在", "role not exist"),
    OLD_PASSWORD_NOT_EXIST(4008, "旧密码不能为空", "old password cannot null"),
    NEW_PASSWORD_NOT_EXIST(4009, "新密码不能为空", "new password cannot null"),
    CONFIRM_PASSWORD_NOT_EXIST(4010, "确认密码不能为空", "new password cannot null"),
    OLD_PASSWORD_NOT_TRUE(4011, "旧密码出错", "old password wrong"),
    MOBILE_PHONE_REPEAT(4012, "手机号重复创建", "mobile phone repeat"),
    MOBILE_PHONE_INVALIDATE(40013, "手机号%s格式错误", "mobile error"),
    PASSWORD_IS_WEAK(40014, "密码较弱，必须包含数字、大小写字母，且至少六位", "password is weak"),
    NEW_CONFIRM_PASSWORD_NOT_SAME(4015, "新密码与原密码不能相同", "new and confirm password not same"),
    NEW_OLD_PASSWORD_SAME(4016, "新密码和旧密码一致", "new and old password same"),
    DEPT_HAS_USER(5001, "此辖区还存在警员,请核对后进行删除!", "dept has user,can't del"),
    FENCE_INFO_ERROR(5002, "围栏信息录入有误", "fence info error"),
    DEPT_NAME_REPEAT(5003, "辖区名称重复", "dept name repeat"),
    DEPT_NOT_OPEN(5004, "当前位置暂未开通！", "dept not open"),
    COMMAND_CENTER_HAS_POLICE_STATION(5005, "当前指挥中心下面还存在辖区派出所，请核对后进行删除!", "dept under has dept,can't del"),
    COUNTRY_HAS_DEPT(5006, "此辖区已存在指挥中心,请核对!", "Country has dept"),
    ALARM_TELEPHONE_ERROR(5007, "报警电话格式不正确，请重新输入", "alarm telephone error"),
    ALARM_TELEPHONE_REPEAT(5008, "报警电话重复", "alarm telephone repeat"),
    COUNTRY_HAS_COMMAND_CENTER(5009, "此辖区已存在指挥中心，请误添加/修改不区分警种类型的指挥中心!", "Country has command center"),
    COUNTRY_HAS_DISTINCT_COMMAND_CENTER(5010, "此辖区已存在110/122指挥中心，请误再添加/修改指挥中心!", "Country has distinct command center"),
    COUNTRY_HAS_NO_DISTINCT_COMMAND_CENTER(5011, "此辖区已存在不区分类型的指挥中心，请误再添加/修改指挥中心!", "Country has no distinct command center"),
    COUNTRY_HAS_THIS_TYPE_COMMAND_CENTER(5012, "此辖区已存在此类型的指挥中心，请误再添加/修改指挥中心!", "Country has this police type command center"),
    COMMAND_CENTER_NAME_REPEAT(5013, "指挥中心名称重复", "command center name repeat"),
    COUNTRY_HAS_TWO_DISTINCT_COMMAND_CENTER(5014, "此辖区已存在110/122指挥中心，请误修改为不区分类型的指挥中心!", "Country has distinct command center"),
    COMMAND_CENTER_NOT_EXIST(5015, "指挥中心不存在!", " command center not exist"),
    COMMAND_CENTER_POLICE_TYPE_CANNOT_MODIFY(5016, "请误修改指挥中心的警种类型，一个辖区只能存在一个110或者122类型", "Country has distinct command center"),
    PERMISSION_HAS_ERROR(6002, "传入操作权限ID有误", "these pemmissions id was wrong"),
    DATA_PERMISSION_HAS_ERROR(6003, "传入数据权限ID有误", "these data pemmissions id was wrong"),
    ROLE_NAME_HAS_EXIST(6004, "角色名不能重复", "role name can not repeat"),
    ROLE_INSERT_FAIL(6005, "该角色添加失败", "the role was inset fail"),
    ROLE_HAS_USER(6006, "该角色下面还有人员，不能删除", "role has user"),
    DATA_PERMISSION_NULL(6007, "请选择数据权限", "miss param error"),
    UPLOAD_NO_FILE(6008, "上传文件为空", "upload file is empty"),
    ROLE_HAS_NO_DEPT(6009, "当前用户无任何单位的权限，请配置好角色对应的数据权限范围", "role has no dept"),
    UPLOAD_NO_FILE_FORMAT(6010, "文件格式有误", "upload file format error"),
    ALARM_DO(7001, "警情已经处理", "upload file is empty"),
    NOT_ALARM(7002, "没有未接警的警情", "upload file is empty"),
    NOT_PLUNDER_ALARM(7003, "没有分派到警情，请重试", "upload file is empty"),
    HAS_DOING_ALARM(7004, "有未处理完毕的警情！", "upload file is empty"),
    HAS_RESERVATION_ALARM(7005, "当前时间段内有预约的警情！", "upload file is empty"),
    ALARM_CANCEL(7006, "对方已挂断", "upload file is empty"),
    NOT_SESSION_ID(8001, "没有获取到会议室id", "upload file is empty"),
    XING_YUN_ERROR(9001, "调用星云失败", "xing yun rpc error"),
    SHORT_URL_ERROR(9002, "链接无效", "url error"),
    TENANT_NO_TEMPLATE(9003, "租户未配置模板", "tenant has no template"),
    TENANT_NO_SMS(9004, "本%s短信流量已用完，超支%s条", "tenant has no sms use"),
    HANDLER_ALREADY_EXISTS(9005, "该手机号%s已存在", "The police officer already exists"),
    HANDLER_REPORTER_PHONE(9006, "处警员手机号不能与报警人手机号%s相同", "The mobile phone number of the police officer cannot be the same as that of the police officer"),
    REPORTER_CONTEXT_EXISTS(9007, "请先发送给报警人定位短信", "Please add the information of the caller first"),
    TENANT_NO_USE_SMS(9008, "本%s短信流量已用完", "tenant has no use sms"),
    JSON_PARSE_ERROR(10001, "反序列化错误", "parse error");

    private final int code;
    private String ChineseDes;
    private String EnglishDes;

    private ErrorCode(int code, String ChineseDes, String EnglishDes) {
        this.code = code;
        this.EnglishDes = EnglishDes;
        this.ChineseDes = ChineseDes;
    }

    public String getChineseDes() {
        return this.ChineseDes;
    }

    public void setChineseDes(String chineseDes) {
        this.ChineseDes = chineseDes;
    }

    public int getCode() {
        return this.code;
    }

    public String getDes() {
        return this.getChineseDes();
    }

    public String getEnglishDes() {
        return this.EnglishDes;
    }

    public void setEnglishDes(String englishDes) {
        this.EnglishDes = englishDes;
    }
}
