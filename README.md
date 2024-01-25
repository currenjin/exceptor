# Exceptor
🚨 A simple exception handler

## Simple Usage
```java
@RestController
@Exceptor(status = HttpStatus.BAD_REQUEST, exception = IllegalArgumentException.class)
public class ExampleController {

    @GetMapping("/example")
    ResponseEntity<String> request() {
        ...
    }
}
```

## Test
```java
@SpringBootTest
@AutoConfigureMockMvc
class ExampleAfterControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    void _400_bad_request() throws Exception {
        mvc.perform(get("/example/after"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("reason").value("test"))
                .andExpect(jsonPath("httpCode").value(400));
    }
}
```