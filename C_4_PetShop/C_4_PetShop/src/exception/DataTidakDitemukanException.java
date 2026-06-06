
package exception;

public class DataTidakDitemukanException extends Exception{

    public DataTidakDitemukanException(){
        super("Data tidak ditemukan!");
    }
}
