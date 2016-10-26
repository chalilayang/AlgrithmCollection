package com.algrithm.entity;
public class BuildMaxHeap {
    private static int[] input = new int[] {-1, 2322, 4, 1, 3, 2, 16, 9, 10, 14, 8, 7, 23, 122, 432, 222, 0, 121};
    private static int heapSize = input.length;

    public static void main(String[] args) {
        
        System.out.println("\n");
        System.out.println("��ʼ״̬��");
        printArray();
        
        buildMaxHeap();
        System.out.println("\n");
        System.out.println("�󶥶ѣ�");
        printArray();
        
        heapSort(input);
        System.out.println("\n");
        System.out.println(" �����");
        printArray();
    }

    /**
     * * ����max-heap * ���Ӷȣ����㷨���ۡ�ԭ�ķ������£� Each call to MAX-HEAPIFY costs O(lg n)
     * time, and there are O(n) such calls. Thus,the running time is O(n lg n).
     */
    private static void buildMaxHeap() {
        // ������������򣬹���max-heap,����ÿ�ξ�������
        // MaxHeapify�㷨��ǰ�ᣬ�������Ӷ������Ѿ���max-heap
        for (int i = heapSize / 2; i >= 0; i--) {
            adjust(input, i, heapSize - 1);
        }
    }
    
    private static void adjust(int[] array, int start, int end) {
        int left = start * 2 + 1;
        int right = left + 1;
        int largest;
        // �����Ҷ�ӽڵ�����С�ڶѴ�С���Ƚϵ�ǰֵ����Ҷ�ӽڵ��ֵ��ȡֵ�������ֵ
        if (left <= end && array[left] > array[start]) {
            largest = left;
        } else {
            largest = start;
        }
        // �����Ҷ�ӽڵ�����С�ڶѴ�С���Ƚ���Ҷ�ӽڵ��֮ǰ�Ƚϵó��Ľϴ�ֵ��ȡ�������ֵ
        if (right <= end && array[right] > array[largest]) {
            largest = right;
        }
        // ����λ�ã��������ݹ���ø÷�������λ�á�
        if (largest != start) {
            swap(array, start, largest);
            adjust(array, largest, end);
        }
    }

    // ��һ������heap����
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
