package demoPack;

import java.math.BigDecimal;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;

import lombok.Data;

/**
 * @author youchao.wen
 * @date 2019/9/19.
 */
@Data
public class Goo {
    private Boolean hasCoreAccountId;

    /**
     * 账户状态属否正常
     */
    private Boolean statusIsNormal;

    /**
     * 是否已经实名认证
     */
    private Boolean hasRealNameIdentified;

    /**
     * 实名时间在7天哪
     */
    private Boolean hasRealNameIdentifiedIn7Days;

    /**
     * 30天内有过注销账号
     */
    private Boolean hasCanceledWithin30Days;

    /**
     * 是否有网易支付钱包余额
     */
    private Boolean hasWalletBalance;

    /**
     * 是否有考拉钱包余额
     */
    private Boolean hasKaolaWalletBalance;

    /**
     * 未完成的订单
     */
    private Integer unfinishedOrder;

    /**
     * 未完成的充值
     */
    private Integer unfinishedCharge;

    /**
     * 未完成的退款
     */
    private Integer unfinishedRefund;

    /**
     * 未完成的提现
     */
    private Integer unfinishedWithDraw;

    /**
     * 未完成的转账
     */
    private Integer unfinishedTransfer;

    /**
     * 藏宝阁钱包是否有余额
     */
    private Boolean hasCbgBalance;

    /**
     * 藏宝阁钱包是否有在途资金
     */
    private Boolean hasCbgCashInTransit;

    /**
     * 银行卡数量
     */
    private Integer bankCardCount;
    /**
     * 是否有未解绑的银行卡
     */
    private Boolean hasBindBankCard;

    /**
     * 是否存在进行中的申诉
     */
    private Boolean hasIdentifyApply;

    /**
     * 是否存在进行中的人工审核
     */
    private Boolean hasManualIdentifyApply;

    /**
     * 是否开通小额贷款业务
     */
    private Boolean hasMinorLoanInfo;

    /**
     * 是否开通白条消费业务
     */
    private Boolean hasQuhuaInfo;

    /** 风控身份校验的返回dto */
//	private RiskCheckBehaviorResponseDTO riskCheckBehaviorResponseDTO;

    /**
     * 余额
     */
    private BigDecimal epayWalletBalance;

    /**
     * 考拉钱包余额
     */
    private BigDecimal kaolaWalletBalance;

    /**
     * 是否能注销
     */
    private Boolean canCancel;

    /**
     * 账号
     */
    private String accountId;

    /**
     * 实名审核时间
     */
    private String identityTime;

    /**
     * 上一次注销时间
     */
    private String laseCancelTime;

    /**
     * 检查能否注销的结果
     */
    private String checkResult;

    /**
     * 检查结果的code集合
     */
    private Set<Integer> checkResultCodes;

    public Boolean getCanCancel() {
        boolean canCancelWithoutKaoLa = hasRealNameIdentified != null && hasRealNameIdentified
                && hasRealNameIdentifiedIn7Days != null && !hasRealNameIdentifiedIn7Days
                && hasCanceledWithin30Days != null && !hasCanceledWithin30Days
                && hasWalletBalance != null && !hasWalletBalance
                && unfinishedOrder != null && unfinishedOrder <= 0
                && unfinishedCharge != null && unfinishedCharge <= 0
                && unfinishedRefund != null && unfinishedRefund <= 0
                && unfinishedTransfer != null && unfinishedTransfer <= 0
                && unfinishedWithDraw != null && unfinishedWithDraw <= 0
                && hasCbgBalance != null && !hasCbgBalance
                && hasCbgCashInTransit != null && !hasCbgCashInTransit
                && bankCardCount != null && bankCardCount <= 0
                && hasIdentifyApply != null && !hasIdentifyApply
                && hasManualIdentifyApply != null && !hasManualIdentifyApply
                && hasMinorLoanInfo != null && !hasMinorLoanInfo
                && hasQuhuaInfo != null && !hasQuhuaInfo
                && hasKaolaWalletBalance != null && !hasKaolaWalletBalance;
        return canCancelWithoutKaoLa;
    }

    public static void main(String[] args) {
        String str = " {\"accountId\":\"macvis@126.com\",\"bankCardCount\":0,\"canCancel\":false,\"checkResult\":\"注销检查验证通过\",\"checkResultCodes\":[],\"epayWalletBalance\":0,\"hasBindBankCard\":false,\"hasCanceledWithin30Days\":false,\"hasCbgBalance\":false,\"hasCbgCashInTransit\":false,\"hasCoreAccountId\":true,\"hasIdentifyApply\":false,\"hasKaolaWalletBalance\":false,\"hasManualIdentifyApply\":false,\"hasMinorLoanInfo\":false,\"hasQuhuaInfo\":false,\"hasRealNameIdentified\":true,\"hasRealNameIdentifiedIn7Days\":false,\"hasWalletBalance\":false,\"identityTime\":\"2017-10-17 17:21:27\",\"kaolaWalletBalance\":0,\"statusIsNormal\":true,\"unfinishedCharge\":0,\"unfinishedOrder\":0,\"unfinishedRefund\":0,\"unfinishedTransfer\":0,\"unfinishedWithDraw\":0}";

        Goo g = JSONObject.parseObject(str, Goo.class);
        System.out.println("g.getCancel -> " + g.getCanCancel());
    }

}
