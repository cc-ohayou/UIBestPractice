package space.cc.com.uibestpractice.domain.bizObject;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Msg {
    public static final int TYPE_RECEIVED=0;
    public static final int TYPE_SENT=1;
    private String content;
    //消息类型
    private int type;

    public Msg(String content, int type) {
        this.content = content;
        this.type = type;
    }
}
