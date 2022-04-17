
public class HomeWorkApp {
    public static void main(String[] args) {
        String[][] arr = {{"1", "1", "1", "1"},{"2", "2", "2", "2"},{"3", "3", "3", "3"},{"4", "4", "4", "4"}};
        arrChange(arr);

    }

    public static void arrChange(String[][] array) {
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            res += array[i].length;
        }
        if(res != 16) {
            throw new MyArraySizeException("Не соответствует размеру");
        }else {
            System.out.println(res);
        }

        int sumOfArr = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sumOfArr += Integer.parseInt(array[i][j]);
            }
        }
        System.out.println(sumOfArr);

    }
}
