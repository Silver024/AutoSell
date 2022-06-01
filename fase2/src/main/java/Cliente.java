import java.io.Serializable;
import java.lang.ref.Cleaner;

public class Cliente implements Serializable {
    private String nome, morada, genero, dataNascimento, contacto, email, nif, estadoProfissional;

    public Cliente(String nome, String morada, String genero, String dataNascimento, String contacto, String email, String nif, String estadoProfissional){
        this.nome = nome;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.contacto = contacto;
        this.morada = morada;
        this.email = email;
        this.nif = nif;
        this.estadoProfissional = estadoProfissional;
    }

    public String getNome() {
        return nome;
    }

    public String getMorada() {
        return morada;
    }

    public String getGenero() {
        return genero;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getContacto() {
        return contacto;
    }

    public String getEmail() {
        return email;
    }

    public String getnif() {
        return nif;
    }

    public String getEstadoProfissional() {
        return estadoProfissional;
    }



    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setEstadoProfissional(String estadoProfissional) {
        this.estadoProfissional = estadoProfissional;
    }
}
