import java.nio.*;

public class ServerReceive
{
    private ServerConnection connection;
    
    public ServerReceive(ServerConnection connection)
    {
        this.connection = connection;
    }
    
    public void receive()
    {
        while(true)
        {
            ByteBuffer buffer = connection.read_server();
            byte packet_id = buffer.get();
        
            if(packet_id == 0x00)
            {
                connection.set_ping(java.lang.System.currentTimeMillis());
            }
            
            if(packet_id == 0x01)
            {
                OpenSessionPacket packet = new OpenSessionPacket();
                packet.buffer = buffer;
                packet.decode();
                
                connection.add_player(packet.player_session);
            }
            
            if(packet_id == 0x02)
            {
                UpdatePositionPacket packet = new UpdatePositionPacket();
                packet.buffer = buffer;
                packet.decode();
                
                connection.update_player_position(packet.client_id, packet.position, packet.rotation);
            }
            
            if(packet_id == 0x04)
            {
                StartGamePacket packet = new StartGamePacket();
                packet.buffer = buffer;
                packet.decode();
                
                for(PlayerSession player: packet.players)
                {
                    connection.add_player(player);
                }
            }
            
            if(packet_id == 0x05)
            {
                CloseConnectionPacket packet = new CloseConnectionPacket();
                packet.buffer = buffer;
                packet.decode();
                
                connection.remove_player(connection.get_player_by_id(packet.client_id));
            }
            
            if(packet_id == 0x09)
            {
                HitPacket packet = new HitPacket();
                packet.buffer = buffer;
                packet.decode();
                
                connection.damage_by_hit(packet.client_id);
            }   
        }
    }
}