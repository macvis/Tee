package demoPack;

import org.apache.commons.lang3.StringUtils;

public enum BusinessSubType {
    /************* boss系统start *****************/
    //BOSS系统---权限管理
    AUTH_ADD("AuthAdd", "权限新增", BusinessType.AUTH_CONFIG),
    AUTH_UPDATE("AuthUpdate", "权限修改", BusinessType.AUTH_CONFIG),
    ROLE_ADD("RoleAdd", "角色新增", BusinessType.ROLE_CONFIG),
    ROLE_UPDATE("RoleUpdate", "角色修改", BusinessType.ROLE_CONFIG),
    ROLE_AUTH("RoleAuth", "角色授权", BusinessType.ROLE_CONFIG),
    APP_ADD("AppConfig", "应用新增", BusinessType.APP_CONFIG),
    APP_UPDATE("AppUpdate", "应用修改", BusinessType.APP_CONFIG),
    APP_AUTH("AppAuth", "应用授权", BusinessType.APP_CONFIG),
    USER_ADD("UserAdd", "用户新增", BusinessType.USER_CONFIG),
    USER_UPDATE("UserUpdate", "用户修改", BusinessType.USER_CONFIG),
    USER_CHANGE_PASSWORD("UserChangePassword", "密码修改", BusinessType.USER_CONFIG),
    USER_AUTH("UserAuth", "用户授权", BusinessType.USER_CONFIG),
    USER_UNLOCK("UserUnLock", "用户解锁", BusinessType.USER_CONFIG),

    //BOSS系统---工作流管理
    TASK_ASSIGN("TaskAssign", "任务指派", BusinessType.TASK_MANAGE),
    INSTANCE_HANGUP("InstanceHangUp", "实例挂起", BusinessType.TASK_MANAGE),
    BOSS_WORKFLOW("BossWorkflow", "工作流", BusinessType.TASK_MANAGE),

    //BOSS系统---短信模板配置
    SMS_TEMP_ADD("SmsTempAdd", "短信模板新增", BusinessType.SMS_TEMP_CONFIG),
    SMS_TEMP_UPDATE("SmsTempUpdate", "短信模板修改", BusinessType.SMS_TEMP_CONFIG),
    SMS_TEMP_DELETE("SmsTempDelete", "短信模板删除", BusinessType.SMS_TEMP_CONFIG),

    //BOSS系统---卡bin卡表配置
    CARD_BIN_ADD("CardBinAdd", "卡Bin卡表新增", BusinessType.CARD_BIN_CONFIG),
    CARD_BIN_UPDATE("CardBinUpdate", "卡Bin卡表修改", BusinessType.CARD_BIN_CONFIG),
    CARD_BIN_BATCH("CardBinBatch", "卡Bin卡表批量变更", BusinessType.CARD_BIN_CONFIG),

    //BOSS系统---标签配置管理
    TAG_ADD("TagAdd", "标签新增", BusinessType.TAG_CONFIG),
    TAG_DELETE("TagDelete", "标签删除", BusinessType.TAG_CONFIG),
    TAG_UPDATE("TagUpdate", "标签修改", BusinessType.TAG_CONFIG),

    //BOSS系统---签名配置
    SIGN_ADD("SignAdd", "签名新增", BusinessType.SIGN_CONFIG),
    SIGN_UPDATE("SignUpdate", "签名修改", BusinessType.SIGN_CONFIG),
    SIGN_DELETE("SignDelete", "签名删除", BusinessType.SIGN_CONFIG),
    SIGN_AUTH_IP("SignAuthIp", "签名IP白名单", BusinessType.SIGN_CONFIG),

