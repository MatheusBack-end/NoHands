public class PlayerDeathPacket
{
    public ByteBuffer buffer;
    public String damager_id;
    
    public void encode()
    {
        
    }
    
    public void decode()
    {
        damager_id = BinaryUtils.read_string(buffer, 10);
    }
}
