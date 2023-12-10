package ProjetoIMDB;

public class Filme {

    private String titulo;
    private String genero;
    private String idioma;
    private String[] diretor;
    private String ano;
    private String[] ator;

    public Filme(String titulo, String genero, String idioma, String[] diretor, String ano, String[] ator) {
        this.titulo = titulo;
        this.genero = genero;
        this.idioma = idioma;
        this.diretor = diretor;
        this.ano = ano;
        this.ator = ator;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public String getIdioma() {
        return idioma;
    }

    public String[] getDiretor() { return diretor;}

    public String getAno() {
        return ano;
    }

    public String[] getAtor() {
        return ator;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setDiretor(String[] diretor) {
        this.diretor = diretor;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public void setAtor(String[] ator) {
        this.ator = ator;
    }
}
