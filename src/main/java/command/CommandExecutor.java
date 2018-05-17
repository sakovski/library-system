package command;

public interface CommandExecutor<T extends Command> {

    void execute(T command);
}
