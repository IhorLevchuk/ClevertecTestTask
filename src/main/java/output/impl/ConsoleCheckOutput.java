package output.impl;

import output.CheckOutput;

public class ConsoleCheckOutput implements CheckOutput {
    @Override
    public void output(String check) {
        System.out.println(check);
    }
}
