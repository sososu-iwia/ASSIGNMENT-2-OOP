package ui;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<MenuOption> options = new ArrayList();

    public void addOption(int code, String description, Runnable action) {
        if (this.options.stream().anyMatch((o) -> o.getCode() == code)) {
            throw new IllegalArgumentException("Menu code already exists: " + code);
        } else {
            this.options.add(new MenuOption(code, description, action));
        }
    }

    public void display() {
        this.options.forEach((o) -> System.out.printf("%d. %s%n", o.getCode(), o.getDescription()));
    }

    public boolean executeOption(int code) {
        for(MenuOption option : this.options) {
            if (option.getCode() == code) {
                option.execute();
                return true;
            }
        }

        return false;
    }
}
