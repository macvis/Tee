package demoPack;

import org.apache.commons.lang3.StringUtils;

public enum BusinessType {
    //BOSS系统
    TASK_MANAGE("WorkflowManage", "工作流管理", SystemName.BOSS),
    SYSTEM_OPERATION("SystemOperation", "系统操作", SystemName.BOSS),
    BOSS_USER_OPERATION("BossUserOperation", "用户操作", SystemName.BOSS),
    ORDER_PUSH("OrderPush", "订单推送", SystemName.BOSS),
    AUTH_CONFIG("AuthConfig", "系统权限管理", SystemName.BOSS),
    ROLE_CONFIG("RoleConfig", "系统角色管理", SystemName.BOSS),
    APP_CONFIG("AppConfig", "系统应用管理", SystemName.BOSS),
    USER_CONFIG("UserConfig", "系统用户管理", SystemName.BOSS),
    SYSTEM_CONFIG("SystemConfig", "系统基础配置", SystemName.BOSS),
    CARD_BIN_CONFIG("CardBinConfig", "卡Bin卡表配置", SystemName.BOSS),
    SMS_TEMP_CONFIG("SmsTempConfig", "短信模板配置", SystemName.BOSS),
    TAG_CONFIG("TagConfig", "标签配置管理", SystemName.BOSS),
    TEMP_CONFIG("TempConfig", "配置模板管理", SystemName.BOSS),
    MAIL_TEMP_CONFIG("MailTempConfig", "邮件通知配置", SystemName.BOSS),
    CACHE_REFRESH_CONFIG("CacheRefreshConfig", "缓存刷新配置", SystemName.BOSS),
    PLATFORM_MANAGE("PlatformManage", "商户管理", SystemName.BOSS),
    INTERFACE_CONFIG("InterfaceConfig", "接口配置", SystemName.BOSS),
    SIGN_CONFIG("SignConfig", "签名配置", SystemName.BOSS),
    ADMINISTRATOR_MANAGE("AdministratorManage", "管理员管理", SystemName.BOSS),
    PAYGATE_PLATFORM_CONFIG("PayGatePlatformConfig", "网关商户配置", SystemName.BOSS),
    PLATFORM_QUICK_OPEN("PlatformQuickOpen", "一键开户", SystemName.BOSS),
    PRODUCT_MANAGE("ProductManage", "产品管理", SystemName.BOSS),
    PLATFORM_AUTH("PlatformAuth", "商户权限", SystemName.BOSS),
    INTERFACE_MANAGE("InterfaceManage", "接口管理", SystemName.BOSS),
    PLATFORM_VERIFICATION("PlatformVerification", "商户核查", SystemName.BOSS),
    PLATFORM_INSURANCE_REPORT("PlatformInsuranceReport", "商险上报", SystemName.BOSS),
    ADVERTISEMENT_CONFIG("AdvertisementConfig", "广告配置", SystemName.BOSS),
    THIRD_SERVICE_MANAGE("ThirdServiceManage", "第三方服务管理", SystemName.BOSS),
    GAME_CONFIG("GameConfig", "游戏配置", SystemName.BOSS),
    APP_MESSAGE_PUSH("AppMessagePush", "APP消息推送", SystemName.BOSS),
    MARKETING_SMS_PUSH("MarketingSmsPush", "营销短信推送", SystemName.BOSS),
    HONGBAO_MANAGE("HongbaoManage", "红包管理", SystemName.BOSS),
    YOUHUI_MANAGE("YouhuiManage", "优惠管理", SystemName.BOSS),
    JIANGPING_MANAGE("JiangpingManage", "奖品管理", SystemName.BOSS),
    HUODONG_MANAGE("HuodongManage", "活动管理", SystemName.BOSS),
    DISTRIBUTE_TASK_MANAGE("DistributeTaskManage", "派发任务", SystemName.BOSS),

    //客服系统
    CUSTOMER_USER_OPERATION("CustomerUserOperation", "用户操作", SystemName.CUSTOMER),
    CATALOG_MANAGE("CatalogManage", "目录管理", SystemName.CUSTOMER),
    PROBLEM_MANAGE("ProblemManage", "问题管理", SystemName.CUSTOMER),
    USER_FEEDBACK("UserFeedback", "用户反馈", SystemName.CUSTOMER),
    MANUAL_AUDIT("ManualAudit", "人工审核", SystemName.CUSTOMER),
    ACCOUNT_MANAGE("AccountManage", "账户管理", SystemName.CUSTOMER),
    INTEGRATED_QUERY("IntegratedQuery", "综合查询", SystemName.CUSTOMER),
    XFJR_QUERY("XFJRQuery", "消费金融查询", SystemName.CUSTOMER),

    //商户系统
    PLATFORM_ADMIN_MANAGE("PlatformAdminManage", "商户管理员管理", SystemName.PLATFORM),
    PLATFORM_INFO_MANAGE("PlatformInfoManage", "商户基本信息管理", SystemName.PLATFORM),
    PLATFORM_COMPANY_INFO_MANAGE("PlatformCompanyInfoManage", "商户公司信息管理", SystemName.PLATFORM),
    PLATFORM_USER_OPERATION("PlatformUserOperation", "商户系统用户操作", SystemName.PLATFORM),

    // 聚合支付
    APAY_APP_MANAGE("ApayAppManange", "聚合支付业务管理", SystemName.APAY),
    APAY_APP_CHANNEL_MANAGE("ApayChannelManage", "聚合支付渠道配置管理", SystemName.APAY),
    APAY_USER_OPERATION("ApayUserOperation", "聚合支付用户操作", SystemName.APAY);

    private String type;
    private String desc;
    private SystemName systemName;

    public static BusinessType getBusinessTypeByType(String type) {
        if (StringUtils.isBlank(type)) {
            return null;
        } else {
            BusinessType[] businessTypes = values();

            for(int i = 0; i < businessTypes.length; ++i) {
                if (type.equals(businessTypes[i].getType())) {
                    return businessTypes[i];
                }
            }

            return null;
        }
    }

    public static void printDESC(String sysName){
        BusinessType[] businessTypes = values();

        for(BusinessType type : businessTypes){
            if(StringUtils.equals(type.getSystemName().getDesc(), sysName)){
                System.out.println(type.getDesc() + "------");
                String desc = type.getDesc();
                BusinessSubType.printDESC(desc);
            }
        }
    }

    private BusinessType(String type, String desc, SystemName systemName) {
        this.type = type;
        this.desc = desc;
        this.systemName = systemName;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getType() {
        return this.type;
    }

    public SystemName getSystemName() {
        return this.systemName;
    }

}
