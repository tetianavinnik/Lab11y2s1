package task2;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class MailInfo {
    private Client client;
    private MAilCode mAilCode;

    public String generate() {
        return mAilCode.generate(client);
    }
}
