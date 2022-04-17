public class HomeWorkApp {

    public static void main(String[] args) {
        String[][] arr =
                {{"1", "1", "1", "1"},
                {"2", "2", "2", "2"},
                {"3", "3", "3", "3"},
                {"4", "4", "4"}};

        try {
            int sum = arrChange(arr);
            System.out.println(sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int arrChange(String[][] array) {

        checkArraySize(array);

        int sumOfArr = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {

                try {
                    sumOfArr += Integer.parseInt(array[i][j]);
                }catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sumOfArr;

    }

    private static void checkArraySize(String[][] array) {
        int res = 0;

        for (String[] strings : array) {
            res += strings.length;
        }

        if(res != 16) {
            throw new MyArraySizeException();
        }
    }
}
