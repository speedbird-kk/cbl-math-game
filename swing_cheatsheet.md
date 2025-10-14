# Cheat sheet for Java swing and awt for web developers

## Creating components and adding to parent components
JavaScript
```JavaScript
const div = document.createElement("div");
const btn = document.createElement("button");
btn.textContent = "Click Me";
div.appendChild(btn);
document.body.appendChild(div);
```

Swing
```Java
JPanel div = new JPanel();
JButton btn = new JButton("Click Me");
div.add(btn);
frame.add(div);
```

## Event listeners
JavaScript
```JavaScript
btn.addEventListener("click", () => {
    console.log("Clicked !");
});
```

Swing
```Java
btn.addActionListener(e -> {
    System.out.println("Clicked !");
});
```

## Structure

**Document root**
HTML
```html
<head>
    <title>Title</title>
</head>
<body></body>
```

Swing
```Java
Jframe frame = new Jframe();
frame.setTitle("Title");
```

**Containers, elements**

Make container
```JavaScript
const div = document.createElement("div");
```
```Java
JPanel panel = new JPanel();
```

Make input box
```JavaScript
const input = document.createElement("input");
input.type = "text";
```
```Java
JTextField textField = new JTextField();
```

Add input to container
```JavaScript
div.appendChild(input);
```
```Java
panel.add(textField);
```

Focus on the input
```JavaScript
input.focus();
```
```Java
textField.requestFocusInWindow();
```

Disable input
```JavaScript
input.disabled = true;
```
```Java
textField.setEditable(false);
```

Injecting inner HTML
```JavaScript
div.innerHTML = `
    <h1><u>Demonstration</u></h1>
    <ul>
        ...
    </ul>
    <table border="1">
        ...
    </table>
`;
```
```Java
JLabel label = new JLabel("""
    <html>
    <h1><u>Demonstration</u></h1>
    <ul>
        <li>Hello world !</li>
        <li>Hallo wereld ! </li>
    </ul>
    <table border="1">
        <thead>
            <tr><th>English</th><th>Dutch</th></tr>
        </thead>
        <tbody>
            <tr><th>Nice !</th><th>Leuk !</th></tr>
        </tbody>
    </table>
    </html>""".stripLeading());
```

## Replicating CSS classes as methods in a styling class

Defining style classes in CSS
```css
.title {
    background-color: cyan;
    font-family: 'Verdana';
    font-weight: bold;
    font-size: 20;
}

.button {
    border: 1px solid black;
    background-color: orange;
    font-family: 'Verdana';
    font-style: italic;
    font-size: 25;
    display: block;
}
```

Similar implementation using enum:
```Java
public enum ClassList {
    TITLE {
        @Override
        public void add(JComponent c) {
            c.setBackground(Color.CYAN);
            c.setFont(new Font("Verdana", Font.BOLD, 20));
        }
    },

    BUTTON {
        @Override
        public void add(JComponent c) {
            c.setBorder(BorderFactory.createEtchedBorder());
            c.setBackground(Color.ORANGE);
            c.setFont(new Font("Verdana", Font.ITALIC, 25));
            c.setVisible(true);
        }
    };

    public abstract void add(JComponent c);
}
```

Applying style classes to elements
```JavaScript
btn.classList.add('button');
```
```Java
ClassList.BUTTON.add(btn);
```

## Replicating CSS variables using enum

Defining colour variables in CSS
```CSS
:root {
    --main-bg-colour: rgb(240, 220, 220);
    --main-btn-colour: rgb(230, 20, 88);
}
```

Similar implementation using enum
```Java
public enum StyleVariable {
    MAIN_BG_COLOUR(new Color(240, 220, 220)),
    MAIN_BTN_COLOUR(new Color(230, 20, 88));
    
    private final Color rgbColour;

    private StyleVariable(Color rgbColour) {
        this.rgbColour = rgbColour;
    }

    public Color get() {
        return rgbColour;
    }
}
```

Style variables can also be fonts (or possibly borders in the future).
```Java
public enum StyleVariable {
    MAIN_BG_COLOUR(new Color(240, 220, 220)),
    MAIN_BTN_COLOUR(new Color(230, 20, 88)),

    MAIN_FONT(new Font("Futura", Font.ITALIC, 30));
    
    private Color rgbColour;
    private Font font;

    private StyleVariable(Color rgbColour) {
        this.rgbColour = rgbColour;
    }

    private StyleVariable(Font font) {
        this.font = font;
    }

    public Color colour() {
        return rgbColour;
    }

    public Font font() {
        return font;
    }
}
```

Using defined variables for colours
```CSS
background-color: var(--main-btn-colour);
```
```Java
c.setBackground(StyleVariable.MAIN_BTN_COLOUR.get());
```

## Adding multiple CSS classes to a component

This method enables adding multiple CSS classes at once
```java
@SafeVarargs
public static final void add(JComponent c, String... classes) {
    for (String cl : classes) {
        for (ClassList l : ClassList.values()) {
            if (l.name().equals(cl)) {
                l.add(c);
            }
        }
    }
}
```

It can be called like this. Note that the latter declared parameters take precedence, in this case `BUTTON_EXTRA` overrides any same styling elements set in `BUTTON`.
```java
ClassList.add(btn, "BUTTON", "BUTTON_EXTRA");
```

Equivalent to doing on JavaScript:
```JavaScript
btn.classList.add('button', 'button-extra');
```