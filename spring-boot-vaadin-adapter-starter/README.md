# Spring Boot Vaadin Adapter Starter

## Usage
Add the dependency in your Spring Boot project
```
<dependency>
    <groupId>com.jbudgets</groupId>
    <artifactId>spring-boot-vaadin-adapter-starter</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

## About
This module implements the adapter pattern for Vaadin components. It provides an annotation, `@WidgetFor` for widgets, and a `WidgetAdapter` that allow us to loosely link Java objects to Vaadin components with a specified purpose.

We use the term `widget` to separate our terminology from a Vaadin Component.

```
public class User {
   ...
}

@WidgetFor(forClass = User.class, purpose = WidgetPurpose.VIEW)
public class UserViewComponent implements Widget {
   ...
}

// -----------------------------------------------------------------
// Example Usage

VerticalLayout layout = ...;
User user = ...;
Widget widget = WidgetAdapter.adapt(user, WidgetPurpose.VIEW);
// add to display
layout.add(widget.get());
```
