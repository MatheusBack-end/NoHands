public class Utils {
    
    private static String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    
    public static String generateClientId() {
        StringBuilder sb = new StringBuilder(10);
            
        for (int i = 0; i < 10; i++) {
            int index = (int) (Random.range(0, characters.length() - 1));
            sb.append(characters.charAt(index));
        }
            
        return sb.toString();
    }
}