    //BOSS系统---系统基础配置
    SYSTEM_COMMON_ADD("SystemCommonAdd", "系统预设值新增", BusinessType.SYSTEM_CONFIG),
    SYSTEM_COMMON_UPDATE("SystemCommonUpdate", "系统预设值修改", BusinessType.SYSTEM_CONFIG),
    SYSTEM_INI_ADD("SystemIniAdd", "系统INI新增", BusinessType.SYSTEM_CONFIG),
    SYSTEM_INI_UPDATE("SystemIniUpdate", "系统INI修改", BusinessType.SYSTEM_CONFIG),
    SYSTEM_INI_DELETE("SystemIniDelete", "系统INI删除", BusinessType.SYSTEM_CONFIG),
    SYSTEM_ERRORCODE_ADD("SystemErrorCodeAdd", "系统错误码新增", BusinessType.SYSTEM_CONFIG),
    SYSTEM_ERRORCODE_UPDATE("SystemErrorCodeUpdate", "系统错误码修改", BusinessType.SYSTEM_CONFIG),
    SYSTEM_SERVICE_ADD("SystemServiceAdd", "网易宝服务新增", BusinessType.SYSTEM_CONFIG),
    SYSTEM_SERVICE_UPDATE("SystemServiceUpdate", "网易宝服务修改", BusinessType.SYSTEM_CONFIG),
    SYSTEM_SERVICE_DELETE("SystemServiceDelete", "网易宝服务删除", BusinessType.SYSTEM_CONFIG),
    SYSTEM_ERRCODE_MAP_ADD("SystemErrcodeMapAdd", "错误码业务映射新增", BusinessType.SYSTEM_CONFIG),
    SYSTEM_ERRCODE_MAP_UPDATE("SystemErrcodeMapUpdate", "错误码业务映射修改", BusinessType.SYSTEM_CONFIG),
    SYSTEM_ERRCODE_MAP_DELETE("SystemErrcodeMapDelete", "错误码业务映射删除", BusinessType.SYSTEM_CONFIG),
    SYSTEM_BANK_INFO_UPDATE("SystemBankInfoUpdate", "支行信息修改", BusinessType.SYSTEM_CONFIG),
    SYSTEM_CUSTOMS_ADD("SystemCustomsAdd", "海关信息新增", BusinessType.SYSTEM_CONFIG),
    SYSTEM_CUSTOMS_UPDATE("SystemCustomsUpdate", "海关信息修改", BusinessType.SYSTEM_CONFIG),

    //BOSS系统 --- 配置模板管理
    TEMP_CONFIG_ADD("TempConfigAdd", "配置模板新增", BusinessType.TEMP_CONFIG),
    TEMP_CONFIG_UPDATE("TempConfigUpdate", "配置模板修改", BusinessType.TEMP_CONFIG),
    TEMP_CONFIG_DATA_ADD("TempConfigDataAdd", "配置模板数据新增", BusinessType.TEMP_CONFIG),
    TEMP_CONFIG_DATA_UPDATE("TempConfigDataUpdate", "配置模板数据修改", BusinessType.TEMP_CONFIG),

    //BOSS系统 ---邮件通知配置
    MAIL_TEMP_ADD("MailTempAdd", "邮件通知新增", BusinessType.MAIL_TEMP_CONFIG),
    MAIL_TEMP_UPDATE("MailTempUpdate", "邮件通知修改", BusinessType.MAIL_TEMP_CONFIG),

    //BOSS系统---网关商户配置
    PAYGATE_PLATFORM_MERCHANT_ADD("PayGatePlatformMerchantAdd", "网关商户新增", BusinessType.PAYGATE_PLATFORM_CONFIG),
    PAYGATE_PLATFORM_MERCHANT_UPDATE("PayGatePlatformMerchantUpdate", "网关商户修改", BusinessType.PAYGATE_PLATFORM_CONFIG),
    PAYGATE_PLATFORM_CHANNEL_ADD("PayGatePlatformChannelAdd", "网关渠道新增", BusinessType.PAYGATE_PLATFORM_CONFIG),
    PAYGATE_PLATFORM_CHANNEL_UPDATE("PayGatePlatformChannelUpdate", "网关渠道修改", BusinessType.PAYGATE_PLATFORM_CONFIG),

