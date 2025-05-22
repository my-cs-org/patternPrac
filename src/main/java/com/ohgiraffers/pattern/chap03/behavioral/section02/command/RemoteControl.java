package com.ohgiraffers.pattern.chap03.behavioral.section02.command;

/**
 * 설명. 커맨드 패턴의 호출자(Invoker) 클래스
 *  - 명령을 저장하고 실행하는 역할
 */
public class RemoteControl {
    private Command[] onCommands;
    private Command[] offCommands;
    private Command undoCommand;

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void undoButtonWasPushed() {
        undoCommand.undo();
    }

    @Override
    public String toString() {
        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append("\n------ 리모컨 ------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuff.append("[슬롯 " + i + "] " + onCommands[i].getClass().getSimpleName()
                    + "    " + offCommands[i].getClass().getSimpleName() + "\n");
        }
        stringBuff.append("[undo] " + undoCommand.getClass().getSimpleName());
        return stringBuff.toString();
    }
}
