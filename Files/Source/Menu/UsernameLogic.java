private SUIText text;

public void start()
{
    text = myObject.findComponentInChildren(SUIText.class);
    text.setText(get_username());
}

public void onKeyDown(Key key)
{
    if(!key.getName().equals("change-name"))
        return;
        
    new InputDialog("new username", get_username(), new InputDialogListener()
    {
        public void onFinish(String text)
        {
            set_username(text);
        }
        
        public void onCancel()
        {
            
        }
    });
}

private String get_username()
{
    if(GameData.get_username() == null)
    {
        GameData.set_username(SaveGame.loadString("username"));
    }
    
    return GameData.get_username();
}

private void set_username(String username)
{
    GameData.set_username(username);
    SaveGame.saveString("username", GameData.get_username());
    text.setText(GameData.get_username());
}

public String getComponentMenu()
{
    return "Menu";
}