    //BOSS系统----缓存刷新配置
    CACHE_REFRESH_ITEM_ADD("CacheRefreshItemAdd", "缓存刷新项新增", BusinessType.CACHE_REFRESH_CONFIG),
    CACHE_REFRESH_ITEM_UPDATE("CacheRefreshItemUpdate", "缓存刷新项修改", BusinessType.CACHE_REFRESH_CONFIG),
    CACHE_REFRESH_ITEM_DELETE("CacheRefreshItemDelete", "缓存刷新项删除", BusinessType.CACHE_REFRESH_CONFIG),
    CACHE_REFRESH_APP_ADD("CacheRefreshAppAdd", "缓存刷新应用新增", BusinessType.CACHE_REFRESH_CONFIG),
    CACHE_REFRESH_APP_UPDATE("CacheRefreshAppUpdate", "缓存刷新应用修改", BusinessType.CACHE_REFRESH_CONFIG),

    //BOSS系统---用户操作
    BOSS_USER_LOGIN("UserLogin", "用户登录", BusinessType.BOSS_USER_OPERATION),
    BOSS_USER_LOGOUT("UserLogout", "用户登出", BusinessType.BOSS_USER_OPERATION),

    //BOSS系统---系统操作
    FILE_UPLOAD("FileUpload", "文件上传", BusinessType.SYSTEM_OPERATION),
    CACHE_REFRESH("CacheRefresh", "缓存刷新", BusinessType.SYSTEM_OPERATION),
    CACHE_MANAGE("CacheManage", "缓存管理", BusinessType.SYSTEM_OPERATION),
    PRIVACY_DEAL("PrivacyDeal", "隐私加解密", BusinessType.SYSTEM_OPERATION),
    RECHARGE_REFUND("RechargeRefund", "充值退款", BusinessType.SYSTEM_OPERATION),

    //BOSS系统---订单推送
    BATCH_ORDER_NOTIFY("BatchOrderNotify", "批量订单发送通知", BusinessType.ORDER_PUSH),
    BATCH_NOTIFY_PLATFORM("BatchOrderNotify", "批量通知商户", BusinessType.ORDER_PUSH),
    CUSTOM_PUSH("CrossPush", "跨境海关推送", BusinessType.ORDER_PUSH),
    BATCH_CUSTOM_PUSH("BatchCustomPush", "批量跨境订单推送", BusinessType.ORDER_PUSH),

    //BOSS系统----接口管理
    INTERFACE_ADD("NewInterfaceAdd", "接口新增", BusinessType.INTERFACE_MANAGE),
    INTERFACE_UPDATE("NewInterfaceUpdate", "接口修改", BusinessType.INTERFACE_MANAGE),

    //BOSS系统----接口配置
    NEW_INTERFACE_AUTH_ADD("NewInterfaceAuthAdd", "新接口权限新增", BusinessType.INTERFACE_CONFIG),
    NEW_INTERFACE_AUTH_UPDATE("NewInterfaceAuthUpdate", "新接口权限修改", BusinessType.INTERFACE_CONFIG),
    NEW_INTERFACE_AUTH_DELETE("NewInterfaceAuthModify", "新接口权限删除", BusinessType.INTERFACE_CONFIG),
    OLD_INTERFACE_ADD("OldInterfaceAdd", "老接口权限新增", BusinessType.INTERFACE_CONFIG),
    OLD_INTERFACE_DELETE("OldInterfaceDelete", "老接口权限删除", BusinessType.INTERFACE_CONFIG),

    //BOSS系统----商户权限
    PLATFORM_AUTH_ADD("PlatformAuthAdd", "商户权限新增", BusinessType.PLATFORM_AUTH),
    PLATFORM_AUTH_UPDATE("PlatformAuthUpdate", "商户权限修改", BusinessType.PLATFORM_AUTH),

