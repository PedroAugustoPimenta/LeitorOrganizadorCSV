
package csv;


public class Item {
    
    public String site;
    public int classificacao;

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }
    
    

    public Item(String site, int classificacao) {
        this.site = site;
        this.classificacao = classificacao;
    }
    
    
}
