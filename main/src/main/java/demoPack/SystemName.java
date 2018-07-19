package demoPack;

import org.apache.commons.lang3.StringUtils;

public enum SystemName {
    BOSS("platform_boss", "BOSS系统"),
    CUSTOMER("customer-web", "客服系统"),
    PLATFORM("platform-web", "商户系统"),
    APAY("apay", "聚合支付");

    private String type;
    private String desc;

    public static SystemName getSystemNameByType(String type) {
        if (StringUtils.isBlank(type)) {
            return null;
        } else {
            SystemName[] systemNames = values();

            for(int i = 0; i < systemNames.length; ++i) {
                if (type.equals(systemNames[i].getType())) {
                    return systemNames[i];
                }
            }

            return null;
        }
    }

    private SystemName(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getType() {
        return this.type;
    }

    public String toString() {
        return "{'type':'" + this.type + "','desc':'" + this.desc + "'}";
    }
}
