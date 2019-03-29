**springboot+websock+sockjs**
1.创建一个springboot项目
2.引入freemarker
3.引入websocket包
4.配置WebSocketConfig
    覆盖两个方法：
        
    @Configuration
        @EnableWebSocketMessageBroker
        public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
        
            //配置节点
            @Override
            public void registerStompEndpoints(StompEndpointRegistry registry){
                registry.addEndpoint("/endpointOyzc").setAllowedOrigins("*").withSockJS();
            }
        
            //配置消息代理
            @Override
            public void configureMessageBroker(MessageBrokerRegistry registry) {
                registry.enableSimpleBroker("/topic","/user");
                registry.setUserDestinationPrefix("/user");
            }
        }
        
5.