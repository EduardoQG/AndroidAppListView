package com.example.practicat6intento4;

public class ListItem {
    private String texto;
    private int imagenId; // Id de la imagen (puede ser un recurso drawable)

    public ListItem(String texto, int imagenId) {
        this.texto = texto;
        this.imagenId = imagenId;
    }

    public String getTexto() {
        return texto;
    }

    public int getImagenId() {
        return imagenId;
    }
}
