package org.darihuan.chatbackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat-websocket/*")
                .setAllowedOrigins("https://chartskt.herokuapp.com/")
                .withSockJS();
        //ruta servidor en springboot, permisos de acceso para angulat y permitir uso del framework de sockets
    }
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
      config.enableSimpleBroker("/chat"); //Prefijo para los nombres de evento
      config.setApplicationDestinationPrefixes("/app"); //Prefijo del destino

    }
}
