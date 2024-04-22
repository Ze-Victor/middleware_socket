package naming;

public class ServicoAplicacaoInfo {
    private String url;
    private int porta;

    public ServicoAplicacaoInfo(String url, int porta) {
        this.url = url;
        this.porta = porta;
    }

    public String getUrl() {
        return url;
    }

    public int getPorta() {
        return porta;
    }
}
