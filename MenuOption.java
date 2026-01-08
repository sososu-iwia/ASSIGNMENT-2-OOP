package ui;

public class MenuOption {
    private final int code;
    private final String description;
    private final Runnable action;

    public MenuOption(int code, String description, Runnable action) {
        this.code = code;
        this.description = description;
        this.action = action;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public void execute() {
        action.run();
    }
}