    //BOSS系统---产品管理
    PRODUCT_ADD("ProductAdd", "产品新增", BusinessType.PRODUCT_MANAGE),
    PRODUCT_UPDATE("ProductUpdate", "产品修改", BusinessType.PRODUCT_MANAGE),
    PRODUCT_AUTH_MENU("ProductAuthMenu", "产品菜单权限分配", BusinessType.PRODUCT_MANAGE),
    PRODUCT_AUTH_INTERFACE("ProductAuthInterface", "产品接口权限分配", BusinessType.PRODUCT_MANAGE),

    //BOSS系统---管理员管理
    ADMINISTRATOR_UPDATE("AdministratorUpdate", "管理员修改", BusinessType.ADMINISTRATOR_MANAGE),
    ADMINISTRATOR_RESET_PAYPWD("AdministratorRestPayPwd", "管理员重置支付密码", BusinessType.ADMINISTRATOR_MANAGE),
    ADMINISTRATOR_RESET_LOGINPWD("AdministratorRestLoginPwd", "管理员重置登录密码", BusinessType.ADMINISTRATOR_MANAGE),

    //BOSS系统---商户核查
    PLATFORM_VERIFY_PASS("PlatformBatchVerifyPass", "商户核查通过", BusinessType.PLATFORM_VERIFICATION),
    PLATFORM_VERIFY_UPLOAD("PlatformBatchVerifyUpload", "商户核查备注", BusinessType.PLATFORM_VERIFICATION),

    //BOSS系统---商险上报
    PLATFORM_INSURANCE_REPORT("PlatformInsuranceReport", "商险上报", BusinessType.PLATFORM_INSURANCE_REPORT),

    //BOSS系统---一键开户
    PLATFORM_QUICK_OPEN_GROUP("PlatformQuickOpenGroup", "集团商户添加", BusinessType.PLATFORM_QUICK_OPEN),
    PLATFORM_QUICK_OPEN_PLATFORM("PlatformQuickOpenPlatform", "子商户添加", BusinessType.PLATFORM_QUICK_OPEN),
    PLATFORM_BINDING_PLATFORM("PlatformBindingPlatform", "子商户绑定", BusinessType.PLATFORM_QUICK_OPEN),

    //BOSS系统---商户权限
    PLATFORM_NEW_INTERFACE_AUTH("PlatformNewInterfaceAuth", "商户新接口分配", BusinessType.PLATFORM_AUTH),
    PLATFORM_OLD_INTERFACE_AUTH("PlatformOldInterfaceAuth", "商户老接口分配", BusinessType.PLATFORM_AUTH),

    //BOSS系统---商户管理
    PLATFORM_MENU_AUTH("PlatformMenuAuth", "商户菜单权限分配", BusinessType.PLATFORM_MANAGE),
    PLATFORM_CANCEL("PlatformCancel", "商户注销", BusinessType.PLATFORM_MANAGE),
    PLATFORM_COMMON_UPDATE("PlatformCommonUpdate", "商户基本信息修改", BusinessType.PLATFORM_MANAGE),
    PLATFORM_COMPANY_UPDATE("PlatformCompanyUpdate", "商户公司信息修改", BusinessType.PLATFORM_MANAGE),
    PLATFORM_CONTACTS_ADD("PlatformContactsAdd", "商户联系人新增", BusinessType.PLATFORM_MANAGE),
    PLATFORM_CONTACTS_UPDATE("PlatformContactsUpdate", "商户联系人修改", BusinessType.PLATFORM_MANAGE),
    PLATFORM_IP_UPDATE("PlatformIpUpdate", "商户IP修改", BusinessType.PLATFORM_MANAGE),
    PLATFORM_ORDER_TIMEOUT_ADD("PlatformOrderTimeoutAdd", "商户超时设置新增", BusinessType.PLATFORM_MANAGE),
    PLATFORM_ORDER_TIMEOUT_UPDATE("PlatformOrderTimeoutUpdate", "商户超时设置修改", BusinessType.PLATFORM_MANAGE),
    PLATFORM_ORDER_TIMEOUT_DELETE("PlatformOrderTimeoutDelete", "商户超时设置删除", BusinessType.PLATFORM_MANAGE),
    PLATFORM_NOTIFY_CONFIG("PlatformNotifyConfig", "商户通知设置", BusinessType.PLATFORM_MANAGE),
    PLATFORM_BANK_CHANGE("PlatformBankChange", "商户银行卡修改", BusinessType.PLATFORM_MANAGE),
    PLATFORM_ACCOUNT_REGISTER("PlatformAccountRegister", "注册商户账号", BusinessType.PLATFORM_MANAGE),
    PLATFORM_MAIL_NOTIFY("PlatformMailNotify", "商户邮件通知", BusinessType.PLATFORM_MANAGE),

