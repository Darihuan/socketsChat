package org.darihuan.chatbackend.chat.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Message  implements Serializable {
    private String content;
    private String user;
    private String type;
    private long time;
    private long color;
}
