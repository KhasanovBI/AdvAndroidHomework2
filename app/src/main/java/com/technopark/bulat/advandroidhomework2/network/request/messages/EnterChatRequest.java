package com.technopark.bulat.advandroidhomework2.network.request.messages;

import com.technopark.bulat.advandroidhomework2.network.request.RequestMessage;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bulat on 16.11.15.
 */
public class EnterChatRequest implements RequestMessage {
    private final String cid;
    private final String sid;
    private final String channelId;

    public EnterChatRequest(String cid, String sid, String channelId) {
        this.cid = cid;
        this.sid = sid;
        this.channelId = channelId;
    }

    @Override
    public String getRequestString() {
        Map<String, String> data = new HashMap<>();
        data.put("cid", cid);
        data.put("sid", sid);
        data.put("channel", channelId);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("action", "enter");
            jsonObject.put("data", new JSONObject(data));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
