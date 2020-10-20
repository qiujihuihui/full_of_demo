package com.module.base.widget.dimple;

/**
 * 粒子类
 * On 2020/10/20
 * @author shenh
 */
public class Particle
{
    // X坐标
    private float x;
    // Y坐标
    private float y;
    // 半径
    private float radius;
    // 速度
    private float speed;
    // 透明度
    private int alpha;
    // 最大移动距离
    private float maxOffset = 300f;
    // 当前移动距离
    private int offset;
    // 粒子角度
    private double angle;

    public Particle(float x, float y, float radius, float speed, int alpha, double angle, int offset, float maxOffset) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.speed = speed;
        this.alpha = alpha;
        this.angle = angle;
        this.offset = offset;
        this.maxOffset = maxOffset;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }

    public float getMaxOffset() {
        return maxOffset;
    }

    public void setMaxOffset(float maxOffset) {
        this.maxOffset = maxOffset;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }
}
