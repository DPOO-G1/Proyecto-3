package persistencia;

import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import learningPath.LearningPath;
import usuarios.Estudiante;
import usuarios.Profesor;
import usuarios.Usuario;

public class PersistenciaLearningPaths {
 
	private static final String FILE_NAME = "learningPaths.ser";

    @SuppressWarnings("unchecked")
    public static void guardarLearningPaths(Map<String, LearningPath> learningpaths) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(learningpaths);
            System.out.println("LearningPaths guardados exitosamente.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al guardar los learningPaths.");
            e.printStackTrace();
        }
    }
    
    public static void borrarDatos () {
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME)) {
            fos.write(new byte[0]);
        } catch (IOException e) {
            System.err.println("Error eliminando los LearningPaths:" + e.getMessage());
        }
    	
    }    
    
    public static Map<String, LearningPath> cargarLearningPaths(Map<String, Usuario> usuarios) {
        Map<String, LearningPath> mapaLearningPaths = new HashMap<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("Archivo de learning paths no encontrado.");
            System.out.println("Desea crear un archivo vacío?\n1. Si\n2. No");
            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            if (opcion == 1) {
                guardarLearningPaths(mapaLearningPaths);
                System.out.println("Archivo de learning paths vacío creado exitosamente: " + FILE_NAME);
            } else {
                System.out.println("No se creará ningún archivo.");
            }
            scanner.close();
            return mapaLearningPaths; 
        }

       
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            mapaLearningPaths = (Map<String, LearningPath>) in.readObject();
            System.out.println("Learning paths cargados exitosamente.");

            for (Map.Entry<String, LearningPath> entry : mapaLearningPaths.entrySet()) {
                LearningPath learningPath = entry.getValue();
                Usuario correo = learningPath.getProfesor();
                
                Usuario profesor = usuarios.get(correo);
                if (profesor instanceof Profesor) {
                    ((Profesor) profesor).addLearningPath(learningPath);
                }
            }
        } 
        catch (EOFException e) {
        	return mapaLearningPaths;
        	}
        catch (IOException | ClassNotFoundException e) {
            System.out.println("Ocurrió un error al cargar los learning paths.");
            e.printStackTrace();
        }

        return mapaLearningPaths;
    }

    public static void agregarLearningPath(LearningPath learningPath, String correo, Map<String, Usuario> usuarios) {
        Map<String, LearningPath> mapaLearningPaths = cargarLearningPaths(usuarios);

        Usuario usuario = usuarios.get(correo);
        if (usuario instanceof Profesor) {
            ((Profesor) usuario).addLearningPath(learningPath);
            learningPath.setProfesor(usuario);
            if (mapaLearningPaths.get(learningPath.getTitulo())==null) {
            	mapaLearningPaths.put(learningPath.getTitulo(), learningPath);
            	guardarLearningPaths(mapaLearningPaths);
            }
            System.out.println("Learning path añadido y guardado exitosamente.");
        }else if(usuario instanceof Estudiante) {
        	((Estudiante) usuario).addLearningPath(learningPath);
        	if (mapaLearningPaths.get(learningPath.getTitulo())==null) {
        		mapaLearningPaths.put(learningPath.getTitulo(), learningPath);
        		guardarLearningPaths(mapaLearningPaths);
        	}
        }else {
            System.out.println("Ocurrio un error");
        }
    }

    public static LocalDate convertirFecha(String fecha) {
        return LocalDate.parse(fecha);
    }

}