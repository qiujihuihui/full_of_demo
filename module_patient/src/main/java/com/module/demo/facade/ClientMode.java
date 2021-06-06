package com.module.demo.facade;

/**
 * @author Shenhui
 * @version 1.0
 * @since 2021/6/6  10:46
 */
public class ClientMode
{
    public void wantToStartCompute() {
        FacadeComputer computer = new FacadeComputer();
        computer.startCompute();
    }

}
