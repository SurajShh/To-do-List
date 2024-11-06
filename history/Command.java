package history;

public interface Command {
    void execute();
    void undo();
}
