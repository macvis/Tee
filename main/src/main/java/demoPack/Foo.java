package demoPack;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.sql.Timestamp;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.*;

/**
 * Created by Tee on 2017/5/25.
 */
public class Foo {

    public static void main(String[] args) {
        String str = "验证码;10010,70010,61130,80010,50011,1562764215\n" +
                "|营销;61248,02062,80011,50010,1537916088\n" +
                "|通知;61414,1537914871\n" +
                "|行业;120397";
        str = StringUtils.remove(str, "\n");
        System.out.println("str.indexOf(|)" + str.indexOf("|"));

        MessageTemplate[] templates = MessageTemplate.values();
        for (MessageTemplate template : templates) {
            System.out.println(template.getVal2() + "--------" + template.getVal3());
        }

        long l1 = 1584942103000L - 1584325020000L;
        long l2 = l1 / 24 / 60 / 60 / 1000;
        System.out.println("l2=" + l2);

        char grade = 'C';

        switch(grade)
        {
            case 'A' :
                System.out.println("优秀");
                break;
            case 'B' :
            case 'C' :
                System.out.println("良好");
                break;
            case 'D' :
                System.out.println("及格");
                break;
            case 'F' :
                System.out.println("你需要再努力努力");
                break;
            default :
                System.out.println("未知等级");
        }
        System.out.println("你的等级是 " + grade);

    }

    public static boolean verify(byte[] data, String publicKey, String sign)
            throws Exception {
        byte[] keyBytes = Base64.decodeBase64(publicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicK = keyFactory.generatePublic(keySpec);
        Signature signature = Signature.getInstance("SHA1withRSA");
        signature.initVerify(publicK);
        signature.update(data);
        return signature.verify(Base64.decodeBase64(sign));
    }

    /**
     * 提供将String类型的字符串内容，转化为Map
     * 原始格式(String)：epay易信组;10.120.83.97:6801|epay用户组;10.120.82.201:6801
     * 输出格式(Map<String, String>):{{epay易信组:10.120.83.97:6801}}{epay用户组:10.120.82.201:6801}}
     *
     * @param str
     * @return
     */
    public static Map<String, String> string2MapStr(String str, String masterSplit, String slaveSplit) {
        String[] strs = str.split(masterSplit);
        Map<String, String> resultMap = new TreeMap<>();

        for (String item : strs) {
            //对于每一类的server组，第一个;前为其组名
            String[] itemList = item.split(slaveSplit);
            String key = itemList[0];
            String value = itemList[1];
            resultMap.put(key, value);
        }
        return resultMap;
    }


    static class Goo {
        protected String s1;
        protected String s2;

        private BigDecimal num;

        private Timestamp time1;
        private Timestamp time2;

        public Goo() {

        }

        public Goo(BigDecimal num, String s1) {
            this.num = num;
            this.s1 = s1;
        }

        public BigDecimal getNum() {
            return num;
        }

        public void setNum(BigDecimal num) {
            this.num = num;
        }

        public String getS1() {
            return s1;
        }

        public void setS1(String s1) {
            this.s1 = s1;
        }

        public String getS2() {
            return s2;
        }

        public void setS2(String s2) {
            this.s2 = s2;
        }

        public Timestamp getTime1() {
            return time1;
        }

        public void setTime1(Timestamp time1) {
            this.time1 = time1;
        }

        public Timestamp getTime2() {
            return time2;
        }

        public void setTime2(Timestamp time2) {
            this.time2 = time2;
        }

        //        protected void write() {
//            System.out.println("xxoo");
//        }
    }

    static class Task1 implements Callable<String> {
        @Override
        public String call() throws Exception {

            return "1";
        }
    }

    static class Task2 implements Future<String> {
        @Override
        public boolean cancel(boolean mayInterruptIfRunning) {
            return false;
        }

        @Override
        public boolean isCancelled() {
            return false;
        }

        @Override
        public boolean isDone() {
            return false;
        }

        @Override
        public String get() throws InterruptedException, ExecutionException {
            return null;

        }

        @Override
        public String get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            return null;
        }
    }

