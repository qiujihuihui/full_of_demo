package com.module.demo.facade;

/**
 * @author Shenhui
 * @version 1.0
 * @since 2021/6/6  10:31
 */
public class FacadeComputer
{
    private Memory memory;
    private Cpu cpu;
    private FlashMemory flashMemory;

    public FacadeComputer() {
        memory = new Memory();
        cpu = new Cpu();
        flashMemory = new FlashMemory();
    }

    public void startCompute() {
        memory.compute();
        cpu.compute();
        flashMemory.compute();
    }

    public String checkMemoryInfo() {
        return memory.checkInfo();
    }

    public String checkCpuInfo() {
      return cpu.checkInfo();
    }

    public String checkFlashInfo() {
        return flashMemory.checkInfo();
    }
}
