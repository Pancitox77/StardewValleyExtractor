package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


public class NPCScrapper {
    /* CONSTANTS */


    //Every NPC has...
    public static final String NPC_NAME = "name";
    public static final String NPC_LINK = "link";

    private final String URL_BASE = "https://es.stardewvalleywiki.com";
    private final String URL_NPCLIST = "https://es.stardewvalleywiki.com/Aldeanos";


    /* CLASS VARS */


    private WebClient webClient;
    private ArrayList<HashMap<String,String>> npcList;


    /* CONSTRUCTOR AND PUBLIC FUNCTIONS */


    public NPCScrapper(){
        webClient = new WebClient(BrowserVersion.CHROME);

        //Clear useless messages
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setPrintContentOnFailingStatusCode(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);

        npcList = new ArrayList<>();
        preloadNPCList();
    }


    public ArrayList<HashMap<String,String>> getNPCList(){ return npcList; }


    public HashMap<String,String> getNpcInfo(String npcUrl){
        HashMap<String,String> info = new HashMap<>();

        //get name,diary,gifts,heart events, and more

        return info;
    }


    /* PRIVATE FUNCTIONS */
    

    private void preloadNPCList(){
        try {
            HtmlPage page = webClient.getPage(URL_NPCLIST);
            webClient.getCurrentWindow().getJobManager().removeAllJobs();


            /* GET DATA OF NPC */
            //Obtain links
            DomNodeList<DomElement> links = page.getElementsByTagName("li");

            //Get only NPC links
            ArrayList<DomElement> clearedNPElements = onlyNPCLinks(links);

            //Save name,image and link from each npc
            extractData(clearedNPElements);


            //Close connection
            webClient.close();

        } catch (IOException ioe){ System.out.println("Error en el Scrapper.java"); }
    }


    private ArrayList<DomElement> onlyNPCLinks(DomNodeList<DomElement> lists){
        ArrayList<DomElement> npcElement = new ArrayList<>();

        for(DomElement element: lists){
            if(element.getAttribute("class").equals("gallerybox")){
                npcElement.add(element);
            }
        }
        return npcElement;
    }


    private void extractData(ArrayList<DomElement> elements){
        for(DomElement element: elements){            
            DomElement nameLink = element.getLastElementChild()
                .getLastElementChild().getLastElementChild().getLastElementChild();
            
            /* Jerarquía HTML:

                <li class="gallerybox" style="width: 114.722px;">
                    <div style="width: 114.722px;">
			            <div class="thumb" style="width: 112.722px;">
                            <div style="margin:0px auto;">
                                <a href="/Alex"><img alt="" src="https://stardewvalleywiki.com/mediawiki/images/0/04/Alex.png" decoding="async" width="112" height="131"></a></div></div>
			            <div class="gallerytext">
                            <p>
                                <a href="/Alex" title="Alex">Alex</a>
                            </p>
			            </div>
		            </div>
                </li>

            */
            
            String name = nameLink.getAttribute("title");
            String link = URL_BASE + nameLink.getAttribute("href");

            HashMap<String,String> data = new HashMap<>(3);
            data.put(NPC_NAME, name);
            data.put(NPC_LINK, link);

            npcList.add(data);
        }
    }
}
