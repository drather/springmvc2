package hello.typeconverter.type;

import lombok.EqualsAndHashCode;
import lombok.Getter;

// "127.0.0.1:8080" 같은 IP 를 나타내는 문자열이 들어왔을 때, 이를 IpPort 객체로 바꾸려고 함
@Getter
@EqualsAndHashCode
public class IpPort {
    private String id;
    private int port;

    public IpPort(String id, int port) {
        this.id = id;
        this.port = port;
    }
}
