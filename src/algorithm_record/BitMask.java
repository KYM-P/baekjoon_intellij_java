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
        /* ��Ʈ ����
         * | or ���� �ϳ��� 1�̸� 1
         * & and �Ѵ� 1�̸� 1
         * ^ xor ���� �ٸ��� 1
         * ~ ����
         * <<, >> ��Ʈ ������
         */
    }
}
