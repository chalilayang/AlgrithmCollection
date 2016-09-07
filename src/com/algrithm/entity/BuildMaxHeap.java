package com.algrithm.entity;

public class BuildMaxHeap {
    private static int[] input = new int[] {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
    private static int heapSize = input.length;

    public static void main(String[] args) {
        buildMaxHeap(); // ��ӡ���� printArray();
    }

    /**
     * * ����max-heap * ���Ӷȣ����㷨���ۡ�ԭ�ķ������£� Each call to MAX-HEAPIFY costs O(lg n)
     * time, and there are O(n) such calls. Thus,the running time is O(n lg n).
     */
    private static void buildMaxHeap() {
        // ������������򣬹���max-heap,����ÿ�ξ�������
        // MaxHeapify�㷨��ǰ�ᣬ�������Ӷ������Ѿ���max-heap
        for (int i = heapSize / 2; i > 0; i--) {
            maxHeapify(input, i);
        }
    }

    /**
     * MaxHeap�������㷨��ǰ���Ǽ������е��Ӷ������Ѿ���max-heap��
     * ���Ӷȣ� ��Ϊ��T (n) �� T(2n/3) + ��(1) �����У�T (n) = O(lgn) 
     * @param array 
     * @param index
     */
    private static void maxHeapify(int[] array, int index) {
        int l = index * 2;
        int r = l + 1;
        int largest;
        // �����Ҷ�ӽڵ�����С�ڶѴ�С���Ƚϵ�ǰֵ����Ҷ�ӽڵ��ֵ��ȡֵ�������ֵ
        if (l <= heapSize && array[l - 1] > array[index - 1]) {
            largest = l;
        } else {
            largest = index;
        }
        // �����Ҷ�ӽڵ�����С�ڶѴ�С���Ƚ���Ҷ�ӽڵ��֮ǰ�Ƚϵó��Ľϴ�ֵ��ȡ�������ֵ
        if (r <= heapSize && array[r - 1] > array[largest - 1]) {
            largest = r;
        }
        // ����λ�ã��������ݹ���ø÷�������λ�á�
        if (largest != index) {
            int temp = array[index - 1];
            array[index - 1] = array[largest - 1];
            array[largest - 1] = temp;
            maxHeapify(array, largest);
        }
    }

    private static void printArray() {
        for (int i : input) {
            System.out.print(i + " ");
        }
    }
}
