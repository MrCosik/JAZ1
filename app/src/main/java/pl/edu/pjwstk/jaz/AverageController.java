package pl.edu.pjwstk.jaz;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class AverageController {
    @GetMapping("average")
    public AverageResult getAverage(@RequestParam(value = "numbers", required = false) String numbers) {

        if (numbers == null) {
            return new AverageResult("Please put parameters.");
        }

        String[] splittedNumbers = numbers.split(",");

        float sum = 0;

        for(String i : splittedNumbers){
            sum += Integer.parseInt(i);
        }

        return new AverageResult("Average equals: " + sum/splittedNumbers.length);
    }
}
