# Exceptor
🚨 A simple exception handler

## Simple Usage
```
@RestController
@Exceptor(status = HttpStatus.BAD_REQUEST, exception = IllegalArgumentException.class)
public class ExampleController {

    @GetMapping("/example")
    ResponseEntity<String> request() {
        ...
    }
}
```
