public interface IServerConnection {
    
    public ByteBuffer read_server();
    public void set_ping(double current_time);
    public void add_player(PlayerSession player);
    public void update_player_position(String client_id, Vector3 position, Quaternion rotation);
    public PlayerSession get_player_by_id(String client_id);
    public void remove_player(PlayerSession player);
    public void damage_by_hit(String client_id);
}