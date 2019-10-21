package practica4.juanmartinez.practica4;

public class Poblacion {

    private String provincia;
    private String localidad;
    private float valoracion;
    private String comentarios;

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public float getValoracion() {
        return valoracion;
    }

    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }


    public boolean equals (Object obj) {

        if (obj instanceof Poblacion) {

            Poblacion tmpPoblacion = (Poblacion) obj;

            if (this.provincia.equals(tmpPoblacion.provincia) && this.localidad.equals(tmpPoblacion.localidad)) {
                return true;
            }
            else {
                return false;
            }

        } else {
            return false;
        }
    }
}
