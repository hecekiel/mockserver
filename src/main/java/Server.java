import com.google.gson.Gson;
import org.mockserver.client.server.MockServerClient;
import org.mockserver.model.Delay;
import org.mockserver.model.Header;
import java.util.concurrent.TimeUnit;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;

public class Server {
    static final MockServerClient mockServerClient = startClientAndServer(8081);
    static final Gson gson = new Gson();

    public static void consulta(String metodo, String ruta, int codigo, String content, String body, int delay) {
        mockServerClient
        .when(
            request()
                .withMethod(metodo)
                .withPath(ruta)
        ).respond(
            response()
                .withStatusCode(codigo)
                .withHeader(new Header("content-type", "json"))
                .withBody(body)
                .withDelay(new Delay(TimeUnit.MILLISECONDS, delay))
        );

    }

    public static void main(String[] args) {
        Item item = new Item(1);
        consulta("GET", "/items/.*", 200, "application/json; charset=utf-8", gson.toJson(item), 0);

        User user = new User();
        consulta("GET", "/users/.*", 200, "application/json; charset=utf-8", user.toString(), 0);

        Site site = new Site();
        consulta("GET", "/sites/.*", 200, "application/json; charset=utf-8", site.toString(), 0);

        Country country = new Country();
        consulta("GET", "/countries/.*", 200, "application/json; charset=utf-8", country.toString(), 0);

        Response response = new Response();
        consulta("GET", "/response/.*", 200, "application/json; charset=utf-8", response.toString(), 0);
    }
}
