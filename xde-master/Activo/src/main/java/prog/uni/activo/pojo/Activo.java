/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog.uni.activo.pojo;

/**
 *
 * @author Pablo
 */
public class Activo {
    private String name;
    private float value;
    private float Salvament;
    private Type type;
    
    public enum Type
    {
        EDIFICIO, VEHICULO, MAQUINARIA, MOBILIARIA, EQUIPO_DE_OFICINA
    }

    public Activo() {}

    public Activo(String name, float value, float Salvament, Type type) {
        this.name = name;
        this.value = value;
        this.Salvament = Salvament;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getSalvament() {
        return Salvament;
    }

    public void setSalvament(float Salvament) {
        this.Salvament = Salvament;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    
    public float Depretiation()
    {
        return (value - Salvament) / anio();
    }
    
    public int anio()
    {
        int a = 0;
        switch(type)
        {
            case EDIFICIO: a = 20; break;
            case VEHICULO: a = 5; break;
            case MAQUINARIA: a = 8; break;
            case MOBILIARIA: a = 2; break;
            case EQUIPO_DE_OFICINA: a = 1; break;
        }
        return a;
    }
    
    public Object[] AsArray()
    {
        Object[] obj = new Object[anio() + 1];
        obj[0] = name;
        
        for (int i = 1; i < obj.length; i++) 
        {
            obj[i] = Depretiation();
        }
        
        return obj;
    }
}
