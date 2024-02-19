package homework_5.task_3;

public class HeapSort {

    public void heapSort(int[] arr, int size) {
        // Построение кучи (перегруппируем массив)
        // 0 устанавливаем диапазон перебора size = arr.length

        // 1 Начинаем с самого нижнего родителя у которого есть дети
        //   через метод buildTree(arr, size, indexParent);
        //   сравниваем его с детьми сначала с левым и если есть с правым
        //   находим максимального и меняем их местами

        // 2 если замена состоялась и мы на позиции наследника проверяем есть ли у него дети.
        //   И все по кругу пока детей не будет.

        // 3 Переходим в п.1 и проверяем предыдущего

        // 4 После того как куча сформировалась у нас самый большой элемент в массиве оказался первым
        //   меняем его с последним элементом и уменьшаем диапазон перебора size-- чтобы в дальнейшем исключить из перебора.
        //   И снова запускаем метод buildTree(arr, size, 0);
        //   при проходе по методу buildTree куча снова формируется правильно переходим в п.4

        for (int indexParent = size/2 - 1; indexParent >= 0 ; indexParent--) {
            buildTree(arr, size, indexParent);
        }

        for (size = size - 1; size >= 0; size--) {
            int temp = arr[0];
            arr[0] = arr[size];
            arr[size] = temp;
            buildTree(arr, size, 0);
        }
    }
    void buildTree(int arr[], int size, int indexParent){
        int indexMaxElement = indexParent;
        int indexLeftChild = 2 * indexParent + 1;
        int indexRightChild = 2 * indexParent + 2;

        if (indexLeftChild < size && arr[indexLeftChild] > arr[indexMaxElement]) {
            indexMaxElement = indexLeftChild;
        }
        if (indexRightChild < size && arr[indexRightChild] > arr[indexMaxElement]) {
            indexMaxElement = indexRightChild;
        }
        if(indexMaxElement != indexParent){
            int temp = arr[indexParent];
            arr[indexParent] = arr[indexMaxElement];
            arr[indexMaxElement] = temp;
            buildTree(arr, size, indexMaxElement);
        }
    }
}
