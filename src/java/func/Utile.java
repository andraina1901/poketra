package func;

import gestion.Gestion;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import requete.Requete;

public class Utile {
    public static void dispatcher(HttpServletRequest request, HttpServletResponse response,String body)throws Exception{
        RequestDispatcher re = request.getRequestDispatcher("page/header.jsp");
        re.include(request, response);
        RequestDispatcher re1 = request.getRequestDispatcher("body/"+body);
        re1.include(request, response);
        RequestDispatcher re2 = request.getRequestDispatcher("page/footer.jsp");
        re2.include(request, response);
        
    }
    
    public static Gestion getGestionCom(HttpServletRequest request){
         HttpSession session= request.getSession();
         return (Gestion) session.getAttribute("session");
    }
    
    public  static <T> T[] convertToType(Requete[] requetes, Class<T> type) {
        T[] result = (T[]) Array.newInstance(type, requetes.length);

        try {
            Constructor<T> constructor = type.getDeclaredConstructor();
            for (int i = 0; i < requetes.length; i++) {
                T instance = constructor.newInstance();
                copyFields(requetes[i], instance);
                result[i] = instance;
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        return result;
    }
    
    static void copyFields(Object source, Object destination) throws IllegalAccessException {
        Class<?> sourceClass = source.getClass();
        Class<?> destinationClass = destination.getClass();

        for (Field sourceField : sourceClass.getDeclaredFields()) {
            Field destinationField;
            try {
                destinationField = destinationClass.getDeclaredField(sourceField.getName());
                sourceField.setAccessible(true);
                destinationField.setAccessible(true);
                destinationField.set(destination, sourceField.get(source));
            } catch (NoSuchFieldException e) {
                // Laisser de côté les champs qui n'existent pas dans la classe de destination
            }
        }
    }
    
    public static <T> T[] ajouterElement(T[] tableauOriginal, T nouvelElement) {
        T[] nouveauTableau = Arrays.copyOf(tableauOriginal, tableauOriginal.length + 1);
        nouveauTableau[nouveauTableau.length - 1] = nouvelElement;
        return nouveauTableau;
    }
    
    public static void upload(String nom,HttpServletRequest req)throws Exception{
        Part filePart = req.getPart("pdf");
        String fileName = nom; // Obtenez le nom du fichier
        String pateh = "C:\\Users\\P15A-56-jeremia\\Documents\\NetBeansProjects\\Commerce\\web\\";
        // Écrivez le contenu du fichier dans le dossier de destination
        File files = new File(pateh, fileName);

        try (InputStream fileContent = filePart.getInputStream()){
            Path p = files.toPath();
            if(files.exists()){
                files.delete();
            }
            Files.copy(fileContent, p);
        }
    }
}