    @AllArgsConstructor
    @Getter
    enum MessageTemplate {
        /**
         * 账号冻结申诉人工审核通过
         */
        ACCOUNT_FREEZE_AUDIT_PASS("accountFreezeAuditPass", "账号冻结申诉人工审核通过",
                "您在【账号冻结申诉审核】环节提交的资料已通过人工审核，详情可登录网易支付电脑端查询。"),
        ACCOUNT_FREEZE_AUDIT_UNTREAD("accountFreezeAuditUntread", "账号冻结申诉人工审核待资料补充",
                "您在【账号冻结申诉审核】环节提交的资料需要完善，请于【%s】前登录网易支付电脑端-进度中心完善资料。"),
        ACCOUNT_FREEZE_AUDIT_NOPASS("accountFreezeAuditNoPass", "账号冻结申诉人工审核不通过",
                "您在【账号冻结申诉审核】环节提交的资料未能通过人工审核，详情可登录网易支付电脑端查询。"),

        ANTIMONEY_LAUDRYING_AUDIT_PASS("antiMoneyLaudryingAuditPass", "反洗钱人工审核通过",
                "您在【身份信息审核】环节提交的资料已通过人工审核，详情可登录网易支付电脑端-进度中心查询。"),
        ANTIMONEY_LAUDRYING_AUDIT_UNTREAD("antiMoneyLaudryingAuditUntread", "反洗钱人工审核待资料补充",
                "您在【身份信息审核】环节提交的资料需要完善，请于【%s】前登录网易支付电脑-进度中心端完善资料。"),
        ANTIMONEY_LAUDRYING_AUDIT_NOPASS("antiMoneyLaudryingAuditNoPass", "反洗钱人工审核不通过",
                "您在【身份信息审核】环节提交的资料未能通过人工审核，详情可登录网易支付电脑端-进度中心查询。"),

        RISK_AUDIT_PASS("riskAuditPass", "风控人工审核通过",
                "您在【风控审核】环节提交的资料已通过人工审核，详情可登录网易支付电脑端-进度中心查询。"),
        RISK_AUDIT_UNTREAD("riskAuditUntread", "风控人工审核待资料补充",
                "您在【风控审核】环节提交的资料需要完善，请于【%s】前登录网易支付电脑端-进度中心完善资料。"),
        RISK_AUDIT_FACE_RECOGNITION("riskAuditFaceRecognition", "风控人工审核待人脸验证",
                "您在【风控审核】环节提交的解除账户风险申请，需要您前往网易支付APP-我的-设置-安全设置-人脸识别进行人脸验证操作。"),
        RISK_AUDIT_NOPASS("riskAuditNoPass", "风控人工审核不通过",
                "您在【风控审核】环节提交的资料未能通过人工审核，详情可登录网易支付电脑端-进度中心查询。"),

        REGISTER_ACTIVATION_AUDIT_PASS("registerActivationAuditPass", "注册激活审核通过",
                "您在【注册】环节提交的资料已通过人工审核，详情可登录网易支付电脑端-进度中心查询。"),
        REGISTER_ACTIVATION_AUDIT_UNTREAD("registerActivationAuditUntread", "注册激活审核待资料补充",
                "您在【注册】环节提交的资料需要完善，请于【%s】前登录网易支付电脑端-进度中心完善资料。"),
        REGISTER_ACTIVATION_AUDIT_NOPASS("registerActivationAuditNoPass", "注册激活审核不通过",
                "您在【注册】环节提交的资料未能通过人工审核，详情可登录网易支付电脑端-进度中心查询。"),

        REALNAME_CHANGE_AUDIT_PASS("realnameChangeAuditPass", "实名认证审核通过",
                "您的网易支付账户已通过实名认证人工审核，请登录网易支付电脑端查看。"),
        REALNAME_CHANGE_AUDIT_UNTREAD("realnameChangeAuditUntread", "实名认证审核待资料补充",
                "您在【实名认证】环节提交的资料需要完善，请于【%s】前登录网易支付电脑端-进度中心完善资料。"),
        REALNAME_CHANGE_AUDIT_NOPASS("realnameChangeAuditNoPass", "实名认证审核不通过",
                "您的网易支付账户未通过实名认证人工审核，请登录网易支付电脑端查看。"),

