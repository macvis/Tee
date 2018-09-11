package demoPack;

/**
 * @author youchao.wen
 * @date 2018/8/29.
 */
public enum AppMoudleGroup {
    INDEX_BANNER("INDEX_BANNER"),
    INDEX_GAMES("INDEX_GAMES"),
    RANKING_LIST("RANKING_LIST");

    private String value;

    private AppMoudleGroup(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static AppMoudleGroup getEnumByValue(String value) {
        AppMoudleGroup[] arr$ = values();
        int len$ = arr$.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            AppMoudleGroup appMoudleGroup = arr$[i$];
            if (appMoudleGroup.getValue().equalsIgnoreCase(value)) {
                return appMoudleGroup;
            }
        }

        return null;
    }
}
