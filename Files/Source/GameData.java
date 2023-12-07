public class GameData
{
    private static String client_id;
    private static String username;
    
    public static void set_client_id(String id)
    {
        client_id = id;
    }
    
    public static void set_username(String name)
    {
        username = name;
    }
    
    public static String get_client_id()
    {
        return client_id;
    }
    
    public static String get_username()
    {
        return username;
    }
}