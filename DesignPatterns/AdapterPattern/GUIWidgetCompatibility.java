public class GUIWidgetCompatibility {
    public static void main(String[] args) {
        // button button = new button();
        // resistiveTouchscreen screen = new resistiveTouchscreen();

        FloatingButton button2 = new FloatingButton();
        InfraredTouchscreen screen2 = new InfraredTouchscreen();

        CurrentFramework adapter1 = new NewFrameworkAdapter(button2);
        System.out.println(adapter1.widgetName());
        adapter1.onClick();

        CurrentFramework adapter2 = new NewFrameworkAdapter(screen2);
        System.out.println(adapter2.widgetName());
        adapter2.onClick();
    }
}

interface CurrentFramework {
    String widgetName();
    void onClick();
}

class Button implements CurrentFramework {
    public String widgetName() {
        return "Button ";
    }

    public void onClick() {
        System.out.println(widgetName() + "has been pressed");
    }
}

class ResistiveTouchscreen implements CurrentFramework {
    public String widgetName() {
        return "Resistive Touch Screen ";
    }

    public void onClick() {
        System.out.println(widgetName() + "has been clicked");
    }
}

interface NewFramework {
    String newWidgetName();
    void onTouch();
}

class FloatingButton implements NewFramework {
    public String newWidgetName() {
        return "Floating Button ";
    }

    public void onTouch() {
        System.out.println(newWidgetName() + "has been touched");
    }
}

class InfraredTouchscreen implements NewFramework {
    public String newWidgetName() {
        return "InfraRed Touch Screen ";
    }

    public void onTouch() {
        System.out.println(newWidgetName() + "has been touched");
    }
}

class NewFrameworkAdapter implements CurrentFramework {
    NewFramework adapted;

    public NewFrameworkAdapter(NewFramework xyz) {
        this.adapted = xyz;
    }

    public String widgetName() {
        return adapted.newWidgetName();
    }

    public void onClick() {
        adapted.onTouch();
    }
}
