// config variables
public float Sensitivity, Velocity;

private Vector2 touch, joystick;
private SpatialObject camera;

@AutoWired
private Characterbody physics;

public void start()
{
    touch = Input.getAxisValue("touch");
    joystick = Input.getAxisValue("joystick");
    camera = myObject.findChildObject("camera");
}

public void repeat()
{
    myObject.rotateInSeconds(0, -touch.getX() * Sensitivity, 0);
    camera.rotateInSeconds(touch.getY() * Sensitivity, 0, 0);
    
    physics.setForwardSpeed(joystick.getY() * Velocity);
    physics.setSideSpeed(-joystick.getX() * Velocity);
}


public String getComponentMenu()
{
    return "Player";
}