package de.zlucic;

import de.zlucic.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    @RequestMapping(value="sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value="numberOne") String numberOne, @PathVariable( value="numberTwo") String numberTwo)
        throws UnsupportedMathOperationException
    {
        if( isNumeric( numberOne) && isNumeric( numberTwo)) {
            double numOne = Double.parseDouble(numberOne);
            double numTwo = Double.parseDouble(numberTwo);
            return numOne + numTwo;
        } else {
            throw new UnsupportedMathOperationException( "Parameter is not numeric");
        }
    }

    private boolean isNumeric( String string) {
        if( string == null) {
            return false;
        } else {
            string = string.replaceAll( ",", ".");
            try {
                Double.valueOf(string);
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
        }
    }
}
