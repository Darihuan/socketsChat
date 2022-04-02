package org.darihuan.chatbackend.chat.controller;

import org.darihuan.chatbackend.chat.domain.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class ChatController {
  @MessageMapping("/chat")
  @SendTo("/chat/messages")
  // chat indica que es un evento y message es el nombre del evento cualquier cliente que se
  // suscriba a este
  // evento recibira los cambios que realicen otros clientes
  public Message getMessage(Message message) {
    if(message.getType().equals("NEW_USER")){
      message.setContent("User, " + message.getUser()+ ", has joined the chat");
    }
    message.setTime(new Date().getTime());
    return message;
  }
@MessageMapping("writting")
@SendTo("/chat/writting")
  public String isTheUserTyping(String username){
    return   username;
}
}
