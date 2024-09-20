package data_structure.array;

import org.springframework.util.StopWatch;

/**
 * cpu 读取内存（速度慢）数据后，会将其放入高速缓存（速度快）当中，
 * 如果后来的计算再用到此数据，在缓存中能读到的话，就不必读内存了
 * <p>
 * 缓存的最小存储单位是缓存行（cache line），一般是 64 bytes，
 * 一次读的数据少了不划算啊，因此最少读 64 bytes 填满一个缓存行，
 * 因此读入某个数据时也会读取其临近的数据，这就是所谓空间局部性
 */
public class TestCacheLine {

    public static void ij(int[][] a, int rows, int columns) {
        long sum = 0L;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sum += a[i][j];
            }
        }
        System.out.println(sum);
    }

    public static void ji(int[][] a, int rows, int columns) {
        long sum = 0L;
        for (int j = 0; j < columns; j++) {
            for (int i = 0; i < rows; i++) {
                sum += a[i][j];
            }
        }
        System.out.println(sum);
    }

    /*
        CPU      缓存     内存
        皮秒              纳秒
                 64字节
                 缓存行 cache line

                 空间局部性
     */

    public static void main(String[] args) {
        int rows = 1_000_000;
        int columns = 14;
        int[][] a = new int[rows][columns];

        StopWatch sw = new StopWatch();

        sw.start("ij");
        ij(a, rows, columns);
        sw.stop();

        sw.start("ji");
        ji(a, rows, columns);
        sw.stop();

        System.out.println(sw.prettyPrint());
    }
}