    //BOSS系统---第三方服务管理
    THIRD_SERVICE_ADD("ThirdServiceAdd", "第三方服务新增", BusinessType.THIRD_SERVICE_MANAGE),
    THIRD_SERVICE_UPDATE("ThirdServiceUpdate", "第三方服务修改", BusinessType.THIRD_SERVICE_MANAGE),
    THIRD_SERVICE_DELETE("ThirdServiceDelete", "第三方服务删除", BusinessType.THIRD_SERVICE_MANAGE),

    //BOSS系统---游戏配置
    GAME_CONFIG_ADD("GameConfigAdd", "游戏配置新增", BusinessType.GAME_CONFIG),
    GAME_CONFIG_UPDATE("GameConfigUpdate", "游戏配置修改", BusinessType.GAME_CONFIG),
    GAME_CONFIG_DELETE("GameConfigDelete", "游戏配置删除", BusinessType.GAME_CONFIG),
    GAME_CONFIG_FLUSH("GameConfigFlush", "游戏配置刷新", BusinessType.GAME_CONFIG),
    GAME_CONFIG_ONLINE("GameConfigOnline", "游戏配置上线", BusinessType.GAME_CONFIG),
    GAME_CONFIG_OFFLINE("GameConfigOffline", "游戏配置下线", BusinessType.GAME_CONFIG),
    GAME_CONFIG_PRICE_ADD("GameConfigPriceAdd", "游戏价格新增", BusinessType.GAME_CONFIG),
    GAME_CONFIG_PRICE_UPDATE("GameConfigPriceUpdate", "游戏价格修改", BusinessType.GAME_CONFIG),
    GAME_CONFIG_PRICE_DELETE("GameConfigPriceDelete", "游戏价格删除", BusinessType.GAME_CONFIG),
    GAME_CONFIG_CHANNEL_ADD("GameConfigChannelAdd", "游戏渠道新增", BusinessType.GAME_CONFIG),
    GAME_CONFIG_CHANNEL_UPDATE("GameConfigChannelUpdate", "游戏渠道修改", BusinessType.GAME_CONFIG),

    //BOSS系统---广告配置
    ADVERTISEMENT_BANNER_ADD("AdvertisementBannerAdd", "版本新增", BusinessType.ADVERTISEMENT_CONFIG),
    ADVERTISEMENT_BANNER_UPDATE("AdvertisementBannerUpdate", "版本修改", BusinessType.ADVERTISEMENT_CONFIG),
    ADVERTISEMENT_ADD("AdvertisementAdd", "广告位新增", BusinessType.ADVERTISEMENT_CONFIG),
    ADVERTISEMENT_UPDATE("AdvertisementUpdate", "广告位修改", BusinessType.ADVERTISEMENT_CONFIG),
    ADVERTISEMENT_DELETE("AdvertisementDelete", "广告位删除", BusinessType.ADVERTISEMENT_CONFIG),

