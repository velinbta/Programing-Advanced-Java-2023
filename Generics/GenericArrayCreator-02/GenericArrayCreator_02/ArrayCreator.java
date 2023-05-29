package GenericArrayCreator_02;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator {

    public static <T> T[] create(int length, T defValue) {

        Class<?> clazz = defValue.getClass(); // <- От тук реферира за тип

        @SuppressWarnings("unchecked")
        T[] array = (T[]) Array.newInstance(clazz, length); // <- Type cast

        Arrays.fill(array, defValue);

        return array;
    }

    public static <T> T[] create(Class<T> clazz, int length, T defValue) {

        @SuppressWarnings("unchecked")
        T[] array = (T[]) Array.newInstance(clazz, length); // <- Типът, се подава при аргументите
        Arrays.fill(array, defValue);

        return array;
    }

}
