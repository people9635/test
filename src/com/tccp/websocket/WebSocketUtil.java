package com.tccp.websocket;

import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tccp.persistence.UserMapper;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket/{userId}")
public class WebSocketUtil {
    Set<Session> session_list;
    public static CopyOnWriteArraySet<WebSocketUtil> webSocketSet = new CopyOnWriteArraySet<WebSocketUtil>();
    private Session session;
    private String name ;

	@OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("来自客户端的消息:" + message);
        //群发消息
        for(WebSocketUtil item: webSocketSet){ 
        	String n = name;
        	if(item.getName().equals(name)){
        		n="我";
        	}
            try {
                item.getSession().getBasicRemote().sendText(n+":"+message);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }
	public void sendJson(String message) throws IOException{
        for(WebSocketUtil item: webSocketSet){   
            try {
                item.getSession().getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
	}
	@OnOpen
    public void onOpen (@PathParam("userId") String userId,  Session session) {
		this.setSession(session);
		try {
			JSONObject json = new JSONObject(); 
			name = userId;
//			json.append("11", "1111");
//			new WebSocketUtil().sendJson(json.toString());
			session.getBasicRemote().sendText("欢迎"+name+"登录");
		} catch (Exception e) {
			e.printStackTrace();
		}
	    webSocketSet.add(this);
        System.out.println("Client connected");

    }
    @OnClose
    public void onClose () {
    	webSocketSet.remove(this);
    	System.out.println("Connection closed");
    }
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
