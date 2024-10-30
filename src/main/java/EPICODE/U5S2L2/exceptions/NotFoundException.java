package EPICODE.U5S2L2.exceptions;

public class NotFoundException extends RuntimeException {
    public <T> NotFoundException(Class<T> entity) {
        super(entity.getSimpleName() + " not found!");
    }
}
