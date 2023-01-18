# Annotations in Spring

Annotations in Spring are a way to provide metadata to classes, methods, and variables. This metadata can be used by Spring to perform a number of tasks, such as configuring beans, injecting dependencies, and enabling specific features. Some common annotations in Spring include:

- **`@Override`**: Serves for method and constructor overrides.
- **`@Component`**: Indicates that a class is a Spring "component" and should be included in the application's component scan. We can use algo @Component("")
- **`@Autowired`**: Indicates that a variable should be injected by Spring through dependency injection.
- **`@Qualifier`**: We use this with Autowired to know which Autowired we are going to inject.
- **`@Scope`**: A bean's scope is set using the @Scope annotation. By default, the Spring framework creates exactly one instance for each bean declared in the IoC container.

Web Applications Annotations:

- **`@Controller`**: This is used to define what our controller is.
- **`@RequestMapping`**: RequestMapping annotation is used to map web requests onto specific handler classes and/or handler methods.
- **`@RequestParam`**: Is used to read the form data and bind it automatically to the parameter present in the provided method.

