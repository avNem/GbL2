public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(int row, int column) {
        super("Не правильый формат в строке " + row + ", колонке " + column );
    }
}
