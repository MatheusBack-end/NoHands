private Vector2 slide, joystick;
private Quaternion rotation_x, rotation_y;

private final Vector3 vector_right = new Vector3(1, 0, 0);
private final Vector3 vector_up = new Vector3(0, 1, 0);

private float value_x, value_y;

// config variables
public float Smooth, SwayMultiplier, JoystickMultiplier;

public void start()
{
    slide = Input.getAxisValue("touch");
    joystick = Input.getAxisValue("joystick");
}

public void repeat()
{
    value_x = lerp(value_x,  slide.getX() * SwayMultiplier, 0.5f);
    value_y = lerp(value_y, (-slide.getY() + (joystick.getY() *  JoystickMultiplier)) * SwayMultiplier, 0.5f);

    rotation_x = Quaternion.angleAxis(value_y, vector_right);
    rotation_y = Quaternion.angleAxis(value_x, vector_up);

    myTransform.setRotation(Quaternion.slerp(myTransform.getRotation(), rotation_x, Smooth * Time.deltaTime));
    myTransform.setRotation(Quaternion.slerp(myTransform.getRotation(), rotation_y, Smooth * Time.deltaTime));
}

public static float clamp(float value)
{
    if (value < 0f)
        return 0f;
    else if (value > 1f)
        return 1f;
    else
        return value;
}

public static float lerp(float a, float b, float t)
{
    return a + (b - a) * clamp(t);
}    
    
public String getComponentMenu()
{
    return "Gun";
}