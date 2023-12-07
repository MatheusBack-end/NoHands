public WorldFile world;

@Override
public void onKeyDown(Key key)
{
    if(!key.getName().equals("play-button"))
        return;
        
    WorldController.loadWorld(world);
}

@Override
public String getComponentMenu()
{
    return "Menu";
}