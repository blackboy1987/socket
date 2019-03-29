package com.paicent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate template;

    @Scheduled(fixedRate = 1000)
    public void sendTopicMessage() {
        System.out.println("后台广播推送！");
        User user = new User();
        user.setAge(123);
        user.setUsername(new Date().toString());
        template.convertAndSend("/topic/getResponse", user);
    }

    @Scheduled(fixedRate = 1000)
    public void sendQueueMessage() {
        System.out.println("后台一对一推送！");
        User user=new User();
        user.setId(1L);
        user.setUsername("oyzc");
        user.setAge(10);
        this.template.convertAndSendToUser(user.getId()+"","/topic/getResponse",user);
    }

    /**
     * 群发消息
     *      房间id
     */
    @GetMapping("/sendAllMessage")
    public User mass(){
        User user = new User();
        user.setUsername("群发消息");
        user.setId(System.currentTimeMillis());
        user.setAge(3);
        this.template.convertAndSend("/topic/sendAllMessage",user);

        return user;
    }

    /**
     *  系统给指定的人发送消息
     *      房间id
     */
    @GetMapping("/sendUserMessage")
    public User sendUserMessage(Integer userId){
        User user = new User();
        user.setUsername("我是给指定人发送的消息");
        user.setId(System.currentTimeMillis());
        user.setAge(userId);
        this.template.convertAndSendToUser(userId+"","/topic/sendUserMessage",user);

        return user;
    }

    /**
     *  点对点发送消息
     *      房间id
     */
    @GetMapping("/sendUserToUserMessage")
    public User sendUserToUserMessage(Long fromUserId,Long toUserId){
        List<User> users = new ArrayList<User>();
        User user = new User();
        user.setUsername("我是发送人");
        user.setId(fromUserId);
        user.setAge(12);
        users.add(user);

        User user1 = new User();
        user1.setUsername("我是发送人");
        user1.setId(toUserId);
        user1.setAge(13);
        users.add(user1);
        this.template.convertAndSendToUser(toUserId+"","/topic/sendUserToUserMessage",users);
        return user;
    }
}