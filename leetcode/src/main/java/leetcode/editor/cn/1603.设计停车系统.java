/*
 * @Author: dingrui
 * @Date: 2021-07-10 14:17:33
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-10 14:23:15
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1603 lang=java
 *
 * [1603] 设计停车系统
 */

// @lc code=start
class ParkingSystem {

    // parking 剩余车位 [0]-big [1]-medium [2]-small
    int[] parking = new int[3];

    public ParkingSystem(int big, int medium, int small) {
        this.parking[0] = big;
        this.parking[1] = medium;
        this.parking[2] = small;
    }

    public boolean addCar(int carType) {
        int index = (carType - 1) % 3;
        int left = this.parking[index];
        if (left > 0) {
            this.parking[index]--;
            return true;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
// @lc code=end
