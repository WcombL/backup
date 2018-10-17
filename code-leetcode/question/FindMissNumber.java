import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 在一个元素为 1 到 100 的整数数组中，如何搜索缺失元素
 */
public class FindMissNumber{
    public static void main(String[] args) {
        // 遍历数组，存储元素到一个Map中
        // 遍历1-100查询缺失的元素

        mapSolution(new int[]{1, 2, 3, 4, 6}, 6);
        bitSetSolution(new int[]{1, 2, 3, 4, 6}, 6);
    }

    // 占用内存过大
    private static void mapSolution(int[] numbers, int scope){
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : numbers){
            map.put(num, num);
        }

        for(int i =1; i<= scope; i++){
            if(map.get(i) == null){
                System.out.println(i);
            }
        }
    }

    // 使用位图，其它使用是BoolFilter布尔过滤
    private static void bitSetSolution(int[] numbers, int scope){
        int missingCount  = scope - numbers.length;

        // 64 bit
        BitSet bitSet = new BitSet(missingCount);

        for (int number : numbers) {
            bitSet.set(number-1);
        }

        System.out.printf("Missing numbers in integer array %s, with total number %d is ", Arrays.toString(numbers), scope);

        int lastMissingIndex = 0;

        for (int i = 0; i < missingCount; i++) {
            // 指定索引位置前第一个false索引
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            System.out.println(++lastMissingIndex);
        }
    }

    // 通过计算和来判断缺少的数，但只能判断缺少一个的
    private static int getMissingNumber(int[] numbers, int scope) { 
        int expectedSum = scope * ((scope + 1) / 2); 
        int actualSum = 0; 
        for (int i : numbers) { 
            actualSum += i; 
        } 
        return expectedSum - actualSum; 
    }
}
