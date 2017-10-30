package radams.gracenote.webapi;
import radams.gracenote.webapi.GracenoteException;
import radams.gracenote.webapi.GracenoteMetadata;
import radams.gracenote.webapi.GracenoteWebAPI;


// You will need a Gracenote Client ID to use this. Visit https://developer.gracenote.com/
// for more information.

public class Example
{
    private static String clientID  = "1229386339"; // Put your clientID here.
    private static String clientTag = "325C491B3B2339F178C381BADA2062B5"; // Put your clientTag here.


    public static void main(String[] args)
    {
        try
        {
            /* You first need to register your client information in order to get a gnsdkClientId.
            Best practice is for an application to call this only once, and then cache the gnsdkClientId in
            persistent storage, then only use the gnsdkClientId for subsequent API calls. The class will cache
            it for just this session on your behalf, but you should store it yourself. */
            GracenoteWebAPI api = new GracenoteWebAPI(clientID, clientTag); // If you have a gnsdkClientId, you can specify it as the third parameter to constructor.
            String userID = api.register();
            System.out.println("UserID = " + userID);

            // Once you have the gnsdkClientId, you can search for tracks, artists or albums easily.
            System.out.println("Search Track:");
            GracenoteMetadata results = api.searchTrack("Moby", "Play", "Porcelin");
            results.print();

            System.out.println("Search Artist:");
            results = api.searchArtist("Moby");
            results.print();

            System.out.println("Search Album:");
            results = api.searchAlbum("Moby", "Play");
            results.print();

            System.out.println("Fetch Album:");
            results = api.fetchAlbum("97474325-8C600076B380712C6D1C5DC5DC5674F1");
            results.print();
        }
        catch (GracenoteException e)
        {
            e.printStackTrace();
        }
    }
}
