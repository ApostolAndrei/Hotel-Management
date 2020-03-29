public class CEO extends Human
{


    private static CEO instance;

    private CEO()
    {
        super("Apostol Andrei-Mihnea");
    }


    public static CEO getInstance()
    {
        if (instance == null)
            instance = new CEO();

        return instance;
    }

    public void CEOname()
    {
      super.getName();
    }

}

