package homework_2.bubble_sort;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

class BubbleSort {
    // Создание логгера с нужным форматом вывода
    private static Logger logger = null;
    static {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "%1$tF %1$tR %5$s%n");
        logger = Logger.getLogger(BubbleSort.class.getName());
    }

    public void sort(int[] mas) {
        initLogger();
        bubbleSort(mas);
    }

    private void bubbleSort(int[] mas) {
        boolean flag = true;
        int temp;
        while (flag) {
            flag = false;
            for (int i = 0; i < mas.length - 1; i++) {
                if (mas[i] > mas[i + 1]) {
                    flag = true;
                    temp = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = temp;
                }
            }
            logger.info(Arrays.toString(mas));
        }
    }

    public void initLogger() {
        try {
            FileHandler fh = new FileHandler("log.txt");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.setUseParentHandlers(false);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

//import java.io.File;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.logging.FileHandler;
//import java.util.logging.Logger;
//import java.util.logging.SimpleFormatter;
//
//class BubbleSort {
//    // Создание логгера с нужным форматом вывода
//    private static Logger LOGGER;
//
//    static {
//        System.setProperty("java.util.logging.SimpleFormatter.format",
//                "%1$tF %1$tR %5$s %n");
//        LOGGER = Logger.getLogger(BubbleSort.class.getName());
//    }
//
//    private static final File log = new File("log.txt");
//    private static final FileHandler fh;
//
//    static {
//        try {
//            fh = new FileHandler(log.toString());
//            LOGGER.addHandler(fh);
//            SimpleFormatter formatter = new SimpleFormatter();
//            fh.setFormatter(formatter);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void sort(int[] mas) {
//        boolean isSorted = false;
//        int buffer;
//
//        while (!isSorted) {
//            isSorted = true;
//            for (int i = 0; i < mas.length - 1; i++) {
//                if (mas[i] > mas[i + 1]) {
//                    isSorted = false;
//
//                    buffer = mas[i];
//                    mas[i] = mas[i + 1];
//                    mas[i + 1] = buffer;
//                }
//            }
//            LOGGER.info(Arrays.toString(mas));
//        }
//    }
//}
//
////        public static final Logger LOGGER = Logger.getLogger(BubbleSort.class.getName());
//
////    private static final File log = new File("log.txt");
//    private static FileWriter fileWriter;
//    private static final Logger LOGGER;
//
//    static {
//        System.setProperty("java.util.logging.SimpleFormatter.format",
//                "%1$tF %1$tR %5$s %n");
//        LOGGER = Logger.getLogger(BubbleSort.class.getName());
//    }
//
////    private static final FileHandler fh;
////
////    static {
////        try {
////            fh = new FileHandler(log.toString());
////            LOGGER.addHandler(fh);
////            SimpleFormatter formatter = new SimpleFormatter();
////            fh.setFormatter(formatter);
////        } catch (IOException e) {
////            throw new RuntimeException(e);
////        }
////    }
//
//    public static void fh() {
//        try {
//            FileHandler fileHandler = new FileHandler("log.txt");
//            LOGGER.addHandler(fileHandler);
//            SimpleFormatter formatter = new SimpleFormatter();
//            fileHandler.setFormatter(formatter);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public static void sort(int[] arr) {
////        SimpleFormatter formatter = new SimpleFormatter();
////        fh.setFormatter(formatter);
////        LOGGER.addHandler(fh);
//
//        int j, temp;
//        boolean flag = true;
//        while(flag){
//            flag = false;
//            for (j=0; j < arr.length - 1; j++){
//                if (arr[j] > arr[j+1]){
//                    temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                    flag = true;
//                }
//            }
//            LOGGER.info(Arrays.toString(arr));
//        }
//    }

//    public void sort2(int[] arr){
//        SimpleFormatter formatter = new SimpleFormatter();
//        fh.setFormatter(formatter);
//        LOGGER.addHandler(fh);
//
//        boolean isChange;
//        int limit = arr.length;
//        do {
//            limit--;
//            isChange = false;
//            for (int i = 0; i < limit; i++) {
//                if (arr[i] > arr[i + 1]) {
//                    int temp = arr[i];
//                    arr[i] = arr[i + 1];
//                    arr[i + 1] = temp;
//
//                    isChange = true;
//                }
//            }
//            if (isChange) {
//                LOGGER.info(Arrays.toString(arr));
//            }
//        } while (isChange);
//    }
//}
