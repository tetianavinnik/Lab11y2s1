package task2;

public class GiftMail implements MAilCode{
    private static String TEMPLATE = "BLACK FRIDAY! %NAME";

    @Override
    public String generate(Client client) {
        return TEMPLATE.replace("%NAME", client.getName());
    }
}
