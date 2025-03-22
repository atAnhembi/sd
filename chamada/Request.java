import java.io.Serializable;

public class Request implements Serializable {
    private String password;
    private String ra;

    public Request(String password, String ra) {
        this.password = password;
        this.ra = ra;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

}
