public class PlayerClient extends Component
{
    private String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    public ServerConnection connection;
    public String player_name = "player";
    public SUIText ping_viewer;
    private float timer;
    public int my_life = 100;
    
    @Override
    public void start()
    {
        if(connection == null)
        {
            connection = WorldController.findObject("server").findComponent(ServerConnection.class);
        }
        
        connection.open_connection(get_client_id(), player_name, myTransform.position, myTransform.rotation);
        connection.async_server_listener();
    }

    @Override
    public void repeat()
    {
        timer += Math.bySecond();
        
        if(timer >= 2f)
        {
            timer = 0;
            connection.ping_server();
        }
        
        connection.update_position(get_client_id(), myTransform.position, myTransform.rotation);
        
        ping_viewer.setText("ping: " + connection.get_ping());
    }
    
    @Override
    public void stoppedRepeat()
    {
        if(connection != null)
        {
            connection.close_connection(get_client_id());
        }
    }
    
    public String get_client_id()
    {
        String id = SaveGame.loadString("clientid");
        
        if(id == null)
        {
            StringBuilder sb = new StringBuilder(10);
            for (int i = 0; i < 10; i++)
            {
                int index = (int) (Random.range(0, characters.length() - 1));
                sb.append(characters.charAt(index));
            }
            
            id = sb.toString();
            SaveGame.saveString("clientid", id);
        }
        
        return id;
    }
    
    public String getComponentMenu()
    {
        return "Multiplayer";
    }
}
