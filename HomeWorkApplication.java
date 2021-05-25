import java.util.Arrays;
import java.util.Random;

public class HomeWorkApplication {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis();

        ArrayApp<Integer> arrayApp = new ArrayApp();
        for (int i = 0; i < 100000; i++) {
            arrayApp.add(1 + (int) (Math.random() * 1000));
        }

        start = System.currentTimeMillis();
        arrayApp.sortPuzirek();
        end = System.currentTimeMillis();
        System.out.println("Пузырёк: " + (end-start));

        start = System.currentTimeMillis();
        arrayApp.sortViborka();
        end = System.currentTimeMillis();
        System.out.println("Выборка: " + (end-start));

        start = System.currentTimeMillis();
        arrayApp.sortVstavka();
        end = System.currentTimeMillis();
        System.out.println("Вставка: " + (end-start));

       // arrayApp.show();
//        arrayApp.show();
//        arrayApp.add(5);
//        arrayApp.show();
//        arrayApp.del(2);
//        System.out.println("После первого удалиния");
//        arrayApp.show();
//        System.out.println("После второго удалиния");
//        arrayApp.del(6);
//        arrayApp.show();
//        System.out.println("После второго третьего");
//        arrayApp.del(688);
//        arrayApp.show();
//        arrayApp.del(3);
//        arrayApp.show();
//        System.out.println(arrayApp.find(5));
    }
}

class ArrayApp<E> {

    private Object[] mass;

    public ArrayApp(Object... mass) {
        this.mass = mass;
    }

    public void add(Object object) {
        Object[] newMass = new Object[mass.length + 1];
        for (int i = 0; i < newMass.length - 1; i++) {
            newMass[i] = mass[i];
        }
        newMass[mass.length] = object;
        this.mass = newMass;
    }

    public void show() {
        for (int i = 0; i < mass.length; i++) {
            System.out.print(mass[i] + " ");
        }
        System.out.println();
    }

    public void del(Object object) {
        Object[] o = new Object[mass.length];
        int index = 0;
        boolean flag = false;
        for (int i = 0; i < mass.length; i++) {
            if (object.equals(mass[i])) {
                mass[i] = null;
                flag = true;
            }
            if (mass[i] != null) {
                o[index] = mass[i];
                index++;
            }
        }
        mass = o;
        if (flag) {
            mass = delZero(mass);
        }
    }


    public Object[] delZero(Object[] mass) {
        int n = 0;
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] != null) {
                n++;
            }
        }
        Object[] b = new Object[n];
        int j = 0;

        for (int i = 0; i < mass.length; i++) {
            if (mass[i] != null) {
                b[j++] = mass[i];
            }
        }
        return b;
    }

    public Object find(Object find) {
        for (int i = 0; i < mass.length; i++) {
            if (find.equals(mass[i])) {
                return i;
            }
        }
        return -1;
    }

    public void sortPuzirek() {

        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass.length - 1 - i; j++) {
                if (((int) mass[j]) > ((int) mass[j + 1])) {
                    swap(j, j + 1);
                }
            }
        }
    }

    private void swap(int A, int B) {
        Object temp = mass[A];
        mass[A] = mass[B];
        mass[B] = temp;
    }

    public void sortViborka() {
        for (int i = 0; i < mass.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < mass.length; j++) {
                if ((int) mass[j] > ((int) mass[minIndex])) {
                    minIndex = j;
                }
            }
            swap(i, minIndex);
        }
    }

    public void sortVstavka() {
        int n = mass.length;
        for (int i = 0; i < n; i++) {
            int key = (int) mass[i];
            int j = i - 1;

            while ((j > -1) && ((int) mass[j] > key)) {
                mass[j + 1] = mass[j];
                j--;
            }
            mass[j + 1] = key;
        }
    }
}
