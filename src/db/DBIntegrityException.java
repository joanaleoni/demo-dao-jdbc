package db;

/**
 *
 * @author joana
 */
public class DBIntegrityException extends RuntimeException {

    public DBIntegrityException(String msg) {
        super(msg);
    }    
}