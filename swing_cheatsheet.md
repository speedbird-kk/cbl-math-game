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

## Layout

CSS flex
```CSS
.flex-row {
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    gap: 10px;
}
```

corresponds to `BoxLayout.X_AXIS` for direction row or `BoxLayout.Y_AXIS` for direction column. padding on the panel is set with an `EmptyBorder`.
```Java
JPanel flexRow = new JPanel();
flexRow.setLayout(new BoxLayout(flexRow, BoxLayout.X_AXIS));
flexRow.setBorder(new EmptyBorder(0, 10, 0, 10));
```

We can also think of `EmptyBorder` as such:
```CSS
.component {
    margin-bottom: 10px;
    margin-left: 10px;
}
```

For a panel, the dimension can be set the same as a container width / height
```CSS
.box {
    width: 50px;
    height: 50px;
}
```

if the box is in the `flexRow` panel, we can use `createRigidArea` to set the gap.
```Java
JPanel box = new JPanel();
box.setPreferredSize(new Dimension(50, 50));
flexRow.add(box);
flexRow.add(Box.createRigidArea(new Dimension(10, 0)));
```

Grid layout works similarly, for 3 columns that are equally spaced:
```CSS
.grid {
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    gap: 8px;
}
```

Using a `GridLayout` taking parameters `rows, columns, horizontal gap, vertical gap`. We can set rows or columns to `0` if we want to dynamically create as many rows / columns as are needed. Otherwise, we can set exactly the size of the grid.
```Java
JPanel grid = new JPanel(new GridLayout(0, 3, 8, 8));
```

We use `FlowLayout` for inline-block elements.
```CSS
.panel {
    display: inline-block;
    text-align: center;
}
.panel > * {
    margin: 5px;
}
```

In the case of center aligned as above and a margin of 5px for all childs of the container panel:
```Java
Jpanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
```

## Positioning

If we have a relative positioned parent (position other than default static, and relative to normal document flow), the absolute positioned child is positioned relative to this (or on document body).
```CSS
.parent {
    position: relative;
    width: 400px;
    height: 300px;
}
.child {
    position: absolute;
    top: 50px;
    left: 100px;
    width: 40px;
    height: 40px;
}
```

This can be done using `setBounds()` which takes parameters `x (left), y (top), width, height`, as so:
```Java
JPanel parent = new JPanel(null); // passing null disables layout manager
parent.setPreferredSize(new Dimension(400, 300));
JPanel child = new JPanel();
child.setBounds(100, 50, 40, 40);
parent.add(child);
```

To move an object, we translate.
```CSS
.component {
    transform: translate(40px, 20px);
}
```

There is a `translate()` method for this.
```Java
component.translate(40, 20);
```

## Borders

In the `BorderFactory` object, the method `createCompouindBorder(Border outsideBorder, Border insideBorder)` creates a compound border which specifies the border objects to use for the outside and inside edges of the component. This is parallel to padding and margin.
```CSS
.panel {
    margin: 20px;
    padding: 10px;
    border: 1px solid gray;
}
```

Hence in swing, using `createCompoundBorder` and `createLineBorder`, as follows:
```Java
JPanel panel = new JPanel();
panel.setBorder(BorderFactory.createCompoundBOrder(
    BorderFactory.createEmptyBorder(20, 20, 20, 20), // margin (outside border)
    Border.createCompoundBorder(
        BorderFactory.createLineBorder(Color.GRAY, 1), // line border us outside border of inside border
        BorderFactory.createEmptyBorder(10, 10, 10, 10) // padding (inside border of inside border)
    )
));
```

## Alignment

Horizontal alignment (justify-content) and vertical alignment (align-items) are implemented as follows in flex display.
```CSS
.panel {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 200px;
}
```

As before, we use `BoxLayout` for flex, and `setAlignmentX`, `setAlignmentY`.
```Java
JPanel panel = new JPanel();
panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
panel.setAlginmentX(panel.CENTER_ALIGNMENT);
panel.setAlignmentY(panel.CENTER_ALIGNMENT);
```

