import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


public class API {
    API() throws UnirestException {
                    //System.out.println("Hey");
        HttpResponse<JsonNode> response = Unirest.get("https://anshul_123-indianstock-v1.p.mashape.com/index.php?id=500209")
                .header("X-Mashape-Key", "UAZ74EJd1mmshAAe1isQyt3y9Obxp168shAjsn695RPk33RZc8")
                .asJson();
            System.out.println(response);
        }


 //   API1();
//    public static void setTimeout(Runnable runnable, int delay) {
//        new Thread(() -> {
//            try {
//                Thread.sleep(delay);
//                runnable.run();
//            } catch (Exception e) {
//                System.err.println(e);
//            }
//        }).start();
//    }
//
//    // To call with lambda expression:
//    setTimeout(() ->System.out.println("test"),1000);
//
//    // Or with method reference:
//    setTimeout(anInstance::aMethod, 1000);
//
//
//    function myStartFunction() {
//        var myvar;
//        myVar = setTimeout(alertFunc, 2000);
//    }
}