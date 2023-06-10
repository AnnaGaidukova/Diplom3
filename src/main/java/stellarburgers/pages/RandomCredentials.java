package stellarburgers.pages;

public class RandomCredentials {
    public String String() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyzabcdefghijklmnopqrstuvxyz";
        StringBuilder stringBuilder = new StringBuilder();
        int stringLength = 10;
        int y;
        for ( y = 0; y < stringLength; y++) {
            int index = (int)(chars.length() * Math.random());
            stringBuilder.append(chars.charAt(index));
        }
        return stringBuilder.toString();
    }

    public String invalidString() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyzabcdefghijklmnopqrstuvxyz";
        StringBuilder stringBuilder = new StringBuilder();
        int stringLength = 4 ;
        int y;
        for ( y = 0; y < stringLength; y++) {
            int index = (int)(chars.length() * Math.random());
            stringBuilder.append(chars.charAt(index));
        }
        return stringBuilder.toString();
    }

    public String Email() {
        String emailHost = "@yandex.ru";
        String emailUserName = String();
        return emailUserName + emailHost;
    }
}
