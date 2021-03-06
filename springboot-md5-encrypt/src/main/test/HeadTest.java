import com.alibaba.fastjson.JSONObject;
import com.thinkingcao.encrypt.common.HeadRequest;
import com.thinkingcao.encrypt.common.RequestMessage;
import com.thinkingcao.encrypt.constant.Constants;
import com.thinkingcao.encrypt.encrypt.MD5Util;

/**
 * @desc:
 * @author: cao_wencao
 * @date: 2020-05-15 11:54
 */
public class HeadTest {

    private static final String APP_ID = "572b8e84346a419687422346bb51d0b5";
    private static final String nonce = "62a439ab5d4e433c897f4b459181b2b3";
    private static final String timesTamp = "1585881033";

    public static void main(String[] args) {
        RequestMessage requestData = new RequestMessage();
        // String timesTamp = String.valueOf( System.currentTimeMillis() / 1000);
        // String nonce = UUIDUtil.getUuid();
        HeadRequest head = new HeadRequest();
        head.setAppId(APP_ID);
        head.setAppSecret(Constants.APP_SECRET);
        head.setTimestamp(timesTamp);
        head.setNonce(nonce);
        head.setVersion("1.0");
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("username", "zhangsan");
        jsonObj.put("passward", "111111");
        requestData.setBody(jsonObj);
        requestData.setHead(head);
        String sign = MD5Util.md5(APP_ID + Constants.APP_SECRET + timesTamp +  nonce + "1.0");
        requestData.setSign(sign);
        System.out.println("sign = " + sign);

        String messageResult = JSONObject.toJSONString(requestData);
        System.out.println("messageResult = " + messageResult);
    }
}