    //BOSS系统---APP消息推送
    APP_MESSAGE_PUSH_ADD("AppMessagePushAdd", "APP消息推送新增", BusinessType.APP_MESSAGE_PUSH),
    APP_MESSAGE_PUSH_UPDATE("AppMessagePushUpdate", "APP消息推送修改", BusinessType.APP_MESSAGE_PUSH),
    APP_MESSAGE_PUSH_DELETE("AppMessagePushDelete", "APP消息推送删除", BusinessType.APP_MESSAGE_PUSH),
    APP_MESSAGE_PUSH("AppMessagePush", "推送APP消息", BusinessType.APP_MESSAGE_PUSH),

    //BOSS系统---营销短信推送
    MARKETING_SMS_PUSH_ADD("MarketingSmsPushAdd", "营销短信推送新增", BusinessType.MARKETING_SMS_PUSH),
    MARKETING_SMS_PUSH_UPDATE("MarketingSmsPushUpdate", "营销短信推送修改", BusinessType.MARKETING_SMS_PUSH),
    MARKETING_SMS_PUSH_DELETE("MarketingSmsPushDelete", "营销短信推送删除", BusinessType.MARKETING_SMS_PUSH),
    MARKETING_SMS_PUSH("MarketingSmsPush", "推送营销短信", BusinessType.MARKETING_SMS_PUSH),

    //BOSS系统---红包管理
    HONGBAO_ADD("HongbaoAdd", "红包方案新增", BusinessType.HONGBAO_MANAGE),
    HONGBAO_UPDATE("HongbaoUpdate", "红包方案修改", BusinessType.HONGBAO_MANAGE),

    //BOSS系统---优惠管理
    YOUHUI_ADD("YouhuiAdd", "优惠方案新增", BusinessType.YOUHUI_MANAGE),
    YOUHUI_UPDATE("YouhuiUpdate", "优惠方案修改", BusinessType.YOUHUI_MANAGE),

    //BOSS系统---奖品管理
    JIANGPING_ADD("JiangpingAdd", "奖品方案新增", BusinessType.JIANGPING_MANAGE),
    JIANGPING_UPDATE("JiangpingManage", "奖品方案修改", BusinessType.JIANGPING_MANAGE),

    //BOSS系统---活动管理
    HUODONG_ADD("HuodongAdd", "活动方案新增", BusinessType.HUODONG_MANAGE),
    HUODONG_UPDATE("HuodongUpdate", "活动方案修改", BusinessType.HUODONG_MANAGE),

    //BOSS系统---派发任务
    DISTRIBUTE_TASK_ADD("DistributeTaskAdd", "派发任务新增", BusinessType.DISTRIBUTE_TASK_MANAGE),
    /************* boss系统end *****************/


    /************* 商户系统start *****************/
    //商户系统-管理员管理
    PLATFORM_ADMIN_ADD("PlatformAdminAdd", "新增管理员", BusinessType.PLATFORM_ADMIN_MANAGE),
    PLATFORM_ADMIN_UPDATE("PlatformAdminUpdate", "修改管理员信息", BusinessType.PLATFORM_ADMIN_MANAGE),
    PLATFORM_ADMIN_CANCEL("PlatformAdminCancel", "注销管理员", BusinessType.PLATFORM_ADMIN_MANAGE),
    PAY_PASSWORD_RESET("PayPasswordReset", "重置支付密码", BusinessType.PLATFORM_ADMIN_MANAGE),
    LOGIN_PASSWORD_RESET("LoginPasswordReset", "重置登陆密码", BusinessType.PLATFORM_ADMIN_MANAGE),
    PAY_PASSWORD_UPDATE("PayPasswordUpdate", "修改支付密码", BusinessType.PLATFORM_ADMIN_MANAGE),
    LOGIN_PASSWORD_UPDATE("LoginPasswordUpdate", "修改登录密码", BusinessType.PLATFORM_ADMIN_MANAGE),
    ADMIN_EKEY_UPDATE("AdminEkeyUpdate", "修改将军令序列号", BusinessType.PLATFORM_ADMIN_MANAGE),

