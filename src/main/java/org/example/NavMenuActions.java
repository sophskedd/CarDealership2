package org.example;

    // like arrays, enum ordinals start from 0
    public enum NavMenuActions {
        EXIT("0. Exit"),
        ADD_CAR("1. Add a Car"),
        DISPLAY("2. Display Inventory"),
        SAVE("3. Save Inventory"),
        LOAD("4. Load Inventory"),
        HONK("5. Check Horn");

        public final String displayMessage;
        NavMenuActions(String displayMessage) {
            this.displayMessage = displayMessage;
        }
    }

