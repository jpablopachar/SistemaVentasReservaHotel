package Datos;

public class vCliente extends vPersona {
    private String codigoCliente;

    public vCliente() {
    }

    public vCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }
}