    //商户系统-商户基本信息管理
    PLATFORM_INFO_UPDATE("PlatformInfoUpdate", "修改商户基本信息", BusinessType.PLATFORM_INFO_MANAGE),

    //商户系统-商户公司信息管理
    PLATFORM_COMPANY_INFO_UPDATE("PlatformCompanyInfoUpdate", "修改商户公司信息", BusinessType.PLATFORM_COMPANY_INFO_MANAGE),

    //商户系统-用户操作
    PLATFORM_USER_LOGIN("PlatformUserLogin", "商户系统登录", BusinessType.PLATFORM_USER_OPERATION),
    PLATFORM_USER_LOGOUT("PlatformUserLogout", "商户系统登出", BusinessType.PLATFORM_USER_OPERATION),

    /************* 商户系统end *****************/

    /************* 客服系统start *****************/
    //客服系统---目录管理
    CATALOG_ADD("CatalogAdd", "目录新增", BusinessType.CATALOG_MANAGE),
    CATALOG_UPDATE("CatalogUpdate", "目录修改", BusinessType.CATALOG_MANAGE),
    CATALOG_DELETE("CatalogDelete", "目录删除", BusinessType.CATALOG_MANAGE),

    //客服系统---问题管理
    PROBLEM_ADD("ProblemAdd", "问题新增", BusinessType.PROBLEM_MANAGE),
    PROBLEM_UPDATE("ProblemUpdate", "问题修改", BusinessType.PROBLEM_MANAGE),
    PROBLEM_DELETE("ProblemDelete", "问题删除", BusinessType.PROBLEM_MANAGE),

    //客服系统---用户反馈
    USER_FEEDBACK_REMARK("UserFeedbackRemark", "用户反馈备注", BusinessType.USER_FEEDBACK),
    USER_FEEDBACK_IGNORE("UserFeedbackIgnore", "用户反馈忽略", BusinessType.USER_FEEDBACK),
    USER_FEEDBACK_REPLY("UserFeedbackReply", "用户反馈回复", BusinessType.USER_FEEDBACK),

    //客服系统---用户操作
    CUSTOMER_USER_LOGIN("UserLogin", "用户登录", BusinessType.CUSTOMER_USER_OPERATION),
    CUSTOMER_USER_LOGOUT("UserLogout", "用户登出", BusinessType.CUSTOMER_USER_OPERATION),

    //客服系统---人工审核
    ANTI_MONEY_LAUNDERING_IDENTITY_VERIFY("AntiMoneyLaunderingIdentityVerify", "反洗钱人工审核", BusinessType.MANUAL_AUDIT),
    RISK_IDENTITY_VERIFY("RiskIdentityVerify", "风控人工审核", BusinessType.MANUAL_AUDIT),
    ACTIVATE_IDENTITY_VERIFY("ActivateIdentityVerify", "注册激活人工审核", BusinessType.MANUAL_AUDIT),
    IDENTIFY_INFO_UPDATE("IdentifyInfoUpdate", "身份信息修改", BusinessType.MANUAL_AUDIT),
    ACCOUNT_FREEZE_AUDIT("AccountFreezeAudit", "账号冻结审核", BusinessType.MANUAL_AUDIT),
    NAME_USED_BEFORE("NameUsedBeforeAudit", "曾用名修改审核", BusinessType.MANUAL_AUDIT),
    DOUBLE_ACCOUNT("DoubleAccountAudit", "双重户口注销审核", BusinessType.MANUAL_AUDIT),
    MODIFY_NAME("ModifyNameAudit", "姓名修正审核", BusinessType.MANUAL_AUDIT),
    EMIGRATION("EmigrationAudit", "移居海外审核", BusinessType.MANUAL_AUDIT),
    BANK_ANOMALY("BankAnomalyAudit", "银行异常交易审核", BusinessType.MANUAL_AUDIT),
    BALANCE_ANOMALY("BalanceAnomalyAudit", "余额异常交易审核", BusinessType.MANUAL_AUDIT),
    QUICKPAY_ANOMALY("QuickPayAnomalyAudit", "快捷支付异常审核", BusinessType.MANUAL_AUDIT),
    BOTH_SIDE_KNOW_RENAMED("BothSideKnowRenamedAudit","双方认识改名审核",BusinessType.MANUAL_AUDIT),
    HOUSEHOLD_DIED("HouseholdDied","原户主去世审核",BusinessType.MANUAL_AUDIT),
    STOLEN_OTHERS_INFORMATION("StolenOthersInformationAudit","被盗/冒用他人信息审核",BusinessType.MANUAL_AUDIT),

