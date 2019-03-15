package demoPack;

import org.apache.commons.codec.binary.Base64;

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
        String sign = "6cz8VATEutOg3TNpqFb4+PW9vL1XvypU3Qu1jszw/83uLUdHKXA3zbJETicZFtUZJ3wwVIxg5DhHuS4a7J8LiqnHbrdAU/LiB9LhyedsLVpdPCAB04HM8cmTs6lLA9kXT86XgZDMndlfGlBZuZuNWFHSfzWi7Np3JDkPED+zNfI=";
        String pubKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDzbCpYQX3JquqipDDXU9PTqvMS\n" +
                "RHahfeDyD+cbpkU/Tga8mqg1Em84qqPzKfpyUI8vvaEmL4pCwTqgRwytrswwVFBB\n" +
                "YRPIj4RWOMWRer6pGmJI1SodY0UPKr/IFcQboadUC4VSXripQuhJSZPcTfHux6cU\n" +
                "pPSWr5RwrE6EYvRd5wIDAQAB";
        String data = "payGateTradeId=20181211TX22342342&queryType=order&requester=kunPeng";

        try {
            boolean f = verify(data.getBytes("UTF-8"), pubKey, sign);
            System.out.println("f  -> " + f);

        } catch (Exception e) {
            e.printStackTrace();
        }
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

    static class Task1 implements Callable<String>{
        @Override
        public String call() throws Exception {

            return "1";
        }
    }

    static class Task2 implements Future<String>{
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

}
