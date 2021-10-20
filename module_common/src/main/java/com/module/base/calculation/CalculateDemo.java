package com.module.base.calculation;

import android.os.Build;
import android.os.Debug;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import androidx.annotation.RequiresApi;

/**
 * On 2020/12/11
 */
public class CalculateDemo
{
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void basicNotes() {
        Debug.getRuntimeStat("art.gc.gc-count");

    }

    public boolean findNumIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        // 从右上角开始，初始化该值，向左向下逐次遍历
        int i = 0, j = columns - 1;
        while (i < rows && j >= 0) {
            int value = matrix[i][j];
            if (value == target) {
                return true;
            } else if (value > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    private static int findRepeatNum(int[] numbers) {
        Set<Integer> numSet = new HashSet<>();
        int repeat = -1;
        for (int num : numbers) {
            if (!numSet.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 2, 3, 7};
        int repeatNum = findRepeatNum(numbers);
        if (repeatNum != -1) {
            System.out.print("repeat num is: " + repeatNum);
        }

        List<Integer> myAccounts = new ArrayList<>();
        calculateAllMoney(myAccounts);
    }

    public static double calculateAllMoney(List<? extends Number> accounts) {
        double s = 0.0;
        for (Number a : accounts) {
            s += a.doubleValue();
        }
        return s;
    }

    class Parser<T extends Exception> {
        public void parse(File file) throws T {

        }
    }
}