    //客服系统---账户管理
    CANCEL_ACCOUNT("CancelAccount", "注销账户", BusinessType.ACCOUNT_MANAGE),
    FROZEN_ACCOUNT("FrozenAccount", "冻结账户", BusinessType.ACCOUNT_MANAGE),
    UNFREEZE_ACCOUNT("UnfreezeAccount", "解冻账户", BusinessType.ACCOUNT_MANAGE),
    RESCISSION_LOSS("RescissionLoss", "解除挂失", BusinessType.ACCOUNT_MANAGE),
    BANKCARD_UNBIND("BankCardUnbind", "银行卡解绑", BusinessType.ACCOUNT_MANAGE),

    //客服系统---综合查询
    INTEGRATED_QUERY("IntegratedQuery", "综合查询", BusinessType.INTEGRATED_QUERY),

    //客服系统---消费金融
    XFJR_EXPORT_RECORDS("XFJRExportRecords", "消费金融导出", BusinessType.XFJR_QUERY),
    /************* 客服系统end *****************/

    /************* 聚合支付start *****************/
    // 聚合支付---业务管理
    APAY_APP_CREATE("ApayAppCreate", "业务创建", BusinessType.APAY_APP_MANAGE),
    APAY_APP_NAME_CN_UPDATE("ApayAppNameCnUpdate", "业务中文名修改", BusinessType.APAY_APP_MANAGE),
    APAY_APP_DETAIL_UPDATE("ApayAppDetailUpdate", "业务详情修改", BusinessType.APAY_APP_MANAGE),

    // 聚合支付---业务渠道配置管理
    APAY_APP_CHANNEL_CONFIG_ADD("AppChannelConfigAdd", "业务渠道配置增加", BusinessType.APAY_APP_CHANNEL_MANAGE),
    APAY_APP_CHANNEL_CONFIG_UPDATE("AppChannelConfigUpdate", "业务渠道配置修改", BusinessType.APAY_APP_CHANNEL_MANAGE),

    // 聚合支付---用户操作
    APAY_USER_LOGIN("ApayUserLogin", "聚合支付登录", BusinessType.APAY_USER_OPERATION),
    APAY_USER_LOGOUT("ApayUserLogout", "聚合支付登出", BusinessType.APAY_USER_OPERATION);
    /************* 聚合支付end *****************/

    private String type;
    private String desc;
    private BusinessType businessType;

    private BusinessSubType(String type, String desc, BusinessType businessType) {
        this.type = type;
        this.desc = desc;
        this.businessType = businessType;
    }

    public static BusinessSubType getBusinessSubTypeByType(String type) {
        if (StringUtils.isBlank(type)) {
            return null;
        } else {
            BusinessSubType[] businessSubTypes = values();

            for(int i = 0; i < businessSubTypes.length; ++i) {
                if (type.equals(businessSubTypes[i].getType())) {
                    return businessSubTypes[i];
                }
            }

            return null;
        }
    }


    public static void printDESC(String bizType){
        BusinessSubType[] businessSubTypes = values();

        for(BusinessSubType type : businessSubTypes){
            if(StringUtils.equals(type.getBusinessType().getDesc(), bizType)){
                System.out.println("      " + type.getDesc());
            }
        }
    }

    public BusinessType getBusinessType() {
        return this.businessType;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getType() {
        return this.type;
    }
}
