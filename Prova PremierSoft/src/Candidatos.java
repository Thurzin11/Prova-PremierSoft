import java.io.Serializable;

public class Candidatos implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;
    private Integer idade;
    private String vaga;
    private String estado;

    public Candidatos() {}

    public Candidatos(String nome, Integer idade, String vaga, String estado) {
        super();
        this.nome = nome;
        this.idade = idade;
        this.vaga = vaga;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getVaga() {
        return vaga;
    }

    public void setVaga(String vaga) {
        this.vaga = vaga;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Candidatos{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", vaga='" + vaga + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
