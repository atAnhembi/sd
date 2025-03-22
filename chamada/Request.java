import java.io.Serializable;

public class Request implements Serializable {
    static final long serialVersionUID = 1L;
    private String password;
    private String ra;

    public Request(String password, String ra) {
        this.password = password;
        this.ra = ra;
    }

    public String getPassword() {
        return password;
    }

    public String getRa() {
        return ra;
    }

}
