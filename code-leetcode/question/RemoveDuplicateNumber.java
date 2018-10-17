import java.util.BitSet;

/**
 * 给定一个数组，如何搜索重复元素
 */
public class RemoveDuplicateNumber{
    public static void main(String[] args) {
        bitSetDuplicateNumber(new int[]{1, 1, 2, 2, 3, 4, 5});
    }

    private static void bitSetDuplicateNumber(int[] numbers){
        // 规约为64的整数倍
        BitSet bitSet = new BitSet(numbers.length);

        for (int number : numbers) {
            boolean duplicate = bitSet.get(number-1);
            if(!duplicate){
                bitSet.set(number-1);
            }else{
                System.out.println(number);
            }
        }
    }
}
