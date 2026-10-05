/**
 * Beschreiben Sie hier die Klasse POP3client.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class POP3client extends Client
{
    private GUI gui;
    private String command = "";
    private long commandTS;
    private String user;
    private String pass;
    private int numberMessages;
    private int currentMessage;
    private int maxEmails;
    private String nachricht;

    /**
     * Konstruktor für Objekte der Klasse POP3client
     */
    public POP3client(String pServerIP, int pServerPort, GUI pGui)
    {
        super(pServerIP, pServerPort);
        gui = pGui;
        
    }

    public void processMessage(String pMessage)
    {
        gui.ausgabeAppend(pMessage);
        nachricht = pMessage;
    }

    public void meldeAn(String pUser, String pPass)
    {
        send("USER " + pUser);
        schlafe(100);
        send("PASS " + pPass);
        send("STAT");
        send("LIST");
        
    }

    public void fetch()
    {
        send("STAT");
        String[] splitMessage = nachricht.split("");
        gui.setVon(Integer.parseInt(splitMessage[1]));
        maxEmails = Integer.parseInt(splitMessage[1]);
        currentMessage = gui.getCurrentMessage();
        send("RETR "+currentMessage);
        
    }

    public void prev()
    {
        if(currentMessage >1){
            currentMessage = currentMessage -1;
            fetch();
        }
        

    }

    public void next()
    {
        if(currentMessage <maxEmails){
            currentMessage = currentMessage +1;
            fetch();
        }

    }
    public void schlafe(int pMsec) 

    { 

         try { 

            Thread.sleep(pMsec); 

         } catch(InterruptedException ex) { 

            Thread.currentThread().interrupt(); 

         } 

    } 
}
