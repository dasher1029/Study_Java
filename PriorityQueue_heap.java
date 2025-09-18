/*
사용 인터페이스: Comparable<E>
구현 대상
add(E e): 요소 추가
poll(): 루트 노드 요소 반환하고 제거 
remove(Object o): 특정 요소 제거
isEmpty(): 비어있는지 여부 확인 
clear(): 큐 초기화
resize()로직 추가해보기 
*/
import java.lang.reflect.Array;

public class PriorityQueue_heap<E extends Comparable<E>>{

    public boolean isLess(E a, E b){//a가 더 작으면 true 반환 /////완 
        return a.compareTo(b) < 0;
    }
    private int size = 0;
    private E[] arr;
    public PriorityQueue_heap(E[] newArr){
        arr = newArr;
        int temp = 0;
        for (int i = 0; i < arr.length; i++){//입력된 배열 원소 수 측정 
            if (arr[i] != null){
                temp++;
            }
        }
        size = temp;
        heapify();
    }

    public void heapify(){// 힙 생성 메서드 
        if (size % 2 == 0){//downheap대상 첫 번째 부모의 자식이 2개인지 한개인지 처리 
            for (int i = (size-2)/2; i >= 0; i--){
                downHeap(i);
            }
        }
        else{
            if (isLess(arr[size-1], arr[(size - 2) / 2])){
                swap(size-1, (size-2)/2);
            }
            for (int i = (size-2)/2 -1; i >= 0; i--){
                downHeap(i);
            }
        }
    }

    public void downHeap(int i){ //arr: 대상 배열, i: downheap 대상 인덱스, size: arr.length가 아님! arr에 저장된 원소들의 개수임 
        if(2*i + 1 > size - 1){
            return;
        }
        else if (2*i + 1 >= size -1){//유효범위 넘어가면 넘어감 
            E minChild = arr[2*i + 1];
            int minChildIndex = 2*i + 1;
            E parent = arr[i];
            int parentIndex = i;
            if (isLess(minChild, parent)){
            swap(minChildIndex, parentIndex);
            downHeap(minChildIndex);
            }
        }
        else if(2*i  + 2 < size -1){
            E left = arr[2*i + 1];
            E right = arr[2*i + 2];
            E minChild; 
            int minChildIndex = 0;
            E parent = arr[i];
            int parentIndex = i;
            
            if (isLess(left, right)){//left가 right보다 작으면 
                minChild = left;
                minChildIndex = 2*i + 1;
            }
            else{
                minChild = right;
                minChildIndex = 2*i + 2;
            }

            if (isLess(minChild, parent)){
                swap(minChildIndex, parentIndex);
                downHeap(minChildIndex);
            }
        }
    }

    public void upheap(int i){
        if (i < 2){//유효범위 넘어가면 넘어감 - 구현하기
            return;
        }
        if (i % 2 == 0){//두 번째 자식 
            if (isLess(arr[i], arr[(i-2) / 2])){
                swap(i, (i-2) / 2);
            }
        }
        else{//첫 번째 자식 
            if (isLess(arr[i], arr[(i-1) / 2])){
                swap(i, (i-1) / 2);
            }
        }
    }

    public void swap(int i, int j){
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public E peek(){
        return arr[0];
    }

    public E poll(){//루트노드 삭제 및 반환 
        E root = arr[0];
        E temp = arr[size];
        arr[size] = arr[0];
        arr[0] = temp;
        downHeap(0);
        size--;
        resize();
        return root;
    }

    public void printArrayValue(){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public void resize(){
        if (size * 4 > arr.length * 3){
            @SuppressWarnings("unchecked")
            E[] newArr = (E[]) Array.newInstance(
                arr.getClass().getComponentType(), 2 * arr.length
            );
            for (int i = 0; i < size; i++){
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        else if(size * 4 < arr.length){
            if (arr.length / 2 == 0){
                return;
            }
            @SuppressWarnings("unchecked")
            E[] newArr = (E[]) Array.newInstance(
                arr.getClass().getComponentType(), arr.length / 2
            );
            for (int i = 0; i < size; i++){
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
    }

    public E add(E value){
        resize();
        arr[size] = value;
        upheap(size);
        size++;
        return value;
    }
}
// 아래 로직 다시 보고 downheap 다시 작성하기

/*
int left  = 2*i + 1;
int right = 2*i + 2;

int smallest = i;
if (left  < size && isLess(arr[left],  arr[smallest]))  smallest = left;
if (right < size && isLess(arr[right], arr[smallest]))  smallest = right;

if (smallest != i) {
    swap(i, smallest);
    downHeap(smallest);
}
 */