package com.macro.emc.common.utils;

/**
 * 工具类
 */
public class MathUtil {

    /**
     * 返回一个随机的int类型的值
     * @return
     */
    public static int randomInt() {
        return org.apache.commons.lang3.RandomUtils.nextInt();
    }

    /**
     * 根据大于等于startInclusive 小于endExclusive，返回int类型随机值
     * @param startInclusive
     * @param endExclusive
     * @return 返回int类型随机值
     */
    public static int randomInt(int startInclusive, int endExclusive) {
        return org.apache.commons.lang3.RandomUtils.nextInt(startInclusive, endExclusive);
    }

    /**
     * 根据大于等于start 小于等于end，返回int类型随机值
     * @param startInclusive
     * @param end
     * @return 返回int类型随机值
     */
    public static int randomIntEq(int startInclusive, int end) {
        return org.apache.commons.lang3.RandomUtils.nextInt(startInclusive, (end+1));
    }

    /**
     * 返回一个随机的double类型的值
     * @return
     */
    public static double randomDouble() {
        return org.apache.commons.lang3.RandomUtils.nextDouble();
    }

    /**
     * 根据大于等于startInclusive 小于endExclusive，返回double类型的随机值
     * 例如：MathUtil.randomDouble(0.0001, 3.0)
     * 返回：
     *      1.2644359156711416
     *      1.6984879869015073
     *      0.42196876903355895
     *      1.101019302679642
     *      2.849278251146894
     * @param startInclusive
     * @param endExclusive
     * @return 返回double类型的随机值
     */
    public static double randomDouble(double startInclusive, double endExclusive) {
        return org.apache.commons.lang3.RandomUtils.nextDouble(startInclusive, endExclusive);
    }

    /**
     * 返回boolean类型的随机值
     * @return 返回boolean类型的随机值
     */
    public static boolean randomBoolean() {
        return org.apache.commons.lang3.RandomUtils.nextBoolean();
    }

    /**
     * 返回随机长度的byte数组
     * @param count
     * @return 返回随机长度的byte数组
     */
    public static byte[] randomBytes(final int count) {
        return org.apache.commons.lang3.RandomUtils.nextBytes(count);
    }

    /**
     * 返回一个随机的long类型的值
     * @return
     */
    public static long randomLong() {
        return org.apache.commons.lang3.RandomUtils.nextLong();
    }

    /**
     * 根据大于等于startInclusive 小于endExclusive，返回long类型随机值
     * @param startInclusive
     * @param endExclusive
     * @return 返回long类型随机值
     */
    public static long randomLong(final long startInclusive, final long endExclusive) {
        return org.apache.commons.lang3.RandomUtils.nextLong(startInclusive, endExclusive);
    }

    /**
     * 根据大于等于start 小于等于end，返回long类型随机值
     * @param startInclusive
     * @param end
     * @return 返回long类型随机值
     */
    public static long randomLongEq(int startInclusive, int end) {
        return org.apache.commons.lang3.RandomUtils.nextLong(startInclusive, (end+1));
    }

    /**
     * 返回一个随机的float类型的值
     * 例如：MathUtil.randomFloat()
     * 返回：
     *      1.8009603E38
     *      1.3743114E38
     *      1.32583E38
     *      1.5554841E38
     * @return
     */
    public static float randomFloat() {
        return org.apache.commons.lang3.RandomUtils.nextFloat();
    }

    /**
     * 根据大于等于startInclusive 小于endExclusive，返回float类型的随机值
     * @param startInclusive
     * @param endExclusive
     * @return 返回float类型的随机值
     */
    public static float randomDouble(float startInclusive, float endExclusive) {
        return org.apache.commons.lang3.RandomUtils.nextFloat(startInclusive, endExclusive);
    }


}
