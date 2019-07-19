import javax.jws.soap.SOAPBinding;

public class Response {
    @Override
    public String toString() {
        User user = new User();
        Site site = new Site();
        Country country = new Country();
        return String.format("{User: %s, Site: %s, Country: %s}",
                user.toString(),
                site.toString(),
                country.toString());
    }
}
