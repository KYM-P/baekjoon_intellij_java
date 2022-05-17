package algorithm_record;

public class BitMask {
    public static void main(String[] args) {
        int Bitm = 0; // 0000 = 0
        int N = 3;
        Bitm = 1 << N; // 1000 = 8
        System.out.println(Bitm);
        if ((Bitm & (1 << 2)) == 0 ){ // 1000 and 0100 => 0000 = 0
            System.out.println(Bitm);
        }
        /* 비트 연산
         * | or 둘중 하나라도 1이면 1
         * & and 둘다 1이면 1
         * ^ xor 서로 다르면 1
         * ~ 반전
         * <<, >> 비트 연산자
         */
    }
}
