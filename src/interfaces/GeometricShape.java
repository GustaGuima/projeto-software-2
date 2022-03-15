package interfaces;

public interface GeometricShape {
    String toString();
	String toTextLine();
    String toTextLineBD();
    String getStrPosition();
    String toStringArq();
    
	Shape getController();
}
