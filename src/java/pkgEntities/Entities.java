package pkgEntities;

/**
 *
 * @author rubeus
 */
public class Entities {
    
    public boolean stringValid(String string){
        String regex = "[a-zA-Z]+";
        return string.matches(regex);
    }
    
    public boolean emailValid(String string){
        String regex = "[-0-9a-zA-Z.+_]+@[-0-9a-zA-Z.+_]+\\.[a-zA-Z]{2,4}";
        return string.matches(regex);
    }
    
    public boolean intValid(String string){
        String regex = "[0-9]+";
        return string.matches(regex);
    }
}