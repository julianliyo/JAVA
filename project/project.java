package classs.project;


public class project {
    private String nombre;
    private String descripcion;
    private double initialcost;
    
    public project() {}
    
    public project(String nombre) {
		super();
		this.nombre = nombre;
    }
	public project(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
    public double getInitialcost() {
		return initialcost;
	}

	public void setInitialcost(double initialcost) {
		this.initialcost = initialcost;
	}

	public String elevatorPitch() {
        return nombre + " : "  + descripcion+ "($" + initialcost + ")";
    }
}
