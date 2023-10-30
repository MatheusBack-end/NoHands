private Gun gun_interface;

// config variables
public float ShotDelay;

private Key shot_key;
private float timer;

public void start()
{
    gun_interface = (Gun) myObject.findComponent(Gun.class);
}

public void repeat()
{
    timer -= Time.deltaTime();
    
    if(in_click())
        shot();
}

public boolean in_click()
{
    return get_key().isDown() || get_key().isPressed();
}

public void shot()
{
    if(timer <= 0)
    {
        gun_interface.on_shot();
        timer = ShotDelay;
    }
}

private Key get_key()
{
    if(shot_key == null)
        shot_key = Input.getKey("shot-button");
        
    return shot_key;
}

public String getComponentMenu()
{
    return "Events";
}