        BALANCETRANS_ABNORMAL_AUDIT_PASS("balanceTransAbnormalAuditPass", "余额异常审核通过",
                "您在【余额异常信息申诉】环节提交的资料已通过人工审核，详情可登录网易支付电脑端-进度中心查询。"),
        BALANCETRANS_ABNORMAL_AUDIT_UNTREAD("balanceTransAbnormalAuditUntread", "余额异常审核待资料补充",
                "您在【余额异常信息申诉】环节提交的资料需要完善，请于【%s】前登录网易支付电脑端-进度中心完善资料。"),
        BALANCETRANS_ABNORMAL_AUDIT_NOPASS("balanceTransAbnormalAuditNoPass", "余额异常审核不通过",
                "您在【余额异常信息申诉】环节提交的资料未能通过人工审核，详情可登录网易支付电脑端-进度中心查询。"),

        BANKTRANS_ABNORMAL_AUDIT_PASS("bankTransAbnormalAuditPass", "银行异常审核通过",
                "您在【银行异常信息申诉】环节提交的资料已通过人工审核，详情可登录网易支付电脑端-进度中心查询。"),
        BANKTRANS_ABNORMAL_AUDIT_UNTREAD("bankTransAbnormalAuditUntread", "银行异常审核待资料补充",
                "您在【银行异常信息申诉】环节提交的资料需要完善，请于【%s】前登录网易支付电脑端-进度中心完善资料。"),
        BANKTRANS_ABNORMAL_AUDIT_NOPASS("bankTransAbnormalAuditNoPass", "银行异常审核不通过",
                "您在【银行异常信息申诉】环节提交的资料未能通过人工审核，详情可登录网易支付电脑端-进度中心查询。"),

        DOUBLE_ACCOUNT_AUDIT_INIT("doubleAccountAuditInit", "双户口二选一审核发起",
                "您在【身份信息申诉】环节提交的资料已发起人工审核，详情可登录网易支付电脑端-进度中心查询。"),
        DOUBLE_ACCOUNT_AUDIT_PASS("doubleAccountAuditPass", "双户口二选一审核通过",
                "您在【身份信息申诉】环节提交的资料已通过人工审核，详情可登录网易支付电脑端-进度中心查询。"),
        DOUBLE_ACCOUNT_AUDIT_UNTREAD("doubleAccountAuditUntread", "双户口二选一审核待资料补充",
                "您在【身份信息申诉】环节提交的资料需要完善，请于【%s】前登录网易支付电脑端-进度中心完善资料。"),
        DOUBLE_ACCOUNT_AUDIT_NOPASS("doubleAccountAuditNoPass", "双户口二选一审核不通过",
                "您在【身份信息申诉】环节提交的资料未能通过人工审核，详情可登录网易支付电脑端-进度中心查询。"),

        EMIGRATION_AUDIT_INIT("emigrationAuditInit", "移居海外审核发起",
                "您在【身份信息申诉】环节提交的资料已发起人工审核，详情可登录网易支付电脑端-进度中心查询。"),
        EMIGRATION_AUDIT_PASS("emigrationAuditPass", "移居海外审核通过",
                "您在【身份信息申诉】环节提交的资料已通过人工审核，详情可登录网易支付电脑端-进度中心查询。"),
        EMIGRATION_AUDIT_UNTREAD("emigrationAuditUntread", "移居海外审核待资料补充",
                "您在【身份信息申诉】环节提交的资料需要完善，请于【%s】前登录网易支付电脑端-进度中心完善资料。"),
        EMIGRATION_AUDIT_NOPASS("emigrationAuditNoPass", "移居海外审核不通过",
                "您在【身份信息申诉】环节提交的资料未能通过人工审核，详情可登录网易支付电脑端-进度中心查询。"),

