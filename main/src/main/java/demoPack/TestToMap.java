package demoPack;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author youchao.wen
 * @date 2019-04-24.
 */
public class TestToMap {
    public static void main(String[] args) {
        String json = "[{\"city\":\"上海\",\"cityId\":2,\"province\":\"上海\"},{\"city\":\"天津\",\"cityId\":3,\"province\":\"天津\"},{\"city\":\"石家庄\",\"cityId\":4,\"province\":\"河北\"},{\"city\":\"保定\",\"cityId\":5,\"province\":\"河北\"},{\"city\":\"沧州\",\"cityId\":6,\"province\":\"河北\"},{\"city\":\"承德\",\"cityId\":7,\"province\":\"河北\"},{\"city\":\"邯郸\",\"cityId\":8,\"province\":\"河北\"},{\"city\":\"衡水\",\"cityId\":9,\"province\":\"河北\"},{\"city\":\"廊坊\",\"cityId\":10,\"province\":\"河北\"},{\"city\":\"秦皇岛\",\"cityId\":11,\"province\":\"河北\"},{\"city\":\"唐山\",\"cityId\":12,\"province\":\"河北\"},{\"city\":\"邢台\",\"cityId\":13,\"province\":\"河北\"},{\"city\":\"张家口\",\"cityId\":14,\"province\":\"河北\"},{\"city\":\"太原\",\"cityId\":15,\"province\":\"山西\"},{\"city\":\"长治\",\"cityId\":16,\"province\":\"山西\"},{\"city\":\"大同\",\"cityId\":17,\"province\":\"山西\"},{\"city\":\"晋城\",\"cityId\":18,\"province\":\"山西\"},{\"city\":\"离石\",\"cityId\":19,\"province\":\"山西\"},{\"city\":\"临汾\",\"cityId\":20,\"province\":\"山西\"},{\"city\":\"朔州\",\"cityId\":21,\"province\":\"山西\"},{\"city\":\"忻州\",\"cityId\":22,\"province\":\"山西\"},{\"city\":\"阳泉\",\"cityId\":23,\"province\":\"山西\"},{\"city\":\"榆次\",\"cityId\":24,\"province\":\"山西\"},{\"city\":\"运城\",\"cityId\":25,\"province\":\"山西\"},{\"city\":\"晋中\",\"cityId\":26,\"province\":\"山西\"},{\"city\":\"吕梁\",\"cityId\":27,\"province\":\"山西\"},{\"city\":\"呼和浩特\",\"cityId\":28,\"province\":\"内蒙古\"},{\"city\":\"包头\",\"cityId\":29,\"province\":\"内蒙古\"},{\"city\":\"阿拉善\",\"cityId\":30,\"province\":\"内蒙古\"},{\"city\":\"巴彦淖尔\",\"cityId\":31,\"province\":\"内蒙古\"},{\"city\":\"赤峰\",\"cityId\":32,\"province\":\"内蒙古\"},{\"city\":\"呼伦贝尔\",\"cityId\":33,\"province\":\"内蒙古\"},{\"city\":\"乌海\",\"cityId\":34,\"province\":\"内蒙古\"},{\"city\":\"乌兰察布\",\"cityId\":35,\"province\":\"内蒙古\"},{\"city\":\"锡林郭勒\",\"cityId\":36,\"province\":\"内蒙古\"},{\"city\":\"兴安\",\"cityId\":37,\"province\":\"内蒙古\"},{\"city\":\"鄂尔多斯\",\"cityId\":38,\"province\":\"内蒙古\"},{\"city\":\"通辽\",\"cityId\":39,\"province\":\"内蒙古\"},{\"city\":\"沈阳\",\"cityId\":40,\"province\":\"辽宁\"},{\"city\":\"大连\",\"cityId\":41,\"province\":\"辽宁\"},{\"city\":\"鞍山\",\"cityId\":42,\"province\":\"辽宁\"},{\"city\":\"本溪\",\"cityId\":43,\"province\":\"辽宁\"},{\"city\":\"朝阳\",\"cityId\":44,\"province\":\"辽宁\"},{\"city\":\"丹东\",\"cityId\":45,\"province\":\"辽宁\"},{\"city\":\"抚顺\",\"cityId\":46,\"province\":\"辽宁\"},{\"city\":\"阜新\",\"cityId\":47,\"province\":\"辽宁\"},{\"city\":\"葫芦岛\",\"cityId\":48,\"province\":\"辽宁\"},{\"city\":\"锦州\",\"cityId\":49,\"province\":\"辽宁\"},{\"city\":\"辽阳\",\"cityId\":50,\"province\":\"辽宁\"},{\"city\":\"盘锦\",\"cityId\":51,\"province\":\"辽宁\"},{\"city\":\"铁岭\",\"cityId\":52,\"province\":\"辽宁\"},{\"city\":\"营口\",\"cityId\":53,\"province\":\"辽宁\"},{\"city\":\"长春\",\"cityId\":54,\"province\":\"吉林\"},{\"city\":\"白城\",\"cityId\":55,\"province\":\"吉林\"},{\"city\":\"白山\",\"cityId\":56,\"province\":\"吉林\"},{\"city\":\"吉林\",\"cityId\":57,\"province\":\"吉林\"},{\"city\":\"辽源\",\"cityId\":58,\"province\":\"吉林\"},{\"city\":\"四平\",\"cityId\":59,\"province\":\"吉林\"},{\"city\":\"松原\",\"cityId\":60,\"province\":\"吉林\"},{\"city\":\"通化\",\"cityId\":61,\"province\":\"吉林\"},{\"city\":\"延边\",\"cityId\":62,\"province\":\"吉林\"},{\"city\":\"哈尔滨\",\"cityId\":63,\"province\":\"黑龙江\"},{\"city\":\"大庆\",\"cityId\":64,\"province\":\"黑龙江\"},{\"city\":\"大兴安岭\",\"cityId\":65,\"province\":\"黑龙江\"},{\"city\":\"鹤岗\",\"cityId\":66,\"province\":\"黑龙江\"},{\"city\":\"黑河\",\"cityId\":67,\"province\":\"黑龙江\"},{\"city\":\"鸡西\",\"cityId\":68,\"province\":\"黑龙江\"},{\"city\":\"佳木斯\",\"cityId\":69,\"province\":\"黑龙江\"},{\"city\":\"牡丹江\",\"cityId\":70,\"province\":\"黑龙江\"},{\"city\":\"七台河\",\"cityId\":71,\"province\":\"黑龙江\"},{\"city\":\"齐齐哈尔\",\"cityId\":72,\"province\":\"黑龙江\"},{\"city\":\"双鸭山\",\"cityId\":73,\"province\":\"黑龙江\"},{\"city\":\"绥化\",\"cityId\":74,\"province\":\"黑龙江\"},{\"city\":\"伊春\",\"cityId\":75,\"province\":\"黑龙江\"},{\"city\":\"南京\",\"cityId\":76,\"province\":\"江苏\"},{\"city\":\"常州\",\"cityId\":77,\"province\":\"江苏\"},{\"city\":\"淮安\",\"cityId\":78,\"province\":\"江苏\"},{\"city\":\"连云港\",\"cityId\":79,\"province\":\"江苏\"},{\"city\":\"南通\",\"cityId\":80,\"province\":\"江苏\"},{\"city\":\"苏州\",\"cityId\":81,\"province\":\"江苏\"},{\"city\":\"宿迁\",\"cityId\":82,\"province\":\"江苏\"},{\"city\":\"泰州\",\"cityId\":83,\"province\":\"江苏\"},{\"city\":\"无锡\",\"cityId\":84,\"province\":\"江苏\"},{\"city\":\"徐州\",\"cityId\":85,\"province\":\"江苏\"},{\"city\":\"盐城\",\"cityId\":86,\"province\":\"江苏\"},{\"city\":\"扬州\",\"cityId\":87,\"province\":\"江苏\"},{\"city\":\"镇江\",\"cityId\":88,\"province\":\"江苏\"},{\"city\":\"胥浦\",\"cityId\":89,\"province\":\"江苏\"},{\"city\":\"昆山\",\"cityId\":90,\"province\":\"江苏\"},{\"city\":\"杭州\",\"cityId\":91,\"province\":\"浙江\"},{\"city\":\"宁波\",\"cityId\":92,\"province\":\"浙江\"},{\"city\":\"湖州\",\"cityId\":93,\"province\":\"浙江\"},{\"city\":\"嘉兴\",\"cityId\":94,\"province\":\"浙江\"},{\"city\":\"金华\",\"cityId\":95,\"province\":\"浙江\"},{\"city\":\"绍兴\",\"cityId\":96,\"province\":\"浙江\"},{\"city\":\"台州\",\"cityId\":97,\"province\":\"浙江\"},{\"city\":\"温州\",\"cityId\":98,\"province\":\"浙江\"},{\"city\":\"舟山\",\"cityId\":99,\"province\":\"浙江\"},{\"city\":\"衢州\",\"cityId\":100,\"province\":\"浙江\"},{\"city\":\"丽水\",\"cityId\":101,\"province\":\"浙江\"},{\"city\":\"合肥\",\"cityId\":102,\"province\":\"安徽\"},{\"city\":\"安庆\",\"cityId\":103,\"province\":\"安徽\"},{\"city\":\"蚌埠\",\"cityId\":104,\"province\":\"安徽\"},{\"city\":\"巢湖\",\"cityId\":105,\"province\":\"安徽\"},{\"city\":\"池州\",\"cityId\":106,\"province\":\"安徽\"},{\"city\":\"滁州\",\"cityId\":107,\"province\":\"安徽\"},{\"city\":\"阜阳\",\"cityId\":108,\"province\":\"安徽\"},{\"city\":\"淮北\",\"cityId\":109,\"province\":\"安徽\"},{\"city\":\"淮南\",\"cityId\":110,\"province\":\"安徽\"},{\"city\":\"黄山\",\"cityId\":111,\"province\":\"安徽\"},{\"city\":\"六安\",\"cityId\":112,\"province\":\"安徽\"},{\"city\":\"马鞍山\",\"cityId\":113,\"province\":\"安徽\"},{\"city\":\"铜陵\",\"cityId\":114,\"province\":\"安徽\"},{\"city\":\"芜湖\",\"cityId\":115,\"province\":\"安徽\"},{\"city\":\"宣城\",\"cityId\":116,\"province\":\"安徽\"},{\"city\":\"亳州\",\"cityId\":117,\"province\":\"安徽\"},{\"city\":\"宿州\",\"cityId\":118,\"province\":\"安徽\"},{\"city\":\"福州\",\"cityId\":119,\"province\":\"福建\"},{\"city\":\"厦门\",\"cityId\":120,\"province\":\"福建\"},{\"city\":\"龙岩\",\"cityId\":121,\"province\":\"福建\"},{\"city\":\"南平\",\"cityId\":122,\"province\":\"福建\"},{\"city\":\"宁德\",\"cityId\":123,\"province\":\"福建\"},{\"city\":\"莆田\",\"cityId\":124,\"province\":\"福建\"},{\"city\":\"泉州\",\"cityId\":125,\"province\":\"福建\"},{\"city\":\"三明\",\"cityId\":126,\"province\":\"福建\"},{\"city\":\"漳州\",\"cityId\":127,\"province\":\"福建\"},{\"city\":\"南昌\",\"cityId\":128,\"province\":\"江西\"},{\"city\":\"抚州\",\"cityId\":129,\"province\":\"江西\"},{\"city\":\"赣州\",\"cityId\":130,\"province\":\"江西\"},{\"city\":\"吉安\",\"cityId\":131,\"province\":\"江西\"},{\"city\":\"景德镇\",\"cityId\":132,\"province\":\"江西\"},{\"city\":\"九江\",\"cityId\":133,\"province\":\"江西\"},{\"city\":\"萍乡\",\"cityId\":134,\"province\":\"江西\"},{\"city\":\"上饶\",\"cityId\":135,\"province\":\"江西\"},{\"city\":\"新余\",\"cityId\":136,\"province\":\"江西\"},{\"city\":\"宜春\",\"cityId\":137,\"province\":\"江西\"},{\"city\":\"鹰潭\",\"cityId\":138,\"province\":\"江西\"},{\"city\":\"济南\",\"cityId\":139,\"province\":\"山东\"},{\"city\":\"青岛\",\"cityId\":140,\"province\":\"山东\"},{\"city\":\"滨州\",\"cityId\":141,\"province\":\"山东\"},{\"city\":\"德州\",\"cityId\":142,\"province\":\"山东\"},{\"city\":\"东营\",\"cityId\":143,\"province\":\"山东\"},{\"city\":\"菏泽\",\"cityId\":144,\"province\":\"山东\"},{\"city\":\"济宁\",\"cityId\":145,\"province\":\"山东\"},{\"city\":\"莱芜\",\"cityId\":146,\"province\":\"山东\"},{\"city\":\"聊城\",\"cityId\":147,\"province\":\"山东\"},{\"city\":\"临沂\",\"cityId\":148,\"province\":\"山东\"},{\"city\":\"日照\",\"cityId\":149,\"province\":\"山东\"},{\"city\":\"泰安\",\"cityId\":150,\"province\":\"山东\"},{\"city\":\"威海\",\"cityId\":151,\"province\":\"山东\"},{\"city\":\"潍坊\",\"cityId\":152,\"province\":\"山东\"},{\"city\":\"烟台\",\"cityId\":153,\"province\":\"山东\"},{\"city\":\"枣庄\",\"cityId\":154,\"province\":\"山东\"},{\"city\":\"淄博\",\"cityId\":155,\"province\":\"山东\"},{\"city\":\"郑州\",\"cityId\":156,\"province\":\"河南\"},{\"city\":\"安阳\",\"cityId\":157,\"province\":\"河南\"},{\"city\":\"焦作\",\"cityId\":158,\"province\":\"河南\"},{\"city\":\"鹤壁\",\"cityId\":159,\"province\":\"河南\"},{\"city\":\"开封\",\"cityId\":160,\"province\":\"河南\"},{\"city\":\"洛阳\",\"cityId\":161,\"province\":\"河南\"},{\"city\":\"南阳\",\"cityId\":162,\"province\":\"河南\"},{\"city\":\"平顶山\",\"cityId\":163,\"province\":\"河南\"},{\"city\":\"三门峡\",\"cityId\":164,\"province\":\"河南\"},{\"city\":\"商丘\",\"cityId\":165,\"province\":\"河南\"},{\"city\":\"新乡\",\"cityId\":166,\"province\":\"河南\"},{\"city\":\"信阳\",\"cityId\":167,\"province\":\"河南\"},{\"city\":\"许昌\",\"cityId\":168,\"province\":\"河南\"},{\"city\":\"周口\",\"cityId\":169,\"province\":\"河南\"},{\"city\":\"驻马店\",\"cityId\":170,\"province\":\"河南\"},{\"city\":\"漯河\",\"cityId\":171,\"province\":\"河南\"},{\"city\":\"濮阳\",\"cityId\":172,\"province\":\"河南\"},{\"city\":\"济源\",\"cityId\":173,\"province\":\"河南\"},{\"city\":\"武汉\",\"cityId\":174,\"province\":\"湖北\"},{\"city\":\"鄂州\",\"cityId\":175,\"province\":\"湖北\"},{\"city\":\"恩施\",\"cityId\":176,\"province\":\"湖北\"},{\"city\":\"黄冈\",\"cityId\":177,\"province\":\"湖北\"},{\"city\":\"黄石\",\"cityId\":178,\"province\":\"湖北\"},{\"city\":\"荆门\",\"cityId\":179,\"province\":\"湖北\"},{\"city\":\"荆州\",\"cityId\":180,\"province\":\"湖北\"},{\"city\":\"十堰\",\"cityId\":181,\"province\":\"湖北\"},{\"city\":\"随州\",\"cityId\":182,\"province\":\"湖北\"},{\"city\":\"咸宁\",\"cityId\":183,\"province\":\"湖北\"},{\"city\":\"襄樊\",\"cityId\":184,\"province\":\"湖北\"},{\"city\":\"孝感\",\"cityId\":185,\"province\":\"湖北\"},{\"city\":\"神农架\",\"cityId\":186,\"province\":\"湖北\"},{\"city\":\"天门\",\"cityId\":187,\"province\":\"湖北\"},{\"city\":\"宜昌\",\"cityId\":188,\"province\":\"湖北\"},{\"city\":\"三峡\",\"cityId\":189,\"province\":\"湖北\"},{\"city\":\"长沙\",\"cityId\":190,\"province\":\"湖南\"},{\"city\":\"常德\",\"cityId\":191,\"province\":\"湖南\"},{\"city\":\"郴州\",\"cityId\":192,\"province\":\"湖南\"},{\"city\":\"衡阳\",\"cityId\":193,\"province\":\"湖南\"},{\"city\":\"怀化\",\"cityId\":194,\"province\":\"湖南\"},{\"city\":\"娄底\",\"cityId\":195,\"province\":\"湖南\"},{\"city\":\"邵阳\",\"cityId\":196,\"province\":\"湖南\"},{\"city\":\"湘潭\",\"cityId\":197,\"province\":\"湖南\"},{\"city\":\"湘西\",\"cityId\":198,\"province\":\"湖南\"},{\"city\":\"益阳\",\"cityId\":199,\"province\":\"湖南\"},{\"city\":\"永州\",\"cityId\":200,\"province\":\"湖南\"},{\"city\":\"岳阳\",\"cityId\":201,\"province\":\"湖南\"},{\"city\":\"张家界\",\"cityId\":202,\"province\":\"湖南\"},{\"city\":\"株洲\",\"cityId\":203,\"province\":\"湖南\"},{\"city\":\"广州\",\"cityId\":204,\"province\":\"广东\"},{\"city\":\"深圳\",\"cityId\":205,\"province\":\"广东\"},{\"city\":\"潮州\",\"cityId\":206,\"province\":\"广东\"},{\"city\":\"东莞\",\"cityId\":207,\"province\":\"广东\"},{\"city\":\"佛山\",\"cityId\":208,\"province\":\"广东\"},{\"city\":\"惠州\",\"cityId\":209,\"province\":\"广东\"},{\"city\":\"江门\",\"cityId\":210,\"province\":\"广东\"},{\"city\":\"揭阳\",\"cityId\":211,\"province\":\"广东\"},{\"city\":\"茂名\",\"cityId\":212,\"province\":\"广东\"},{\"city\":\"梅州\",\"cityId\":213,\"province\":\"广东\"},{\"city\":\"清远\",\"cityId\":214,\"province\":\"广东\"},{\"city\":\"汕头\",\"cityId\":215,\"province\":\"广东\"},{\"city\":\"汕尾\",\"cityId\":216,\"province\":\"广东\"},{\"city\":\"韶关\",\"cityId\":217,\"province\":\"广东\"},{\"city\":\"阳江\",\"cityId\":218,\"province\":\"广东\"},{\"city\":\"云浮\",\"cityId\":219,\"province\":\"广东\"},{\"city\":\"湛江\",\"cityId\":220,\"province\":\"广东\"},{\"city\":\"肇庆\",\"cityId\":221,\"province\":\"广东\"},{\"city\":\"中山\",\"cityId\":222,\"province\":\"广东\"},{\"city\":\"河源\",\"cityId\":223,\"province\":\"广东\"},{\"city\":\"珠海\",\"cityId\":224,\"province\":\"广东\"},{\"city\":\"南宁\",\"cityId\":225,\"province\":\"广西\"},{\"city\":\"百色\",\"cityId\":226,\"province\":\"广西\"},{\"city\":\"北海\",\"cityId\":227,\"province\":\"广西\"},{\"city\":\"桂林\",\"cityId\":228,\"province\":\"广西\"},{\"city\":\"河池\",\"cityId\":229,\"province\":\"广西\"},{\"city\":\"柳州\",\"cityId\":230,\"province\":\"广西\"},{\"city\":\"梧州\",\"cityId\":231,\"province\":\"广西\"},{\"city\":\"玉林\",\"cityId\":232,\"province\":\"广西\"},{\"city\":\"崇左\",\"cityId\":233,\"province\":\"广西\"},{\"city\":\"防城港\",\"cityId\":234,\"province\":\"广西\"},{\"city\":\"贵港\",\"cityId\":235,\"province\":\"广西\"},{\"city\":\"贺州\",\"cityId\":236,\"province\":\"广西\"},{\"city\":\"来宾\",\"cityId\":237,\"province\":\"广西\"},{\"city\":\"钦州\",\"cityId\":238,\"province\":\"广西\"},{\"city\":\"海口\",\"cityId\":239,\"province\":\"海南\"},{\"city\":\"三亚\",\"cityId\":240,\"province\":\"海南\"},{\"city\":\"白沙\",\"cityId\":241,\"province\":\"海南\"},{\"city\":\"保亭\",\"cityId\":242,\"province\":\"海南\"},{\"city\":\"昌江\",\"cityId\":243,\"province\":\"海南\"},{\"city\":\"澄迈\",\"cityId\":244,\"province\":\"海南\"},{\"city\":\"儋州\",\"cityId\":245,\"province\":\"海南\"},{\"city\":\"定安\",\"cityId\":246,\"province\":\"海南\"},{\"city\":\"东方\",\"cityId\":247,\"province\":\"海南\"},{\"city\":\"乐东\",\"cityId\":248,\"province\":\"海南\"},{\"city\":\"临高\",\"cityId\":249,\"province\":\"海南\"},{\"city\":\"陵水\",\"cityId\":250,\"province\":\"海南\"},{\"city\":\"琼海\",\"cityId\":251,\"province\":\"海南\"},{\"city\":\"琼中\",\"cityId\":252,\"province\":\"海南\"},{\"city\":\"屯昌\",\"cityId\":253,\"province\":\"海南\"},{\"city\":\"万宁\",\"cityId\":254,\"province\":\"海南\"},{\"city\":\"文昌\",\"cityId\":255,\"province\":\"海南\"},{\"city\":\"五指山\",\"cityId\":256,\"province\":\"海南\"},{\"city\":\"洋浦\",\"cityId\":257,\"province\":\"海南\"},{\"city\":\"重庆\",\"cityId\":258,\"province\":\"重庆\"},{\"city\":\"成都\",\"cityId\":259,\"province\":\"四川\"},{\"city\":\"巴中\",\"cityId\":260,\"province\":\"四川\"},{\"city\":\"达州\",\"cityId\":261,\"province\":\"四川\"},{\"city\":\"德阳\",\"cityId\":262,\"province\":\"四川\"},{\"city\":\"广安\",\"cityId\":263,\"province\":\"四川\"},{\"city\":\"广元\",\"cityId\":264,\"province\":\"四川\"},{\"city\":\"乐山\",\"cityId\":265,\"province\":\"四川\"},{\"city\":\"凉山\",\"cityId\":266,\"province\":\"四川\"},{\"city\":\"眉山\",\"cityId\":267,\"province\":\"四川\"},{\"city\":\"绵阳\",\"cityId\":268,\"province\":\"四川\"},{\"city\":\"南充\",\"cityId\":269,\"province\":\"四川\"},{\"city\":\"内江\",\"cityId\":270,\"province\":\"四川\"},{\"city\":\"攀枝花\",\"cityId\":271,\"province\":\"四川\"},{\"city\":\"遂宁\",\"cityId\":272,\"province\":\"四川\"},{\"city\":\"雅安\",\"cityId\":273,\"province\":\"四川\"},{\"city\":\"宜宾\",\"cityId\":274,\"province\":\"四川\"},{\"city\":\"自贡\",\"cityId\":275,\"province\":\"四川\"},{\"city\":\"泸州\",\"cityId\":276,\"province\":\"四川\"},{\"city\":\"阿坝\",\"cityId\":277,\"province\":\"四川\"},{\"city\":\"甘孜\",\"cityId\":278,\"province\":\"四川\"},{\"city\":\"资阳\",\"cityId\":279,\"province\":\"四川\"},{\"city\":\"贵阳\",\"cityId\":280,\"province\":\"贵州\"},{\"city\":\"安顺\",\"cityId\":281,\"province\":\"贵州\"},{\"city\":\"毕节\",\"cityId\":282,\"province\":\"贵州\"},{\"city\":\"六盘水\",\"cityId\":283,\"province\":\"贵州\"},{\"city\":\"铜仁\",\"cityId\":284,\"province\":\"贵州\"},{\"city\":\"遵义\",\"cityId\":285,\"province\":\"贵州\"},{\"city\":\"黔东南\",\"cityId\":286,\"province\":\"贵州\"},{\"city\":\"黔南\",\"cityId\":287,\"province\":\"贵州\"},{\"city\":\"黔西南\",\"cityId\":288,\"province\":\"贵州\"},{\"city\":\"昆明\",\"cityId\":289,\"province\":\"云南\"},{\"city\":\"西双版纳\",\"cityId\":290,\"province\":\"云南\"},{\"city\":\"保山\",\"cityId\":291,\"province\":\"云南\"},{\"city\":\"楚雄\",\"cityId\":292,\"province\":\"云南\"},{\"city\":\"大理\",\"cityId\":293,\"province\":\"云南\"},{\"city\":\"德宏\",\"cityId\":294,\"province\":\"云南\"},{\"city\":\"红河\",\"cityId\":295,\"province\":\"云南\"},{\"city\":\"丽江\",\"cityId\":296,\"province\":\"云南\"},{\"city\":\"临沧\",\"cityId\":297,\"province\":\"云南\"},{\"city\":\"怒江\",\"cityId\":298,\"province\":\"云南\"},{\"city\":\"曲靖\",\"cityId\":299,\"province\":\"云南\"},{\"city\":\"思茅\",\"cityId\":300,\"province\":\"云南\"},{\"city\":\"文山\",\"cityId\":301,\"province\":\"云南\"},{\"city\":\"玉溪\",\"cityId\":302,\"province\":\"云南\"},{\"city\":\"昭通\",\"cityId\":303,\"province\":\"云南\"},{\"city\":\"中甸\",\"cityId\":304,\"province\":\"云南\"},{\"city\":\"迪庆州\",\"cityId\":305,\"province\":\"云南\"},{\"city\":\"拉萨\",\"cityId\":306,\"province\":\"西藏\"},{\"city\":\"阿里\",\"cityId\":307,\"province\":\"西藏\"},{\"city\":\"昌都\",\"cityId\":308,\"province\":\"西藏\"},{\"city\":\"林芝\",\"cityId\":309,\"province\":\"西藏\"},{\"city\":\"那曲\",\"cityId\":310,\"province\":\"西藏\"},{\"city\":\"日喀则\",\"cityId\":311,\"province\":\"西藏\"},{\"city\":\"山南\",\"cityId\":312,\"province\":\"西藏\"},{\"city\":\"西安\",\"cityId\":313,\"province\":\"陕西\"},{\"city\":\"安康\",\"cityId\":314,\"province\":\"陕西\"},{\"city\":\"宝鸡\",\"cityId\":315,\"province\":\"陕西\"},{\"city\":\"汉中\",\"cityId\":316,\"province\":\"陕西\"},{\"city\":\"商洛\",\"cityId\":317,\"province\":\"陕西\"},{\"city\":\"铜川\",\"cityId\":318,\"province\":\"陕西\"},{\"city\":\"渭南\",\"cityId\":319,\"province\":\"陕西\"},{\"city\":\"咸阳\",\"cityId\":320,\"province\":\"陕西\"},{\"city\":\"延安\",\"cityId\":321,\"province\":\"陕西\"},{\"city\":\"榆林\",\"cityId\":322,\"province\":\"陕西\"},{\"city\":\"兰州\",\"cityId\":323,\"province\":\"甘肃\"},{\"city\":\"白银\",\"cityId\":324,\"province\":\"甘肃\"},{\"city\":\"定西\",\"cityId\":325,\"province\":\"甘肃\"},{\"city\":\"东风\",\"cityId\":326,\"province\":\"甘肃\"},{\"city\":\"合作\",\"cityId\":327,\"province\":\"甘肃\"},{\"city\":\"嘉峪关\",\"cityId\":328,\"province\":\"甘肃\"},{\"city\":\"金昌\",\"cityId\":329,\"province\":\"甘肃\"},{\"city\":\"酒泉\",\"cityId\":330,\"province\":\"甘肃\"},{\"city\":\"矿区\",\"cityId\":331,\"province\":\"甘肃\"},{\"city\":\"临夏\",\"cityId\":332,\"province\":\"甘肃\"},{\"city\":\"陇南\",\"cityId\":333,\"province\":\"甘肃\"},{\"city\":\"平凉\",\"cityId\":334,\"province\":\"甘肃\"},{\"city\":\"庆阳\",\"cityId\":335,\"province\":\"甘肃\"},{\"city\":\"天水\",\"cityId\":336,\"province\":\"甘肃\"},{\"city\":\"武威\",\"cityId\":337,\"province\":\"甘肃\"},{\"city\":\"张掖\",\"cityId\":338,\"province\":\"甘肃\"},{\"city\":\"甘南州\",\"cityId\":339,\"province\":\"甘肃\"},{\"city\":\"西宁\",\"cityId\":340,\"province\":\"青海\"},{\"city\":\"海东\",\"cityId\":341,\"province\":\"青海\"},{\"city\":\"银川\",\"cityId\":342,\"province\":\"宁夏\"},{\"city\":\"中卫\",\"cityId\":343,\"province\":\"宁夏\"},{\"city\":\"固原\",\"cityId\":344,\"province\":\"宁夏\"},{\"city\":\"石嘴山\",\"cityId\":345,\"province\":\"宁夏\"},{\"city\":\"吴忠\",\"cityId\":346,\"province\":\"宁夏\"},{\"city\":\"乌鲁木齐\",\"cityId\":347,\"province\":\"新疆\"},{\"city\":\"阿克苏\",\"cityId\":348,\"province\":\"新疆\"},{\"city\":\"阿勒泰\",\"cityId\":349,\"province\":\"新疆\"},{\"city\":\"巴州\",\"cityId\":350,\"province\":\"新疆\"},{\"city\":\"博州\",\"cityId\":351,\"province\":\"新疆\"},{\"city\":\"昌吉\",\"cityId\":352,\"province\":\"新疆\"},{\"city\":\"哈密\",\"cityId\":353,\"province\":\"新疆\"},{\"city\":\"和田\",\"cityId\":354,\"province\":\"新疆\"},{\"city\":\"喀什\",\"cityId\":355,\"province\":\"新疆\"},{\"city\":\"克拉玛依\",\"cityId\":356,\"province\":\"新疆\"},{\"city\":\"马兰\",\"cityId\":357,\"province\":\"新疆\"},{\"city\":\"石河子\",\"cityId\":358,\"province\":\"新疆\"},{\"city\":\"塔城\",\"cityId\":359,\"province\":\"新疆\"},{\"city\":\"吐鲁番\",\"cityId\":360,\"province\":\"新疆\"},{\"city\":\"伊犁\",\"cityId\":361,\"province\":\"新疆\"},{\"city\":\"克州\",\"cityId\":362,\"province\":\"新疆\"},{\"city\":\"阿拉尔\",\"cityId\":363,\"province\":\"新疆\"},{\"city\":\"五家渠\",\"cityId\":364,\"province\":\"新疆\"},{\"city\":\"北京\",\"cityId\":1,\"province\":\"北京\"}]";
        List<ProvinceCity> provinceCities = JSON.parseObject(json, new TypeReference<List<ProvinceCity>>() {
        });

        Map<String, Map<String, String>> provinceCityMap2 =
                provinceCities.stream()
                        .collect(Collectors.groupingBy(ProvinceCity::getProvince,
                                Collectors.toMap(provinceCity -> provinceCity.getCityId() + "",
                                        ProvinceCity::getCity,
                                        //map重复key值时的处理
                                        (oldValue, newValue) -> newValue))
                        );

        Map<String, Map<String, String>> provinceCityMap = new HashMap<>(16);
        for (ProvinceCity provinceCity : provinceCities) {
            String province = provinceCity.getProvince();
            if (!provinceCityMap.containsKey(province)) {
                provinceCityMap.put(province, new HashMap<>(16));
            }
            provinceCityMap.get(province).put(String.valueOf(provinceCity.getCityId()), provinceCity.getCity());
        }

        System.out.println("province map 1 -> " + JSON.toJSONString(provinceCityMap));
        System.out.println("province map 2 -> " + JSON.toJSONString(provinceCityMap2));


        String str = "帕如哈·吐尔逊:650202197201230053|努尔麦麦提·麦麦提敏:653222196507194052|吐送江·艾比布拉:653201198103220514|阿布都克尤木·库尔班:653101198207092013|努尔麦麦提·热西提:653121197012273210|麦麦提依明·努尔麦麦提:653125198306051496|买买提吐尔逊·依明:65302119740830003X|买买提明·买买提:653225197110100533|买买提吐尔逊·阿布杜哈力克:653222197606014576|夏米斯丁艾合麦提·阿布都米吉提:653101197211020819|艾可米来·吾买尔江:654126197706010012|牙库甫·麦麦提:652927760128101|吐尔孙·托合提:653125750620041";
        List<String> terroristList = Arrays.asList(str.split("\\|"));

        List<TerroristDTO> list = terroristList.stream()
                .filter(StringUtils::isNotBlank)
                .filter(terrorist -> terrorist.indexOf(":") > 0)
                .map(terroristStr ->
                {
                    String[] arr = terroristStr.split(":");
                    TerroristDTO terroristDTO = new TerroristDTO();
                    terroristDTO.setRealName(arr[0]);
                    terroristDTO.setIdNumber(arr[1]);
                    return terroristDTO;
                })
                .collect(Collectors.toList());
        System.out.println("terrorists -> " + JSON.toJSONString(list));

        List<TerroristDTO> list2 = new ArrayList<>();
        for (String terroristStr : terroristList) {
            if (StringUtils.isNotBlank(terroristStr)) {
                String[] infoAry = terroristStr.split(":");
                TerroristDTO terroristDTO = new TerroristDTO();
                terroristDTO.setRealName(infoAry[0]);
                if (infoAry.length > 1) {
                    terroristDTO.setIdNumber(infoAry[1]);
                }
                list2.add(terroristDTO);
            }
        }
        System.out.println("terrorists -> " + JSON.toJSONString(list2));

    }
    @Data
    public static class ProvinceCity implements Serializable {
        private static final long serialVersionUID = 1226516268726536108L;
        /**
         * //城市的标识
         */
        public Long cityId;
        /**
         * //省
         */
        private String province;
        /**
         * //市
         */
        private String city;


    }

    @Data
    public static class TerroristDTO implements Serializable {
        private static final long serialVersionUID = -6334645241513531438L;

        /**
         * 虚拟
         */
        public static final String DUMMY = "dummy";

        /**
         * 真实姓名
         */
        private String realName = DUMMY;

        /**
         * 身份证号
         */
        private String idNumber;

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("TerroristDTO{");
            sb.append("realName='").append(realName).append('\'');
            sb.append(", idNumber='").append(idNumber).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
}
