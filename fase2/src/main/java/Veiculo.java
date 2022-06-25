import java.io.Serializable;

public class Veiculo implements Serializable {
    private String matricula, marca, modelo, garantia, disponibilidade, donoAnterior, nrDonos, mesRegisto, anoRegisto, quilometros, cilindrada, potencia, cor, segmento, nrPortas, condicao;

    public Veiculo(String matricula, String marca, String modelo, String garantia, String disponibilidade, String donoAnterior, String nrDonos, String mesRegisto, String anoRegisto, String quilometros, String cilindrada, String potencia, String cor, String segmento, String nrPortas, String condicao){
    this.matricula = matricula;
    this.marca = marca;
    this.modelo = modelo;
    this.garantia = garantia;
    this.disponibilidade = disponibilidade;
    this.donoAnterior = donoAnterior;
    this.nrDonos = nrDonos;
    this.mesRegisto = mesRegisto;
    this.anoRegisto = anoRegisto;
    this.quilometros = quilometros;
    this.cilindrada = cilindrada;
    this.potencia = potencia;
    this.cor = cor;
    this.segmento = segmento;
    this.nrPortas = nrPortas;
    this.condicao = condicao;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getGarantia() {
        return garantia;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public String getDonoAnterior() {
        return donoAnterior;
    }

    public String getNrDonos() {
        return nrDonos;
    }

    public String getMesRegisto() {
        return mesRegisto;
    }

    public String getAnoRegisto() {
        return anoRegisto;
    }

    public String getQuilometros() {
        return quilometros;
    }

    public String getCilindrada() {
        return cilindrada;
    }

    public String getPotencia() {
        return potencia;
    }

    public String getCor() {
        return cor;
    }

    public String getSegmento() {
        return segmento;
    }

    public String getNrPortas() {
        return nrPortas;
    }

    public String getCondicao() {
        return condicao;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public void setDonoAnterior(String donoAnterior) {
        this.donoAnterior = donoAnterior;
    }

    public void setNrDonos(String nrDonos) {
        this.nrDonos = nrDonos;
    }

    public void setMesRegisto(String mesRegisto) {
        this.mesRegisto = mesRegisto;
    }

    public void setAnoRegisto(String anoRegisto) {
        this.anoRegisto = anoRegisto;
    }

    public void setQuilometros(String quilometros) {
        this.quilometros = quilometros;
    }

    public void setCilindrada(String cilindrada) {
        this.cilindrada = cilindrada;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    public void setNrPortas(String nrPortas) {
        this.nrPortas = nrPortas;
    }

    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }
}