        MODIFYNAME_AUDIT_INIT("modifynameAuditInit", "姓名修正审核发起",
                "您在【身份信息申诉】环节提交的资料已发起人工审核，详情可登录网易支付电脑端-进度中心查询。"),
        MODIFYNAME_AUDIT_PASS("modifyNameAuditPass", "姓名修正审核通过",
                "您在【身份信息申诉】环节提交的资料已通过人工审核，详情可登录网易支付电脑端-进度中心查询。"),
        MODIFYNAME_AUDIT_UNTREAD("modifyNameAuditUntread", "姓名修正审核待资料补充",
                "您在【身份信息申诉】环节提交的资料需要完善，请于【%s】前登录网易支付电脑端-进度中心完善资料。"),
        MODIFYNAME_AUDIT_NOPASS("modifyNameAuditNoPass", "姓名修正审核不通过",
                "您在【身份信息申诉】环节提交的资料未能通过人工审核，详情可登录网易支付电脑端-进度中心查询。"),

        NAME_USED_BEFORE_AUDIT_INIT("nameUsedBeforeAuditInit", "曾用名修正审核发起",
                "您在【身份信息申诉】环节提交的资料已发起人工审核，详情可登录网易支付电脑端-进度中心查询。"),
        NAME_USED_BEFORE_AUDIT_PASS("nameUsedBeforeAuditPass", "曾用名修正审核通过",
                "您在【身份信息申诉】环节提交的资料已通过人工审核，详情可登录网易支付电脑端-进度中心查询。"),
        NAME_USED_BEFORE_AUDIT_UNTREAD("nameUsedBeforeAuditUntread", "曾用名修正审核待资料补充",
                "您在【身份信息申诉】环节提交的资料需要完善，请于【%s】前登录网易支付电脑端-进度中心完善资料。"),
        NAME_USED_BEFORE_AUDIT_NOPASS("nameUsedBeforeAuditNoPass", "曾用名修正审核不通过",
                "您在【身份信息申诉】环节提交的资料未能通过人工审核，详情可登录网易支付电脑端-进度中心查询。"),

        QUICKPAY_ABNORMAL_AUDIT_PASS("quickPayAbnormalAuditPass", "快捷支付异常审核通过",
                "您在【快捷支付异常】环节提交的资料已通过人工审核，详情可登录网易支付电脑端-进度中心查询。"),
        QUICKPAY_ABNORMAL_AUDIT_UNTREAD("quickPayAbnormalAuditUntread", "快捷支付异常审核待资料补充",
                "您在【快捷支付异常】环节提交的资料需要完善，请于【%s】前登录网易支付电脑端-进度中心完善资料。"),
        QUICKPAY_ABNORMAL_AUDIT_NOPASS("quickPayAbnormalAuditNoPass", "快捷支付异常审核不通过",
                "您在【快捷支付异常】环节提交的资料未能通过人工审核，详情可登录网易支付电脑端-进度中心查询。"),

        OTHER_IDENTITY_SUBMITED("otherIdentityAuditSubmited", "其他信息申诉审核提交成功",
                "您在【身份信息申诉】环节提交的资料已提交成功，详情可登录网易支付电脑端-进度中心查询。"),
        OTHER_IDENTITY_PASS("otherIdentityAuditPass", "其他信息申诉审核通过",
                "您在【身份信息申诉】环节提交的资料已通过人工审核，详情可登录网易支付电脑端-进度中心查询。"),
        OTHER_IDENTITY_AUDIT_UNTREAD("otherIdentityAuditUntread", "其他信息申诉审核待资料补充",
                "您在【身份信息申诉】环节提交的资料需要完善，请于【%s】前登录网易支付电脑端-进度中心完善资料。"),
        OTHER_IDENTITY_AUDIT_NOPASS("otherIdentityAuditNoPass", "其他信息申诉审核不通过",
                "您在【身份信息申诉】环节提交的资料未能通过人工审核，详情可登录网易支付电脑端-进度中心查询。");

        private String val1;
        private String val2;
        private String val3;
    }
}
