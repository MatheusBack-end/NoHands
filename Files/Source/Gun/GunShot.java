public class GunShot extends Component implements Gun
{
    @AutoWired
    public Camera camera;
    private ServerConnection connection;
    private PlayerClient player_client;
    private Laser laser = new Laser();
    
    public void start()
    {
        player_client = myObject.getParent().findComponent(PlayerClient.class);
        connection = player_client.connection;
    }
    
    public void on_shot()
    {
        LaserHit hit = laser.trace(myTransform.getGlobalPosition(), get_midle(), 0);
        
        if(hit != null)
        {
            if(hit.getObject().getTag().equals("player"))
            {
                connection.hit("abcdefjklm", player_client.get_client_id());
            }
        }
    }
    
    public Vector3 get_midle()
    {
        return camera.screenPointNormal(
            Screen.getWidth() / 2,
            Screen.getHeight() / 2);
    }
    
    public String getComponentMenu()
    {
        return "Gun";
    }
}
