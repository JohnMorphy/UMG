package Backend;

public class NoImageException extends RuntimeException {

    public NoImageException() {
        super("Image not found");
        System.out.println("Image not found");
    }
}
