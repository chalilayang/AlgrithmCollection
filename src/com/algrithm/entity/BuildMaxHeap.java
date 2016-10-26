package com.algrithm.entity;
public class BuildMaxHeap {
    private static int[] input = new int[] {-1, 2322, 4, 1, 3, 2, 16, 9, 10, 14, 8, 7, 23, 122, 432, 222, 0, 121};
    private static int heapSize = input.length;

    public static void main(String[] args) {
        
        System.out.println("\n");
        System.out.println("初始状态：");
        printArray();
        
        buildMaxHeap();
        System.out.println("\n");
        System.out.println("大顶堆：");
        printArray();
        
        heapSort(input);
        System.out.println("\n");
        System.out.println(" 排序后：");
        printArray();
    }

    /**
     * * 构造max-heap * 复杂度：《算法导论》原文分析如下： Each call to MAX-HEAPIFY costs O(lg n)
     * time, and there are O(n) such calls. Thus,the running time is O(n lg n).
     */
    private static void buildMaxHeap() {
        // 从树的深层逆序，构造max-heap,正好每次均可满足
        // MaxHeapify算法的前提，即所有子二叉树已经是max-heap
        for (int i = heapSize / 2; i >= 0; i--) {
            maxHeapify(input, i);
        }
    }

    /**
     * MaxHeap，调整算法，前提是假设所有的子二叉树已经是max-heap。
     * 复杂度： 因为：T (n) ≤ T(2n/3) + Θ(1) 所以有：T (n) = O(lgn) 
     * @param array 
     * @param index
     */
    private static void maxHeapify(int[] array, int index) {
        int l = index * 2 + 1;
        int r = l + 1;
        int largest;
        // 如果左叶子节点索引小于堆大小，比较当前值和左叶子节点的值，取值大的索引值
        if (l < heapSize && array[l] > array[index]) {
            largest = l;
        } else {
            largest = index;
        }
        // 如果右叶子节点索引小于堆大小，比较右叶子节点和之前比较得出的较大值，取大的索引值
        if (r < heapSize && array[r] > array[largest]) {
            largest = r;
        }
        // 交换位置，并继续递归调用该方法调整位置。
        if (largest != index) {
            swap(array, index, largest);
            maxHeapify(array, largest);
        }
    }
    
    private static void adjust(int[] array, int start, int end) {
        int left = start * 2 + 1;
        int right = left + 1;
        int largest;
        // 如果左叶子节点索引小于堆大小，比较当前值和左叶子节点的值，取值大的索引值
        if (left <= end && array[left] > array[start]) {
            largest = left;
        } else {
            largest = start;
        }
        // 如果右叶子节点索引小于堆大小，比较右叶子节点和之前比较得出的较大值，取大的索引值
        if (right <= end && array[right] > array[largest]) {
            largest = right;
        }
        // 交换位置，并继续递归调用该方法调整位置。
        if (largest != start) {
            swap(array, start, largest);
            adjust(array, largest, end);
        }
    }

 // 对一个最大堆heap排序
    public static void heapSort(int[] heap) {
        for (int i = heap.length - 1; i > 0; i--) {
            swap(heap, 0, i);
            adjust(heap, 0, i - 1);
        }
    }
    
    public static void swap(int[] array, int indexA, int indexB) {
        if (array == null) {
            return;
        }
        int size = array.length;
        if (indexA < 0 || indexA >= size) {
            return;
        }
        if (indexB < 0 || indexB >= size) {
            return;
        }
        int tmp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = tmp;
    }
    
    private static void printArray() {
        for (int i : input) {
            System.out.print(i + " ");
        }
    }
}
