public class HitPacket
{
    private static int PID = 0x09;
    public ByteBuffer buffer;
    public String client_id;
    public String damager_id;
    
    public void encode()
    {
        buffer = ByteBuffer.allocate(21);
        buffer.put((byte) PID);
        BinaryUtils.write_string(buffer, client_id, 10);
        BinaryUtils.write_string(buffer, damager_id, 10);
    }
    
    public void decode()
    {
        client_id = BinaryUtils.read_string(buffer, 10);
        damager_id = BinaryUtils.read_string(buffer, 10);
    }
}
