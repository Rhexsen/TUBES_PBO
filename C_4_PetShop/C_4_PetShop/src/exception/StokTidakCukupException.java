
package exception;

public class StokTidakCukupException extends Exception{

    public StokTidakCukupException(){
        super("Stok produk tidak mencukupi!");
    }
}
