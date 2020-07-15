package com.shilovich.day6.controller.command.type;

import com.shilovich.day6.controller.command.ActionCommand;
import com.shilovich.day6.controller.command.impl.AddBookCommand;
import com.shilovich.day6.controller.command.impl.FindByTagCommand;
import com.shilovich.day6.controller.command.impl.RemoveBookCommand;
import com.shilovich.day6.controller.command.impl.SortingByTagCommand;

public enum CommandType {
    FIND_BY_TAG(new FindByTagCommand()),
    SORT_BY_TAG(new SortingByTagCommand()),
    ADD_BOOK(new AddBookCommand()),
    REMOVE_BOOK(new RemoveBookCommand());

    private CommandType(ActionCommand command) {
        this.command = command;
    }

    private ActionCommand command;

    public ActionCommand getCommand() {
        return command;
    }
}
