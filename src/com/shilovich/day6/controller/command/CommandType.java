package com.shilovich.day6.controller.command;

import com.shilovich.day6.controller.command.impl.AddBookCommand;
import com.shilovich.day6.controller.command.impl.FindByTagCommand;
import com.shilovich.day6.controller.command.impl.RemoveBookCommand;
import com.shilovich.day6.controller.command.impl.SortingByTagCommand;

import java.util.Map;

public enum CommandType {
    FIND_BY_TAG {
        {
            this.command = new FindByTagCommand();
        }
    },
    SORT_BY_TAG {
        {
            this.command = new SortingByTagCommand();
        }
    },
    ADD_BOOK {
        {
            this.command = new AddBookCommand();
        }
    },
    REMOVE_BOOK {
        {
            this.command = new RemoveBookCommand();
        }
    };

    ActionCommand command;

    public ActionCommand getCommand() {
        return command;
    }
}
