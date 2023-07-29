package classs.project;

public class projectTest {

	    public static void main(String[] args) {

	        project project1 = new project(null, null);
	        project project2 = new project(null, null);
	        project project3 = new project(null, null);


	        project1.setNombre("proyecto casa");
	        project1.setDescripcion("trata sobre los proyectos de la casa");
	        project1.setInitialcost(50000);
	        project2.setNombre("curso java");
	        project2.setDescripcion("trata sobre un curso java.");
	        project2.setInitialcost(4200);
	        project3.setNombre("Proyecto web");
	        project3.setDescripcion("Este Proyecto trata sobre desarrollo web.");
	        project3.setInitialcost(6500);

	        
	        System.out.println(project1.elevatorPitch());
	        System.out.println(project2.elevatorPitch());
	        System.out.println(project3.elevatorPitch());
	    }
	}

