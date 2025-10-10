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

